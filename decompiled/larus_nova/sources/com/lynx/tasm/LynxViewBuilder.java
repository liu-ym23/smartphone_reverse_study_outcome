package com.lynx.tasm;

import android.content.Context;
import android.net.Uri;
import com.lynx.jsbridge.LynxModule;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.ILynxUIRenderer;
import com.lynx.tasm.behavior.LynxUIRenderer;
import com.lynx.tasm.service.ILynxTrailService;
import com.lynx.tasm.service.ILynxTrailServiceExtension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public class LynxViewBuilder extends com.lynx.tasm.group.e<LynxViewBuilder> implements com.lynx.tasm.group.b {
    boolean enableLayoutOnly;
    k7a.a fetcher;
    w7a.a.b fontLoader;
    boolean hasInheritedGroupRuntimeOptions;
    v7a.h imageFetcher;
    LynxBackgroundRuntime lynxBackgroundRuntime;
    Object lynxModuleExtraData;
    Map<String, String> lynxViewConfig;
    com.lynx.tasm.group.c lynxViewGroup;
    Map<String, String> mImageCustomParam;
    u7a.h mLynxImageConfig;
    d8a.j resourceFetcher;
    d8a.b templateProvider;
    Uri uri;

    public u7a.h getLynxImageConfig() {
        return null;
    }

    public boolean isEnableAutoConcurrency() {
        return false;
    }

    public LynxViewBuilder setEnableCreateViewAsync(boolean r100) {
        return this;
    }

    public LynxViewBuilder setEnableLayoutOnly(boolean r100) {
        return this;
    }

    public LynxViewBuilder setEnableRadonCompatible(boolean r100) {
        return this;
    }

    public LynxViewBuilder setImageFetcher(v7a.h r100) {
        return this;
    }

    public LynxViewBuilder setLynxImageConfig(u7a.h r100) {
        return this;
    }

    public LynxViewBuilder setResourceFetcher(d8a.j r100) {
        return this;
    }

    private void inheritLynxViewGroupRuntimeOptions() {
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.hasInheritedGroupRuntimeOptions == true) goto L66;
        q r101 = r100.getLynxRuntimeOptions();
        q r102 = this.lynxRuntimeOptions;
        r102.getClass();
        if (r101 == null) goto L58;
        if (r101 == r102) goto L58;
        List<com.lynx.jsbridge.f> r103 = r102.f383553d;
        ArrayList r104 = (ArrayList) r103;
        r104.addAll(0, r101.f383553d);
        Iterator r105 = ((HashMap) r101.f383554e).entrySet().iterator();
    L13:
        if (r105.hasNext() == false) goto L18;
        Map.Entry r106 = (Map.Entry) r105.next();
        Map<String, d8a.k> r107 = r102.f383554e;
        HashMap r108 = (HashMap) r107;
        if (r108.containsKey(r106.getKey()) == true) goto L13;
        Map<String, d8a.k> r109 = r102.f383554e;
        HashMap r110 = (HashMap) r109;
        r110.put(r106.getKey(), r106.getValue());
        goto L13
    L18:
        if (r102.f383552c != null) goto L21;
        r102.f383552c = r101.f383552c;
    L21:
        if (r102.f383550a != null) goto L26;
        Boolean r111 = r101.f383550a;
        if (r111 == null) goto L26;
        r102.f383550a = r111;
    L26:
        if (r102.f383551b != null) goto L29;
        r102.f383551b = r101.f383551b;
    L29:
        if (r102.f383561l != null) goto L34;
        Boolean r112 = r101.f383561l;
        if (r112 == null) goto L34;
        r102.f383561l = r112;
    L34:
        if (r102.f383555f != null) goto L37;
        r102.f383555f = r101.f383555f;
    L37:
        if (r102.f383556g != null) goto L40;
        r102.f383556g = r101.f383556g;
    L40:
        if (r102.f383562m != null) goto L43;
        r102.f383562m = r101.f383562m;
    L43:
        if (r102.f383560k != LynxBooleanOption.UNSET) goto L45;
        r102.f383560k = r101.f383560k;
    L45:
        f8a.a r113 = r102.f383557h;
        if (r113 != null) goto L49;
        r113 = r101.f383557h;
    L49:
        r102.f383557h = r113;
        g8a.a r114 = r102.f383558i;
        if (r114 != null) goto L53;
        r114 = r101.f383558i;
    L53:
        r102.f383558i = r114;
        h8a.a r115 = r102.f383559j;
        if (r115 != null) goto L57;
        r115 = r101.f383559j;
    L57:
        r102.f383559j = r115;
    L58:
        this.hasInheritedGroupRuntimeOptions = true;
        return;
    }

    @Override // com.lynx.tasm.group.b
    public com.lynx.tasm.behavior.c getBehaviorRegistry() {
        if (this.hasBehaviorRegistrySet == true) goto L8;
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 == null) goto L8;
        return r100.getBehaviorRegistry();
    L8:
        return this.behaviorRegistry;
    }

    @Override // com.lynx.tasm.group.b
    public LynxColorScheme getColorScheme() {
        if (this.hasColorSchemeSet == true) goto L5;
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 == null) goto L11;
        return r100.getColorScheme();
    L11:
        return LynxColorScheme.LIGHT;
    L5:
        return this.colorScheme;
    }

    @Override // com.lynx.tasm.group.b
    public HashMap getContextData() {
        HashMap<String, Object> r100 = this.mContextData;
        if (r100 == null) goto L5;
        return r100;
    L5:
        com.lynx.tasm.group.c r101 = this.lynxViewGroup;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.getContextData();
    }

    @Override // com.lynx.tasm.group.b
    public Float getDensity() {
        if (this.hasDensitySet == true) goto L8;
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 == null) goto L8;
        return r100.getDensity();
    L8:
        return this.densityOverride;
    }

    @Override // com.lynx.tasm.group.b
    public int getEmbeddedMode() {
        if (this.hasEmbeddedModeSet == true) goto L8;
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 == null) goto L8;
        return r100.getEmbeddedMode();
    L8:
        return this.embeddedMode;
    }

    @Override // com.lynx.tasm.group.b
    public float getFontScale() {
        if (this.hasFontScaleSet == true) goto L8;
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 == null) goto L8;
        return r100.getFontScale();
    L8:
        return this.fontScale;
    }

    @Override // com.lynx.tasm.group.b
    public boolean getForceDarkAllowed() {
        if (this.hasForceDarkAllowedSet == true) goto L8;
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 == null) goto L8;
        return r100.getForceDarkAllowed();
    L8:
        return this.forceDarkAllowed;
    }

    @Override // com.lynx.tasm.group.b
    public j getLogicExecutor() {
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 == null) goto L5;
        r100.getLogicExecutor();
    L5:
        return null;
    }

    @Override // com.lynx.tasm.group.b
    public f8a.a getLynxGenericResourceFetcher() {
        f8a.a r100 = this.lynxRuntimeOptions.f383557h;
        if (r100 == null) goto L5;
        return r100;
    L5:
        com.lynx.tasm.group.c r101 = this.lynxViewGroup;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.getLynxGenericResourceFetcher();
    }

    @Override // com.lynx.tasm.group.b
    public LynxGroup getLynxGroup() {
        LynxGroup r100 = this.lynxRuntimeOptions.f383552c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        com.lynx.tasm.group.c r101 = this.lynxViewGroup;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.getLynxGroup();
    }

    @Override // com.lynx.tasm.group.b
    public g8a.a getLynxMediaResourceFetcher() {
        g8a.a r100 = this.lynxRuntimeOptions.f383558i;
        if (r100 == null) goto L5;
        return r100;
    L5:
        com.lynx.tasm.group.c r101 = this.lynxViewGroup;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.getLynxMediaResourceFetcher();
    }

    @Override // com.lynx.tasm.group.b
    public h8a.a getLynxTemplateResourceFetcher() {
        h8a.a r100 = this.lynxRuntimeOptions.f383559j;
        if (r100 == null) goto L5;
        return r100;
    L5:
        com.lynx.tasm.group.c r101 = this.lynxViewGroup;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.getLynxTemplateResourceFetcher();
    }

    @Override // com.lynx.tasm.group.b
    public int getPresetHeightMeasureSpec() {
        if (this.hasPresetMeasureSpec == true) goto L8;
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 == null) goto L8;
        return r100.getPresetHeightMeasureSpec();
    L8:
        return this.presetHeightMeasureSpec;
    }

    @Override // com.lynx.tasm.group.b
    public int getPresetWidthMeasureSpec() {
        if (this.hasPresetMeasureSpec == true) goto L8;
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 == null) goto L8;
        return r100.getPresetWidthMeasureSpec();
    L8:
        return this.presetWidthMeasureSpec;
    }

    @Override // com.lynx.tasm.group.b
    public int getScreenHeight() {
        if (this.hasScreenSizeSet == true) goto L8;
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 == null) goto L8;
        return r100.getScreenHeight();
    L8:
        return this.screenHeight;
    }

    @Override // com.lynx.tasm.group.b
    public int getScreenWidth() {
        if (this.hasScreenSizeSet == true) goto L8;
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 == null) goto L8;
        return r100.getScreenWidth();
    L8:
        return this.screenWidth;
    }

    @Override // com.lynx.tasm.group.b
    public String getTapSlop() {
        if (this.hasTapSlopSet == true) goto L8;
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 == null) goto L8;
        return r100.getTapSlop();
    L8:
        return this.tapSlop;
    }

    @Override // com.lynx.tasm.group.b
    public ThreadStrategyForRendering getThreadStrategy() {
        ThreadStrategyForRendering r100 = this.threadStrategy;
        if (r100 == null) goto L5;
        return r100;
    L5:
        com.lynx.tasm.group.c r101 = this.lynxViewGroup;
        if (r101 == null) goto L10;
        return r101.getThreadStrategy();
    L10:
        return ThreadStrategyForRendering.ALL_ON_UI;
    }

    @Override // com.lynx.tasm.group.b
    public k getUIRendererCreator() {
        if (this.hasUIRendererCreatorSet == true) goto L8;
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 == null) goto L8;
        return r100.getUIRendererCreator();
    L8:
        return this.uiRendererCreator;
    }

    @Override // com.lynx.tasm.group.b
    public boolean isDebuggable() {
        if (this.hasDebuggableSet == true) goto L8;
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 == null) goto L8;
        return r100.isDebuggable();
    L8:
        return this.debuggable;
    }

    @Override // com.lynx.tasm.group.b
    public boolean isEnableAirStrictMode() {
        if (this.hasEnableAirStrictModeSet == true) goto L8;
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 == null) goto L8;
        return r100.isEnableAirStrictMode();
    L8:
        return this.enableAirStrictMode;
    }

    @Override // com.lynx.tasm.group.b
    public boolean isEnableAsyncHydration() {
        if (this.hasEnableAsyncHydrationSet == true) goto L8;
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 == null) goto L8;
        return r100.isEnableAsyncHydration();
    L8:
        return this.enableAsyncHydration;
    }

    @Override // com.lynx.tasm.group.b
    public boolean isEnableAutoExpose() {
        if (this.hasEnableAutoExposeSet == true) goto L8;
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 == null) goto L8;
        return r100.isEnableAutoExpose();
    L8:
        return this.enableAutoExpose;
    }

    @Override // com.lynx.tasm.group.b
    public LynxBooleanOption isEnableGenericResourceFetcher() {
        LynxBooleanOption r100 = this.lynxRuntimeOptions.f383560k;
        if (r100 == LynxBooleanOption.UNSET) goto L5;
        return r100;
    L5:
        com.lynx.tasm.group.c r101 = this.lynxViewGroup;
        if (r101 != null) goto L8;
        return r100;
    L8:
        return r101.isEnableGenericResourceFetcher();
    }

    @Override // com.lynx.tasm.group.b
    public boolean isEnableLayoutSafepoint() {
        if (this.hasEnableLayoutSafepointSet == true) goto L8;
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 == null) goto L8;
        return r100.isEnableLayoutSafepoint();
    L8:
        return this.enableLayoutSafepoint;
    }

    @Override // com.lynx.tasm.group.b
    public boolean isEnableLepusModule() {
        if (this.hasEnableLepusModuleSet == true) goto L8;
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 == null) goto L8;
        return r100.isEnableLepusModule();
    L8:
        return this.enableLepusModule;
    }

    @Override // com.lynx.tasm.group.b
    public boolean isEnableMTSModule() {
        if (this.hasEnableMTSModuleSet == true) goto L8;
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 == null) goto L8;
        return r100.isEnableMTSModule();
    L8:
        return this.enableMTSModule;
    }

    @Override // com.lynx.tasm.group.b
    public boolean isEnableMultiAsyncThread() {
        if (this.hasEnableMultiAsyncThreadSet == true) goto L8;
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 == null) goto L8;
        return r100.isEnableMultiAsyncThread();
    L8:
        return this.enableMultiAsyncThread;
    }

    @Override // com.lynx.tasm.group.b
    public boolean isEnablePendingJsTask() {
        if (this.hasPendingJsTaskSet == true) goto L8;
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 == null) goto L8;
        return r100.isEnablePendingJsTask();
    L8:
        return this.enablePendingJsTask;
    }

    @Override // com.lynx.tasm.group.b
    public boolean isEnablePreUpdateData() {
        if (this.hasEnablePreUpdateDataSet == true) goto L8;
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 == null) goto L8;
        return r100.isEnablePreUpdateData();
    L8:
        return this.enablePreUpdateData;
    }

    @Override // com.lynx.tasm.group.b
    public boolean isEnableSyncFlush() {
        if (this.hasEnableSyncFlushSet == true) goto L8;
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 == null) goto L8;
        return r100.isEnableSyncFlush();
    L8:
        return this.enableSyncFlush;
    }

    @Override // com.lynx.tasm.group.b
    public boolean isEnableUnifiedPipeline() {
        if (this.hasEnableUnifiedPipelineSet == true) goto L8;
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 == null) goto L8;
        return r100.isEnableUnifiedPipeline();
    L8:
        return this.enableUnifiedPipeline;
    }

    @Override // com.lynx.tasm.group.b
    public boolean isEnableVSyncAlignedMessageLoop() {
        if (this.hasEnableVSyncAlignedMessageLoopSet == true) goto L8;
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 == null) goto L8;
        return r100.isEnableVSyncAlignedMessageLoop();
    L8:
        return this.enableVSyncAlignedMessageLoop;
    }

    public LynxViewBuilder() {
        this.enableLayoutOnly = LynxEnv.inst().isLayoutOnlyEnabled();
        this.uri = null;
        this.hasInheritedGroupRuntimeOptions = false;
        LynxEnv.inst().lazyInitIfNeeded();
        this.templateProvider = LynxEnv.inst().getTemplateProvider();
    }

    public ILynxUIRenderer createLynxUIRenderer() {
        ((com.lynx.tasm.behavior.l0) getUIRendererCreator()).getClass();
        LynxUIRenderer r100 = new LynxUIRenderer();
        setThreadStrategyForRendering(getThreadStrategy());
        return r100;
    }

    @Override // com.lynx.tasm.group.b
    public q getLynxRuntimeOptions() {
        inheritLynxViewGroupRuntimeOptions();
        return this.lynxRuntimeOptions;
    }

    @Override // com.lynx.tasm.group.b
    public boolean isEnableJSRuntime() {
        if (isEnableAirStrictMode() == false) goto L7;
        return false;
    L7:
        if (this.hasEnableJSRuntimeSet == true) goto L12;
        com.lynx.tasm.group.c r100 = this.lynxViewGroup;
        if (r100 == null) goto L12;
        return r100.isEnableJSRuntime();
    L12:
        return this.enableJSRuntime;
    }

    public Map<String, String> getLynxViewConfig() {
        return this.lynxViewConfig;
    }

    public Uri getUri() {
        return this.uri;
    }

    @Override // com.lynx.tasm.group.b
    public boolean hasPresetMeasureSpec() {
        return this.hasPresetMeasureSpec;
    }

    public LynxViewBuilder(Context r100) {
        this();
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder addBehavior(com.lynx.tasm.behavior.a r100) {
        return (LynxViewBuilder) super.addBehavior(r100);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder addBehaviors(List<com.lynx.tasm.behavior.a> r100) {
        return (LynxViewBuilder) super.addBehaviors(r100);
    }

    public LynxView build(Context r100) {
        TraceEvent.beginSection("CreateLynxView");
        ILynxTrailService r101 = (ILynxTrailService) i8a.n.c().a(ILynxTrailService.class);
        if ((r101 instanceof ILynxTrailServiceExtension) == false) goto L5;
        ((ILynxTrailServiceExtension) r101).parseLynxViewBuilder(this);
    L5:
        LynxView r102 = new LynxView(r100, this);
        if (TraceEvent.enableTrace() == false) goto L11;
        HashMap r103 = new HashMap();
        if (r102.getLynxContext() == null) goto L10;
        r103.put("instance_id", String.valueOf(r102.getLynxContext().getInstanceId()));
    L10:
        TraceEvent.endSection(0, "CreateLynxView", r103);
    L11:
        return r102;
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder enableAutoExpose(boolean r100) {
        return (LynxViewBuilder) super.enableAutoExpose(r100);
    }

    public LynxViewBuilder mergeLynxRuntimeOptions(q r100) {
        q r101 = getLynxRuntimeOptions();
        if (r101 == null) goto L5;
        r101.b(r100);
    L5:
        return this;
    }

    @Override // com.lynx.tasm.group.e
    public void registerModuleAuthValidator(LynxModule.a r100) {
        super.registerModuleAuthValidator(r100);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setBytecodeSourceUrl(String r100) {
        return (LynxViewBuilder) super.setBytecodeSourceUrl(r100);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setCodeCacheSourceUrl(String r100) {
        return (LynxViewBuilder) super.setCodeCacheSourceUrl(r100);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setColorScheme(LynxColorScheme r100) {
        return (LynxViewBuilder) super.setColorScheme(r100);
    }

    @Override // com.lynx.tasm.group.e
    public void setCustomBehaviorRegistry(com.lynx.tasm.behavior.c r100) {
        super.setCustomBehaviorRegistry(r100);
    }

    public LynxViewBuilder setDynamicComponentFetcher(k7a.a r100) {
        this.fetcher = r100;
        return this;
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setEnableAirStrictMode(boolean r100) {
        return (LynxViewBuilder) super.setEnableAirStrictMode(r100);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setEnableAutoConcurrency(boolean r100) {
        return (LynxViewBuilder) super.setEnableAutoConcurrency(r100);
    }

    @Override // com.lynx.tasm.group.e
    public void setEnableGenericResourceFetcher(LynxBooleanOption r100) {
        super.setEnableGenericResourceFetcher(r100);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setEnableJSRuntime(boolean r100) {
        return (LynxViewBuilder) super.setEnableJSRuntime(r100);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setEnableLayoutSafepoint(boolean r100) {
        return (LynxViewBuilder) super.setEnableLayoutSafepoint(r100);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setEnableMultiAsyncThread(boolean r100) {
        return (LynxViewBuilder) super.setEnableMultiAsyncThread(r100);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setEnablePendingJsTask(boolean r100) {
        return (LynxViewBuilder) super.setEnablePendingJsTask(r100);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setEnablePreUpdateData(boolean r100) {
        return (LynxViewBuilder) super.setEnablePreUpdateData(r100);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setEnableSyncFlush(boolean r100) {
        return (LynxViewBuilder) super.setEnableSyncFlush(r100);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setEnableUserBytecode(boolean r100) {
        return (LynxViewBuilder) super.setEnableUserBytecode(r100);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setEnableUserCodeCache(boolean r100) {
        return (LynxViewBuilder) super.setEnableUserCodeCache(r100);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setEnableVSyncAlignedMessageLoop(boolean r100) {
        return (LynxViewBuilder) super.setEnableVSyncAlignedMessageLoop(r100);
    }

    public LynxViewBuilder setFontLoader(w7a.a.b r100) {
        this.fontLoader = r100;
        return this;
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setFontScale(float r100) {
        return (LynxViewBuilder) super.setFontScale(r100);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setForceDarkAllowed(boolean r100) {
        return (LynxViewBuilder) super.setForceDarkAllowed(r100);
    }

    @Override // com.lynx.tasm.group.e
    public void setGenericResourceFetcher(f8a.a r100) {
        super.setGenericResourceFetcher(r100);
    }

    public LynxViewBuilder setImageCustomParam(Map<String, String> r100) {
        this.mImageCustomParam = r100;
        return this;
    }

    public LynxViewBuilder setLynxBackgroundRuntime(LynxBackgroundRuntime r100) {
        this.lynxBackgroundRuntime = r100;
        return this;
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setLynxGroup(LynxGroup r100) {
        return (LynxViewBuilder) super.setLynxGroup(r100);
    }

    public LynxViewBuilder setLynxModuleExtraData(Object r100) {
        this.lynxModuleExtraData = r100;
        return this;
    }

    public LynxViewBuilder setLynxViewConfig(Map<String, String> r100) {
        this.lynxViewConfig = r100;
        return this;
    }

    public LynxViewBuilder setLynxViewGroup(com.lynx.tasm.group.c r100) {
        this.lynxViewGroup = r100;
        this.hasInheritedGroupRuntimeOptions = false;
        return this;
    }

    @Override // com.lynx.tasm.group.e
    public void setMediaResourceFetcher(g8a.a r100) {
        super.setMediaResourceFetcher(r100);
    }

    public LynxViewBuilder setTemplateProvider(d8a.b r100) {
        this.templateProvider = r100;
        return this;
    }

    @Override // com.lynx.tasm.group.e
    public void setTemplateResourceFetcher(h8a.a r100) {
        super.setTemplateResourceFetcher(r100);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setThreadStrategyForRendering(ThreadStrategyForRendering r100) {
        return (LynxViewBuilder) super.setThreadStrategyForRendering(r100);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setUIRunningMode(boolean r100) {
        return setUIRunningMode(r100);
    }

    public LynxViewBuilder setUri(Uri r100) {
        this.uri = r100;
        return this;
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e addBehavior(com.lynx.tasm.behavior.a r100) {
        return addBehavior(r100);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e addBehaviors(List r100) {
        return addBehaviors(r100);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e enableAutoExpose(boolean r100) {
        return enableAutoExpose(r100);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setBytecodeSourceUrl(String r100) {
        return setBytecodeSourceUrl(r100);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setCodeCacheSourceUrl(String r100) {
        return setCodeCacheSourceUrl(r100);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setColorScheme(LynxColorScheme r100) {
        return setColorScheme(r100);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setEnableAirStrictMode(boolean r100) {
        return setEnableAirStrictMode(r100);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setEnableAutoConcurrency(boolean r100) {
        return setEnableAutoConcurrency(r100);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setEnableJSRuntime(boolean r100) {
        return setEnableJSRuntime(r100);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setEnableLayoutSafepoint(boolean r100) {
        return setEnableLayoutSafepoint(r100);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setEnableMultiAsyncThread(boolean r100) {
        return setEnableMultiAsyncThread(r100);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setEnablePendingJsTask(boolean r100) {
        return setEnablePendingJsTask(r100);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setEnablePreUpdateData(boolean r100) {
        return setEnablePreUpdateData(r100);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setEnableSyncFlush(boolean r100) {
        return setEnableSyncFlush(r100);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setEnableUserBytecode(boolean r100) {
        return setEnableUserBytecode(r100);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setEnableUserCodeCache(boolean r100) {
        return setEnableUserCodeCache(r100);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setEnableVSyncAlignedMessageLoop(boolean r100) {
        return setEnableVSyncAlignedMessageLoop(r100);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setFontScale(float r100) {
        return setFontScale(r100);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setForceDarkAllowed(boolean r100) {
        return setForceDarkAllowed(r100);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setLynxGroup(LynxGroup r100) {
        return setLynxGroup(r100);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setThreadStrategyForRendering(ThreadStrategyForRendering r100) {
        return setThreadStrategyForRendering(r100);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setUIRunningMode(boolean r100) {
        super.setUIRunningMode(r100);
        return this;
    }

    public LynxViewBuilder insertLynxViewConfig(String r100, String r101) {
        if (this.lynxViewConfig != null) goto L6;
        this.lynxViewConfig = new HashMap();
    L6:
        if (this.lynxViewConfig.get(r100) != null) goto L8;
        this.lynxViewConfig.put(r100, r101);
    L8:
        return this;
    }

    @Override // com.lynx.tasm.group.e
    public void registerModule(String r100, Class<? extends LynxModule> r101) {
        super.registerModule(r100, r101);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setPresetMeasuredSpec(int r100, int r101) {
        return (LynxViewBuilder) super.setPresetMeasuredSpec(r100, r101);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setResourceProvider(String r100, d8a.k r101) {
        return (LynxViewBuilder) super.setResourceProvider(r100, r101);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setScreenSize(int r100, int r101) {
        return (LynxViewBuilder) super.setScreenSize(r100, r101);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setPresetMeasuredSpec(int r100, int r101) {
        return setPresetMeasuredSpec(r100, r101);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setResourceProvider(String r100, d8a.k r101) {
        return setResourceProvider(r100, r101);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setScreenSize(int r100, int r101) {
        return setScreenSize(r100, r101);
    }

    @Override // com.lynx.tasm.group.e
    public void registerModule(String r100, Class<? extends LynxModule> r101, Object r102) {
        super.registerModule(r100, r101, r102);
    }
}
