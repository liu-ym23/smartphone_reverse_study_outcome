package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

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
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e {
    public static final Resources.Theme a(DialogFragment r100) {
        Context r101 = r100.getContext();
        if (r101 != null) goto L5;
        return null;
    L5:
        int r102 = r100.getTheme();
        if (r102 != 0) goto L8;
        TypedValue r103 = new TypedValue();
        r101.getTheme().resolveAttribute(R.attr.dialogTheme, r103, true);
        r102 = r103.resourceId;
    L8:
        if (r102 != 0) goto L10;
        return null;
    L10:
        Resources.Theme r104 = r101.getResources().newTheme();
        r104.applyStyle(r102, true);
        return r104;
    }

    public static final void b(DialogFragment r100, View r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r110, "backGroundView");
        Context r101 = r100.getContext();
        if (r101 != null) goto L6;
        tt5.a.d("DialogFragmentHelper", "context is null!");
        r110.setBackgroundColor(ContextCompat.getColor(LarkContext.getApplication(), R.color.bg_mask));
        return;
    L6:
        Resources.Theme r102 = a(r100);
        if (r102 != null) goto L10;
        tt5.a.d("DialogFragmentHelper", "theme is null!");
        r110.setBackgroundColor(ContextCompat.getColor(LarkContext.getApplication(), R.color.bg_mask));
        return;
    L10:
        boolean r103 = false;
        TypedArray r104 = r102.obtainStyledAttributes(new int[]{android.R.attr.backgroundDimEnabled});     // Catch: Throwable -> L27
        Intrinsics.checkNotNull(r104);
        TypedArray r105 = r102.obtainStyledAttributes(new int[]{android.R.attr.backgroundDimAmount});     // Catch: Throwable -> L25
        Intrinsics.checkNotNull(r105);
    L19:
        th = move-exception;
        tt5.a.e("DialogFragmentHelper", "setBackGroundColorByDimAmount failed!", th, false);     // Catch: Throwable -> L22
    L21:
        r104.recycle();
        r105.recycle();
    L29:
        boolean r106 = false;
    L30:
        if (r106 == false) goto L71;
        tt5.a.h("DialogFragmentHelper", "set background color by dimAmount");
        return;
    L71:
        TypedArray r107 = r102.obtainStyledAttributes(new int[]{android.R.attr.windowBackground});     // Catch: Throwable -> L54
        Intrinsics.checkNotNull(r107);
        int r108 = r107.getType(0);     // Catch: Throwable -> L48
        switch(r108) {
            case 28: goto L38;
            case 29: goto L38;
            case 30: goto L38;
            case 31: goto L38;
            default: goto L41;
        };     // Catch: Throwable -> L48
    L38:
        int r109 = r107.getColor(0, -1);     // Catch: Throwable -> L48
        if (r109 < 0) goto L41;
        r110.setBackgroundColor(r109);     // Catch: Throwable -> L48
    L47:
        r107.recycle();
        r103 = true;
    L56:
        if (r103 == false) goto L59;
        tt5.a.h("DialogFragmentHelper", "set background color by window background");
        return;
    L59:
        tt5.a.h("DialogFragmentHelper", "set background color by default");
        r110.setBackgroundColor(ContextCompat.getColor(LarkContext.getApplication(), R.color.bg_mask));
        return;
    L41:
        if (r108 != 1) goto L50;
        int r111 = r107.getResourceId(0, 0);     // Catch: Throwable -> L48
        if (r111 == 0) goto L50;
        Drawable r112 = AppCompatResources.getDrawable(r101, r111);     // Catch: Throwable -> L48
        if (r112 == null) goto L50;
        r110.setBackground(r112);     // Catch: Throwable -> L48
    L50:
        r107.recycle();
    L48:
        th = move-exception;
        tt5.a.e("DialogFragmentHelper", "setWindowBackGroundColor failed!", th, false);     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        r107.recycle();
        throw th;
    L54:
        th = move-exception;
        tt5.a.e("DialogFragmentHelper", "obtain windowBackground failed!", th, false);
    L22:
        th = move-exception;
        r104.recycle();
        r105.recycle();
        throw th;
    L16:
        if (r104.getBoolean(0, false) == false) goto L21;
        r110.setBackgroundColor(Color.argb((int) ((r105.getFloat(0, 0.0f) * 255.0f) + 0.5f), 0, 0, 0));     // Catch: Throwable -> L19
        r104.recycle();
        r105.recycle();
        r106 = true;
    L25:
        th = move-exception;
        tt5.a.e("DialogFragmentHelper", "obtain backgroundDimAmount failed!", th, false);
    L27:
        th = move-exception;
        tt5.a.e("DialogFragmentHelper", "obtain backgroundDimEnabled failed!", th, false);
        goto L29
    }
}
