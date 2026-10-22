package com.lynx.devtoolwrapper;

import android.content.Context;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.service.ILynxDevToolService;
import i8a.n;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class LynxDevtoolGlobalHelper {
    private static final String TAG = "LynxDevtoolGlobalHelper";
    private static ILynxDevToolService sDevToolService;
    private Map<String, String> mAppInfo;
    private boolean remoteDebugAvailable;

    /* JADX INFO: renamed from: com.lynx.devtoolwrapper.LynxDevtoolGlobalHelper$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class SingletonHolder {
        private static final LynxDevtoolGlobalHelper INSTANCE = null;

        private SingletonHolder() {
        }

        static {
            INSTANCE = new LynxDevtoolGlobalHelper(null);
        }

        public static /* synthetic */ LynxDevtoolGlobalHelper access$000() {
            return INSTANCE;
        }
    }

    private LynxDevtoolGlobalHelper() {
        this.remoteDebugAvailable = false;
        HashMap r100 = new HashMap();
        this.mAppInfo = r100;
        r100.put(com.heytap.mcssdk.constant.b.C, LynxEnv.inst().getLynxVersion());
        if (LynxEnv.inst().isLynxDebugEnabled() == false) goto L6;
        initRemoteDebugIfNecessary();
        sDevToolService = (ILynxDevToolService) n.c().a(ILynxDevToolService.class);
        return;
    }

    public static LynxDevtoolGlobalHelper getInstance() {
        return SingletonHolder.access$000();
    }

    private boolean initRemoteDebugIfNecessary() {
        if (LynxEnv.inst().isLynxDebugEnabled() == true) goto L6;
        return false;
    L6:
        if (LynxEnv.inst().isNativeLibraryLoaded() == true) goto L10;
        LLog.w(TAG, "liblynx.so not loaded!");
        return false;
    L10:
        if (this.remoteDebugAvailable == false) goto L12;
        return true;
    L12:
        this.remoteDebugAvailable = true;
        return true;
    }

    public boolean isRemoteDebugAvailable() {
        return this.remoteDebugAvailable;
    }

    public /* synthetic */ LynxDevtoolGlobalHelper(AnonymousClass1 r100) {
        this();
    }

    public boolean prepareRemoteDebug(String r100) {
        if (initRemoteDebugIfNecessary() == true) goto L6;
        return false;
    L6:
        if (LynxEnv.inst().isLynxDebugEnabled() == true) goto L10;
        LLog.w(TAG, "Debugging not supported in this package");
        return false;
    L10:
        if (LynxEnv.inst().isDevtoolEnabled() == true) goto L13;
        LLog.w(TAG, "DevTool not enabled, turn on the switch!");
        return false;
    L13:
        ILynxDevToolService r101 = sDevToolService;
        if (r101 != null) goto L16;
        LLog.e(TAG, "failed to get DevToolService");
        return false;
    L16:
        return r101.globalDebugBridgePrepareRemoteDebug(r100).booleanValue();
    }

    public void registerCardListener(LynxDevtoolCardListener r100) {
        if (initRemoteDebugIfNecessary() == true) goto L5;
        return;
    L5:
        ILynxDevToolService r101 = sDevToolService;
        if (r101 == null) goto L8;
        r101.globalDebugBridgeRegisterCardListener(r100);
        return;
    L8:
        LLog.e(TAG, "failed to get DevToolService");
    }

    public boolean shouldPrepareRemoteDebug(String r100) {
        if (initRemoteDebugIfNecessary() == true) goto L5;
        return false;
    L5:
        ILynxDevToolService r101 = sDevToolService;
        if (r101 != null) goto L8;
        LLog.e(TAG, "failed to get DevToolService");
        return false;
    L8:
        return r101.globalDebugBridgeShouldPrepareRemoteDebug(r100).booleanValue();
    }

    public void setAppInfo(Context r100, Map<String, String> r101) {
        if (r101 == null) goto L5;
        this.mAppInfo.putAll(r101);
    L5:
        if (initRemoteDebugIfNecessary() == true) goto L7;
        return;
    L7:
        ILynxDevToolService r102 = sDevToolService;
        if (r102 == null) goto L10;
        r102.globalDebugBridgeSetAppInfo(r100, this.mAppInfo);
        return;
    L10:
        LLog.e(TAG, "failed to get DevToolService");
    }

    public void setAppInfo(String r100, String r101) {
        setAppInfo(null, r100, r101);
    }

    public void onPerfMetricsEvent(String r100, JSONObject r101, int r102) {
        if (this.remoteDebugAvailable == true) goto L5;
        return;
    L5:
        ILynxDevToolService r103 = sDevToolService;
        if (r103 == null) goto L8;
        r103.globalDebugBridgeOnPerfMetricsEvent(r100, r101, r102);
        return;
    L8:
        LLog.e(TAG, "failed to get DevToolService");
    }

    public void setAppInfo(Context r100, String r101, String r102) {
        HashMap r103 = new HashMap();
        r103.put("App", r101);
        r103.put("AppVersion", r102);
        setAppInfo(r100, r103);
    }
}
