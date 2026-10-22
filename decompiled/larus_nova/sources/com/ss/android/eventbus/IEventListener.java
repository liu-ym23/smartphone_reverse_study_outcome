package com.ss.android.eventbus;

import com.ss.android.eventbus.BaseEvent;

/* JADX INFO: loaded from: classes34.dex */
public interface IEventListener<T extends BaseEvent> {
    void onEvent(T r100) throws Exception;
}
