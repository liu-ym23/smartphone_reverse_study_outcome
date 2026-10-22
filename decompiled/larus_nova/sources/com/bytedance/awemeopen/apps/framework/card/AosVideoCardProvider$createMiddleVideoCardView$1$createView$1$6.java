package com.bytedance.awemeopen.apps.framework.card;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.awemeopen.writtenlayout.IWrittenLayout;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/widget/LinearLayout;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AosVideoCardProvider$createMiddleVideoCardView$1$createView$1$6 extends Lambda implements Function1<LinearLayout, Unit> {
    final /* synthetic */ v44.a $cardConfig;
    final /* synthetic */ a this$0;

    public AosVideoCardProvider$createMiddleVideoCardView$1$createView$1$6(a r100, v44.a r101) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LinearLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$linearLayout");
        r100.setGravity(16);
        a r101 = this.this$0;
        Integer r102 = Integer.valueOf(R.id.aos_card_middle_video_author_name);
        TextView r103 = new TextView(r100.getContext());
        final a r104 = this.this$0;
        final v44.a r105 = null;
        LinearLayout.LayoutParams r106 = r104.w(r100, new AnonymousClass1(r104, r105));
        final a r107 = this.this$0;
        Function1<TextView, Unit> r108 = new AnonymousClass2(r107, r105);
        r101.getClass();
        IWrittenLayout.b(r100, r102, r103, r106, r108);
        a r109 = this.this$0;
        Integer r110 = Integer.valueOf(R.id.aos_card_middle_video_comment_or_praise_count);
        TextView r111 = new TextView(r100.getContext());
        final a r112 = this.this$0;
        LinearLayout.LayoutParams r113 = r112.w(r100, new AnonymousClass3(r112, r105));
        final a r114 = this.this$0;
        Function1<TextView, Unit> r115 = new AnonymousClass4(r114, r105);
        r109.getClass();
        IWrittenLayout.b(r100, r110, r111, r113, r115);
        a r116 = this.this$0;
        Integer r117 = Integer.valueOf(R.id.aos_card_middle_video_publish_time);
        TextView r118 = new TextView(r100.getContext());
        LinearLayout.LayoutParams r119 = this.this$0.w(r100, null);
        final a r120 = this.this$0;
        Function1<TextView, Unit> r121 = new AnonymousClass5(r120, r105);
        r116.getClass();
        IWrittenLayout.b(r100, r117, r118, r119, r121);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(LinearLayout r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
