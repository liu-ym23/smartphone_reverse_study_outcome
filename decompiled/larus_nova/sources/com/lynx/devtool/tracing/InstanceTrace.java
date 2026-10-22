package com.lynx.devtool.tracing;

/* JADX INFO: loaded from: classes32.dex */
public class InstanceTrace {
    private long mNativeInstanceTrace;

    /* JADX INFO: renamed from: com.lynx.devtool.tracing.InstanceTrace$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class InstanceTraceLoader {
        private static final InstanceTrace INSTANCE = null;

        private InstanceTraceLoader() {
        }

        static {
            INSTANCE = new InstanceTrace(null);
        }

        public static /* synthetic */ InstanceTrace access$100() {
            return INSTANCE;
        }
    }

    private native long nativeCreateInstanceTrace();

    private InstanceTrace() {
        this.mNativeInstanceTrace = 0;
        this.mNativeInstanceTrace = nativeCreateInstanceTrace();
    }

    public static InstanceTrace getInstance() {
        return InstanceTraceLoader.access$100();
    }

    public long getNativeInstanceTrace() {
        return this.mNativeInstanceTrace;
    }

    public /* synthetic */ InstanceTrace(AnonymousClass1 r100) {
        this();
    }
}
