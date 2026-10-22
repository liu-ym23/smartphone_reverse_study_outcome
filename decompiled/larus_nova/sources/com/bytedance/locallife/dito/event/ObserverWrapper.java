package com.bytedance.locallife.dito.event;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/locallife/dito/event/ObserverWrapper;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/Observer;", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final class ObserverWrapper<T> implements Observer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Observer<T> f258280a;

    public ObserverWrapper(Observer<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f258280a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(T r100) {
        StackTraceElement[] r101 = ThreadMethodProxy.currentThread().getStackTrace();
        boolean r102 = true;
        if (r101.length != 0) goto L5;
        boolean r103 = true;
    L7:
        if ((!r103) == false) goto L16;
        int r104 = r101.length;
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L16;
        StackTraceElement r106 = r101[r105];
        if (Intrinsics.areEqual("android.arch.lifecycle.LiveData", r106.getClassName()) == false) goto L15;
        if (Intrinsics.areEqual("observeForever", r106.getMethodName()) == false) goto L15;
    L17:
        if (r102 == false) goto L19;
        return;
    L19:
        this.f258280a.onChanged(r100);
        return;
    L15:
        r105 = r105 + 1;
    L16:
        r102 = false;
        goto L17
    L5:
        r103 = false;
        goto L7
    }
}
