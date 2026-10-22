package com.bytedance.android.shopping.mall.homepage.card.product;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/product/BreakLineFeedText;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "text", "", "setTextBySelf", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BreakLineFeedText extends AppCompatTextView {
    public CharSequence a;
    public boolean b;
    public final float[] c;
    public final SpannableStringBuilder d;
    public boolean e;
    public boolean f;
    public final int g;

    public static final class a {
    }

    static {
    }

    public BreakLineFeedText(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.c = new float[]{0.0f};
        this.d = new SpannableStringBuilder();
        this.f = true;
        this.g = -1;
        if (this.a != null) goto L6;
        this.a = "";
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setTextBySelf(CharSequence r2) {
        this.b = true;
        setText(r2);
        this.b = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super/*android.widget.TextView*/.onDraw(r2);
    }

    public BreakLineFeedText(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.c = new float[]{0.0f};
        this.d = new SpannableStringBuilder();
        this.f = true;
        this.g = -1;
        if (this.a != null) goto L6;
        this.a = "";
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r23, int r24) {
        if (this.e == true) goto L6;
        super.onMeasure(r23, r24);
        return;
    L6:
        int r1 = getLayoutParams().width;
        super.onMeasure(r23, r24);
        CharSequence r2 = getText();
        SpannableStringBuilder r3 = new SpannableStringBuilder();
        int r4 = 0;
        int r5 = 0;
    L8:
        if (r5 >= r2.length()) goto L13;
        char r6 = r2.charAt(r5);
        if (r6 == '\n') goto L12;
        r3.append(r6);
    L12:
        r5 = r5 + 1;
        goto L8
    L13:
        CharSequence r7 = this.a;
        if (r7 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("fullText");
    L16:
        int r8 = 1;
        if (StringsKt.startsWith$default(r7, r3, false, 2, null) == true) goto L19;
    L21:
        getLayoutParams().width = getMeasuredWidth();
        float r9 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        this.d.clear();
        this.d.clearSpans();
        int r10 = TextViewCompat.getMaxLines(this);
        int r11 = 0;
        int r15 = 0;
    L22:
        if (r11 >= r10) goto L88;
        if (r11 != 0) goto L35;
        CharSequence r14 = this.a;
        if (r14 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("fullText");
    L27:
        float r12 = 0.0f;
        if ((r14 instanceof Spanned) == false) goto L34;
        Object[] r13 = ((Spanned) r14).getSpans(r4, r14.length(), ReplacementSpan.class);
        int r16 = r13.length;
        int r17 = 0;
        float r18 = 0.0f;
    L31:
        if (r17 >= r16) goto L33;
        ReplacementSpan r19 = (ReplacementSpan) r13[r17];
        Spanned r110 = (Spanned) r14;
        int r20 = r17;
        CharSequence r111 = r14;
        r18 = r18 + r19.getSize(getPaint(), r111, r110.getSpanStart(r19), r110.getSpanEnd(r19), getPaint().getFontMetricsInt());
        r17 = r20 + 1;
        r13 = r13;
        r14 = r14;
        r16 = r16;
        goto L31
    L33:
        r12 = r18;
    L34:
        float r112 = r9 - r12;
    L36:
        CharSequence r113 = this.a;
        if (r113 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("fullText");
    L39:
        CharSequence r25 = r113;
        int r21 = r15;
        int r22 = getPaint().breakText(r113, r15, r113.length(), true, r112, this.c) + r21;
        if (r22 >= r25.length()) goto L48;
        float r114 = this.c[r4];
    L43:
        if (r22 >= r25.length()) goto L48;
        int r115 = r22 + 1;
        CharSequence r116 = r25;
        r114 = r114 + getPaint().measureText(r116, r22, r115);
        if (r114 > r112) goto L48;
        r22 = r115;
        r25 = r116;
    L48:
        if (r10 != r8) goto L66;
        int r117 = r22 + 1;
        CharSequence r118 = this.a;
        if (r118 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("fullText");
    L53:
        if (r117 >= r118.length()) goto L66;
        CharSequence r119 = this.a;
        if (r119 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("fullText");
    L57:
        char r120 = r119.charAt(r22);
        if (19968 <= r120) goto L61;
    L63:
        boolean r121 = false;
    L64:
        if (r121 == false) goto L66;
        r15 = r117;
    L67:
        SpannableStringBuilder r26 = this.d;
        CharSequence r122 = this.a;
        if (r122 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("fullText");
    L70:
        CharSequence r27 = r122.subSequence(r21, r15);
        r26.append(r27);
        if ((r27 instanceof Spanned) == false) goto L75;
        int r123 = r26.length();
        int r124 = r123 - r27.length();
        Object[] r125 = r26.getSpans(r124, r123, Object.class);
        int r126 = r125.length;
        int r127 = 0;
    L73:
        if (r127 >= r126) goto L75;
        Object r128 = r125[r127];
        r26.removeSpan(r128);
        Spanned r28 = (Spanned) r27;
        int r129 = r28.getSpanStart(r128);
        int r29 = r129 + r124;
        float r130 = r9;
        r26.setSpan(r128, r29, r28.getSpanEnd(r128) + r124, r28.getSpanFlags(r128));
        r127 = r127 + 1;
        r9 = r130;
    L75:
        float r131 = r9;
        CharSequence r30 = this.a;
        if (r30 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("fullText");
    L79:
        if (r15 >= r30.length()) goto L88;
        r11 = r11 + 1;
        if (r10 <= 1) goto L87;
        if (this.f == false) goto L87;
        this.d.append('\n');
        ForegroundColorSpan r31 = new ForegroundColorSpan(this.g);
        SpannableStringBuilder r32 = this.d;
        r32.setSpan(r31, r32.length() - 1, this.d.length(), 33);
    L87:
        r9 = r131;
        r4 = 0;
        r8 = 1;
        goto L22
    L61:
        if (40959 < r120) goto L63;
        r121 = true;
    L66:
        r15 = r22;
        goto L67
    L35:
        r112 = r9;
    L88:
        setTextBySelf(this.d);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), r24);
        getLayoutParams().width = r1;
        return;
    L19:
        if ((!Intrinsics.areEqual(getText().toString(), r3.toString())) == false) goto L21;
    }

    public BreakLineFeedText(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = new float[]{0.0f};
        this.d = new SpannableStringBuilder();
        this.f = true;
        this.g = -1;
        if (this.a != null) goto L6;
        this.a = "";
        return;
    }

    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        super.onTextChanged(r1, r2, r3, r4);
        if (this.b == true) goto L8;
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        this.a = r1;
        return;
    }
}
