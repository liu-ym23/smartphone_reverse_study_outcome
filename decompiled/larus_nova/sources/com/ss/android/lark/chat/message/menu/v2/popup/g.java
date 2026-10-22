package com.ss.android.lark.chat.message.menu.v2.popup;

import android.content.Context;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class g {
    public static final boolean b(zya.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        zya.d r101 = r100.f573995j;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L9:
        if (r100.f573992g == false) goto L12;
        if (r102 == true) goto L12;
        return true;
    L12:
        return false;
    L5:
        if (r101.a() != true) goto L7;
        r102 = true;
        goto L9
    }

    public static final boolean a(zya.b r100, View r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "view");
        zya.d r103 = r100.f573995j;
        if (r103 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L10;
        return false;
    L10:
        zya.d r105 = r100.f573995j;
        if (r105 == null) goto L13;
        r105.b(r101, r102);
    L13:
        return true;
    L5:
        if (r103.c(r102) != true) goto L7;
        r104 = true;
        goto L8
    }

    public static final void c(b r100, Context r101, zya.b r102, int r103, int r104, Integer r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "action");
        Integer r107 = r102.f573989d;
        Integer r108 = null;
        if (r107 == null) goto L5;
        Integer r109 = Integer.valueOf(UIUtils.getColor(r101, r107.intValue()));
    L7:
        if (r102.f573988c == true) goto L15;
        if (r106 == true) goto L11;
        r108 = Integer.valueOf(r104);
        goto L15
    L11:
        if (r109 == null) goto L13;
        int r110 = r109.intValue();
    L14:
        r108 = Integer.valueOf(r110);
        goto L15
    L13:
        r110 = r103;
    L15:
        if (r106 == true) goto L17;
        r103 = r104;
    L19:
        if (r108 == null) goto L21;
        r100.setIconTint(r108.intValue());
    L21:
        r100.setTextColor(r103);
        if (r105 == null) goto L25;
        r100.setBgColor(r105.intValue());
        return;
    L25:
        return;
    L17:
        if (r109 == null) goto L19;
        r103 = r109.intValue();
        goto L19
    L5:
        r109 = null;
        goto L7
    }
}
