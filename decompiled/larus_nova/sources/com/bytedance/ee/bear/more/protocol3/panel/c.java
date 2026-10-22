package com.bytedance.ee.bear.more.protocol3.panel;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f234938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f234939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q f234940c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f234938a, r101.f234938a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f234939b, r101.f234939b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f234940c, r101.f234940c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f234938a.hashCode() * 31;
        String r101 = this.f234939b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        q r105 = this.f234940c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CustomItemFactory(template=" + this.f234938a + ", itemId=" + this.f234939b + ", delegate=" + this.f234940c + ')';
    }

    public c(d r100, String r101, q r102) {
        Intrinsics.checkNotNullParameter(r100, ThumbGlideUrl.SOURCE_TEMPLATE);
        this.f234938a = r100;
        this.f234939b = r101;
        this.f234940c = r102;
    }
}
