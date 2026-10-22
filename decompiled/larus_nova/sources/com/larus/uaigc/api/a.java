package com.larus.uaigc.api;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010.\u001a\u0004\u0018\u00010\u0011HÆ\u0003J~\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0005HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00066"}, d2 = {"Lcom/larus/uaigc/api/AiReplicaInfoData;", "", "iconUrl", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "", "createTimeSec", "", "iconUri", "preGenImages", "", "Lcom/larus/uaigc/avatar/api/PreGenImage;", "quotaData", "Lcom/larus/uaigc/api/AiReplicaTrainQuotaData;", "digitalAvatarId", "masterIdx", "refVideo", "Lcom/larus/uaigc/avatar/api/AiReplicaRefVideo;", "<init>", "(Ljava/lang/String;ILjava/lang/Long;Ljava/lang/String;Ljava/util/List;Lcom/larus/uaigc/api/AiReplicaTrainQuotaData;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/uaigc/avatar/api/AiReplicaRefVideo;)V", "getIconUrl", "()Ljava/lang/String;", "getModel", "()I", "getCreateTimeSec", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getIconUri", "getPreGenImages", "()Ljava/util/List;", "getQuotaData", "()Lcom/larus/uaigc/api/AiReplicaTrainQuotaData;", "getDigitalAvatarId", "getMasterIdx", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRefVideo", "()Lcom/larus/uaigc/avatar/api/AiReplicaRefVideo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;ILjava/lang/Long;Ljava/lang/String;Ljava/util/List;Lcom/larus/uaigc/api/AiReplicaTrainQuotaData;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/uaigc/avatar/api/AiReplicaRefVideo;)Lcom/larus/uaigc/api/AiReplicaInfoData;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("create_time_sec")
    private final Long createTimeSec;

    @SerializedName("id")
    private final String digitalAvatarId;

    @SerializedName("icon_uri")
    private final String iconUri;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("master_idx")
    private final Integer masterIdx;

    @SerializedName(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL)
    private final int model;

    @SerializedName("pre_gen_images")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<ey9.k> preGenImages;

    @SerializedName("quota_data")
    private final b quotaData;

    @SerializedName("ref_video")
    private final ey9.a refVideo;

    public a() {
        this.iconUrl = null;
        this.model = 0;
        this.createTimeSec = null;
        this.iconUri = null;
        this.preGenImages = null;
        this.quotaData = null;
        this.digitalAvatarId = null;
        this.masterIdx = -1;
        this.refVideo = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L12;
        return false;
    L12:
        if (this.model == r101.model) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.createTimeSec, r101.createTimeSec) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.iconUri, r101.iconUri) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.preGenImages, r101.preGenImages) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.quotaData, r101.quotaData) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.digitalAvatarId, r101.digitalAvatarId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.masterIdx, r101.masterIdx) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.refVideo, r101.refVideo) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.iconUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.model) * 31;
        Long r104 = this.createTimeSec;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.iconUri;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<ey9.k> r110 = this.preGenImages;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        b r113 = this.quotaData;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.digitalAvatarId;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.masterIdx;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        ey9.a r122 = this.refVideo;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AiReplicaInfoData(iconUrl=" + this.iconUrl + ", model=" + this.model + ", createTimeSec=" + this.createTimeSec + ", iconUri=" + this.iconUri + ", preGenImages=" + this.preGenImages + ", quotaData=" + this.quotaData + ", digitalAvatarId=" + this.digitalAvatarId + ", masterIdx=" + this.masterIdx + ", refVideo=" + this.refVideo + ')';
    }

    public final Long a() {
        return this.createTimeSec;
    }

    public final String b() {
        return this.digitalAvatarId;
    }

    public final String c() {
        return this.iconUri;
    }

    public final String d() {
        return this.iconUrl;
    }

    public final Integer e() {
        return this.masterIdx;
    }

    public final int f() {
        return this.model;
    }

    public final List<ey9.k> g() {
        return this.preGenImages;
    }

    public final b h() {
        return this.quotaData;
    }

    public final ey9.a i() {
        return this.refVideo;
    }
}
