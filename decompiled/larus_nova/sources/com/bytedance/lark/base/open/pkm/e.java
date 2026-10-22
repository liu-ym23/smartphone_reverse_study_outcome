package com.bytedance.lark.base.open.pkm;

import com.ss.texturerender.TextureRenderKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f252896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f252897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f252898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f252899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f252900e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f252896a, r101.f252896a) == true) goto L12;
        return false;
    L12:
        if (this.f252897b == r101.f252897b) goto L15;
        return false;
    L15:
        if (this.f252898c == r101.f252898c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f252899d, r101.f252899d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f252900e, r101.f252900e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f252896a.hashCode() * 31;
        long r101 = this.f252897b;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f252898c) * 31;
        Long r103 = this.f252899d;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return ((r102 + r104) * 31) + this.f252900e.hashCode();
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final String toString() {
        return "InvokeHookInfo(moduleName=" + this.f252896a + ", libraryId=" + this.f252897b + ", libId=" + this.f252898c + ", instance=" + this.f252899d + ", methodName=" + this.f252900e + ')';
    }

    public e(Long r100, String r101) {
        Intrinsics.checkNotNullParameter("open_pkm", TextureRenderKeys.KEY_MODULE_NAME);
        Intrinsics.checkNotNullParameter(r101, "methodName");
        this.f252896a = "open_pkm";
        this.f252897b = -1289516615139540930L;
        this.f252898c = 2124726334;
        this.f252899d = r100;
        this.f252900e = r101;
    }
}
