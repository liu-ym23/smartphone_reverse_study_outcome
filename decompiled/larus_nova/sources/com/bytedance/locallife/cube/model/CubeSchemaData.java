package com.bytedance.locallife.cube.model;

import com.bytedance.ee.bear.doc.structure.StructurePlugin;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0014\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u001e\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001e\u00102\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b3\u0010.\"\u0004\b4\u00100R\u001e\u00105\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b6\u0010.\"\u0004\b7\u00100R\u001e\u00108\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b9\u0010.\"\u0004\b:\u00100R\u001c\u0010;\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010%\"\u0004\b=\u0010'R\u001a\u0010>\u001a\u00020?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001e\u0010D\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\bE\u0010\u0006\"\u0004\bF\u0010\bR\u001e\u0010G\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\bH\u0010\u0006\"\u0004\bI\u0010\bR\u001e\u0010J\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\bK\u0010\u0006\"\u0004\bL\u0010\bR\u001c\u0010M\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010%\"\u0004\bO\u0010'R\u001e\u0010P\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\bQ\u0010.\"\u0004\bR\u00100¨\u0006S"}, d2 = {"Lcom/bytedance/locallife/cube/model/CubeSchemaData;", "", "()V", "disableJsCtxShare", "", "getDisableJsCtxShare", "()Ljava/lang/Boolean;", "setDisableJsCtxShare", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "enableCanvas", "getEnableCanvas", "setEnableCanvas", "enableCanvasOptimize", "getEnableCanvasOptimize", "setEnableCanvasOptimize", "enableDynamicV8", "getEnableDynamicV8", "setEnableDynamicV8", StructurePlugin.ENABLE_FONT_SCALE, "getEnableFontScale", "setEnableFontScale", "enableJsGroupThread", "getEnableJsGroupThread", "setEnableJsGroupThread", "enablePendingJsTask", "getEnablePendingJsTask", "setEnablePendingJsTask", "enablePreFetchImage", "getEnablePreFetchImage", "setEnablePreFetchImage", "enableVsyncAlignedMessageLoop", "getEnableVsyncAlignedMessageLoop", "setEnableVsyncAlignedMessageLoop", "enterFrom", "", "getEnterFrom", "()Ljava/lang/String;", "setEnterFrom", "(Ljava/lang/String;)V", "group", "getGroup", "setGroup", "lynxPresetHeight", "", "getLynxPresetHeight", "()Ljava/lang/Integer;", "setLynxPresetHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "lynxPresetHeightSpecMode", "getLynxPresetHeightSpecMode", "setLynxPresetHeightSpecMode", "lynxPresetWidth", "getLynxPresetWidth", "setLynxPresetWidth", "lynxPresetWidthSpecMode", "getLynxPresetWidthSpecMode", "setLynxPresetWidthSpecMode", "originUrl", "getOriginUrl", "setOriginUrl", "parseDuration", "", "getParseDuration", "()J", "setParseDuration", "(J)V", "presetSafePoint", "getPresetSafePoint", "setPresetSafePoint", "readResInMain", "getReadResInMain", "setReadResInMain", "renderTemplateInMain", "getRenderTemplateInMain", "setRenderTemplateInMain", "scene", "getScene", "setScene", "threadStrategy", "getThreadStrategy", "setThreadStrategy", "cube-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class CubeSchemaData {
    private Boolean disableJsCtxShare;
    private Boolean enableCanvas;
    private Boolean enableCanvasOptimize;
    private Boolean enableDynamicV8;
    private Boolean enableFontScale;
    private Boolean enableJsGroupThread;
    private Boolean enablePendingJsTask;
    private Boolean enablePreFetchImage;
    private Boolean enableVsyncAlignedMessageLoop;
    private String enterFrom;
    private String group;
    private Integer lynxPresetHeight;
    private Integer lynxPresetHeightSpecMode;
    private Integer lynxPresetWidth;
    private Integer lynxPresetWidthSpecMode;
    private String originUrl;
    private long parseDuration;
    private Boolean presetSafePoint;
    private Boolean readResInMain;
    private Boolean renderTemplateInMain;
    private String scene;
    private Integer threadStrategy;

    public CubeSchemaData() {
    }

    public final Boolean getDisableJsCtxShare() {
        return this.disableJsCtxShare;
    }

    public final Boolean getEnableCanvas() {
        return this.enableCanvas;
    }

    public final Boolean getEnableCanvasOptimize() {
        return this.enableCanvasOptimize;
    }

    public final Boolean getEnableDynamicV8() {
        return this.enableDynamicV8;
    }

    public final Boolean getEnableFontScale() {
        return this.enableFontScale;
    }

    public final Boolean getEnableJsGroupThread() {
        return this.enableJsGroupThread;
    }

    public final Boolean getEnablePendingJsTask() {
        return this.enablePendingJsTask;
    }

    public final Boolean getEnablePreFetchImage() {
        return this.enablePreFetchImage;
    }

    public final Boolean getEnableVsyncAlignedMessageLoop() {
        return this.enableVsyncAlignedMessageLoop;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getGroup() {
        return this.group;
    }

    public final Integer getLynxPresetHeight() {
        return this.lynxPresetHeight;
    }

    public final Integer getLynxPresetHeightSpecMode() {
        return this.lynxPresetHeightSpecMode;
    }

    public final Integer getLynxPresetWidth() {
        return this.lynxPresetWidth;
    }

    public final Integer getLynxPresetWidthSpecMode() {
        return this.lynxPresetWidthSpecMode;
    }

    public final String getOriginUrl() {
        return this.originUrl;
    }

    public final long getParseDuration() {
        return this.parseDuration;
    }

    public final Boolean getPresetSafePoint() {
        return this.presetSafePoint;
    }

    public final Boolean getReadResInMain() {
        return this.readResInMain;
    }

    public final Boolean getRenderTemplateInMain() {
        return this.renderTemplateInMain;
    }

    public final String getScene() {
        return this.scene;
    }

    public final Integer getThreadStrategy() {
        return this.threadStrategy;
    }

    public final void setDisableJsCtxShare(Boolean r100) {
        this.disableJsCtxShare = r100;
    }

    public final void setEnableCanvas(Boolean r100) {
        this.enableCanvas = r100;
    }

    public final void setEnableCanvasOptimize(Boolean r100) {
        this.enableCanvasOptimize = r100;
    }

    public final void setEnableDynamicV8(Boolean r100) {
        this.enableDynamicV8 = r100;
    }

    public final void setEnableFontScale(Boolean r100) {
        this.enableFontScale = r100;
    }

    public final void setEnableJsGroupThread(Boolean r100) {
        this.enableJsGroupThread = r100;
    }

    public final void setEnablePendingJsTask(Boolean r100) {
        this.enablePendingJsTask = r100;
    }

    public final void setEnablePreFetchImage(Boolean r100) {
        this.enablePreFetchImage = r100;
    }

    public final void setEnableVsyncAlignedMessageLoop(Boolean r100) {
        this.enableVsyncAlignedMessageLoop = r100;
    }

    public final void setEnterFrom(String r100) {
        this.enterFrom = r100;
    }

    public final void setGroup(String r100) {
        this.group = r100;
    }

    public final void setLynxPresetHeight(Integer r100) {
        this.lynxPresetHeight = r100;
    }

    public final void setLynxPresetHeightSpecMode(Integer r100) {
        this.lynxPresetHeightSpecMode = r100;
    }

    public final void setLynxPresetWidth(Integer r100) {
        this.lynxPresetWidth = r100;
    }

    public final void setLynxPresetWidthSpecMode(Integer r100) {
        this.lynxPresetWidthSpecMode = r100;
    }

    public final void setOriginUrl(String r100) {
        this.originUrl = r100;
    }

    public final void setParseDuration(long r100) {
        this.parseDuration = r100;
    }

    public final void setPresetSafePoint(Boolean r100) {
        this.presetSafePoint = r100;
    }

    public final void setReadResInMain(Boolean r100) {
        this.readResInMain = r100;
    }

    public final void setRenderTemplateInMain(Boolean r100) {
        this.renderTemplateInMain = r100;
    }

    public final void setScene(String r100) {
        this.scene = r100;
    }

    public final void setThreadStrategy(Integer r100) {
        this.threadStrategy = r100;
    }
}
