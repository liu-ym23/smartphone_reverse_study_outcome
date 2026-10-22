package com.larus.bmhome.chat.nestedmenu;

import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.t0;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import di8.d0;
import di8.f0;
import di8.n0;
import di8.p0;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NestedMenuScene f308240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f308241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap<String, List<d0>> f308242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d0 f308243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f308244e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyOption f308245f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f308246g;

    public c() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f308240a == r101.f308240a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f308241b, r101.f308241b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f308242c, r101.f308242c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f308243d, r101.f308243d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f308244e, r101.f308244e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f308245f, r101.f308245f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f308246g, r101.f308246g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f308240a.hashCode() * 31) + this.f308241b.hashCode()) * 31) + this.f308242c.hashCode()) * 31) + this.f308243d.hashCode()) * 31;
        Integer r101 = this.f308244e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        ReplyOption r105 = this.f308245f;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f308246g;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "NestedMenuClickResult(scene=" + this.f308240a + ", sectionName=" + this.f308241b + ", sections=" + this.f308242c + ", model=" + this.f308243d + ", legacyMenuId=" + this.f308244e + ", queryOption=" + this.f308245f + ", conversationForkTaskParam=" + this.f308246g + ')';
    }

    public final b a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sectionName");
        ReplyOption r101 = this.f308245f;
        if (r101 != null) goto L5;
        return null;
    L5:
        List<d0> r102 = this.f308242c.get(r100);
        if (r102 != null) goto L8;
        r102 = CollectionsKt.emptyList();
    L8:
        d0 r103 = b(r100, r101, r102);
        if (r103 == null) goto L21;
        f0 r104 = r103.c();
        if (r104 != null) goto L13;
        return null;
    L13:
        if ((r104 instanceof b) == false) goto L17;
        b r105 = (b) r104;
    L23:
        return r105;
    L17:
        if ((r104 instanceof p0) == false) goto L24;
        f0 r106 = ((p0) r104).f468837a;
        if ((r106 instanceof b) == false) goto L25;
        r105 = (b) r106;
        goto L23
    L25:
        return null;
    L24:
        return null;
    L21:
        return null;
    }

    public static final d0 b(String r100, ReplyOption r101, List<? extends d0> r102) {
        Iterator<T> r103 = r102.iterator();
    L3:
        d0 r104 = null;
        String r105 = null;
        r105 = null;
        r105 = null;
        ModelItemIdentity r106 = null;
        r106 = null;
        if (r103.hasNext() == false) goto L44;
        d0 r107 = (d0) r103.next();
        f0 r108 = r107.c();
        if ((r108 instanceof b) == false) goto L9;
        b r109 = (b) r108;
    L15:
        if (Intrinsics.areEqual(r100, "mode") == false) goto L24;
        if (r109 == null) goto L22;
        b.a r110 = r109.f308231c;
        if (r110 == null) goto L22;
        t0 r111 = r110.f308233a;
        if (r111 == null) goto L22;
        r105 = r111.f295450a;
    L22:
        boolean r112 = Intrinsics.areEqual(r105, r101.getModeId());
    L31:
        if (r112 == true) goto L32;
        n0 r113 = r107.getSubMenu();
        if (r113 == null) goto L3;
        Map<String, List<d0>> r114 = r113.f468807a;
        if (r114 == null) goto L3;
        Collection<List<d0>> r115 = r114.values();
        if (r115 == null) goto L3;
        Iterator<T> r116 = r115.iterator();
    L41:
        if (r116.hasNext() == false) goto L3;
        r104 = b(r100, r101, (List) r116.next());
        if (r104 == null) goto L41;
    L32:
        return r107;
    L24:
        if (Intrinsics.areEqual(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL) == false) goto L30;
        if (r109 == null) goto L29;
        b.C4065b r117 = r109.f308229a;
        if (r117 == null) goto L29;
        r106 = r117.f308235b;
    L29:
        r112 = Intrinsics.areEqual(r106, r101.getModel());
        goto L31
    L30:
        r112 = false;
        goto L31
    L9:
        if ((r108 instanceof p0) == false) goto L13;
        f0 r118 = ((p0) r108).f468837a;
        if ((r118 instanceof b) == false) goto L13;
        r109 = (b) r118;
    L13:
        r109 = null;
    L44:
        return r104;
    }

    public c(NestedMenuScene r100, String r101, LinkedHashMap r102, d0 r103, Integer r104, int r105) {
        if ((r105 & 16) == 0) goto L5;
        r104 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "sectionName");
        Intrinsics.checkNotNullParameter(r102, "sections");
        Intrinsics.checkNotNullParameter(r103, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this.f308240a = r100;
        this.f308241b = r101;
        this.f308242c = r102;
        this.f308243d = r103;
        this.f308244e = r104;
        this.f308245f = null;
        this.f308246g = null;
    }
}
