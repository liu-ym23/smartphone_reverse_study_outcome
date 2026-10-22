package com.bytedance.ies.xelement.input;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;
import z6a.p;

/* JADX INFO: loaded from: classes19.dex */
public final class k {
    public static Layout a(CharSequence r110, LynxEditText r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "charSequence");
        Intrinsics.checkNotNullParameter(r111, "editText");
        int r100 = r111.getGravity();
        if (r100 == 3) goto L10;
        if (r100 != 5) goto L6;
        Layout.Alignment r101 = Layout.Alignment.ALIGN_OPPOSITE;
    L11:
        Layout.Alignment r102 = r101;
        int r103 = Build.VERSION.SDK_INT;
        if (r103 < 23) goto L26;
        int r104 = r111.getTextDirection();
        if (r104 == 3) goto L20;
        if (r104 == 4) goto L19;
        if (r104 == 5) goto L18;
        TextDirectionHeuristic r105 = TextDirectionHeuristics.LTR;
    L21:
        StaticLayout.Builder r106 = StaticLayout.Builder.obtain(r110, 0, r110.length(), r111.getPaint(), r112).setAlignment(r102).setTextDirection(r105).setLineSpacing(r111.getLineSpacingExtra(), r111.getLineSpacingMultiplier()).setIncludePad(r111.getIncludeFontPadding());
        if (r103 < 28) goto L25;
        r106.setUseLineSpacingFromFallbacks(true);
    L25:
        return r106.build();
    L18:
        r105 = TextDirectionHeuristics.LOCALE;
        goto L21
    L19:
        r105 = TextDirectionHeuristics.RTL;
        goto L21
    L20:
        r105 = TextDirectionHeuristics.LTR;
        goto L21
    L26:
        int r107 = r111.getTextDirection();
        if (r107 == 3) goto L33;
        if (r107 == 4) goto L32;
        if (r107 == 5) goto L31;
        TextDirectionHeuristic r108 = TextDirectionHeuristics.LTR;
    L34:
        TextDirectionHeuristic r113 = r108;
        return p.a(r110, r110.length(), r111.getPaint(), r112, r102, r111.getLineSpacingMultiplier(), r111.getLineSpacingExtra(), r111.getIncludeFontPadding(), TextUtils.TruncateAt.END, -1, r113);
    L31:
        r108 = TextDirectionHeuristics.LOCALE;
        goto L34
    L32:
        r108 = TextDirectionHeuristics.RTL;
        goto L34
    L33:
        r108 = TextDirectionHeuristics.LTR;
        goto L34
    L6:
        if (r100 == 17) goto L8;
        r101 = Layout.Alignment.ALIGN_NORMAL;
        goto L11
    L8:
        r101 = Layout.Alignment.ALIGN_CENTER;
        goto L11
    L10:
        r101 = Layout.Alignment.ALIGN_NORMAL;
        goto L11
    }
}
