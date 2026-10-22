package m93;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R*\u0010\n\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010#\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lm93/f;", "", "", "b", "Ljava/lang/Long;", "getType", "()Ljava/lang/Long;", "type", "", "", "packData", "Ljava/util/Map;", "getPackData", "()Ljava/util/Map;", "Lm93/j;", "impressionData", "Lm93/j;", "getImpressionData", "()Lm93/j;", "Lm93/w;", "packDataV1", "Lm93/w;", "getPackDataV1", "()Lm93/w;", "Lm93/h;", "filterData", "Lm93/h;", "getFilterData", "()Lm93/h;", "Lm93/v;", "packDataCard", "Lm93/v;", "getPackDataCard", "()Lm93/v;", "Lm93/g;", "feedRawData", "Lm93/g;", "getFeedRawData", "()Lm93/g;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {
    public final String a;
    public final Long b;
    public final Long c;

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

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L24;
        f r4 = (f) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.packData, r4.packData) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.impressionData, r4.impressionData) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.packDataV1, r4.packDataV1) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.filterData, r4.filterData) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.packDataCard, r4.packDataCard) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.feedRawData, r4.feedRawData) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Long r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Map<String, Object> r10 = this.packData;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        j r13 = this.impressionData;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        w r16 = this.packDataV1;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        h r19 = this.filterData;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        v r22 = this.packDataCard;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        g r25 = this.feedRawData;
        if (r25 == null) goto L38;
        r1 = r25.hashCode();
    L38:
        return r24 + r1;
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
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
        return "Feed(id=" + this.a + ", type=" + this.b + ", source=" + this.c + ", packData=" + this.packData + ", impressionData=" + this.impressionData + ", packDataV1=" + this.packDataV1 + ", filterData=" + this.filterData + ", packDataCard=" + this.packDataCard + ", feedRawData=" + this.feedRawData + ")";
    }

    public f() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.packData = null;
        this.impressionData = null;
        this.packDataV1 = null;
        this.filterData = null;
        this.packDataCard = null;
        this.feedRawData = null;
    }

    public final Long getType() {
        return this.b;
    }
}
