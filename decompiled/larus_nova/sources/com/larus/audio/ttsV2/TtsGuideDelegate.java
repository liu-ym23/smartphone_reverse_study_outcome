package com.larus.audio.ttsV2;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0096\u0001J:\u0010\u000b\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00050\u0010H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u0014\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0005H\u0096\u0001¨\u0006\u0019"}, d2 = {"Lcom/larus/audio/ttsV2/TtsGuideDelegate;", "Lcom/larus/audio/ttsV2/ITtsGuideService;", "<init>", "()V", "clickGuide", "", "showFrom", "", "getEarphoneFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/audio/ttsV2/EarphoneState;", "initListener", "isTtsOpen", "Lkotlin/Function0;", "", "popupShow", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isEarphoneOnAndTtsCheck", "isEarphoneOpenGlobal", "removeListener", "setGlobalTtsSwitch", "openTts", "toggleTtsCheck", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsGuideDelegate implements ITtsGuideService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TtsGuideDelegate f289898b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ITtsGuideService f289899a;

    static {
        f289898b = new TtsGuideDelegate();
    }

    @Override // com.larus.audio.ttsV2.ITtsGuideService
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "showFrom");
        this.f289899a.a(r100);
    }

    @Override // com.larus.audio.ttsV2.ITtsGuideService
    public final void b(com.larus.tts.impl.t r100, com.larus.tts.impl.u r101) {
        Intrinsics.checkNotNullParameter(r100, "isTtsOpen");
        Intrinsics.checkNotNullParameter(r101, "popupShow");
        this.f289899a.b(r100, r101);
    }

    @Override // com.larus.audio.ttsV2.ITtsGuideService
    public final void c() {
        this.f289899a.c();
    }

    @Override // com.larus.audio.ttsV2.ITtsGuideService
    public final void d() {
        this.f289899a.d();
    }

    @Override // com.larus.audio.ttsV2.ITtsGuideService
    public final boolean e() {
        return this.f289899a.e();
    }

    @Override // com.larus.audio.ttsV2.ITtsGuideService
    public final i1<a> f() {
        return this.f289899a.f();
    }

    @Override // com.larus.audio.ttsV2.ITtsGuideService
    public final boolean g() {
        return this.f289899a.g();
    }

    @Override // com.larus.audio.ttsV2.ITtsGuideService
    public final void h(boolean r100) {
        this.f289899a.h(r100);
    }

    private TtsGuideDelegate() {
        ITtsGuideService r100 = (ITtsGuideService) ServiceManager.get().getService(ITtsGuideService.class);
        if (r100 != null) goto L5;
        r100 = new TtsGuideServiceNoop();
    L5:
        this.f289899a = r100;
    }
}
