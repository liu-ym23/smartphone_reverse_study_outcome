package f63;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.matchpurchase.model.CombinationVO;
import com.bytedance.android.shopping.anchorv4.dto.base.Link;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f475689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f475690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<ECUrlModel> f475691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Link f475692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CombinationVO f475693e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ECUrlModel f475694f;

    public a() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L18;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f475689a, r101.f475689a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f475690b, r101.f475690b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f475691c, r101.f475691c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f475692d, r101.f475692d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f475693e, r101.f475693e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f475694f, r101.f475694f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f475689a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f475690b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<ECUrlModel> r107 = this.f475691c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Link r110 = this.f475692d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        CombinationVO r113 = this.f475693e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        ECUrlModel r116 = this.f475694f;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GroupImage(title=" + this.f475689a + ", type=" + this.f475690b + ", images=" + this.f475691c + ", specialLink=" + this.f475692d + ", combinationVO=" + this.f475693e + ", entryIcon=" + this.f475694f + ")";
    }

    public final String getType() {
        return this.f475690b;
    }

    public a(String r100, String r101, List r102, Link r103, CombinationVO r104, ECUrlModel r105, int r106) {
        if ((r106 & 8) == 0) goto L6;
        r103 = null;
    L6:
        if ((r106 & 16) == 0) goto L9;
        r104 = null;
    L9:
        if ((r106 & 32) == 0) goto L11;
        r105 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "images");
        this.f475689a = r100;
        this.f475690b = r101;
        this.f475691c = r102;
        this.f475692d = r103;
        this.f475693e = r104;
        this.f475694f = r105;
    }
}
