package com.bytedance.ee.bear.creationmenu;

import com.bytedance.ee.bear.content.creation.mvp.SelectCreationMenuItem;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final int a;
    public final int b;
    public final String c;
    public final String d;
    public final boolean e;
    public final List<g> f;
    public List<? extends SelectCreationMenuItem> g;

    public a() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        if (this.e == false) goto L5;
        int r1 = 1231;
    L7:
        return ((((r0 + r1) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "CreationMenuItem(id=" + this.a + ", iconRes=" + this.b + ", title=" + this.c + ", content=" + this.d + ", networkEnable=" + this.e + ", wikiMenuList=" + this.f + ", menuList=" + this.g + ')';
    }

    public a(int r2, int r3, String r4, String r5, boolean r6, List r7, int r8) {
        if ((r8 & 32) == 0) goto L6;
        r7 = CollectionsKt.emptyList();
    L6:
        if ((r8 & 64) == 0) goto L8;
        List<? extends SelectCreationMenuItem> r9 = CollectionsKt.emptyList();
    L9:
        Intrinsics.checkNotNullParameter(r4, "title");
        Intrinsics.checkNotNullParameter(r5, "content");
        Intrinsics.checkNotNullParameter(r7, "wikiMenuList");
        Intrinsics.checkNotNullParameter(r9, "menuList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r9;
        return;
    L8:
        r9 = null;
        goto L9
    }
}
