package com.bytedance.common.jato.gc;

import android.app.Application;
import java.lang.ref.WeakReference;
import java.security.SecureRandom;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public class LightLeakObject {
    private static volatile LightLeakObject sInstance;
    private Application applcation;
    private boolean catchAll;
    private int checkInterval;
    private boolean enable;
    private boolean fetchPathFork;
    private int fetchPathTimeout;
    private WeakReference<Object> gcWatcher;
    private volatile boolean isRunning;
    private long lastCheckTime;
    private WeakHashMap<Object, Object> leakMap;
    private int leakThreshold;
    private int maxCount;
    private int maxDeep;
    private final SecureRandom random;
    private AtomicInteger requestId;
    private int sizeDeep;
    private boolean useSelfImpl;

    public interface LeakChecker {
    }

    public static final enum LeakResult extends Enum<LeakResult> {
        private static final /* synthetic */ LeakResult[] $VALUES = null;
        public static final LeakResult LEAK = null;
        public static final LeakResult NEXT_CHECK = null;
        public static final LeakResult REMOVE_CHECK = null;

        static {
            LeakResult r100 = new LeakResult("LEAK", 0);
            LEAK = r100;
            LeakResult r101 = new LeakResult("NEXT_CHECK", 1);
            NEXT_CHECK = r101;
            LeakResult r102 = new LeakResult("REMOVE_CHECK", 2);
            REMOVE_CHECK = r102;
            $VALUES = new LeakResult[]{r100, r101, r102};
        }

        public static LeakResult[] values() {
            return (LeakResult[]) $VALUES.clone();
        }

        public static LeakResult valueOf(String r100) {
            return (LeakResult) a.a(LeakResult.class, r100);
        }

        private LeakResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    public void addLeakObject(Object r100, Object r101, LeakChecker r102) {
    }

    public static LightLeakObject getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(LightLeakObject.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new LightLeakObject();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LightLeakObject.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public LightLeakObject() {
        this.isRunning = false;
        this.fetchPathTimeout = 30000;
        this.fetchPathFork = true;
        this.enable = false;
        this.maxCount = 10;
        this.maxDeep = 100;
        this.catchAll = true;
        this.useSelfImpl = true;
        this.sizeDeep = 0;
        this.leakThreshold = 60000;
        this.checkInterval = 120000;
        this.random = new SecureRandom();
        this.leakMap = new WeakHashMap();
        this.requestId = new AtomicInteger(0);
        this.lastCheckTime = 0;
        this.applcation = null;
        this.gcWatcher = null;
    }
}
