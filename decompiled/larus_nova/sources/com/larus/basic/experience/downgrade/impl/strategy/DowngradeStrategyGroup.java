package com.larus.basic.experience.downgrade.impl.strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes4.dex */
public final class DowngradeStrategyGroup<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c<T>> f294846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<com.larus.basic.experience.downgrade.impl.strategy.b<T>, Continuation<? super com.larus.network.http.a<? extends T>>, Object> f294847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.basic.experience.downgrade.impl.strategy.b<T> f294848c;

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((c) r101).d()), Integer.valueOf(((c) r100).d()));
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((c) r101).g()), Integer.valueOf(((c) r100).g()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.larus.basic.experience.downgrade.impl.strategy.b<T>] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00d7 -> B:34:0x00dc). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x016f -> B:58:0x0172). Please report as a decompilation issue!!! */
    public final Object a(Continuation<? super Pair<? extends com.larus.network.http.a<? extends T>, com.larus.basic.experience.downgrade.impl.strategy.b<T>>> r110) {
        if ((r110 instanceof DowngradeStrategyGroup$process$1) == false) goto L7;
        DowngradeStrategyGroup$process$1 r100 = (DowngradeStrategyGroup$process$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        Iterator<T> r104 = (Iterator) r100.L$2;
        Ref.ObjectRef r105 = (Ref.ObjectRef) r100.L$1;
        Ref.ObjectRef r106 = (Ref.ObjectRef) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L58:
        Pair r112 = (Pair) r111;
        T r107 = (T) ((com.larus.basic.experience.downgrade.impl.strategy.b) r112.component1());
        T r113 = (T) ((com.larus.network.http.a) r112.component2());
        r106.element = r107;
        r105.element = r113;
        T r114 = r106.element;
        com.larus.network.http.a<T> r108 = ((com.larus.basic.experience.downgrade.impl.strategy.b) r114).f294859g;
        if (r108 != null) goto L61;
    L54:
        if (r104.hasNext() == false) goto L62;
        c r115 = (c) r104.next();
        com.larus.basic.experience.downgrade.impl.strategy.b r109 = (com.larus.basic.experience.downgrade.impl.strategy.b) r106.element;
        com.larus.network.http.a r116 = (com.larus.network.http.a) r105.element;
        r100.L$0 = r106;
        r100.L$1 = r105;
        r100.L$2 = r104;
        r100.label = 3;
        r111 = (T) r115.c(r109, r116);
        if (r111 != r102) goto L58;
        return r102;
    L62:
        T r117 = r106.element;
        com.larus.network.http.a<T> r118 = ((com.larus.basic.experience.downgrade.impl.strategy.b) r117).f294859g;
        if (r118 != null) goto L66;
        r118 = (com.larus.network.http.a) r105.element;
    L66:
        return TuplesKt.to(r118, r117);
    L61:
        return TuplesKt.to(r108, r114);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Ref.ObjectRef r119 = (Ref.ObjectRef) r100.L$2;
        Ref.ObjectRef r120 = (Ref.ObjectRef) r100.L$1;
        Ref.ObjectRef r121 = (Ref.ObjectRef) r100.L$0;
        ResultKt.throwOnFailure(r111);
        Ref.ObjectRef r122 = r121;
        Ref.ObjectRef r123 = r120;
        DowngradeStrategyGroup<T> r124 = this;
    L43:
        r119.element = (T) r111;
        List<c<T>> r125 = r124.f294846a;
        ArrayList r126 = new ArrayList();
        Iterator<T> r127 = r125.iterator();
    L45:
        if (r127.hasNext() == false) goto L52;
        T r128 = r127.next();
        if (((c) r128).g() < 0) goto L49;
        boolean r129 = true;
    L50:
        if (r129 == false) goto L45;
        r126.add(r128);
        goto L45
    L49:
        r129 = false;
        goto L50
    L52:
        r104 = CollectionsKt.sortedWith(CollectionsKt.toMutableList(r126), new b()).iterator();
        r105 = r123;
        r106 = r122;
        goto L54
    L17:
        Ref.ObjectRef r130 = (Ref.ObjectRef) r100.L$2;
        Iterator<T> r131 = (Iterator) r100.L$1;
        Ref.ObjectRef r132 = (Ref.ObjectRef) r100.L$0;
        ResultKt.throwOnFailure(r111);
        Iterator<T> r133 = r131;
        DowngradeStrategyGroup<T> r134 = this;
    L34:
        r130.element = (T) r111;
        T r135 = r132.element;
        com.larus.network.http.a<T> r136 = ((com.larus.basic.experience.downgrade.impl.strategy.b) r135).f294859g;
        if (r136 != null) goto L37;
        DowngradeStrategyGroup<T> r137 = r134;
        Ref.ObjectRef r138 = r132;
        Iterator<T> r139 = r133;
    L29:
        if (r139.hasNext() == false) goto L39;
        c r140 = (c) r139.next();
        com.larus.basic.experience.downgrade.impl.strategy.b<T> r141 = (com.larus.basic.experience.downgrade.impl.strategy.b) r138.element;
        r100.L$0 = r138;
        r100.L$1 = r139;
        r100.L$2 = r138;
        r100.label = 1;
        Object r142 = r140.e(r141, r100);
        if (r142 != r102) goto L33;
        return r102;
    L33:
        r133 = r139;
        r134 = r137;
        r130 = r138;
        r111 = (T) r142;
        r132 = r130;
        goto L34
    L39:
        r123 = new Ref.ObjectRef();
        Function2<com.larus.basic.experience.downgrade.impl.strategy.b<T>, Continuation<? super com.larus.network.http.a<? extends T>>, Object> r143 = r137.f294847b;
        T r144 = r138.element;
        r100.L$0 = r138;
        r100.L$1 = r123;
        r100.L$2 = r123;
        r100.label = 2;
        Object r145 = r143.invoke((com.larus.basic.experience.downgrade.impl.strategy.b<T>) r144, r100);
        if (r145 != r102) goto L42;
        return r102;
    L42:
        r122 = r138;
        r111 = (T) r145;
        r124 = r137;
        r119 = r123;
        goto L43
    L37:
        return TuplesKt.to(r136, r135);
    L18:
        ResultKt.throwOnFailure(r111);
        r138 = new Ref.ObjectRef();
        r138.element = this.f294848c;
        List<c<T>> r146 = this.f294846a;
        ArrayList r147 = new ArrayList();
        Iterator<T> r148 = r146.iterator();
    L20:
        if (r148.hasNext() == false) goto L27;
        T r149 = r148.next();
        if (((c) r149).d() < 0) goto L24;
        boolean r150 = true;
    L25:
        if (r150 == false) goto L20;
        r147.add(r149);
        goto L20
    L24:
        r150 = false;
        goto L25
    L27:
        r139 = CollectionsKt.sortedWith(CollectionsKt.toMutableList(r147), new a()).iterator();
        r137 = this;
    L7:
        r100 = new DowngradeStrategyGroup$process$1(this, r110);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DowngradeStrategyGroup(List<? extends c<T>> r100, Function2<? super com.larus.basic.experience.downgrade.impl.strategy.b<T>, ? super Continuation<? super com.larus.network.http.a<? extends T>>, ? extends Object> r101, com.larus.basic.experience.downgrade.impl.strategy.b<T> r102) {
        Intrinsics.checkNotNullParameter(r100, "strategies");
        Intrinsics.checkNotNullParameter(r101, "originCall");
        Intrinsics.checkNotNullParameter(r102, "downgradeContext");
        this.f294846a = r100;
        this.f294847b = r101;
        this.f294848c = r102;
    }
}
