package com.larus.bmhome.chat.layout.item;

import android.view.SurfaceHolder;
import com.larus.platform.api.IVideoController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class m4 implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l4 f304512a;

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
    }

    public m4(l4 r100) {
        this.f304512a = r100;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        IVideoController r101 = this.f304512a.A;
        if (r101 == null) goto L6;
        r101.setSurfaceHolder(r100);
        return;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        IVideoController r104 = this.f304512a.A;
        if (r104 == null) goto L6;
        r104.setSurfaceHolder(r100);
        return;
    }
}
