package com.bytedance.android.shopping.deepfeed.weights;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/SalesViewContainer;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SalesViewContainer extends LinearLayout {
    public final ProductTextView a;

    public SalesViewContainer(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SalesViewContainer(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView] */
    public SalesViewContainer(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        ?? r7 = new ProductTextView(r4, null, 6, 0);
        r7.setId(ViewCompat.generateViewId());
        r7.setIncludeFontPadding(false);
        r7.setMaxLines(1);
        com.bytedance.android.shopping.deepfeed.ui.view.a r0 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r7.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r4, 12));
        Integer r8 = com.bytedance.android.shopping.deepfeed.utlis.j.d("#16182399");
        if (r8 == null) goto L6;
        r7.setTextColor(r8.intValue());
    L6:
        if (tc3.f.e() == false) goto L8;
        r7.setGravity(80);
    L8:
        Unit r9 = Unit.INSTANCE;
        this.a = r7;
        if (tc3.f.e() == false) goto L11;
        setGravity(80);
    L12:
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-2, -2);
        if (tc3.f.e() == false) goto L15;
        r10.gravity = 80;
    L15:
        addView(r7, r10);
        Integer r11 = tc3.f.c();
        if (r11 != null) goto L19;
    L21:
        Integer r12 = tc3.f.c();
        if (r12 != null) goto L25;
        return;
    L25:
        if (r12.intValue() != 2) goto L29;
        r7.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 14));
        return;
    L29:
        return;
    L19:
        if (r11.intValue() != 1) goto L21;
        r7.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 13));
        return;
    L11:
        setGravity(17);
        goto L12
    }

    public /* synthetic */ SalesViewContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
