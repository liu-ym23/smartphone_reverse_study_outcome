package com.ss.android.lark.compose.chat_member_list;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes35.dex */
public final class e<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2<T, Continuation<? super Unit>, Object> f417349a;

    /* JADX WARN: Multi-variable type inference failed */
    public e(Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r100) {
        this.f417349a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T r100, Continuation<? super Unit> r101) {
        Object r102 = this.f417349a.invoke(r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }
}
