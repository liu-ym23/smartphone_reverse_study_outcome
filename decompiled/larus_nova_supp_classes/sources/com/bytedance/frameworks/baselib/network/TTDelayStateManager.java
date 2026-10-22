package com.bytedance.frameworks.baselib.network;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class TTDelayStateManager {
    public static final String a = null;
    public static volatile AppStartState b;
    public static final AtomicBoolean c = null;
    public static final AtomicLong d = null;
    public static final AtomicLong e = null;
    public static final AtomicLong f = null;
    public static final AtomicLong g = null;

    public static final enum AppStartState extends Enum<AppStartState> {
        public static final AppStartState ColdStart = null;
        public static final AppStartState HotStart = null;
        public static final AppStartState NormalStart = null;
        public static final AppStartState WarmStart = null;
        public static final /* synthetic */ AppStartState[] a = null;
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
            a = new AppStartState[]{r0, r1, r2, r5};
        }

        public static AppStartState[] values() {
            return (AppStartState[]) a.clone();
        }

        public int getValue() {
            return this.state;
        }

        public static AppStartState valueOf(String r1) {
            return (AppStartState) a.a(AppStartState.class, r1);
        }

        public AppStartState(String r1, int r2, int r3) {
            super(r1, r2);
            this.state = r3;
        }
    }

    public TTDelayStateManager() {
    }

    static {
        a = TTDelayStateManager.class.getSimpleName();
        b = AppStartState.NormalStart;
        c = new AtomicBoolean(false);
        d = new AtomicLong(0);
        e = new AtomicLong(0);
        f = new AtomicLong(0);
        g = new AtomicLong(0);
    }
}
