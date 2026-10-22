package com.obric.assistant.interaction.impl;

import android.content.Context;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.base.model.InteractionEvent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\f"}, d2 = {"Lcom/obric/assistant/interaction/impl/ActivityStackObserver;", "Lcom/larus/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;", "<init>", "()V", "init", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onAppBackground", "onAppForeground", "onAllActivityDestroyed", MapMonitorConst.EVENT_DESTROY, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActivityStackObserver implements f09.a.b {
    public static final ActivityStackObserver INSTANCE = null;

    static {
        INSTANCE = new ActivityStackObserver();
    }

    private ActivityStackObserver() {
    }

    @Override // f09.a.b
    public void onAllActivityDestroyed() {
    }

    @Override // f09.a.b
    public void onAppBackground() {
        IAssistantInteractionServiceKt.getInteractionStateApi().onActivityVisibleStateEvent(InteractionEvent.InteractionActivityVisibleEvent.InvisibleEvent.INSTANCE);
    }

    @Override // f09.a.b
    public void onAppForeground() {
        IAssistantInteractionServiceKt.getInteractionStateApi().onActivityVisibleStateEvent(InteractionEvent.InteractionActivityVisibleEvent.VisibleEvent.INSTANCE);
    }

    public final void destroy(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AppHost.f326268a.a().c(this);
    }

    public final void init(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AppHost.f326268a.a().j(this);
    }
}
