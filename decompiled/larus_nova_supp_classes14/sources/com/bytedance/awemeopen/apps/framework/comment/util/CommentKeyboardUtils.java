package com.bytedance.awemeopen.apps.framework.comment.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.inputmethod.InputMethodManager;
import com.bytedance.awemeopen.apps.framework.comment.widget.view.CommentMentionEditText;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class CommentKeyboardUtils {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static int e;

    static {
        a = LazyKt.lazy(CommentKeyboardUtils$defaultLandscape$2.INSTANCE);
        b = LazyKt.lazy(CommentKeyboardUtils$defaultPortrait$2.INSTANCE);
        c = LazyKt.lazy(CommentKeyboardUtils$spStore$2.INSTANCE);
        Lazy r0 = LazyKt.lazy(CommentKeyboardUtils$mApplication$2.INSTANCE);
        d = r0;
        int r1 = d0.c((Application) r0.getValue()) - d0.b((Application) r0.getValue());
        Resources r2 = ((Application) r0.getValue()).getResources();
        int r3 = r2.getIdentifier("status_bar_height", "dimen", "android");
        if (r3 <= 0) goto L5;
        int r4 = r2.getDimensionPixelSize(r3);
    L6:
        e = (int) ((r1 - r4) * 0.75f);
        return;
    L5:
        r4 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void a(CommentMentionEditText r4, Context r5) {
        if (r4 == 0) goto L15;
        Object r0 = y54.a.a().getSystemService("input_method");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        if (((InputMethodManager) r0).hideSoftInputFromWindow(r4.getWindowToken(), 0) == true) goto L16;
        InputMethodManager r1 = null;
        if (r5 == null) goto L8;
        Object r6 = r5.getSystemService("input_method");
    L10:
        if ((r6 instanceof InputMethodManager) == false) goto L12;
        r1 = (InputMethodManager) r6;
    L12:
        if (r1 == null) goto L17;
        r1.hideSoftInputFromWindow(r4.getWindowToken(), 0);
        return;
    L17:
        return;
    L8:
        r6 = null;
        goto L10
    L16:
        return;
    }

    @JvmStatic
    public static final int b(boolean r5, boolean r6) {
        if (r5 == true) goto L10;
        int r7 = ((SharedPreferences) c.getValue()).getInt("keyboard_height_portrait", ((Number) b.getValue()).intValue());
        if (r6 == true) goto L11;
        float r0 = 1;
        Resources r1 = Resources.getSystem();
        if (r7 >= ((int) (((double) MathKt.roundToInt(TypedValue.applyDimension(1, r0, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics())))) * 299.5d))) goto L12;
        Resources r8 = Resources.getSystem();
        return (int) (((double) MathKt.roundToInt(TypedValue.applyDimension(1, r0, WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics())))) * 299.5d);
    L12:
        return r7;
    L11:
        return r7;
    L10:
        return ((SharedPreferences) c.getValue()).getInt("keyboard_height_landscape", ((Number) a.getValue()).intValue());
    }
}
