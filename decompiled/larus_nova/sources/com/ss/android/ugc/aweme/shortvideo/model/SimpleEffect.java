package com.ss.android.ugc.aweme.shortvideo.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.base.model.UrlModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BU\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0016Jd\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010#J\t\u0010$\u001a\u00020%HÖ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020%HÖ\u0001J\t\u0010+\u001a\u00020\u0006HÖ\u0001J\u0019\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020%HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u00061"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/model/SimpleEffect;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "iconUrl", "Lcom/ss/android/ugc/aweme/base/model/UrlModel;", "name", "", "extra", "designerUid", "types", "", "resourceId", "publishTime", "", "(Lcom/ss/android/ugc/aweme/base/model/UrlModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;)V", "getDesignerUid", "()Ljava/lang/String;", "getExtra", "getIconUrl", "()Lcom/ss/android/ugc/aweme/base/model/UrlModel;", "getName", "getPublishTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getResourceId", "getTypes", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lcom/ss/android/ugc/aweme/base/model/UrlModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;)Lcom/ss/android/ugc/aweme/shortvideo/model/SimpleEffect;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class SimpleEffect implements Parcelable, Serializable {
    public static final Parcelable.Creator<SimpleEffect> CREATOR = null;

    @SerializedName(alternate = {"designer_uid"}, value = "designerUid")
    private final String designerUid;

    @SerializedName("extra")
    private final String extra;

    @SerializedName(alternate = {"icon_url"}, value = "iconUrl")
    private final UrlModel iconUrl;

    @SerializedName("name")
    private final String name;

    @SerializedName("publishTime")
    private final Long publishTime;

    @SerializedName(alternate = {"resource_id"}, value = "resourceId")
    private final String resourceId;

    @SerializedName("types")
    private final List<String> types;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public static class Creator implements Parcelable.Creator<SimpleEffect> {
        public Creator() {
        }

        @Override // android.os.Parcelable.Creator
        public final SimpleEffect createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "in");
            UrlModel r100 = (UrlModel) r110.readSerializable();
            String r101 = r110.readString();
            String r102 = r110.readString();
            String r103 = r110.readString();
            ArrayList<String> r104 = r110.createStringArrayList();
            String r105 = r110.readString();
            if (r110.readInt() == 0) goto L5;
            Long r111 = Long.valueOf(r110.readLong());
        L7:
            return new SimpleEffect(r100, r101, r102, r103, r104, r105, r111);
        L5:
            r111 = null;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final SimpleEffect[] newArray(int r100) {
            return new SimpleEffect[r100];
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SimpleEffect copy$default(SimpleEffect r100, UrlModel r101, String r102, String r103, String r104, List r110, String r111, Long r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.iconUrl;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.name;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.extra;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.designerUid;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.types;
    L17:
        List r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.resourceId;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.publishTime;
    L23:
        UrlModel r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final UrlModel component1() {
        return this.iconUrl;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.extra;
    }

    public final String component4() {
        return this.designerUid;
    }

    public final List<String> component5() {
        return this.types;
    }

    public final String component6() {
        return this.resourceId;
    }

    public final Long component7() {
        return this.publishTime;
    }

    public final SimpleEffect copy(UrlModel r110, String r111, String r112, String r113, List<String> r114, String r115, Long r116) {
        Intrinsics.checkNotNullParameter(r110, "iconUrl");
        Intrinsics.checkNotNullParameter(r111, "name");
        return new SimpleEffect(r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SimpleEffect) == false) goto L20;
        SimpleEffect r101 = (SimpleEffect) r100;
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.designerUid, r101.designerUid) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.types, r101.types) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.resourceId, r101.resourceId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.publishTime, r101.publishTime) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        UrlModel r100 = this.iconUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.extra;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.designerUid;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<String> r113 = this.types;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.resourceId;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Long r119 = this.publishTime;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
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

    public String toString() {
        return "SimpleEffect(iconUrl=" + this.iconUrl + ", name=" + this.name + ", extra=" + this.extra + ", designerUid=" + this.designerUid + ", types=" + this.types + ", resourceId=" + this.resourceId + ", publishTime=" + this.publishTime + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeSerializable(this.iconUrl);
        r100.writeString(this.name);
        r100.writeString(this.extra);
        r100.writeString(this.designerUid);
        r100.writeStringList(this.types);
        r100.writeString(this.resourceId);
        Long r102 = this.publishTime;
        if (r102 == null) goto L5;
        r100.writeInt(1);
        r100.writeLong(r102.longValue());
        return;
    L5:
        r100.writeInt(0);
    }

    public final String getDesignerUid() {
        return this.designerUid;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final UrlModel getIconUrl() {
        return this.iconUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final Long getPublishTime() {
        return this.publishTime;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final List<String> getTypes() {
        return this.types;
    }

    public SimpleEffect(UrlModel r100, String r101, String r102, String r103, List<String> r104, String r105, Long r106) {
        Intrinsics.checkNotNullParameter(r100, "iconUrl");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.iconUrl = r100;
        this.name = r101;
        this.extra = r102;
        this.designerUid = r103;
        this.types = r104;
        this.resourceId = r105;
        this.publishTime = r106;
    }

    public /* synthetic */ SimpleEffect(UrlModel r110, String r111, String r112, String r113, List r114, String r115, Long r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 8) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r117 & 16) == 0) goto L9;
        List r101 = null;
    L11:
        if ((r117 & 32) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r117 & 64) == 0) goto L17;
        Long r103 = null;
    L18:
        this(r110, r111, r112, r100, r101, r102, r103);
        return;
    L17:
        r103 = r116;
        goto L18
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
