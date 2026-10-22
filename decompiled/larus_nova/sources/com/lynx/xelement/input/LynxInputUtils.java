package com.lynx.xelement.input;

import android.graphics.Paint;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextUtils;
import android.widget.EditText;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import z6a.p;

/* JADX INFO: loaded from: classes32.dex */
public final class LynxInputUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<b> f384135a = null;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f384136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f384137b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f384138c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f384136a, r101.f384136a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f384137b, r101.f384137b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f384138c, r101.f384138c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f384136a.hashCode() * 31) + this.f384137b.hashCode()) * 31) + this.f384138c.hashCode();
        }

        public final String toString() {
            return "LocaleLineHeightMethods(isLocalePreferredLineHeightForMinimumUsed=" + this.f384136a + ", getFontMetricsForLocale=" + this.f384137b + ", setMinimumFontMetrics=" + this.f384138c + ')';
        }

        public b(Method r100, Method r101, Method r102) {
            Intrinsics.checkNotNullParameter(r100, "isLocalePreferredLineHeightForMinimumUsed");
            Intrinsics.checkNotNullParameter(r101, "getFontMetricsForLocale");
            Intrinsics.checkNotNullParameter(r102, "setMinimumFontMetrics");
            this.f384136a = r100;
            this.f384137b = r101;
            this.f384138c = r102;
        }
    }

    public LynxInputUtils() {
    }

    static {
        f384135a = LazyKt.lazy(LynxInputUtils$Companion$localeLineHeightMethods$2.INSTANCE);
    }

    public static Layout a(CharSequence r110, EditText r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "charSequence");
        Intrinsics.checkNotNullParameter(r111, "editText");
        int r100 = r111.getGravity();
        if (r100 == 3) goto L10;
        if (r100 != 5) goto L6;
        Layout.Alignment r101 = Layout.Alignment.ALIGN_OPPOSITE;
    L11:
        Layout.Alignment r102 = r101;
        int r103 = Build.VERSION.SDK_INT;
        if (r103 < 23) goto L39;
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
        if (r103 < 35) goto L38;
        b r107 = f384135a.getValue();
        if (r107 == null) goto L38;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L35
        if (Intrinsics.areEqual(r107.f384136a.invoke(r111, new Object[0]), Boolean.TRUE) == false) goto L33;
        Paint.FontMetrics r109 = new Paint.FontMetrics();     // Catch: Throwable -> L35
        r107.f384137b.invoke(r111.getPaint(), new Object[]{r109});     // Catch: Throwable -> L35
        r107.f384138c.invoke(r106, new Object[]{r109});     // Catch: Throwable -> L35
    L33:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L38:
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
    L39:
        int r114 = r111.getTextDirection();
        if (r114 == 3) goto L46;
        if (r114 == 4) goto L45;
        if (r114 == 5) goto L44;
        TextDirectionHeuristic r115 = TextDirectionHeuristics.LTR;
    L48:
        return p.a(r110, r110.length(), r111.getPaint(), r112, r102, r111.getLineSpacingMultiplier(), r111.getLineSpacingExtra(), r111.getIncludeFontPadding(), TextUtils.TruncateAt.END, -1, r115);
    L44:
        r115 = TextDirectionHeuristics.LOCALE;
        goto L48
    L45:
        r115 = TextDirectionHeuristics.RTL;
        goto L48
    L46:
        r115 = TextDirectionHeuristics.LTR;
        goto L48
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
