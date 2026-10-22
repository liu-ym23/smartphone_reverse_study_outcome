package com.larus.bmhome.bot.utils;

import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import wc9.e;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MutableSharedFlow<e> f296780a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutableSharedFlow<String> f296781b = null;

    static {
        f296780a = SharedFlowKt.MutableSharedFlow(0, 1, BufferOverflow.DROP_OLDEST);
        f296781b = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    }
}
