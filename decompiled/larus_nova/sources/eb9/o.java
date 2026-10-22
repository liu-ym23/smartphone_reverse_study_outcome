package eb9;

import com.larus.home.impl.main.side_bar.feed.SideBarFeedCardType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class o<DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f471907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Enum<?> f471908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DATA f471909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f471910d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f471911e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f471912f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f471913g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f471914h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f471907a, r101.f471907a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f471908b, r101.f471908b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f471909c, r101.f471909c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f471910d, r101.f471910d) == true) goto L21;
        return false;
    L21:
        if (this.f471911e == r101.f471911e) goto L24;
        return false;
    L24:
        if (this.f471912f == r101.f471912f) goto L27;
        return false;
    L27:
        if (this.f471913g == r101.f471913g) goto L30;
        return false;
    L30:
        if (this.f471914h == r101.f471914h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f471907a.hashCode() * 31) + this.f471908b.hashCode()) * 31) + this.f471909c.hashCode()) * 31;
        n r101 = this.f471910d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f471911e == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        long r106 = this.f471912f;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f471913g;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.f471914h;
        return r109 + ((int) (r110 ^ (r110 >>> 32)));
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowUIFeedCard(id=" + this.f471907a + ", type=" + this.f471908b + ", data=" + this.f471909c + ", selectionKey=" + this.f471910d + ", isSelected=" + this.f471911e + ", updateTime=" + this.f471912f + ", createTime=" + this.f471913g + ", contentVersion=" + this.f471914h + ')';
    }

    public final Enum<?> getType() {
        return this.f471908b;
    }

    public o(String r100, Enum<?> r101, DATA r102, n r103, boolean r104, long r105, long r106, long r110) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "data");
        this.f471907a = r100;
        this.f471908b = r101;
        this.f471909c = r102;
        this.f471910d = r103;
        this.f471911e = r104;
        this.f471912f = r105;
        this.f471913g = r106;
        this.f471914h = r110;
    }

    public /* synthetic */ o(String r110, SideBarFeedCardType r111, Object r112, n r113, boolean r114, long r210, long r211, long r212, int r213) {
        if ((r213 & 8) == 0) goto L5;
        n r100 = null;
    L7:
        if ((r213 & 16) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r213 & 32) == 0) goto L13;
        long r102 = 0;
    L15:
        if ((r213 & 64) == 0) goto L17;
        long r115 = 0;
    L19:
        if ((r213 & 128) == 0) goto L21;
        long r116 = 0;
    L22:
        this(r110, r111, r112, r100, r101, r102, r115, r116);
        return;
    L21:
        r116 = r212;
        goto L22
    L17:
        r115 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
