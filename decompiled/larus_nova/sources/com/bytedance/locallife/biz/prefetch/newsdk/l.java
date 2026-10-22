package com.bytedance.locallife.biz.prefetch.newsdk;

import com.bytedance.retrofit2.SsResponse;
import com.ss.android.ugc.aweme.prefetch.newsdk.PrefetchType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f256960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PrefetchType f256961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f256962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f256963d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<SsResponse<?>, String, Unit> f256964e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f256965f;

    public l() {
        this(false, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.f256960a == r101.f256960a) goto L12;
        return false;
    L12:
        if (this.f256961b == r101.f256961b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(null, null) == true) goto L18;
        return false;
    L18:
        if (this.f256962c == r101.f256962c) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f256963d, r101.f256963d) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f256964e, r101.f256964e) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f256965f, r101.f256965f) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f256960a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((r101 * 31) + this.f256961b.hashCode()) * 31) + 0) * 31;
        if (this.f256962c == true) goto L11;
        r100 = 1237;
    L11:
        return ((((((r102 + r100) * 31) + this.f256963d.hashCode()) * 31) + this.f256964e.hashCode()) * 31) + this.f256965f.hashCode();
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "PrefetchRequestConfig(isPrefetch=" + this.f256960a + ", prefetchType=" + this.f256961b + ", params=null, repeatRequest=" + this.f256962c + ", extParams=" + this.f256963d + ", getDataCallBack=" + this.f256964e + ", customHeaders=" + this.f256965f + ')';
    }

    public l(boolean r100, PrefetchType r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = PrefetchType.INTERCEPTOR_PREFETCH;
    L8:
        LinkedHashMap r103 = null;
        if ((r102 & 16) == 0) goto L11;
        LinkedHashMap r104 = new LinkedHashMap();
    L13:
        if ((r102 & 32) == 0) goto L15;
        PrefetchRequestConfig$1 r105 = PrefetchRequestConfig$1.INSTANCE;
    L17:
        if ((r102 & 64) == 0) goto L19;
        r103 = new LinkedHashMap();
    L19:
        Intrinsics.checkNotNullParameter(r101, "prefetchType");
        Intrinsics.checkNotNullParameter(r104, "extParams");
        Intrinsics.checkNotNullParameter(r105, "getDataCallBack");
        Intrinsics.checkNotNullParameter(r103, "customHeaders");
        this.f256960a = r100;
        this.f256961b = r101;
        this.f256962c = false;
        this.f256963d = r104;
        this.f256964e = r105;
        this.f256965f = r103;
        return;
    L15:
        r105 = null;
        goto L17
    L11:
        r104 = null;
        goto L13
    }
}
