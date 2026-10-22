package com.larus.voicecall.impl.subtitle;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class t1 implements com.larus.bmhome.upload.audio.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f378973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SubtitleSingleImageHolder f378974b;

    @Override // com.larus.bmhome.upload.audio.l
    public final void G0(float r100) {
        this.f378974b.f378835a.f378309c.setProgress(r100);
    }

    public t1(c r100, SubtitleSingleImageHolder r101) {
        this.f378973a = r100;
        this.f378974b = r101;
    }

    @Override // com.larus.bmhome.upload.audio.l
    public final void H0(com.larus.bmhome.upload.audio.b r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, HiAnalyticsConstant.Direction.REQUEST);
        FLogger.f375446a.i("SubtitleSingleImageHolder", "upload photo failed. reason=" + r101);
        x3a.a r102 = this.f378973a.f378862i;
        if (r102 == null) goto L5;
        r102.f562412i = Boolean.TRUE;
    L5:
        this.f378974b.U3(true);
    }

    @Override // com.larus.bmhome.upload.audio.l
    public final void I0(com.larus.bmhome.upload.audio.i r100, com.larus.bmhome.upload.audio.h r101) {
        Intrinsics.checkNotNullParameter(r100, "totalRes");
        Intrinsics.checkNotNullParameter(r101, "res");
        x3a.a r102 = this.f378973a.f378862i;
        if (r102 == null) goto L8;
        String r103 = r101.c();
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f562410g = r103;
    L8:
        com.larus.utils.e1.o(this.f378974b.f378835a.f378311e);
        com.larus.utils.e1.o(this.f378974b.f378835a.f378309c);
        FLogger.f375446a.i("SubtitleSingleImageHolder", "upload photo success.");
    }
}
