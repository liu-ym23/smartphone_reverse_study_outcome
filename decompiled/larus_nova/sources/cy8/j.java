package cy8;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f465847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f465848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f465849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f465850d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f465851e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f465852f;

    public j() {
        this(null, null, null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f465847a, r101.f465847a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f465848b, r101.f465848b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f465849c, r101.f465849c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f465850d, r101.f465850d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f465851e, r101.f465851e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f465852f, r101.f465852f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f465847a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f465848b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f465849c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f465850d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, String> r113 = this.f465851e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.f465852f;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
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
        return "CanvasImageObject(uri=" + this.f465847a + ", url=" + this.f465848b + ", width=" + this.f465849c + ", height=" + this.f465850d + ", urlFormats=" + this.f465851e + ", aiCreationImage=" + this.f465852f + ')';
    }

    public /* synthetic */ j(String r110, String r111, Integer r112, Integer r113, Map r114, int r115) {
        if ((r115 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r115 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r115 & 4) == 0) goto L13;
        Integer r102 = null;
    L15:
        if ((r115 & 8) == 0) goto L17;
        Integer r103 = null;
    L19:
        if ((r115 & 16) == 0) goto L21;
        Map r104 = null;
    L22:
        this(r100, r101, r102, r103, r104, null);
        return;
    L21:
        r104 = r114;
        goto L22
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public j(String r100, String r101, Integer r102, Integer r103, Map<String, String> r104, Boolean r105) {
        this.f465847a = r100;
        this.f465848b = r101;
        this.f465849c = r102;
        this.f465850d = r103;
        this.f465851e = r104;
        this.f465852f = r105;
    }
}
