package com.obric.assistant;

import com.obric.assistant.chatcontext.ClearContextInKeyguardServiceImpl;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000bH&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000bH&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000bH&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u000bH&J\u0014\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00160\u0015H&J)\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH&¢\u0006\u0002\u0010\u001eJ3\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u000bH&¢\u0006\u0002\u0010!J\u0018\u0010\"\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH&J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0$H&J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0$H&J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0$H&J)\u0010'\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH&¢\u0006\u0002\u0010\u001e¨\u0006("}, d2 = {"Lcom/obric/assistant/ISessionAuthenticationService;", "", "init", "", "getSessionId", "", "registerSessionAuthenticationStateChangedListener", "listener", "Lcom/obric/assistant/IOnSessionAuthenticationStateChangedListener;", "unregisterSessionAuthenticationStateChangedListener", "isVoicePrintAuthenticationOnLockScreenEnabled", "", "isNeedVoicePrintAuthentication", "setVoicePrintState", "sessionId", "isPassed", "setBiometricState", "setDeviceState", "resetSessionState", "isAuthenticationPass", "isAuthenticationPassV2", "Lkotlin/Pair;", "Lcom/obric/assistant/AuthenticationType;", "requestVoicePrintAuthentication", "params", "Lcom/obric/assistant/RequestAuthenticationParams;", "timeoutMillis", "", "callback", "Lcom/obric/assistant/RequestAuthenticationCallback;", "(Lcom/obric/assistant/RequestAuthenticationParams;Ljava/lang/Long;Lcom/obric/assistant/RequestAuthenticationCallback;)V", "requestBiometricAuthentication", "playTts", "(Lcom/obric/assistant/RequestAuthenticationParams;Ljava/lang/Long;Lcom/obric/assistant/RequestAuthenticationCallback;Z)V", "requestDeviceCredentialAuthentication", "isVoicePrintPass", "Lkotlinx/coroutines/flow/StateFlow;", "isBiometricPass", "isBiometricAuthenticating", "requestActivityAuthenticationOnLockAsync", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ISessionAuthenticationService {
    void d(String r100, boolean r101);

    void e(o4 r100, n4 r101);

    void f(o4 r100, Long r101, n4 r102);

    void g(o4 r100, Long r101, n4 r102, boolean r103);

    String getSessionId();

    void h(ClearContextInKeyguardServiceImpl.d r100);

    Pair<Boolean, AuthenticationType> i();

    void init();

    boolean isAuthenticationPass();

    void j(o4 r100, Long r101, n4 r102);

    kotlinx.coroutines.flow.i1<Boolean> k();

    kotlinx.coroutines.flow.i1<Boolean> l();

    boolean m();

    boolean n();

    kotlinx.coroutines.flow.i1<Boolean> o();
}
