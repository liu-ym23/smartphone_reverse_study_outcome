package com.ss.android.ugc.aweme.search.utils;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/utils/DynamicTool;", "", "<init>", "()V", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class DynamicTool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DynamicTool f453400a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f453401b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f453402c = null;

    private DynamicTool() {
    }

    static {
        f453400a = new DynamicTool();
        f453401b = LazyKt.lazy(DynamicTool$mainHandler$2.INSTANCE);
        f453402c = LazyKt.lazy(DynamicTool$isTest$2.INSTANCE);
    }

    @JvmStatic
    public static final boolean a() {
        return Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper()));
    }

    @JvmStatic
    public static final void b(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (a() == false) goto L5;
        r100.run();
        return;
    L5:
        f453400a.getClass();
        ((Handler) f453401b.getValue()).post(r100);
    }
}
