package com.ss.android.ad.applinksdk.interceptor;

import android.content.Context;
import ira.d;
import ira.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class InterceptorModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f406365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f406366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f406367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f406368d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof InterceptorModel) == false) goto L10;
        InterceptorModel r101 = (InterceptorModel) r100;
        if (Intrinsics.areEqual(this.f406367c, r101.f406367c) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f406368d, r101.f406368d) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        e r100 = this.f406367c;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Context r104 = this.f406368d;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "InterceptorModel(nativeModel=" + this.f406367c + ", context=" + this.f406368d + ")";
    }

    public final Context getContext() {
        return this.f406368d;
    }

    public InterceptorModel(e r100, Context r101) {
        this.f406367c = r100;
        this.f406368d = r101;
        this.f406365a = LazyKt.lazy(new InterceptorModel$strategyModel$2(this));
        this.f406366b = r100.f495545d;
    }
}
