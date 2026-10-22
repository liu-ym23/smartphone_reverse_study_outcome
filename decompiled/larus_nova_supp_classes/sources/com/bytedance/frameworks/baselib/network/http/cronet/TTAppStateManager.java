package com.bytedance.frameworks.baselib.network.http.cronet;

import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.TTDelayStateManager;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
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
            AppStartState r0 = new AppStartState("NormalStart", 0, -1);
            NormalStart = r0;
            AppStartState r1 = new AppStartState("ColdStart", 1, 0);
            ColdStart = r1;
            AppStartState r2 = new AppStartState("HotStart", 2, 1);
            HotStart = r2;
            AppStartState r5 = new AppStartState("WarmStart", 3, 2);
            WarmStart = r5;
            AppStartState r7 = new AppStartState("WeakNet", 4, 3);
            WeakNet = r7;
            AppStartState r9 = new AppStartState("Default", 5, 4);
            Default = r9;
            $VALUES = new AppStartState[]{r0, r1, r2, r5, r7, r9};
        }

        public static AppStartState[] values() {
            return (AppStartState[]) $VALUES.clone();
        }

        public int getValue() {
            return this.state;
        }

        public static AppStartState valueOf(String r1) {
            return (AppStartState) a.a(AppStartState.class, r1);
        }

        private AppStartState(String r1, int r2, int r3) {
            super(r1, r2);
            this.state = r3;
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

    public static void setAppDelayState(AppStartState r0) {
        sAppDelayState = r0;
    }

    public static void setAppStartUpState(AppStartState r7) {
        sAppStartState = r7;     // Catch: Exception -> L21
        int r1 = r7.getValue();     // Catch: Exception -> L21
        TTDelayStateManager.d.set(System.currentTimeMillis() / 1000);     // Catch: Exception -> L21
        if (r1 != 0) goto L6;
        TTDelayStateManager.b = TTDelayStateManager.AppStartState.ColdStart;     // Catch: Exception -> L21
    L12:
        ICronetClient r2 = SsCronetHttpClient.getCronetClient();     // Catch: Exception -> L21
        if (r2 == null) goto L26;
        int r8 = r7.state;     // Catch: Exception -> L21
        if (Logger.debug() == false) goto L17;
        Logger.d(TAG, "Set app start-up state: " + r8);     // Catch: Exception -> L21
    L17:
        if (r8 < 0) goto L27;
        if (r8 > 2) goto L28;
        r2.setAppStartUpState(r8);     // Catch: Exception -> L21
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L6:
        if (r1 == 1) goto L10;
        if (r1 == 2) goto L9;
        TTDelayStateManager.b = TTDelayStateManager.AppStartState.NormalStart;     // Catch: Exception -> L21
        goto L12
    L9:
        TTDelayStateManager.b = TTDelayStateManager.AppStartState.WarmStart;     // Catch: Exception -> L21
        goto L12
    L10:
        TTDelayStateManager.b = TTDelayStateManager.AppStartState.HotStart;     // Catch: Exception -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
    }
}
