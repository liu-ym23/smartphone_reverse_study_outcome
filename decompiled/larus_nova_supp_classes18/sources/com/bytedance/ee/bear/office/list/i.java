package com.bytedance.ee.bear.office.list;

import androidx.fragment.app.Fragment;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i {
    public final String a;
    public final WeakReference<Fragment> b;
    public final ce5.a c;
    public final WeakReference<ed5.d> d;
    public final boolean e;
    public final Function0<Boolean> f;
    public final m g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        WeakReference<ed5.d> r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        if (this.e == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r4 + r5) * 31;
        Function0<Boolean> r7 = this.f;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        m r10 = this.g;
        if (r10 == null) goto L19;
        r2 = r10.hashCode();
    L19:
        return r9 + r2;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "OfficeListPageMenuCapability(module=" + this.a + ", ownerFragmentRef=" + this.b + ", userComponentAbility=" + this.c + ", selectionHostRef=" + this.d + ", canMultiSelect=" + this.e + ", isGridProvider=" + this.f + ", longPressEnvironment=" + this.g + ')';
    }

    public final Fragment a() {
        return this.b.get();
    }

    public final ed5.d b() {
        WeakReference<ed5.d> r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    public i(String r2, WeakReference<Fragment> r3, ce5.a r4, WeakReference<ed5.d> r5, boolean r6, Function0<Boolean> r7, m r8) {
        Intrinsics.checkNotNullParameter(r2, "module");
        Intrinsics.checkNotNullParameter(r3, "ownerFragmentRef");
        Intrinsics.checkNotNullParameter(r4, "userComponentAbility");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
