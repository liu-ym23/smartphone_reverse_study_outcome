package com.bytedance.frameworks.baselib.network.http.cronet;

import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.TTDelayStateManager;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import r27.a;

/* JADX INFO: loaded from: classes.dex */
public class TTAppStateManager {
    private static final String TAG = null;
    private static volatile AppStartState sAppDelayState;
    private static volatile AppStartState sAppStartState;

    public static final enum AppStartState extends Enum<AppStartState> {
        private static final /* synthetic */ AppStartState[] $VALUES = null;
        public static final AppStartState ColdStart = null;
        public static final AppStartState Default = null;
        public static final AppStartState HotStart = null;
        public static final AppStartState NormalStart = null;
        public static final AppStartState WarmStart = null;
        public static final AppStartState WeakNet = null;
        final int state;

        static {
            AppStartState r100 = new AppStartState("NormalStart", 0, -1);
            NormalStart = r100;
            AppStartState r101 = new AppStartState("ColdStart", 1, 0);
            ColdStart = r101;
            AppStartState r102 = new AppStartState("HotStart", 2, 1);
            HotStart = r102;
            AppStartState r103 = new AppStartState("WarmStart", 3, 2);
            WarmStart = r103;
            AppStartState r104 = new AppStartState("WeakNet", 4, 3);
            WeakNet = r104;
            AppStartState r105 = new AppStartState("Default", 5, 4);
            Default = r105;
            $VALUES = new AppStartState[]{r100, r101, r102, r103, r104, r105};
        }

        public static AppStartState[] values() {
            return (AppStartState[]) $VALUES.clone();
        }

        public int getValue() {
            return this.state;
        }

        public static AppStartState valueOf(String r100) {
            return (AppStartState) a.a(AppStartState.class, r100);
        }

        private AppStartState(String r100, int r101, int r102) {
            super(r100, r101);
            this.state = r102;
        }
    }

    public TTAppStateManager() {
    }

    static {
        TAG = "TTAppStateManager";
        sAppStartState = AppStartState.NormalStart;
        sAppDelayState = AppStartState.Default;
    }

    public static int getAppStartUpState() {
        return sAppStartState.state;
    }

    public static AppStartState getAppDelayState() {
        return sAppDelayState;
    }

    public static void setAppDelayState(AppStartState r100) {
        sAppDelayState = r100;
    }

    public static void setAppStartUpState(AppStartState r100) {
        sAppStartState = r100;     // Catch: Exception -> L21
        int r101 = r100.getValue();     // Catch: Exception -> L21
        TTDelayStateManager.f244594d.set(System.currentTimeMillis() / 1000);     // Catch: Exception -> L21
        if (r101 != 0) goto L6;
        TTDelayStateManager.f244592b = TTDelayStateManager.AppStartState.ColdStart;     // Catch: Exception -> L21
    L12:
        ICronetClient r102 = SsCronetHttpClient.getCronetClient();     // Catch: Exception -> L21
        if (r102 == null) goto L26;
        int r103 = r100.state;     // Catch: Exception -> L21
        if (Logger.debug() == false) goto L17;
        Logger.d(TAG, "Set app start-up state: " + r103);     // Catch: Exception -> L21
    L17:
        if (r103 < 0) goto L27;
        if (r103 > 2) goto L28;
        r102.setAppStartUpState(r103);     // Catch: Exception -> L21
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L6:
        if (r101 == 1) goto L10;
        if (r101 == 2) goto L9;
        TTDelayStateManager.f244592b = TTDelayStateManager.AppStartState.NormalStart;     // Catch: Exception -> L21
        goto L12
    L9:
        TTDelayStateManager.f244592b = TTDelayStateManager.AppStartState.WarmStart;     // Catch: Exception -> L21
        goto L12
    L10:
        TTDelayStateManager.f244592b = TTDelayStateManager.AppStartState.HotStart;     // Catch: Exception -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
    }
}
