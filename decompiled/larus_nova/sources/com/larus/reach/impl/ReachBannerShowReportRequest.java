package com.larus.reach.impl;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\tHÆ\u0003JQ\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR&\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/larus/reach/impl/ReachBannerShowReportRequest;", "", "bannerScene", "", "showTime", "", "bannerSource", "pushId", "extraParams", "", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getBannerScene", "()Ljava/lang/String;", "getShowTime", "()J", "getBannerSource", "getPushId", "getExtraParams", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReachBannerShowReportRequest {

    @SerializedName("banner_scene")
    private final String bannerScene;

    @SerializedName("banner_source")
    private final String bannerSource;

    @SerializedName("extra_params")
    private final Map<String, String> extraParams;

    @SerializedName("push_id")
    private final String pushId;

    @SerializedName("show_time")
    private final long showTime;

    public ReachBannerShowReportRequest() {
        this(null, 0, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReachBannerShowReportRequest copy$default(ReachBannerShowReportRequest r100, String r101, long r102, String r103, String r104, Map r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.bannerScene;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.showTime;
    L8:
        long r105 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.bannerSource;
    L11:
        String r113 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.pushId;
    L14:
        String r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.extraParams;
    L17:
        String r107 = r101;
        return r100.copy(r107, r105, r113, r106, r110);
    }

    public final String component1() {
        return this.bannerScene;
    }

    public final long component2() {
        return this.showTime;
    }

    public final String component3() {
        return this.bannerSource;
    }

    public final String component4() {
        return this.pushId;
    }

    public final Map<String, String> component5() {
        return this.extraParams;
    }

    public final ReachBannerShowReportRequest copy(String r100, long r110, String r111, String r112, Map<String, String> r113) {
        return new ReachBannerShowReportRequest(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ReachBannerShowReportRequest) == true) goto L8;
        return false;
    L8:
        ReachBannerShowReportRequest r101 = (ReachBannerShowReportRequest) r100;
        if (Intrinsics.areEqual(this.bannerScene, r101.bannerScene) == true) goto L12;
        return false;
    L12:
        if (this.showTime == r101.showTime) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bannerSource, r101.bannerSource) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.pushId, r101.pushId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.extraParams, r101.extraParams) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.bannerScene;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        long r103 = this.showTime;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.bannerSource;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.pushId;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Map<String, String> r111 = this.extraParams;
        if (r111 == null) goto L19;
        r101 = r111.hashCode();
    L19:
        return r110 + r101;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ReachBannerShowReportRequest(bannerScene=" + this.bannerScene + ", showTime=" + this.showTime + ", bannerSource=" + this.bannerSource + ", pushId=" + this.pushId + ", extraParams=" + this.extraParams + ')';
    }

    public final String getBannerScene() {
        return this.bannerScene;
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

    public ReachBannerShowReportRequest(String r100, long r101, String r102, String r103, Map<String, String> r104) {
        this.bannerScene = r100;
        this.showTime = r101;
        this.bannerSource = r102;
        this.pushId = r103;
        this.extraParams = r104;
    }

    public /* synthetic */ ReachBannerShowReportRequest(String r100, long r101, String r102, String r110, Map r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        long r103 = r101;
        if ((r112 & 4) == 0) goto L12;
        String r104 = null;
    L14:
        if ((r112 & 8) == 0) goto L16;
        String r105 = null;
    L18:
        if ((r112 & 16) == 0) goto L20;
        Map r115 = null;
    L21:
        this(r114, r103, r104, r105, r115);
        return;
    L20:
        r115 = r111;
        goto L21
    L16:
        r105 = r110;
        goto L18
    L12:
        r104 = r102;
        goto L14
    L5:
        r114 = r100;
        goto L7
    }
}
