package com.larus.im.internal.network.chunk.receiver;

import com.larus.im.internal.protocol.bean.DownlinkMessage;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes30.dex */
public interface b {
    Object a(int r100, com.larus.im.internal.network.e<DownlinkMessage> r101, Continuation<? super Unit> r102);

    com.larus.im.internal.network.chunk.cache.a.C4363a getTask();
}
