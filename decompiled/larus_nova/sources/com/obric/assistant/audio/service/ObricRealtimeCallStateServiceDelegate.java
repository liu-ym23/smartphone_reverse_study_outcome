package com.obric.assistant.audio.service;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J9\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0096\u0001J9\u0010\u000e\u001a\u00020\u00052\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0010\u001a\u00020\u0005H\u0096\u0001J\t\u0010\t\u001a\u00020\u0005H\u0096\u0001¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/audio/service/ObricRealtimeCallStateServiceDelegate;", "Lcom/obric/assistant/audio/service/IObricRealtimeCallStateService;", "<init>", "()V", "endCall", "", "init", ITTVideoEngineEventSource.KEY_MUTE, "Lkotlin/Function0;", "unMute", "onRealtimeCallStateChanged", "prev", "", "current", "release", "start", "stop", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricRealtimeCallStateServiceDelegate implements IObricRealtimeCallStateService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricRealtimeCallStateServiceDelegate f385681b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricRealtimeCallStateService f385682a;

    static {
        f385681b = new ObricRealtimeCallStateServiceDelegate();
    }

    @Override // com.obric.assistant.audio.service.IObricRealtimeCallStateService
    public final void R1() {
        this.f385682a.R1();
    }

    @Override // com.obric.assistant.audio.service.IObricRealtimeCallStateService
    public final void a(Function0<Unit> r100, Function0<Unit> r101, Function0<Unit> r102) {
        this.f385682a.a(r100, r101, r102);
    }

    @Override // com.obric.assistant.audio.service.IObricRealtimeCallStateService
    public final void b(Function0<Unit> r100, Function0<Unit> r101, Function0<Unit> r102) {
        this.f385682a.b(r100, r101, r102);
    }

    @Override // com.obric.assistant.audio.service.IObricRealtimeCallStateService
    public final void c(Object r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "prev");
        Intrinsics.checkNotNullParameter(r101, "current");
        this.f385682a.c(r100, r101);
    }

    @Override // com.obric.assistant.audio.service.IObricRealtimeCallStateService
    public final void endCall() {
        this.f385682a.endCall();
    }

    @Override // com.obric.assistant.audio.service.IObricRealtimeCallStateService
    public final void mute() {
        this.f385682a.mute();
    }

    @Override // com.obric.assistant.audio.service.IObricRealtimeCallStateService
    public final void start() {
        this.f385682a.start();
    }

    @Override // com.obric.assistant.audio.service.IObricRealtimeCallStateService
    public final void stop() {
        this.f385682a.stop();
    }

    private ObricRealtimeCallStateServiceDelegate() {
        this.f385682a = (IObricRealtimeCallStateService) ServiceManager.get().getService(IObricRealtimeCallStateService.class);
    }
}
