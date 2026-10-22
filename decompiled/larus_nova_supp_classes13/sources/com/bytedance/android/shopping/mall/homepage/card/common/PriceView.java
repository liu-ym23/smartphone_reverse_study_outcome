package com.bytedance.android.shopping.mall.homepage.card.common;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB\u001d\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fB%\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/common/PriceView;", "Landroid/widget/LinearLayout;", "", "colorString", "", "setColorRedValue", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PriceView extends LinearLayout {
    public int a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;

    public PriceView(Context r10) {
        super(r10);
        Lazy r11 = HybridAppInfoService.a;
        if (HybridAppInfoService.m() == false) goto L5;
        String r12 = "#FE496A";
    L6:
        this.a = ColorProtector.parseColor(r12);
        TextView r13 = new TextView(getContext());
        r13.setTextColor(this.a);
        r13.setTextSize(1, 13.0f);
        r13.setIncludeFontPadding(false);
        r13.setMaxLines(1);
        r13.setEllipsize(TextUtils.TruncateAt.END);
        Unit r3 = Unit.INSTANCE;
        this.b = r13;
        TextView r4 = new TextView(getContext());
        r4.setTextColor(this.a);
        r4.setTextSize(1, 18.0f);
        r4.setIncludeFontPadding(false);
        r4.setMaxLines(1);
        r4.setEllipsize(TextUtils.TruncateAt.END);
        this.c = r4;
        TextView r5 = new TextView(getContext());
        r5.setTextColor(this.a);
        r5.setTextSize(1, 13.0f);
        r5.setIncludeFontPadding(false);
        r5.setMaxLines(1);
        r5.setEllipsize(TextUtils.TruncateAt.END);
        this.d = r5;
        TextView r1 = new TextView(getContext());
        r1.setTextColor(this.a);
        r1.setTextSize(1, 11.0f);
        r1.setIncludeFontPadding(false);
        r1.setMaxLines(1);
        r1.setEllipsize(TextUtils.TruncateAt.END);
        this.e = r1;
        TextView r6 = new TextView(getContext());
        r6.setTextColor(this.a);
        r6.setTextSize(1, 11.0f);
        r6.setIncludeFontPadding(false);
        r6.setMaxLines(1);
        r6.setEllipsize(TextUtils.TruncateAt.END);
        this.f = r6;
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(-2, -2);
        r7.bottomMargin = b0.c(1);
        addView(r13, r7);
        LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(-2, -2);
        r14.setMargins(b0.c(1), 0, 0, 0);
        addView(r4, r14);
        LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(-2, -2);
        r15.bottomMargin = b0.c(1);
        addView(r5, r15);
        LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(-2, -2);
        r16.setMargins(b0.c(1), 0, 0, b0.c(1));
        addView(r1, r16);
        LinearLayout.LayoutParams r17 = new LinearLayout.LayoutParams(-2, -2);
        r17.setMargins(b0.c(4), 0, b0.c(7), b0.c(1));
        addView(r6, r17);
        return;
    L5:
        r12 = "#FF002A";
        goto L6
    }

    public final void setColorRedValue(String r4) {
        Intrinsics.checkNotNullParameter(r4, "colorString");
        this.a = Color.parseColor(r4);     // Catch: Exception -> L5
    L7:
        this.b.setTextColor(this.a);
        this.c.setTextColor(this.a);
        this.d.setTextColor(this.a);
        this.e.setTextColor(this.a);
        this.f.setTextColor(this.a);
        return;
    L5:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "an error occurs when parsing color " + r4);
        goto L7
    }

    public PriceView(Context r9, AttributeSet r10) {
        super(r9, r10);
        Lazy r11 = HybridAppInfoService.a;
        if (HybridAppInfoService.m() == false) goto L5;
        String r12 = "#FE496A";
    L6:
        this.a = ColorProtector.parseColor(r12);
        TextView r13 = new TextView(getContext());
        r13.setTextColor(this.a);
        r13.setTextSize(1, 13.0f);
        r13.setIncludeFontPadding(false);
        r13.setMaxLines(1);
        r13.setEllipsize(TextUtils.TruncateAt.END);
        Unit r2 = Unit.INSTANCE;
        this.b = r13;
        TextView r3 = new TextView(getContext());
        r3.setTextColor(this.a);
        r3.setTextSize(1, 18.0f);
        r3.setIncludeFontPadding(false);
        r3.setMaxLines(1);
        r3.setEllipsize(TextUtils.TruncateAt.END);
        this.c = r3;
        TextView r4 = new TextView(getContext());
        r4.setTextColor(this.a);
        r4.setTextSize(1, 13.0f);
        r4.setIncludeFontPadding(false);
        r4.setMaxLines(1);
        r4.setEllipsize(TextUtils.TruncateAt.END);
        this.d = r4;
        TextView r0 = new TextView(getContext());
        r0.setTextColor(this.a);
        r0.setTextSize(1, 11.0f);
        r0.setIncludeFontPadding(false);
        r0.setMaxLines(1);
        r0.setEllipsize(TextUtils.TruncateAt.END);
        this.e = r0;
        TextView r5 = new TextView(getContext());
        r5.setTextColor(this.a);
        r5.setTextSize(1, 11.0f);
        r5.setIncludeFontPadding(false);
        r5.setMaxLines(1);
        r5.setEllipsize(TextUtils.TruncateAt.END);
        this.f = r5;
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(-2, -2);
        r6.bottomMargin = b0.c(1);
        addView(r13, r6);
        LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(-2, -2);
        r14.setMargins(b0.c(1), 0, 0, 0);
        addView(r3, r14);
        LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(-2, -2);
        r15.bottomMargin = b0.c(1);
        addView(r4, r15);
        LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(-2, -2);
        r16.setMargins(b0.c(1), 0, 0, b0.c(1));
        addView(r0, r16);
        LinearLayout.LayoutParams r17 = new LinearLayout.LayoutParams(-2, -2);
        r17.setMargins(b0.c(4), 0, b0.c(7), b0.c(1));
        addView(r5, r17);
        return;
    L5:
        r12 = "#FF002A";
        goto L6
    }

    public PriceView(Context r8, AttributeSet r9, int r10) {
        super(r8, r9, r10);
        Lazy r11 = HybridAppInfoService.a;
        if (HybridAppInfoService.m() == false) goto L5;
        String r12 = "#FE496A";
    L6:
        this.a = ColorProtector.parseColor(r12);
        TextView r13 = new TextView(getContext());
        r13.setTextColor(this.a);
        r13.setTextSize(1, 13.0f);
        r13.setIncludeFontPadding(false);
        r13.setMaxLines(1);
        r13.setEllipsize(TextUtils.TruncateAt.END);
        Unit r1 = Unit.INSTANCE;
        this.b = r13;
        TextView r2 = new TextView(getContext());
        r2.setTextColor(this.a);
        r2.setTextSize(1, 18.0f);
        r2.setIncludeFontPadding(false);
        r2.setMaxLines(1);
        r2.setEllipsize(TextUtils.TruncateAt.END);
        this.c = r2;
        TextView r3 = new TextView(getContext());
        r3.setTextColor(this.a);
        r3.setTextSize(1, 13.0f);
        r3.setIncludeFontPadding(false);
        r3.setMaxLines(1);
        r3.setEllipsize(TextUtils.TruncateAt.END);
        this.d = r3;
        TextView r14 = new TextView(getContext());
        r14.setTextColor(this.a);
        r14.setTextSize(1, 11.0f);
        r14.setIncludeFontPadding(false);
        r14.setMaxLines(1);
        r14.setEllipsize(TextUtils.TruncateAt.END);
        this.e = r14;
        TextView r4 = new TextView(getContext());
        r4.setTextColor(this.a);
        r4.setTextSize(1, 11.0f);
        r4.setIncludeFontPadding(false);
        r4.setMaxLines(1);
        r4.setEllipsize(TextUtils.TruncateAt.END);
        this.f = r4;
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(-2, -2);
        r5.bottomMargin = b0.c(1);
        addView(r13, r5);
        LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(-2, -2);
        r15.setMargins(b0.c(1), 0, 0, 0);
        addView(r2, r15);
        LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(-2, -2);
        r16.bottomMargin = b0.c(1);
        addView(r3, r16);
        LinearLayout.LayoutParams r17 = new LinearLayout.LayoutParams(-2, -2);
        r17.setMargins(b0.c(1), 0, 0, b0.c(1));
        addView(r14, r17);
        LinearLayout.LayoutParams r18 = new LinearLayout.LayoutParams(-2, -2);
        r18.setMargins(b0.c(4), 0, b0.c(7), b0.c(1));
        addView(r4, r18);
        return;
    L5:
        r12 = "#FF002A";
        goto L6
    }
}
