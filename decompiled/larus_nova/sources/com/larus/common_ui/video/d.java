package com.larus.common_ui.video;

import com.larus.platform.api.IVideoController;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoPlayView f328033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f328034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f328035c;

    public /* synthetic */ d(VideoPlayView r100, long r101, boolean r102) {
        this.f328033a = r100;
        this.f328034b = r101;
        this.f328035c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPlayView r100 = this.f328033a;
        long r101 = this.f328034b;
        boolean r102 = this.f328035c;
        int r103 = VideoPlayView.f327971y1;
        if (r100.h(r101) == false) goto L13;
        IVideoController r104 = r100.C;
        if (r104 != null) goto L8;
        return;
    L8:
        if (r104.d() != IVideoController.PlayType.PAUSE) goto L12;
        r100.f328005x1 = r102;
        r100.i(false);
        r104.play();
        return;
    L12:
        return;
    }
}
