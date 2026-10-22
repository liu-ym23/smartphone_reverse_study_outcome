package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("cronet")
public abstract class TTThreadConfigInfoProvider {
    public static final int INVALID_THREAD_PRIORITY = 20;

    /* JADX INFO: loaded from: classes6.dex */
    public static final enum BindCore extends Enum<BindCore> {
        private static final /* synthetic */ BindCore[] $VALUES = null;
        public static final BindCore BIG_CORE = null;
        public static final BindCore CANCEL_BIND = null;
        public static final BindCore DEFAULT = null;
        public static final BindCore LITTLE_CORE = null;

        static {
            BindCore r100 = new BindCore("DEFAULT", 0);
            DEFAULT = r100;
            BindCore r101 = new BindCore("BIG_CORE", 1);
            BIG_CORE = r101;
            BindCore r102 = new BindCore("LITTLE_CORE", 2);
            LITTLE_CORE = r102;
            BindCore r103 = new BindCore("CANCEL_BIND", 3);
            CANCEL_BIND = r103;
            $VALUES = new BindCore[]{r100, r101, r102, r103};
        }

        public static BindCore[] values() {
            return (BindCore[]) $VALUES.clone();
        }

        public static BindCore valueOf(String r100) {
            return (BindCore) r27.a.a(BindCore.class, r100);
        }

        private BindCore(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public interface Callback {
        void bindBigCore(int r100);

        void bindLittleCore(int r100);

        void resetCoreBind(int r100);
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class ThreadConfigInfo {
        private BindCore mBindCore;
        private int mThreadPriority;
        private int mThreadStackSize;
        private ThreadType mThreadType;

        public int getThreadType() {
            return this.mThreadType.ordinal();
        }

        public ThreadConfigInfo() {
            this.mThreadPriority = 20;
        }

        public int getThreadPriority() {
            return this.mThreadPriority;
        }

        public int getThreadStackSize() {
            return this.mThreadStackSize;
        }

        public void setThreadPriority(int r100) {
            this.mThreadPriority = r100;
        }

        public void setThreadStackSize(int r100) {
            this.mThreadStackSize = r100;
        }

        public void setThreadType(ThreadType r100) {
            this.mThreadType = r100;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
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
            return (ThreadType) r27.a.a(ThreadType.class, r100);
        }

        private ThreadType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public TTThreadConfigInfoProvider() {
    }
}
