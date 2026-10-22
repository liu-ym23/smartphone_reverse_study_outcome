package com.bytedance.android.shopping.deepfeed.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/view/AdapterScreenImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdapterScreenImageView extends AppCompatImageView {
    public final a a;
    public final float[] b;

    public AdapterScreenImageView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AdapterScreenImageView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r9, int r10) {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        Pair<Integer, Integer> r2 = null;
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        if (r1 == null) goto L26;
        a r3 = this.a;
        if (r3 == null) goto L26;
        float[] r4 = this.b;
        Intrinsics.checkNotNullParameter(r1, "layoutParams");
        Intrinsics.checkNotNullParameter(r4, "margin");
        if (r3.b != 1) goto L26;
        if (r4.length != 4) goto L26;
        float r5 = r4[0];
        if (r5 == 0.0f) goto L17;
        r1.leftMargin = Math.round(r5 * r3.a);
    L17:
        float r6 = r4[1];
        if (r6 == 0.0f) goto L20;
        r1.topMargin = Math.round(r6 * r3.a);
    L20:
        float r7 = r4[2];
        if (r7 == 0.0f) goto L23;
        r1.rightMargin = Math.round(r7 * r3.a);
    L23:
        float r8 = r4[3];
        if (r8 == 0.0f) goto L26;
        r1.bottomMargin = Math.round(r8 * r3.a);
    L26:
        a r11 = this.a;
        if (r11 == null) goto L29;
        r2 = r11.b(r9, r10);
    L29:
        if (r2 == null) goto L31;
        super/*android.widget.ImageView*/.onMeasure(((Number) r2.getFirst()).intValue(), ((Number) r2.getSecond()).intValue());
        return;
    L31:
        super/*android.widget.ImageView*/.onMeasure(r9, r10);
    }

    public AdapterScreenImageView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        a r8 = a.e;
        this.a = a.e;
        this.b = new float[]{r5.getDimension(1, 0.0f), r5.getDimension(3, 0.0f), r5.getDimension(2, 0.0f), r5.getDimension(0, 0.0f)};
        TypedArray r9 = r5.obtainStyledAttributes(r6, new int[]{2130969706, 2130969707, 2130969708, 2130969709}, 0, 0);
        r9.recycle();
    }

    public /* synthetic */ AdapterScreenImageView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
