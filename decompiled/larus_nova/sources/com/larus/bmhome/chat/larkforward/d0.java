package com.larus.bmhome.chat.larkforward;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f303392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f303393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Drawable f303394c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d0) == true) goto L8;
        return false;
    L8:
        d0 r101 = (d0) r100;
        if (Intrinsics.areEqual(this.f303392a, r101.f303392a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f303393b, r101.f303393b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f303394c, r101.f303394c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f303392a.hashCode() * 31) + this.f303393b.hashCode()) * 31;
        Drawable r101 = this.f303394c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "FlowLarkToDoubaoTarget(id=" + this.f303392a + ", name=" + this.f303393b + ", icon=" + this.f303394c + ')';
    }

    public d0(String r100, Drawable r101) {
        Intrinsics.checkNotNullParameter("doubao_main_bot", "id");
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f303392a = "doubao_main_bot";
        this.f303393b = r100;
        this.f303394c = r101;
    }
}
