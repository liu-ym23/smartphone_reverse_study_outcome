package com.bytedance.kmp.ec.yata.view.render.controller.common;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import ba6.g;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f251845a = 0;

    static {
    }

    public static boolean a(com.bytedance.kmp.ec.yata.view.c r100, g r101, List r110, List r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "viewWrapper");
        Intrinsics.checkNotNullParameter(r101, "storeData");
        Intrinsics.checkNotNullParameter(r110, "oldList");
        Intrinsics.checkNotNullParameter(r111, "newList");
        if (r100.f251820c.f251426b == true) goto L6;
        return false;
    L6:
        if (r100.f251824g == true) goto L8;
        return false;
    L8:
        int r102 = ha6.b.f484381a;
        Context r103 = r100.f251818a;
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r104 = r103.getSystemService("input_method");
        if ((r104 instanceof InputMethodManager) == false) goto L11;
        InputMethodManager r105 = (InputMethodManager) r104;
    L13:
        if (r105 != null) goto L15;
    L17:
        boolean r106 = false;
    L18:
        if (r106 == false) goto L20;
        return false;
    L20:
        if (r112 == false) goto L22;
        return true;
    L22:
        aa6.a r107 = r101.getStrategy();
        String r108 = r101.getTriggerType();
        ArrayList r113 = new ArrayList();
        ArrayList r109 = new ArrayList();
        ArrayList r114 = new ArrayList();
        ArrayList r115 = new ArrayList();
        ArrayList r116 = new ArrayList();
        Iterator r117 = r110.iterator();
    L24:
        if (r117.hasNext() == false) goto L28;
        c r118 = (c) r117.next();
        String r119 = r118.c().d();
        r113.add(r119);
        if (r118.c().l(r107, r108) == false) goto L24;
        r109.add(r119);
        goto L24
    L28:
        Iterator r120 = r111.iterator();
    L30:
        if (r120.hasNext() == false) goto L39;
        ba6.d r121 = ((c) r120.next()).c();
        String r122 = r121.d();
        r114.add(r122);
        if (r121.k(r107, r108) == false) goto L35;
        r115.add(r122);
    L35:
        if (r113.contains(r122) == false) goto L30;
        if (r121.j(r107, r108) == false) goto L30;
        r116.add(r122);
        goto L30
    L39:
        Iterator r123 = r115.iterator();
    L41:
        if (r123.hasNext() == false) goto L45;
        if (r113.contains((String) r123.next()) == true) goto L41;
    L50:
        boolean r124 = true;
    L52:
        if (r124 == false) goto L54;
        return true;
    L54:
        return false;
    L45:
        Iterator r125 = r109.iterator();
    L47:
        if (r125.hasNext() == false) goto L51;
        if (r114.contains((String) r125.next()) == true) goto L47;
    L51:
        r124 = !r116.isEmpty();
        goto L52
    L15:
        if (r105.isAcceptingText() != true) goto L17;
        r106 = true;
        goto L18
    L11:
        r105 = null;
        goto L13
    }
}
