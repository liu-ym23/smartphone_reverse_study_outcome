package com.obric.assistant.audio.service;

import android.content.Intent;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0005H&J \u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0005H&J\b\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u0014\u001a\u00020\u0005H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u0018\u001a\u00020\u0003H&J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\r\u001a\u00020\u000bH&J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/audio/service/IObricLiveService;", "", "init", "", "isRealtimeCallMute", "", "resetRealtimeCallMuteState", "markAsClosed", "destroyAllLiveCard", "updateComplexTaskLiveCard", "conversationId", "", "destroyLiveCardByScene", "scene", "", "isFromContinuousIntents", "updateDialogueActionBtn", "disable", "updateDialogue", "showLiveCardByScene", "isCollapseNotificationPanelAvailable", "openChatOrRealtimeCallActivity", "intent", "Landroid/content/Intent;", "cancelShowOnLocked", "getSessionState", "Lcom/obric/assistant/state/api/v2/core/bean/ObricState;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricLiveService {
    boolean a();

    void b();

    void c();

    void d(int r100, boolean r101, String r102);

    void e();

    boolean f();

    void g(Intent r100);

    ObricState h(String r100, String r101);

    void i();

    void init();

    void j();

    ObricState k();

    void l(int r100, boolean r101);

    void m();
}
