package com.bytedance.sdk.xbridge.cn.storage.utils;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u0001*\u0006\b\u0001\u0010\u0003 \u00002\u00020\u0001¨\u0006\u0004"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/utils/SingletonHolder;", "", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "anniex_release"}, k = 1, mv = {1, 4, 3})
public class SingletonHolder<T, A> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super A, ? extends T> f270146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile T f270147b;

    public SingletonHolder(Function1<? super A, ? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "creator");
        this.f270146a = r100;
    }

    public final T a(A r100) {
        T r101 = this.f270147b;
        if (r101 == null) goto L5;
        return r101;
    L5:
        monitor-enter(this);
        T r102 = this.f270147b;     // Catch: Throwable -> L12
        if (r102 != null) goto L10;
        Function1<? super A, ? extends T> r103 = this.f270146a;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L12
        r102 = r103.invoke(r100);     // Catch: Throwable -> L12
        this.f270147b = r102;     // Catch: Throwable -> L12
        this.f270146a = null;     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return r102;
    L12:
        th = move-exception;
        throw th;
    }
}
