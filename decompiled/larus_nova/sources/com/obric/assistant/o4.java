package com.obric.assistant;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class o4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f390382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f390383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f390384c;

    /* JADX WARN: Multi-variable type inference failed */
    public o4() {
        Object[] r100 = 0 == true ? 1 : 0;
        Object[] r101 = 0 == true ? 1 : 0;
        this(null, r100, r101, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o4) == true) goto L8;
        return false;
    L8:
        o4 r101 = (o4) r100;
        if (Intrinsics.areEqual(this.f390382a, r101.f390382a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f390383b, r101.f390383b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f390384c, r101.f390384c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f390382a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f390383b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Bundle r107 = this.f390384c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "RequestAuthenticationParams(title=" + this.f390382a + ", description=" + this.f390383b + ", reportParams=" + this.f390384c + ')';
    }

    public o4(String r100, String r101, Bundle r102) {
        this.f390382a = r100;
        this.f390383b = r101;
        this.f390384c = r102;
    }

    public /* synthetic */ o4(String r100, String r101, Bundle r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
