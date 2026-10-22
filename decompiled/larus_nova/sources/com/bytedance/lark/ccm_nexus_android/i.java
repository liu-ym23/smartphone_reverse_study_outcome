package com.bytedance.lark.ccm_nexus_android;

import com.ss.texturerender.TextureRenderKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f252916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f252917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f252918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f252919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f252920e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f252916a, r101.f252916a) == true) goto L12;
        return false;
    L12:
        if (this.f252917b == r101.f252917b) goto L15;
        return false;
    L15:
        if (this.f252918c == r101.f252918c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f252919d, r101.f252919d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f252920e, r101.f252920e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f252916a.hashCode() * 31;
        long r101 = this.f252917b;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f252918c) * 31;
        Long r103 = this.f252919d;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return ((r102 + r104) * 31) + this.f252920e.hashCode();
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final String toString() {
        return "InvokeHookInfo(moduleName=" + this.f252916a + ", libraryId=" + this.f252917b + ", libId=" + this.f252918c + ", instance=" + this.f252919d + ", methodName=" + this.f252920e + ')';
    }

    public i(Long r100, String r101) {
        Intrinsics.checkNotNullParameter("ccm_nexus", TextureRenderKeys.KEY_MODULE_NAME);
        Intrinsics.checkNotNullParameter(r101, "methodName");
        this.f252916a = "ccm_nexus";
        this.f252917b = -1149330650820507274L;
        this.f252918c = -866121354;
        this.f252919d = r100;
        this.f252920e = r101;
    }
}
