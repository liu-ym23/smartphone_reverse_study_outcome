package com.larus.dora.obric.device_management.device_home;

import com.larus.dora.impl.resource.DoraResourceDeviceType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DoraObricDeviceHomeQuickActionType f339299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f339300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f339301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f339302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DoraResourceDeviceType f339303e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m1) == true) goto L8;
        return false;
    L8:
        m1 r101 = (m1) r100;
        if (this.f339299a == r101.f339299a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f339300b, r101.f339300b) == true) goto L15;
        return false;
    L15:
        if (this.f339301c == r101.f339301c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f339302d, r101.f339302d) == true) goto L21;
        return false;
    L21:
        if (this.f339303e == r101.f339303e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f339299a.hashCode() * 31) + this.f339300b.hashCode()) * 31) + this.f339301c) * 31;
        String r101 = this.f339302d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        DoraResourceDeviceType r105 = this.f339303e;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraObricDeviceHomeQuickAction(type=" + this.f339299a + ", title=" + this.f339300b + ", iconResId=" + this.f339301c + ", iconResourceName=" + this.f339302d + ", iconResourceDeviceType=" + this.f339303e + ')';
    }

    public final DoraObricDeviceHomeQuickActionType getType() {
        return this.f339299a;
    }

    public m1(DoraObricDeviceHomeQuickActionType r100, String r101, int r102, String r103, DoraResourceDeviceType r104) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "title");
        this.f339299a = r100;
        this.f339300b = r101;
        this.f339301c = r102;
        this.f339302d = r103;
        this.f339303e = r104;
    }

    public /* synthetic */ m1(DoraObricDeviceHomeQuickActionType r100, String r101, int r102, String r110, int r111) {
        if ((r111 & 8) == 0) goto L5;
        r110 = null;
    L5:
        this(r100, r101, r102, r110, null);
    }
}
