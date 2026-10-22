package com.obric.miniapp.alarm;

import java.util.List;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes33.dex */
public interface b {
    Object a(Continuation<? super List<a>> r100);

    Object b(w r100, Continuation<? super List<a>> r101);

    Object c(String r100, Continuation<? super a> r101);

    Object d(Continuation<? super List<String>> r100);

    Object delete(String r100, String r101, Continuation<? super Integer> r102);

    Object e(Continuation<? super w> r100);

    Object insert(a r100, Continuation<? super Long> r101);

    Object update(String r100, w r101, int r102, String r103, Continuation<? super Integer> r104);
}
