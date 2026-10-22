package com.bytedance.lark.molten_livequery;

import com.ss.texturerender.TextureRenderKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f253326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f253327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f253328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f253329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f253330e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f253326a, r101.f253326a) == true) goto L12;
        return false;
    L12:
        if (this.f253327b == r101.f253327b) goto L15;
        return false;
    L15:
        if (this.f253328c == r101.f253328c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f253329d, r101.f253329d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f253330e, r101.f253330e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f253326a.hashCode() * 31;
        long r101 = this.f253327b;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f253328c) * 31;
        Long r103 = this.f253329d;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return ((r102 + r104) * 31) + this.f253330e.hashCode();
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final String toString() {
        return "InvokeHookInfo(moduleName=" + this.f253326a + ", libraryId=" + this.f253327b + ", libId=" + this.f253328c + ", instance=" + this.f253329d + ", methodName=" + this.f253330e + ')';
    }

    public b(Long r100, String r101) {
        Intrinsics.checkNotNullParameter("molten_livequery", TextureRenderKeys.KEY_MODULE_NAME);
        Intrinsics.checkNotNullParameter(r101, "methodName");
        this.f253326a = "molten_livequery";
        this.f253327b = 8855028268531269900L;
        this.f253328c = 1440301324;
        this.f253329d = r100;
        this.f253330e = r101;
    }
}
