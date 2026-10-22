package com.obric.assistant.audio.service;

import com.larus.utils.logger.FLogger;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J8\u0010\r\u001a\u00020\u00062\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J8\u0010\u0011\u001a\u00020\u00062\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/audio/service/ObricRealtimeCallStateService;", "Lcom/obric/assistant/audio/service/IObricRealtimeCallStateService;", "<init>", "()V", "muteFun", "Lkotlin/Function0;", "", "unMuteFun", "endCallFun", "onRealtimeCallStateChanged", "prev", "", "current", "init", ITTVideoEngineEventSource.KEY_MUTE, "unMute", "endCall", "release", "start", "stop", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricRealtimeCallStateService implements IObricRealtimeCallStateService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f385678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f385679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f385680c;

    public ObricRealtimeCallStateService() {
    }

    @Override // com.obric.assistant.audio.service.IObricRealtimeCallStateService
    public final void c(Object r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "prev");
        Intrinsics.checkNotNullParameter(r101, "current");
    }

    @Override // com.obric.assistant.audio.service.IObricRealtimeCallStateService
    public final void R1() {
        Function0<Unit> r100 = this.f385679b;
        if (r100 == null) goto L5;
        r100.invoke();
    L5:
        FLogger.f375446a.d("ObricRealtimeCallStateService", "unMute() called, unMuteFun:" + this.f385679b);
    }

    @Override // com.obric.assistant.audio.service.IObricRealtimeCallStateService
    public final void endCall() {
        Function0<Unit> r100 = this.f385680c;
        if (r100 == null) goto L5;
        r100.invoke();
    L5:
        FLogger.f375446a.d("ObricRealtimeCallStateService", "endCall() called, endCallFun:" + this.f385680c);
    }

    @Override // com.obric.assistant.audio.service.IObricRealtimeCallStateService
    public final void mute() {
        Function0<Unit> r100 = this.f385678a;
        if (r100 == null) goto L5;
        r100.invoke();
    L5:
        FLogger.f375446a.d("ObricRealtimeCallStateService", "mute() called, muteFun:" + this.f385678a);
    }

    @Override // com.obric.assistant.audio.service.IObricRealtimeCallStateService
    public final void start() {
        FLogger.f375446a.d("ObricRealtimeCallStateService", "start()");
    }

    @Override // com.obric.assistant.audio.service.IObricRealtimeCallStateService
    public final void stop() {
        FLogger.f375446a.d("ObricRealtimeCallStateService", "stop()");
    }

    @Override // com.obric.assistant.audio.service.IObricRealtimeCallStateService
    public final void a(Function0<Unit> r100, Function0<Unit> r101, Function0<Unit> r102) {
        this.f385678a = r100;
        this.f385679b = r101;
        this.f385680c = r102;
        FLogger.f375446a.d("ObricRealtimeCallStateService", "init() called, muteFun:" + this.f385678a + ", unMuteFun:" + this.f385679b + ", endCallFun:" + this.f385680c);
    }

    @Override // com.obric.assistant.audio.service.IObricRealtimeCallStateService
    public final void b(Function0<Unit> r100, Function0<Unit> r101, Function0<Unit> r102) {
        if (Intrinsics.areEqual(r100, this.f385678a) == true) goto L5;
    L11:
        FLogger.f375446a.w("ObricRealtimeCallStateService", "release() called with different funs, muteFun:" + this.f385678a + ", unMuteFun:" + this.f385679b + ", endCallFun:" + this.f385680c);
        return;
    L5:
        if (Intrinsics.areEqual(r101, this.f385679b) == false) goto L11;
        if (Intrinsics.areEqual(r102, this.f385680c) == false) goto L11;
        this.f385678a = null;
        this.f385679b = null;
        this.f385680c = null;
        FLogger.f375446a.d("ObricRealtimeCallStateService", "release() called");
    }
}
