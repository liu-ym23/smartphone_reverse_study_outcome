package com.obric.miniapp.lynx;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class p4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f398237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f398238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Drawable f398239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f398240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final JSONObject f398241e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p4) == true) goto L8;
        return false;
    L8:
        p4 r101 = (p4) r100;
        if (Intrinsics.areEqual(this.f398237a, r101.f398237a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f398238b, r101.f398238b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f398239c, r101.f398239c) == true) goto L18;
        return false;
    L18:
        if (this.f398240d == r101.f398240d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f398241e, r101.f398241e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f398237a.hashCode() * 31;
        Drawable r101 = this.f398238b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Drawable r105 = this.f398239c;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        int r106 = (r104 + r102) * 31;
        if (this.f398240d == false) goto L13;
        int r107 = 1231;
    L15:
        return ((r106 + r107) * 31) + this.f398241e.hashCode();
    L13:
        r107 = 1237;
        goto L15
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MiniAppActionItem(title=" + this.f398237a + ", icon=" + this.f398238b + ", tailIcon=" + this.f398239c + ", disabled=" + this.f398240d + ", json=" + this.f398241e + ')';
    }

    public p4(String r100, Drawable r101, Drawable r102, boolean r103, JSONObject r104) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r104, "json");
        this.f398237a = r100;
        this.f398238b = r101;
        this.f398239c = r102;
        this.f398240d = r103;
        this.f398241e = r104;
    }
}
