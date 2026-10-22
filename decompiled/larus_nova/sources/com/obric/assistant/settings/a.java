package com.obric.assistant.settings;

import android.view.View;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a extends q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f391771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f391772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f391773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<View, Unit> f391774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f391775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f391776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f391777g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f391778h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f391779i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f391771a, r101.f391771a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f391772b, r101.f391772b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f391773c, r101.f391773c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f391774d, r101.f391774d) == true) goto L21;
        return false;
    L21:
        if (this.f391775e == r101.f391775e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f391776f, r101.f391776f) == true) goto L27;
        return false;
    L27:
        if (this.f391777g == r101.f391777g) goto L30;
        return false;
    L30:
        if (this.f391778h == r101.f391778h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f391779i, r101.f391779i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f391771a.hashCode() * 31) + this.f391772b.hashCode()) * 31;
        String r101 = this.f391773c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f391774d.hashCode()) * 31;
        int r105 = 1231;
        if (this.f391775e == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f391776f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        if (this.f391777g == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r110 + r111) * 31;
        if (this.f391778h == true) goto L22;
        r105 = 1237;
    L22:
        int r113 = (r112 + r105) * 31;
        String r114 = this.f391779i;
        if (r114 == null) goto L27;
        r102 = r114.hashCode();
    L27:
        return r113 + r102;
    L17:
        r111 = 1237;
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActionUiModel(id=" + this.f391771a + ", title=" + this.f391772b + ", subtitle=" + this.f391773c + ", onClick=" + this.f391774d + ", showSubtitleRedPot=" + this.f391775e + ", endDetailText=" + this.f391776f + ", beta=" + this.f391777g + ", enabled=" + this.f391778h + ", disabledToastText=" + this.f391779i + ')';
    }

    @Override // com.obric.assistant.settings.q0
    public final boolean a(q0 r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        if ((r100 instanceof a) == true) goto L5;
        return false;
    L5:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f391771a, r101.f391771a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f391772b, r101.f391772b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f391773c, r101.f391773c) == true) goto L12;
        return false;
    L12:
        if (this.f391775e == r101.f391775e) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f391776f, r101.f391776f) == true) goto L16;
        return false;
    L16:
        if (this.f391777g == r101.f391777g) goto L18;
        return false;
    L18:
        if (this.f391778h == r101.f391778h) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f391779i, r101.f391779i) == false) goto L30;
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r100, CharSequence r101, String r102, Function1<? super View, Unit> r103, boolean r104, String r105, boolean r106, boolean r107, String r110) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r103, SendEventContainerMethodParamModel.EventKinds.onClick);
        this.f391771a = r100;
        this.f391772b = r101;
        this.f391773c = r102;
        this.f391774d = r103;
        this.f391775e = r104;
        this.f391776f = r105;
        this.f391777g = r106;
        this.f391778h = r107;
        this.f391779i = r110;
    }
}
