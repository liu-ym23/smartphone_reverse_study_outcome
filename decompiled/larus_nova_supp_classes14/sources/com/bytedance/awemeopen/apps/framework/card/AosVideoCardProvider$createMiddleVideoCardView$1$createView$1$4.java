package com.bytedance.awemeopen.apps.framework.card;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.awemeopen.writtenlayout.IWrittenLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/widget/RelativeLayout;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AosVideoCardProvider$createMiddleVideoCardView$1$createView$1$4 extends Lambda implements Function1<RelativeLayout, Unit> {
    final /* synthetic */ v44.a $cardConfig;
    final /* synthetic */ a this$0;

    public AosVideoCardProvider$createMiddleVideoCardView$1$createView$1$4(a r1, v44.a r2) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(RelativeLayout r8) {
        Intrinsics.checkNotNullParameter(r8, "$this$relativeLayout");
        a r0 = this.this$0;
        AoImageView r1 = new AoImageView(r8.getContext());
        final a r2 = this.this$0;
        final v44.a r4 = null;
        Function1<RelativeLayout.LayoutParams, Unit> r3 = new AnonymousClass1(r2, r4);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r8, "$receiver");
        RelativeLayout.LayoutParams r5 = new RelativeLayout.LayoutParams(-1, -1);
        r3.invoke(r5);
        AnonymousClass2 r6 = AnonymousClass2.INSTANCE;
        r0.getClass();
        IWrittenLayout.a(r8, r1, r5, r6);
        a r7 = this.this$0;
        AoImageView r9 = new AoImageView(r8.getContext());
        final a r10 = this.this$0;
        Function1<RelativeLayout.LayoutParams, Unit> r11 = new AnonymousClass3(r10, r4);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r8, "$receiver");
        RelativeLayout.LayoutParams r12 = new RelativeLayout.LayoutParams(-1, -1);
        r11.invoke(r12);
        AnonymousClass4 r13 = AnonymousClass4.INSTANCE;
        r7.getClass();
        IWrittenLayout.a(r8, r9, r12, r13);
        a r14 = this.this$0;
        ImageView r15 = new ImageView(r8.getContext());
        final a r16 = this.this$0;
        RelativeLayout.LayoutParams r17 = r16.x(r8, new AnonymousClass5(r16));
        AnonymousClass6 r18 = AnonymousClass6.INSTANCE;
        r14.getClass();
        IWrittenLayout.a(r8, r15, r17, r18);
        a r19 = this.this$0;
        ImageView r20 = new ImageView(r8.getContext());
        final a r21 = this.this$0;
        RelativeLayout.LayoutParams r22 = r21.x(r8, new AnonymousClass7(r21));
        AnonymousClass8 r23 = AnonymousClass8.INSTANCE;
        r19.getClass();
        IWrittenLayout.a(r8, r20, r22, r23);
        a r24 = this.this$0;
        TextView r25 = new TextView(r8.getContext());
        final a r26 = this.this$0;
        RelativeLayout.LayoutParams r27 = r26.x(r8, new AnonymousClass9(r26, r4));
        final a r28 = this.this$0;
        Function1<TextView, Unit> r29 = new AnonymousClass10(r4, r28);
        r24.getClass();
        IWrittenLayout.a(r8, r25, r27, r29);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((RelativeLayout) r1);
        return Unit.INSTANCE;
    }
}
