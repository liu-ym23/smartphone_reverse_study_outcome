package com.bytedance.ee.bear.contract;

import android.content.Context;
import android.widget.ImageView;
import com.bytedance.ee.bear.list.dto.Document;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f217058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Document f217059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f217060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f217061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f217062e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f217063f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r101 = (g0) r100;
        if (Intrinsics.areEqual(this.f217058a, r101.f217058a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f217059b, r101.f217059b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f217060c, r101.f217060c) == true) goto L18;
        return false;
    L18:
        if (this.f217061d == r101.f217061d) goto L21;
        return false;
    L21:
        if (this.f217062e == r101.f217062e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f217063f, r101.f217063f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Context r100 = this.f217058a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Document r104 = this.f217059b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f217060c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        int r110 = 1231;
        if (this.f217061d == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.f217062e == true) goto L22;
        r110 = 1237;
    L22:
        int r113 = (r112 + r110) * 31;
        ImageView r114 = this.f217063f;
        if (r114 == null) goto L27;
        r101 = r114.hashCode();
    L27:
        return r113 + r101;
    L17:
        r111 = 1237;
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LoadIconConfig(context=" + this.f217058a + ", item=" + this.f217059b + ", token=" + this.f217060c + ", isGrid=" + this.f217061d + ", isDirty=" + this.f217062e + ", imageView=" + this.f217063f + ')';
    }

    public final Context getContext() {
        return this.f217058a;
    }

    public g0(Context r100, Document r101, String r102, boolean r103, ImageView r104) {
        this.f217058a = r100;
        this.f217059b = r101;
        this.f217060c = r102;
        this.f217061d = r103;
        this.f217062e = false;
        this.f217063f = r104;
    }
}
