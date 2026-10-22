package com.ss.ttvideoengine.preRender;

import android.text.TextUtils;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineStateListener;
import com.ss.ttvideoengine.setting.SettingsHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class PlayBufferManager implements PlayBufferListener, VideoEngineStateListener {
    public static final String AUTO_RANGE_K_KEY = "auto_range_k";
    public static final int DEFAULT_AUTO_RANGE_K = 500;
    public static final int DEFAULT_START_BUFFER_S = 14;
    public static final int DEFAULT_STOP_BUFFER_S = 3;
    public static final String PRERENDER_KEY = "prerender";
    public static final String START_BUFFER_S_KEY = "start_buffer_s";
    public static final String STOP_BUFFER_S_KEY = "stop_buffer_s";
    private static final String TAG = "PreRender_PlayBufferManager";
    private int mCustomStartBufferInS;
    private int mCustomStopBufferInS;
    private String mEngineHash;
    private final CopyOnWriteArrayList<PreRenderTriggerListener> mListeners;
    private PlayBuffer mPlayBuffer;
    private int mStartBufferInS;
    private int mStopBufferInS;
    private final Timer mTimer;
    private volatile boolean mTriggered;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.preRender.PlayBufferManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Holder {
        private static final PlayBufferManager PLAY_BUFFER_MANAGER = null;

        private Holder() {
        }

        static {
            PLAY_BUFFER_MANAGER = new PlayBufferManager(null);
        }

        public static /* synthetic */ PlayBufferManager access$100() {
            return PLAY_BUFFER_MANAGER;
        }
    }

    private PlayBufferManager() {
        this.mStartBufferInS = 14;
        this.mStopBufferInS = 3;
        this.mTimer = TimerDefault.instance();
        this.mListeners = new CopyOnWriteArrayList();
    }

    public static PlayBufferManager instance() {
        return Holder.access$100();
    }

    private void updateSettingsInfo() {
        JSONObject r100 = SettingsHelper.helper().getVodJsonObject(PRERENDER_KEY);
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.mCustomStartBufferInS > 0) goto L9;
        this.mStartBufferInS = r100.optInt(START_BUFFER_S_KEY, 14);
    L9:
        if (this.mCustomStopBufferInS > 0) goto L12;
        this.mStopBufferInS = r100.optInt(STOP_BUFFER_S_KEY, 3);
        return;
    }

    public /* synthetic */ PlayBufferManager(AnonymousClass1 r100) {
        this();
    }

    private void pausePreRender(String r100) {
        if (this.mTriggered == true) goto L5;
        return;
    L5:
        TTVideoEngineLog.d(TAG, "pause PreRender " + r100);
        this.mTriggered = false;
        Iterator<PreRenderTriggerListener> r101 = this.mListeners.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        r101.next().onPausePreRender();
        goto L7
    }

    private void triggerPreRender(String r100) {
        if (this.mTriggered == false) goto L5;
        return;
    L5:
        TTVideoEngineLog.d(TAG, "trigger PreRender " + r100);
        this.mTriggered = true;
        Iterator<PreRenderTriggerListener> r101 = this.mListeners.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        r101.next().onTriggerPreRender();
        goto L7
    }

    public void addListener(PreRenderTriggerListener r100) {
        TTVideoEngineLog.d(TAG, "addListener triggered " + this.mTriggered);
        updateSettingsInfo();
        if (r100 != null) goto L5;
        return;
    L5:
        this.mListeners.addIfAbsent(r100);
        if (this.mTriggered == false) goto L8;
        r100.onTriggerPreRender();
        return;
    L8:
        r100.onPausePreRender();
    }

    public synchronized void enginePlay(TTVideoEngine r100) {
        monitor-enter(this);
        TTVideoEngineLog.d(TAG, "enginePlay " + r100);     // Catch: Throwable -> L14
        if (r100 != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        pausePreRender("new enginePlay");     // Catch: Throwable -> L14
        this.mEngineHash = r100.getHash();     // Catch: Throwable -> L14
        if (this.mPlayBuffer != null) goto L11;
        PlayBuffer r101 = new PlayBuffer(this.mTimer);     // Catch: Throwable -> L14
        this.mPlayBuffer = r101;     // Catch: Throwable -> L14
        r101.addPlayBufferListener(this);     // Catch: Throwable -> L14
    L11:
        this.mPlayBuffer.setEngine(r100);     // Catch: Throwable -> L14
        this.mPlayBuffer.start();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized void engineStop(TTVideoEngine r100) {
        monitor-enter(this);
        TTVideoEngineLog.d(TAG, "engineStop " + r100);     // Catch: Throwable -> L16
        if (r100 != null) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (TextUtils.equals(r100.getHash(), this.mEngineHash) == false) goto L14;
        PlayBuffer r101 = this.mPlayBuffer;     // Catch: Throwable -> L16
        if (r101 == null) goto L13;
        r101.removePlayBufferListener(this);     // Catch: Throwable -> L16
        this.mPlayBuffer.stop();     // Catch: Throwable -> L16
        this.mPlayBuffer = null;     // Catch: Throwable -> L16
    L13:
        triggerPreRender("engineStop");     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.ttvideoengine.preRender.PlayBufferListener
    public void onCacheEnd(TTVideoEngine r100) {
        triggerPreRender("cache end");
    }

    @Override // com.ss.ttvideoengine.VideoEngineStateListener
    public void onEnginePlay(TTVideoEngine r100) {
        enginePlay(r100);
    }

    @Override // com.ss.ttvideoengine.VideoEngineStateListener
    public void onEngineStop(TTVideoEngine r100) {
        engineStop(r100);
    }

    public void removeListener(PreRenderTriggerListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mListeners.remove(r100);
    }

    public void setStartBufferInS(int r100) {
        this.mCustomStartBufferInS = r100;
        this.mStartBufferInS = r100;
    }

    public void setStopBufferInS(int r100) {
        this.mCustomStopBufferInS = r100;
        this.mStopBufferInS = r100;
    }

    public void useDefaultEngineState(boolean r100) {
        if (r100 == false) goto L4;
        TTVideoEngine.addEngineStateListener(this);
        return;
    L4:
        TTVideoEngine.removeEngineStateListener(this);
    }

    @Override // com.ss.ttvideoengine.preRender.PlayBufferListener
    public void onCacheSize(TTVideoEngine r100, long r101) {
        if (r101 < (((long) this.mStartBufferInS) * 1000)) goto L6;
        triggerPreRender("high buffer " + r101);
    L6:
        if (r101 > (((long) this.mStopBufferInS) * 1000)) goto L9;
        pausePreRender("low buffer " + r101);
        return;
    }
}
