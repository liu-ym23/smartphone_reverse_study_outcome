package com.bytedance.awemeopen.apps.framework.card;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/widget/RelativeLayout$LayoutParams;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AosVideoCardProvider$createMiddleVideoCardView$1$createView$1$3 extends Lambda implements Function1<RelativeLayout.LayoutParams, Unit> {
    final /* synthetic */ v44.a $cardConfig;
    final /* synthetic */ a this$0;

    public AosVideoCardProvider$createMiddleVideoCardView$1$createView$1$3(a r1, v44.a r2) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(RelativeLayout.LayoutParams r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$matchLparams");
        this.this$0.getClass();
        Intrinsics.checkNotNullParameter(r4, "$receiver");
        ((ViewGroup.LayoutParams) r4).width = -2;
        this.this$0.getClass();
        Intrinsics.checkNotNullParameter(r4, "$receiver");
        ((ViewGroup.LayoutParams) r4).height = -2;
        this.this$0.getClass();
        Intrinsics.checkNotNullParameter(r4, "$receiver");
        r4.addRule(3, 2131363054);
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((RelativeLayout.LayoutParams) r1);
        return Unit.INSTANCE;
    }
}
