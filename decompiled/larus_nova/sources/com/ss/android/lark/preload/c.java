package com.ss.android.lark.preload;

import android.os.SystemClock;
import androidx.camera.video.AudioStats;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static StrategyConfig f438807a;

    static {
    }

    public static StrategyConfig a() {
        long r100 = SystemClock.elapsedRealtime();
        StrategyConfig r101 = e1c.c.f470764d.get();
        if (r101 == null) goto L7;
        Log.d("StrategyConfig", "getStrategyConfig from AB = " + r101.getBizFrequencyDisableValue() + ", " + r101.getHitRateDisableValue());
        return r101;
    L7:
        if (f438807a != null) goto L9;
        f438807a = (StrategyConfig) SettingManager.getInstance().get(StrategyConfig.class);
    L9:
        Log.d("StrategyConfig", "getStrategyConfig cost = " + (SystemClock.elapsedRealtime() - r100));
        StrategyConfig r102 = f438807a;
        if (r102 == null) goto L12;
        return r102;
    L12:
        return new StrategyConfig(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 3, null);
    }
}
