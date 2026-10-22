package com.obric.assistant.cocreationreview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes32.dex */
public final class c4 {
    public static final void d(EditText r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        final Ref.FloatRef r101 = new Ref.FloatRef();
        r100.setOnTouchListener(new a4(r101));
    }

    public static final LinearLayout e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        LinearLayout r101 = new LinearLayout(r100);
        r101.setOrientation(0);
        r101.setGravity(16);
        return r101;
    }

    public static final int g(int r100) {
        return Color.argb(24, Color.red(r100), Color.green(r100), Color.blue(r100));
    }

    public static final int i(int r100) {
        return Color.argb(61, Color.red(r100), Color.green(r100), Color.blue(r100));
    }

    public static final LinearLayout k(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        LinearLayout r101 = new LinearLayout(r100);
        r101.setOrientation(1);
        return r101;
    }

    public static final int c(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Resources r102 = r100.getResources();
        return (int) ((r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    }

    public static final void a(LinearLayout r100, View r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "view");
        LinearLayout.LayoutParams r105 = new LinearLayout.LayoutParams(-1, r102);
        r105.setMargins(0, r103, 0, r104);
        Unit r106 = Unit.INSTANCE;
        r100.addView(r101, r105);
    }

    public static final TextView f(Context r100, String r101, float r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "text");
        TextView r105 = new TextView(r100);
        r105.setText(r101);
        r105.setTextSize(r102);
        r105.setTextColor(r103);
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L7;
        Typeface r106 = Typeface.create(Typeface.DEFAULT, 2);
    L18:
        r105.setTypeface(r106);
        r105.setIncludeFontPadding(true);
        r105.setLineSpacing(0.0f, 1.15f);
        return r105;
    L7:
        if (r104 == 3) goto L10;
        r106 = Typeface.DEFAULT;
        goto L18
    L10:
        if (Build.VERSION.SDK_INT < 28) goto L12;
        r106 = Typeface.create(Typeface.DEFAULT, 600, true);
        Intrinsics.checkNotNull(r106);
        goto L18
    L12:
        r106 = Typeface.create(Typeface.DEFAULT_BOLD, 2);
        Intrinsics.checkNotNull(r106);
        goto L18
    L15:
        if (Build.VERSION.SDK_INT < 28) goto L17;
        r106 = Typeface.create(Typeface.DEFAULT, 600, false);
        Intrinsics.checkNotNull(r106);
        goto L18
    L17:
        r106 = Typeface.DEFAULT_BOLD;
        Intrinsics.checkNotNull(r106);
        goto L18
    }

    public static final GradientDrawable h(Context r100, int r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        GradientDrawable r105 = new GradientDrawable();
        r105.setColor(r101);
        r105.setCornerRadius(c(r100, r102));
        if (r104 <= 0) goto L5;
        r105.setStroke(c(r100, r104), r103);
    L5:
        return r105;
    }

    public static final TextView j(Context r100, String r101, boolean r102, int r103, final Function0<Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r104, SendEventContainerMethodParamModel.EventKinds.onClick);
        int r105 = -1;
        if (r102 == false) goto L5;
        int r106 = -1;
    L6:
        TextView r107 = f(r100, r101, 12.5f, r106, 1);
        r107.setText(r101);
        r107.setGravity(17);
        r107.setMinHeight(c(r100, 38));
        r107.setPadding(c(r100, 12), 0, c(r100, 12), 0);
        if (r102 == false) goto L9;
        r105 = r103;
    L9:
        r107.setBackground(h(r100, r105, 9, r103, 1));
        r107.setOnClickListener(new z3(r104));
        return r107;
    L5:
        r106 = r103;
        goto L6
    }

    public static /* synthetic */ void b(LinearLayout r100, View r101, int r102, int r103, int r104, int r105) {
        if ((r105 & 2) == 0) goto L6;
        r102 = -2;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = 0;
    L9:
        if ((r105 & 8) == 0) goto L11;
        r104 = 0;
    L11:
        a(r100, r101, r102, r103, r104);
    }
}
