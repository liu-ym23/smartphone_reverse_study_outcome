package com.bytedance.awemeopen.apps.framework.card;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.awemeopen.writtenlayout.IWrittenLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/widget/LinearLayout;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AosVideoCardProvider$createMiddleVideoCardView$1$createView$1$6 extends Lambda implements Function1<LinearLayout, Unit> {
    final /* synthetic */ v44.a $cardConfig;
    final /* synthetic */ a this$0;

    public AosVideoCardProvider$createMiddleVideoCardView$1$createView$1$6(a r1, v44.a r2) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(LinearLayout r8) {
        Intrinsics.checkNotNullParameter(r8, "$this$linearLayout");
        r8.setGravity(16);
        a r0 = this.this$0;
        TextView r2 = new TextView(r8.getContext());
        final a r3 = this.this$0;
        final v44.a r5 = null;
        LinearLayout.LayoutParams r4 = r3.w(r8, new AnonymousClass1(r3, r5));
        final a r6 = this.this$0;
        Function1<TextView, Unit> r7 = new AnonymousClass2(r6, r5);
        r0.getClass();
        IWrittenLayout.b(r8, 2131363045, r2, r4, r7);
        a r1 = this.this$0;
        TextView r9 = new TextView(r8.getContext());
        final a r10 = this.this$0;
        LinearLayout.LayoutParams r11 = r10.w(r8, new AnonymousClass3(r10, r5));
        final a r12 = this.this$0;
        Function1<TextView, Unit> r13 = new AnonymousClass4(r12, r5);
        r1.getClass();
        IWrittenLayout.b(r8, 2131363048, r9, r11, r13);
        a r14 = this.this$0;
        TextView r15 = new TextView(r8.getContext());
        LinearLayout.LayoutParams r16 = this.this$0.w(r8, null);
        final a r17 = this.this$0;
        Function1<TextView, Unit> r18 = new AnonymousClass5(r17, r5);
        r14.getClass();
        IWrittenLayout.b(r8, 2131363053, r15, r16, r18);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((LinearLayout) r1);
        return Unit.INSTANCE;
    }
}
