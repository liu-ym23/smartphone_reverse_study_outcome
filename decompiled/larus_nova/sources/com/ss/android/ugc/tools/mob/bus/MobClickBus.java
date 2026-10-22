package com.ss.android.ugc.tools.mob.bus;

import io.reactivex.subjects.PublishSubject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes40.dex */
public final class MobClickBus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MutableSharedFlow<b> f454824a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<CoroutineScope> f454825b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<PublishSubject<b>> f454826c = null;

    static {
        f454824a = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        f454825b = LazyKt.lazy(MobClickBus$_coroutineScope$1.INSTANCE);
        f454826c = LazyKt.lazy(MobClickBus$subject$1.INSTANCE);
    }
}
