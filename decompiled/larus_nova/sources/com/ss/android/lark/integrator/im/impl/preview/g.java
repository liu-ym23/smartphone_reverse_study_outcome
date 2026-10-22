package com.ss.android.lark.integrator.im.impl.preview;

import com.ss.android.lark.biz.officesdk.im.preview.UrlPreviewCardType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UrlPreviewCardType f428030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f428031b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f428030a == r101.f428030a) goto L12;
        return false;
    L12:
        if (this.f428031b == r101.f428031b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f428030a.hashCode() * 31) + this.f428031b;
    }

    public final String toString() {
        return "PreviewRenderKey(cardType=" + this.f428030a + ", maxWidth=" + this.f428031b + ')';
    }

    public g(UrlPreviewCardType r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "cardType");
        this.f428030a = r100;
        this.f428031b = r101;
    }
}
