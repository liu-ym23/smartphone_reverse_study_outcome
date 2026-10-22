package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge;

import com.bytedance.android.live.core.utils.StateMachine;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvChallengeStatusMachine {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static StateMachine a(final Function1 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        StateMachine.a r0 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<f, c, e>, Unit> r1 = new KtvChallengeStatusMachine$create$1(r2);
        r0.getClass();
        return StateMachine.a.a(r1);
    }
}
