package com.larus.common_ui.video;

import com.larus.platform.api.IVideoController;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import v19.m5;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoPlayView f328052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f328053b;

    public /* synthetic */ m(VideoPlayView r100, long r101) {
        this.f328052a = r100;
        this.f328053b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPlayView r100 = this.f328052a;
        long r101 = this.f328053b;
        int r102 = VideoPlayView.f327971y1;
        if (r100.h(r101) == false) goto L42;
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("fitVideoSize isCenterCrop:");
        b r105 = r100.f327973a;
        if (r105 == null) goto L8;
        Integer r106 = Integer.valueOf(r105.f328028c);
    L9:
        r104.append(r106);
        r103.i("VideoPlayView", r104.toString());
        IVideoController r107 = r100.C;
        if (r107 == null) goto L12;
        r107.i(4);
    L12:
        String r108 = "";
        if (m5.c(r100.f328006y) == false) goto L20;
        String r109 = r100.f328006y;
        if (r109 == null) goto L18;
        r108 = r109;
    L18:
        r100.A(r108);
        return;
    L20:
        if (o0.d(r100.f328007z) == false) goto L27;
        String r110 = r100.f328007z;
        if (r110 == null) goto L25;
        r108 = r110;
    L25:
        r100.A(r108);
        return;
    L27:
        if (o0.d(r100.A) == false) goto L33;
        String r111 = r100.A;
        if (r111 == null) goto L32;
        r108 = r111;
    L32:
        r100.B(r108);
        return;
    L33:
        String r112 = r100.f328004x;
        if (r112 == null) goto L37;
        r108 = r112;
    L37:
        r100.C(r108);
        return;
    L8:
        r106 = null;
        goto L9
    }
}
