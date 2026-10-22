package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lac0/a;", "data", "", "invoke", "(Lac0/a;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class KSongTuningButtonOuterCallback$checkEchoMode$1 extends Lambda implements Function1<ac0.a, Unit> {
    final /* synthetic */ Boolean $isWiredHeadsetConnected;
    final /* synthetic */ KSongTuningButtonOuterCallback this$0;

    public KSongTuningButtonOuterCallback$checkEchoMode$1(KSongTuningButtonOuterCallback r1, Boolean r2) {
        this.this$0 = r1;
        this.$isWiredHeadsetConnected = r2;
        super(1);
    }

    public final void invoke(ac0.a r5) {
        if (r5 == null) goto L9;
        if (Intrinsics.areEqual(this.$isWiredHeadsetConnected, Boolean.TRUE) == false) goto L6;
        float r0 = 1.0f;
    L7:
        r5.e = r0;
        goto L9
    L6:
        r0 = 0.5f;
    L9:
        if (this.this$0.e.v() == false) goto L15;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r1 = this.this$0.e;
        if (r5 == null) goto L13;
        boolean r6 = r5.c;
    L13:
        r1.k(false);
        return;
    L15:
        if (Intrinsics.areEqual(this.$isWiredHeadsetConnected, Boolean.TRUE) == false) goto L20;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r2 = this.this$0.e;
        if (r5 == null) goto L19;
        boolean r7 = r5.c;
    L19:
        r2.k(false);
        return;
    L20:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r3 = this.this$0.e;
        if (r5 == null) goto L23;
        boolean r8 = r5.c;
    L23:
        r3.k(false);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ac0.a) r1);
        return Unit.INSTANCE;
    }
}
