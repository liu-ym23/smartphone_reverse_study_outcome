package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes42.dex */
public class BDSStateMap implements Serializable {
    private static final long serialVersionUID = -3464451825208522308L;
    private final Map<Integer, BDS> bdsState;
    private transient long maxIndex;

    public BDSStateMap(long r100) {
        this.bdsState = new TreeMap();
        this.maxIndex = r100;
    }

    public BDSStateMap(BDSStateMap r100, long r101) {
        this.bdsState = new TreeMap();
        Iterator<Integer> r102 = r100.bdsState.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Integer r103 = r102.next();
        this.bdsState.put(r103, new BDS(r100.bdsState.get(r103)));
        goto L4
    L6:
        this.maxIndex = r101;
    }

    public BDSStateMap(XMSSMTParameters r110, long r111, byte[] r112, byte[] r113) {
        this.bdsState = new TreeMap();
        this.maxIndex = (1 << r110.getHeight()) - 1;
        long r100 = 0;
    L4:
        if (r100 >= r111) goto L6;
        updateState(r110, r100, r112, r113);
        r100 = r100 + 1;
        goto L4
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        if (r100.available() == 0) goto L5;
        long r101 = r100.readLong();
    L6:
        this.maxIndex = r101;
        return;
    L5:
        r101 = 0;
        goto L6
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        r100.writeLong(this.maxIndex);
    }

    public BDS get(int r100) {
        return this.bdsState.get(Integers.valueOf(r100));
    }

    public long getMaxIndex() {
        return this.maxIndex;
    }

    public boolean isEmpty() {
        return this.bdsState.isEmpty();
    }

    public void put(int r100, BDS r101) {
        this.bdsState.put(Integers.valueOf(r100), r101);
    }

    public BDS update(int r100, byte[] r101, byte[] r102, OTSHashAddress r103) {
        return this.bdsState.put(Integers.valueOf(r100), this.bdsState.get(Integers.valueOf(r100)).getNextState(r101, r102, r103));
    }

    public void updateState(XMSSMTParameters r110, long r111, byte[] r210, byte[] r211) {
        XMSSParameters r100 = r110.getXMSSParameters();
        int r101 = r100.getHeight();
        long r102 = XMSSUtil.getTreeIndex(r111, r101);
        int r103 = XMSSUtil.getLeafIndex(r111, r101);
        OTSHashAddress r112 = (OTSHashAddress) new OTSHashAddress.Builder().withTreeAddress(r102).withOTSAddress(r103).build();
        int r113 = 1;
        int r114 = (1 << r101) - 1;
        if (r103 >= r114) goto L10;
        if (get(0) == null) goto L7;
        if (r103 == 0) goto L7;
    L8:
        update(0, r210, r211, r112);
    L7:
        put(0, new BDS(r100, r210, r211, r112));
    L10:
        if (r113 >= r110.getLayers()) goto L21;
        int r104 = XMSSUtil.getLeafIndex(r102, r101);
        r102 = XMSSUtil.getTreeIndex(r102, r101);
        OTSHashAddress r115 = (OTSHashAddress) new OTSHashAddress.Builder().withLayerAddress(r113).withTreeAddress(r102).withOTSAddress(r104).build();
        if (this.bdsState.get(Integer.valueOf(r113)) != null) goto L14;
    L15:
        this.bdsState.put(Integer.valueOf(r113), new BDS(r100, r210, r211, r115));
    L16:
        if (r104 >= r114) goto L20;
        if (XMSSUtil.isNewAuthenticationPathNeeded(r111, r101, r113) == false) goto L20;
        update(r113, r210, r211, r115);
    L20:
        r113 = r113 + 1;
        goto L10
    L14:
        if (XMSSUtil.isNewBDSInitNeeded(r111, r101, r113) == false) goto L16;
    }

    public BDSStateMap withWOTSDigest(ASN1ObjectIdentifier r100) {
        BDSStateMap r101 = new BDSStateMap(this.maxIndex);
        Iterator<Integer> r102 = this.bdsState.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Integer r103 = r102.next();
        r101.bdsState.put(r103, this.bdsState.get(r103).withWOTSDigest(r100));
        goto L4
    L6:
        return r101;
    }
}
