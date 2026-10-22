package com.bytedance.lark.open_app_android;

import com.ss.texturerender.TextureRenderKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f253426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f253427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f253428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f253429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f253430e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f253426a, r101.f253426a) == true) goto L12;
        return false;
    L12:
        if (this.f253427b == r101.f253427b) goto L15;
        return false;
    L15:
        if (this.f253428c == r101.f253428c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f253429d, r101.f253429d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f253430e, r101.f253430e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f253426a.hashCode() * 31;
        long r101 = this.f253427b;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f253428c) * 31;
        Long r103 = this.f253429d;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return ((r102 + r104) * 31) + this.f253430e.hashCode();
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final String toString() {
        return "InvokeHookInfo(moduleName=" + this.f253426a + ", libraryId=" + this.f253427b + ", libId=" + this.f253428c + ", instance=" + this.f253429d + ", methodName=" + this.f253430e + ')';
    }

    public f(Long r100, String r101) {
        Intrinsics.checkNotNullParameter("open_app", TextureRenderKeys.KEY_MODULE_NAME);
        Intrinsics.checkNotNullParameter(r101, "methodName");
        this.f253426a = "open_app";
        this.f253427b = -2042214572265789549L;
        this.f253428c = -1460099181;
        this.f253429d = r100;
        this.f253430e = r101;
    }
}
