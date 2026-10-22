package com.bytedance.forest.preload;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<c> f244484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<c> f244485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f244486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f244487d;

    public final c a() {
        LinkedList<c> r100 = this.f244484a;
        monitor-enter(r100);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L6
        Object r102 = Result.m9449constructorimpl(this.f244484a.removeLast());     // Catch: Throwable -> L6
    L9:
        if (Result.m9455isFailureimpl(r102) == false) goto L11;
        r102 = null;
    L11:
        c r103 = (c) r102;     // Catch: Throwable -> L14
        monitor-exit(r100);
        return r103;
    L6:
        th = move-exception;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L14
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public d() {
        this.f244486c = 3;
        this.f244487d = 30;
        this.f244484a = new LinkedList();
        this.f244485b = new ArrayList(3);
    }

    public final c b(com.bytedance.forest.utils.a r100) {
        LinkedList<c> r101 = this.f244484a;
        monitor-enter(r101);
        Iterator<T> r102 = this.f244484a.iterator();     // Catch: Throwable -> L14
    L6:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();     // Catch: Throwable -> L14
        if (Intrinsics.areEqual(((c) r103).f244482c, r100) == false) goto L6;
    L11:
        c r104 = (c) r103;     // Catch: Throwable -> L14
        monitor-exit(r101);
        return r104;
    L10:
        r103 = null;
    L14:
        th = move-exception;
        throw th;
    }

    public final c c(com.bytedance.forest.utils.a r100) {
        ArrayList<c> r101 = this.f244485b;
        monitor-enter(r101);
        Iterator<T> r102 = this.f244485b.iterator();     // Catch: Throwable -> L14
    L6:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();     // Catch: Throwable -> L14
        if (Intrinsics.areEqual(((c) r103).f244482c, r100) == false) goto L6;
    L11:
        c r104 = (c) r103;     // Catch: Throwable -> L14
        monitor-exit(r101);
        return r104;
    L10:
        r103 = null;
    L14:
        th = move-exception;
        throw th;
    }

    public final void d(com.bytedance.forest.utils.a r100) {
        LinkedList<c> r101 = this.f244484a;
        monitor-enter(r101);
        c r102 = b(r100);     // Catch: Throwable -> L11
        LinkedList<c> r103 = this.f244484a;     // Catch: Throwable -> L11
        if (r103 == null) goto L10;
        TypeIntrinsics.asMutableCollection(r103).remove(r102);     // Catch: Throwable -> L11
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r101);
        return;
    L10:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
