package com.larksuite.component.universe_design.dialog.compose;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f284900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f284901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UDDialogActionRole f284902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f284903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f284904e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f284900a, r101.f284900a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f284901b, r101.f284901b) == true) goto L15;
        return false;
    L15:
        if (this.f284902c == r101.f284902c) goto L18;
        return false;
    L18:
        if (this.f284903d == r101.f284903d) goto L21;
        return false;
    L21:
        if (this.f284904e == r101.f284904e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f284900a.hashCode() * 31) + this.f284901b.hashCode()) * 31) + this.f284902c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f284903d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f284904e == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "UDDialogAction(text=" + this.f284900a + ", onClick=" + this.f284901b + ", role=" + this.f284902c + ", enabled=" + this.f284903d + ", autoDismiss=" + this.f284904e + ')';
    }

    public static b a(b r100, boolean r101) {
        String r102 = r100.f284900a;
        Function0<Unit> r103 = r100.f284901b;
        UDDialogActionRole r104 = r100.f284902c;
        boolean r105 = r100.f284904e;
        Intrinsics.checkNotNullParameter(r102, "text");
        Intrinsics.checkNotNullParameter(r103, SendEventContainerMethodParamModel.EventKinds.onClick);
        Intrinsics.checkNotNullParameter(r104, "role");
        return new b(r102, r103, r104, r101, r105);
    }

    public b(String r100, Function0<Unit> r101, UDDialogActionRole r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, SendEventContainerMethodParamModel.EventKinds.onClick);
        Intrinsics.checkNotNullParameter(r102, "role");
        this.f284900a = r100;
        this.f284901b = r101;
        this.f284902c = r102;
        this.f284903d = r103;
        this.f284904e = r104;
    }
}
