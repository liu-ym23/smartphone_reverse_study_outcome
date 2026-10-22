package com.bytedance.lark.lark_bitable_android;

import com.ss.texturerender.TextureRenderKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f253085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f253086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f253087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f253088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f253089e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m0) == true) goto L8;
        return false;
    L8:
        m0 r101 = (m0) r100;
        if (Intrinsics.areEqual(this.f253085a, r101.f253085a) == true) goto L12;
        return false;
    L12:
        if (this.f253086b == r101.f253086b) goto L15;
        return false;
    L15:
        if (this.f253087c == r101.f253087c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f253088d, r101.f253088d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f253089e, r101.f253089e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f253085a.hashCode() * 31;
        long r101 = this.f253086b;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f253087c) * 31;
        Long r103 = this.f253088d;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return ((r102 + r104) * 31) + this.f253089e.hashCode();
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final String toString() {
        return "InvokeHookInfo(moduleName=" + this.f253085a + ", libraryId=" + this.f253086b + ", libId=" + this.f253087c + ", instance=" + this.f253088d + ", methodName=" + this.f253089e + ')';
    }

    public m0(Long r100, String r101) {
        Intrinsics.checkNotNullParameter("lark_bitable", TextureRenderKeys.KEY_MODULE_NAME);
        Intrinsics.checkNotNullParameter(r101, "methodName");
        this.f253085a = "lark_bitable";
        this.f253086b = -4859419532938133078L;
        this.f253087c = 1554039210;
        this.f253088d = r100;
        this.f253089e = r101;
    }
}
