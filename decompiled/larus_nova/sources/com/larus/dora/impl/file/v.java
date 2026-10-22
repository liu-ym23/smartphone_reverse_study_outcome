package com.larus.dora.impl.file;

import com.bytedance.dora.file.DoraInterruptLogFileReason;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
public interface v {
    Object a(String r100, DoraInterruptLogFileReason r101, Continuation<? super Unit> r102);

    Object b(String r100, int r101, Continuation<? super Boolean> r102);

    Object c(long r100, String r101, long r102);
}
