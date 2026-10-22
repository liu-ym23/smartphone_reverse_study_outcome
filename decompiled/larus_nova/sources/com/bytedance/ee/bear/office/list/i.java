package com.bytedance.ee.bear.office.list;

import androidx.fragment.app.Fragment;
import com.ss.android.cert.manager.constants.EventConstant;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f235904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<Fragment> f235905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ce5.a f235906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference<ed5.d> f235907d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f235908e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Boolean> f235909f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m f235910g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f235904a, r101.f235904a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f235905b, r101.f235905b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f235906c, r101.f235906c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f235907d, r101.f235907d) == true) goto L21;
        return false;
    L21:
        if (this.f235908e == r101.f235908e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f235909f, r101.f235909f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f235910g, r101.f235910g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f235904a.hashCode() * 31) + this.f235905b.hashCode()) * 31) + this.f235906c.hashCode()) * 31;
        WeakReference<ed5.d> r101 = this.f235907d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        if (this.f235908e == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r104 + r105) * 31;
        Function0<Boolean> r107 = this.f235909f;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        m r110 = this.f235910g;
        if (r110 == null) goto L19;
        r102 = r110.hashCode();
    L19:
        return r109 + r102;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "OfficeListPageMenuCapability(module=" + this.f235904a + ", ownerFragmentRef=" + this.f235905b + ", userComponentAbility=" + this.f235906c + ", selectionHostRef=" + this.f235907d + ", canMultiSelect=" + this.f235908e + ", isGridProvider=" + this.f235909f + ", longPressEnvironment=" + this.f235910g + ')';
    }

    public final Fragment a() {
        return this.f235905b.get();
    }

    public final ed5.d b() {
        WeakReference<ed5.d> r100 = this.f235907d;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    public i(String r100, WeakReference<Fragment> r101, ce5.a r102, WeakReference<ed5.d> r103, boolean r104, Function0<Boolean> r105, m r106) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r101, "ownerFragmentRef");
        Intrinsics.checkNotNullParameter(r102, "userComponentAbility");
        this.f235904a = r100;
        this.f235905b = r101;
        this.f235906c = r102;
        this.f235907d = r103;
        this.f235908e = r104;
        this.f235909f = r105;
        this.f235910g = r106;
    }
}
