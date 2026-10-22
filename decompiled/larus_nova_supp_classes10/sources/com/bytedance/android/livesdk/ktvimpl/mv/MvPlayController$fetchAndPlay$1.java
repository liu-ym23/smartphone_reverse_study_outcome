package com.bytedance.android.livesdk.ktvimpl.mv;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/mv/l;", "it", "", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "invoke", "(Lcom/bytedance/android/livesdk/ktvimpl/mv/l;ILjava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class MvPlayController$fetchAndPlay$1 extends Lambda implements Function3<l, Integer, String, Unit> {
    final /* synthetic */ MvPlayController this$0;

    public MvPlayController$fetchAndPlay$1(MvPlayController r1) {
        this.this$0 = r1;
        super(3);
    }

    public final void invoke(l r3, int r4, String r5) {
        if (r3 != null) goto L5;
        com.bytedance.android.live.ktv.common.util.g.c("get mvInfo fail is null");
        return;
    L5:
        Intrinsics.checkNotNullParameter("startPlayForSinger", "<set-?>");
        r3.k = "startPlayForSinger";
        Function0<y> r6 = this.this$0.p;
        if (r6 == null) goto L14;
        y r7 = (y) r6.invoke();
        if (r7 == null) goto L14;
        this.this$0.getClass();
        if (MvPlayController.b(r7, r3) == true) goto L14;
        com.bytedance.android.live.ktv.common.util.g.c("checkMvInfoValid fail," + r3);
        return;
    L14:
        if (MvPlayController.e(this.this$0, r3, false, r3.i, 1) != true) goto L19;
        Function1<? super String, Unit> r8 = this.this$0.k;
        if (r8 == null) goto L20;
        Unit r9 = (Unit) r8.invoke(r3.d);
        return;
    L20:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((l) r1, ((Number) r2).intValue(), (String) r3);
        return Unit.INSTANCE;
    }
}
