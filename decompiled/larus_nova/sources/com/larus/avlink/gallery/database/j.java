package com.larus.avlink.gallery.database;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes25.dex */
public interface j {
    Object a(long r100, String r101, Continuation<? super Integer> r102);

    Object b(long r100, String r101, ContinuationImpl r102);

    Object c(List<Long> r100, String r101, Continuation<? super Integer> r102);

    Object d(List<Long> r100, String r101, Continuation<? super List<i>> r102);

    Object e(i r100, Continuation<? super Long> r101);

    Object f(Continuation<? super List<i>> r100);

    Object g(i r100, Continuation<? super Integer> r101);
}
