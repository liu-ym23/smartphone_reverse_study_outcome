package ifa;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class e implements t1a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f489676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f489677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<String> f489678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f489679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f489680e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f489681f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f489682g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f489683h;

    public e() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f489676a, r101.f489676a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f489677b, r101.f489677b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f489678c, r101.f489678c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f489679d, r101.f489679d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f489680e, r101.f489680e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f489681f, r101.f489681f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f489682g, r101.f489682g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f489683h, r101.f489683h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f489676a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f489677b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.f489678c.hashCode()) * 31;
        String r107 = this.f489679d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f489680e;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f489681f;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f489682g;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f489683h;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "OmniDetailParam(title=" + this.f489676a + ", summary=" + this.f489677b + ", additionTips=" + this.f489678c + ", resourceId=" + this.f489679d + ", messageId=" + this.f489680e + ", botId=" + this.f489681f + ", enterMethod=" + this.f489682g + ", instructionType=" + this.f489683h + ')';
    }

    public e(Object r100) {
        List<String> r101 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r101, "additionTips");
        this.f489676a = null;
        this.f489677b = null;
        this.f489678c = r101;
        this.f489679d = null;
        this.f489680e = null;
        this.f489681f = null;
        this.f489682g = null;
        this.f489683h = null;
    }
}
