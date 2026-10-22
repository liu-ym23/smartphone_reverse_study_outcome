package com.obric.assistant;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\t\u0010\n\u001a\u00020\u000bH\u0096\u0001J\t\u0010\f\u001a\u00020\u000bH\u0096\u0001J\t\u0010\r\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u000e\u001a\u00020\u000bH\u0096\u0001J\u001b\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001J\u0011\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0013H\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0013H\u0096\u0001J \u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0001¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/obric/assistant/ObricAssistantDelegate;", "Lcom/obric/assistant/IObricAssistant;", "<init>", "()V", "createObricChatPageRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "createObricLockScreenRouterInterceptor", "createObricMultiTabChatPageRouterInterceptor", "createObricRealTimeCallRouterInterceptor", "createObricSecurityRouterInterceptor", "finishChatPage", "", "initCapabilitySdk", "initEventTaskSdk", "registerLifecycle", "routeToCameraCapture", "", "isTopRtcVideo", "startupAttemptId", "", "routeToCameraResult", "uri", "routeToCreationCanvas", "displayId", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAssistantDelegate implements IObricAssistant {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricAssistantDelegate f385138b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricAssistant f385139a;

    static {
        f385138b = new ObricAssistantDelegate();
    }

    @Override // com.obric.assistant.IObricAssistant
    public final void a(String r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        this.f385139a.a(r100, r101);
    }

    @Override // com.obric.assistant.IObricAssistant
    public final q97.a b() {
        return this.f385139a.b();
    }

    @Override // com.obric.assistant.IObricAssistant
    public final q97.a c() {
        return this.f385139a.c();
    }

    @Override // com.obric.assistant.IObricAssistant
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        this.f385139a.d(r100);
    }

    @Override // com.obric.assistant.IObricAssistant
    public final boolean e(boolean r100, String r101) {
        return this.f385139a.e(r100, r101);
    }

    @Override // com.obric.assistant.IObricAssistant
    public final void f() {
        this.f385139a.f();
    }

    @Override // com.obric.assistant.IObricAssistant
    public final void finishChatPage() {
        this.f385139a.finishChatPage();
    }

    @Override // com.obric.assistant.IObricAssistant
    public final void g() {
        this.f385139a.g();
    }

    @Override // com.obric.assistant.IObricAssistant
    public final q97.a h() {
        return this.f385139a.h();
    }

    @Override // com.obric.assistant.IObricAssistant
    public final void i() {
        this.f385139a.i();
    }

    @Override // com.obric.assistant.IObricAssistant
    public final void j(boolean r100) {
        this.f385139a.j(r100);
    }

    @Override // com.obric.assistant.IObricAssistant
    public final q97.a k() {
        return this.f385139a.k();
    }

    private ObricAssistantDelegate() {
        this.f385139a = (IObricAssistant) ServiceManager.get().getService(IObricAssistant.class);
    }
}
