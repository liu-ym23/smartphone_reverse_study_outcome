package com.larus.im.internal.audio.session.omni;

import com.larus.im.internal.jni.ktx.OmniTokenServiceKtxKt;
import com.larus.im.internal.jni.service.OmniMediaServiceKt;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes4.dex */
public final class r implements qf9.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f347373a = null;

    static {
        f347373a = new r();
    }

    public r() {
    }

    @Override // qf9.d
    public final int a(com.larus.im.service.d r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return OmniMediaServiceKt.preGetMmtAccess(OmniTokenServiceKtxKt.getOmniMediaService(), h0.a(r100));
    }

    @Override // qf9.d
    public final void b(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "rtcAppIds");
    }

    @Override // qf9.d
    public final void c(cf9.a r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        fe9.c r101 = fe9.c.f476624a;
        r101.e("OmniLinkRuntime", "init rtc engine bridge from media service init, appId:" + r100.f23542a + ", businessId:" + r100.f23543b + '.');
        Object r102 = OmniRtcEngineBridgeInitTask.f347269a;
        Intrinsics.checkNotNullParameter("media_service_init", "reason");
        Object r103 = OmniRtcEngineBridgeInitTask.f347269a;
        monitor-enter(r103);
        boolean r104 = OmniRtcEngineBridgeInitTask.f347271c;     // Catch: Throwable -> L11
        monitor-exit(r103);
        if (r104 == false) goto L9;
        r101.e("OmniRtcEngineBridgeInitTask", "init rtc engine bridge skipped, already initialized, reason:media_service_init.");
        return;
    L9:
        Deferred r105 = OmniRtcEngineBridgeInitTask.a();
        r101.e("OmniRtcEngineBridgeInitTask", "start init rtc engine bridge, reason:media_service_init.");
        r105.start();
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // qf9.d
    public final int d(com.larus.im.service.d r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return OmniMediaServiceKt.preloadMmtTransport(OmniTokenServiceKtxKt.getOmniMediaService(), h0.a(r100));
    }
}
