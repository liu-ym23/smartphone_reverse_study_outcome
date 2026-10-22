package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits31;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ec.hybrid.a;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import gf3.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/cardview/legou/pits31/SinglePriceLabelView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lgf3/b;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SinglePriceLabelView extends AppCompatTextView implements b {
    public final int a;
    public final int b;

    public SinglePriceLabelView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SinglePriceLabelView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gf3.b
    public final View i() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gf3.b
    public final void s(ChannelVO r9, int r10) {
        SpannableStringBuilder r0 = new SpannableStringBuilder();
        int r1 = this.b;
        Typeface r2 = null;
        if (r9 == null) goto L5;
        Boolean r3 = Boolean.valueOf(r9.showItemPrice(r10));
    L6:
        if (r9 == null) goto L8;
        Boolean r4 = Boolean.valueOf(r9.showItemTag(r10));
    L9:
        Boolean r5 = Boolean.TRUE;
        if (Intrinsics.areEqual(r3, r5) == false) goto L12;
        r0.append("¥");
        r1 = this.a;
    L12:
        if (r9 == null) goto L14;
        String r11 = r9.getItemPriceOrTag(r10);
    L15:
        boolean r12 = true;
        if (r11 != null) goto L18;
    L21:
        boolean r7 = true;
    L22:
        if (r7 == false) goto L24;
        r0 = null;
    L34:
        if (r0 != null) goto L36;
    L39:
        if (r12 == true) goto L41;
        setText(r0);
        setVisibility(0);
        return;
    L41:
        setVisibility(8);
        return;
    L36:
        if (r0.length() == 0) goto L39;
        r12 = false;
        goto L39
    L24:
        r0.append(r11);
        r0.setSpan(new ForegroundColorSpan(r1), 0, r0.length(), 17);
        if (Build.VERSION.SDK_INT < 28) goto L34;
        if (Intrinsics.areEqual(r3, r5) == false) goto L30;
        a.c();
    L32:
        if (r2 == null) goto L34;
        r0.setSpan(new TypefaceSpan(r2), 0, r0.length(), 17);
        goto L34
    L30:
        if (Intrinsics.areEqual(r4, r5) == false) goto L32;
        r2 = Typeface.create(Typeface.create("PingFang SC", 0), 600, false);
        goto L32
    L18:
        if (r11.length() == 0) goto L21;
        r7 = false;
        goto L22
    L14:
        r11 = null;
        goto L15
    L8:
        r4 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SinglePriceLabelView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = ContextCompat.getColor(r2, 2131106126);
        this.b = ContextCompat.getColor(r2, 2131106115);
        setTextColor(ContextCompat.getColor(r2, 2131106126));
        a.c();
        setGravity(17);
    }

    public /* synthetic */ SinglePriceLabelView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
