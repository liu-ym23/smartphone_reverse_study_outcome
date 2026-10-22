package com.bytedance.android.shopping.mall.homepage.card.common;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/common/HotTextContainerView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HotTextContainerView extends LinearLayout {
    public final HotTextView a;
    public final HotTextView b;
    public final HotTextView c;

    public HotTextContainerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public HotTextContainerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a(String r2) {
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        ToolsKt.w(this.c, r2);
        ToolsKt.w(this.b, r2);
        ToolsKt.w(this.a, r2);
        return;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.shopping.mall.homepage.card.common.HotTextView] */
    /* JADX WARN: Type inference failed for: r4v4, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.shopping.mall.homepage.card.common.HotTextView] */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.shopping.mall.homepage.card.common.HotTextView] */
    public HotTextContainerView(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r11);
        ?? r12 = new HotTextView(r9, null, 6, 0);
        r12.setTextSize(1, 10.0f);
        r12.setTextColor(ColorProtector.parseColor("#FFFFFF"));
        r12.setIncludeFontPadding(false);
        r12.setText("热卖");
        r12.x("DouyinSansBold.otf", 400);
        Unit r4 = Unit.INSTANCE;
        this.a = r12;
        ?? r5 = new HotTextView(r9, null, 6, 0);
        r5.setTextSize(1, 8.0f);
        r5.setTextColor(ColorProtector.parseColor("#FFFFFF"));
        r5.setIncludeFontPadding(false);
        r5.setText("x");
        r5.x("DouyinNumberABC-Bold", 500);
        this.b = r5;
        ?? r7 = new HotTextView(r9, null, 6, 0);
        r7.setTextSize(1, 11.0f);
        r7.setTextColor(ColorProtector.parseColor("#FFFFFF"));
        r7.setIncludeFontPadding(false);
        r7.x("DouyinNumberABC-Bold", 500);
        this.c = r7;
        setGravity(17);
        addView(r12, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(-2, -2);
        int r14 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r13.leftMargin = com.bytedance.android.ec.hybrid.list.util.c.d(2);
        r13.rightMargin = com.bytedance.android.ec.hybrid.list.util.c.d(2);
        addView(r5, r13);
        addView(r7, new LinearLayout.LayoutParams(-2, -2));
    }

    public /* synthetic */ HotTextContainerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
