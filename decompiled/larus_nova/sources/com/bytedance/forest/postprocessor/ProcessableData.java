package com.bytedance.forest.postprocessor;

import android.net.Uri;
import com.bytedance.forest.model.ResourceFrom2;
import com.bytedance.forest.model.Response;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ProcessableData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f244430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f244431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f244432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f244433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f244434e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f244435f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f244436g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f244437h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, String> f244438i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ResourceFrom2 f244439j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ResourceFrom2 f244440k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f244441l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f244442m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f244443n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Response f244444o;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ProcessableData) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f244444o, ((ProcessableData) r100).f244444o) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Response r100 = this.f244444o;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "ProcessableData(response=" + this.f244444o + ")";
    }

    public ProcessableData(Response r100) {
        this.f244444o = r100;
        r100.f244315q.getScene();
        this.f244430a = r100.f244315q.getUrl();
        this.f244431b = r100.f244315q.getUri$forest_release();
        this.f244432c = r100.f244315q.getOriginUrl();
        r100.f244315q.getOriginUri();
        r100.f244315q.getGeckoModel();
        this.f244433d = r100.f244315q.isPreload();
        this.f244434e = r100.B;
        r100.getClass();
        this.f244435f = r100.f244315q.getGeckoModel().f244349b;
        this.f244436g = r100.f244315q.getGeckoModel().f244350c;
        this.f244437h = r100.f244315q.getGeckoModel().f244348a;
        r100.getClass();
        this.f244438i = r100.f244304f;
        this.f244439j = r100.f244320v;
        this.f244440k = r100.f244322x;
        this.f244442m = LazyKt.lazy(new ProcessableData$dataStream$2(this));
        this.f244443n = LazyKt.lazy(new ProcessableData$directBuffer$2(this));
    }
}
