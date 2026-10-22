package com.larus.bmhome.chat.bubble.floating.network;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\bHÆ\u0003JE\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR&\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/network/BubbleBannerShowReportRequest;", "", "bannerSource", "", "showTime", "", "pushId", "extraParams", "", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/util/Map;)V", "getBannerSource", "()Ljava/lang/String;", "getShowTime", "()J", "getPushId", "getExtraParams", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BubbleBannerShowReportRequest {

    @SerializedName("banner_source")
    private final String bannerSource;

    @SerializedName("extra_params")
    private final Map<String, String> extraParams;

    @SerializedName("push_id")
    private final String pushId;

    @SerializedName("show_time")
    private final long showTime;

    public BubbleBannerShowReportRequest() {
        this(null, 0, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BubbleBannerShowReportRequest copy$default(BubbleBannerShowReportRequest r100, String r101, long r102, String r103, Map r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.bannerSource;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.showTime;
    L8:
        long r106 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.pushId;
    L11:
        String r111 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.extraParams;
    L14:
        String r107 = r101;
        return r100.copy(r107, r106, r111, r104);
    }

    public final String component1() {
        return this.bannerSource;
    }

    public final long component2() {
        return this.showTime;
    }

    public final String component3() {
        return this.pushId;
    }

    public final Map<String, String> component4() {
        return this.extraParams;
    }

    public final BubbleBannerShowReportRequest copy(String r100, long r101, String r110, Map<String, String> r111) {
        return new BubbleBannerShowReportRequest(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BubbleBannerShowReportRequest) == true) goto L8;
        return false;
    L8:
        BubbleBannerShowReportRequest r101 = (BubbleBannerShowReportRequest) r100;
        if (Intrinsics.areEqual(this.bannerSource, r101.bannerSource) == true) goto L12;
        return false;
    L12:
        if (this.showTime == r101.showTime) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.pushId, r101.pushId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extraParams, r101.extraParams) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.bannerSource;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        long r103 = this.showTime;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.pushId;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Map<String, String> r108 = this.extraParams;
        if (r108 == null) goto L15;
        r101 = r108.hashCode();
    L15:
        return r107 + r101;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "BubbleBannerShowReportRequest(bannerSource=" + this.bannerSource + ", showTime=" + this.showTime + ", pushId=" + this.pushId + ", extraParams=" + this.extraParams + ')';
    }

    public final String getBannerSource() {
        return this.bannerSource;
    }

    public final Map<String, String> getExtraParams() {
        return this.extraParams;
    }

    public final String getPushId() {
        return this.pushId;
    }

    public final long getShowTime() {
        return this.showTime;
    }

    public BubbleBannerShowReportRequest(String r100, long r101, String r102, Map<String, String> r103) {
        this.bannerSource = r100;
        this.showTime = r101;
        this.pushId = r102;
        this.extraParams = r103;
    }

    public /* synthetic */ BubbleBannerShowReportRequest(String r100, long r101, String r102, Map r103, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        long r104 = r101;
        if ((r110 & 4) == 0) goto L12;
        String r105 = null;
    L14:
        if ((r110 & 8) == 0) goto L16;
        Map r113 = null;
    L17:
        this(r112, r104, r105, r113);
        return;
    L16:
        r113 = r103;
        goto L17
    L12:
        r105 = r102;
        goto L14
    L5:
        r112 = r100;
        goto L7
    }
}
