package com.bytedance.frameworks.baselib.network.http.cronet;

import r27.a;

/* JADX INFO: loaded from: classes6.dex */
public class TTNetThreadConfig {
    private static final int INVALID_THREAD_PRIORITY = 20;
    public int mThreadPriority;
    public int mThreadStackSize;
    public ThreadType mThreadType;

    /* JADX INFO: loaded from: classes3.dex */
    public interface Callback {
        void bindBigCore(int r100);

        void bindLittleCore(int r100);

        void resetCoreBind(int r100);
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final enum ThreadStackInitReason extends Enum<ThreadStackInitReason> {
        private static final /* synthetic */ ThreadStackInitReason[] $VALUES = null;
        public static final ThreadStackInitReason CALLED_MULIT_TIMES = null;
        public static final ThreadStackInitReason CRASH_HAPPENED = null;
        public static final ThreadStackInitReason FALLBACK_FIX = null;
        public static final ThreadStackInitReason HAS_EXCEPTION = null;
        public static final ThreadStackInitReason OPT_EFFECTIVE = null;
        public static final ThreadStackInitReason PROCESS_NAME_NULL = null;
        public static final ThreadStackInitReason TNC_DISABLED = null;

        static {
            ThreadStackInitReason r100 = new ThreadStackInitReason("CALLED_MULIT_TIMES", 0);
            CALLED_MULIT_TIMES = r100;
            ThreadStackInitReason r101 = new ThreadStackInitReason("PROCESS_NAME_NULL", 1);
            PROCESS_NAME_NULL = r101;
            ThreadStackInitReason r102 = new ThreadStackInitReason("TNC_DISABLED", 2);
            TNC_DISABLED = r102;
            ThreadStackInitReason r103 = new ThreadStackInitReason("CRASH_HAPPENED", 3);
            CRASH_HAPPENED = r103;
            ThreadStackInitReason r104 = new ThreadStackInitReason("OPT_EFFECTIVE", 4);
            OPT_EFFECTIVE = r104;
            ThreadStackInitReason r105 = new ThreadStackInitReason("FALLBACK_FIX", 5);
            FALLBACK_FIX = r105;
            ThreadStackInitReason r110 = new ThreadStackInitReason("HAS_EXCEPTION", 6);
            HAS_EXCEPTION = r110;
            $VALUES = new ThreadStackInitReason[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static ThreadStackInitReason[] values() {
            return (ThreadStackInitReason[]) $VALUES.clone();
        }

        public static ThreadStackInitReason valueOf(String r100) {
            return (ThreadStackInitReason) a.a(ThreadStackInitReason.class, r100);
        }

        private ThreadStackInitReason(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum ThreadType extends Enum<ThreadType> {
        private static final /* synthetic */ ThreadType[] $VALUES = null;
        public static final ThreadType FILE_THREAD = null;
        public static final ThreadType INIT_THREAD = null;
        public static final ThreadType NETWORK_THREAD = null;
        public static final ThreadType THREAD_POOL_SERVICE_THREAD = null;
        public static final ThreadType WORKER_THREAD = null;

        static {
            ThreadType r100 = new ThreadType("INIT_THREAD", 0);
            INIT_THREAD = r100;
            ThreadType r101 = new ThreadType("NETWORK_THREAD", 1);
            NETWORK_THREAD = r101;
            ThreadType r102 = new ThreadType("FILE_THREAD", 2);
            FILE_THREAD = r102;
            ThreadType r103 = new ThreadType("THREAD_POOL_SERVICE_THREAD", 3);
            THREAD_POOL_SERVICE_THREAD = r103;
            ThreadType r104 = new ThreadType("WORKER_THREAD", 4);
            WORKER_THREAD = r104;
            $VALUES = new ThreadType[]{r100, r101, r102, r103, r104};
        }

        public static ThreadType[] values() {
            return (ThreadType[]) $VALUES.clone();
        }

        public static ThreadType valueOf(String r100) {
            return (ThreadType) a.a(ThreadType.class, r100);
        }

        private ThreadType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public TTNetThreadConfig() {
        this.mThreadPriority = 20;
        this.mThreadStackSize = 0;
    }
}
