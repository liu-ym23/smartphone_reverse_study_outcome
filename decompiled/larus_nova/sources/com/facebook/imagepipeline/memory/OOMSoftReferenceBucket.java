package com.facebook.imagepipeline.memory;

import com.facebook.common.references.OOMSoftReference;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes23.dex */
class OOMSoftReferenceBucket<V> extends Bucket<V> {
    private LinkedList<OOMSoftReference<V>> mSpareReferences;

    @Override // com.facebook.imagepipeline.memory.Bucket
    public V pop() {
        OOMSoftReference<V> r100 = (OOMSoftReference) this.mFreeList.poll();
        V r101 = r100.get();
        r100.clear();
        this.mSpareReferences.add(r100);
        return r101;
    }

    @Override // com.facebook.imagepipeline.memory.Bucket
    public void addToFreeList(V r100) {
        OOMSoftReference<V> r101 = this.mSpareReferences.poll();
        if (r101 != null) goto L5;
        r101 = new OOMSoftReference();
    L5:
        r101.set(r100);
        this.mFreeList.add(r101);
    }

    public OOMSoftReferenceBucket(int r100, int r101, int r102) {
        super(r100, r101, r102, false);
        this.mSpareReferences = new LinkedList();
    }
}
