package com.lynx.tasm.group;

import com.lynx.jsbridge.LynxModule;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxColorScheme;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.behavior.f;
import com.lynx.tasm.behavior.l0;
import com.lynx.tasm.group.e;
import com.lynx.tasm.k;
import com.lynx.tasm.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public class e<T extends e<T>> {
    static Float defaultDensity;
    protected com.lynx.tasm.behavior.c behaviorRegistry;
    protected LynxColorScheme colorScheme;
    protected boolean debuggable;
    protected Float densityOverride;
    protected int embeddedMode;
    protected boolean enableAirStrictMode;
    protected boolean enableAsyncHydration;
    protected boolean enableAutoConcurrency;
    protected boolean enableAutoExpose;
    protected boolean enableJSRuntime;
    protected boolean enableLayoutSafepoint;
    protected boolean enableLepusModule;
    protected boolean enableMTSModule;
    protected boolean enableMultiAsyncThread;
    protected boolean enablePendingJsTask;
    protected boolean enablePreUpdateData;
    protected boolean enableSyncFlush;
    protected boolean enableUnifiedPipeline;
    protected boolean enableVSyncAlignedMessageLoop;
    protected float fontScale;
    protected boolean forceDarkAllowed;
    protected boolean hasBehaviorRegistrySet;
    protected boolean hasColorSchemeSet;
    protected boolean hasDebuggableSet;
    protected boolean hasDensitySet;
    protected boolean hasEmbeddedModeSet;
    protected boolean hasEnableAirStrictModeSet;
    protected boolean hasEnableAsyncHydrationSet;
    protected boolean hasEnableAutoExposeSet;
    protected boolean hasEnableJSRuntimeSet;
    protected boolean hasEnableLayoutSafepointSet;
    protected boolean hasEnableLepusModuleSet;
    protected boolean hasEnableMTSModuleSet;
    protected boolean hasEnableMultiAsyncThreadSet;
    protected boolean hasEnablePreUpdateDataSet;
    protected boolean hasEnableSyncFlushSet;
    protected boolean hasEnableUnifiedPipelineSet;
    protected boolean hasEnableVSyncAlignedMessageLoopSet;
    protected boolean hasFontScaleSet;
    protected boolean hasForceDarkAllowedSet;
    protected boolean hasPendingJsTaskSet;
    protected boolean hasPresetMeasureSpec;
    protected boolean hasScreenSizeSet;
    protected boolean hasTapSlopSet;
    protected boolean hasUIRendererCreatorSet;
    protected q lynxRuntimeOptions;
    protected HashMap<String, Object> mContextData;
    protected int presetHeightMeasureSpec;
    protected int presetWidthMeasureSpec;
    protected int screenHeight;
    protected int screenWidth;
    protected String tapSlop;
    protected ThreadStrategyForRendering threadStrategy;
    protected k uiRendererCreator;

    public e() {
        this.enableMultiAsyncThread = true;
        this.hasEnableMultiAsyncThreadSet = false;
        this.hasDensitySet = false;
        this.hasBehaviorRegistrySet = false;
        this.hasEnableAutoExposeSet = false;
        this.hasEnableLayoutSafepointSet = false;
        this.hasEnableUnifiedPipelineSet = false;
        this.forceDarkAllowed = false;
        this.hasForceDarkAllowedSet = false;
        this.enableSyncFlush = false;
        this.hasEnableSyncFlushSet = false;
        this.enableAutoConcurrency = false;
        this.enableVSyncAlignedMessageLoop = false;
        this.hasEnableVSyncAlignedMessageLoopSet = false;
        this.enablePendingJsTask = false;
        this.hasPendingJsTaskSet = false;
        this.hasPresetMeasureSpec = false;
        this.enableAsyncHydration = false;
        this.hasEnableAsyncHydrationSet = false;
        this.enableJSRuntime = true;
        this.hasEnableJSRuntimeSet = false;
        this.enableAirStrictMode = false;
        this.hasEnableAirStrictModeSet = false;
        this.debuggable = false;
        this.hasDebuggableSet = false;
        this.fontScale = 1.0f;
        this.hasFontScaleSet = false;
        this.colorScheme = LynxColorScheme.LIGHT;
        this.hasColorSchemeSet = false;
        this.enablePreUpdateData = false;
        this.hasEnablePreUpdateDataSet = false;
        this.threadStrategy = null;
        this.screenWidth = -1;
        this.screenHeight = -1;
        this.hasScreenSizeSet = false;
        this.hasUIRendererCreatorSet = false;
        this.embeddedMode = 0;
        this.hasEmbeddedModeSet = false;
        this.enableMTSModule = false;
        this.hasEnableMTSModuleSet = false;
        this.enableLepusModule = true;
        this.hasEnableLepusModuleSet = false;
        this.tapSlop = "50px";
        this.hasTapSlopSet = false;
        LynxEnv.inst().lazyInitIfNeeded();
        this.lynxRuntimeOptions = new q();
        this.behaviorRegistry = new com.lynx.tasm.behavior.c(LynxEnv.inst().getBehaviorMap());
        this.uiRendererCreator = new l0();
        Float r100 = defaultDensity;
        if (r100 == null) goto L6;
        this.densityOverride = r100;
        return;
    }

    public static void setDefaultDensity(Float r100) {
        defaultDensity = r100;
    }

    public T addBehavior(com.lynx.tasm.behavior.a r100) {
        this.behaviorRegistry.a(r100);
        this.hasBehaviorRegistrySet = true;
        return this;
    }

    public T addBehaviors(List<com.lynx.tasm.behavior.a> r100) {
        this.behaviorRegistry.b(r100);
        this.hasBehaviorRegistrySet = true;
        return this;
    }

    public T enableAutoExpose(boolean r100) {
        this.enableAutoExpose = r100;
        this.hasEnableAutoExposeSet = true;
        return this;
    }

    public void registerModuleAuthValidator(LynxModule.a r100) {
        this.lynxRuntimeOptions.f383562m = r100;
    }

    public T setBehaviors(List<com.lynx.tasm.behavior.a> r100) {
        if (r100 == null) goto L4;
        this.behaviorRegistry.b(r100);
        this.hasBehaviorRegistrySet = true;
    L4:
        return this;
    }

    public T setBytecodeSourceUrl(String r100) {
        this.lynxRuntimeOptions.f383551b = r100;
        return this;
    }

    public T setCodeCacheSourceUrl(String r100) {
        setBytecodeSourceUrl(r100);
        return this;
    }

    public T setColorScheme(LynxColorScheme r100) {
        if (r100 != null) goto L4;
        return this;
    L4:
        this.colorScheme = r100;
        this.hasColorSchemeSet = true;
        return this;
    }

    public void setCustomBehaviorRegistry(com.lynx.tasm.behavior.c r100) {
        this.behaviorRegistry = r100;
        this.hasBehaviorRegistrySet = true;
    }

    public T setDebuggable(boolean r100) {
        this.debuggable = r100;
        this.hasDebuggableSet = true;
        return this;
    }

    public T setDensity(float r100) {
        this.densityOverride = Float.valueOf(r100);
        this.hasDensitySet = true;
        return this;
    }

    public T setEmbeddedMode(int r100) {
        this.embeddedMode = r100;
        this.hasEmbeddedModeSet = true;
        if ((r100 & 1) <= 0) goto L5;
        com.lynx.tasm.behavior.c r101 = this.behaviorRegistry;
        int r102 = f.f382037a;
        r101.f381999b = com.lynx.tasm.behavior.e.f382005a;
    L5:
        return this;
    }

    public T setEnableAirStrictMode(boolean r100) {
        this.enableAirStrictMode = r100;
        this.hasEnableAirStrictModeSet = true;
        return this;
    }

    public T setEnableAsyncHydration(boolean r100) {
        this.enableAsyncHydration = r100;
        this.hasEnableAsyncHydrationSet = true;
        return this;
    }

    public T setEnableAutoConcurrency(boolean r100) {
        this.enableAutoConcurrency = r100;
        return this;
    }

    public void setEnableGenericResourceFetcher(LynxBooleanOption r100) {
        this.lynxRuntimeOptions.f383560k = r100;
    }

    public T setEnableJSRuntime(boolean r100) {
        this.enableJSRuntime = r100;
        this.hasEnableJSRuntimeSet = true;
        return this;
    }

    public T setEnableLayoutSafepoint(boolean r100) {
        this.enableLayoutSafepoint = r100;
        this.hasEnableLayoutSafepointSet = true;
        return this;
    }

    public T setEnableLepusModule(boolean r100) {
        this.enableLepusModule = r100;
        this.hasEnableLepusModuleSet = true;
        return this;
    }

    public T setEnableMTSModule(boolean r100) {
        this.enableMTSModule = r100;
        this.hasEnableMTSModuleSet = true;
        return this;
    }

    public T setEnableMultiAsyncThread(boolean r100) {
        this.enableMultiAsyncThread = r100;
        this.hasEnableMultiAsyncThreadSet = true;
        return this;
    }

    public T setEnablePendingJsTask(boolean r100) {
        this.enablePendingJsTask = r100;
        this.hasPendingJsTaskSet = true;
        return this;
    }

    public T setEnablePreUpdateData(boolean r100) {
        this.enablePreUpdateData = r100;
        this.hasEnablePreUpdateDataSet = true;
        return this;
    }

    public T setEnableSyncFlush(boolean r100) {
        this.enableSyncFlush = r100;
        this.hasEnableSyncFlushSet = true;
        return this;
    }

    public T setEnableUnifiedPipeline(boolean r100) {
        this.enableUnifiedPipeline = r100;
        this.hasEnableUnifiedPipelineSet = true;
        return this;
    }

    public T setEnableUserBytecode(boolean r100) {
        q r101 = this.lynxRuntimeOptions;
        r101.f383550a = Boolean.valueOf(r100);
        return this;
    }

    public T setEnableUserCodeCache(boolean r100) {
        setEnableUserBytecode(r100);
        return this;
    }

    public T setEnableVSyncAlignedMessageLoop(boolean r100) {
        this.enableVSyncAlignedMessageLoop = r100;
        this.hasEnableVSyncAlignedMessageLoopSet = true;
        return this;
    }

    public T setFontScale(float r100) {
        this.fontScale = r100;
        this.hasFontScaleSet = true;
        return this;
    }

    public T setForceDarkAllowed(boolean r100) {
        this.forceDarkAllowed = r100;
        this.hasForceDarkAllowedSet = true;
        return this;
    }

    public void setGenericResourceFetcher(f8a.a r100) {
        this.lynxRuntimeOptions.f383557h = r100;
    }

    public T setLynxGroup(LynxGroup r100) {
        this.lynxRuntimeOptions.f383552c = r100;
        return this;
    }

    public void setMediaResourceFetcher(g8a.a r100) {
        this.lynxRuntimeOptions.f383558i = r100;
    }

    public T setTapSlop(String r100) {
        this.tapSlop = r100;
        this.hasTapSlopSet = true;
        return this;
    }

    public void setTemplateResourceFetcher(h8a.a r100) {
        this.lynxRuntimeOptions.f383559j = r100;
    }

    public T setThreadStrategyForRendering(ThreadStrategyForRendering r100) {
        if (r100 == null) goto L4;
        this.threadStrategy = r100;
    L4:
        return this;
    }

    public T setUIRendererCreator(k r100) {
        this.uiRendererCreator = r100;
        this.hasUIRendererCreatorSet = true;
        return this;
    }

    public T setUIRunningMode(boolean r100) {
        if (r100 == false) goto L4;
        this.threadStrategy = ThreadStrategyForRendering.ALL_ON_UI;
    L5:
        return this;
    L4:
        this.threadStrategy = ThreadStrategyForRendering.PART_ON_LAYOUT;
        goto L5
    }

    public T registerContextData(String r100, Object r101) {
        if (this.mContextData != null) goto L5;
        this.mContextData = new HashMap();
    L5:
        this.mContextData.put(r100, r101);
        return this;
    }

    public void registerModule(String r100, Class<? extends LynxModule> r101) {
        registerModule(r100, r101, null);
    }

    public T setPresetMeasuredSpec(int r100, int r101) {
        this.presetHeightMeasureSpec = r101;
        this.presetWidthMeasureSpec = r100;
        this.hasPresetMeasureSpec = true;
        return this;
    }

    public T setResourceProvider(String r100, d8a.k r101) {
        ((HashMap) this.lynxRuntimeOptions.f383554e).put(r100, r101);
        return this;
    }

    public T setScreenSize(int r100, int r101) {
        this.screenWidth = r100;
        this.screenHeight = r101;
        this.hasScreenSizeSet = true;
        return this;
    }

    public void registerModule(String r100, Class<? extends LynxModule> r101, Object r102) {
        q r103 = this.lynxRuntimeOptions;
        r103.getClass();
        com.lynx.jsbridge.f r104 = new com.lynx.jsbridge.f();
        r104.f381363b = r101;
        r104.f381364c = r102;
        r104.f381362a = r100;
        ((ArrayList) r103.f383553d).add(r104);
    }
}
