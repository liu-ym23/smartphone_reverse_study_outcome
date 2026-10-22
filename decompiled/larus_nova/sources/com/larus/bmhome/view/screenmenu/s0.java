package com.larus.bmhome.view.screenmenu;

import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class s0 implements ot8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f317384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f317385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f317386c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s0) == true) goto L8;
        return false;
    L8:
        s0 r101 = (s0) r100;
        if (this.f317384a == r101.f317384a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f317385b, r101.f317385b) == true) goto L15;
        return false;
    L15:
        if (this.f317386c == r101.f317386c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f317384a * 31) + this.f317385b.hashCode()) * 31;
        if (this.f317386c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "MenuTimeStamp(id=" + this.f317384a + ", text=" + this.f317385b + ", removeAroundDivider=" + this.f317386c + ')';
    }

    @Override // ot8.a
    public final boolean a() {
        return this.f317386c;
    }

    @Override // ot8.a
    public final int getId() {
        return this.f317384a;
    }

    public s0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f317384a = R.id.view_id_menu_timestamp;
        this.f317385b = r100;
        this.f317386c = true;
    }
}
