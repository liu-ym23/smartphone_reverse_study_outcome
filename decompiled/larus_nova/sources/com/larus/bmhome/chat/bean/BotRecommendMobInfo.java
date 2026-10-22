package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ixigua.lib.track.TrackParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u001bJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010$\u001a\u00020%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020%HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020%R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\r\"\u0004\b\u0012\u0010\u000fR \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000f¨\u00061"}, d2 = {"Lcom/larus/bmhome/chat/bean/BotRecommendMobInfo;", "Landroid/os/Parcelable;", "botId", "", "isCertificationLabel", "certificationLabelType", "labelList", "isCapabilityLabel", "capabilityLabelCnt", "discoverPageTabId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBotId", "()Ljava/lang/String;", "setBotId", "(Ljava/lang/String;)V", "getCertificationLabelType", "getLabelList", "setCapabilityLabel", "getCapabilityLabelCnt", "setCapabilityLabelCnt", "getDiscoverPageTabId", "setDiscoverPageTabId", "fillParams", "Lorg/json/JSONObject;", "src", "fillTrackParams", "Lcom/ixigua/lib/track/TrackParams;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotRecommendMobInfo implements Parcelable {
    public static final Parcelable.Creator<BotRecommendMobInfo> CREATOR = null;

    @SerializedName("bot_id")
    private String botId;

    @SerializedName("capability_label_cnt")
    private String capabilityLabelCnt;

    @SerializedName("certification_label_type")
    private final String certificationLabelType;

    @SerializedName("discover_page_tab_id")
    private String discoverPageTabId;

    @SerializedName("is_capability_label")
    private String isCapabilityLabel;

    @SerializedName("is_certification_label")
    private final String isCertificationLabel;

    @SerializedName("label_list")
    private final String labelList;

    public static final class a implements Parcelable.Creator<BotRecommendMobInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BotRecommendMobInfo createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            return new BotRecommendMobInfo(r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final BotRecommendMobInfo[] newArray(int r100) {
            return new BotRecommendMobInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public BotRecommendMobInfo() {
        this(null, null, null, null, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BotRecommendMobInfo) == true) goto L8;
        return false;
    L8:
        BotRecommendMobInfo r101 = (BotRecommendMobInfo) r100;
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isCertificationLabel, r101.isCertificationLabel) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.certificationLabelType, r101.certificationLabelType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.labelList, r101.labelList) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.isCapabilityLabel, r101.isCapabilityLabel) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.capabilityLabelCnt, r101.capabilityLabelCnt) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.discoverPageTabId, r101.discoverPageTabId) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.botId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.isCertificationLabel;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.certificationLabelType;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.labelList;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.isCapabilityLabel;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.capabilityLabelCnt;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.discoverPageTabId;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
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
        return "BotRecommendMobInfo(botId=" + this.botId + ", isCertificationLabel=" + this.isCertificationLabel + ", certificationLabelType=" + this.certificationLabelType + ", labelList=" + this.labelList + ", isCapabilityLabel=" + this.isCapabilityLabel + ", capabilityLabelCnt=" + this.capabilityLabelCnt + ", discoverPageTabId=" + this.discoverPageTabId + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.botId);
        r100.writeString(this.isCertificationLabel);
        r100.writeString(this.certificationLabelType);
        r100.writeString(this.labelList);
        r100.writeString(this.isCapabilityLabel);
        r100.writeString(this.capabilityLabelCnt);
        r100.writeString(this.discoverPageTabId);
    }

    public final JSONObject a(JSONObject r100) {
        if (r100 != null) goto L4;
        r100 = new JSONObject();
    L4:
        r100.put("bot_id", this.botId);
        r100.put("is_certification_label", this.isCertificationLabel);
        r100.put("certification_label_type", this.certificationLabelType);
        r100.put("label_list", this.labelList);
        r100.put("is_capability_label", this.isCapabilityLabel);
        r100.put("capability_label_cnt", this.capabilityLabelCnt);
        r100.put("discover_page_tab_id", this.discoverPageTabId);
        return r100;
    }

    public final void b(TrackParams r100) {
        Intrinsics.checkNotNullParameter(r100, "src");
        r100.put("bot_id", this.botId);
        r100.put("is_certification_label", this.isCertificationLabel);
        r100.put("certification_label_type", this.certificationLabelType);
        r100.put("label_list", this.labelList);
        r100.put("is_capability_label", this.isCapabilityLabel);
        r100.put("capability_label_cnt", this.capabilityLabelCnt);
        r100.put("discover_page_tab_id", this.discoverPageTabId);
    }

    public BotRecommendMobInfo(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        this.botId = r100;
        this.isCertificationLabel = r101;
        this.certificationLabelType = r102;
        this.labelList = r103;
        this.isCapabilityLabel = r104;
        this.capabilityLabelCnt = r105;
        this.discoverPageTabId = r106;
    }
}
