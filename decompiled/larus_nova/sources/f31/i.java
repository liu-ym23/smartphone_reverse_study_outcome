package f31;

import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<k> f475339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f475340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.multianchor.dynamic.i f475341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RevSeiFrame f475342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final JSONObject f475343e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f475344f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f475345g;

    public i() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L20;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f475339a, r101.f475339a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f475340b, r101.f475340b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f475341c, r101.f475341c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f475342d, r101.f475342d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f475343e, r101.f475343e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f475344f, r101.f475344f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f475345g, r101.f475345g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        List<k> r100 = this.f475339a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f475340b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.i r107 = this.f475341c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        RevSeiFrame r110 = this.f475342d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        JSONObject r113 = this.f475343e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f475344f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.f475345g;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
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
        return "MultiLayoutStatus(status=" + this.f475339a + ", seiRaw=" + this.f475340b + ", visibleLayoutStatus=" + this.f475341c + ", seiFrame=" + this.f475342d + ", appDataJSONObject=" + this.f475343e + ", realContainerHeight=" + this.f475344f + ", realContainerWidth=" + this.f475345g + ")";
    }

    public i(List r100, String r101, com.bytedance.android.live.revlink.impl.multianchor.dynamic.i r102, RevSeiFrame r103, JSONObject r104, Integer r105, Integer r106, int r110) {
        if ((r110 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r110 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r110 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r110 & 16) == 0) goto L15;
        r104 = null;
    L15:
        if ((r110 & 32) == 0) goto L18;
        r105 = null;
    L18:
        if ((r110 & 64) == 0) goto L20;
        r106 = null;
    L20:
        this.f475339a = r100;
        this.f475340b = r101;
        this.f475341c = r102;
        this.f475342d = r103;
        this.f475343e = r104;
        this.f475344f = r105;
        this.f475345g = r106;
    }
}
