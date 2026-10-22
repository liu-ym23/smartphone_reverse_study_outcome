package ud3;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lud3/b;", "", "", "accordingProductId", "Ljava/lang/String;", "getAccordingProductId", "()Ljava/lang/String;", "source", "getSource", "type", "getType", "roomId", "getRoomId", "videoId", "getVideoId", "", "imageConstraintsMap", "Ljava/util/Map;", "getImageConstraintsMap", "()Ljava/util/Map;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("according_product_id")
    private final String accordingProductId;

    @SerializedName("image_constraints_map")
    private final Map<String, String> imageConstraintsMap;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("source")
    private final String source;

    @SerializedName("type")
    private final String type;

    @SerializedName("video_id")
    private final String videoId;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L18;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.accordingProductId, r4.accordingProductId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.source, r4.source) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.type, r4.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.roomId, r4.roomId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.videoId, r4.videoId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.imageConstraintsMap, r4.imageConstraintsMap) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r0 = this.accordingProductId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.source;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.type;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.roomId;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.videoId;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Map<String, String> r16 = this.imageConstraintsMap;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorV3PromotionRecommendParam(accordingProductId=" + this.accordingProductId + ", source=" + this.source + ", type=" + this.type + ", roomId=" + this.roomId + ", videoId=" + this.videoId + ", imageConstraintsMap=" + this.imageConstraintsMap + ")";
    }

    public b() {
        this.accordingProductId = null;
        this.source = "";
        this.type = "";
        this.roomId = "";
        this.videoId = "";
        this.imageConstraintsMap = null;
    }

    public final String getType() {
        return this.type;
    }
}
