package com.ttnet.org.chromium.base.task;

import android.util.Pair;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes41.dex */
public class ChainedTasks {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private volatile boolean mCanceled;
    private boolean mFinalized;
    private final Runnable mRunAndPost;
    private final LinkedList<Pair<TaskTraits, Runnable>> mTasks;

    public static /* synthetic */ void a(ChainedTasks r100) {
        r100.lambda$start$0();
    }

    private /* synthetic */ void lambda$start$0() {
        Iterator<Pair<TaskTraits, Runnable>> r100 = this.mTasks.iterator();
    L4:
        if (r100.hasNext() == false) goto L7;
        ((Runnable) r100.next().second).run();
        if (this.mCanceled == false) goto L4;
        return;
    }

    public void cancel() {
        LinkedList<Pair<TaskTraits, Runnable>> r100 = this.mTasks;
        monitor-enter(r100);
        this.mFinalized = true;     // Catch: Throwable -> L8
        this.mCanceled = true;     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public ChainedTasks() {
        this.mTasks = new LinkedList();
        this.mRunAndPost = new AnonymousClass1(this);
    }

    static {
    }

    public static /* synthetic */ boolean access$000(ChainedTasks r100) {
        return r100.mCanceled;
    }

    public static /* synthetic */ LinkedList access$100(ChainedTasks r100) {
        return r100.mTasks;
    }

    public void start(boolean r100) {
        LinkedList<Pair<TaskTraits, Runnable>> r101 = this.mTasks;
        monitor-enter(r101);
        this.mFinalized = true;     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L16
        if (this.mTasks.isEmpty() == false) goto L10;
        return;
    L10:
        if (r100 == false) goto L12;
        PostTask.runOrPostTask((TaskTraits) this.mTasks.peek().first, new c(this));
        return;
    L12:
        PostTask.postTask((TaskTraits) this.mTasks.peek().first, this.mRunAndPost);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public void add(TaskTraits r100, Runnable r101) {
        LinkedList<Pair<TaskTraits, Runnable>> r102 = this.mTasks;
        monitor-enter(r102);
        this.mTasks.add(new Pair(r100, r101));     // Catch: Throwable -> L9
        monitor-exit(r102);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
