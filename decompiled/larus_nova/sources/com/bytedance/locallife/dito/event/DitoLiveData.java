package com.bytedance.locallife.dito.event;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.locallife.dito.core.c0;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/locallife/dito/event/DitoLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LiveData;", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public class DitoLiveData<T> extends LiveData<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f258274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c0 f258275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Observer<? super T>, Observer<? super T>> f258276c;

    public DitoLiveData() {
        this.f258274a = null;
        this.f258275b = null;
        this.f258276c = new WeakHashMap();
    }

    @Override // androidx.lifecycle.LiveData
    public final synchronized void observeForever(Observer<? super T> r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "observer");     // Catch: Throwable -> L9
        WeakHashMap r101 = (WeakHashMap) this.f258276c;     // Catch: Throwable -> L9
        Object r102 = r101.get(r100);     // Catch: Throwable -> L9
        if (r102 != null) goto L6;
        r102 = new DitoDataObserver(r100, this.f258274a, this.f258275b);     // Catch: Throwable -> L9
        r101.put(r100, r102);     // Catch: Throwable -> L9
    L6:
        super.observeForever((Observer) r102);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // androidx.lifecycle.LiveData
    public final synchronized void removeObserver(Observer<? super T> r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "observer");     // Catch: Throwable -> L11
        Observer<? super T> r101 = (Observer) ((WeakHashMap) this.f258276c).remove(r100);     // Catch: Throwable -> L11
        if (r101 == null) goto L6;
        super.removeObserver(r101);     // Catch: Throwable -> L11
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L7:
        if (r102 != null) goto L9;
        super.removeObserver(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L6:
        r102 = null;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // androidx.lifecycle.LiveData
    public final synchronized void observe(LifecycleOwner r100, Observer<? super T> r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "owner");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r101, "observer");     // Catch: Throwable -> L9
        WeakHashMap r102 = (WeakHashMap) this.f258276c;     // Catch: Throwable -> L9
        Object r103 = r102.get(r101);     // Catch: Throwable -> L9
        if (r103 != null) goto L6;
        r103 = new DitoDataObserver(r101, this.f258274a, this.f258275b);     // Catch: Throwable -> L9
        r102.put(r101, r103);     // Catch: Throwable -> L9
    L6:
        super.observe(r100, (Observer) r103);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
