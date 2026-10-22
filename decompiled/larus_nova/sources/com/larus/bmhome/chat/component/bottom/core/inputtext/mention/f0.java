package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c1> f298913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c> f298914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<c1> f298915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<c1> f298916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<MentionSearchDomain, d1> f298917e;

    public f0() {
        this(null, null, null, null, 31);
    }

    public static f0 a(List r100, List r101, List r102, List r110, Map r111) {
        Intrinsics.checkNotNullParameter(r100, "drives");
        Intrinsics.checkNotNullParameter(r101, "contacts");
        Intrinsics.checkNotNullParameter(r102, "groups");
        Intrinsics.checkNotNullParameter(r110, "conversations");
        Intrinsics.checkNotNullParameter(r111, "pages");
        return new f0(r100, r101, r102, r110, r111);
    }

    public static /* synthetic */ f0 b(f0 r100, List r101, List r102, List r103, List r104, Map r105, int r106) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.f298913a;
    L6:
        if ((r106 & 2) == 0) goto L9;
        r102 = r100.f298914b;
    L9:
        if ((r106 & 4) == 0) goto L12;
        r103 = r100.f298915c;
    L12:
        if ((r106 & 8) == 0) goto L15;
        r104 = r100.f298916d;
    L15:
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.f298917e;
    L17:
        r100.getClass();
        return a(r101, r102, r103, r104, r105);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r101 = (f0) r100;
        if (Intrinsics.areEqual(this.f298913a, r101.f298913a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f298914b, r101.f298914b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f298915c, r101.f298915c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f298916d, r101.f298916d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f298917e, r101.f298917e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f298913a.hashCode() * 31) + this.f298914b.hashCode()) * 31) + this.f298915c.hashCode()) * 31) + this.f298916d.hashCode()) * 31) + this.f298917e.hashCode();
    }

    public final String toString() {
        return "MentionPanelRemoteData(drives=" + this.f298913a + ", contacts=" + this.f298914b + ", groups=" + this.f298915c + ", conversations=" + this.f298916d + ", pages=" + this.f298917e + ')';
    }

    public /* synthetic */ f0(List r100, List r101, List r102, List r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        r100 = CollectionsKt.emptyList();
    L5:
        List r103 = r100;
        if ((r111 & 2) == 0) goto L8;
        r101 = CollectionsKt.emptyList();
    L8:
        List r104 = r101;
        if ((r111 & 4) == 0) goto L11;
        r102 = CollectionsKt.emptyList();
    L11:
        List r105 = r102;
        if ((r111 & 8) == 0) goto L14;
        r110 = CollectionsKt.emptyList();
    L14:
        List r106 = r110;
        if ((r111 & 16) == 0) goto L17;
        Map r107 = MapsKt.emptyMap();
    L18:
        this(r103, r104, r105, r106, r107);
        return;
    L17:
        r107 = null;
        goto L18
    }

    public f0(List<c1> r100, List<c> r101, List<c1> r102, List<c1> r103, Map<MentionSearchDomain, d1> r104) {
        Intrinsics.checkNotNullParameter(r100, "drives");
        Intrinsics.checkNotNullParameter(r101, "contacts");
        Intrinsics.checkNotNullParameter(r102, "groups");
        Intrinsics.checkNotNullParameter(r103, "conversations");
        Intrinsics.checkNotNullParameter(r104, "pages");
        this.f298913a = r100;
        this.f298914b = r101;
        this.f298915c = r102;
        this.f298916d = r103;
        this.f298917e = r104;
    }
}
