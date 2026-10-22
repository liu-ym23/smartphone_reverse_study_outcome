package pf9;

import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f528874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f528875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f528876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f528877d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f528878e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f528879f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f528880g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f528874a, r101.f528874a) == true) goto L12;
        return false;
    L12:
        if (this.f528875b == r101.f528875b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f528876c, r101.f528876c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f528877d, r101.f528877d) == true) goto L21;
        return false;
    L21:
        if (Float.compare(this.f528878e, r101.f528878e) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.f528879f, r101.f528879f) == 0) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f528880g, r101.f528880g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f528874a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        if (this.f528875b == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        String r106 = this.f528876c;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        Map<String, String> r109 = this.f528877d;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (((((r108 + r110) * 31) + Float.floatToIntBits(this.f528878e)) * 31) + Float.floatToIntBits(this.f528879f)) * 31;
        String r112 = this.f528880g;
        if (r112 == null) goto L23;
        r101 = r112.hashCode();
    L23:
        return r111 + r101;
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AsrResult(text=" + this.f528874a + ", isInterim=" + this.f528875b + ", asrTaskID=" + this.f528876c + ", extra=" + this.f528877d + ", startTime=" + this.f528878e + ", endTime=" + this.f528879f + ", logId=" + this.f528880g + ')';
    }

    public a(String r100, boolean r110, String r111, Map<String, String> r112) {
        LinkedHashMap<String, Boolean> r101 = i.f528921a;
        String r102 = r112.get(CronetDataStorageAccess.LOGID);
        if (r102 != null) goto L5;
    L7:
        r102 = null;
    L8:
        this(r100, r110, r111, r112, 0.0f, 0.0f, r102);
        return;
    L5:
        if ((!StringsKt.isBlank(r102)) == false) goto L7;
        goto L7
    }

    public a(String r100, boolean r101, String r102, Map<String, String> r103, float r104, float r105, String r106) {
        this.f528874a = r100;
        this.f528875b = r101;
        this.f528876c = r102;
        this.f528877d = r103;
        this.f528878e = r104;
        this.f528879f = r105;
        this.f528880g = r106;
    }
}
