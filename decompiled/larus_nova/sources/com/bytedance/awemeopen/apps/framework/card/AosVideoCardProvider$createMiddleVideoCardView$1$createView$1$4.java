package com.bytedance.awemeopen.apps.framework.card;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.awemeopen.writtenlayout.IWrittenLayout;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/widget/RelativeLayout;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AosVideoCardProvider$createMiddleVideoCardView$1$createView$1$4 extends Lambda implements Function1<RelativeLayout, Unit> {
    final /* synthetic */ v44.a $cardConfig;
    final /* synthetic */ a this$0;

    public AosVideoCardProvider$createMiddleVideoCardView$1$createView$1$4(a r100, v44.a r101) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RelativeLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$relativeLayout");
        a r101 = this.this$0;
        AoImageView r102 = new AoImageView(r100.getContext());
        final a r103 = this.this$0;
        final v44.a r104 = null;
        Function1<RelativeLayout.LayoutParams, Unit> r105 = new AnonymousClass1(r103, r104);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        RelativeLayout.LayoutParams r106 = new RelativeLayout.LayoutParams(-1, -1);
        r105.invoke(r106);
        AnonymousClass2 r107 = AnonymousClass2.INSTANCE;
        r101.getClass();
        IWrittenLayout.a(r100, r102, r106, r107);
        a r108 = this.this$0;
        AoImageView r109 = new AoImageView(r100.getContext());
        final a r110 = this.this$0;
        Function1<RelativeLayout.LayoutParams, Unit> r111 = new AnonymousClass3(r110, r104);
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        RelativeLayout.LayoutParams r112 = new RelativeLayout.LayoutParams(-1, -1);
        r111.invoke(r112);
        AnonymousClass4 r113 = AnonymousClass4.INSTANCE;
        r108.getClass();
        IWrittenLayout.a(r100, r109, r112, r113);
        a r114 = this.this$0;
        ImageView r115 = new ImageView(r100.getContext());
        final a r116 = this.this$0;
        RelativeLayout.LayoutParams r117 = r116.x(r100, new AnonymousClass5(r116));
        AnonymousClass6 r118 = AnonymousClass6.INSTANCE;
        r114.getClass();
        IWrittenLayout.a(r100, r115, r117, r118);
        a r119 = this.this$0;
        ImageView r120 = new ImageView(r100.getContext());
        final a r121 = this.this$0;
        RelativeLayout.LayoutParams r122 = r121.x(r100, new AnonymousClass7(r121));
        AnonymousClass8 r123 = AnonymousClass8.INSTANCE;
        r119.getClass();
        IWrittenLayout.a(r100, r120, r122, r123);
        a r124 = this.this$0;
        TextView r125 = new TextView(r100.getContext());
        final a r126 = this.this$0;
        RelativeLayout.LayoutParams r127 = r126.x(r100, new AnonymousClass9(r126, r104));
        final a r128 = this.this$0;
        Function1<TextView, Unit> r129 = new AnonymousClass10(r104, r128);
        r124.getClass();
        IWrittenLayout.a(r100, r125, r127, r129);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RelativeLayout r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
