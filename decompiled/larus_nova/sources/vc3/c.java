package vc3;

import com.bytedance.android.shopping.deepfeed.data.DeepFeedQueryParam;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InFeedProductV2 f554094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f554095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DeepFeedQueryParam f554096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f554097d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f554098e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final JSONArray f554099f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f554100g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f554101h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L22;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f554094a, r101.f554094a) == true) goto L8;
        return false;
    L8:
        if (this.f554095b == r101.f554095b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f554096c, r101.f554096c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f554097d, r101.f554097d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f554098e, r101.f554098e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f554099f, r101.f554099f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f554100g, r101.f554100g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f554101h, r101.f554101h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        InFeedProductV2 r100 = this.f554094a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f554095b) * 31;
        DeepFeedQueryParam r104 = this.f554096c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f554097d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f554098e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        JSONArray r113 = this.f554099f;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.f554100g;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f554101h;
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
        return "SlcOpenActionData(cardData=" + this.f554094a + ", cardIndex=" + this.f554095b + ", feedParams=" + this.f554096c + ", sourceBtmToken=" + this.f554097d + ", btm=" + this.f554098e + ", selectSpecIds=" + this.f554099f + ", skuSelectedNum=" + this.f554100g + ", skuSessionId=" + this.f554101h + ")";
    }

    public c(InFeedProductV2 r100, int r101, DeepFeedQueryParam r102, String r103, String r104, JSONArray r105, Long r106, String r107) {
        Intrinsics.checkNotNullParameter(r107, "skuSessionId");
        this.f554094a = r100;
        this.f554095b = r101;
        this.f554096c = r102;
        this.f554097d = r103;
        this.f554098e = r104;
        this.f554099f = r105;
        this.f554100g = r106;
        this.f554101h = r107;
    }
}
