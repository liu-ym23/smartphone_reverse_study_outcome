package lk2;

import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.model.response.CarouselDetailInfo;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements QModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f509548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<CarouselDetailInfo> f509549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f509550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f509551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f509552e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f509553f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LiveRoomParams f509554g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L20;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f509548a, r101.f509548a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f509549b, r101.f509549b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f509550c, r101.f509550c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f509551d, r101.f509551d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f509552e, r101.f509552e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f509553f, r101.f509553f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f509554g, r101.f509554g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.f509548a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<CarouselDetailInfo> r104 = this.f509549b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f509550c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f509551d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f509552e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f509553f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        LiveRoomParams r119 = this.f509554g;
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

    @Override // com.ss.android.ugc.aweme.kiwi.model.QModel
    public final int modelType() {
        return 0;
    }

    public final String toString() {
        return "ECFloatWindowCarouseModel(status=" + this.f509548a + ", detailInfos=" + this.f509549b + ", carouselInterval=" + this.f509550c + ", productId=" + this.f509551d + ", promotionId=" + this.f509552e + ", eventItemType=" + this.f509553f + ", liveRoomParams=" + this.f509554g + ")";
    }

    public a(Integer r100, List<CarouselDetailInfo> r101, Long r102, String r103, String r104, String r105, LiveRoomParams r106) {
        Intrinsics.checkNotNullParameter(r101, "detailInfos");
        this.f509548a = r100;
        this.f509549b = r101;
        this.f509550c = r102;
        this.f509551d = r103;
        this.f509552e = r104;
        this.f509553f = r105;
        this.f509554g = r106;
    }
}
