package com.ss.android.ugc.bytex.pthread.base.convergence.core;

import android.util.EventsUtils;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0001H&J\b\u0010\u000f\u001a\u00020\fH&¨\u0006\u0010"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/core/ICoreThread;", "Ljava/lang/Thread;", "group", "Ljava/lang/ThreadGroup;", "target", "Ljava/lang/Runnable;", "name", XmlPullParser.NO_NAMESPACE, "stackSize", XmlPullParser.NO_NAMESPACE, "(Ljava/lang/ThreadGroup;Ljava/lang/Runnable;Ljava/lang/String;J)V", "associateDelegateThread", XmlPullParser.NO_NAMESPACE, "delegate", "getDelegateThread", "resetThread", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, EventsUtils.FEAT_TYPE_PERF_COMMON_DATA})
public abstract class ICoreThread extends Thread {
    public ICoreThread(ThreadGroup r1, Runnable r2, String r3, long r4) {
        super(r1, r2, r3, r4);
    }

    public abstract void associateDelegateThread(Thread r1);

    public abstract Thread getDelegateThread();

    public abstract void resetThread();
}
