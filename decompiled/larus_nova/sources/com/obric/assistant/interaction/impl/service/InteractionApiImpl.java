package com.obric.assistant.interaction.impl.service;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.service.IInteractionStateApi;
import com.obric.assistant.interaction.base.model.InteractionEvent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0019H\u0016J\u0010\u0010\u0006\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/interaction/impl/service/InteractionApiImpl;", "Lcom/obric/assistant/interaction/api/service/IInteractionStateApi;", "<init>", "()V", "TAG", "", "isSupportLiveNotification", "", "eventHub", "Lcom/obric/assistant/interaction/impl/service/EventHubImpl;", "getEventHub", "()Lcom/obric/assistant/interaction/impl/service/EventHubImpl;", "eventHub$delegate", "Lkotlin/Lazy;", "onSessionLifecycleStateEvent", "", "event", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent;", "onActivityExpandStateEvent", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent;", "onActivityVisibleStateEvent", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityVisibleEvent;", "onKeyguardLockedStateEvent", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionKeyguardLockedEvent;", "onMicMuteStateEvent", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$MicMuteEvent;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InteractionApiImpl implements IInteractionStateApi {
    public static final InteractionApiImpl INSTANCE = null;
    public static final String TAG = "InteractionApiImpl";
    private static final Lazy eventHub$delegate = null;
    private static int isSupportLiveNotification;

    private InteractionApiImpl() {
    }

    public static /* synthetic */ EventHubImpl a() {
        return eventHub_delegate$lambda$0();
    }

    static {
        INSTANCE = new InteractionApiImpl();
        isSupportLiveNotification = -1;
        eventHub$delegate = LazyKt.lazy(new b());
    }

    private final EventHubImpl getEventHub() {
        return (EventHubImpl) eventHub$delegate.getValue();
    }

    private static final EventHubImpl eventHub_delegate$lambda$0() {
        return EventHubImpl.INSTANCE;
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateApi
    public boolean isSupportLiveNotification(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = isSupportLiveNotification;
        if (r101 == (-1)) goto L21;
        if (r101 != 1) goto L23;
        return true;
    L23:
        return false;
    L21:
        Bundle r102 = r100.getPackageManager().getApplicationInfo(r100.getPackageName(), 128).metaData;     // Catch: PackageManager.NameNotFoundException -> L15
        if (r102 == null) goto L18;
        boolean r103 = r102.getBoolean("com.samsung.android.support.ongoing_activity");     // Catch: PackageManager.NameNotFoundException -> L15
        FLogger.f375446a.d(TAG, "supportLiveNotification: " + r103);     // Catch: PackageManager.NameNotFoundException -> L15
        if (r103 == false) goto L12;
        int r104 = 1;
    L13:
        isSupportLiveNotification = r104;     // Catch: PackageManager.NameNotFoundException -> L15
        goto L18
    L12:
        r104 = 0;
    L18:
        if (isSupportLiveNotification != 1) goto L24;
        return true;
    L24:
        return false;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateApi
    public void onActivityExpandStateEvent(InteractionEvent.InteractionActivityExpandEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        getEventHub().onEvent(r100);
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateApi
    public void onActivityVisibleStateEvent(InteractionEvent.InteractionActivityVisibleEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        getEventHub().onEvent(r100);
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateApi
    public void onKeyguardLockedStateEvent(InteractionEvent.InteractionKeyguardLockedEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        getEventHub().onEvent(r100);
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateApi
    public void onMicMuteStateEvent(InteractionEvent.MicMuteEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        getEventHub().onEvent(r100);
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateApi
    public void onSessionLifecycleStateEvent(InteractionEvent.SessionLifecycleEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        getEventHub().onEvent(r100);
    }
}
