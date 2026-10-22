package com.obric.assistant;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u001f\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0012\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u0016H&J\u001a\u0010\u0014\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fH&¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/IObricAssistant;", "", "createObricLockScreenRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "createObricChatPageRouterInterceptor", "createObricMultiTabChatPageRouterInterceptor", "createObricRealTimeCallRouterInterceptor", "createObricSecurityRouterInterceptor", "registerLifecycle", "", "initCapabilitySdk", "finishChatPage", "initEventTaskSdk", "routeToCreationCanvas", "uri", "", "displayId", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "routeToCameraResult", "routeToCameraCapture", "isTopRtcVideo", "", "startupAttemptId", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricAssistant {
    void a(String r100, Integer r101);

    q97.a b();

    q97.a c();

    void d(String r100);

    boolean e(boolean r100, String r101);

    void f();

    void finishChatPage();

    void g();

    q97.a h();

    void i();

    void j(boolean r100);

    q97.a k();
}
