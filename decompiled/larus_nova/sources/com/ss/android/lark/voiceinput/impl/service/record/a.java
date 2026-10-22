package com.ss.android.lark.voiceinput.impl.service.record;

import abc.c;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes38.dex */
public interface a extends bbc.a {
    Object b(Continuation<? super Result<Unit>> r100);

    Object c(Continuation<? super Result<Unit>> r100);

    Object e(abc.b r100, Continuation<? super Result<Unit>> r101);

    d1<yac.a> getEvents();

    i1<c> getState();

    void n(com.ss.android.lark.voiceinput.impl.service.c r100);

    Object p(Continuation<? super Result<Unit>> r100);
}
