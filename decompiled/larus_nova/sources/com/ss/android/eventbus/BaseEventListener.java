package com.ss.android.eventbus;

import com.ss.android.eventbus.BaseEvent;

/* JADX INFO: loaded from: classes34.dex */
public class BaseEventListener<T extends BaseEvent> implements IEventListener<T> {
    private volatile boolean isDestory;

    @Override // com.ss.android.eventbus.IEventListener
    public void onEvent(T r100) {
    }

    public BaseEventListener() {
        this.isDestory = false;
        this.isDestory = false;
    }

    public boolean isDestory() {
        return this.isDestory;
    }

    public void setDestory(boolean r100) {
        this.isDestory = r100;
    }
}
