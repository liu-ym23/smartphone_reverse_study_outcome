package com.bytedance.helios.common.utils;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f245397a = 0;

    static {
    }

    public static String a(Throwable r110, String r111) {
        ArrayList r100 = new ArrayList();
        StackTraceElement[] r101 = r110.getStackTrace();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L18;
        StackTraceElement r104 = r101[r103];
        String r105 = r104.getClassName();
        if (r105 != null) goto L7;
    L10:
        boolean r106 = true;
    L11:
        if (r106 == true) goto L17;
        if (StringsKt.startsWith$default(r104.getClassName(), "com.bytedance.helios.sdk.ActionInvoker", false, 2, null) == true) goto L17;
        if (StringsKt.startsWith$default(r104.getClassName(), "com.bytedance.timonbase.pipeline.TimonPipeline", false, 2, null) == true) goto L17;
        r100.add(r104);
    L17:
        r103 = r103 + 1;
        goto L3
    L7:
        if (r105.length() == 0) goto L10;
        r106 = false;
        goto L11
    L18:
        StringBuilder r107 = new StringBuilder();
        r107.append(r110.getClass().getName());
        r107.append(": ");
        r107.append(r111);
        r107.append('\n');
        Iterator r112 = r100.iterator();
    L20:
        if (r112.hasNext() == false) goto L23;
        StackTraceElement r108 = (StackTraceElement) r112.next();
        r107.append("at ");
        r107.append(r108.toString());
        r107.append('\n');
        goto L20
    L23:
        return r107.toString();
    }
}
