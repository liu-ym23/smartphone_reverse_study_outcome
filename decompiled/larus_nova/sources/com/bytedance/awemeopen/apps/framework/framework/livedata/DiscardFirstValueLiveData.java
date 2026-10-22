package com.bytedance.awemeopen.apps.framework.framework.livedata;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0002\u0005\u0006B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/livedata/DiscardFirstValueLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MutableLiveData;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ObserverWrapper", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class DiscardFirstValueLiveData<T> extends MutableLiveData<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f196952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Observer<? super T>, ObserverWrapper<T>> f196953b;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/livedata/DiscardFirstValueLiveData$ObserverWrapper;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/Observer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final class ObserverWrapper<T> implements Observer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super T> f196954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DiscardFirstValueLiveData<T> f196955b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f196956c;

        public static final class a {
        }

        static {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T r100) {
            if (this.f196956c < this.f196955b.f196952a) goto L5;
            return;
        L5:
            this.f196954a.onChanged(r100);
        }

        public ObserverWrapper(Observer<? super T> r100, DiscardFirstValueLiveData<T> r101) {
            Intrinsics.checkNotNullParameter(r100, "mObserver");
            Intrinsics.checkNotNullParameter(r101, "liveData");
            this.f196954a = r100;
            this.f196955b = r101;
            this.f196956c = r101.f196952a;
        }
    }

    public static final class a {
    }

    static {
    }

    public DiscardFirstValueLiveData() {
        this.f196952a = -1;
        this.f196953b = new LinkedHashMap();
        this.f196952a = -1;
    }

    public DiscardFirstValueLiveData(T r100) {
        this.f196952a = -1;
        this.f196953b = new LinkedHashMap();
        setValue(r100);
    }

    @Override // androidx.lifecycle.LiveData
    public final void observeForever(Observer<? super T> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        LinkedHashMap r101 = (LinkedHashMap) this.f196953b;
        Object r102 = r101.get(r100);
        if (r102 != null) goto L5;
        r102 = new ObserverWrapper(r100, this);
        this.f196953b.put(r100, (ObserverWrapper<T>) r102);
        r101.put(r100, r102);
    L5:
        super.observeForever((ObserverWrapper) r102);
    }

    @Override // androidx.lifecycle.LiveData
    public final void removeObserver(Observer<? super T> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        ObserverWrapper<T> r101 = this.f196953b.remove(r100);
        if (r101 == null) goto L5;
        r100 = r101;
    L5:
        super.removeObserver(r100);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void setValue(T r100) {
        this.f196952a++;
        super.setValue(r100);
    }

    @Override // androidx.lifecycle.LiveData
    public final void observe(LifecycleOwner r100, Observer<? super T> r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        LinkedHashMap r102 = (LinkedHashMap) this.f196953b;
        Object r103 = r102.get(r101);
        if (r103 != null) goto L5;
        r103 = new ObserverWrapper(r101, this);
        this.f196953b.put(r101, (ObserverWrapper<T>) r103);
        r102.put(r101, r103);
    L5:
        super.observe(r100, (ObserverWrapper) r103);
    }
}
