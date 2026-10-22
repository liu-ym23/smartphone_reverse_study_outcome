package com.lynx.tasm.service.async;

import android.util.LruCache;
import com.lynx.tasm.base.LLog;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes32.dex */
public final class LynxAsyncManager<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExecutorService f383770a;

    public static final enum AsyncCallbackCode extends Enum<AsyncCallbackCode> {
        public static final AsyncCallbackCode ASYNC_MANAGER_LOAD_FAIL = null;
        public static final AsyncCallbackCode ASYNC_MANAGER_TIMEOUT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AsyncCallbackCode[] f383771a = null;

        static {
            AsyncCallbackCode r100 = new AsyncCallbackCode("ASYNC_MANAGER_LOAD_FAIL", 0);
            ASYNC_MANAGER_LOAD_FAIL = r100;
            AsyncCallbackCode r101 = new AsyncCallbackCode("ASYNC_MANAGER_TIMEOUT", 1);
            ASYNC_MANAGER_TIMEOUT = r101;
            f383771a = new AsyncCallbackCode[]{r100, r101};
        }

        public static AsyncCallbackCode[] values() {
            return (AsyncCallbackCode[]) f383771a.clone();
        }

        public static AsyncCallbackCode valueOf(String r100) {
            return (AsyncCallbackCode) r27.a.a(AsyncCallbackCode.class, r100);
        }

        public AsyncCallbackCode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a<T> {
        public final String toString() {
            return "Builder{lruSize=10, enableUseCreateExecutor=true, enableUseLoadExecutor=true, slidingWindowsSize=5}";
        }

        public a() {
        }
    }

    static {
    }

    public LynxAsyncManager(a r100) {
        LLog.i("LynxAsyncManager", "Create LynxAsyncManager, address:" + this);
        new LruCache(10);
        new LruCache(10);
        new LinkedList();
    }
}
