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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public final CoroutineScope a;
    public final Channel<Function0<Unit>> b;

    public a() {
        CoroutineDispatcher r0 = Dispatchers.getDefault();
        Intrinsics.checkNotNullParameter(r0, "dispatcher");
        CoroutineScope r2 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(r0));
        this.a = r2;
        this.b = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        BuildersKt.launch$default(r2, null, null, new CallbackQueue$1(this, null), 3, null);
    }
}
