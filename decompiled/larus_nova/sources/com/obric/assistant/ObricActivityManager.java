package com.obric.assistant;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes4.dex */
public final class ObricActivityManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Job f385129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile int f385130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CoroutineScope f385131c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f385132d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ObricActivityManager$appBackGroundListener$1 f385133e = null;

    static {
        f385131c = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        f385132d = LazyKt.lazy(new r0());
        f385133e = new ObricActivityManager$appBackGroundListener$1();
    }
}
