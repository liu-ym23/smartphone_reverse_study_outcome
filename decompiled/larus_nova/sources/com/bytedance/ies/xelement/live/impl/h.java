package com.bytedance.ies.xelement.live.impl;

import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.xlive.IXLivePlayerView;
import com.bytedance.android.livesdkapi.xlive.XLivePlayerViewConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public XLivePlayerViewConfig f250144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IXLivePlayerView f250145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f250146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f250147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f250148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f250149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f250150g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f250151h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f250152i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f250153j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.ies.xelement.live.b f250154k;

    public h() {
        this.f250146c = "";
        this.f250147d = "";
        this.f250148e = "";
        this.f250150g = "";
        this.f250153j = "";
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f250147d = r100;
        XLivePlayerViewConfig r101 = this.f250144a;
        if (r101 == null) goto L7;
        r101.setBizDomain(r100);
        return;
    }

    public final void b(com.bytedance.ies.xelement.live.e r100) {
        this.f250154k = r100;
        XLivePlayerViewConfig r101 = this.f250144a;
        if (r101 == null) goto L7;
        r101.setPlayerEventListener(new LynxLiveLightPlayerConfigDefaultImpl$commonPlayerEventListener$1(this));
        return;
    }

    public final void c(boolean r100) {
        this.f250152i = r100;
        XLivePlayerViewConfig r101 = this.f250144a;
        if (r101 == null) goto L6;
        r101.setMute(r100);
    L6:
        if (r100 == false) goto L12;
        IXLivePlayerView r102 = this.f250145b;
        if (r102 == null) goto L18;
        ILivePlayerClient r103 = r102.client();
        if (r103 == null) goto L19;
        r103.mute();
        return;
    L19:
        return;
    L18:
        return;
    L12:
        IXLivePlayerView r104 = this.f250145b;
        if (r104 == null) goto L21;
        ILivePlayerClient r105 = r104.client();
        if (r105 == null) goto L22;
        r105.unmute();
        return;
    L22:
        return;
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f250153j = r100;
        XLivePlayerViewConfig r101 = this.f250144a;
        if (r101 == null) goto L6;
        r101.setResolution(r100);
    L6:
        IXLivePlayerView r102 = this.f250145b;
        if (r102 == null) goto L12;
        ILivePlayerClient r103 = r102.client();
        if (r103 == null) goto L13;
        r103.switchResolution(r100);
        return;
    L13:
        return;
    }

    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f250146c = r100;
        XLivePlayerViewConfig r101 = this.f250144a;
        if (r101 == null) goto L7;
        r101.setRoomId(r100);
        return;
    }

    public final void f(int r100) {
        this.f250151h = r100;
        if (r100 != 1) goto L5;
        XLivePlayerViewConfig r101 = this.f250144a;
        if (r101 == null) goto L23;
        r101.setScaleType(1);
        return;
    L23:
        return;
    L5:
        if (r100 == 2) goto L10;
        XLivePlayerViewConfig r102 = this.f250144a;
        if (r102 == null) goto L21;
        r102.setScaleType(0);
        return;
    L21:
        return;
    L10:
        XLivePlayerViewConfig r103 = this.f250144a;
        if (r103 == null) goto L22;
        r103.setScaleType(2);
        return;
    }

    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f250148e = r100;
        XLivePlayerViewConfig r101 = this.f250144a;
        if (r101 == null) goto L7;
        r101.setScene(r100);
        return;
    }

    public final void h(boolean r100) {
        this.f250149f = r100;
        XLivePlayerViewConfig r101 = this.f250144a;
        if (r101 == null) goto L7;
        r101.setShareToOther(r100);
        return;
    }

    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f250150g = r100;
        XLivePlayerViewConfig r101 = this.f250144a;
        if (r101 == null) goto L7;
        r101.setStreamData(r100);
        return;
    }
}
