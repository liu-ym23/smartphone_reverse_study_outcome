package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface Callback<T> {

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.Callback$-CC, reason: invalid class name */
    /* JADX INFO: loaded from: classes41.dex */
    public final /* synthetic */ class CC<T> {
        public static Runnable $default$bind(final Callback r100, final Object r101) {
            return new a(r100, r101);
        }

        public static /* synthetic */ void $private$lambda$bind$0(Callback r100, Object r101) {
            r100.onResult(r101);
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public static abstract class Helper {
        public Helper() {
        }

        public static void runRunnable(Runnable r100) {
            r100.run();
        }

        public static void onBooleanResultFromNative(Callback r100, boolean r101) {
            r100.onResult(Boolean.valueOf(r101));
        }

        public static void onIntResultFromNative(Callback r100, int r101) {
            r100.onResult(Integer.valueOf(r101));
        }

        public static void onLongResultFromNative(Callback r100, long r101) {
            r100.onResult(Long.valueOf(r101));
        }

        public static void onObjectResultFromNative(Callback r100, Object r101) {
            r100.onResult(r101);
        }

        public static void onTimeResultFromNative(Callback r100, long r101) {
            r100.onResult(Long.valueOf(r101));
        }
    }

    Runnable bind(T r100);

    void onResult(T r100);
}
