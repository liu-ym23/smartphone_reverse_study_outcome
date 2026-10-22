package com.ss.android.lark.framework.larkwidget;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0007J\u001a\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0007J.\u0010\u0018\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00190\rH\u0007J&\u0010\u001d\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u0015\u001a\u00020\u00062\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00190\rH\u0007J \u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00062\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\rH\u0007J\u0015\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0002\u0010!J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020 J\u0010\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u0015\u001a\u00020\u0006J\u0016\u0010#\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020$J\u0015\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0002\u0010'J\u0016\u0010%\u001a\u00020&2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020&J\u0015\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0002\u0010*J\u0016\u0010(\u001a\u00020)2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020)J\u0015\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0002\u0010-J\u0016\u0010+\u001a\u00020,2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020,J\u0015\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0002\u00100J\u0016\u0010.\u001a\u00020/2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020/J\u0015\u00101\u001a\u0004\u0018\u0001022\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0002\u00103J\u0016\u00101\u001a\u0002022\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\"\u001a\u000202J\u0015\u00104\u001a\u0004\u0018\u0001052\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0002\u00106J\u0016\u00104\u001a\u0002052\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\"\u001a\u000205J)\u00107\u001a\u0004\u0018\u0001H\u0019\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u0015\u001a\u00020\u00062\f\u00108\u001a\b\u0012\u0004\u0012\u0002H\u001909¢\u0006\u0002\u0010:J \u00107\u001a\u0004\u0018\u0001H\u0019\"\u0006\b\u0000\u0010\u0019\u0018\u00012\u0006\u0010\u0015\u001a\u00020\u0006H\u0086\b¢\u0006\u0002\u0010;J\b\u0010<\u001a\u00020\u0012H\u0002R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/ss/android/lark/framework/larkwidget/WidgetSharedData;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "dataMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getDataMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "liveDataMap", "", "Landroidx/lifecycle/MutableLiveData;", "rawObserverToTypeSafeObserver", "Landroidx/lifecycle/Observer;", "Lcom/ss/android/lark/framework/larkwidget/TypeSafeObserver;", "handler", "Landroid/os/Handler;", "putData", "", "bundle", "Landroid/os/Bundle;", "key", "data", "postData", "observe", ExifInterface.GPS_DIRECTION_TRUE, "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "observeForever", "removeObserver", "getBoolean", "", "(Ljava/lang/Object;)Ljava/lang/Boolean;", "defaultValue", "getString", "", "getInt", "", "(Ljava/lang/Object;)Ljava/lang/Integer;", "getLong", "", "(Ljava/lang/Object;)Ljava/lang/Long;", "getFloat", "", "(Ljava/lang/Object;)Ljava/lang/Float;", "getDouble", "", "(Ljava/lang/Object;)Ljava/lang/Double;", "getShort", "", "(Ljava/lang/Object;)Ljava/lang/Short;", "getByte", "", "(Ljava/lang/Object;)Ljava/lang/Byte;", "getObject", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;", "(Ljava/lang/Object;)Ljava/lang/Object;", "assertMainThread", "lark-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WidgetSharedData extends ViewModel {
    private final ConcurrentHashMap<Object, Object> dataMap;
    private final Handler handler;
    private final Map<Object, MutableLiveData<Object>> liveDataMap;
    private final ConcurrentHashMap<Observer<?>, TypeSafeObserver<?>> rawObserverToTypeSafeObserver;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WidgetSharedData f425759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f425760b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f425761c;

        public a(WidgetSharedData r100, Object r101, Object r102) {
            this.f425759a = r100;
            this.f425760b = r101;
            this.f425761c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f425759a.putData(this.f425760b, this.f425761c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public WidgetSharedData() {
        this.dataMap = new ConcurrentHashMap();
        this.liveDataMap = new LinkedHashMap();
        this.rawObserverToTypeSafeObserver = new ConcurrentHashMap();
        this.handler = new Handler(Looper.getMainLooper());
    }

    private final void assertMainThread() {
        Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper()));
    }

    public final ConcurrentHashMap<Object, Object> getDataMap() {
        return this.dataMap;
    }

    public final Boolean getBoolean(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r101 = this.dataMap.get(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        if ((r101 instanceof Boolean) == true) goto L8;
        return null;
    L8:
        return (Boolean) r101;
    }

    public final Byte getByte(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r101 = this.dataMap.get(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        if ((r101 instanceof Byte) == true) goto L8;
        return null;
    L8:
        return (Byte) r101;
    }

    public final Double getDouble(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r101 = this.dataMap.get(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        if ((r101 instanceof Double) == true) goto L8;
        return null;
    L8:
        return (Double) r101;
    }

    public final Float getFloat(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r101 = this.dataMap.get(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        if ((r101 instanceof Float) == true) goto L8;
        return null;
    L8:
        return (Float) r101;
    }

    public final Integer getInt(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r101 = this.dataMap.get(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        if ((r101 instanceof Integer) == true) goto L8;
        return null;
    L8:
        return (Integer) r101;
    }

    public final Long getLong(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r101 = this.dataMap.get(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        if ((r101 instanceof Long) == true) goto L8;
        return null;
    L8:
        return (Long) r101;
    }

    public final /* synthetic */ <T> T getObject(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        T r101 = (T) getDataMap().get(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return r101;
    }

    public final Short getShort(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r101 = this.dataMap.get(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        if ((r101 instanceof Short) == true) goto L8;
        return null;
    L8:
        return (Short) r101;
    }

    public final String getString(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r101 = this.dataMap.get(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        if ((r101 instanceof String) == true) goto L8;
        return null;
    L8:
        return (String) r101;
    }

    public final void putData(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        assertMainThread();
        Iterator<String> r101 = r100.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        String r102 = r101.next();
        Intrinsics.checkNotNull(r102);
        putData(r102, r100.get(r102));
        goto L4
    }

    public final boolean getBoolean(Object r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r102 = this.dataMap.get(r100);
        if (r102 != null) goto L6;
        return r101;
    L6:
        if ((r102 instanceof Boolean) == true) goto L8;
        return r101;
    L8:
        return ((Boolean) r102).booleanValue();
    }

    public final byte getByte(Object r100, byte r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r102 = this.dataMap.get(r100);
        if (r102 != null) goto L6;
        return r101;
    L6:
        if ((r102 instanceof Byte) == true) goto L8;
        return r101;
    L8:
        return ((Number) r102).byteValue();
    }

    public final double getDouble(Object r100, double r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r102 = this.dataMap.get(r100);
        if (r102 != null) goto L6;
        return r101;
    L6:
        if ((r102 instanceof Double) == true) goto L8;
        return r101;
    L8:
        return ((Number) r102).doubleValue();
    }

    public final float getFloat(Object r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r102 = this.dataMap.get(r100);
        if (r102 != null) goto L6;
        return r101;
    L6:
        if ((r102 instanceof Float) == true) goto L8;
        return r101;
    L8:
        return ((Number) r102).floatValue();
    }

    public final int getInt(Object r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r102 = this.dataMap.get(r100);
        if (r102 != null) goto L6;
        return r101;
    L6:
        if ((r102 instanceof Integer) == true) goto L8;
        return r101;
    L8:
        return ((Number) r102).intValue();
    }

    public final long getLong(Object r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r102 = this.dataMap.get(r100);
        if (r102 != null) goto L6;
        return r101;
    L6:
        if ((r102 instanceof Long) == true) goto L8;
        return r101;
    L8:
        return ((Number) r102).longValue();
    }

    public final <T> T getObject(Object r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        T r102 = (T) this.dataMap.get(r100);
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r101.isInstance(r102) == false) goto L9;
        return r102;
    L9:
        return null;
    }

    public final short getShort(Object r100, short r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r102 = this.dataMap.get(r100);
        if (r102 != null) goto L6;
        return r101;
    L6:
        if ((r102 instanceof Short) == true) goto L8;
        return r101;
    L8:
        return ((Number) r102).shortValue();
    }

    public final String getString(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        Object r102 = this.dataMap.get(r100);
        if (r102 != null) goto L6;
        return r101;
    L6:
        if ((r102 instanceof String) == true) goto L8;
        return r101;
    L8:
        return (String) r102;
    }

    public final <T> void observeForever(Object r100, Observer<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "observer");
        assertMainThread();
        if (this.rawObserverToTypeSafeObserver.contains(r101) == false) goto L5;
        return;
    L5:
        TypeSafeObserver<?> r102 = new TypeSafeObserver(r101);
        this.rawObserverToTypeSafeObserver.put(r101, r102);
        MutableLiveData<Object> r103 = this.liveDataMap.get(r100);
        if (r103 != null) goto L8;
        r103 = new MutableLiveData();
        this.liveDataMap.put(r100, r103);
    L8:
        r103.observeForever(r102);
    }

    public final void postData(Object r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.handler.post(new a(this, r100, r101));
    }

    public final void putData(Object r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        assertMainThread();
        this.dataMap.put(r100, r101);
        MutableLiveData<Object> r102 = this.liveDataMap.get(r100);
        if (r102 == null) goto L6;
        r102.setValue(r101);
        return;
    }

    public final void removeObserver(Object r100, Observer<Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "observer");
        assertMainThread();
        TypeSafeObserver<?> r102 = this.rawObserverToTypeSafeObserver.remove(r101);
        if (r102 != null) goto L5;
        return;
    L5:
        MutableLiveData<Object> r103 = this.liveDataMap.get(r100);
        if (r103 == null) goto L9;
        r103.removeObserver(r102);
        return;
    }

    public final <T> void observe(Object r100, LifecycleOwner r101, Observer<T> r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "observer");
        assertMainThread();
        if (this.rawObserverToTypeSafeObserver.contains(r102) == false) goto L5;
        return;
    L5:
        TypeSafeObserver<?> r103 = new TypeSafeObserver(r102);
        this.rawObserverToTypeSafeObserver.put(r102, r103);
        MutableLiveData<Object> r104 = this.liveDataMap.get(r100);
        if (r104 != null) goto L8;
        r104 = new MutableLiveData();
        this.liveDataMap.put(r100, r104);
    L8:
        r104.observe(r101, r103);
    }
}
