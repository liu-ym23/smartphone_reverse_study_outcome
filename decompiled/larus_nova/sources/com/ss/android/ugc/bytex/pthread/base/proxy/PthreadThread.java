package com.ss.android.ugc.bytex.pthread.base.proxy;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001b\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\fB\u0019\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\rB\u0019\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000eB#\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000fB+\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/proxy/PthreadThread;", "Ljava/lang/Thread;", "()V", "runnable", "Ljava/lang/Runnable;", "(Ljava/lang/Runnable;)V", "name", "", "(Ljava/lang/String;)V", "group", "Ljava/lang/ThreadGroup;", PickerReporterConstants.KEY.TARGET, "(Ljava/lang/ThreadGroup;Ljava/lang/Runnable;)V", "(Ljava/lang/ThreadGroup;Ljava/lang/String;)V", "(Ljava/lang/Runnable;Ljava/lang/String;)V", "(Ljava/lang/ThreadGroup;Ljava/lang/Runnable;Ljava/lang/String;)V", "stackSize", "", "(Ljava/lang/ThreadGroup;Ljava/lang/Runnable;Ljava/lang/String;J)V", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public class PthreadThread extends Thread {
    public PthreadThread() {
    }

    public PthreadThread(Runnable r100) {
        super(r100);
    }

    public PthreadThread(Runnable r100, String r101) {
        super(r100, r101);
    }

    public PthreadThread(String r100) {
        super(r100);
    }

    public PthreadThread(ThreadGroup r100, Runnable r101) {
        super(r100, r101);
    }

    public PthreadThread(ThreadGroup r100, Runnable r101, String r102) {
        super(r100, r101, r102);
    }

    public PthreadThread(ThreadGroup r100, Runnable r101, String r102, long r103) {
        super(r100, r101, r102, r103);
    }

    public PthreadThread(ThreadGroup r100, String r101) {
        super(r100, r101);
    }
}
