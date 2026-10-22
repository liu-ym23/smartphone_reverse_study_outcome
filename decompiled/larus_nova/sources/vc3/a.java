package vc3;

import com.bytedance.android.shopping.deepfeed.data.DeepFeedQueryParam;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f554086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f554087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f554088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InFeedProductV2 f554089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f554090e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DeepFeedQueryParam f554091f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final JSONObject f554092g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L20;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f554086a, r101.f554086a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f554087b, r101.f554087b) == true) goto L10;
        return false;
    L10:
        if (this.f554088c == r101.f554088c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f554089d, r101.f554089d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f554090e, r101.f554090e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f554091f, r101.f554091f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f554092g, r101.f554092g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        Map<String, Object> r100 = this.f554086a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f554087b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.f554088c) * 31;
        InFeedProductV2 r107 = this.f554089d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.f554090e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        DeepFeedQueryParam r113 = this.f554091f;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        JSONObject r116 = this.f554092g;
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
        return "ReportActionData(params=" + this.f554086a + ", areaBtm=" + this.f554087b + ", cardIndex=" + this.f554088c + ", data=" + this.f554089d + ", tagList=" + this.f554090e + ", queryParams=" + this.f554091f + ", entranceInfo=" + this.f554092g + ")";
    }

    public a(Map<String, Object> r100, String r101, int r102, InFeedProductV2 r103, List<String> r104, DeepFeedQueryParam r105, JSONObject r106) {
        this.f554086a = r100;
        this.f554087b = r101;
        this.f554088c = r102;
        this.f554089d = r103;
        this.f554090e = r104;
        this.f554091f = r105;
        this.f554092g = r106;
    }
}
