package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public static final Resources.Theme a(DialogFragment r5) {
        Context r0 = r5.getContext();
        if (r0 != null) goto L5;
        return null;
    L5:
        int r6 = r5.getTheme();
        if (r6 != 0) goto L8;
        TypedValue r7 = new TypedValue();
        r0.getTheme().resolveAttribute(2130969753, r7, true);
        r6 = r7.resourceId;
    L8:
        if (r6 != 0) goto L10;
        return null;
    L10:
        Resources.Theme r1 = r0.getResources().newTheme();
        r1.applyStyle(r6, true);
        return r1;
    }

    public static final void b(DialogFragment r9, View r10) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, "backGroundView");
        Context r0 = r9.getContext();
        if (r0 != null) goto L6;
        tt5.a.d("DialogFragmentHelper", "context is null!");
        r10.setBackgroundColor(ContextCompat.getColor(LarkContext.getApplication(), 2131100562));
        return;
    L6:
        Resources.Theme r11 = a(r9);
        if (r11 != null) goto L10;
        tt5.a.d("DialogFragmentHelper", "theme is null!");
        r10.setBackgroundColor(ContextCompat.getColor(LarkContext.getApplication(), 2131100562));
        return;
    L10:
        boolean r3 = false;
        TypedArray r5 = r11.obtainStyledAttributes(new int[]{R.attr.backgroundDimEnabled});     // Catch: Throwable -> L27
        Intrinsics.checkNotNull(r5);
        TypedArray r6 = r11.obtainStyledAttributes(new int[]{R.attr.backgroundDimAmount});     // Catch: Throwable -> L25
        Intrinsics.checkNotNull(r6);
    L19:
        th = move-exception;
        tt5.a.e("DialogFragmentHelper", "setBackGroundColorByDimAmount failed!", th, false);     // Catch: Throwable -> L22
    L21:
        r5.recycle();
        r6.recycle();
    L29:
        boolean r7 = false;
    L30:
        if (r7 == false) goto L71;
        tt5.a.h("DialogFragmentHelper", "set background color by dimAmount");
        return;
    L71:
        TypedArray r12 = r11.obtainStyledAttributes(new int[]{R.attr.windowBackground});     // Catch: Throwable -> L54
        Intrinsics.checkNotNull(r12);
        int r8 = r12.getType(0);     // Catch: Throwable -> L48
        switch(r8) {
            case 28: goto L38;
            case 29: goto L38;
            case 30: goto L38;
            case 31: goto L38;
            default: goto L41;
        };     // Catch: Throwable -> L48
    L38:
        int r13 = r12.getColor(0, -1);     // Catch: Throwable -> L48
        if (r13 < 0) goto L41;
        r10.setBackgroundColor(r13);     // Catch: Throwable -> L48
    L47:
        r12.recycle();
        r3 = true;
    L56:
        if (r3 == false) goto L59;
        tt5.a.h("DialogFragmentHelper", "set background color by window background");
        return;
    L59:
        tt5.a.h("DialogFragmentHelper", "set background color by default");
        r10.setBackgroundColor(ContextCompat.getColor(LarkContext.getApplication(), 2131100562));
        return;
    L41:
        if (r8 != 1) goto L50;
        int r14 = r12.getResourceId(0, 0);     // Catch: Throwable -> L48
        if (r14 == 0) goto L50;
        Drawable r1 = AppCompatResources.getDrawable(r0, r14);     // Catch: Throwable -> L48
        if (r1 == null) goto L50;
        r10.setBackground(r1);     // Catch: Throwable -> L48
    L50:
        r12.recycle();
    L48:
        th = move-exception;
        tt5.a.e("DialogFragmentHelper", "setWindowBackGroundColor failed!", th, false);     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        r12.recycle();
        throw th;
    L54:
        th = move-exception;
        tt5.a.e("DialogFragmentHelper", "obtain windowBackground failed!", th, false);
    L22:
        th = move-exception;
        r5.recycle();
        r6.recycle();
        throw th;
    L16:
        if (r5.getBoolean(0, false) == false) goto L21;
        r10.setBackgroundColor(Color.argb((int) ((r6.getFloat(0, 0.0f) * 255.0f) + 0.5f), 0, 0, 0));     // Catch: Throwable -> L19
        r5.recycle();
        r6.recycle();
        r7 = true;
    L25:
        th = move-exception;
        tt5.a.e("DialogFragmentHelper", "obtain backgroundDimAmount failed!", th, false);
    L27:
        th = move-exception;
        tt5.a.e("DialogFragmentHelper", "obtain backgroundDimEnabled failed!", th, false);
        goto L29
    }
}
