package com.bytedance.awemeopen.apps.framework.card;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/widget/RelativeLayout$LayoutParams;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AosVideoCardProvider$createSmallVideoCardView$1$createView$1$9 extends Lambda implements Function1<RelativeLayout.LayoutParams, Unit> {
    final /* synthetic */ b this$0;

    public AosVideoCardProvider$createSmallVideoCardView$1$createView$1$9(b r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RelativeLayout.LayoutParams r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$wrapLparams");
        this.this$0.getClass();
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        ((ViewGroup.LayoutParams) r100).width = -1;
        this.this$0.getClass();
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.addRule(5, R.id.aos_card_small_video_cover);
        this.this$0.getClass();
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.addRule(7, R.id.aos_card_small_video_cover);
        this.this$0.getClass();
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.addRule(8, R.id.aos_card_small_video_cover);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RelativeLayout.LayoutParams r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
