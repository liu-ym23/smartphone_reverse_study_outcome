package v63;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionReceiveAddrStruct;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PromotionReceiveAddrStruct f553391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECUrlModel f553392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f553393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ECUrlModel f553394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f553395e;

    public c() {
        this(null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L16;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f553391a, r101.f553391a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f553392b, r101.f553392b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f553393c, r101.f553393c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f553394d, r101.f553394d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f553395e, r101.f553395e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        PromotionReceiveAddrStruct r100 = this.f553391a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECUrlModel r104 = this.f553392b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f553393c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ECUrlModel r110 = this.f553394d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f553395e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "ProductAddressInfo(receiveAddressInfo=" + this.f553391a + ", arriveIcon=" + this.f553392b + ", arriveTime=" + this.f553393c + ", presaleIcon=" + this.f553394d + ", middleText=" + this.f553395e + ")";
    }

    public c(PromotionReceiveAddrStruct r100, ECUrlModel r101, Integer r102, ECUrlModel r103, String r104) {
        this.f553391a = r100;
        this.f553392b = r101;
        this.f553393c = r102;
        this.f553394d = r103;
        this.f553395e = r104;
    }
}
