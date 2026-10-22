package com.obric.assistant.cocreationreview;

import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f387183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Vote f387184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f387185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f387186d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f387187e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f387188f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<b5> f387189g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f387190h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a5) == true) goto L8;
        return false;
    L8:
        a5 r101 = (a5) r100;
        if (Intrinsics.areEqual(this.f387183a, r101.f387183a) == true) goto L12;
        return false;
    L12:
        if (this.f387184b == r101.f387184b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f387185c, r101.f387185c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f387186d, r101.f387186d) == true) goto L21;
        return false;
    L21:
        if (this.f387187e == r101.f387187e) goto L24;
        return false;
    L24:
        if (this.f387188f == r101.f387188f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f387189g, r101.f387189g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f387190h, r101.f387190h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f387183a.hashCode() * 31;
        Vote r101 = this.f387184b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((((r100 + r103) * 31) + this.f387185c.hashCode()) * 31) + this.f387186d.hashCode()) * 31;
        if (this.f387187e == false) goto L9;
        int r105 = 1231;
    L10:
        long r106 = this.f387188f;
        int r107 = (((((r104 + r105) * 31) + ((int) (r106 ^ (r106 >>> 32)))) * 31) + this.f387189g.hashCode()) * 31;
        Integer r108 = this.f387190h;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "Feedback(recordId=" + this.f387183a + ", vote=" + this.f387184b + ", reasons=" + this.f387185c + ", comment=" + this.f387186d + ", completed=" + this.f387187e + ", createdAt=" + this.f387188f + ", media=" + this.f387189g + ", feedbackValue=" + this.f387190h + ')';
    }

    public final boolean b() {
        if (this.f387184b != null) goto L5;
    L7:
        return false;
    L5:
        if ((!this.f387185c.isEmpty()) == false) goto L7;
        return true;
    }

    public /* synthetic */ a5(String r110, Vote r111, Set r112, String r113, boolean r114, long r115, Integer r210, int r211) {
        if ((r211 & 2) == 0) goto L5;
        Vote r100 = null;
    L7:
        if ((r211 & 4) == 0) goto L9;
        Set r101 = SetsKt.emptySet();
    L11:
        if ((r211 & 8) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r211 & 16) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r211 & 32) == 0) goto L21;
        long r104 = 0;
    L23:
        if ((r211 & 64) == 0) goto L25;
        List r116 = CollectionsKt.emptyList();
    L27:
        if ((r211 & 128) == 0) goto L29;
        Integer r117 = null;
    L30:
        this(r110, r100, r101, r102, r103, r104, r116, r117);
        return;
    L29:
        r117 = r210;
        goto L30
    L25:
        r116 = null;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public static a5 a(a5 r110, Vote r111, Set r112, String r113, boolean r114, long r115, Integer r210, int r211) {
        List<b5> r100 = null;
        if ((r211 & 1) == 0) goto L5;
        String r101 = r110.f387183a;
    L7:
        if ((r211 & 2) == 0) goto L9;
        Vote r102 = r110.f387184b;
    L11:
        if ((r211 & 4) == 0) goto L13;
        Set r103 = r110.f387185c;
    L15:
        if ((r211 & 8) == 0) goto L17;
        String r104 = r110.f387186d;
    L19:
        if ((r211 & 16) == 0) goto L21;
        boolean r105 = r110.f387187e;
    L23:
        if ((r211 & 32) == 0) goto L25;
        long r116 = r110.f387188f;
    L27:
        if ((r211 & 64) == 0) goto L29;
        r100 = r110.f387189g;
    L29:
        List<b5> r117 = r100;
        if ((r211 & 128) == 0) goto L32;
        Integer r118 = r110.f387190h;
    L33:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "recordId");
        Intrinsics.checkNotNullParameter(r103, "reasons");
        Intrinsics.checkNotNullParameter(r104, "comment");
        Intrinsics.checkNotNullParameter(r117, "media");
        return new a5(r101, r102, r103, r104, r105, r116, r117, r118);
    L32:
        r118 = r210;
        goto L33
    L25:
        r116 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public a5(String r100, Vote r101, Set<String> r102, String r103, boolean r104, long r105, List<b5> r106, Integer r110) {
        Intrinsics.checkNotNullParameter(r100, "recordId");
        Intrinsics.checkNotNullParameter(r102, "reasons");
        Intrinsics.checkNotNullParameter(r103, "comment");
        Intrinsics.checkNotNullParameter(r106, "media");
        this.f387183a = r100;
        this.f387184b = r101;
        this.f387185c = r102;
        this.f387186d = r103;
        this.f387187e = r104;
        this.f387188f = r105;
        this.f387189g = r106;
        this.f387190h = r110;
    }
}
