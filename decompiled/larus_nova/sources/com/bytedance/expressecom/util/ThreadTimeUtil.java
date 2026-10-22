package com.bytedance.expressecom.util;

import android.os.SystemClock;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes19.dex */
public final class ThreadTimeUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class<SystemClock> f243223a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f243224b = null;

    static {
        f243223a = SystemClock.class;
        f243224b = LazyKt.lazy(ThreadTimeUtil$method$2.INSTANCE);
    }
}
