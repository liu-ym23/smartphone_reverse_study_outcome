package com.bytedance.awemeopen.infra.base.env;

import com.bytedance.awemeopen.infra.base.debug.AoDebug;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.servicesapi.context.AoHostService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class AoEnv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f198594a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Function0<String> f198595b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f198596c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f198597d = null;

    static {
        f198594a = LazyKt.lazy(AoEnv$aoHostService$2.INSTANCE);
        f198595b = AoEnv$bdDeviceId$1.INSTANCE;
        f198596c = "";
        f198597d = "";
    }

    public static AoHostService a() {
        return (AoHostService) f198594a.getValue();
    }

    @JvmStatic
    public static final String g() {
        return CollectionsKt.joinToString$default(CollectionsKt.take(StringsKt.split$default((String) CollectionsKt.first(StringsKt.split$default("3.7.3", new String[]{"-"}, false, 0, 6, null)), new String[]{"."}, false, 0, 6, null), 3), ".", null, null, 0, null, null, 62, null);
    L5:
        AoLogger.c("", new Object[]{"getSdkVersionName3Digit error"});
        return "3.7.3";
    }

    @JvmStatic
    public static final boolean i() {
        return Intrinsics.areEqual("local_test", b());
    }

    @JvmStatic
    public static final String b() {
        return a().getHostChannel();
    }

    @JvmStatic
    public static final String c() {
        return a().getDeviceId();
    }

    @JvmStatic
    public static final String d() {
        return a().getHostAid();
    }

    @JvmStatic
    public static final int e() {
        return a().getHostUpdateVersionCode();
    }

    @JvmStatic
    public static final String f() {
        return a().getHostVersionName();
    }

    @JvmStatic
    public static final boolean h() {
        if (i() == false) goto L5;
    L8:
        return true;
    L5:
        if (AoDebug.b() == true) goto L8;
        return false;
    }

    @JvmStatic
    public static final boolean j() {
        if (a().f2() != AoHostService.HostType.TOB) goto L5;
        return true;
    L5:
        return false;
    }
}
