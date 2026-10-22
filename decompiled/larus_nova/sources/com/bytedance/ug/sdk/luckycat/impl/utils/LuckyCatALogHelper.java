package com.bytedance.ug.sdk.luckycat.impl.utils;

import com.bytedance.ug.sdk.luckycat.impl.manager.LuckyCatSettingsManger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class LuckyCatALogHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f271501a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f271502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f271503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f271504d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final LuckyCatALogHelper f271505e = null;

    static {
        f271501a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LuckyCatALogHelper.class), "logHandler", "getLogHandler()Landroid/os/Handler;"))};
        f271505e = new LuckyCatALogHelper();
        f271502b = true;
        f271504d = LazyKt.lazy(LuckyCatALogHelper$logHandler$2.INSTANCE);
    }

    public LuckyCatALogHelper() {
    }

    public static void a(int r100, String r101, String r102) {
        com.bytedance.ug.sdk.luckycat.impl.manager.q r103 = com.bytedance.ug.sdk.luckycat.impl.manager.q.b.f271365a;
        if (r103.f271357b == true) goto L5;
        return;
    L5:
        boolean r104 = true;
        if (r103.f271357b == true) goto L9;
    L16:
        if (r104 == true) goto L18;
        return;
    L18:
        String r105 = "LUCKY_DOG_ALOG_" + r101;
        com.bytedance.ug.sdk.luckycat.api.depend.f r106 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.f271338f;
        if (r106 == null) goto L24;
        ik7.d r107 = ((cn7.d) r106).f24555a;
        if (r107 == null) goto L25;
        r107.c(r100, r105, r102);
        return;
    L25:
        return;
    L24:
        return;
    L9:
        if (f271503c == false) goto L11;
        r104 = f271502b;
        goto L16
    L11:
        LuckyCatSettingsManger r108 = LuckyCatSettingsManger.b.f271283a;
        r108.getClass();
        Object r109 = r108.c(new String[]{"common", "enable_alog"});
        if ((r109 instanceof Boolean) == false) goto L14;
        boolean r110 = ((Boolean) r109).booleanValue();
    L15:
        f271502b = r110;
        f271503c = true;
        r104 = r110;
        goto L16
    L14:
        r110 = true;
        goto L15
    }
}
