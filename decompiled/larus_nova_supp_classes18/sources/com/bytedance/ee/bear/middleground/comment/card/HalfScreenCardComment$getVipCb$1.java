package com.bytedance.ee.bear.middleground.comment.card;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class HalfScreenCardComment$getVipCb$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ HalfScreenCardComment this$0;

    public HalfScreenCardComment$getVipCb$1(HalfScreenCardComment r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(String r5) {
        if (r5 == null) goto L5;
        HalfScreenCardComment r0 = this.this$0;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).B7(r0.a.getActivity(), r5);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
