package com.bytedance.ug.sdk.luckydog.api.settings;

import il7.m;
import java.util.LinkedHashSet;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f271651a = 0;

    @JvmStatic
    public static final long a() {
        LuckyDogLocalSettings r100 = h.a();
        if (r100 != null) goto L6;
        long r101 = m.b("activity_local.sp").d("key_time_interval", 0);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogLocalStorage", "getTimeInterval interval = " + r101);
        return r101;
    L6:
        return r100.getTimeInterval();
    }

    @JvmStatic
    public static final long b() {
        LuckyDogLocalSettings r100 = h.a();
        if (r100 != null) goto L6;
        long r101 = m.b("activity_local.sp").d("key_boot_time", 0);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogLocalStorage", "getTimeManagerOldBoot bootTime = " + r101);
        return r101;
    L6:
        return r100.getTimeManagerOldBoot();
    }

    static {
    }

    @JvmStatic
    public static final boolean c(long r100) {
        LuckyDogLocalSettings r101 = h.a();
        if (r101 == null) goto L5;
        LinkedHashSet<Long> r102 = r101.getShownPopupIdSet();
    L6:
        if (r102 != null) goto L8;
        return false;
    L8:
        if (r102.isEmpty() == false) goto L11;
        return false;
    L11:
        return r102.contains(Long.valueOf(r100));
    L5:
        r102 = null;
        goto L6
    }
}
