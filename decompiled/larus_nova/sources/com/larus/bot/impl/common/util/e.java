package com.larus.bot.impl.common.util;

import androidx.lifecycle.LifecycleCoroutineScope;
import kotlin.Function;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.c1;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    public static final class a implements FlowCollector, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f317678a;

        public a(Function2 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f317678a = r100;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final /* synthetic */ Object emit(Object r100, Continuation r101) {
            return this.f317678a.invoke(r100, r101);
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof FlowCollector) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f317678a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    public static final c1 b(MutableSharedFlow r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new c1(new FlowExtKt$throttleFirst$1(r100, 1000, null));
    }

    public static final void a(d1 r100, LifecycleCoroutineScope r101, Function2 r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "scope");
        Intrinsics.checkNotNullParameter(r102, "action");
        BuildersKt.launch$default(r101, null, null, new FlowExtKt$collectIn$1(r100, r102, null), 3, null);
    }
}
