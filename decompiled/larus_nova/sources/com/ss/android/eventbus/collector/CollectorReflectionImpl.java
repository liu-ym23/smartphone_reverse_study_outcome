package com.ss.android.eventbus.collector;

import com.ss.android.eventbus.BaseEvent;
import com.ss.android.eventbus.BaseEventListener;
import com.ss.android.eventbus.EventBus;
import com.ss.android.eventbus.Subscribe;
import com.ss.android.eventbus.ThreadMode;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes34.dex */
public class CollectorReflectionImpl implements ICollector {
    public CollectorReflectionImpl() {
    }

    @Override // com.ss.android.eventbus.collector.ICollector
    public void register(final Object r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Method[] r101 = r100.getClass().getDeclaredMethods();
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L10;
        final Method r104 = r101[r103];
        if (r104.isAnnotationPresent(Subscribe.class) == false) goto L9;
        Subscribe r105 = (Subscribe) r104.getAnnotation(Subscribe.class);
        Class<?>[] r106 = r104.getParameterTypes();
        final ThreadMode r107 = r105.threadMode();
        Class<? extends U> r108 = r106[0].asSubclass(BaseEvent.class);
        BaseEventListener r109 = new AnonymousClass1(this, r104, r100, r107);
        EventBus.getDefault().register(r100, r108, r109, r107);
    L9:
        r103 = r103 + 1;
        goto L5
    }

    @Override // com.ss.android.eventbus.collector.ICollector
    public void unRegister(Object r100) {
        EventBus.getDefault().unregister(r100);
    }
}
