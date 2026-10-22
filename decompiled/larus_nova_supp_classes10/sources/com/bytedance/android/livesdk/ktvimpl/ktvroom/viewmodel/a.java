package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class a {
    public a() {
    }

    public abstract void c(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r1);

    public abstract void f(com.bytedance.android.livesdk.ktvimpl.base.sei.k r1);

    public abstract void g(com.bytedance.android.livesdk.ktvimpl.base.sei.k r1, JSONObject r2);

    public abstract void h(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r1);

    public void i() {
    }

    public static boolean d(KtvMusic r1) {
        String r0 = jc1.k.n(IMiddlewareUserService.class).user().n().toString();
        if (r1 == null) goto L10;
        OrderInfo r2 = r1.getOrderInfo();
        if (r2 == null) goto L10;
        InteractiveSongUserInfo r3 = r2.getTopUser();
        if (r3 == null) goto L10;
        String r4 = r3.getIdString();
        if (r4 == null) goto L10;
    L12:
        return Intrinsics.areEqual(r0, r4);
    L10:
        r4 = "";
        goto L12
    }

    public static boolean e(String r1) {
        Intrinsics.checkNotNullParameter(r1, "userId");
        return Intrinsics.areEqual(jc1.k.n(IMiddlewareUserService.class).user().n().toString(), r1);
    }
}
