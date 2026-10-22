package com.larus.avlink.record.util;

import com.larus.avlink.n1;
import com.larus.common.apphost.AppHost;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i implements yk9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f294415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f294416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f294417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f294418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Integer f294419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f294420f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ s f294421g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<RetryDecision> f294422h;

    @Override // yk9.b
    public final void onSuccess(String r310) {
        Intrinsics.checkNotNullParameter(r310, "onlineRecordingId");
        n1.d("LarkRecordMinutesManager", "GRecord lark retry success, recordingId=" + r310);
        long r110 = System.currentTimeMillis() - this.f294415a;
        int r100 = a.f294409a;
        a.i(true, this.f294416b, this.f294417c, this.f294418d, this.f294419e, this.f294420f, r110, null, null, this.f294421g);
        a.l(true, this.f294416b, this.f294417c, this.f294418d, this.f294419e, this.f294420f, System.currentTimeMillis() - LarkRecordMinutesManager.E, null, null, null, null, null, this.f294421g, 3968);
        LarkRecordMinutesManager.f294325a.getClass();
        if (r310 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        n1.b("LarkRecordMinutesManager", "GRecord open recording page failed, recordingId is null or empty");
    L19:
        if (this.f294422h.isActive() == false) goto L22;
        kotlinx.coroutines.i<RetryDecision> r102 = this.f294422h;
        Result.Companion r103 = Result.Companion;
        r102.resumeWith(Result.m9449constructorimpl(RetryDecision.SUCCESS));
        return;
    L22:
        return;
    L11:
        AppHost.Companion r104 = AppHost.f326268a;
        if (r104.a().isAppBackground() == false) goto L17;
        n1.d("LarkRecordMinutesManager", "GRecord app in background, defer open recording page until foreground, recordingId=" + r310);
        f09.a.b r105 = LarkRecordMinutesManager.G;
        if (r105 == null) goto L16;
        r104.a().c(r105);
    L16:
        j r106 = new j(r310);
        LarkRecordMinutesManager.G = r106;
        r104.a().j(r106);
        goto L19
    L17:
        LarkRecordMinutesManager.A(r310);
        goto L19
    L5:
        if (r310.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @Override // yk9.b
    public final void onFail(int r210, String r211) {
        boolean r100 = yk9.f.f568287a.contains(Integer.valueOf(r210));
        n1.b("LarkRecordMinutesManager", "GRecord lark retry failed, code=" + r210 + ", msg=" + r211 + ", terminal=" + r100);
        long r110 = System.currentTimeMillis() - this.f294415a;
        int r101 = a.f294409a;
        a.i(false, this.f294416b, this.f294417c, this.f294418d, this.f294419e, this.f294420f, r110, String.valueOf(r210), r211, this.f294421g);
        if (r100 == false) goto L6;
        a.l(false, this.f294416b, this.f294417c, this.f294418d, this.f294419e, this.f294420f, System.currentTimeMillis() - LarkRecordMinutesManager.E, "sdk", "sdk_retry_create_failed", String.valueOf(r210), r211, null, this.f294421g, 2048);
    L6:
        if (this.f294422h.isActive() == false) goto L13;
        kotlinx.coroutines.i<RetryDecision> r102 = this.f294422h;
        Result.Companion r103 = Result.Companion;
        if (r100 == false) goto L10;
        RetryDecision r104 = RetryDecision.TERMINAL;
    L11:
        r102.resumeWith(Result.m9449constructorimpl(r104));
        return;
    L10:
        r104 = RetryDecision.RETRY;
        goto L11
    }

    public i(long r100, String r101, String r102, String r103, Integer r104, String r105, s r106, kotlinx.coroutines.j r107) {
        this.f294415a = r100;
        this.f294416b = r101;
        this.f294417c = r102;
        this.f294418d = r103;
        this.f294419e = r104;
        this.f294420f = r105;
        this.f294421g = r106;
        this.f294422h = r107;
    }
}
