package com.ss.android.lark.biz.im.api.message.params;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class e implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f410346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f410347b;

    public e() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f410346a, r101.f410346a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f410347b, r101.f410347b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        List<String> r100 = this.f410346a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        o r104 = this.f410347b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "EditMessageTagCellParam(listenerTypeList=" + this.f410346a + ", textColorConfig=" + this.f410347b + ')';
    }

    public e(List<String> r100, o r101) {
        this.f410346a = r100;
        this.f410347b = r101;
    }
}
