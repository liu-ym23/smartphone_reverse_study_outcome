package com.ss.android.lark.widget.photopickernew.grid;

import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.widget.photopicker.statistics.PerfGalleryLoadMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements rkb.g<Object, Object> {
    public f() {
    }

    @Override // rkb.g
    public final boolean onLoadFailed(Exception r100, Object r101, Target<Object> r102, boolean r103) {
        PerfGalleryLoadMonitor.f447609a.getClass();
        PerfGalleryLoadMonitor.c();
        return false;
    }

    @Override // rkb.g
    public final boolean onResourceReady(Object r100, Object r101, Target<Object> r102, DataSource r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r103, "p3");
        PerfGalleryLoadMonitor.f447609a.getClass();
        PerfGalleryLoadMonitor.a r105 = PerfGalleryLoadMonitor.f447610b;
        if (r105 == null) goto L8;
        r105.end();
        PerfGalleryLoadMonitor.f447610b = null;
        return false;
    L8:
        return false;
    }
}
