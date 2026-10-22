package fi3;

import com.google.gson.internal.LinkedTreeMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class j0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f477274d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedTreeMap<String, Object> f477275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f477276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedTreeMap<String, Object> f477277c;

    public static final class a {
    }

    static {
    }

    public j0() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j0) == false) goto L12;
        j0 r101 = (j0) r100;
        if (Intrinsics.areEqual(this.f477275a, r101.f477275a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f477276b, r101.f477276b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f477277c, r101.f477277c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        LinkedTreeMap<String, Object> r100 = this.f477275a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f477276b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        LinkedTreeMap<String, Object> r107 = this.f477277c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PdpClickShopEntryParam(businessMeta=" + this.f477275a + ", pendantId=" + this.f477276b + ", trackMeta=" + this.f477277c + ")";
    }

    public j0(LinkedTreeMap<String, Object> r100, String r101, LinkedTreeMap<String, Object> r102) {
        this.f477275a = r100;
        this.f477276b = r101;
        this.f477277c = r102;
    }
}
