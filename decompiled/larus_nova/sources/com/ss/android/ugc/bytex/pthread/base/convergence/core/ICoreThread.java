package com.ss.android.ugc.bytex.pthread.base.convergence.core;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0001H&J\b\u0010\u000f\u001a\u00020\fH&¨\u0006\u0010"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/core/ICoreThread;", "Ljava/lang/Thread;", "group", "Ljava/lang/ThreadGroup;", PickerReporterConstants.KEY.TARGET, "Ljava/lang/Runnable;", "name", "", "stackSize", "", "(Ljava/lang/ThreadGroup;Ljava/lang/Runnable;Ljava/lang/String;J)V", "associateDelegateThread", "", "delegate", "getDelegateThread", "resetThread", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public abstract class ICoreThread extends Thread {
    public ICoreThread(ThreadGroup r100, Runnable r101, String r102, long r103) {
        super(r100, r101, r102, r103);
    }

    public abstract void associateDelegateThread(Thread r100);

    public abstract Thread getDelegateThread();

    public abstract void resetThread();
}
