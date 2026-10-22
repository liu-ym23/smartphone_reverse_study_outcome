package com.bytedance.awemeopen.apps.framework.framework.eventbus;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/eventbus/BusLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MutableLiveData;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ObserverWrapper", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class BusLiveData<T> extends MutableLiveData<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f196939d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<T> f196940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f196941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Observer<? super T>, ObserverWrapper<T>> f196942c;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/eventbus/BusLiveData$ObserverWrapper;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/Observer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final class ObserverWrapper<T> implements Observer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super T> f196943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BusLiveData<T> f196944b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f196945c;

        public static final class a {
        }

        static {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T r100) {
            Objects.toString(r100);
            if (this.f196945c < this.f196944b.f196941b) goto L5;
            return;
        L5:
            this.f196943a.onChanged(r100);
        }

        public ObserverWrapper(Observer<? super T> r100, BusLiveData<T> r101) {
            Intrinsics.checkNotNullParameter(r100, "mObserver");
            Intrinsics.checkNotNullParameter(r101, "liveData");
            this.f196943a = r100;
            this.f196944b = r101;
            this.f196945c = r101.f196941b;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // androidx.lifecycle.LiveData
    public final void onInactive() {
        super.onInactive();
        if (hasObservers() == true) goto L6;
        LiveDataBus r100 = LiveDataBus.f196946c;
        Class<T> r101 = this.f196940a;
        Intrinsics.checkNotNullParameter(r101, "key");
        ((Map) LiveDataBus.f196946c.f196948b.getValue()).remove(r101);
        return;
    }

    public BusLiveData(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "mKey");
        this.f196940a = r100;
        this.f196941b = -1;
        this.f196942c = new LinkedHashMap();
    }

    @Override // androidx.lifecycle.LiveData
    public final void observeForever(Observer<? super T> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        LinkedHashMap r101 = (LinkedHashMap) this.f196942c;
        Object r102 = r101.get(r100);
        if (r102 != null) goto L5;
        r102 = new ObserverWrapper(r100, this);
        this.f196942c.put(r100, (ObserverWrapper<T>) r102);
        r101.put(r100, r102);
    L5:
        super.observeForever((ObserverWrapper) r102);
        Objects.toString(r100);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void postValue(final T r100) {
        LiveDataBus r101 = LiveDataBus.f196946c;
        LiveDataBus.f196946c.f196947a.post(new com.bytedance.awemeopen.apps.framework.framework.eventbus.a(this, r100));
    }

    @Override // androidx.lifecycle.LiveData
    public final void removeObserver(Observer<? super T> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        ObserverWrapper<T> r101 = this.f196942c.remove(r100);
        if (r101 != null) goto L6;
        r101 = r100;
    L6:
        super.removeObserver(r101);
        Objects.toString(r100);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void setValue(T r100) {
        this.f196941b++;
        super.setValue(r100);
    }

    @Override // androidx.lifecycle.LiveData
    public final void observe(LifecycleOwner r100, Observer<? super T> r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        LinkedHashMap r102 = (LinkedHashMap) this.f196942c;
        Object r103 = r102.get(r101);
        if (r103 != null) goto L5;
        r103 = new ObserverWrapper(r101, this);
        this.f196942c.put(r101, (ObserverWrapper<T>) r103);
        r102.put(r101, r103);
    L5:
        super.observe(r100, (ObserverWrapper) r103);
        Objects.toString(r100);
        Objects.toString(r101);
    }
}
