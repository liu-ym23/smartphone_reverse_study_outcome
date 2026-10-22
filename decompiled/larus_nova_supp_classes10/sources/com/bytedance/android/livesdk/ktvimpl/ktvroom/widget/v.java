package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.view.View;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.DragLinearLayout;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class v<T> implements Observer {
    public final /* synthetic */ KtvInteractElementWidget a;

    public v(KtvInteractElementWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        StateMachine.c.b r7 = (StateMachine.c.b) r6;
        KtvInteractElementWidget r0 = this.a;
        r0.getClass();
        if (r7 == null) goto L42;
        KtvRoomLyricsStateMachineConfig.d r8 = (KtvRoomLyricsStateMachineConfig.d) r7.c;
        if ((r8 instanceof KtvRoomLyricsStateMachineConfig.d.c) == false) goto L11;
        DragLinearLayout r1 = r0.f;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("interactElementContainer");
    L10:
        r1.setVisibility(0);
    L16:
        if ((r8 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L28;
        if (r0.z.isCurrentUserIsSinger() == false) goto L20;
        r0.yq("onPreparing");
    L20:
        View r9 = r0.t;
        if (r9 == null) goto L23;
        r9.setVisibility(8);
    L23:
        DragLinearLayout r10 = r0.f;
        if (r10 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("interactElementContainer");
    L26:
        r10.setPosPercent(0.0f);
        return;
    L28:
        if ((r8 instanceof KtvRoomLyricsStateMachineConfig.d.f) == true) goto L30;
        return;
    L30:
        if (r0.z.isCurrentUserIsSinger() == false) goto L33;
        r0.yq("onSinging");
    L33:
        if (vm2.h.b() == false) goto L41;
        DragLinearLayout r11 = r0.f;
        if (r11 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("interactElementContainer");
    L37:
        r11.a();
        return;
    L41:
        return;
    L11:
        DragLinearLayout r2 = r0.f;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("interactElementContainer");
    L14:
        r2.setVisibility(8);
        goto L16
    }
}
