package cq8;

import com.larus.bmhome.actionbar.model.MediaAttachment;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class k0 extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f464871d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f464872e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<MediaAttachment> f464873f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f464874g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f464875h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f464876i;

    public k0() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k0) == true) goto L8;
        return false;
    L8:
        k0 r101 = (k0) r100;
        if (Intrinsics.areEqual(this.f464870c, r101.f464870c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464871d, r101.f464871d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f464872e, r101.f464872e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f464873f, r101.f464873f) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f464874g, r101.f464874g) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f464875h, r101.f464875h) == true) goto L27;
        return false;
    L27:
        if (this.f464876i == r101.f464876i) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f464870c.hashCode() * 31) + this.f464871d.hashCode()) * 31) + this.f464872e.hashCode()) * 31) + this.f464873f.hashCode()) * 31;
        String r101 = this.f464874g;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f464875h;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        int r106 = (r104 + r102) * 31;
        if (this.f464876i == false) goto L13;
        int r107 = 1231;
    L15:
        return r106 + r107;
    L13:
        r107 = 1237;
        goto L15
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MultiMediaSelectorDescriptor(widgetId=" + this.f464870c + ", actionChannel=" + this.f464871d + ", version=" + this.f464872e + ", attachments=" + this.f464873f + ", emptyText=" + this.f464874g + ", subTitle=" + this.f464875h + ", enableBottomLine=" + this.f464876i + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.f464872e;
    }

    public k0(String r100, com.larus.bmhome.instruction.core.impl.base.b.C4081b r101, List r102, String r103, String r104, boolean r105) {
        String r106 = a0.a.a();
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, "actionChannel");
        Intrinsics.checkNotNullParameter(r106, "version");
        Intrinsics.checkNotNullParameter(r102, "attachments");
        super("MultiMediaSelectorDescriptor");
        this.f464870c = r100;
        this.f464871d = r101;
        this.f464872e = r106;
        this.f464873f = r102;
        this.f464874g = r103;
        this.f464875h = r104;
        this.f464876i = r105;
    }
}
