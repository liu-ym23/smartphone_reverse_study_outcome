package com.ttnet.org.chromium.base;

import android.content.Context;
import android.provider.Settings;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ttnet.org.chromium.base.supplier.Supplier;

/* JADX INFO: loaded from: classes41.dex */
public final class CommandLineInitUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String COMMAND_LINE_FILE_PATH = "/data/local";
    private static final String COMMAND_LINE_FILE_PATH_DEBUG_APP = "/data/local/tmp";

    static {
    }

    private CommandLineInitUtil() {
    }

    private static String getDebugApp(Context r100) {
        boolean r101 = false;
        if (Settings.Global.getInt(r100.getContentResolver(), "adb_enabled", 0) != 1) goto L5;
        r101 = true;
    L5:
        if (r101 == true) goto L7;
        return null;
    L7:
        return Settings.Global.getString(r100.getContentResolver(), "debug_app");
    }

    public static void initCommandLine(String r100) {
        initCommandLine(r100, null);
    }

    private static boolean shouldUseDebugCommandLine(Supplier<Boolean> r100) {
        if (r100 != null) goto L5;
    L7:
        Context r101 = ContextUtils.getApplicationContext();
        if (r101.getPackageName().equals(getDebugApp(r101)) == false) goto L10;
        return true;
    L10:
        if (BuildInfo.isDebugAndroid() == true) goto L15;
        return false;
    L15:
        return true;
    L5:
        if (r100.get().booleanValue() == false) goto L7;
        return true;
    }

    public static void initCommandLine(String r100, Supplier<Boolean> r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(COMMAND_LINE_FILE_PATH_DEBUG_APP, r100);
        if (r102.exists() == true) goto L5;
    L6:
        r102 = new PolarisFileWrapper(COMMAND_LINE_FILE_PATH, r100);
    L7:
        CommandLine.initFromFile(r102.getPath());
        return;
    L5:
        if (shouldUseDebugCommandLine(r101) == true) goto L7;
        goto L6
    }
}
