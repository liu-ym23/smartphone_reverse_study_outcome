package com.bytedance.awemeopen.apps.framework.card;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/widget/LinearLayout;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AosVideoCardProvider$createSmallVideoCardView$1$createView$1$10 extends Lambda implements Function1<LinearLayout, Unit> {
    final /* synthetic */ y44.a $cardConfig;
    final /* synthetic */ b this$0;

    /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.card.AosVideoCardProvider$createSmallVideoCardView$1$createView$1$10$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/widget/LinearLayout$LayoutParams;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class AnonymousClass1 extends Lambda implements Function1<LinearLayout.LayoutParams, Unit> {
        final /* synthetic */ y44.a $cardConfig;
        final /* synthetic */ b this$0;

        public AnonymousClass1(b r100, y44.a r101) {
            this.this$0 = r100;
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LinearLayout.LayoutParams r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LinearLayout.LayoutParams r100) {
            Intrinsics.checkNotNullParameter(r100, "$this$wrapLparams");
            throw null;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.card.AosVideoCardProvider$createSmallVideoCardView$1$createView$1$10$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/widget/TextView;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class AnonymousClass2 extends Lambda implements Function1<TextView, Unit> {
        final /* synthetic */ y44.a $cardConfig;

        public AnonymousClass2(y44.a r100) {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView r100) {
            Intrinsics.checkNotNullParameter(r100, "$this$add");
            r100.setId(R.id.aos_card_small_video_title);
            throw null;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    public AosVideoCardProvider$createSmallVideoCardView$1$createView$1$10(y44.a r100, b r101) {
        this.this$0 = r101;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(LinearLayout r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LinearLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$linearLayout");
        throw null;
    }
}
