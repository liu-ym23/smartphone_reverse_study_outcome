package com.ss.android.ugc.aweme.search.common.ambient.property;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/ambient/property/AbECPropertyHolder;", ExifInterface.GPS_DIRECTION_TRUE, "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbECPropertyHolder<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f451454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f451455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f451456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final T f451457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final T f451458e;

    public abstract void a(T r100, int r101);

    /* JADX WARN: Multi-variable type inference failed */
    public AbECPropertyHolder(Object r100, Object r101) {
        this.f451457d = r100;
        this.f451458e = r101;
        this.f451454a = LazyKt.lazy(AbECPropertyHolder$notChangeFilter$2.INSTANCE);
        this.f451456c = 5;
    }
}
