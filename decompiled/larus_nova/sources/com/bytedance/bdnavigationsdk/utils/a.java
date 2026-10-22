package com.bytedance.bdnavigationsdk.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f200373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Channel<Function0<Unit>> f200374b;

    public a() {
        CoroutineDispatcher r100 = Dispatchers.getDefault();
        Intrinsics.checkNotNullParameter(r100, "dispatcher");
        CoroutineScope r101 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(r100));
        this.f200373a = r101;
        this.f200374b = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        BuildersKt.launch$default(r101, null, null, new CallbackQueue$1(this, null), 3, null);
    }
}
