package com.bytedance.ies.xbridge.storage.utils;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u0001*\u0006\b\u0001\u0010\u0003 \u00002\u00020\u0001¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/xbridge/storage/utils/SingletonHolder;", "", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "anniex-deprecated_release"}, k = 1, mv = {1, 4, 3})
public class SingletonHolder<T, A> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super A, ? extends T> f249539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile T f249540b;

    public SingletonHolder(Function1<? super A, ? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "creator");
        this.f249539a = r100;
    }
}
