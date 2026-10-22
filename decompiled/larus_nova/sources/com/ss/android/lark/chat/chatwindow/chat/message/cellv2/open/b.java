package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open;

import com.ss.android.lark.blueprint.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f413346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f413347b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f413346a == r101.f413346a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f413347b, r101.f413347b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f413346a * 31) + this.f413347b.hashCode();
    }

    public final String toString() {
        return "OpenMessageBlockKey[" + this.f413346a + ", " + this.f413347b + ']';
    }

    public final int getType() {
        return this.f413346a;
    }

    public b(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "voTypeName");
        this.f413346a = r100;
        this.f413347b = r101;
    }
}
