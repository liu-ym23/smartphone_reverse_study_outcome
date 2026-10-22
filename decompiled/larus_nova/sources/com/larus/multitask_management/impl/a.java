package com.larus.multitask_management.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kl9.u;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static final <T> List<T> e(CopyOnWriteArrayList<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(r102.next());
        goto L4
    L6:
        return r101;
    }

    public static final <T> List<T> a(CopyOnWriteArrayList<T> r100, Function1<? super T, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "predicate");
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        T r104 = r103.next();
        if (r101.invoke(r104).booleanValue() == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        return r102;
    }

    public static final <T> T b(CopyOnWriteArrayList<T> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 >= 0) goto L5;
    L12:
        return null;
    L5:
        if (r101 >= r100.size()) goto L12;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        T r103 = (T) Result.m9449constructorimpl(r100.get(r101));
    L11:
        if (Result.m9455isFailureimpl(r103) == true) goto L12;
        return r103;
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = (T) Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static final <T> int c(CopyOnWriteArrayList<T> r100, Function1<? super T, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "predicate");
        Iterator<T> r102 = r100.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L9;
        if (r101.invoke(r102.next()).booleanValue() == true) goto L7;
        r103 = r103 + 1;
        goto L4
    L7:
        return r103;
    L9:
        return -1;
    }

    public static final void d(CopyOnWriteArrayList r100, int r101, u r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 >= 0) goto L5;
        return;
    L5:
        if (r101 >= r100.size()) goto L14;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        Result.m9449constructorimpl(r100.set(r101, r102));     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    }
}
