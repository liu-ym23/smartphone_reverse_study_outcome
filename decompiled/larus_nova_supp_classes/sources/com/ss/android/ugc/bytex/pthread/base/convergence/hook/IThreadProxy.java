package com.ss.android.ugc.bytex.pthread.base.convergence.hook;

import android.util.EventsUtils;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\b\u0010\u0014\u001a\u00020\tH&¨\u0006\u0015"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/IThreadProxy;", XmlPullParser.NO_NAMESPACE, "getAttachThread", "Ljava/lang/Thread;", "getState", "Ljava/lang/Thread$State;", "isRealAlive", XmlPullParser.NO_NAMESPACE, "join", XmlPullParser.NO_NAMESPACE, "millis", XmlPullParser.NO_NAMESPACE, "nanos", XmlPullParser.NO_NAMESPACE, "setContextClassLoader", "cl", "Ljava/lang/ClassLoader;", "setUncaughtExceptionHandler", "eh", "Ljava/lang/Thread$UncaughtExceptionHandler;", "start", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, EventsUtils.FEAT_TYPE_PERF_COMMON_DATA})
public interface IThreadProxy {
    Thread getAttachThread();

    Thread.State getState();

    boolean isRealAlive();

    void join();

    void join(long r1);

    void join(long r1, int r3);

    void setContextClassLoader(ClassLoader r1);

    void setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler r1);

    void start();
}
