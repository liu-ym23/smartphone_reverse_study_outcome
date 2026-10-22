package com.bytedance.ee.bear.creationmenu;

import com.bytedance.ee.bear.content.creation.mvp.SelectCreationMenuItem;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f217281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f217282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f217283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f217284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f217285e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<g> f217286f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<? extends SelectCreationMenuItem> f217287g;

    public a() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f217281a == r101.f217281a) goto L12;
        return false;
    L12:
        if (this.f217282b == r101.f217282b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f217283c, r101.f217283c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f217284d, r101.f217284d) == true) goto L21;
        return false;
    L21:
        if (this.f217285e == r101.f217285e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f217286f, r101.f217286f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f217287g, r101.f217287g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f217281a * 31) + this.f217282b) * 31) + this.f217283c.hashCode()) * 31) + this.f217284d.hashCode()) * 31;
        if (this.f217285e == false) goto L5;
        int r101 = 1231;
    L7:
        return ((((r100 + r101) * 31) + this.f217286f.hashCode()) * 31) + this.f217287g.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "CreationMenuItem(id=" + this.f217281a + ", iconRes=" + this.f217282b + ", title=" + this.f217283c + ", content=" + this.f217284d + ", networkEnable=" + this.f217285e + ", wikiMenuList=" + this.f217286f + ", menuList=" + this.f217287g + ')';
    }

    public a(int r100, int r101, String r102, String r103, boolean r104, List r105, int r106) {
        if ((r106 & 32) == 0) goto L6;
        r105 = CollectionsKt.emptyList();
    L6:
        if ((r106 & 64) == 0) goto L8;
        List<? extends SelectCreationMenuItem> r107 = CollectionsKt.emptyList();
    L9:
        Intrinsics.checkNotNullParameter(r102, "title");
        Intrinsics.checkNotNullParameter(r103, "content");
        Intrinsics.checkNotNullParameter(r105, "wikiMenuList");
        Intrinsics.checkNotNullParameter(r107, "menuList");
        this.f217281a = r100;
        this.f217282b = r101;
        this.f217283c = r102;
        this.f217284d = r103;
        this.f217285e = r104;
        this.f217286f = r105;
        this.f217287g = r107;
        return;
    L8:
        r107 = null;
        goto L9
    }
}
