package com.bytedance.android.shopping.commentfeed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.shopping.commentfeed.utils.CommentListViewModel;
import com.bytedance.android.shopping.utils.k0;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/widget/CommentItemDiggView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentItemDiggView extends LinearLayout {
    public final TextView a;
    public final ImageView b;
    public zb3.a c;
    public CommentListViewModel d;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.commentfeed.widget.CommentItemDiggView$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ CommentItemDiggView a;
        public final /* synthetic */ Context b;

        public AnonymousClass1(CommentItemDiggView r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r19) {
            CommentItemDiggView r0 = this.a;
            zb3.a r1 = r0.c;
            final boolean r8 = r1.b;
            final long r4 = r1.c;
            if (r8 == true) goto L5;
            final long r2 = 1;
        L6:
            String r3 = r1.a;
            if (r3 == null) goto L12;
            CommentListViewModel r6 = r0.d;
            if (r6 == null) goto L12;
            r6.diggCommentAction(new zb3.b(CastLongProtector.parseLong(r3), r2, r4), new CommentItemDiggView$1$$special$$inlined$let$lambda$1(this, r2, r4, r8));
        L12:
            CommentItemDiggView r5 = this.a;
            boolean r7 = !r8;
            if (r8 == false) goto L15;
            long r9 = r4 - 1;
        L16:
            r5.a(r7, r9);
            return;
        L15:
            r9 = r4 + 1;
            goto L16
        L5:
            r2 = 2;
            goto L6
        }
    }

    public CommentItemDiggView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CommentItemDiggView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a(boolean r3, long r4) {
        if (r3 == false) goto L4;
        this.b.setImageResource(2131234446);
    L6:
        if (r4 <= 0) goto L8;
        this.a.setText(k0.a(r4));
        return;
    L8:
        this.a.setText(th.a.f(getContext()).getString(2131914057));
        return;
    L4:
        this.b.setImageResource(2131234447);
        goto L6
    }

    public CommentItemDiggView(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10);
        this.c = new zb3.a(null, false, 0, 15);
        LayoutInflater.from(r8).inflate(2131560525, this);
        ImageView r11 = (ImageView) findViewById(2131370655);
        this.b = r11;
        this.a = (TextView) findViewById(2131370691);
        r11.setOnClickListener(new AnonymousClass1(this, r8));
    }

    public /* synthetic */ CommentItemDiggView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
