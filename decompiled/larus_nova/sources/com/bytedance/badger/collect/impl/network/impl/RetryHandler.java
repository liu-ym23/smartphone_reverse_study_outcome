package com.bytedance.badger.collect.impl.network.impl;

import android.os.Handler;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.model.TTRequest;
import com.bytedance.badger.collect.impl.model.TTResponse;
import com.bytedance.badger.collect.impl.network.interfaces.IChainHandler;
import com.bytedance.badger.collect.impl.utils.ExecutorManager;
import com.bytedance.badger.collect.impl.utils.KLog;

/* JADX INFO: loaded from: classes47.dex */
public class RetryHandler implements IChainHandler {
    private static final int MAX_RETRY_COUNT = 3;
    private final Handler retryHandler;

    public class RetryCallback {
        private final IChainHandler.IChain chain;
        private boolean completed;
        private TTResponse finalResponse;
        private final TTRequest request;
        private int retryCount;
        final /* synthetic */ RetryHandler this$0;

        public synchronized TTResponse getFinalResponse() {
            monitor-enter(this);
            TTResponse r100 = this.finalResponse;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r100;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized boolean isCompleted() {
            monitor-enter(this);
            boolean r100 = this.completed;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r100;
        L6:
            th = move-exception;
            throw th;
        }

        public void retry() {
            RetryHandler.access$300(this.this$0).post(new AnonymousClass1(this));
        }

        public static /* synthetic */ TTRequest access$000(RetryCallback r100) {
            return r100.request;
        }

        public static /* synthetic */ IChainHandler.IChain access$100(RetryCallback r100) {
            return r100.chain;
        }

        public static /* synthetic */ int access$200(RetryCallback r100) {
            return r100.retryCount;
        }

        public static /* synthetic */ int access$208(RetryCallback r100) {
            int r101 = r100.retryCount;
            r100.retryCount = r101 + 1;
            return r101;
        }

        public static /* synthetic */ TTResponse access$402(RetryCallback r100, TTResponse r101) {
            r100.finalResponse = r101;
            return r101;
        }

        public static /* synthetic */ boolean access$502(RetryCallback r100, boolean r101) {
            r100.completed = r101;
            return r101;
        }

        public RetryCallback(RetryHandler r100, IChainHandler.IChain r101, TTRequest r102) {
            this.this$0 = r100;
            this.finalResponse = null;
            this.retryCount = 0;
            this.completed = false;
            this.chain = r101;
            this.request = r102;
        }
    }

    public RetryHandler() {
        this.retryHandler = ExecutorManager.getInstance().getHandler();
    }

    public static /* synthetic */ Handler access$300(RetryHandler r100) {
        return r100.retryHandler;
    }

    @Override // com.bytedance.badger.collect.impl.network.interfaces.IChainHandler
    public long getRetryDelay(int r100) {
        return ((long) Math.pow(2.0d, r100)) * 1000;
    }

    @Override // com.bytedance.badger.collect.impl.network.interfaces.IChainHandler
    public TTResponse handle(IChainHandler.IChain r100) throws Exception {
        RetryCallback r101 = new RetryCallback(this, r100, r100.getRequest());
        r101.retry();
        monitor-enter(r101);
    L13:
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r101.isCompleted() == true) goto L7;
        r101.wait();     // Catch: Throwable -> L10
        goto L13
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L10
        return r101.getFinalResponse();
    }

    @Override // com.bytedance.badger.collect.impl.network.interfaces.IChainHandler
    public boolean shouldRetry(TTResponse r100, int r101) {
        KLog.w(Constants.TAGS.NETWORK, "RetryHandler# request failed, need retry...... ");
        if (r100 == null) goto L7;
        if (r100.getStatusCode() != 200) goto L7;
    L9:
        return false;
    L7:
        if (r101 >= 3) goto L9;
        return true;
    }
}
