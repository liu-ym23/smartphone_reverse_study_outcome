package com.ss.android.socialbase.downloader.thread;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes38.dex */
public class ThreadWithHandler {
    private InnerThread handlerThread;
    private Object lock;
    private Queue<MessageEntity> mCacheQueue;
    private Handler mHandler;

    public class InnerThread extends PthreadHandlerThreadV2 {
        final /* synthetic */ ThreadWithHandler this$0;

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Looper r100 = getLooper();
            Object r101 = ThreadWithHandler.access$000(this.this$0);
            monitor-enter(r101);
            ThreadWithHandler.access$102(this.this$0, new Handler(r100));     // Catch: Throwable -> L12
            monitor-exit(r101);     // Catch: Throwable -> L12
        L7:
            if (ThreadWithHandler.access$200(this.this$0).isEmpty() == true) goto L11;
            MessageEntity r102 = (MessageEntity) ThreadWithHandler.access$200(this.this$0).poll();
            if (r102 == null) goto L7;
            ThreadWithHandler.access$100(this.this$0).postDelayed(r102.target, r102.delayMillis);
            goto L7
        L11:
            return;
        L12:
            th = move-exception;
            throw th;
        }

        public InnerThread(ThreadWithHandler r100, String r101) {
            this.this$0 = r100;
            super(r101);
        }
    }

    public class MessageEntity {
        public long delayMillis;
        public Runnable target;
        final /* synthetic */ ThreadWithHandler this$0;

        public MessageEntity(ThreadWithHandler r100, Runnable r101, long r102) {
            this.this$0 = r100;
            this.target = r101;
            this.delayMillis = r102;
        }
    }

    public void quit() {
        this.handlerThread.quit();
    }

    public void start() {
        ThreadMethodProxy.start(this.handlerThread);
    }

    public ThreadWithHandler(String r100) {
        this.lock = new Object();
        this.mCacheQueue = new ConcurrentLinkedQueue();
        this.handlerThread = new InnerThread(this, r100);
    }

    public static /* synthetic */ Object access$000(ThreadWithHandler r100) {
        return r100.lock;
    }

    public static /* synthetic */ Handler access$100(ThreadWithHandler r100) {
        return r100.mHandler;
    }

    public static /* synthetic */ Queue access$200(ThreadWithHandler r100) {
        return r100.mCacheQueue;
    }

    public void post(Runnable r100) {
        postDelayed(r100, 0);
    }

    public static /* synthetic */ Handler access$102(ThreadWithHandler r100, Handler r101) {
        r100.mHandler = r101;
        return r101;
    }

    public void postDelayed(Runnable r100, long r101) {
        if (this.mHandler != null) goto L16;
        Object r102 = this.lock;
        monitor-enter(r102);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.mHandler != null) goto L11;
        this.mCacheQueue.add(new MessageEntity(this, r100, r101));     // Catch: Throwable -> L13
        monitor-exit(r102);     // Catch: Throwable -> L13
        return;
    L11:
        monitor-exit(r102);     // Catch: Throwable -> L13
    L16:
        this.mHandler.postDelayed(r100, r101);
    }
}
