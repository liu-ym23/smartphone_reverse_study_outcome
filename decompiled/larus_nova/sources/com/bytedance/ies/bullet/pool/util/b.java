package com.bytedance.ies.bullet.pool.util;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements Iterable<View>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f247497a;

    @Override // java.lang.Iterable
    public final Iterator<View> iterator() {
        return new a(this.f247497a);
    }

    public b(ViewGroup r100) {
        this.f247497a = r100;
    }
}
