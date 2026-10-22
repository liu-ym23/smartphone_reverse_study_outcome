package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui;

import android.view.View;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface a {
    void c(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r1);

    boolean d();

    void e(View r1, Function1<? super Boolean, Unit> r2);

    void g(KtvRoomChallengeProgressView r1, View r2, View r3, Function1<? super Boolean, Unit> r4);

    void h(UserAttr r1);

    void onDestroy();
}
