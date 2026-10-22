package cq8;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f464816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f464817e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f464818f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f464814b, r101.f464814b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464815c, r101.f464815c) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f464816d, r101.f464816d) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f464817e, r101.f464817e) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f464818f, r101.f464818f) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f464814b.hashCode() * 31;
        String r101 = this.f464815c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f464816d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.f464817e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Map<String, String> r111 = this.f464818f;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ButtonRouterSelectAction(widgetId=" + this.f464814b + ", selectedId=" + this.f464815c + ", selectedName=" + this.f464816d + ", showPosition=" + this.f464817e + ", extra=" + this.f464818f + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.f464814b;
    }

    public d(String r100, String r101, String r102, Integer r103, Map<String, String> r104) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        super("ButtonRouterSelectAction");
        this.f464814b = r100;
        this.f464815c = r101;
        this.f464816d = r102;
        this.f464817e = r103;
        this.f464818f = r104;
    }
}
