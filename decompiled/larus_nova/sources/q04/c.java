package q04;

import com.bytedance.awemeopen.bizmodels.profile.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f531183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f531184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f531185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f531186d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f531187e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f531188f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f531183a, r101.f531183a) == true) goto L12;
        return false;
    L12:
        if (this.f531184b == r101.f531184b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f531185c, r101.f531185c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f531186d, r101.f531186d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f531187e, r101.f531187e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f531188f, r101.f531188f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    public final int hashCode() {
        i r100 = this.f531183a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f531184b;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f531185c;
        if (r107 != null) goto L12;
        int r108 = 0;
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f531186d;
        if (r110 != null) goto L16;
        int r111 = 0;
    L17:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f531187e;
        if (r113 != null) goto L20;
        int r114 = 0;
    L21:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f531188f;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L20:
        r114 = r113.hashCode();
        goto L21
    L16:
        r111 = r110.hashCode();
        goto L17
    L12:
        r108 = r107.hashCode();
        goto L13
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "UserVerifyInfo(publishRemindInfo=" + this.f531183a + ", isRedV=" + this.f531184b + ", weiboVerifyText=" + this.f531185c + ", enterpriseVerifyText=" + this.f531186d + ", userPersonalText=" + this.f531187e + ", benefitInfo=" + this.f531188f + ')';
    }

    public c(i r100, boolean r101, String r102, String r103, String r104, String r105) {
        this.f531183a = r100;
        this.f531184b = r101;
        this.f531185c = r102;
        this.f531186d = r103;
        this.f531187e = r104;
        this.f531188f = r105;
    }
}
