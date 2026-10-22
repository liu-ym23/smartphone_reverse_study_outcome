package com.bytedance.locallife.live.experiment;

import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes21.dex */
public final class n {
    static {
    }

    @JvmStatic
    public static final int a() {
        Class r100 = Integer.TYPE;     // Catch: Throwable -> L17
        if (LiveLifeSaaSUtil.y().containsKey("locallife_shelf_screen_experiment") == false) goto L12;
        Object r101 = LiveLifeSaaSUtil.y().get("locallife_shelf_screen_experiment");     // Catch: Throwable -> L17
        if (r101 != null) goto L9;
        Object r102 = null;
    L13:
        Integer r103 = (Integer) r102;     // Catch: Throwable -> L17
        if (r103 == null) goto L20;
        return r103.intValue();
    L20:
        return 1;
    L9:
        if ((r101 instanceof Integer) == true) goto L11;
        r102 = LiveLifeSaaSUtil.a("locallife_shelf_screen_experiment", r100, 1);     // Catch: Throwable -> L17
        goto L13
    L11:
        r102 = (Integer) r101;     // Catch: Throwable -> L17
        goto L13
    L12:
        r102 = LiveLifeSaaSUtil.a("locallife_shelf_screen_experiment", r100, 1);     // Catch: Throwable -> L17
    L21:
        return 1;
    }

    @JvmStatic
    public static final boolean b() {
        if (c() == false) goto L5;
        return true;
    L5:
        if (a() != 2) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == true) goto L13;
        return false;
    L13:
        return true;
    L7:
        r100 = false;
        goto L8
    }

    @JvmStatic
    public static final boolean c() {
        if (a() == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
