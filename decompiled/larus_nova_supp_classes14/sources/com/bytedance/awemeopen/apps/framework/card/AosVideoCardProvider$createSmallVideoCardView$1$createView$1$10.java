package com.bytedance.awemeopen.apps.framework.card;

import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/widget/LinearLayout;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AosVideoCardProvider$createSmallVideoCardView$1$createView$1$10 extends Lambda implements Function1<LinearLayout, Unit> {
    final /* synthetic */ y44.a $cardConfig;
    final /* synthetic */ b this$0;

    /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.card.AosVideoCardProvider$createSmallVideoCardView$1$createView$1$10$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/widget/LinearLayout$LayoutParams;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class AnonymousClass1 extends Lambda implements Function1<LinearLayout.LayoutParams, Unit> {
        final /* synthetic */ y44.a $cardConfig;
        final /* synthetic */ b this$0;

        public AnonymousClass1(b r1, y44.a r2) {
            this.this$0 = r1;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((LinearLayout.LayoutParams) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(LinearLayout.LayoutParams r2) {
            Intrinsics.checkNotNullParameter(r2, "$this$wrapLparams");
            throw null;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.card.AosVideoCardProvider$createSmallVideoCardView$1$createView$1$10$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/widget/TextView;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class AnonymousClass2 extends Lambda implements Function1<TextView, Unit> {
        final /* synthetic */ y44.a $cardConfig;

        public AnonymousClass2(y44.a r1) {
            super(1);
        }

        public final void invoke(TextView r2) {
            Intrinsics.checkNotNullParameter(r2, "$this$add");
            r2.setId(2131363060);
            throw null;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((TextView) r1);
            return Unit.INSTANCE;
        }
    }

    public AosVideoCardProvider$createSmallVideoCardView$1$createView$1$10(y44.a r1, b r2) {
        this.this$0 = r2;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((LinearLayout) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(LinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$linearLayout");
        throw null;
    }
}
