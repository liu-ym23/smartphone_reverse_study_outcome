package com.bytedance.ies.sdk.widgets.perf;

/* JADX INFO: loaded from: classes19.dex */
public class WidgetCostModule {
    public static final int LEVEL_ALL = 3;
    public static final int LEVEL_COMPLETE = 4;
    public static final int LEVEL_P0 = 0;
    public static final int LEVEL_P1 = 1;
    public static final int LEVEL_P2 = 2;
    public static final String TYPE_INFLATE = "inflate";
    public static final String TYPE_ON_CONTINUE_LOAD = "onContinueLoad";
    public static final String TYPE_ON_CREATE = "onCreate";
    public static final String TYPE_ON_LOAD = "onLoad";
    public static final String TYPE_ON_RESUME = "onResume";
    public static final String TYPE_ON_START = "onStart";
    public boolean hasUI;
    public int index;
    public boolean isAsync;
    public boolean isRecycle;
    public int level;
    public long onContinueLoadEnd;
    public long onContinueLoadStart;
    public long onCreateEnd;
    public long onCreateStart;
    public long onInflateEnd;
    public long onInflateStart;
    public long onLoadEnd;
    public long onLoadStart;
    public long onResumeEnd;
    public long onResumeStart;
    public long onStartEnd;
    public long onStartStart;

    public WidgetCostModule() {
    }

    public long getContinueLoadDuration() {
        return this.onContinueLoadEnd - this.onContinueLoadStart;
    }

    public long getInflateDuration() {
        return this.onInflateEnd - this.onInflateStart;
    }

    public long getLoadDuration() {
        return this.onLoadEnd - this.onLoadStart;
    }

    public long getOnCreateDuration() {
        return this.onCreateEnd - this.onCreateStart;
    }

    public long getOnResumeDuration() {
        return this.onResumeEnd - this.onResumeStart;
    }

    public long getOnStartDuration() {
        return this.onStartEnd - this.onStartStart;
    }

    public long getTotal() {
        return this.onContinueLoadEnd - this.onLoadStart;
    }

    public long getLoadOffset(long r100) {
        return this.onLoadStart - r100;
    }
}
