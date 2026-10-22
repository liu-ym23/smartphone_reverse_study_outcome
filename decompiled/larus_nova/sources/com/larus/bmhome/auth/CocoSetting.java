package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b*\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003Jz\u0010-\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010.J\u0006\u0010/\u001a\u00020\u0006J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\u0006HÖ\u0001J\t\u00105\u001a\u00020\u0004HÖ\u0001J\u0016\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0006R,\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR \u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR \u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019¨\u0006;"}, d2 = {"Lcom/larus/bmhome/auth/CocoSetting;", "Landroid/os/Parcelable;", "cocoVoiceTypeMap", "", "", "appIconId", "", "cocoIconUrl", "cocoIconUri", "cocoDynamicUrl", "cocoDynamicImgUri", "cocoVoiceId", "cocoSettingIconUrl", "<init>", "(Ljava/util/Map;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCocoVoiceTypeMap", "()Ljava/util/Map;", "setCocoVoiceTypeMap", "(Ljava/util/Map;)V", "getAppIconId", "()Ljava/lang/Integer;", "setAppIconId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCocoIconUrl", "()Ljava/lang/String;", "setCocoIconUrl", "(Ljava/lang/String;)V", "getCocoIconUri", "setCocoIconUri", "getCocoDynamicUrl", "setCocoDynamicUrl", "getCocoDynamicImgUri", "setCocoDynamicImgUri", "getCocoVoiceId", "setCocoVoiceId", "getCocoSettingIconUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/util/Map;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/bmhome/auth/CocoSetting;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CocoSetting implements Parcelable {
    public static final Parcelable.Creator<CocoSetting> CREATOR = null;

    @SerializedName("app_icon_id")
    private Integer appIconId;

    @SerializedName("coco_dynamic_img_uri")
    private String cocoDynamicImgUri;

    @SerializedName("coco_dynamic_img_url")
    private String cocoDynamicUrl;

    @SerializedName("coco_icon_uri")
    private String cocoIconUri;

    @SerializedName("coco_icon_url")
    private String cocoIconUrl;

    @SerializedName("coco_setting_icon_url")
    private final String cocoSettingIconUrl;

    @SerializedName("coco_voice_type")
    private String cocoVoiceId;

    @SerializedName("coco_voice_type_map")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private Map<String, String> cocoVoiceTypeMap;

    public static final class a implements Parcelable.Creator<CocoSetting> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CocoSetting createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            Integer r100 = null;
            if (r110.readInt() != 0) goto L5;
            LinkedHashMap r101 = null;
        L10:
            if (r110.readInt() == 0) goto L14;
            r100 = Integer.valueOf(r110.readInt());
        L14:
            return new CocoSetting(r101, r100, r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString());
        L5:
            int r102 = r110.readInt();
            LinkedHashMap r103 = new LinkedHashMap(r102);
            int r104 = 0;
        L6:
            if (r104 == r102) goto L8;
            r103.put(r110.readString(), r110.readString());
            r104 = r104 + 1;
            goto L6
        L8:
            r101 = r103;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public final CocoSetting[] newArray(int r100) {
            return new CocoSetting[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public CocoSetting() {
        this(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CocoSetting) == true) goto L8;
        return false;
    L8:
        CocoSetting r101 = (CocoSetting) r100;
        if (Intrinsics.areEqual(this.cocoVoiceTypeMap, r101.cocoVoiceTypeMap) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appIconId, r101.appIconId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cocoIconUrl, r101.cocoIconUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cocoIconUri, r101.cocoIconUri) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.cocoDynamicUrl, r101.cocoDynamicUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.cocoDynamicImgUri, r101.cocoDynamicImgUri) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.cocoVoiceId, r101.cocoVoiceId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.cocoSettingIconUrl, r101.cocoSettingIconUrl) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Map<String, String> r100 = this.cocoVoiceTypeMap;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.appIconId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.cocoIconUrl;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.cocoIconUri;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.cocoDynamicUrl;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.cocoDynamicImgUri;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.cocoVoiceId;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.cocoSettingIconUrl;
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
        return "CocoSetting(cocoVoiceTypeMap=" + this.cocoVoiceTypeMap + ", appIconId=" + this.appIconId + ", cocoIconUrl=" + this.cocoIconUrl + ", cocoIconUri=" + this.cocoIconUri + ", cocoDynamicUrl=" + this.cocoDynamicUrl + ", cocoDynamicImgUri=" + this.cocoDynamicImgUri + ", cocoVoiceId=" + this.cocoVoiceId + ", cocoSettingIconUrl=" + this.cocoSettingIconUrl + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Map<String, String> r102 = this.cocoVoiceTypeMap;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L9:
        Integer r103 = this.appIconId;
        if (r103 != null) goto L12;
        r100.writeInt(0);
    L13:
        r100.writeString(this.cocoIconUrl);
        r100.writeString(this.cocoIconUri);
        r100.writeString(this.cocoDynamicUrl);
        r100.writeString(this.cocoDynamicImgUri);
        r100.writeString(this.cocoVoiceId);
        r100.writeString(this.cocoSettingIconUrl);
        return;
    L12:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        goto L13
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<Map.Entry<String, String>> r104 = r102.entrySet().iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        Map.Entry<String, String> r105 = r104.next();
        r100.writeString(r105.getKey());
        r100.writeString(r105.getValue());
        goto L7
    }

    public final Integer a() {
        return this.appIconId;
    }

    public final String b() {
        return this.cocoDynamicImgUri;
    }

    public final String c() {
        return this.cocoDynamicUrl;
    }

    public final String d() {
        return this.cocoIconUri;
    }

    public final String e() {
        return this.cocoIconUrl;
    }

    public final String g() {
        return this.cocoSettingIconUrl;
    }

    public final String h() {
        return this.cocoVoiceId;
    }

    public final Map<String, String> i() {
        return this.cocoVoiceTypeMap;
    }

    public /* synthetic */ CocoSetting(int r110) {
        this(null, 0, "", "", "", "", "", "");
    }

    public CocoSetting(Map<String, String> r100, Integer r101, String r102, String r103, String r104, String r105, String r106, String r107) {
        this.cocoVoiceTypeMap = r100;
        this.appIconId = r101;
        this.cocoIconUrl = r102;
        this.cocoIconUri = r103;
        this.cocoDynamicUrl = r104;
        this.cocoDynamicImgUri = r105;
        this.cocoVoiceId = r106;
        this.cocoSettingIconUrl = r107;
    }
}
