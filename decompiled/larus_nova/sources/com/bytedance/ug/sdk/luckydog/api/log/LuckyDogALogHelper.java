package com.bytedance.ug.sdk.luckydog.api.log;

import android.app.Application;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import rk7.m;
import rk7.u;

/* JADX INFO: loaded from: classes3.dex */
public final class LuckyDogALogHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f271578a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f271579b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LuckyDogALogHelper f271580c = null;

    static {
        f271578a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LuckyDogALogHelper.class), "logHandler", "getLogHandler()Landroid/os/Handler;"))};
        f271580c = new LuckyDogALogHelper();
        f271579b = LazyKt.lazy(LuckyDogALogHelper$logHandler$2.INSTANCE);
    }

    public LuckyDogALogHelper() {
    }

    public static void a(int r100, String r101, String r102, Throwable r103) {
        AtomicBoolean r104 = u.f538372v;
        u.c.f538395a.getClass();
        Application r105 = m.f538347a;
        m.r(r100, "LUCKY_DOG_ALOG_" + r101, r102, r103);
    }
}
