package com.bytedance.android.livesdk.livecommerce.intro.card.widget.secondframe;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.livesdk.livecommerce.view.GradientAndItalicTextView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/secondframe/IntroCustomEllipsisTextView;", "Lcom/bytedance/android/livesdk/livecommerce/view/GradientAndItalicTextView;", "", "text", "", "setOriginalText", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroCustomEllipsisTextView extends GradientAndItalicTextView {
    public CharSequence f;
    public int g;

    public static final class a {
    }

    static {
    }

    public IntroCustomEllipsisTextView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public IntroCustomEllipsisTextView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setOriginalText(CharSequence r2) {
        this.f = r2;
        this.g = -1;
        setText(r2);
        setContentDescription(String.valueOf(r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r9, int r10) {
        int r0 = View.MeasureSpec.getMode(r9);
        int r1 = View.MeasureSpec.getSize(r9);
        if (r0 != 0) goto L5;
        int r2 = Integer.MAX_VALUE;
    L6:
        if (r2 > 0) goto L8;
    L32:
        super.onMeasure(r9, r10);
        return;
    L8:
        if (r2 == this.g) goto L32;
        CharSequence r3 = this.f;
        if (r3 == null) goto L32;
        this.g = r2;
        TextPaint r4 = getPaint();
        String r5 = String.valueOf(r3);
        float r6 = r2;
        if (r4.measureText("“" + r3 + 8221) > r6) goto L14;
        String r7 = "“" + r3 + 8221;
    L30:
        if ((!Intrinsics.areEqual(getText().toString(), r7.toString())) == false) goto L32;
        setText(r7);
        goto L32
    L14:
        float r8 = r4.measureText("“");
        float r11 = ((r6 - r8) - r4.measureText("”")) - r4.measureText("…");
        if (r11 > 0) goto L18;
        r7 = "";
    L18:
        if (r5.length() <= 0) goto L20;
        boolean r12 = true;
    L21:
        if (r12 == false) goto L28;
        if (r4.measureText(r5) <= r11) goto L28;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L26
        r5 = r5.substring(0, r5.length() - 1);     // Catch: Throwable -> L26
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L28:
        r7 = "“" + r5 + "…”";
        goto L30
    L20:
        r12 = false;
        goto L21
    L5:
        r2 = (r1 - getPaddingLeft()) - getPaddingRight();
        goto L6
    }

    public IntroCustomEllipsisTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.g = -1;
    }

    public /* synthetic */ IntroCustomEllipsisTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
