package com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor;

import com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.ECPerfSessionStageHandler;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final CopyOnWriteArrayList<WeakReference<com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.c>> a = null;
    public static final CopyOnWriteArrayList<c> b = null;
    public static final ECPerfSessionStageHandler c = null;

    static {
        CopyOnWriteArrayList<WeakReference<com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.c>> r0 = new CopyOnWriteArrayList();
        a = r0;
        b = new CopyOnWriteArrayList();
        c = new ECPerfSessionStageHandler();
        WeakReference<com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.c> r1 = new WeakReference(c);
        Intrinsics.checkNotNullParameter(r1, "handler");
        r1.get();
        r0.add(r1);
    }

    public static void a(String r16, String r17, double r18, String r20, Map r21) {
        Intrinsics.checkNotNullParameter(r16, "stageName");
        Intrinsics.checkNotNullParameter(r17, "scheme");
        String r3 = r20;
        Intrinsics.checkNotNullParameter(r3, "triggerSource");
        if (r16.length() != 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L9;
        return;
    L9:
        if (r20.length() != 0) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L14;
        r3 = ECStageTriggerSource.GENERAL.getType();
    L14:
        String r11 = r3;
        if (r18 > 0) goto L17;
        double r12 = System.currentTimeMillis();
    L18:
        Intrinsics.checkNotNullParameter(r16, "stageName");
        Intrinsics.checkNotNullParameter(r17, "scheme");
        Intrinsics.checkNotNullParameter(r11, "triggerSource");
        b.add(new c(r16, r17, r12, r11, r21));
        Iterator<WeakReference<com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.c>> r14 = a.iterator();
    L20:
        if (r14.hasNext() == false) goto L34;
        com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.c r0 = r14.next().get();
        if (r0 == null) goto L20;
        String r1 = r0.a(r17, r21);
        if (r1 == null) goto L20;
        if (r1.length() <= 0) goto L28;
        boolean r2 = true;
    L29:
        if (r2 == true) goto L32;
        r1 = null;
    L32:
        if (r1 == null) goto L20;
        r0.b(r16, r17, r12, r11, r21);
        goto L20
    L28:
        r2 = false;
        goto L29
    L34:
        return;
    L17:
        r12 = r18;
        goto L18
    L11:
        r5 = false;
        goto L12
    L5:
        r4 = false;
        goto L6
    }
}
