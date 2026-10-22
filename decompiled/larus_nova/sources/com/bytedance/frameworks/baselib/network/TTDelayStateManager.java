package com.bytedance.frameworks.baselib.network;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class TTDelayStateManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f244591a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile AppStartState f244592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f244593c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicLong f244594d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicLong f244595e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicLong f244596f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicLong f244597g = null;

    public static final enum AppStartState extends Enum<AppStartState> {
        public static final AppStartState ColdStart = null;
        public static final AppStartState HotStart = null;
        public static final AppStartState NormalStart = null;
        public static final AppStartState WarmStart = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AppStartState[] f244598a = null;
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
            f244598a = new AppStartState[]{r100, r101, r102, r103};
        }

        public static AppStartState[] values() {
            return (AppStartState[]) f244598a.clone();
        }

        public int getValue() {
            return this.state;
        }

        public static AppStartState valueOf(String r100) {
            return (AppStartState) r27.a.a(AppStartState.class, r100);
        }

        public AppStartState(String r100, int r101, int r102) {
            super(r100, r101);
            this.state = r102;
        }
    }

    /* JADX INFO: loaded from: classes19.dex */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f244599a = null;

        static {
            int[] r100 = new int[AppStartState.values().length];
            f244599a = r100;
            r100[AppStartState.ColdStart.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f244599a[AppStartState.HotStart.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f244599a[AppStartState.WarmStart.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public TTDelayStateManager() {
    }

    static {
        f244591a = TTDelayStateManager.class.getSimpleName();
        f244592b = AppStartState.NormalStart;
        f244593c = new AtomicBoolean(false);
        f244594d = new AtomicLong(0);
        f244595e = new AtomicLong(0);
        f244596f = new AtomicLong(0);
        f244597g = new AtomicLong(0);
    }
}
