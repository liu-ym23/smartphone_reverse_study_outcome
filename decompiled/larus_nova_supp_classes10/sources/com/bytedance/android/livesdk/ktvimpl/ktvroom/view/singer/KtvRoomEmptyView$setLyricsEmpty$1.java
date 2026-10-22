package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer;

import com.bytedance.android.livesdk.ktvimpl.base.util.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/util/p;", "", "invoke", "(Lcom/bytedance/android/livesdk/ktvimpl/base/util/p;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class KtvRoomEmptyView$setLyricsEmpty$1 extends Lambda implements Function1<p, Unit> {
    final /* synthetic */ KtvRoomEmptyView this$0;

    public KtvRoomEmptyView$setLyricsEmpty$1(KtvRoomEmptyView r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(p r2) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        r2.b = 2;
        if (this.this$0.getVisibility() == 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        r2.a = r0;
        return;
    L5:
        if (this.this$0.isShown() == false) goto L7;
        r0 = true;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((p) r1);
        return Unit.INSTANCE;
    }
}
