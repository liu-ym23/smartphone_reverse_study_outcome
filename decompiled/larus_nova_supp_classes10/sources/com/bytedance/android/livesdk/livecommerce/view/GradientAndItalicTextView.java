package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.graphics.LinearGradient;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001bB'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR.\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/view/GradientAndItalicTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/bytedance/android/livesdk/livecommerce/view/GradientAndItalicTextView$a;", "value", "d", "Lcom/bytedance/android/livesdk/livecommerce/view/GradientAndItalicTextView$a;", "getLinearGradientCreator", "()Lcom/bytedance/android/livesdk/livecommerce/view/GradientAndItalicTextView$a;", "setLinearGradientCreator", "(Lcom/bytedance/android/livesdk/livecommerce/view/GradientAndItalicTextView$a;)V", "linearGradientCreator", "", "e", "F", "getTextSkewXValue", "()F", "setTextSkewXValue", "(F)V", "textSkewXValue", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public class GradientAndItalicTextView extends AppCompatTextView {
    public boolean a;
    public int b;
    public int c;
    public a d;
    public float e;

    public interface a {
        LinearGradient a(int r1, int r2);
    }

    public GradientAndItalicTextView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GradientAndItalicTextView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final a getLinearGradientCreator() {
        return this.d;
    }

    public final float getTextSkewXValue() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setLinearGradientCreator(a r1) {
        this.d = r1;
        this.a = true;
        requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setTextSkewXValue(float r2) {
        if (this.e == r2) goto L6;
        this.e = r2;
        getPaint().setTextSkewX(this.e);
        invalidate();
        return;
    }

    public GradientAndItalicTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = true;
    }

    public /* synthetic */ GradientAndItalicTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (this.a == false) goto L5;
    L8:
        TextPaint r6 = getPaint();
        a r7 = this.d;
        if (r7 == null) goto L11;
        LinearGradient r8 = r7.a(getWidth(), getHeight());
    L12:
        r6.setShader(r8);
        this.b = getWidth();
        this.c = getHeight();
        this.a = false;
        return;
    L11:
        r8 = null;
        goto L12
    L5:
        if (this.b != getWidth()) goto L8;
        if (this.c != getHeight()) goto L8;
    }
}
