package com.bytedance.awemeopen.apps.framework.feed.ui.information.username;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j {
    public final ViewGroup a;
    public final SparseArray<View> b;

    public static final class a {
    }

    static {
    }

    public j(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "parentView");
        this.a = r5;
        SparseArray<View> r0 = new SparseArray();
        this.b = r0;
        r0.put(0, a(2131558634));
        r0.put(1, a(2131558633));
        TextView r1 = new TextView(r5.getContext());
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(-2, -2);
        r6.gravity = 16;
        r6.setMargins(0, 0, 0, 0);
        r1.setLayoutParams(r6);
        r1.setIncludeFontPadding(false);
        r1.setGravity(3);
        r1.setEllipsize(TextUtils.TruncateAt.END);
        r1.setSingleLine();
        r1.setShadowLayer(1.0f, 0.0f, 1.0f, ColorProtector.parseColor("#4E000000"));
        r1.setTextColor(r1.getResources().getColor(2131100273));
        r1.setTextSize(15.0f);
        r0.put(2, r1);
    }

    public final View a(int r8) {
        View r9 = LayoutInflater.from(this.a.getContext()).inflate(r8, this.a, false);
        Resources r3 = Resources.getSystem();
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-2, MathKt.roundToInt(TypedValue.applyDimension(1, 20, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()))));
        r0.gravity = 80;
        Resources r4 = Resources.getSystem();
        int r1 = MathKt.roundToInt(TypedValue.applyDimension(1, 6, WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics())));
        Resources r5 = Resources.getSystem();
        r0.setMargins(r1, 0, 0, MathKt.roundToInt(TypedValue.applyDimension(1, 2, WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()))));
        r9.setLayoutParams(r0);
        return r9;
    }

    public final void b(int r5) {
        int r0 = this.b.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        View r2 = this.b.valueAt(r1);
        if (x54.b.c(r2) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) r3).leftMargin = r5;
        return;
    }
}
