package com.bytedance.ug.sdk.luckydog.base.keep;

import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes22.dex */
public class ConfigUpdateManager {
    private static final String TAG = "ConfigUpdateManager";
    private static final long TIMER_SCHEDULE_PERIOD = 100;
    private ICallback mConfigUpdateCallback;
    private Timer mTimer;
    private TimerTask mTimerTask;

    public interface ICallback {
        void onConfigUpdate(String r100);
    }

    public static class Singleton {
        private static ConfigUpdateManager sInstance;

        private Singleton() {
        }

        static {
            sInstance = new ConfigUpdateManager(null);
        }

        public static /* synthetic */ ConfigUpdateManager access$100() {
            return sInstance;
        }
    }

    private void destroy() {
        Timer r100 = this.mTimer;
        if (r100 == null) goto L5;
        r100.cancel();
        this.mTimer = null;
    L5:
        TimerTask r101 = this.mTimerTask;
        if (r101 == null) goto L9;
        r101.cancel();
        this.mTimerTask = null;
        return;
    }

    public static ConfigUpdateManager getInstance() {
        return Singleton.access$100();
    }

    private ConfigUpdateManager() {
    }

    public /* synthetic */ ConfigUpdateManager(AnonymousClass1 r100) {
        this();
    }

    public static /* synthetic */ ICallback access$200(ConfigUpdateManager r100) {
        return r100.mConfigUpdateCallback;
    }

    public static /* synthetic */ void access$300(ConfigUpdateManager r100) {
        r100.destroy();
    }

    public void init(ICallback r100) {
        this.mTimer = new PthreadTimer(TAG);
        this.mConfigUpdateCallback = r100;
        TimerTask r101 = new AnonymousClass1(this);
        this.mTimerTask = r101;
        this.mTimer.schedule(r101, 0, 100);
    }
}
