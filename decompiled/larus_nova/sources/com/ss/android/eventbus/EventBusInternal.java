package com.ss.android.eventbus;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes34.dex */
class EventBusInternal {
    private static final String TAG = "EventBus";
    private static volatile EventBusInternal defaultBus;
    private Map<Class, List<BaseEventListener>> mEventListenerMap;

    public static EventBusInternal getDefault() {
        if (defaultBus != null) goto L15;
        monitor-enter(EventBusInternal.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (defaultBus != null) goto L9;
        defaultBus = new EventBusInternal();     // Catch: Throwable -> L11
    L9:
        monitor-exit(EventBusInternal.class);     // Catch: Throwable -> L11
    L15:
        return defaultBus;
    }

    private EventBusInternal() {
        this.mEventListenerMap = new ConcurrentHashMap();
    }

    public static Class<?> getRawType(BaseEventListener<?> r100) {
        return (Class) ((ParameterizedType) r100.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
    }

    public <T extends BaseEvent> void register(BaseEventListener<T> r100) {
        register(getRawType(r100), r100);
    }

    public <T extends BaseEvent> void trigger(T r100) {
        trigger(r100.getClass(), r100);
    }

    public <T extends BaseEvent> void unregister(BaseEventListener<T> r100) {
        unregister(getRawType(r100), r100);
    }

    public <T extends BaseEvent> void register(Class<T> r100, BaseEventListener<T> r101) {
        List<BaseEventListener> r102 = this.mEventListenerMap.get(r100);
        if (r102 != null) goto L6;
        r102 = new LinkedList();
        this.mEventListenerMap.put(r100, r102);
    L6:
        if (r102.indexOf(r101) == (-1)) goto L8;
        Objects.toString(r101);
        return;
    L8:
        r102.add(r101);
    }

    public <T extends BaseEvent> void trigger(Class<T> r100, T r101) {
        List<BaseEventListener> r102 = this.mEventListenerMap.get(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.isEmpty() == true) goto L24;
        Iterator r103 = new ArrayList(r102).iterator();
    L9:
        if (r103.hasNext() == false) goto L25;
        BaseEventListener r104 = (BaseEventListener) r103.next();
        if (r104 == null) goto L9;
        if (r104.isDestory() == true) goto L9;
        r104.onEvent(r101);
        goto L9
    L25:
        return;
    }

    public <T extends BaseEvent> void unregister(Class<T> r100, BaseEventListener<T> r101) {
        List<BaseEventListener> r102 = this.mEventListenerMap.get(r100);
        if (r102 != null) goto L5;
    L9:
        Objects.toString(r101);
        return;
    L5:
        if (r102.contains(r101) == false) goto L9;
        r102.remove(r101);
        r101.setDestory(true);
    }
}
