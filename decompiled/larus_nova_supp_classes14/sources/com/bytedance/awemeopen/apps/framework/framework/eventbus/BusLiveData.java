package com.bytedance.awemeopen.apps.framework.framework.eventbus;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/eventbus/BusLiveData;", "T", "Landroidx/lifecycle/MutableLiveData;", "a", "ObserverWrapper", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class BusLiveData<T> extends MutableLiveData<T> {
    public static final /* synthetic */ int d = 0;
    public final Class<T> a;
    public int b;
    public final Map<Observer<? super T>, ObserverWrapper<T>> c;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/eventbus/BusLiveData$ObserverWrapper;", "T", "Landroidx/lifecycle/Observer;", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final class ObserverWrapper<T> implements Observer<T> {
        public final Observer<? super T> a;
        public final BusLiveData<T> b;
        public final int c;

        public static final class a {
        }

        static {
        }

        public final void onChanged(T r3) {
            Objects.toString(r3);
            if (this.c < this.b.b) goto L5;
            return;
        L5:
            this.a.onChanged(r3);
        }

        public ObserverWrapper(Observer<? super T> r2, BusLiveData<T> r3) {
            Intrinsics.checkNotNullParameter(r2, "mObserver");
            Intrinsics.checkNotNullParameter(r3, "liveData");
            this.a = r2;
            this.b = r3;
            this.c = r3.b;
        }
    }

    public static final class a {
    }

    static {
    }

    public final void onInactive() {
        super/*androidx.lifecycle.LiveData*/.onInactive();
        if (hasObservers() == true) goto L6;
        LiveDataBus r0 = LiveDataBus.c;
        Class<T> r1 = this.a;
        Intrinsics.checkNotNullParameter(r1, "key");
        ((Map) LiveDataBus.c.b.getValue()).remove(r1);
        return;
    }

    public BusLiveData(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "mKey");
        this.a = r2;
        this.b = -1;
        this.c = new LinkedHashMap();
    }

    public final void observeForever(Observer<? super T> r4) {
        Intrinsics.checkNotNullParameter(r4, "observer");
        LinkedHashMap r0 = (LinkedHashMap) this.c;
        Object r1 = r0.get(r4);
        if (r1 != null) goto L5;
        r1 = new ObserverWrapper(r4, this);
        this.c.put(r4, (ObserverWrapper<T>) r1);
        r0.put(r4, r1);
    L5:
        super/*androidx.lifecycle.LiveData*/.observeForever((ObserverWrapper) r1);
        Objects.toString(r4);
    }

    public final void postValue(final T r3) {
        LiveDataBus r0 = LiveDataBus.c;
        LiveDataBus.c.a.post(new com.bytedance.awemeopen.apps.framework.framework.eventbus.a(this, r3));
    }

    public final void removeObserver(Observer<? super T> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        ObserverWrapper<T> r0 = this.c.remove(r2);
        if (r0 != null) goto L6;
        r0 = r2;
    L6:
        super/*androidx.lifecycle.LiveData*/.removeObserver(r0);
        Objects.toString(r2);
    }

    public final void setValue(T r2) {
        this.b++;
        super.setValue(r2);
    }

    public final void observe(LifecycleOwner r4, Observer<? super T> r5) {
        Intrinsics.checkNotNullParameter(r4, "owner");
        Intrinsics.checkNotNullParameter(r5, "observer");
        LinkedHashMap r0 = (LinkedHashMap) this.c;
        Object r1 = r0.get(r5);
        if (r1 != null) goto L5;
        r1 = new ObserverWrapper(r5, this);
        this.c.put(r5, (ObserverWrapper<T>) r1);
        r0.put(r5, r1);
    L5:
        super/*androidx.lifecycle.LiveData*/.observe(r4, (ObserverWrapper) r1);
        Objects.toString(r4);
        Objects.toString(r5);
    }
}
