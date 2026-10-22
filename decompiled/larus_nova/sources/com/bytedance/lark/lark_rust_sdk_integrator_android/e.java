package com.bytedance.lark.lark_rust_sdk_integrator_android;

import com.ss.texturerender.TextureRenderKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f253247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f253248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f253249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f253250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f253251e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f253247a, r101.f253247a) == true) goto L12;
        return false;
    L12:
        if (this.f253248b == r101.f253248b) goto L15;
        return false;
    L15:
        if (this.f253249c == r101.f253249c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f253250d, r101.f253250d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f253251e, r101.f253251e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f253247a.hashCode() * 31;
        long r101 = this.f253248b;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f253249c) * 31;
        Long r103 = this.f253250d;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return ((r102 + r104) * 31) + this.f253251e.hashCode();
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final String toString() {
        return "InvokeHookInfo(moduleName=" + this.f253247a + ", libraryId=" + this.f253248b + ", libId=" + this.f253249c + ", instance=" + this.f253250d + ", methodName=" + this.f253251e + ')';
    }

    public e(Long r100, String r101) {
        Intrinsics.checkNotNullParameter("lark_rust_sdk_integrator", TextureRenderKeys.KEY_MODULE_NAME);
        Intrinsics.checkNotNullParameter(r101, "methodName");
        this.f253247a = "lark_rust_sdk_integrator";
        this.f253248b = 7244955805902941472L;
        this.f253249c = -2009092832;
        this.f253250d = r100;
        this.f253251e = r101;
    }
}
