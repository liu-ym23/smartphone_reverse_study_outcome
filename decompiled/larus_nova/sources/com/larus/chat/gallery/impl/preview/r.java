package com.larus.chat.gallery.impl.preview;

import com.larus.chat.gallery.api.PreviewScene;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarLayoutMode;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarVisualStyle;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sq9.a0;

/* JADX INFO: loaded from: classes26.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PreviewScene f324605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ToolbarLayoutMode f324606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ToolbarVisualStyle f324607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f324608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<SourceType, a0> f324609e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f324610f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f324611g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f324612h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f324613i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f324614j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (this.f324605a == r101.f324605a) goto L12;
        return false;
    L12:
        if (this.f324606b == r101.f324606b) goto L15;
        return false;
    L15:
        if (this.f324607c == r101.f324607c) goto L18;
        return false;
    L18:
        if (this.f324608d == r101.f324608d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f324609e, r101.f324609e) == true) goto L24;
        return false;
    L24:
        if (this.f324610f == r101.f324610f) goto L27;
        return false;
    L27:
        if (this.f324611g == r101.f324611g) goto L30;
        return false;
    L30:
        if (this.f324612h == r101.f324612h) goto L33;
        return false;
    L33:
        if (this.f324613i == r101.f324613i) goto L36;
        return false;
    L36:
        if (this.f324614j == r101.f324614j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f324605a.hashCode() * 31) + this.f324606b.hashCode()) * 31) + this.f324607c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f324608d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((r100 + r102) * 31) + this.f324609e.hashCode()) * 31;
        if (this.f324610f == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f324611g == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f324612h == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.f324613i == false) goto L21;
        int r110 = 1231;
    L22:
        int r111 = (r109 + r110) * 31;
        if (this.f324614j == true) goto L27;
        r101 = 1237;
    L27:
        return r111 + r101;
    L21:
        r110 = 1237;
        goto L22
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "PreviewSourcePolicy(scene=" + this.f324605a + ", layoutMode=" + this.f324606b + ", visualStyle=" + this.f324607c + ", publishInSharePanel=" + this.f324608d + ", toolPresentation=" + this.f324609e + ", preserveToolPresentationForLocalMedia=" + this.f324610f + ", showBottom=" + this.f324611g + ", showSideBar=" + this.f324612h + ", showPlusButton=" + this.f324613i + ", attachCurrentImageFromAlbum=" + this.f324614j + ')';
    }

    public r(PreviewScene r100, ToolbarLayoutMode r101, ToolbarVisualStyle r102, boolean r103, Function1 r104, boolean r105, boolean r106, boolean r107, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "layoutMode");
        Intrinsics.checkNotNullParameter(r102, "visualStyle");
        Intrinsics.checkNotNullParameter(r104, "toolPresentation");
        this.f324605a = r100;
        this.f324606b = r101;
        this.f324607c = r102;
        this.f324608d = r103;
        this.f324609e = r104;
        this.f324610f = r105;
        this.f324611g = true;
        this.f324612h = r106;
        this.f324613i = r107;
        this.f324614j = r110;
    }
}
