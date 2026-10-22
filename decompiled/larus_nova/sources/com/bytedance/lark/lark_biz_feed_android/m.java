package com.bytedance.lark.lark_biz_feed_android;

import com.ss.texturerender.TextureRenderKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f253174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f253175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f253176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f253177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f253178e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f253174a, r101.f253174a) == true) goto L12;
        return false;
    L12:
        if (this.f253175b == r101.f253175b) goto L15;
        return false;
    L15:
        if (this.f253176c == r101.f253176c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f253177d, r101.f253177d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f253178e, r101.f253178e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f253174a.hashCode() * 31;
        long r101 = this.f253175b;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f253176c) * 31;
        Long r103 = this.f253177d;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return ((r102 + r104) * 31) + this.f253178e.hashCode();
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final String toString() {
        return "InvokeHookInfo(moduleName=" + this.f253174a + ", libraryId=" + this.f253175b + ", libId=" + this.f253176c + ", instance=" + this.f253177d + ", methodName=" + this.f253178e + ')';
    }

    public m(String r100) {
        Intrinsics.checkNotNullParameter("lark_biz_feed", TextureRenderKeys.KEY_MODULE_NAME);
        Intrinsics.checkNotNullParameter(r100, "methodName");
        this.f253174a = "lark_biz_feed";
        this.f253175b = 5912850658444239768L;
        this.f253176c = -1568611432;
        this.f253177d = null;
        this.f253178e = r100;
    }
}
