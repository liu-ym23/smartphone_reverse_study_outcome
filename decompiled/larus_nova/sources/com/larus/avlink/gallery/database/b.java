package com.larus.avlink.gallery.database;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes25.dex */
public interface b {
    int a(a r100);

    Object b(a r100, Continuation<? super Long> r101);

    Object c(List<String> r100, Continuation<? super Integer> r101);

    Object d(int r100, int r101, Continuation<? super List<a>> r102);

    Object e(List<Long> r100, Continuation<? super List<a>> r101);

    Object f(Continuation<? super Integer> r100);

    Object g(List<a> r100, Continuation<? super List<Long>> r101);

    Object h(Continuation<? super List<a>> r100);

    Object i(int r100, Continuation<? super List<a>> r101);

    Object j(String r100, Continuation<? super a> r101);

    Object k(String r100, ContinuationImpl r101);

    Object l(List<Integer> r100, Continuation<? super List<a>> r101);

    Object m(String r100, Continuation<? super Integer> r101);

    Object n(int r100, Continuation<? super List<a>> r101);
}
