package com.larus.voicecall.impl.component.vlm;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes32.dex */
public final class i2 implements Iterator<View>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f377953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f377954b;

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f377953a >= this.f377954b.getChildCount()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public final View next() {
        ViewGroup r100 = this.f377954b;
        int r101 = this.f377953a;
        this.f377953a = r101 + 1;
        return r100.getChildAt(r101);
    }

    public i2(ViewGroup r100) {
        this.f377954b = r100;
    }
}
