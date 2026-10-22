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
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f196536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<View> f196537b;

    public static final class a {
    }

    static {
    }

    public j(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        this.f196536a = r100;
        SparseArray<View> r101 = new SparseArray();
        this.f196537b = r101;
        r101.put(0, a(R.layout.aos_familiar_module_slides_tag));
        r101.put(1, a(R.layout.aos_familiar_module_slides_douyin_tag));
        TextView r102 = new TextView(r100.getContext());
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-2, -2);
        r103.gravity = 16;
        r103.setMargins(0, 0, 0, 0);
        r102.setLayoutParams(r103);
        r102.setIncludeFontPadding(false);
        r102.setGravity(3);
        r102.setEllipsize(TextUtils.TruncateAt.END);
        r102.setSingleLine();
        r102.setShadowLayer(1.0f, 0.0f, 1.0f, ColorProtector.parseColor("#4E000000"));
        r102.setTextColor(r102.getResources().getColor(R.color.aos_const_text_inverse4));
        r102.setTextSize(15.0f);
        r101.put(2, r102);
    }

    public final View a(int r100) {
        View r101 = LayoutInflater.from(this.f196536a.getContext()).inflate(r100, this.f196536a, false);
        Resources r102 = Resources.getSystem();
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-2, MathKt.roundToInt(TypedValue.applyDimension(1, 20, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()))));
        r103.gravity = 80;
        Resources r104 = Resources.getSystem();
        int r105 = MathKt.roundToInt(TypedValue.applyDimension(1, 6, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics())));
        Resources r106 = Resources.getSystem();
        r103.setMargins(r105, 0, 0, MathKt.roundToInt(TypedValue.applyDimension(1, 2, WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()))));
        r101.setLayoutParams(r103);
        return r101;
    }

    public final void b(int r100) {
        int r101 = this.f196537b.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        View r103 = this.f196537b.valueAt(r102);
        if (x54.b.c(r103) == true) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) r104).leftMargin = r100;
        return;
    }
}
