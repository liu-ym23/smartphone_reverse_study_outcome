package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0017Jb\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020\u000bJ\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u000bHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006."}, d2 = {"Lcom/larus/bmhome/chat/bean/PopWindowButton;", "Landroid/os/Parcelable;", "text", "", "textColor", "Lcom/larus/bmhome/chat/bean/PopWindowColor;", "backgroundColor", "schema", "bizReqId", "params", ReportConstant.COMMON_ACTION_TYPE, "", "<init>", "(Ljava/lang/String;Lcom/larus/bmhome/chat/bean/PopWindowColor;Lcom/larus/bmhome/chat/bean/PopWindowColor;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getText", "()Ljava/lang/String;", "getTextColor", "()Lcom/larus/bmhome/chat/bean/PopWindowColor;", "getBackgroundColor", "getSchema", "getBizReqId", "getParams", "getActionType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Lcom/larus/bmhome/chat/bean/PopWindowColor;Lcom/larus/bmhome/chat/bean/PopWindowColor;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/bean/PopWindowButton;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopWindowButton implements Parcelable {
    public static final Parcelable.Creator<PopWindowButton> CREATOR = null;

    @SerializedName("action_type")
    private final Integer actionType;

    @SerializedName("background_color")
    private final PopWindowColor backgroundColor;

    @SerializedName("biz_req_id")
    private final String bizReqId;

    @SerializedName("params")
    private final String params;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("text")
    private final String text;

    @SerializedName("text_color")
    private final PopWindowColor textColor;

    public static final class a implements Parcelable.Creator<PopWindowButton> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PopWindowButton createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            if (r110.readInt() != 0) goto L5;
            PopWindowColor r101 = null;
        L6:
            PopWindowColor r102 = r101;
            if (r110.readInt() != 0) goto L9;
            PopWindowColor r103 = null;
        L10:
            PopWindowColor r104 = r103;
            String r105 = r110.readString();
            String r106 = r110.readString();
            String r107 = r110.readString();
            if (r110.readInt() != 0) goto L13;
            Integer r111 = null;
        L15:
            return new PopWindowButton(r100, r102, r104, r105, r106, r107, r111);
        L13:
            r111 = Integer.valueOf(r110.readInt());
            goto L15
        L9:
            r103 = PopWindowColor.CREATOR.createFromParcel(r110);
            goto L10
        L5:
            r101 = PopWindowColor.CREATOR.createFromParcel(r110);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final PopWindowButton[] newArray(int r100) {
            return new PopWindowButton[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public PopWindowButton() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ PopWindowButton copy$default(PopWindowButton r100, String r101, PopWindowColor r102, PopWindowColor r103, String r104, String r110, String r111, Integer r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.textColor;
    L8:
        PopWindowColor r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.backgroundColor;
    L11:
        PopWindowColor r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.schema;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.bizReqId;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.params;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.actionType;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.text;
    }

    public final PopWindowColor component2() {
        return this.textColor;
    }

    public final PopWindowColor component3() {
        return this.backgroundColor;
    }

    public final String component4() {
        return this.schema;
    }

    public final String component5() {
        return this.bizReqId;
    }

    public final String component6() {
        return this.params;
    }

    public final Integer component7() {
        return this.actionType;
    }

    public final PopWindowButton copy(String r110, PopWindowColor r111, PopWindowColor r112, String r113, String r114, String r115, Integer r116) {
        return new PopWindowButton(r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PopWindowButton) == true) goto L8;
        return false;
    L8:
        PopWindowButton r101 = (PopWindowButton) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.bizReqId, r101.bizReqId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.actionType, r101.actionType) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        PopWindowColor r104 = this.textColor;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        PopWindowColor r107 = this.backgroundColor;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.schema;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.bizReqId;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.params;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.actionType;
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

    public String toString() {
        return "PopWindowButton(text=" + this.text + ", textColor=" + this.textColor + ", backgroundColor=" + this.backgroundColor + ", schema=" + this.schema + ", bizReqId=" + this.bizReqId + ", params=" + this.params + ", actionType=" + this.actionType + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.text);
        PopWindowColor r102 = this.textColor;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        PopWindowColor r103 = this.backgroundColor;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        r100.writeString(this.schema);
        r100.writeString(this.bizReqId);
        r100.writeString(this.params);
        Integer r104 = this.actionType;
        if (r104 != null) goto L13;
        r100.writeInt(0);
        return;
    L13:
        r100.writeInt(1);
        r100.writeInt(r104.intValue());
        return;
    L9:
        r100.writeInt(1);
        r103.writeToParcel(r100, r101);
        goto L10
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
        goto L6
    }

    public final Integer getActionType() {
        return this.actionType;
    }

    public final PopWindowColor getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getBizReqId() {
        return this.bizReqId;
    }

    public final String getParams() {
        return this.params;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getText() {
        return this.text;
    }

    public final PopWindowColor getTextColor() {
        return this.textColor;
    }

    public PopWindowButton(String r100, PopWindowColor r101, PopWindowColor r102, String r103, String r104, String r105, Integer r106) {
        this.text = r100;
        this.textColor = r101;
        this.backgroundColor = r102;
        this.schema = r103;
        this.bizReqId = r104;
        this.params = r105;
        this.actionType = r106;
    }

    public /* synthetic */ PopWindowButton(String r100, PopWindowColor r101, PopWindowColor r102, String r110, String r111, String r112, Integer r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        PopWindowColor r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        PopWindowColor r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        Integer r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
