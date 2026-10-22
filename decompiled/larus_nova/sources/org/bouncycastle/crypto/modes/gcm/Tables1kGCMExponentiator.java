package org.bouncycastle.crypto.modes.gcm;

import java.util.Vector;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class Tables1kGCMExponentiator implements GCMExponentiator {
    private Vector lookupPowX2;

    public Tables1kGCMExponentiator() {
    }

    private void ensureAvailable(int r100) {
        int r101 = this.lookupPowX2.size();
        if (r101 > r100) goto L7;
        long[] r102 = (long[]) this.lookupPowX2.elementAt(r101 - 1);
    L5:
        r102 = Arrays.clone(r102);
        GCMUtil.square(r102, r102);
        this.lookupPowX2.addElement(r102);
        r101 = r101 + 1;
        if (r101 <= r100) goto L5;
        return;
    }

    @Override // org.bouncycastle.crypto.modes.gcm.GCMExponentiator
    public void exponentiateX(long r100, byte[] r110) {
        long[] r101 = GCMUtil.oneAsLongs();
        int r102 = 0;
    L4:
        if (r100 <= 0) goto L9;
        if ((1 & r100) == 0) goto L8;
        ensureAvailable(r102);
        GCMUtil.multiply(r101, (long[]) this.lookupPowX2.elementAt(r102));
    L8:
        r102 = r102 + 1;
        r100 = r100 >>> 1;
        goto L4
    L9:
        GCMUtil.asBytes(r101, r110);
    }

    @Override // org.bouncycastle.crypto.modes.gcm.GCMExponentiator
    public void init(byte[] r100) {
        long[] r101 = GCMUtil.asLongs(r100);
        Vector r102 = this.lookupPowX2;
        if (r102 != null) goto L5;
    L7:
        Vector r103 = new Vector(8);
        this.lookupPowX2 = r103;
        r103.addElement(r101);
        return;
    L5:
        if (Arrays.areEqual(r101, (long[]) r102.elementAt(0)) == false) goto L7;
    }
}
