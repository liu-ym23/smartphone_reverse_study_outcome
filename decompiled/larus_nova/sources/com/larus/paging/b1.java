package com.larus.paging;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: classes29.dex */
public interface b1<T> extends CoroutineScope, SendChannel<T> {
    Object WA(Function0<Unit> r100, Continuation<? super Unit> r101);
}
