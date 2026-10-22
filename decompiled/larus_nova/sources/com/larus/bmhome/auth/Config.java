package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0081\u0001\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010%\u001a\u00020&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020&HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020&R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u00062"}, d2 = {"Lcom/larus/bmhome/auth/Config;", "Landroid/os/Parcelable;", "frontierAppKey", "", "frontierAppId", "frontierDomain", "frontierProductId", "messageServiceId", "imServiceId", "samiAppKey", "samiToken", "enterpriseAudioAppKey", "enterpriseCallAppKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFrontierAppKey", "()Ljava/lang/String;", "getFrontierAppId", "getFrontierDomain", "getFrontierProductId", "getMessageServiceId", "getImServiceId", "getSamiAppKey", "getSamiToken", "getEnterpriseAudioAppKey", "getEnterpriseCallAppKey", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Config implements Parcelable {
    public static final Parcelable.Creator<Config> CREATOR = null;

    @SerializedName("enterprise_audio_app_key")
    private final String enterpriseAudioAppKey;

    @SerializedName("enterprise_call_app_key")
    private final String enterpriseCallAppKey;

    @SerializedName("ws_app_id")
    private final String frontierAppId;

    @SerializedName("ws_app_key")
    private final String frontierAppKey;

    @SerializedName("ws_domain")
    private final String frontierDomain;

    @SerializedName("ws_product_id")
    private final String frontierProductId;

    @SerializedName("im_service_id")
    private final String imServiceId;

    @SerializedName("message_service_id")
    private final String messageServiceId;

    @SerializedName("audio_app_key")
    private final String samiAppKey;

    @SerializedName("audio_token")
    private final String samiToken;

    public static final class a implements Parcelable.Creator<Config> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Config createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            return new Config(r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final Config[] newArray(int r100) {
            return new Config[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Config) == true) goto L8;
        return false;
    L8:
        Config r101 = (Config) r100;
        if (Intrinsics.areEqual(this.frontierAppKey, r101.frontierAppKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.frontierAppId, r101.frontierAppId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.frontierDomain, r101.frontierDomain) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.frontierProductId, r101.frontierProductId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.messageServiceId, r101.messageServiceId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.imServiceId, r101.imServiceId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.samiAppKey, r101.samiAppKey) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.samiToken, r101.samiToken) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.enterpriseAudioAppKey, r101.enterpriseAudioAppKey) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.enterpriseCallAppKey, r101.enterpriseCallAppKey) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        String r100 = this.frontierAppKey;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.frontierAppId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.frontierDomain;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.frontierProductId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.messageServiceId;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.imServiceId;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.samiAppKey;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.samiToken;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.enterpriseAudioAppKey;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.enterpriseCallAppKey;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
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
        return "Config(frontierAppKey=" + this.frontierAppKey + ", frontierAppId=" + this.frontierAppId + ", frontierDomain=" + this.frontierDomain + ", frontierProductId=" + this.frontierProductId + ", messageServiceId=" + this.messageServiceId + ", imServiceId=" + this.imServiceId + ", samiAppKey=" + this.samiAppKey + ", samiToken=" + this.samiToken + ", enterpriseAudioAppKey=" + this.enterpriseAudioAppKey + ", enterpriseCallAppKey=" + this.enterpriseCallAppKey + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.frontierAppKey);
        r100.writeString(this.frontierAppId);
        r100.writeString(this.frontierDomain);
        r100.writeString(this.frontierProductId);
        r100.writeString(this.messageServiceId);
        r100.writeString(this.imServiceId);
        r100.writeString(this.samiAppKey);
        r100.writeString(this.samiToken);
        r100.writeString(this.enterpriseAudioAppKey);
        r100.writeString(this.enterpriseCallAppKey);
    }

    public Config() {
        this("", "", "", "", "", "", "", "", null, null);
    }

    public final String a() {
        return this.enterpriseAudioAppKey;
    }

    public final String b() {
        return this.enterpriseCallAppKey;
    }

    public final String c() {
        return this.frontierAppId;
    }

    public final String d() {
        return this.frontierAppKey;
    }

    public final String e() {
        return this.frontierDomain;
    }

    public final String g() {
        return this.frontierProductId;
    }

    public final String h() {
        return this.imServiceId;
    }

    public final String i() {
        return this.messageServiceId;
    }

    public final String j() {
        return this.samiAppKey;
    }

    public final String k() {
        return this.samiToken;
    }

    public Config(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110) {
        this.frontierAppKey = r100;
        this.frontierAppId = r101;
        this.frontierDomain = r102;
        this.frontierProductId = r103;
        this.messageServiceId = r104;
        this.imServiceId = r105;
        this.samiAppKey = r106;
        this.samiToken = r107;
        this.enterpriseAudioAppKey = r108;
        this.enterpriseCallAppKey = r110;
    }
}
