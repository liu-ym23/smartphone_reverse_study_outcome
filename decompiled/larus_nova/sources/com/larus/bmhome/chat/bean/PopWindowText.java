package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003JV\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u0006J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0006HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0006R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006+"}, d2 = {"Lcom/larus/bmhome/chat/bean/PopWindowText;", "Landroid/os/Parcelable;", "title", "", "description", "textAlignment", "", "descriptionAlignment", "textColor", "Lcom/larus/bmhome/chat/bean/PopWindowColor;", "descriptionColor", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/bmhome/chat/bean/PopWindowColor;Lcom/larus/bmhome/chat/bean/PopWindowColor;)V", "getTitle", "()Ljava/lang/String;", "getDescription", "getTextAlignment", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDescriptionAlignment", "getTextColor", "()Lcom/larus/bmhome/chat/bean/PopWindowColor;", "getDescriptionColor", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/bmhome/chat/bean/PopWindowColor;Lcom/larus/bmhome/chat/bean/PopWindowColor;)Lcom/larus/bmhome/chat/bean/PopWindowText;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopWindowText implements Parcelable {
    public static final Parcelable.Creator<PopWindowText> CREATOR = null;

    @SerializedName("description")
    private final String description;

    @SerializedName("description_alignment")
    private final Integer descriptionAlignment;

    @SerializedName("description_color")
    private final PopWindowColor descriptionColor;

    @SerializedName("text_alignment")
    private final Integer textAlignment;

    @SerializedName("text_color")
    private final PopWindowColor textColor;

    @SerializedName("title")
    private final String title;

    public static final class a implements Parcelable.Creator<PopWindowText> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PopWindowText createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            String r102 = r100.readString();
            PopWindowColor r103 = null;
            if (r100.readInt() != 0) goto L5;
            Integer r104 = null;
        L7:
            if (r100.readInt() != 0) goto L9;
            Integer r105 = null;
        L11:
            if (r100.readInt() != 0) goto L13;
            PopWindowColor r106 = null;
        L14:
            PopWindowColor r107 = r106;
            if (r100.readInt() == 0) goto L19;
            r103 = PopWindowColor.CREATOR.createFromParcel(r100);
        L19:
            return new PopWindowText(r101, r102, r104, r105, r107, r103);
        L13:
            r106 = PopWindowColor.CREATOR.createFromParcel(r100);
            goto L14
        L9:
            r105 = Integer.valueOf(r100.readInt());
            goto L11
        L5:
            r104 = Integer.valueOf(r100.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final PopWindowText[] newArray(int r100) {
            return new PopWindowText[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public PopWindowText() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ PopWindowText copy$default(PopWindowText r100, String r101, String r102, Integer r103, Integer r104, PopWindowColor r105, PopWindowColor r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.title;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.description;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.textAlignment;
    L11:
        Integer r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.descriptionAlignment;
    L14:
        Integer r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.textColor;
    L17:
        PopWindowColor r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.descriptionColor;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.description;
    }

    public final Integer component3() {
        return this.textAlignment;
    }

    public final Integer component4() {
        return this.descriptionAlignment;
    }

    public final PopWindowColor component5() {
        return this.textColor;
    }

    public final PopWindowColor component6() {
        return this.descriptionColor;
    }

    public final PopWindowText copy(String r100, String r110, Integer r111, Integer r112, PopWindowColor r113, PopWindowColor r114) {
        return new PopWindowText(r100, r110, r111, r112, r113, r114);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PopWindowText) == true) goto L8;
        return false;
    L8:
        PopWindowText r101 = (PopWindowText) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.textAlignment, r101.textAlignment) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.descriptionAlignment, r101.descriptionAlignment) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.descriptionColor, r101.descriptionColor) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.description;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.textAlignment;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.descriptionAlignment;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        PopWindowColor r113 = this.textColor;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        PopWindowColor r116 = this.descriptionColor;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
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
        return "PopWindowText(title=" + this.title + ", description=" + this.description + ", textAlignment=" + this.textAlignment + ", descriptionAlignment=" + this.descriptionAlignment + ", textColor=" + this.textColor + ", descriptionColor=" + this.descriptionColor + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.title);
        r100.writeString(this.description);
        Integer r102 = this.textAlignment;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Integer r103 = this.descriptionAlignment;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        PopWindowColor r104 = this.textColor;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        PopWindowColor r105 = this.descriptionColor;
        if (r105 != null) goto L17;
        r100.writeInt(0);
        return;
    L17:
        r100.writeInt(1);
        r105.writeToParcel(r100, r101);
        return;
    L13:
        r100.writeInt(1);
        r104.writeToParcel(r100, r101);
        goto L14
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.intValue());
        goto L6
    }

    public final String getDescription() {
        return this.description;
    }

    public final Integer getDescriptionAlignment() {
        return this.descriptionAlignment;
    }

    public final PopWindowColor getDescriptionColor() {
        return this.descriptionColor;
    }

    public final Integer getTextAlignment() {
        return this.textAlignment;
    }

    public final PopWindowColor getTextColor() {
        return this.textColor;
    }

    public final String getTitle() {
        return this.title;
    }

    public PopWindowText(String r100, String r101, Integer r102, Integer r103, PopWindowColor r104, PopWindowColor r105) {
        this.title = r100;
        this.description = r101;
        this.textAlignment = r102;
        this.descriptionAlignment = r103;
        this.textColor = r104;
        this.descriptionColor = r105;
    }

    public /* synthetic */ PopWindowText(String r100, String r101, Integer r102, Integer r103, PopWindowColor r110, PopWindowColor r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        Integer r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        Integer r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        PopWindowColor r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        PopWindowColor r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
