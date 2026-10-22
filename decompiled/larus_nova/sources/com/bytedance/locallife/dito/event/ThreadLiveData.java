package com.bytedance.locallife.dito.event;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import com.bytedance.locallife.dito.core.c0;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/dito/event/ThreadLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/locallife/dito/event/DitoMutableLiveData;", "<init>", "()V", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public class ThreadLiveData<T> extends DitoMutableLiveData<T> {
    public ThreadLiveData() {
        super(null, null);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final synchronized void setValue(T r110) {
        monitor-enter(this);
        Field[] r100 = LiveData.class.getDeclaredFields();     // Catch: Throwable -> L34
        int r101 = r100.length;     // Catch: Throwable -> L34
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L10;
        Field r103 = r100[r102];     // Catch: Throwable -> L34
        if (Intrinsics.areEqual(r103.getName(), "mVersion") == true) goto L12;
        r102 = r102 + 1;     // Catch: Throwable -> L34
    L12:
        if (r103 == null) goto L14;
        r103.setAccessible(true);     // Catch: Throwable -> L34
        Object r104 = r103.get(this);     // Catch: Throwable -> L34
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L34
        r103.set(this, Integer.valueOf(((Integer) r104).intValue() + 1));     // Catch: Throwable -> L34
    L14:
        Field[] r105 = LiveData.class.getDeclaredFields();     // Catch: Throwable -> L34
        int r106 = r105.length;     // Catch: Throwable -> L34
        int r107 = 0;
    L15:
        if (r107 >= r106) goto L20;
        Field r108 = r105[r107];     // Catch: Throwable -> L34
        if (Intrinsics.areEqual(r108.getName(), "mData") == true) goto L21;
        r107 = r107 + 1;     // Catch: Throwable -> L34
    L21:
        if (r108 == null) goto L23;
        r108.setAccessible(true);     // Catch: Throwable -> L34
        r108.set(this, r110);     // Catch: Throwable -> L34
    L23:
        Method[] r111 = LiveData.class.getDeclaredMethods();     // Catch: Throwable -> L34
        int r109 = r111.length;     // Catch: Throwable -> L34
        int r112 = 0;
    L24:
        if (r112 >= r109) goto L29;
        Method r113 = r111[r112];     // Catch: Throwable -> L34
        if (Intrinsics.areEqual(r113.getName(), "dispatchingValue") == true) goto L30;
        r112 = r112 + 1;     // Catch: Throwable -> L34
    L30:
        if (r113 == null) goto L32;
        r113.setAccessible(true);     // Catch: Throwable -> L34
        r113.invoke(this, new Object[]{null});     // Catch: Throwable -> L34
    L32:
        monitor-exit(this);
        return;
    L29:
        r113 = null;
        goto L30
    L20:
        r108 = null;
        goto L21
    L10:
        r103 = null;
    L34:
        th = move-exception;
        throw th;
    }

    public ThreadLiveData(String r100, c0 r101) {
        super(r100, r101);
    }
}
