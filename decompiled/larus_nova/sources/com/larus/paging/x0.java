package com.larus.paging;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes29.dex */
public interface x0<Key, Value> extends y0<Key, Value> {
    Object a(Continuation<? super RemoteMediator.InitializeAction> r100);

    StateFlowImpl getState();
}
