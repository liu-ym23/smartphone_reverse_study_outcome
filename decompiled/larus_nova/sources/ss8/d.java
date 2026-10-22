package ss8;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f543423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f543424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f543425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f543426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f543427e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Object> f543428f;

    public d() {
        this(false, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f543423a, r101.f543423a) == true) goto L12;
        return false;
    L12:
        if (this.f543424b == r101.f543424b) goto L15;
        return false;
    L15:
        if (this.f543425c == r101.f543425c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f543426d, r101.f543426d) == true) goto L21;
        return false;
    L21:
        if (this.f543427e == r101.f543427e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f543428f, r101.f543428f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f543423a.hashCode() * 31) + this.f543424b) * 31) + this.f543425c) * 31) + this.f543426d.hashCode()) * 31;
        if (this.f543427e == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f543428f.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "FilterContext(chatId=" + this.f543423a + ", chatType=" + this.f543424b + ", chatMode=" + this.f543425c + ", segmentId=" + this.f543426d + ", isLocalPcMode=" + this.f543427e + ", extra=" + this.f543428f + ')';
    }

    public d(boolean r100, Map r101, int r102) {
        String r103 = null;
        if ((r102 & 1) == 0) goto L5;
        String r104 = "";
    L7:
        if ((r102 & 8) == 0) goto L10;
        r103 = "";
    L10:
        if ((r102 & 16) == 0) goto L13;
        r100 = false;
    L13:
        if ((r102 & 32) == 0) goto L15;
        r101 = MapsKt.emptyMap();
    L15:
        Intrinsics.checkNotNullParameter(r104, "chatId");
        Intrinsics.checkNotNullParameter(r103, "segmentId");
        Intrinsics.checkNotNullParameter(r101, "extra");
        this.f543423a = r104;
        this.f543424b = 0;
        this.f543425c = 0;
        this.f543426d = r103;
        this.f543427e = r100;
        this.f543428f = r101;
        return;
    L5:
        r104 = null;
        goto L7
    }
}
