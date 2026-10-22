package com.ss.ttvideoengine;

import android.os.SystemClock;
import com.bytedance.vcloud.networkpredictor.ISpeedPredictor;
import com.ss.ttvideoengine.strategrycenter.StrategyCenter;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.Locale;

/* JADX INFO: loaded from: classes34.dex */
class DataLoaderListener2ForStrategyCenter implements DataLoaderListener2 {
    private static final String TAG = "TTVideoEngine";
    static DataLoaderListener2ForStrategyCenter sInstance;

    public DataLoaderListener2ForStrategyCenter() {
    }

    static {
        sInstance = new DataLoaderListener2ForStrategyCenter();
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener2
    public void onNotify(int r100, long r101, long r110, String r111) {
        ISpeedPredictor r102 = StrategyCenter.sNetSpeedPredictor;
        if (r100 != 2) goto L9;
        if (r102 == null) goto L10;
        r102.update(r101, r110, SystemClock.elapsedRealtime());
        if (r110 == 0) goto L11;
        TTVideoEngineLog.d(TAG, String.format(Locale.US, "[IESSpeedPredictor]: speedRecord:%f", new Object[]{Double.valueOf(r101 / r110)}));
        return;
    L11:
        return;
    L10:
        return;
    }
}
