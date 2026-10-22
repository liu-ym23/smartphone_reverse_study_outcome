package com.ss.android.lark.jsruntime.vmsdk;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.io.InputStream;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f428169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f428170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f428171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InputStream f428172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f428173e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f428169a, r101.f428169a) == true) goto L12;
        return false;
    L12:
        if (this.f428170b == r101.f428170b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f428171c, r101.f428171c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f428172d, r101.f428172d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f428173e, r101.f428173e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f428169a.hashCode() * 31) + this.f428170b) * 31) + this.f428171c.hashCode()) * 31) + this.f428172d.hashCode()) * 31;
        String r101 = this.f428173e;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "NetWorkResponse(url=" + this.f428169a + ", status=" + this.f428170b + ", headers=" + this.f428171c + ", body=" + this.f428172d + ", mimeType=" + this.f428173e + ')';
    }

    public i(String r100, int r101, Map<String, String> r102, InputStream r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r102, "headers");
        Intrinsics.checkNotNullParameter(r103, ContainerPosition.BODY);
        this.f428169a = r100;
        this.f428170b = r101;
        this.f428171c = r102;
        this.f428172d = r103;
        this.f428173e = r104;
    }
}
