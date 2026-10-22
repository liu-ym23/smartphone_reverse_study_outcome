package com.ss.android.lark.widget.halfscreen;

import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.widget.photopicker.statistics.PerfGalleryLoadMonitor;

/* JADX INFO: loaded from: classes38.dex */
public final class i implements rkb.g {
    public i() {
    }

    @Override // rkb.g
    public final boolean onLoadFailed(Exception r100, Object r101, Target r102, boolean r103) {
        PerfGalleryLoadMonitor.f447609a.getClass();
        PerfGalleryLoadMonitor.c();
        return false;
    }

    @Override // rkb.g
    public final boolean onResourceReady(Object r100, Object r101, Target r102, DataSource r103, boolean r104) {
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
