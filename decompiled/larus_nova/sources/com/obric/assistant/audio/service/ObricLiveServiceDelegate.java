package com.obric.assistant.audio.service;

import android.content.Intent;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J!\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096\u0001J\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\rH\u0096\u0001J\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0011\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u0012\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0018\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0019\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000bH\u0096\u0001¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/audio/service/ObricLiveServiceDelegate;", "Lcom/obric/assistant/audio/service/IObricLiveService;", "<init>", "()V", "cancelShowOnLocked", "", "destroyAllLiveCard", "destroyLiveCardByScene", "scene", "", "isFromContinuousIntents", "", "conversationId", "", "getSessionState", "Lcom/obric/assistant/state/api/v2/core/bean/ObricState;", "init", "isCollapseNotificationPanelAvailable", "isRealtimeCallMute", "markAsClosed", "openChatOrRealtimeCallActivity", "intent", "Landroid/content/Intent;", "resetRealtimeCallMuteState", "showLiveCardByScene", "updateComplexTaskLiveCard", "updateDialogue", "updateDialogueActionBtn", "disable", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricLiveServiceDelegate implements IObricLiveService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricLiveServiceDelegate f385676b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricLiveService f385677a;

    static {
        f385676b = new ObricLiveServiceDelegate();
    }

    @Override // com.obric.assistant.audio.service.IObricLiveService
    public final boolean a() {
        return this.f385677a.a();
    }

    @Override // com.obric.assistant.audio.service.IObricLiveService
    public final void b() {
        this.f385677a.b();
    }

    @Override // com.obric.assistant.audio.service.IObricLiveService
    public final void c() {
        this.f385677a.c();
    }

    @Override // com.obric.assistant.audio.service.IObricLiveService
    public final void d(int r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "conversationId");
        this.f385677a.d(r100, false, r102);
    }

    @Override // com.obric.assistant.audio.service.IObricLiveService
    public final void e() {
        this.f385677a.e();
    }

    @Override // com.obric.assistant.audio.service.IObricLiveService
    public final boolean f() {
        return this.f385677a.f();
    }

    @Override // com.obric.assistant.audio.service.IObricLiveService
    public final void g(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        this.f385677a.g(r100);
    }

    @Override // com.obric.assistant.audio.service.IObricLiveService
    public final ObricState h(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        return this.f385677a.h(r100, r101);
    }

    @Override // com.obric.assistant.audio.service.IObricLiveService
    public final void i() {
        this.f385677a.i();
    }

    @Override // com.obric.assistant.audio.service.IObricLiveService
    public final void init() {
        this.f385677a.init();
    }

    @Override // com.obric.assistant.audio.service.IObricLiveService
    public final void j() {
        this.f385677a.j();
    }

    @Override // com.obric.assistant.audio.service.IObricLiveService
    public final ObricState k() {
        Intrinsics.checkNotNullParameter("complex_task", "scene");
        return this.f385677a.k();
    }

    @Override // com.obric.assistant.audio.service.IObricLiveService
    public final void l(int r100, boolean r101) {
        this.f385677a.l(r100, r101);
    }

    @Override // com.obric.assistant.audio.service.IObricLiveService
    public final void m() {
        this.f385677a.m();
    }

    private ObricLiveServiceDelegate() {
        this.f385677a = (IObricLiveService) ServiceManager.get().getService(IObricLiveService.class);
    }
}
