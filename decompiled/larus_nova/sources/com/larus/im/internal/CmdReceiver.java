package com.larus.im.internal;

import com.larus.im.bean.IMCmd;
import com.larus.platform.api.p2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes4.dex */
public final class CmdReceiver {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f347147f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f347148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineDispatcher f347149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableSharedFlow<IMCmd> f347150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p2 f347151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super byte[], Unit> f347152e;

    public static final class a {
    }

    static {
    }

    private final void registerReceiver() {
        this.f347152e = new com.larus.im.internal.a(this);
    }

    public CmdReceiver(CoroutineScope r100, ExecutorCoroutineDispatcher r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "emitDispatcher");
        this.f347148a = r100;
        this.f347149b = r101;
        this.f347150c = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        registerReceiver();
    }
}
