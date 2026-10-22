package com.ss.android.downloadlib.utils;

import android.os.AsyncTask;

/* JADX INFO: loaded from: classes34.dex */
public class AsyncTaskUtils {
    static final BaseImpl IMPL = null;

    /* JADX INFO: renamed from: com.ss.android.downloadlib.utils.AsyncTaskUtils$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class BaseImpl {
        private BaseImpl() {
        }

        public /* synthetic */ BaseImpl(AnonymousClass1 r100) {
            this();
        }

        public <T> void executeAsyncTask(AsyncTask<T, ?, ?> r100, T... r101) {
            r100.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, r101);     // Catch: Throwable -> L4
            return;
        }
    }

    public static class HoneyCombImpl extends BaseImpl {
        private HoneyCombImpl() {
            super(null);
        }

        public /* synthetic */ HoneyCombImpl(AnonymousClass1 r100) {
            this();
        }

        @Override // com.ss.android.downloadlib.utils.AsyncTaskUtils.BaseImpl
        public <T> void executeAsyncTask(AsyncTask<T, ?, ?> r100, T... r101) {
            r100.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, r101);     // Catch: Throwable -> L4
            return;
        }
    }

    public AsyncTaskUtils() {
    }

    static {
        IMPL = new HoneyCombImpl(null);
    }

    public static <T> void executeAsyncTask(AsyncTask<T, ?, ?> r100, T... r101) {
        IMPL.executeAsyncTask(r100, r101);
    }
}
