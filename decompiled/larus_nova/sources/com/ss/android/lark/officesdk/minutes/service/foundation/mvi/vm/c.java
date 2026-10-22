package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.l;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: classes37.dex */
public final class c<S extends l> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ExecutorCoroutineDispatcher f433862g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f433863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Channel<Function1<S, S>> f433864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Channel<Function1<S, Unit>> f433865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableSharedFlow<S> f433866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile S f433867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a1 f433868f;

    public static final class a {
    }

    static {
        f433862g = ExecutorsKt.from(PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("vm/StateStore")));
    }

    public c(S r100, CoroutineScope r110) {
        Intrinsics.checkNotNullParameter(r100, "initialState");
        Intrinsics.checkNotNullParameter(r110, "scope");
        this.f433863a = r110;
        this.f433864b = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.f433865c = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        MutableSharedFlow<S> r101 = SharedFlowKt.MutableSharedFlow(1, 63, BufferOverflow.SUSPEND);
        r101.tryEmit(r100);
        this.f433866d = r101;
        this.f433867e = r100;
        this.f433868f = kotlinx.coroutines.flow.e.a(r101);
        BuildersKt.launch$default(r110, f433862g, null, new StateStore$setupTriggerFlushQueues$1(this, null), 2, null);
    }

    public static void a(c r100, Flow r101, CoroutineScope r102, Function2 r103) {
        BuildersKt.launch$default(r102, null, null, new StateStore$resolveSubscription$1(true, r101, r103, null), 3, null);
    }
}
