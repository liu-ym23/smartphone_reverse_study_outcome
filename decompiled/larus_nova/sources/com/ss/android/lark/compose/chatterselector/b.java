package com.ss.android.lark.compose.chatterselector;

import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f417540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f417541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f417542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f417543d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f417544e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f417545f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f417546g;

    public b() {
        this(null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f417540a, r101.f417540a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f417541b, r101.f417541b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f417542c, r101.f417542c) == true) goto L18;
        return false;
    L18:
        if (this.f417543d == r101.f417543d) goto L21;
        return false;
    L21:
        if (this.f417544e == r101.f417544e) goto L24;
        return false;
    L24:
        if (this.f417545f == r101.f417545f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f417546g, r101.f417546g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f417540a.hashCode() * 31) + this.f417541b.hashCode()) * 31) + this.f417542c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f417543d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f417544e == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f417545f == true) goto L14;
        r101 = 1237;
    L14:
        int r106 = (r105 + r101) * 31;
        String r107 = this.f417546g;
        if (r107 != null) goto L17;
        int r108 = 0;
    L19:
        return r106 + r108;
    L17:
        r108 = r107.hashCode();
        goto L19
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatterSelectorUiState(query=" + this.f417540a + ", members=" + this.f417541b + ", selectedIds=" + this.f417542c + ", loading=" + this.f417543d + ", loadingMore=" + this.f417544e + ", hasMore=" + this.f417545f + ", cursor=" + this.f417546g + ')';
    }

    public /* synthetic */ b(Set r110, int r111) {
        List r100 = null;
        if ((r111 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r111 & 2) == 0) goto L9;
        r100 = CollectionsKt.emptyList();
    L9:
        List r102 = r100;
        if ((r111 & 4) == 0) goto L12;
        r110 = SetsKt.emptySet();
    L12:
        this(r101, r102, r110, false, false, false, null);
        return;
    L5:
        r101 = null;
        goto L7
    }

    public static b a(b r100, String r101, List r110, Set r111, boolean r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        r101 = r100.f417540a;
    L5:
        String r102 = r101;
        if ((r113 & 2) == 0) goto L8;
        r110 = r100.f417541b;
    L8:
        List r103 = r110;
        if ((r113 & 4) == 0) goto L11;
        r111 = r100.f417542c;
    L11:
        Set r104 = r111;
        if ((r113 & 8) == 0) goto L14;
        r112 = r100.f417543d;
    L14:
        boolean r105 = r112;
        if ((r113 & 16) == 0) goto L17;
        boolean r106 = r100.f417544e;
    L19:
        if ((r113 & 32) == 0) goto L21;
        boolean r107 = r100.f417545f;
    L23:
        if ((r113 & 64) == 0) goto L25;
        String r108 = r100.f417546g;
    L26:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "query");
        Intrinsics.checkNotNullParameter(r103, "members");
        Intrinsics.checkNotNullParameter(r104, "selectedIds");
        return new b(r102, r103, r104, r105, r106, r107, r108);
    L25:
        r108 = null;
        goto L26
    L21:
        r107 = false;
        goto L23
    L17:
        r106 = false;
        goto L19
    }

    public b(String r100, List<a> r101, Set<String> r102, boolean r103, boolean r104, boolean r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "query");
        Intrinsics.checkNotNullParameter(r101, "members");
        Intrinsics.checkNotNullParameter(r102, "selectedIds");
        this.f417540a = r100;
        this.f417541b = r101;
        this.f417542c = r102;
        this.f417543d = r103;
        this.f417544e = r104;
        this.f417545f = r105;
        this.f417546g = r106;
    }
}
