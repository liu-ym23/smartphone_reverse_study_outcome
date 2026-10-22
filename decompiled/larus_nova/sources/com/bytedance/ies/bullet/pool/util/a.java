package com.bytedance.ies.bullet.pool.util;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements Iterator<View>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f247495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f247496b;

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f247495a >= this.f247496b.getChildCount()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public final View next() {
        ViewGroup r100 = this.f247496b;
        int r101 = this.f247495a;
        this.f247495a = r101 + 1;
        return r100.getChildAt(r101);
    }

    public a(ViewGroup r100) {
        this.f247496b = r100;
    }
}
