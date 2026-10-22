package com.ss.android.lark.widget.photo.preview.utils;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f447152a = 0;

    static {
    }

    public static int a(String r100) {
        ucc.a r101 = (ucc.a) c(ucc.a.class);
        if (r101 != null) goto L5;
        return 0;
    L5:
        return r101.V3(r100);
    }

    public static Object c(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return k.a(LarkContext.getApplication(), r100);
    }

    public static boolean b(View r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "event");
        float r102 = r101.getRawX();
        float r103 = r101.getRawY();
        int[] r104 = new int[2];
        r100.getLocationOnScreen(r104);
        int r105 = r104[0];
        return new Rect(r105, r104[1], r100.getWidth() + r105, r104[1] + r100.getHeight()).contains((int) r102, (int) r103);
    }
}
