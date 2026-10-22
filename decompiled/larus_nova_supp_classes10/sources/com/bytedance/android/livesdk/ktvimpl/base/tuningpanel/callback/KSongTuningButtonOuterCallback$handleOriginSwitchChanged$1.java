package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lac0/a;", "data", "", "invoke", "(Lac0/a;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class KSongTuningButtonOuterCallback$handleOriginSwitchChanged$1 extends Lambda implements Function1<ac0.a, Unit> {
    final /* synthetic */ KSongTuningButtonOuterCallback this$0;

    public KSongTuningButtonOuterCallback$handleOriginSwitchChanged$1(KSongTuningButtonOuterCallback r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(ac0.a r3) {
        if (r3 == null) goto L17;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.this$0.e;
        if (r0 != null) goto L6;
    L8:
        boolean r1 = false;
    L9:
        r3.c = r1;
        ec0.a r2 = this.this$0.f();
        if (r2 != null) goto L12;
    L14:
        float r4 = 0.5f;
    L15:
        r3.e = r4;
        return;
    L12:
        if (r2.g() != true) goto L14;
        r4 = 1.0f;
        goto L15
    L6:
        if (r0.R() != true) goto L8;
        r1 = true;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ac0.a) r1);
        return Unit.INSTANCE;
    }
}
