package com.larus.voicecall.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import lq9.x;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0001J\t\u0010\n\u001a\u00020\u000bH\u0096\u0001J\t\u0010\f\u001a\u00020\u000bH\u0096\u0001J\t\u0010\r\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u0011\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u0012\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u0013\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u0014\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u0015\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u0016\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u0017\u001a\u00020\tH\u0096\u0001J\t\u0010\u0018\u001a\u00020\tH\u0096\u0001R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/larus/voicecall/api/VoiceCallConfigServiceDelegate;", "Lcom/larus/voicecall/api/IVoiceCallConfigService;", "<init>", "()V", "buildConnectionConfig", "Lcom/larus/voicecall/api/bean/PreConnectConfig;", "callHelloTechType", "", "closeRealtimeDenoiseSwitch", "", "enableInitTaskVEPreload", "", "enableSubtitleAsrSeg", "getRealtimeCallPreloadConfig", "Lcom/larus/platform/model/audio/RealtimeCallPreloadConfig;", "isAutoInterrupt", "isCurSceneNull", "isDenoiseABEnable", "isDialogEntranceEnable", "isInCall", "isNewCallIconEnable", "isPlayingHello", "isVideoEnable", "preGetMmtAccess", "preloadMmtTransport", "curCallId", "getCurCallId", "()Ljava/lang/String;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceCallConfigServiceDelegate implements IVoiceCallConfigService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final VoiceCallConfigServiceDelegate f377084b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IVoiceCallConfigService f377085a;

    static {
        f377084b = new VoiceCallConfigServiceDelegate();
    }

    @Override // com.larus.voicecall.api.IVoiceCallConfigService
    public final String a() {
        return this.f377085a.a();
    }

    @Override // com.larus.voicecall.api.IVoiceCallConfigService
    public final boolean b() {
        return this.f377085a.b();
    }

    @Override // com.larus.voicecall.api.IVoiceCallConfigService
    public final boolean c() {
        return this.f377085a.c();
    }

    @Override // com.larus.voicecall.api.IVoiceCallConfigService
    public final void d() {
        this.f377085a.d();
    }

    @Override // com.larus.voicecall.api.IVoiceCallConfigService
    public final boolean e() {
        return this.f377085a.e();
    }

    @Override // com.larus.voicecall.api.IVoiceCallConfigService
    public final boolean f() {
        return this.f377085a.f();
    }

    @Override // com.larus.voicecall.api.IVoiceCallConfigService
    public final boolean g() {
        return this.f377085a.g();
    }

    @Override // com.larus.voicecall.api.IVoiceCallConfigService
    public final x getRealtimeCallPreloadConfig() {
        return this.f377085a.getRealtimeCallPreloadConfig();
    }

    @Override // com.larus.voicecall.api.IVoiceCallConfigService
    public final void h() {
        this.f377085a.h();
    }

    @Override // com.larus.voicecall.api.IVoiceCallConfigService
    public final boolean i() {
        return this.f377085a.i();
    }

    @Override // com.larus.voicecall.api.IVoiceCallConfigService
    public final String j() {
        return this.f377085a.j();
    }

    @Override // com.larus.voicecall.api.IVoiceCallConfigService
    public final boolean k() {
        return this.f377085a.k();
    }

    @Override // com.larus.voicecall.api.IVoiceCallConfigService
    public final boolean l() {
        return this.f377085a.l();
    }

    @Override // com.larus.voicecall.api.IVoiceCallConfigService
    public final void m() {
        this.f377085a.m();
    }

    @Override // com.larus.voicecall.api.IVoiceCallConfigService
    public final boolean n() {
        return this.f377085a.n();
    }

    private VoiceCallConfigServiceDelegate() {
        IVoiceCallConfigService r100 = (IVoiceCallConfigService) ServiceManager.get().getService(IVoiceCallConfigService.class);
        if (r100 != null) goto L5;
        r100 = new VoiceCallConfigServiceNoop();
    L5:
        this.f377085a = r100;
    }
}
