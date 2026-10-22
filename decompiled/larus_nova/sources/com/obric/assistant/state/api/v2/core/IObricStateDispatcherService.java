package com.obric.assistant.state.api.v2.core;

import cha.a;
import cha.b;
import com.obric.assistant.component.ObricAppeaseComponent;
import com.obric.assistant.live.service.ObricLiveService;
import com.obric.assistant.state.api.v2.core.bean.ObricAssistantAliveLockState;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 *2\u00020\u0001:\u0001*J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\rH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J-\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u0018J-\u0010\u0019\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u0018J-\u0010\u001a\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u0018J-\u0010\u001b\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u0018J\"\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\u001f\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010 \u001a\u0004\u0018\u00010\u00062\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020$H&J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H&J\b\u0010(\u001a\u00020\u0003H&J\b\u0010)\u001a\u00020\u0003H&¨\u0006+"}, d2 = {"Lcom/obric/assistant/state/api/v2/core/IObricStateDispatcherService;", "", "initObricStateMachine", "", "registerOnObricStateChangeChangedObserver", "conversationId", "", "changedListener", "Lcom/obric/assistant/state/api/v2/core/observer/OnStateChangedObserverV2;", "unregisterOnObricStateChangeChangedObserver", "registerOnGlobalObricStateObserver", "unregisterOnGlobalObricStateObserver", "registerOnObricPowerLockStateObserver", "Lcom/obric/assistant/state/api/v2/core/observer/OnPowerLockStateChangedObserver;", "unregisterOnObricPowerLockObserver", "registerGlobalAudioState", "observer", "Lcom/obric/assistant/state/api/v2/core/observer/OnAudioStateChangedObserver;", "unregisterGlobalAudioState", "mobClickTalkStart", "cvsId", "sourceType", "", "sessionId", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "mobClickTalkQueryBegin", "mobClickTalkQueryEnd", "mobClickTalkEnd", "onRealtimeStateChange", "prev", "current", "onContinuousTalkTtsStateChange", DBDefinition.TASK_ID, "isPlaying", "", "getCurrentAssistantLiveState", "Lcom/obric/assistant/state/api/v2/core/bean/ObricAssistantAliveLockState;", "getCurrentAssistantAliveReasons", "", "Lcom/obric/assistant/state/api/v2/core/AssistantAliveReason;", "onAutoDismissTaskAdd", "onAutoDismissTaskRemove", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricStateDispatcherService {
    ObricAssistantAliveLockState a();

    void b(String r100, Integer r101);

    void c();

    void d(int r100, int r101, String r102);

    void e(ObricLiveService.e r100);

    void f(String r100, String r101, boolean r102);

    void g(ObricAppeaseComponent.c r100);

    void h(String r100, Integer r101);

    void i(a r100);

    List<AssistantAliveReason> j();

    void k();

    void l();

    void m(String r100, Integer r101);

    void n(String r100, Integer r101);

    void o(b r100);
}
