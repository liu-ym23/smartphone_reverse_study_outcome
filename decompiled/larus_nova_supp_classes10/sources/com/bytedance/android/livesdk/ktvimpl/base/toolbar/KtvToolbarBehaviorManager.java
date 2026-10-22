package com.bytedance.android.livesdk.ktvimpl.base.toolbar;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.ktvapi.HolderRoomWidget;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zd2.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/toolbar/KtvToolbarBehaviorManager;", "Landroidx/lifecycle/LifecycleOwner;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvToolbarBehaviorManager implements LifecycleOwner {
    public final HashMap<ToolbarButton, c0.b> a;
    public final HolderRoomWidget b;

    public final Lifecycle getLifecycle() {
        return this.b.getLifecycle();
    }

    public KtvToolbarBehaviorManager(HolderRoomWidget r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        this.b = r2;
        this.a = new HashMap();
    }

    public final void a(ToolbarButton r3) {
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TYPE);
        Intrinsics.checkNotNullParameter("more", "enterFrom");
        Intrinsics.checkNotNullParameter("", "function");
        b r0 = new b(this.b, r3);
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r0, "behavior");
        if (this.a.containsKey(r3) == false) goto L5;
        ALogger.i(bb0.b.b(), "load ToolbarBehavior repeatedly, invoke class :KtvToolbarBehaviorManager");
        return;
    L5:
        this.a.put(r3, r0);
        y3.f(((Widget) this.b).dataCenter).k(r3, r0);
    }
}
