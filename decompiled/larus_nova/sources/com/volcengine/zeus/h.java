package com.volcengine.zeus;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.plugin.PluginManager;
import com.volcengine.zeus.servermanager.ServerManagerHelper;
import com.volcengine.zeus.service.server.PluginProcessManager;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f462707a = 0;

    static {
    }

    public static void a(String r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "pluginPackageName");
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "trigger plugin load: " + r100 + ", shouldRegisterProcessPlugin = " + r110);
        String r101 = PluginManager.getInstance().getPlugin(r100).getPluginProcess();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L24;
        if (StringsKt.contains$default(r101, ":", false, 2, null) == false) goto L13;
        r101 = (String) ListProtector.get(StringsKt.split$default(r101, new String[]{":"}, false, 0, 6, null), 1);
    L13:
        if (r110 == true) goto L25;
    L15:
        IPluginProcessManager r111 = ServerManagerHelper.getPluginProcessManager(r101);     // Catch: Throwable -> L20
        if (r111 == null) goto L19;
        r111.warmUpPlugin(r100);     // Catch: Throwable -> L20
        return;
    L19:
        throw new IllegalStateException("pluginProcessManager nullptr");     // Catch: Throwable -> L20
    L25:
        PluginProcessManager.INSTANCE.registerProcessPlugin(r101, r100);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "warmUpPlugin failed", th);
        return;
    L24:
        throw new IllegalArgumentException("not a cross process plugin");
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
