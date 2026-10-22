package com.obric.assistant;

import com.obric.assistant.chatcontext.ClearContextInKeyguardServiceImpl;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0001J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000bH\u0096\u0001J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0096\u0001J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0096\u0001J\t\u0010\u0010\u001a\u00020\tH\u0096\u0001J\t\u0010\u0011\u001a\u00020\tH\u0096\u0001J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0096\u0001J(\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096\u0001¢\u0006\u0002\u0010\u001dJ0\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\tH\u0096\u0001¢\u0006\u0002\u0010 J\u0019\u0010!\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0096\u0001J(\u0010\"\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096\u0001¢\u0006\u0002\u0010\u001dJ\t\u0010#\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\tH\u0096\u0001J\u0019\u0010'\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\tH\u0096\u0001J\u0019\u0010(\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\tH\u0096\u0001J\u0011\u0010)\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0096\u0001¨\u0006*"}, d2 = {"Lcom/obric/assistant/SessionAuthenticationServiceDelegate;", "Lcom/obric/assistant/ISessionAuthenticationService;", "<init>", "()V", "getSessionId", "", "init", "", "isAuthenticationPass", "", "isAuthenticationPassV2", "Lkotlin/Pair;", "Lcom/obric/assistant/AuthenticationType;", "isBiometricAuthenticating", "Lkotlinx/coroutines/flow/StateFlow;", "isBiometricPass", "isNeedVoicePrintAuthentication", "isVoicePrintAuthenticationOnLockScreenEnabled", "isVoicePrintPass", "registerSessionAuthenticationStateChangedListener", "listener", "Lcom/obric/assistant/IOnSessionAuthenticationStateChangedListener;", "requestActivityAuthenticationOnLockAsync", "params", "Lcom/obric/assistant/RequestAuthenticationParams;", "timeoutMillis", "", "callback", "Lcom/obric/assistant/RequestAuthenticationCallback;", "(Lcom/obric/assistant/RequestAuthenticationParams;Ljava/lang/Long;Lcom/obric/assistant/RequestAuthenticationCallback;)V", "requestBiometricAuthentication", "playTts", "(Lcom/obric/assistant/RequestAuthenticationParams;Ljava/lang/Long;Lcom/obric/assistant/RequestAuthenticationCallback;Z)V", "requestDeviceCredentialAuthentication", "requestVoicePrintAuthentication", "resetSessionState", "setBiometricState", "sessionId", "isPassed", "setDeviceState", "setVoicePrintState", "unregisterSessionAuthenticationStateChangedListener", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SessionAuthenticationServiceDelegate implements ISessionAuthenticationService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SessionAuthenticationServiceDelegate f385201b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ISessionAuthenticationService f385202a;

    static {
        f385201b = new SessionAuthenticationServiceDelegate();
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final void d(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        this.f385202a.d(r100, r101);
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final void e(o4 r100, n4 r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f385202a.e(r100, r101);
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final void f(o4 r100, Long r101, n4 r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f385202a.f(r100, r101, r102);
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final void g(o4 r100, Long r101, n4 r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f385202a.g(r100, r101, r102, r103);
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final String getSessionId() {
        return this.f385202a.getSessionId();
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final void h(ClearContextInKeyguardServiceImpl.d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f385202a.h(r100);
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final Pair<Boolean, AuthenticationType> i() {
        return this.f385202a.i();
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final void init() {
        this.f385202a.init();
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final boolean isAuthenticationPass() {
        return this.f385202a.isAuthenticationPass();
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final void j(o4 r100, Long r101, n4 r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f385202a.j(r100, r101, r102);
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final kotlinx.coroutines.flow.i1<Boolean> k() {
        return this.f385202a.k();
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final kotlinx.coroutines.flow.i1<Boolean> l() {
        return this.f385202a.l();
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final boolean m() {
        return this.f385202a.m();
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final boolean n() {
        return this.f385202a.n();
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final kotlinx.coroutines.flow.i1<Boolean> o() {
        return this.f385202a.o();
    }

    private SessionAuthenticationServiceDelegate() {
        this.f385202a = (ISessionAuthenticationService) ServiceManager.get().getService(ISessionAuthenticationService.class);
    }
}
