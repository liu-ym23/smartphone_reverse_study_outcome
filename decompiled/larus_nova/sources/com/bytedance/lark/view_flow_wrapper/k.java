package com.bytedance.lark.view_flow_wrapper;

import com.ss.texturerender.TextureRenderKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f254438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f254439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f254440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f254441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f254442e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f254438a, r101.f254438a) == true) goto L12;
        return false;
    L12:
        if (this.f254439b == r101.f254439b) goto L15;
        return false;
    L15:
        if (this.f254440c == r101.f254440c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f254441d, r101.f254441d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f254442e, r101.f254442e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f254438a.hashCode() * 31;
        long r101 = this.f254439b;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f254440c) * 31;
        Long r103 = this.f254441d;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return ((r102 + r104) * 31) + this.f254442e.hashCode();
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final String toString() {
        return "InvokeHookInfoWrapper(moduleName=" + this.f254438a + ", libraryId=" + this.f254439b + ", libId=" + this.f254440c + ", instance=" + this.f254441d + ", methodName=" + this.f254442e + ')';
    }

    public k(String r100, long r101, int r102, Long r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, TextureRenderKeys.KEY_MODULE_NAME);
        Intrinsics.checkNotNullParameter(r104, "methodName");
        this.f254438a = r100;
        this.f254439b = r101;
        this.f254440c = r102;
        this.f254441d = r103;
        this.f254442e = r104;
    }
}
