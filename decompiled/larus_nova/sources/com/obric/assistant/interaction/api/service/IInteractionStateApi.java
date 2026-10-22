package com.obric.assistant.interaction.api.service;

import android.content.Context;
import com.obric.assistant.interaction.base.model.InteractionEvent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/interaction/api/service/IInteractionStateApi;", "", "onSessionLifecycleStateEvent", "", "state", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent;", "onActivityExpandStateEvent", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent;", "onActivityVisibleStateEvent", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityVisibleEvent;", "onKeyguardLockedStateEvent", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionKeyguardLockedEvent;", "onMicMuteStateEvent", "event", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$MicMuteEvent;", "isSupportLiveNotification", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IInteractionStateApi {
    boolean isSupportLiveNotification(Context r100);

    void onActivityExpandStateEvent(InteractionEvent.InteractionActivityExpandEvent r100);

    void onActivityVisibleStateEvent(InteractionEvent.InteractionActivityVisibleEvent r100);

    void onKeyguardLockedStateEvent(InteractionEvent.InteractionKeyguardLockedEvent r100);

    void onMicMuteStateEvent(InteractionEvent.MicMuteEvent r100);

    void onSessionLifecycleStateEvent(InteractionEvent.SessionLifecycleEvent r100);
}
