package m93;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R*\u0010\n\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010#\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lm93/f;", "", "", "b", "Ljava/lang/Long;", "getType", "()Ljava/lang/Long;", "type", "", "", "packData", "Ljava/util/Map;", "getPackData", "()Ljava/util/Map;", "Lm93/j;", "impressionData", "Lm93/j;", "getImpressionData", "()Lm93/j;", "Lm93/w;", "packDataV1", "Lm93/w;", "getPackDataV1", "()Lm93/w;", "Lm93/h;", "filterData", "Lm93/h;", "getFilterData", "()Lm93/h;", "Lm93/v;", "packDataCard", "Lm93/v;", "getPackDataCard", "()Lm93/v;", "Lm93/g;", "feedRawData", "Lm93/g;", "getFeedRawData", "()Lm93/g;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f512605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f512606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f512607c;

    @SerializedName("feed_raw_data")
    private final g feedRawData;

    @SerializedName("filter_data")
    private final h filterData;

    @SerializedName("impression_data")
    private final j impressionData;

    @SerializedName("pack_data")
    private final Map<String, Object> packData;

    @SerializedName("pack_data_card")
    private final v packDataCard;

    @SerializedName("pack_data_v1")
    private final w packDataV1;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L24;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f512605a, r101.f512605a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f512606b, r101.f512606b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f512607c, r101.f512607c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.packData, r101.packData) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.impressionData, r101.impressionData) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.packDataV1, r101.packDataV1) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.filterData, r101.filterData) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.packDataCard, r101.packDataCard) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.feedRawData, r101.feedRawData) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f512605a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f512606b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f512607c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, Object> r110 = this.packData;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        j r113 = this.impressionData;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        w r116 = this.packDataV1;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        h r119 = this.filterData;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        v r122 = this.packDataCard;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        g r125 = this.feedRawData;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        return r124 + r101;
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
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
        return "Feed(id=" + this.f512605a + ", type=" + this.f512606b + ", source=" + this.f512607c + ", packData=" + this.packData + ", impressionData=" + this.impressionData + ", packDataV1=" + this.packDataV1 + ", filterData=" + this.filterData + ", packDataCard=" + this.packDataCard + ", feedRawData=" + this.feedRawData + ")";
    }

    public f() {
        this.f512605a = null;
        this.f512606b = null;
        this.f512607c = null;
        this.packData = null;
        this.impressionData = null;
        this.packDataV1 = null;
        this.filterData = null;
        this.packDataCard = null;
        this.feedRawData = null;
    }

    public final Long getType() {
        return this.f512606b;
    }
}
