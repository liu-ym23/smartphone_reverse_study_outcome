package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits31;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ec.hybrid.a;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/cardview/legou/pits31/MiaoShaPriceLabelView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiaoShaPriceLabelView extends LinearLayout {
    public final int a;
    public final int b;
    public final AppCompatTextView c;

    public MiaoShaPriceLabelView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MiaoShaPriceLabelView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a(String r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        SpannableStringBuilder r0 = new SpannableStringBuilder();
        r0.append("¥");
        boolean r3 = false;
        r0.setSpan(new AbsoluteSizeSpan(this.a), 0, r0.length(), 17);
        if (r6.length() != 0) goto L7;
        r3 = true;
    L7:
        if (r3 == false) goto L9;
        return;
    L9:
        r0.append(r6);
        r0.setSpan(new AbsoluteSizeSpan(this.b), 1, r0.length(), 17);
        this.c.setText(r0);
    }

    public MiaoShaPriceLabelView(Context r13, AttributeSet r14, int r15) {
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14, r15);
        SimpleDraweeView r16 = new SimpleDraweeView(r13);
        r16.setBackground(ContextCompat.getDrawable(r13, 2131248028));
        Unit r0 = Unit.INSTANCE;
        int r1 = c.a;
        this.a = c.c(10, r13, true);
        this.b = c.c(13, r13, true);
        AppCompatTextView r3 = new AppCompatTextView(r13);
        r3.setTextColor(ContextCompat.getColor(r13, 2131106126));
        a.c();
        r3.setPadding(c.c(1, r13, true), 0, c.c(1, r13, true), 0);
        this.c = r3;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        setOrientation(0);
        setGravity(16);
        setPaddingRelative(c.c(4, r13, true), 0, c.c(10, r13, true), 0);
        Drawable r2 = new BackgroundDrawable(r13, r14, false, 4, null);
        r2.setBgColor(ColorProtector.parseColor("#FFF4ED"));
        r2.setStrokeWidth(c.c(Double.valueOf(0.5d), r13, true));
        r2.setCornerRadius(c.c(100, r13, true));
        r2.invalidate();
        setBackground(r2);
        addView(r16, new LinearLayout.LayoutParams(-2, -2));
        addView(r3, new LinearLayout.LayoutParams(-2, -2));
    }

    public /* synthetic */ MiaoShaPriceLabelView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
