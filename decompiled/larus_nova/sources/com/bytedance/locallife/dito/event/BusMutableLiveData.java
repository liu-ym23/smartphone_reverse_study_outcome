package com.bytedance.locallife.dito.event;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.locallife.dito.common.lynx.DitoLynxNativeModule;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/dito/event/BusMutableLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/locallife/dito/event/DitoMutableLiveData;", "<init>", "()V", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final class BusMutableLiveData<T> extends DitoMutableLiveData<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Observer<? super T>, Observer<? super T>> f258265d;

    public BusMutableLiveData() {
        super(null, null);
        this.f258265d = new LinkedHashMap();
    }

    public final void a(Observer<? super T> r100) throws Exception {
        Intrinsics.checkNotNullParameter(r100, "observer");
        Observer<? super T> r101 = (Observer) ((WeakHashMap) this.f258279c).get(r100);
        if (r101 == null) goto L6;
        r100 = r101;
    L6:
        Field r102 = LiveData.class.getDeclaredField("mObservers");
        r102.setAccessible(true);
        Object r103 = r102.get(this);
        Method r104 = r103.getClass().getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{Object.class});
        r104.setAccessible(true);
        Object r105 = r104.invoke(r103, new Object[]{r100});
        if ((r105 instanceof Map.Entry) == false) goto L9;
        Object r106 = ((Map.Entry) r105).getValue();
    L10:
        if (r106 == null) goto L14;
        Class<? super Object> r107 = r106.getClass().getSuperclass();
        Intrinsics.checkNotNull(r107);
        Field r108 = r107.getDeclaredField("mLastVersion");
        r108.setAccessible(true);
        Field r109 = LiveData.class.getDeclaredField("mVersion");
        r109.setAccessible(true);
        r108.set(r106, r109.get(this));
        return;
    L14:
        throw new NullPointerException("Wrapper can not be bull!");
    L9:
        r106 = null;
        goto L10
    }

    @Override // com.bytedance.locallife.dito.event.DitoMutableLiveData, androidx.lifecycle.LiveData
    public final void observeForever(Observer<? super T> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        if (this.f258265d.containsKey(r100) == true) goto L5;
        this.f258265d.put(r100, new ObserverWrapper(r100));
    L5:
        Observer<? super T> r101 = (Observer) ((LinkedHashMap) this.f258265d).get(r100);
        if (r101 == null) goto L9;
        super.observeForever(r101);
        return;
    }

    @Override // com.bytedance.locallife.dito.event.DitoMutableLiveData, androidx.lifecycle.LiveData
    public final void removeObserver(Observer<? super T> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        if (this.f258265d.containsKey(r100) == false) goto L6;
        r100 = this.f258265d.remove(r100);
    L6:
        if ((r100 instanceof Observer) == true) goto L9;
        r100 = null;
    L9:
        if (r100 == null) goto L12;
        super.removeObserver(r100);
        return;
    }

    @Override // com.bytedance.locallife.dito.event.DitoMutableLiveData, androidx.lifecycle.LiveData
    public final void observe(LifecycleOwner r100, Observer<? super T> r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        super.observe(r100, r101);
        a(r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        rq6.a.f538927a.b(DitoLynxNativeModule.NAME, "BusMutableLiveData observe hook error," + e.getMessage() + ',' + Log.getStackTraceString(e));
    }
}
