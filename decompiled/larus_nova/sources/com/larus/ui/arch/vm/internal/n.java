package com.larus.ui.arch.vm.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;
import w1a.b;

/* JADX INFO: loaded from: classes31.dex */
public final class n<S extends w1a.b> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f375264f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Channel<Function1<S, S>> f375265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Channel<Function1<S, Unit>> f375266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableSharedFlow<S> f375267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public S f375268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a1 f375269e;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(w1a.b r100, CoroutineScope r110, CoroutineDispatcher r111) {
        Intrinsics.checkNotNullParameter(r100, "initialState");
        Intrinsics.checkNotNullParameter(r110, "scope");
        Intrinsics.checkNotNullParameter(r111, "dispatcher");
        this.f375265a = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.f375266b = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        MutableSharedFlow<S> r101 = SharedFlowKt.MutableSharedFlow(1, 63, BufferOverflow.SUSPEND);
        r101.tryEmit(r100);
        this.f375267c = r101;
        this.f375268d = r100;
        this.f375269e = kotlinx.coroutines.flow.e.a(r101);
        BuildersKt.launch$default(r110, r111, null, new CoroutinesStateStore$1(this, null), 2, null);
    }
}
