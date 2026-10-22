package r14;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR*\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0011\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0015R\"\u0010/\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0011\u001a\u0004\b0\u0010\u0013\"\u0004\b1\u0010\u0015R$\u00102\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010'\u001a\u0004\b3\u0010)\"\u0004\b4\u0010+R\"\u00105\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0011\u001a\u0004\b6\u0010\u0013\"\u0004\b7\u0010\u0015R$\u00109\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006?"}, d2 = {"Lr14/u;", "Ln14/a;", "", "minCursor", "J", "getMinCursor", "()J", "setMinCursor", "(J)V", "maxCursor", "getMaxCursor", "setMaxCursor", EffectConfiguration.KEY_CURSOR, "getCursor", "setCursor", "", "hasMore", "I", "getHasMore", "()I", "setHasMore", "(I)V", "Lr14/a0;", "logPb", "Lr14/a0;", ce.f26391f, "()Lr14/a0;", "setLogPb", "(Lr14/a0;)V", "", "Lr14/c;", "items", "Ljava/util/List;", "f", "()Ljava/util/List;", RXScreenCaptureService.KEY_INDEX, "(Ljava/util/List;)V", "", "requestId", "Ljava/lang/String;", "getRequestId", "()Ljava/lang/String;", "setRequestId", "(Ljava/lang/String;)V", "refreshClear", "getRefreshClear", "setRefreshClear", "status_code", "h", "setStatus_code", "status_msg", "getStatus_msg", "setStatus_msg", "error_code", "getError_code", "setError_code", "Lr14/v;", "extraInfo", "Lr14/v;", "e", "()Lr14/v;", "setExtraInfo", "(Lr14/v;)V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class u extends n14.a {

    @SerializedName(EffectConfiguration.KEY_CURSOR)
    private long cursor;

    @SerializedName("error_code")
    private int error_code;

    @SerializedName("extra_info")
    private v extraInfo;

    @SerializedName("has_more")
    private int hasMore;

    @SerializedName("aweme_list")
    private List<c> items;

    @SerializedName("log_pb")
    private a0 logPb;

    @SerializedName(alternate = {"max_time"}, value = "max_cursor")
    private long maxCursor;

    @SerializedName(alternate = {"min_time"}, value = "min_cursor")
    private long minCursor;

    @SerializedName("refresh_clear")
    private int refreshClear;

    @SerializedName("rid")
    private String requestId;

    @SerializedName("status_code")
    private int status_code;

    @SerializedName("status_msg")
    private String status_msg;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (this.minCursor == r101.minCursor) goto L12;
        return false;
    L12:
        if (this.maxCursor == r101.maxCursor) goto L15;
        return false;
    L15:
        if (this.cursor == r101.cursor) goto L18;
        return false;
    L18:
        if (this.hasMore == r101.hasMore) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.logPb, r101.logPb) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.items, r101.items) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L30;
        return false;
    L30:
        if (this.refreshClear == r101.refreshClear) goto L33;
        return false;
    L33:
        if (this.status_code == r101.status_code) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.status_msg, r101.status_msg) == true) goto L39;
        return false;
    L39:
        if (this.error_code == r101.error_code) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.extraInfo, r101.extraInfo) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        long r100 = this.minCursor;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.maxCursor;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.cursor;
        int r105 = (((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.hasMore) * 31;
        a0 r106 = this.logPb;
        int r107 = 0;
        if (r106 != null) goto L5;
        int r108 = 0;
    L6:
        int r109 = (r105 + r108) * 31;
        List<c> r110 = this.items;
        if (r110 != null) goto L9;
        int r111 = 0;
    L10:
        int r112 = (r109 + r111) * 31;
        String r113 = this.requestId;
        if (r113 != null) goto L13;
        int r114 = 0;
    L14:
        int r115 = (((((r112 + r114) * 31) + this.refreshClear) * 31) + this.status_code) * 31;
        String r116 = this.status_msg;
        if (r116 != null) goto L17;
        int r117 = 0;
    L18:
        int r118 = (((r115 + r117) * 31) + this.error_code) * 31;
        v r119 = this.extraInfo;
        if (r119 == null) goto L23;
        r107 = r119.hashCode();
    L23:
        return r118 + r107;
    L17:
        r117 = r116.hashCode();
        goto L18
    L13:
        r114 = r113.hashCode();
        goto L14
    L9:
        r111 = r110.hashCode();
        goto L10
    L5:
        r108 = r106.hashCode();
        goto L6
    }

    public final String toString() {
        return "FeedItemList(minCursor=" + this.minCursor + ", maxCursor=" + this.maxCursor + ", cursor=" + this.cursor + ", hasMore=" + this.hasMore + ", logPb=" + this.logPb + ", items=" + this.items + ", requestId=" + this.requestId + ", refreshClear=" + this.refreshClear + ", status_code=" + this.status_code + ", status_msg=" + this.status_msg + ", error_code=" + this.error_code + ", extraInfo=" + this.extraInfo + ')';
    }

    public u() {
        this.minCursor = 0;
        this.maxCursor = 0;
        this.cursor = 0;
        this.hasMore = 0;
        this.logPb = null;
        this.items = null;
        this.requestId = null;
        this.refreshClear = 0;
        this.status_code = 0;
        this.status_msg = null;
        this.error_code = 0;
        this.extraInfo = null;
    }

    public final v e() {
        return this.extraInfo;
    }

    public final List<c> f() {
        return this.items;
    }

    public final a0 g() {
        return this.logPb;
    }

    public final int h() {
        return this.status_code;
    }

    public final void i(List<c> r100) {
        this.items = r100;
    }
}
