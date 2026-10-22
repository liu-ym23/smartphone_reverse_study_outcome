package jq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f500077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f500078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f500079c;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f500077a == r101.f500077a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f500078b, r101.f500078b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f500079c, r101.f500079c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f500077a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f500078b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f500079c;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "ActionBarConnectorConfig(acbConnectorEnable=" + this.f500077a + ", acbAddConnectorSchema=" + this.f500078b + ", acbConnectorLinkSchema=" + this.f500079c + ')';
    }

    public /* synthetic */ a(int r100) {
        this(true, "", "");
    }

    public a(boolean r100, String r101, String r102) {
        this.f500077a = r100;
        this.f500078b = r101;
        this.f500079c = r102;
    }
}
