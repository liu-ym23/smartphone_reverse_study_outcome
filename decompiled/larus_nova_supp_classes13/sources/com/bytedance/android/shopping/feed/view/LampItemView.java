package com.bytedance.android.shopping.feed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.widget.RoundedLinearLayout;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/shopping/feed/view/LampItemView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/core/widget/RoundedLinearLayout;", "a", "Lcom/bytedance/android/ec/core/widget/RoundedLinearLayout;", "getBuyAndCommentContainer", "()Lcom/bytedance/android/ec/core/widget/RoundedLinearLayout;", "buyAndCommentContainer", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "b", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "getUserAvatarImage", "()Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "userAvatarImage", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "getUserNameArea", "()Landroid/widget/TextView;", "userNameArea", "d", "getBuyOrCommentArea", "buyOrCommentArea", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LampItemView extends FrameLayout {
    public final RoundedLinearLayout a;
    public final ECDraweeView b;
    public final TextView c;
    public final TextView d;

    public LampItemView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LampItemView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final RoundedLinearLayout getBuyAndCommentContainer() {
        return this.a;
    }

    public final TextView getBuyOrCommentArea() {
        return this.d;
    }

    public final ECDraweeView getUserAvatarImage() {
        return this.b;
    }

    public final TextView getUserNameArea() {
        return this.c;
    }

    public LampItemView(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r8);
        if (ld3.b.a() == false) goto L5;
        Map r9 = ShoppingAsyncCacheInflater.d;
        ShoppingAsyncCacheInflater.a.a(r6).aU(2131564842, this, true);
    L6:
        RoundedLinearLayout r10 = findViewById(2131365070);
        this.a = r10;
        ECDraweeView r11 = findViewById(2131392001);
        this.b = r11;
        TextView r12 = (TextView) findViewById(2131392050);
        this.c = r12;
        TextView r0 = (TextView) findViewById(2131365072);
        this.d = r0;
        ViewGroup.LayoutParams r13 = r11.getLayoutParams();
        if (r13 == null) goto L11;
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r13;
        r14.width = com.bytedance.android.shopping.extensions.b.b(22);
        r14.height = com.bytedance.android.shopping.extensions.b.b(22);
        r14.setMargins(com.bytedance.android.shopping.extensions.b.b(2), com.bytedance.android.shopping.extensions.b.b(2), com.bytedance.android.shopping.extensions.b.b(2), com.bytedance.android.shopping.extensions.b.b(2));
        wg.a.g(r12, 13);
        wg.a.g(r0, 13);
        r10.setRadius(com.bytedance.android.shopping.extensions.b.b(24));
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L5:
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r6).aU(2131564842, this, true);
        goto L6
    }

    public /* synthetic */ LampItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
