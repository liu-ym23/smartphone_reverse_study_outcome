package com.larksuite.component.universe_design.dialog.compose;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f284905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f284906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UDDialogActionRole f284907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f284908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f284909e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Color f284910f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Color f284911g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Color f284912h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Dp f284913i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextStyle f284914j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f284915k;

    public d() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f284905a, r101.f284905a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f284906b, r101.f284906b) == true) goto L15;
        return false;
    L15:
        if (this.f284907c == r101.f284907c) goto L18;
        return false;
    L18:
        if (this.f284908d == r101.f284908d) goto L21;
        return false;
    L21:
        if (this.f284909e == r101.f284909e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f284910f, r101.f284910f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f284911g, r101.f284911g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f284912h, r101.f284912h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f284913i, r101.f284913i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f284914j, r101.f284914j) == true) goto L39;
        return false;
    L39:
        if (TextAlign.m7414equalsimpl0(this.f284915k, r101.f284915k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f284905a.hashCode() * 31) + this.f284906b.hashCode()) * 31) + this.f284907c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f284908d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f284909e == true) goto L10;
        r101 = 1237;
    L10:
        int r104 = (r103 + r101) * 31;
        Color r105 = this.f284910f;
        int r106 = 0;
        if (r105 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r104 + r107) * 31;
        Color r109 = this.f284911g;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        Color r112 = this.f284912h;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        Dp r115 = this.f284913i;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        TextStyle r118 = this.f284914j;
        if (r118 == null) goto L31;
        r106 = r118.hashCode();
    L31:
        return ((r117 + r106) * 31) + TextAlign.m7415hashCodeimpl(this.f284915k);
    L25:
        r116 = Dp.m7550hashCodeimpl(r115.m7558unboximpl());
        goto L26
    L21:
        r113 = Color.m4834hashCodeimpl(r112.m4837unboximpl());
        goto L22
    L17:
        r110 = Color.m4834hashCodeimpl(r109.m4837unboximpl());
        goto L18
    L13:
        r107 = Color.m4834hashCodeimpl(r105.m4837unboximpl());
        goto L14
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "UDDialogListItem(text=" + this.f284905a + ", onClick=" + this.f284906b + ", role=" + this.f284907c + ", enabled=" + this.f284908d + ", autoDismiss=" + this.f284909e + ", textColor=" + this.f284910f + ", backgroundColor=" + this.f284911g + ", pressedBackgroundColor=" + this.f284912h + ", height=" + this.f284913i + ", textStyle=" + this.f284914j + ", textAlign=" + TextAlign.m7416toStringimpl(this.f284915k) + ')';
    }

    public d(String r100, Function0 r101, UDDialogActionRole r102, boolean r103, boolean r104, Color r105, Color r106, Dp r110) {
        int r107 = TextAlign.Companion.m7418getCentere0LSkKk();
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, SendEventContainerMethodParamModel.EventKinds.onClick);
        Intrinsics.checkNotNullParameter(r102, "role");
        this.f284905a = r100;
        this.f284906b = r101;
        this.f284907c = r102;
        this.f284908d = r103;
        this.f284909e = r104;
        this.f284910f = null;
        this.f284911g = r105;
        this.f284912h = r106;
        this.f284913i = r110;
        this.f284914j = null;
        this.f284915k = r107;
    }
}
