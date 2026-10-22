package com.volcengine.zeus.plugin.preinstall;

import android.content.SharedPreferences;
import com.volcengine.zeus.log.ZeusLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ZeusPreInstallSpUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f462821a = null;

    public static SharedPreferences a() {
        return (SharedPreferences) f462821a.getValue();
    }

    static {
        f462821a = LazyKt.lazy(ZeusPreInstallSpUtil$sharedPreferences$2.INSTANCE);
    }

    public static void c(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "pluginPkgName");
        ZeusLogger.i("ZeusPreInstallSpUtil", "reset: pluginPkgName = " + r100 + ", pluginVersion = " + r101);
        a().edit().remove(b("extra_info", r100, r101)).remove(b("is_pre_installed", r100, r101)).apply();
    }

    public static String b(String r100, String r101, int r102) {
        return r101 + '/' + r102 + '/' + r100;
    }

    public static void d(int r100, long r101, String r102) {
        ZeusLogger.i("ZeusPreInstallSpUtil", "setHostInfo: hostVersion = " + r100 + ", toolsVersion = 1, preInstallTime = " + r101 + ", hostAbi = " + r102);
        a().edit().putInt("host_version", r100).putInt("tool_version", 1).putLong("pre_install_time", r101).putString("host_abi", r102).apply();
    }

    public static void e(String r100, int r101, String r102) {
        ZeusLogger.i("ZeusPreInstallSpUtil", "setIsPreInstalled: pluginPkgName = " + r100 + ", pluginVersion = " + r101 + ", extraInfo = " + r102);
        SharedPreferences.Editor r103 = a().edit();
        if (r100 == null) goto L5;
        String r104 = r100;
    L6:
        SharedPreferences.Editor r105 = r103.putBoolean(b("is_pre_installed", r104, r101), true);
        if (r100 != null) goto L10;
        r100 = "";
    L10:
        String r106 = b("extra_info", r100, r101);
        if (r102 != null) goto L14;
        r102 = "";
    L14:
        r105.putString(r106, r102).apply();
        return;
    L5:
        r104 = "";
        goto L6
    }
}
