package com.volcengine.zeus.plugin;

import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.log.ZeusLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class PluginProtocolVersionChecker {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(PluginProtocolVersionChecker$appProtocolVersion$2.INSTANCE);
    }

    public static boolean a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "pluginPkgName");
        Intrinsics.checkNotNullParameter(r2, "pluginVersionCode");
        return b(r1, r2, (String) a.getValue());
    }

    public static boolean b(String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "pluginPkgName");
        Intrinsics.checkNotNullParameter(r8, "pluginVersionCode");
        Intrinsics.checkNotNullParameter(r9, "hostProtocolVersionCode");
        if (GlobalParam.getInstance().checkHostProtocolVersion() == true) goto L7;
        ZeusLogger.w("ZeusPluginProtocolVersionChecker", "host protocol version check is disabled: pluginPkg = " + r7 + ", pluginVer = " + r8 + ", hostVer = " + r9);
        return true;
    L7:
        if (r8.length() == (r9.length() + 1)) goto L9;
    L11:
        ZeusLogger.w("ZeusPluginProtocolVersionChecker", "version not match: pluginPkg = " + r7 + ", pluginVer = " + r8 + ", hostVer = " + r9);
        return false;
    L9:
        if (StringsKt.startsWith$default(r8, r9, false, 2, null) == false) goto L11;
        ZeusLogger.i("ZeusPluginProtocolVersionChecker", "version match: pluginPkg = " + r7 + ", pluginVer = " + r8 + ", hostVer = " + r9);
        return true;
    }
}
