package com.obric.assistant.settings;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObricAppListMode f392013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f392014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f392015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f392016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f392017e;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f392013a == r101.f392013a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f392014b, r101.f392014b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f392015c, r101.f392015c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f392016d, r101.f392016d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f392017e, r101.f392017e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f392013a.hashCode() * 31) + this.f392014b.hashCode()) * 31) + this.f392015c.hashCode()) * 31) + this.f392016d.hashCode()) * 31) + this.f392017e.hashCode();
    }

    public final String toString() {
        return "AutoActionAppFilterPolicy(mode=" + this.f392013a + ", blacklistNames=" + this.f392014b + ", whitelistNames=" + this.f392015c + ", saepRestrictedAppNames=" + this.f392016d + ", saepDeclaredAppNames=" + this.f392017e + ')';
    }

    public /* synthetic */ d(int r100) {
        this(ObricAppListMode.BLACK_LIST, SetsKt.emptySet(), SetsKt.emptySet(), SetsKt.emptySet(), SetsKt.emptySet());
    }

    public d(ObricAppListMode r100, Set<String> r101, Set<String> r102, Set<String> r103, Set<String> r104) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r101, "blacklistNames");
        Intrinsics.checkNotNullParameter(r102, "whitelistNames");
        Intrinsics.checkNotNullParameter(r103, "saepRestrictedAppNames");
        Intrinsics.checkNotNullParameter(r104, "saepDeclaredAppNames");
        this.f392013a = r100;
        this.f392014b = r101;
        this.f392015c = r102;
        this.f392016d = r103;
        this.f392017e = r104;
    }
}
