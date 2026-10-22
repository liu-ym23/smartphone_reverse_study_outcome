package com.lark.kmp.impl;

import com.lark.kmp.basic.Scene;
import gy7.n;
import gy7.o;
import gy7.p;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes7.dex */
public final class CompositeTask implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<n> f278587a;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues((Integer) ((Pair) r100).getFirst(), (Integer) ((Pair) r101).getFirst());
        }
    }

    @Override // gy7.n
    public final void name() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CompositeTask(List<? extends n> r100) {
        Intrinsics.checkNotNullParameter(r100, "allTasks");
        this.f278587a = r100;
    }

    @Override // gy7.n
    public final Object a(p r100, Scene r101, Continuation<? super o> r110) {
        if ((r110 instanceof CompositeTask$execute$1) == false) goto L7;
        CompositeTask$execute$1 r102 = (CompositeTask$execute$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        Object r106 = null;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        o r107 = (o) r102.L$0;
        ResultKt.throwOnFailure(r111);
    L18:
        Iterator r108 = CollectionsKt.sortedWith((List) r111, new a()).iterator();
    L20:
        if (r108.hasNext() == false) goto L24;
        Object r112 = r108.next();
        if ((!((o) ((Pair) r112).component2()).f483345a) == false) goto L20;
        r106 = r112;
    L24:
        Pair r109 = (Pair) r106;
        if (r109 == null) goto L27;
        o r113 = (o) r109.getSecond();
        r107.f483345a = false;
        r107.f483346b = r113.f483346b;
        String r114 = r113.f483347c;
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r107.f483347c = r114;
    L27:
        return r107;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        o r115 = new o(true, 0, "");
        CompositeTask$execute$results$1 r116 = new CompositeTask$execute$results$1(this, r100, r101, null);
        r102.L$0 = r115;
        r102.label = 1;
        Object r117 = CoroutineScopeKt.coroutineScope(r116, r102);
        if (r117 != r104) goto L17;
        return r104;
    L17:
        r111 = r117;
        r107 = r115;
    L7:
        r102 = new CompositeTask$execute$1(this, r110);
        goto L8
    }
}
