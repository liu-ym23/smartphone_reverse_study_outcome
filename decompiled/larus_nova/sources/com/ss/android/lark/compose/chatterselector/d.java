package com.ss.android.lark.compose.chatterselector;

import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f417558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageVector f417559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f417560c;

    public d() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f417558a, r101.f417558a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f417559b, r101.f417559b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f417560c, r101.f417560c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f417558a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ImageVector r104 = this.f417559b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f417560c;
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
        return "UDTagParams(text=" + this.f417558a + ", icon=" + this.f417559b + ", tagMaxWidth=" + this.f417560c + ')';
    }

    public d(String r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this.f417558a = r100;
        this.f417559b = null;
        this.f417560c = null;
    }
}
