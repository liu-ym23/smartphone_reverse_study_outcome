package com.lynx.devtoolwrapper;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.InputEvent;
import com.lynx.jsbridge.LynxModule;
import com.lynx.jsbridge.LynxModuleFactory;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.PageReloadHelper;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.r;
import com.lynx.tasm.service.ILynxDevToolService;
import i8a.n;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class LynxDevtool {
    private static final String TAG = "LynxDevtool";
    private static ILynxDevToolService sDevToolService;
    private ILynxLogBox mLogBox;
    private LynxBaseInspectorController mOwner;
    private PageReloadHelper mReloader;
    private WeakReference<LynxTemplateRender> mRender;
    private WeakReference<LynxView> mView;

    public void destroy() {
        LynxBaseInspectorController r100 = this.mOwner;
        if (r100 == null) goto L6;
        r100.destroy();
        this.mOwner = null;
        LLog.i(TAG, "mOwner = null");
        return;
    }

    public Boolean enableAirStrictMode() {
        LynxTemplateRender r100 = this.mRender.get();
        if (r100 == null) goto L7;
        return Boolean.valueOf(r100.enableAirStrictMode());
    L7:
        return Boolean.FALSE;
    }

    public Map<String, Object> getAllJsSource() {
        LynxTemplateRender r100 = this.mRender.get();
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getAllJsSource();
    }

    public LynxBaseInspectorOwner getBaseInspectorOwner() {
        LynxBaseInspectorController r100 = this.mOwner;
        if ((r100 instanceof LynxBaseInspectorOwner) == true) goto L5;
        return null;
    L5:
        return (LynxBaseInspectorOwner) r100;
    }

    public LynxContext getLynxContext() {
        LynxTemplateRender r100 = this.mRender.get();
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getLynxContext();
    }

    public String getTemplateUrl() {
        LynxTemplateRender r100 = this.mRender.get();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.getTemplateUrl();
    }

    public void onEnterBackground() {
        LynxBaseInspectorController r100 = this.mOwner;
        if (r100 == null) goto L6;
        r100.pauseCasting();
        return;
    }

    public void onEnterForeground() {
        LynxBaseInspectorController r100 = this.mOwner;
        if (r100 == null) goto L6;
        r100.continueCasting();
        return;
    }

    public void onPageUpdate() {
        LynxBaseInspectorController r100 = this.mOwner;
        if (r100 == null) goto L6;
        r100.onPageUpdate();
        return;
    }

    public LynxBaseInspectorController getBaseInspectorController() {
        return this.mOwner;
    }

    public void attach(LynxView r100) {
        this.mView = new WeakReference(r100);
        LynxBaseInspectorController r101 = this.mOwner;
        if (r101 == null) goto L6;
        r101.attach(r100);
        return;
    }

    public void attachContext(Context r100) {
        ILynxLogBox r101 = this.mLogBox;
        if (r101 == null) goto L6;
        r101.attachContext(r100);
        return;
    }

    public void attachLynxUIOwner(LynxUIOwner r100) {
        LynxBaseInspectorController r101 = this.mOwner;
        if (r101 == null) goto L6;
        r101.attachLynxUIOwnerToAgent(r100);
        this.mOwner.setReloadHelper(this.mReloader);
        return;
    }

    public void attachToDebugBridge(String r100) {
        LynxBaseInspectorController r101 = this.mOwner;
        if (r101 == null) goto L6;
        r101.attachToDebugBridge(r100);
        return;
    }

    public String getDebugInfoUrl(String r100) {
        LynxBaseInspectorController r101 = this.mOwner;
        if (r101 != null) goto L5;
        return "";
    L5:
        return r101.getDebugInfoUrl(r100);
    }

    public long onBackgroundRuntimeCreated(String r100) {
        LynxBaseInspectorController r101 = this.mOwner;
        if (r101 != null) goto L5;
        return 0;
    L5:
        return r101.onBackgroundRuntimeCreated(r100);
    }

    public void onGlobalPropsChanged(TemplateData r100) {
        LynxBaseInspectorController r101 = this.mOwner;
        if (r101 == null) goto L5;
        r101.onGlobalPropsUpdated(r100);
    L5:
        PageReloadHelper r102 = this.mReloader;
        if (r102 == null) goto L9;
        r102.onGlobalPropsUpdated(r100);
        return;
    }

    public void onMTSRuntimeCreated(long r100) {
        LynxBaseInspectorController r101 = this.mOwner;
        if (r101 == null) goto L6;
        r101.onMTSRuntimeCreated(r100);
        return;
    }

    public void onReceiveMessageEvent(ReadableMap r100) {
        LynxBaseInspectorController r101 = this.mOwner;
        if (r101 == null) goto L6;
        r101.onReceiveMessageEvent(r100);
        return;
    }

    public void onRegisterModule(LynxModuleFactory r100) {
        if (LynxEnv.inst().isLynxDebugEnabled() == true) goto L5;
        return;
    L5:
        ILynxDevToolService r101 = sDevToolService;
        if (r101 != null) goto L9;
        LLog.e(TAG, "sDevToolService is null");
        return;
    L9:
        Class<? extends LynxModule> r102 = r101.getDevToolSetModuleClass();
        if (r102 == null) goto L12;
        r100.c(r102.getSimpleName(), r102, null);
        LLog.i(TAG, "register LynxDevToolSetModule!");
    L12:
        Class<? extends LynxModule> r103 = sDevToolService.getLynxWebSocketModuleClass();
        if (r103 == null) goto L15;
        r100.c(r103.getSimpleName(), r103, null);
        LLog.i(TAG, "register LynxWebSocketModule!");
    L15:
        Class<? extends LynxModule> r104 = sDevToolService.getLynxTrailModule();
        if (r104 == null) goto L19;
        r100.c(r104.getSimpleName(), r104, null);
        LLog.i(TAG, "register LynxTrailModule!");
        return;
    }

    public void onRootViewInputEvent(InputEvent r100) {
        LynxBaseInspectorController r101 = this.mOwner;
        if (r101 == null) goto L6;
        r101.onRootViewInputEvent(r100);
        return;
    }

    public void onTemplateAssemblerCreated(long r100) {
        LynxBaseInspectorController r101 = this.mOwner;
        if (r101 == null) goto L6;
        r101.onTemplateAssemblerCreated(r100);
        return;
    }

    public void onTemplateDataChanged(TemplateData r100) {
        LynxBaseInspectorController r101 = this.mOwner;
        if (r101 == null) goto L5;
        r101.onTemplateDataUpdated(r100);
    L5:
        PageReloadHelper r102 = this.mReloader;
        if (r102 == null) goto L9;
        r102.onTemplateDataUpdated(r100);
        return;
    }

    public void onTemplateDataReset(TemplateData r100) {
        LynxBaseInspectorController r101 = this.mOwner;
        if (r101 == null) goto L5;
        r101.onTemplateDataReset(r100);
    L5:
        PageReloadHelper r102 = this.mReloader;
        if (r102 == null) goto L9;
        r102.onTemplateDataReset(r100);
        return;
    }

    public void onTemplateLoadSuccess(byte[] r100) {
        PageReloadHelper r101 = this.mReloader;
        if (r101 == null) goto L6;
        r101.onTemplateLoadSuccess(r100);
        return;
    }

    public void showErrorMessage(LynxError r100) {
        ILynxLogBox r101 = this.mLogBox;
        if (r101 == null) goto L5;
        r101.showLogMessage(r100);
    L5:
        LynxBaseInspectorController r102 = this.mOwner;
        if (r102 == null) goto L9;
        r102.showErrorMessageOnConsole(r100);
        return;
    }

    public LynxDevtool(Context r100, boolean r101) {
        this.mOwner = null;
        this.mLogBox = null;
        this.mReloader = null;
        this.mView = null;
        this.mRender = null;
        init(null, null, r101, r100);
    }

    public void attach(LynxView r100, LynxTemplateRender r101) {
        this.mView = new WeakReference(r100);
        this.mRender = new WeakReference(r101);
        LynxBaseInspectorController r102 = this.mOwner;
        if (r102 == null) goto L6;
        r102.attach(r100);
    L6:
        if (this.mReloader == null) goto L8;
        this.mReloader.attach(r100);
    L8:
        LynxBaseInspectorController r103 = this.mOwner;
        if (r103 == null) goto L11;
        r103.setDevToolDelegate(new r(r101));
    L11:
        DisplayMetrics r104 = r101.getLynxContext().getScreenMetrics();
        updateScreenMetrics(r104.widthPixels, r104.heightPixels, r104.density);
    }

    public void onPerfMetricsEvent(String r100, JSONObject r101) {
        LynxBaseInspectorController r102 = this.mOwner;
        if (r102 == null) goto L6;
        r102.onPerfMetricsEvent(r100, r101);
        return;
    }

    public LynxDevtool(LynxView r100, LynxTemplateRender r101, boolean r102) {
        this.mOwner = null;
        this.mLogBox = null;
        this.mReloader = null;
        this.mView = null;
        this.mRender = null;
        init(r100, r101, r102, r101.getLynxContext().getContext());
    }

    public void onLoadFromBundle(TemplateBundle r100, TemplateData r101, String r102) {
        PageReloadHelper r103 = this.mReloader;
        if (r103 == null) goto L5;
        r103.loadFromBundle(r100, r101, r102);
    L5:
        ILynxLogBox r104 = this.mLogBox;
        if (r104 == null) goto L9;
        r104.onLoadTemplate();
        return;
    }

    public void onLoadFromLocalFile(byte[] r100, TemplateData r101, String r102) {
        PageReloadHelper r103 = this.mReloader;
        if (r103 == null) goto L5;
        r103.loadFromLocalFile(r100, r101, r102);
    L5:
        ILynxLogBox r104 = this.mLogBox;
        if (r104 == null) goto L9;
        r104.onLoadTemplate();
        return;
    }

    public void updateScreenMetrics(int r100, int r101, float r102) {
        LynxBaseInspectorController r103 = this.mOwner;
        if (r103 == null) goto L6;
        r103.updateScreenMetrics(r100, r101, r102);
        return;
    }

    private void init(LynxView r100, LynxTemplateRender r101, boolean r102, Context r103) {
        TraceEvent.beginSection("LynxDevtool initialized");
        LLog.i(TAG, "Initialize LynxDevtool, lynxDebugEnabled:" + LynxEnv.inst().isLynxDebugEnabled());     // Catch: Exception -> L29
        this.mView = new WeakReference(r100);     // Catch: Exception -> L29
        this.mRender = new WeakReference(r101);     // Catch: Exception -> L29
        if (LynxEnv.inst().isLynxDebugEnabled() == false) goto L21;
        LLog.i(TAG, "devtoolEnabled:" + LynxEnv.inst().isDevtoolEnabled() + ", logBoxEnabled:" + LynxEnv.inst().isLogBoxEnabled() + ", debuggable:" + r102);     // Catch: Exception -> L29
        sDevToolService = (ILynxDevToolService) n.c().a(ILynxDevToolService.class);     // Catch: Exception -> L29
        if (LynxEnv.inst().isDevtoolEnabled() == true) goto L8;
        if (r102 == true) goto L8;
    L14:
        if (LynxEnv.inst().isLogBoxEnabled() == false) goto L18;
        ILynxDevToolService r104 = sDevToolService;     // Catch: Exception -> L29
        if (r104 == null) goto L18;
        this.mLogBox = r104.createLogBox(this);     // Catch: Exception -> L29
        LLog.i(TAG, "LogBox init");     // Catch: Exception -> L29
    L18:
        if (r101 == null) goto L21;
        DisplayMetrics r105 = r101.getLynxContext().getScreenMetrics();     // Catch: Exception -> L29
        updateScreenMetrics(r105.widthPixels, r105.heightPixels, r105.density);     // Catch: Exception -> L29
    L8:
        ILynxDevToolService r106 = sDevToolService;     // Catch: Exception -> L29
        if (r106 == null) goto L14;
        LynxBaseInspectorController r107 = r106.createInspectorOwner(r100, r102);     // Catch: Exception -> L29
        this.mOwner = r107;     // Catch: Exception -> L29
        if (r107 == null) goto L14;
        LLog.i(TAG, "owner init");     // Catch: Exception -> L29
    L21:
        if (this.mOwner == null) goto L23;
    L24:
        this.mReloader = new PageReloadHelper(r100);     // Catch: Exception -> L29
    L25:
        LynxBaseInspectorController r108 = this.mOwner;     // Catch: Exception -> L29
        if (r108 == null) goto L31;
        r108.setDevToolDelegate(new r(r101));     // Catch: Exception -> L29
    L31:
        TraceEvent.endSection("LynxDevtool initialized");
        return;
    L23:
        if (this.mLogBox == null) goto L25;
    L29:
        e = move-exception;
        LLog.e(TAG, "failed to init LynxDevtool: " + e.toString());
        this.mOwner = null;
        this.mLogBox = null;
        this.mReloader = null;
        goto L31
    }

    public void onLoadFromURL(String r100, String r101, TemplateData r102, Map<String, Object> r103, String r104) {
        PageReloadHelper r105 = this.mReloader;
        if (r105 == null) goto L5;
        r105.saveURL(r100, r102, r103, r104);
    L5:
        ILynxLogBox r106 = this.mLogBox;
        if (r106 == null) goto L9;
        r106.onLoadTemplate();
        return;
    }
}
