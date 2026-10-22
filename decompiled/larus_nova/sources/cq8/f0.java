package cq8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f0 extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f464832d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f464833e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<g0> f464834f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f464835g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f464836h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<y0> f464837i;

    public f0() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r101 = (f0) r100;
        if (Intrinsics.areEqual(this.f464831c, r101.f464831c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464832d, r101.f464832d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f464833e, r101.f464833e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f464834f, r101.f464834f) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f464835g, r101.f464835g) == true) goto L24;
        return false;
    L24:
        if (this.f464836h == r101.f464836h) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f464837i, r101.f464837i) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f464831c.hashCode() * 31) + this.f464832d.hashCode()) * 31) + this.f464833e.hashCode()) * 31) + this.f464834f.hashCode()) * 31;
        String r101 = this.f464835g;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f464836h == false) goto L9;
        int r104 = 1231;
    L11:
        return ((r103 + r104) * 31) + this.f464837i.hashCode();
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MenuTabContainerDescriptor(widgetId=" + this.f464831c + ", actionChannel=" + this.f464832d + ", version=" + this.f464833e + ", tabs=" + this.f464834f + ", subTitle=" + this.f464835g + ", enableBottomLine=" + this.f464836h + ", childWidgetEntry=" + this.f464837i + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.f464833e;
    }

    public f0(String r100, com.larus.bmhome.instruction.core.impl.base.b.C4081b r101, List r102, String r103, boolean r104, List r105) {
        String r106 = a0.a.a();
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, "actionChannel");
        Intrinsics.checkNotNullParameter(r106, "version");
        Intrinsics.checkNotNullParameter(r102, "tabs");
        Intrinsics.checkNotNullParameter(r105, "childWidgetEntry");
        super("MenuTabContainerDescriptor");
        this.f464831c = r100;
        this.f464832d = r101;
        this.f464833e = r106;
        this.f464834f = r102;
        this.f464835g = r103;
        this.f464836h = r104;
        this.f464837i = r105;
    }
}
