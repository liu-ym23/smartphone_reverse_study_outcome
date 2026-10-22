package com.bytedance.locallife.biz.btm;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    public static final View a(String r100, View r101) {
        Intrinsics.checkNotNullParameter(r101, "host");
        if (r100 != null) goto L6;
        return r101;
    L6:
        if (StringsKt.contains$default(r100, "c1342", false, 2, null) == false) goto L25;
        ViewParent r102 = r101.getParent();
        if ((r102 instanceof ViewGroup) == false) goto L10;
        ViewGroup r103 = (ViewGroup) r102;
    L11:
        if (r103 == null) goto L25;
        int r104 = r103.getChildCount();
        int r105 = 0;
    L13:
        if (r105 >= r104) goto L22;
        View r106 = r103.getChildAt(r105);
        Intrinsics.checkNotNullParameter(r106, "<this>");
        Map<String, Object> r107 = c.g(r106, null);
        if (r107 == null) goto L17;
        Object r108 = r107.get("btm");
    L19:
        if (Intrinsics.areEqual(r108, "a2552.b9338.c0.d0") == true) goto L20;
        r105 = r105 + 1;
        goto L13
    L20:
        return r106;
    L17:
        r108 = null;
        goto L19
    L22:
        ViewParent r109 = r103.getParent();
        if ((r109 instanceof ViewGroup) == false) goto L10;
        r103 = (ViewGroup) r109;
        goto L11
    L10:
        r103 = null;
        goto L11
    L26:
        r103 = null;
    L25:
        return r101;
    }
}
