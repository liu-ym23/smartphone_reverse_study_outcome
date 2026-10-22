package com.ss.android.ugc.bytex.pthread.base.proxy;

import android.util.EventsUtils;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001b\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\fB\u0019\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\rB\u0019\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000eB#\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000fB+\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/proxy/PthreadThread;", "Ljava/lang/Thread;", "()V", "runnable", "Ljava/lang/Runnable;", "(Ljava/lang/Runnable;)V", "name", XmlPullParser.NO_NAMESPACE, "(Ljava/lang/String;)V", "group", "Ljava/lang/ThreadGroup;", "target", "(Ljava/lang/ThreadGroup;Ljava/lang/Runnable;)V", "(Ljava/lang/ThreadGroup;Ljava/lang/String;)V", "(Ljava/lang/Runnable;Ljava/lang/String;)V", "(Ljava/lang/ThreadGroup;Ljava/lang/Runnable;Ljava/lang/String;)V", "stackSize", XmlPullParser.NO_NAMESPACE, "(Ljava/lang/ThreadGroup;Ljava/lang/Runnable;Ljava/lang/String;J)V", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, EventsUtils.FEAT_TYPE_PERF_COMMON_DATA})
public class PthreadThread extends Thread {
    public PthreadThread() {
    }

    public PthreadThread(Runnable r1) {
        super(r1);
    }

    public PthreadThread(Runnable r1, String r2) {
        super(r1, r2);
    }

    public PthreadThread(String r1) {
        super(r1);
    }

    public PthreadThread(ThreadGroup r1, Runnable r2) {
        super(r1, r2);
    }

    public PthreadThread(ThreadGroup r1, Runnable r2, String r3) {
        super(r1, r2, r3);
    }

    public PthreadThread(ThreadGroup r1, Runnable r2, String r3, long r4) {
        super(r1, r2, r3, r4);
    }

    public PthreadThread(ThreadGroup r1, String r2) {
        super(r1, r2);
    }
}
