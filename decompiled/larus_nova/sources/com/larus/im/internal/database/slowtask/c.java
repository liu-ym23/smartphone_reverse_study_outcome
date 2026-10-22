package com.larus.im.internal.database.slowtask;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
public interface c {
    Object a(String r100, Continuation<? super Unit> r101);

    boolean enable();

    String getName();
}
