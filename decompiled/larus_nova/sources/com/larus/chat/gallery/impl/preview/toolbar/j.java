package com.larus.chat.gallery.impl.preview.toolbar;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ToolbarButtonType f324804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f324805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f324806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f324807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f324808e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f324809f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f324810g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f324811h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, Object> f324812i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f324804a == r101.f324804a) goto L12;
        return false;
    L12:
        if (this.f324805b == r101.f324805b) goto L15;
        return false;
    L15:
        if (this.f324806c == r101.f324806c) goto L18;
        return false;
    L18:
        if (this.f324807d == r101.f324807d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f324808e, r101.f324808e) == true) goto L24;
        return false;
    L24:
        if (this.f324809f == r101.f324809f) goto L27;
        return false;
    L27:
        if (this.f324810g == r101.f324810g) goto L30;
        return false;
    L30:
        if (this.f324811h == r101.f324811h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f324812i, r101.f324812i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f324804a.hashCode() * 31) + this.f324805b) * 31) + this.f324806c) * 31) + this.f324807d) * 31;
        String r101 = this.f324808e;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        int r104 = 1231;
        if (this.f324809f == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f324810g == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.f324811h == true) goto L19;
        r104 = 1237;
    L19:
        return ((r108 + r104) * 31) + this.f324812i.hashCode();
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ToolbarButtonItem(type=" + this.f324804a + ", iconRes=" + this.f324805b + ", overflowIconRes=" + this.f324806c + ", textRes=" + this.f324807d + ", textHardcode=" + this.f324808e + ", visible=" + this.f324809f + ", enabled=" + this.f324810g + ", overflow=" + this.f324811h + ", statePayload=" + this.f324812i + ')';
    }

    public final ToolbarButtonType getType() {
        return this.f324804a;
    }

    public /* synthetic */ j(ToolbarButtonType r110, int r111, int r112, int r113, String r114, boolean r115, int r210) {
        if ((r210 & 4) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r210 & 16) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r210 & 64) == 0) goto L13;
        boolean r116 = true;
    L15:
        if ((r210 & 128) == 0) goto L17;
        boolean r117 = false;
    L19:
        if ((r210 & 256) == 0) goto L21;
        Map r118 = MapsKt.emptyMap();
    L22:
        this(r110, r111, r100, r113, r101, true, r116, r117, r118);
        return;
    L21:
        r118 = null;
        goto L22
    L17:
        r117 = r115;
        goto L19
    L13:
        r116 = false;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }

    public static j a(j r110, int r111, int r112, int r113, boolean r114, boolean r115, Map r210, int r211) {
        String r100 = null;
        if ((r211 & 1) == 0) goto L5;
        ToolbarButtonType r101 = r110.f324804a;
    L7:
        if ((r211 & 2) == 0) goto L9;
        int r102 = r110.f324805b;
    L11:
        if ((r211 & 4) == 0) goto L13;
        int r103 = r110.f324806c;
    L15:
        if ((r211 & 8) == 0) goto L17;
        int r104 = r110.f324807d;
    L19:
        if ((r211 & 16) == 0) goto L21;
        r100 = r110.f324808e;
    L21:
        String r105 = r100;
        if ((r211 & 32) == 0) goto L24;
        boolean r116 = r110.f324809f;
    L26:
        if ((r211 & 64) == 0) goto L28;
        boolean r117 = r110.f324810g;
    L30:
        if ((r211 & 128) == 0) goto L32;
        boolean r118 = r110.f324811h;
    L34:
        if ((r211 & 256) == 0) goto L36;
        Map r119 = r110.f324812i;
    L37:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r119, "statePayload");
        return new j(r101, r102, r103, r104, r105, r116, r117, r118, r119);
    L36:
        r119 = r210;
        goto L37
    L32:
        r118 = r115;
        goto L34
    L28:
        r117 = false;
        goto L30
    L24:
        r116 = r114;
        goto L26
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

    public j(ToolbarButtonType r100, int r101, int r102, int r103, String r104, boolean r105, boolean r106, boolean r107, Map<String, ? extends Object> r110) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r110, "statePayload");
        this.f324804a = r100;
        this.f324805b = r101;
        this.f324806c = r102;
        this.f324807d = r103;
        this.f324808e = r104;
        this.f324809f = r105;
        this.f324810g = r106;
        this.f324811h = r107;
        this.f324812i = r110;
    }
}
