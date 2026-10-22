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

/* JADX INFO: loaded from: classes14.dex */
public final class CommentKeyboardUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f194178a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f194179b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f194180c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f194181d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f194182e;

    static {
        f194178a = LazyKt.lazy(CommentKeyboardUtils$defaultLandscape$2.INSTANCE);
        f194179b = LazyKt.lazy(CommentKeyboardUtils$defaultPortrait$2.INSTANCE);
        f194180c = LazyKt.lazy(CommentKeyboardUtils$spStore$2.INSTANCE);
        Lazy r100 = LazyKt.lazy(CommentKeyboardUtils$mApplication$2.INSTANCE);
        f194181d = r100;
        int r101 = d0.c((Application) r100.getValue()) - d0.b((Application) r100.getValue());
        Resources r102 = ((Application) r100.getValue()).getResources();
        int r103 = r102.getIdentifier("status_bar_height", "dimen", "android");
        if (r103 <= 0) goto L5;
        int r104 = r102.getDimensionPixelSize(r103);
    L6:
        f194182e = (int) ((r101 - r104) * 0.75f);
        return;
    L5:
        r104 = 0;
        goto L6
    }

    @JvmStatic
    public static final void a(CommentMentionEditText r100, Context r101) {
        if (r100 == null) goto L15;
        Object r102 = y54.a.a().getSystemService("input_method");
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        if (((InputMethodManager) r102).hideSoftInputFromWindow(r100.getWindowToken(), 0) == true) goto L16;
        InputMethodManager r103 = null;
        if (r101 == null) goto L8;
        Object r104 = r101.getSystemService("input_method");
    L10:
        if ((r104 instanceof InputMethodManager) == false) goto L12;
        r103 = (InputMethodManager) r104;
    L12:
        if (r103 == null) goto L17;
        r103.hideSoftInputFromWindow(r100.getWindowToken(), 0);
        return;
    L17:
        return;
    L8:
        r104 = null;
        goto L10
    L16:
        return;
    }

    @JvmStatic
    public static final int b(boolean r100, boolean r101) {
        if (r100 == true) goto L10;
        int r102 = ((SharedPreferences) f194180c.getValue()).getInt("keyboard_height_portrait", ((Number) f194179b.getValue()).intValue());
        if (r101 == true) goto L11;
        float r103 = 1;
        Resources r104 = Resources.getSystem();
        if (r102 >= ((int) (((double) MathKt.roundToInt(TypedValue.applyDimension(1, r103, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics())))) * 299.5d))) goto L12;
        Resources r105 = Resources.getSystem();
        return (int) (((double) MathKt.roundToInt(TypedValue.applyDimension(1, r103, WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics())))) * 299.5d);
    L12:
        return r102;
    L11:
        return r102;
    L10:
        return ((SharedPreferences) f194180c.getValue()).getInt("keyboard_height_landscape", ((Number) f194178a.getValue()).intValue());
    }
}
