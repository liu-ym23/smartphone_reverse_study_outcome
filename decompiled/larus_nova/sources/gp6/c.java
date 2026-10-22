package gp6;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f482096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f482097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f482098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f482099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f482100e;

    public c() {
        this(null, null, null, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f482096a, r101.f482096a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f482097b, r101.f482097b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f482098c, r101.f482098c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f482099d, r101.f482099d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f482100e, r101.f482100e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f482096a.hashCode() * 31;
        String r101 = this.f482097b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Map<String, Object> r105 = this.f482098c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Map<String, Object> r108 = this.f482099d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f482100e;
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
        return "CubeTimingInfo(key=" + this.f482096a + ", url=" + this.f482097b + ", metrics=" + this.f482098c + ", category=" + this.f482099d + ", enterFrom=" + this.f482100e + ')';
    }

    public c(String r100, Map r101, Map r102, String r103, int r104) {
        if ((r104 & 1) == 0) goto L5;
        String r105 = "cube_instance_timeline";
    L7:
        if ((r104 & 2) == 0) goto L10;
        r100 = null;
    L10:
        if ((r104 & 4) == 0) goto L13;
        r101 = null;
    L13:
        if ((r104 & 8) == 0) goto L16;
        r102 = null;
    L16:
        if ((r104 & 16) == 0) goto L18;
        r103 = null;
    L18:
        Intrinsics.checkNotNullParameter(r105, "key");
        this.f482096a = r105;
        this.f482097b = r100;
        this.f482098c = r101;
        this.f482099d = r102;
        this.f482100e = r103;
        return;
    L5:
        r105 = null;
        goto L7
    }
}
