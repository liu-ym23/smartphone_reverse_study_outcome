package aa3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0010R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Laa3/b;", "", "", "productMaxFilters", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "liveMaxFilters", "c", "productFiltersTimestamp", "d", "liveFiltersTimestamp", "b", "", "activeRefreshEnable", "Ljava/lang/Boolean;", "a", "()Ljava/lang/Boolean;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("active_refresh_enable")
    private final Boolean activeRefreshEnable;

    @SerializedName("live_filters_timestamp")
    private final Integer liveFiltersTimestamp;

    @SerializedName("live_max_filters")
    private final Integer liveMaxFilters;

    @SerializedName("product_filters_timestamp")
    private final Integer productFiltersTimestamp;

    @SerializedName("product_max_filters")
    private final Integer productMaxFilters;

    public static final class a {
    }

    static {
    }

    public b() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L16;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.productMaxFilters, r4.productMaxFilters) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.liveMaxFilters, r4.liveMaxFilters) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.productFiltersTimestamp, r4.productFiltersTimestamp) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.liveFiltersTimestamp, r4.liveFiltersTimestamp) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.activeRefreshEnable, r4.activeRefreshEnable) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.productMaxFilters;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.liveMaxFilters;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.productFiltersTimestamp;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.liveFiltersTimestamp;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.activeRefreshEnable;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
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
        return "MallFeedImpressionConfig(productMaxFilters=" + this.productMaxFilters + ", liveMaxFilters=" + this.liveMaxFilters + ", productFiltersTimestamp=" + this.productFiltersTimestamp + ", liveFiltersTimestamp=" + this.liveFiltersTimestamp + ", activeRefreshEnable=" + this.activeRefreshEnable + ")";
    }

    public final Boolean a() {
        return this.activeRefreshEnable;
    }

    public final Integer b() {
        return this.liveFiltersTimestamp;
    }

    public final Integer c() {
        return this.liveMaxFilters;
    }

    public final Integer d() {
        return this.productFiltersTimestamp;
    }

    public final Integer e() {
        return this.productMaxFilters;
    }

    public b(int r1) {
        this.productMaxFilters = null;
        this.liveMaxFilters = null;
        this.productFiltersTimestamp = null;
        this.liveFiltersTimestamp = null;
        this.activeRefreshEnable = null;
    }
}
