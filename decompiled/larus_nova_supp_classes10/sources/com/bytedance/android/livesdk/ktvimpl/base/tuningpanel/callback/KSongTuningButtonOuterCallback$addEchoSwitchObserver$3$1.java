package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lac0/a;", "data", "", "invoke", "(Lac0/a;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class KSongTuningButtonOuterCallback$addEchoSwitchObserver$3$1 extends Lambda implements Function1<ac0.a, Unit> {
    final /* synthetic */ Boolean $it;
    final /* synthetic */ b this$0;

    public KSongTuningButtonOuterCallback$addEchoSwitchObserver$3$1(b r1, Boolean r2) {
        this.this$0 = r1;
        this.$it = r2;
        super(1);
    }

    public final void invoke(ac0.a r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.this$0.getClass();
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ac0.a) r1);
        return Unit.INSTANCE;
    }
}
