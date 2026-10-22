package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ec.core.utils.a2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/FollowGiftBubbleView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/bytedance/android/ec/store/common/bubble/d;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FollowGiftBubbleView extends AppCompatTextView implements com.bytedance.android.ec.store.common.bubble.d {
    public static final int d = 0;
    public static final int e = 0;
    public String a;
    public String b;
    public String c;

    public static final class a {
    }

    public FollowGiftBubbleView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FollowGiftBubbleView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    static {
        d = com.bytedance.android.shopping.extensions.b.b(10);
        e = com.bytedance.android.shopping.extensions.b.b(14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b() {
        if (this.a != null) goto L5;
        return;
    L5:
        if (this.b != null) goto L7;
        return;
    L7:
        if (this.c == null) goto L38;
        setVisibility(0);
        ViewGroup.LayoutParams r0 = getLayoutParams();
        String r2 = null;
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == true) goto L12;
        r0 = null;
    L12:
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        if (r1 == null) goto L15;
        r1.topMargin = com.bytedance.android.shopping.extensions.b.b(-13);
        r1.setMarginEnd(r1.rightMargin);
        requestLayout();
    L15:
        setText(this.a);
        String r3 = this.b;
        if (r3 != null) goto L18;
    L23:
        String r4 = this.c;
        if (r4 != null) goto L26;
        return;
    L26:
        if (a2.b(r4) == false) goto L28;
        r2 = r4;
    L28:
        if (r2 == null) goto L36;
        Drawable r5 = getBackground();
        if (r5 == null) goto L37;
        r5.setColorFilter(com.bytedance.android.ec.core.utils.s.a(r2, 16711760), PorterDuff.Mode.SRC_ATOP);
        return;
    L37:
        return;
    L36:
        return;
    L18:
        if (a2.b(r3) == true) goto L21;
        r3 = null;
    L21:
        if (r3 == null) goto L23;
        setTextColor(com.bytedance.android.ec.core.utils.s.a(r3, 16777215));
        goto L23
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y() {
        ViewParent r0 = getParent();
        if ((r0 instanceof ViewGroup) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L9;
        r1.removeView(this);
        return;
    }

    public FollowGiftBubbleView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x(String r2, String r3, String r4) {
        this.a = r2;
        this.b = r3;
        this.c = r4;
        setBackground(th.a.b(getContext(), 2131234788));
        setEllipsize(TextUtils.TruncateAt.END);
        setGravity(17);
        setIncludeFontPadding(false);
        setMaxLines(1);
        setPadding(com.bytedance.android.shopping.extensions.b.b(6), 0, com.bytedance.android.shopping.extensions.b.b(6), 0);
        setTextSize(1, 10.0f);
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextColor(th.a.a(getContext(), 2131105908));
    }

    public /* synthetic */ FollowGiftBubbleView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
