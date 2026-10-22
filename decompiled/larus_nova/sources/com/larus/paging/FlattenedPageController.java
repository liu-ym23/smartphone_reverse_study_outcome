package com.larus.paging;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes29.dex */
public final class FlattenedPageController<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n<T> f363649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutexImpl f363650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f363651c;

    public FlattenedPageController() {
        this.f363649a = new n();
        this.f363650b = kotlinx.coroutines.sync.b.a();
        this.f363651c = -1;
    }

    public final Object a(Continuation<? super List<? extends IndexedValue<? extends PageEvent<T>>>> r100) {
        if ((r100 instanceof FlattenedPageController$getStateAsEvents$1) == false) goto L7;
        FlattenedPageController$getStateAsEvents$1 r101 = (FlattenedPageController$getStateAsEvents$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r101.L$1;
        FlattenedPageController<T> r107 = (FlattenedPageController) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L31:
        List<PageEvent<T>> r108 = r107.f363649a.b();     // Catch: Throwable -> L28
        int r109 = (r107.f363651c - r108.size()) + 1;     // Catch: Throwable -> L28
        List<PageEvent<T>> r110 = r108;     // Catch: Throwable -> L28
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));     // Catch: Throwable -> L28
        Iterator<T> r112 = r110.iterator();     // Catch: Throwable -> L28
        int r113 = 0;
    L19:
        if (r112.hasNext() == false) goto L26;
        T r114 = r112.next();     // Catch: Throwable -> L28
        int r115 = r113 + 1;     // Catch: Throwable -> L28
        if (r113 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L28
    L24:
        int r116 = r113 + r109;     // Catch: Throwable -> L28
        r111.add(new IndexedValue(r116, (PageEvent) r114));     // Catch: Throwable -> L28
        r113 = r115;
        goto L19
    L26:
        r106.unlock(null);
        return r111;
    L28:
        th = move-exception;
        r106.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        MutexImpl r117 = this.f363650b;
        r101.L$0 = this;
        r101.L$1 = r117;
        r101.label = 1;
        if (r117.a(null, r101) != r104) goto L17;
        return r104;
    L17:
        r107 = this;
        r106 = r117;
    L7:
        r101 = new FlattenedPageController$getStateAsEvents$1(this, r100);
        goto L8
    }

    public final Object b(IndexedValue<? extends PageEvent<T>> r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof FlattenedPageController$record$1) == false) goto L7;
        FlattenedPageController$record$1 r102 = (FlattenedPageController$record$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        kotlinx.coroutines.sync.a r107 = (kotlinx.coroutines.sync.a) r102.L$2;
        IndexedValue<? extends PageEvent<T>> r108 = (IndexedValue) r102.L$1;
        FlattenedPageController<T> r109 = (FlattenedPageController) r102.L$0;
        ResultKt.throwOnFailure(r104);
        kotlinx.coroutines.sync.a r110 = r107;
        r100 = r108;
    L24:
        r109.f363651c = r100.getIndex();     // Catch: Throwable -> L21
        r109.f363649a.a(r100.getValue());     // Catch: Throwable -> L21
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L21
        r110.unlock(null);
        return Unit.INSTANCE;
    L21:
        th = move-exception;
        r110.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r110 = this.f363650b;
        r102.L$0 = this;
        r102.L$1 = r100;
        r102.L$2 = r110;
        r102.label = 1;
        if (r110.a(null, r102) != r105) goto L17;
        return r105;
    L17:
        r109 = this;
    L7:
        r102 = new FlattenedPageController$record$1(this, r101);
        goto L8
    }
}
