package com.bytedance.android.shopping.slice.elements.overlay;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.shopping.extensions.j;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f extends LinearLayout {
    public final Lazy a;

    private final View getSpaceView() {
        return (View) this.a.getValue();
    }

    public final void a(boolean r2) {
        View r0 = getSpaceView();
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 4;
        goto L6
    }

    public f(final Context r9, String r10, com.bytedance.android.ecom.arch.slice.render.context.b r11) {
        Intrinsics.checkNotNullParameter(r11, "metrics");
        super(r9, null, 0);
        TextView r0 = new TextView(r9);
        TextView r2 = new TextView(r9);
        this.a = LazyKt.lazy(new SpecificationTitleView$spaceView$2(r9));
        View r12 = getSpaceView();
        GradientDrawable r3 = new GradientDrawable();
        r3.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        r3.setColors(new int[]{j.b(2131109392), -1});
        Unit r5 = Unit.INSTANCE;
        r12.setBackground(r3);
        r12.setVisibility(4);
        addView(r12, new LinearLayout.LayoutParams(SlcDimensExtensionsKt.a(24, r11), -1));
        r0.setBackgroundColor(-1);
        r0.setText(r10);
        r0.setGravity(16);
        r0.setTextColor(j.b(2131106172));
        r0.setTextSize(2, 12.0f);
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(-2, -1);
        r6.gravity = 16;
        addView(r0, r6);
        r0.setMaxWidth(SlcDimensExtensionsKt.a(180, r11));
        r0.setEllipsize(TextUtils.TruncateAt.END);
        r0.setSingleLine(true);
        r2.setText(j.c(2131913827));
        r2.setBackgroundColor(-1);
        r2.setGravity(16);
        r2.setTextColor(j.b(2131106172));
        r2.setTextSize(2, 12.0f);
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(-2, -1);
        r13.gravity = 16;
        addView(r2, r13);
    }
}
