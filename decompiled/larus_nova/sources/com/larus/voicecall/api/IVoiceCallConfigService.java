package com.larus.voicecall.api;

import kotlin.Metadata;
import lq9.x;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u0007H&J\b\u0010\u000e\u001a\u00020\u0007H&J\b\u0010\u000f\u001a\u00020\u0007H&J\b\u0010\u0010\u001a\u00020\u0007H&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0012\u001a\u00020\u0007H&J\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0007H&J\b\u0010\u0016\u001a\u00020\u000bH&J\b\u0010\u0017\u001a\u00020\u0007H&J\b\u0010\u0018\u001a\u00020\u0019H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u001a"}, d2 = {"Lcom/larus/voicecall/api/IVoiceCallConfigService;", "", "curCallId", "", "getCurCallId", "()Ljava/lang/String;", "isAutoInterrupt", "", "isVideoEnable", "enableInitTaskVEPreload", "preGetMmtAccess", "", "preloadMmtTransport", "isNewCallIconEnable", "isInCall", "isPlayingHello", "isCurSceneNull", "callHelloTechType", "isDialogEntranceEnable", "buildConnectionConfig", "Lcom/larus/voicecall/api/bean/PreConnectConfig;", "enableSubtitleAsrSeg", "closeRealtimeDenoiseSwitch", "isDenoiseABEnable", "getRealtimeCallPreloadConfig", "Lcom/larus/platform/model/audio/RealtimeCallPreloadConfig;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IVoiceCallConfigService {
    String a();

    boolean b();

    boolean c();

    void d();

    boolean e();

    boolean f();

    boolean g();

    x getRealtimeCallPreloadConfig();

    void h();

    boolean i();

    String j();

    boolean k();

    boolean l();

    void m();

    boolean n();
}
