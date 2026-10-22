package com.bytedance.ies.tools.prefetch;

import android.net.Uri;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes19.dex */
public final class UriWrapper {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f248769f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f248770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f248771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f248772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f248773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f248774e;

    static {
        f248769f = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(UriWrapper.class), "uri", "getUri()Landroid/net/Uri;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(UriWrapper.class), "host", "getHost()Ljava/lang/String;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(UriWrapper.class), "queryMap", "getQueryMap()Ljava/util/SortedMap;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(UriWrapper.class), faceverify.w.BLOB_ELEM_IMAGE_HASHCODE, "getHash()Ljava/lang/String;"))};
    }

    public final Uri a() {
        Lazy r100 = this.f248770a;
        KProperty r101 = f248769f[0];
        return (Uri) r100.getValue();
    }

    public UriWrapper(String r100) {
        this.f248774e = r100;
        this.f248770a = LazyKt.lazy(new UriWrapper$uri$2(this));
        this.f248771b = LazyKt.lazy(new UriWrapper$host$2(this));
        this.f248772c = LazyKt.lazy(new UriWrapper$queryMap$2(this));
        this.f248773d = LazyKt.lazy(new UriWrapper$hash$2(this));
    }
}
