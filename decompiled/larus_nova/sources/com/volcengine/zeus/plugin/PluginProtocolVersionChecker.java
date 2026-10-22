package com.volcengine.zeus.plugin;

import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.log.ZeusLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
public final class PluginProtocolVersionChecker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f462770a = null;

    static {
        f462770a = LazyKt.lazy(PluginProtocolVersionChecker$appProtocolVersion$2.INSTANCE);
    }

    public static boolean a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "pluginPkgName");
        Intrinsics.checkNotNullParameter(r101, "pluginVersionCode");
        return b(r100, r101, (String) f462770a.getValue());
    }

    public static boolean b(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "pluginPkgName");
        Intrinsics.checkNotNullParameter(r101, "pluginVersionCode");
        Intrinsics.checkNotNullParameter(r102, "hostProtocolVersionCode");
        if (GlobalParam.getInstance().checkHostProtocolVersion() == true) goto L7;
        ZeusLogger.w("ZeusPluginProtocolVersionChecker", "host protocol version check is disabled: pluginPkg = " + r100 + ", pluginVer = " + r101 + ", hostVer = " + r102);
        return true;
    L7:
        if (r101.length() == (r102.length() + 1)) goto L9;
    L11:
        ZeusLogger.w("ZeusPluginProtocolVersionChecker", "version not match: pluginPkg = " + r100 + ", pluginVer = " + r101 + ", hostVer = " + r102);
        return false;
    L9:
        if (StringsKt.startsWith$default(r101, r102, false, 2, null) == false) goto L11;
        ZeusLogger.i("ZeusPluginProtocolVersionChecker", "version match: pluginPkg = " + r100 + ", pluginVer = " + r101 + ", hostVer = " + r102);
        return true;
    }
}
