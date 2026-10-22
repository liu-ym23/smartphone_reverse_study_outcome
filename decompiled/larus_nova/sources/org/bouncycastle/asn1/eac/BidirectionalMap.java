package org.bouncycastle.asn1.eac;

import java.util.Hashtable;

/* JADX INFO: loaded from: classes42.dex */
public class BidirectionalMap extends Hashtable {
    private static final long serialVersionUID = -7457289971962812909L;
    Hashtable reverseMap;

    public BidirectionalMap() {
        this.reverseMap = new Hashtable();
    }

    public Object getReverse(Object r100) {
        return this.reverseMap.get(r100);
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public Object put(Object r100, Object r101) {
        this.reverseMap.put(r101, r100);
        return super.put(r100, r101);
    }
}
