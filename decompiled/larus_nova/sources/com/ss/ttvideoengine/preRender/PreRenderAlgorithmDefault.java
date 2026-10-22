package com.ss.ttvideoengine.preRender;

import com.ss.ttvideoengine.setting.SettingsHelper;
import com.ss.ttvideoengine.source.Source;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class PreRenderAlgorithmDefault implements PreRenderAlgorithm {
    private static final String TAG = "PreRender_AlgorithmDef";
    private int mAutoRangeKB;
    private PreRenderTriggerListener mBufferListener;
    private PreRenderTriggerListener mListener;
    private Source mSource;
    private SourceCache mSourceCache;
    private boolean mSourceCacheEnough;
    private SourceCacheListener mSourceCacheListener;
    private boolean mStop;
    private final String mTraceId;
    private boolean mTriggered;

    public static /* synthetic */ void a(PreRenderAlgorithmDefault r100, Source r101, long r102) {
        r100.lambda$checkSourceCache$0(r101, r102);
    }

    @Override // com.ss.ttvideoengine.preRender.PreRenderAlgorithm
    public void stop() {
        this.mStop = true;
        PlayBufferManager.instance().removeListener(this.mBufferListener);
        SourceCache r100 = this.mSourceCache;
        if (r100 == null) goto L6;
        r100.removeSourceCacheListener(this.mSourceCacheListener);
        this.mSourceCache.stop();
        this.mSourceCache = null;
        return;
    }

    private void checkPlayBuffer() {
        this.mBufferListener = new AnonymousClass1(this);
        PlayBufferManager.instance().addListener(this.mBufferListener);
    }

    private void pausePreRender() {
        if (this.mStop == false) goto L5;
        return;
    L5:
        if (this.mTriggered == true) goto L8;
        return;
    L8:
        if (this.mSourceCacheEnough == false) goto L10;
        return;
    L10:
        TTVideoEngineLog.d(TAG, this.mTraceId + " pause preRender");
        this.mTriggered = false;
        PreRenderTriggerListener r100 = this.mListener;
        if (r100 == null) goto L15;
        r100.onPausePreRender();
        return;
    }

    private void startPreRender() {
        if (this.mStop == false) goto L5;
        return;
    L5:
        if (this.mTriggered == true) goto L13;
        this.mTriggered = true;
        PreRenderTriggerListener r100 = this.mListener;
        if (r100 == null) goto L12;
        r100.onTriggerPreRender();
        return;
    L12:
        return;
    }

    public void checkSourceCache() {
        this.mSourceCacheListener = new a(this);
        SourceCache r100 = new SourceCache(TimerDefault.instance());
        this.mSourceCache = r100;
        r100.setSource(this.mSource);
        this.mSourceCache.addSourceCacheListener(this.mSourceCacheListener);
        this.mSourceCache.start();
    }

    @Override // com.ss.ttvideoengine.preRender.PreRenderAlgorithm
    public int getAutoRange() {
        return this.mAutoRangeKB * 1024;
    }

    public PreRenderAlgorithmDefault() {
        this.mTraceId = "@" + hashCode();
        this.mAutoRangeKB = 500;
        this.mSourceCacheEnough = false;
        this.mTriggered = false;
        this.mStop = false;
    }

    private void updateSettingsInfo() {
        JSONObject r100 = SettingsHelper.helper().getVodJsonObject(PlayBufferManager.PRERENDER_KEY);
        if (r100 != null) goto L5;
        return;
    L5:
        this.mAutoRangeKB = r100.optInt(PlayBufferManager.AUTO_RANGE_K_KEY, 500);
    }

    public static /* synthetic */ String access$000(PreRenderAlgorithmDefault r100) {
        return r100.mTraceId;
    }

    public static /* synthetic */ void access$100(PreRenderAlgorithmDefault r100) {
        r100.startPreRender();
    }

    public static /* synthetic */ void access$200(PreRenderAlgorithmDefault r100) {
        r100.pausePreRender();
    }

    private /* synthetic */ void lambda$checkSourceCache$0(Source r100, long r101) {
        if (r101 <= (((long) this.mAutoRangeKB) * 1024)) goto L6;
        this.mSourceCacheEnough = true;
        TTVideoEngineLog.d(TAG, this.mTraceId + " start preRender cache enough " + r101);
        startPreRender();
        return;
    }

    @Override // com.ss.ttvideoengine.preRender.PreRenderAlgorithm
    public void shouldStartPreRender(Source r100, PreRenderTriggerListener r101) {
        TTVideoEngineLog.d(TAG, this.mTraceId + " shouldStartPreRender " + r100);
        updateSettingsInfo();
        this.mSourceCacheEnough = false;
        this.mTriggered = false;
        this.mStop = false;
        this.mListener = r101;
        this.mSource = r100;
        checkPlayBuffer();
        checkSourceCache();
    }
}
