package com.bytedance.android.shopping.api.mall;

import android.util.SparseArray;
import java.util.NoSuchElementException;
import kotlin.collections.IntIterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends IntIterator {
    public int a;
    public final /* synthetic */ SparseArray b;

    public final boolean hasNext() {
        if (this.a >= this.b.size()) goto L5;
        return true;
    L5:
        return false;
    }

    public final int nextInt() {
        if (hasNext() == false) goto L7;
        SparseArray r0 = this.b;
        int r1 = this.a;
        this.a = r1 + 1;
        return r0.keyAt(r1);
    L7:
        throw new NoSuchElementException();
    }

    public a(SparseArray<Object> r1) {
        this.b = r1;
    }
}
