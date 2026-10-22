package com.lynx.tasm.service;

import android.content.Context;
import com.lynx.devtoolwrapper.ILynxLogBox;
import com.lynx.devtoolwrapper.LynxBaseInspectorController;
import com.lynx.devtoolwrapper.LynxDevtool;
import com.lynx.devtoolwrapper.LynxDevtoolCardListener;
import com.lynx.jsbridge.LynxModule;
import com.lynx.tasm.INativeLibraryLoader;
import com.lynx.tasm.LynxView;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public interface ILynxDevToolService extends IServiceProvider {

    /* JADX INFO: renamed from: com.lynx.tasm.service.ILynxDevToolService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Class $default$getServiceClass(ILynxDevToolService r100) {
            return ILynxDevToolService.class;
        }
    }

    LynxBaseInspectorController createInspectorOwner(LynxView r100, boolean r101);

    ILynxLogBox createLogBox(LynxDevtool r100);

    void devtoolEnvInit(Context r100);

    void devtoolEnvSetDevToolLibraryLoader(INativeLibraryLoader r100);

    void enableAllSessions();

    Class<? extends LynxModule> getDevToolSetModuleClass();

    boolean getLoadQJSBridge();

    boolean getLoadV8Bridge();

    boolean getLogBoxPresetValue();

    boolean getLynxDebugPresetValue();

    Class<? extends LynxModule> getLynxTrailModule();

    Class<? extends LynxModule> getLynxWebSocketModuleClass();

    @Override // com.lynx.tasm.service.IServiceProvider
    Class<? extends IServiceProvider> getServiceClass();

    void globalDebugBridgeOnPerfMetricsEvent(String r100, JSONObject r101, int r102);

    Boolean globalDebugBridgePrepareRemoteDebug(String r100);

    void globalDebugBridgeRegisterCardListener(LynxDevtoolCardListener r100);

    void globalDebugBridgeSetAppInfo(Context r100, Map<String, String> r101);

    Boolean globalDebugBridgeShouldPrepareRemoteDebug(String r100);

    boolean isDevtoolAttached();

    void setLoadQJSBridge(boolean r100);

    void setLoadV8Bridge(boolean r100);

    void setLogBoxPresetValue(boolean r100);

    void setLynxDebugPresetValue(boolean r100);
}
