package com.lynx.tasm.group;

import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxColorScheme;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.j;
import com.lynx.tasm.k;
import com.lynx.tasm.q;
import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public interface b {
    com.lynx.tasm.behavior.c getBehaviorRegistry();

    LynxColorScheme getColorScheme();

    HashMap getContextData();

    Float getDensity();

    int getEmbeddedMode();

    float getFontScale();

    boolean getForceDarkAllowed();

    j getLogicExecutor();

    f8a.a getLynxGenericResourceFetcher();

    LynxGroup getLynxGroup();

    g8a.a getLynxMediaResourceFetcher();

    q getLynxRuntimeOptions();

    h8a.a getLynxTemplateResourceFetcher();

    int getPresetHeightMeasureSpec();

    int getPresetWidthMeasureSpec();

    int getScreenHeight();

    int getScreenWidth();

    String getTapSlop();

    ThreadStrategyForRendering getThreadStrategy();

    k getUIRendererCreator();

    boolean hasPresetMeasureSpec();

    boolean isDebuggable();

    boolean isEnableAirStrictMode();

    boolean isEnableAsyncHydration();

    boolean isEnableAutoExpose();

    LynxBooleanOption isEnableGenericResourceFetcher();

    boolean isEnableJSRuntime();

    boolean isEnableLayoutSafepoint();

    boolean isEnableLepusModule();

    boolean isEnableMTSModule();

    boolean isEnableMultiAsyncThread();

    boolean isEnablePendingJsTask();

    boolean isEnablePreUpdateData();

    boolean isEnableSyncFlush();

    boolean isEnableUnifiedPipeline();

    boolean isEnableVSyncAlignedMessageLoop();
}
