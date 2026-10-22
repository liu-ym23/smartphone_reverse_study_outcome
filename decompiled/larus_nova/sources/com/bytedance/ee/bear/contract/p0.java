package com.bytedance.ee.bear.contract;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.list.dto.Document;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f217123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Document f217124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AccountService$Account f217125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f217126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f217127e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f217128f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Fragment f217129g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p0) == true) goto L8;
        return false;
    L8:
        p0 r101 = (p0) r100;
        if (Intrinsics.areEqual(this.f217123a, r101.f217123a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f217124b, r101.f217124b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f217125c, r101.f217125c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f217126d, r101.f217126d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f217127e, r101.f217127e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f217128f, r101.f217128f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f217129g, r101.f217129g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        FragmentActivity r100 = this.f217123a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Document r104 = this.f217124b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        AccountService$Account r107 = this.f217125c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f217126d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f217127e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f217128f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Fragment r119 = this.f217129g;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
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
        return "ShareClickBean(activity=" + this.f217123a + ", item=" + this.f217124b + ", account=" + this.f217125c + ", module=" + this.f217126d + ", subModule=" + this.f217127e + ", source=" + this.f217128f + ", sourceFragment=" + this.f217129g + ')';
    }

    public final FragmentActivity getActivity() {
        return this.f217123a;
    }

    public p0(FragmentActivity r100, Document r101, AccountService$Account r102, String r103, String r104, String r105, Fragment r106) {
        this.f217123a = r100;
        this.f217124b = r101;
        this.f217125c = r102;
        this.f217126d = r103;
        this.f217127e = r104;
        this.f217128f = r105;
        this.f217129g = r106;
    }
}
