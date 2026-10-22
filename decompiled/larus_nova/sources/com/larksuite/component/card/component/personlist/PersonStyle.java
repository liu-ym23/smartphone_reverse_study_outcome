package com.larksuite.component.card.component.personlist;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0010HÆ\u0003J\u0081\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0006\u0010/\u001a\u00020\u0003J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\u0003HÖ\u0001J\t\u00105\u001a\u00020\u0007HÖ\u0001J\u0016\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006;"}, d2 = {"Lcom/larksuite/component/card/component/personlist/PersonStyle;", "Landroid/os/Parcelable;", "avatarSize", "", "avatarSpace", "nameSize", "nameToken", "", "nameLineHeight", "nameColor", "moreColor", "moreTextColor", "moreTextToken", "moreTextSize", "moreMaxCount", GXTemplateKey.FLEXBOX_MARGIN, "Lcom/larksuite/component/card/component/personlist/PersonMargin;", "<init>", "(IIILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/larksuite/component/card/component/personlist/PersonMargin;)V", "getAvatarSize", "()I", "getAvatarSpace", "getNameSize", "getNameToken", "()Ljava/lang/String;", "getNameLineHeight", "getNameColor", "getMoreColor", "getMoreTextColor", "getMoreTextToken", "getMoreTextSize", "getMoreMaxCount", "getMargin", "()Lcom/larksuite/component/card/component/personlist/PersonMargin;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PersonStyle implements Parcelable {
    public static final Parcelable.Creator<PersonStyle> CREATOR = null;
    private final int avatarSize;
    private final int avatarSpace;
    private final PersonMargin margin;
    private final String moreColor;
    private final int moreMaxCount;
    private final String moreTextColor;
    private final int moreTextSize;
    private final String moreTextToken;
    private final String nameColor;
    private final int nameLineHeight;
    private final int nameSize;
    private final String nameToken;

    public static final class a implements Parcelable.Creator<PersonStyle> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PersonStyle createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            return new PersonStyle(r110.readInt(), r110.readInt(), r110.readInt(), r110.readString(), r110.readInt(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readInt(), r110.readInt(), PersonMargin.CREATOR.createFromParcel(r110));
        }

        @Override // android.os.Parcelable.Creator
        public final PersonStyle[] newArray(int r100) {
            return new PersonStyle[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ PersonStyle copy$default(PersonStyle r110, int r111, int r112, int r113, String r114, int r115, String r116, String r210, String r211, String r212, int r213, int r214, PersonMargin r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        int r100 = r110.avatarSize;
    L7:
        if ((r216 & 2) == 0) goto L9;
        int r101 = r110.avatarSpace;
    L11:
        if ((r216 & 4) == 0) goto L13;
        int r102 = r110.nameSize;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r103 = r110.nameToken;
    L19:
        if ((r216 & 16) == 0) goto L21;
        int r104 = r110.nameLineHeight;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r105 = r110.nameColor;
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r106 = r110.moreColor;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r107 = r110.moreTextColor;
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r117 = r110.moreTextToken;
    L39:
        if ((r216 & 512) == 0) goto L41;
        int r118 = r110.moreTextSize;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        int r119 = r110.moreMaxCount;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        PersonMargin r108 = r110.margin;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r215;
        goto L51
    L45:
        r119 = r214;
        goto L47
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final int component1() {
        return this.avatarSize;
    }

    public final int component10() {
        return this.moreTextSize;
    }

    public final int component11() {
        return this.moreMaxCount;
    }

    public final PersonMargin component12() {
        return this.margin;
    }

    public final int component2() {
        return this.avatarSpace;
    }

    public final int component3() {
        return this.nameSize;
    }

    public final String component4() {
        return this.nameToken;
    }

    public final int component5() {
        return this.nameLineHeight;
    }

    public final String component6() {
        return this.nameColor;
    }

    public final String component7() {
        return this.moreColor;
    }

    public final String component8() {
        return this.moreTextColor;
    }

    public final String component9() {
        return this.moreTextToken;
    }

    public final PersonStyle copy(int r110, int r111, int r112, String r113, int r114, String r210, String r211, String r212, String r213, int r214, int r215, PersonMargin r216) {
        Intrinsics.checkNotNullParameter(r113, "nameToken");
        Intrinsics.checkNotNullParameter(r210, "nameColor");
        Intrinsics.checkNotNullParameter(r211, "moreColor");
        Intrinsics.checkNotNullParameter(r212, "moreTextColor");
        Intrinsics.checkNotNullParameter(r213, "moreTextToken");
        Intrinsics.checkNotNullParameter(r216, GXTemplateKey.FLEXBOX_MARGIN);
        return new PersonStyle(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PersonStyle) == true) goto L8;
        return false;
    L8:
        PersonStyle r101 = (PersonStyle) r100;
        if (this.avatarSize == r101.avatarSize) goto L12;
        return false;
    L12:
        if (this.avatarSpace == r101.avatarSpace) goto L15;
        return false;
    L15:
        if (this.nameSize == r101.nameSize) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.nameToken, r101.nameToken) == true) goto L21;
        return false;
    L21:
        if (this.nameLineHeight == r101.nameLineHeight) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.nameColor, r101.nameColor) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.moreColor, r101.moreColor) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.moreTextColor, r101.moreTextColor) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.moreTextToken, r101.moreTextToken) == true) goto L36;
        return false;
    L36:
        if (this.moreTextSize == r101.moreTextSize) goto L39;
        return false;
    L39:
        if (this.moreMaxCount == r101.moreMaxCount) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.margin, r101.margin) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.avatarSize * 31) + this.avatarSpace) * 31) + this.nameSize) * 31) + this.nameToken.hashCode()) * 31) + this.nameLineHeight) * 31) + this.nameColor.hashCode()) * 31) + this.moreColor.hashCode()) * 31) + this.moreTextColor.hashCode()) * 31) + this.moreTextToken.hashCode()) * 31) + this.moreTextSize) * 31) + this.moreMaxCount) * 31) + this.margin.hashCode();
    }

    public String toString() {
        return "PersonStyle(avatarSize=" + this.avatarSize + ", avatarSpace=" + this.avatarSpace + ", nameSize=" + this.nameSize + ", nameToken=" + this.nameToken + ", nameLineHeight=" + this.nameLineHeight + ", nameColor=" + this.nameColor + ", moreColor=" + this.moreColor + ", moreTextColor=" + this.moreTextColor + ", moreTextToken=" + this.moreTextToken + ", moreTextSize=" + this.moreTextSize + ", moreMaxCount=" + this.moreMaxCount + ", margin=" + this.margin + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.avatarSize);
        r100.writeInt(this.avatarSpace);
        r100.writeInt(this.nameSize);
        r100.writeString(this.nameToken);
        r100.writeInt(this.nameLineHeight);
        r100.writeString(this.nameColor);
        r100.writeString(this.moreColor);
        r100.writeString(this.moreTextColor);
        r100.writeString(this.moreTextToken);
        r100.writeInt(this.moreTextSize);
        r100.writeInt(this.moreMaxCount);
        this.margin.writeToParcel(r100, r101);
    }

    public final int getAvatarSize() {
        return this.avatarSize;
    }

    public final int getAvatarSpace() {
        return this.avatarSpace;
    }

    public final PersonMargin getMargin() {
        return this.margin;
    }

    public final String getMoreColor() {
        return this.moreColor;
    }

    public final int getMoreMaxCount() {
        return this.moreMaxCount;
    }

    public final String getMoreTextColor() {
        return this.moreTextColor;
    }

    public final int getMoreTextSize() {
        return this.moreTextSize;
    }

    public final String getMoreTextToken() {
        return this.moreTextToken;
    }

    public final String getNameColor() {
        return this.nameColor;
    }

    public final int getNameLineHeight() {
        return this.nameLineHeight;
    }

    public final int getNameSize() {
        return this.nameSize;
    }

    public final String getNameToken() {
        return this.nameToken;
    }

    public PersonStyle(int r100, int r101, int r102, String r103, int r104, String r105, String r106, String r107, String r110, int r111, int r112, PersonMargin r113) {
        Intrinsics.checkNotNullParameter(r103, "nameToken");
        Intrinsics.checkNotNullParameter(r105, "nameColor");
        Intrinsics.checkNotNullParameter(r106, "moreColor");
        Intrinsics.checkNotNullParameter(r107, "moreTextColor");
        Intrinsics.checkNotNullParameter(r110, "moreTextToken");
        Intrinsics.checkNotNullParameter(r113, GXTemplateKey.FLEXBOX_MARGIN);
        this.avatarSize = r100;
        this.avatarSpace = r101;
        this.nameSize = r102;
        this.nameToken = r103;
        this.nameLineHeight = r104;
        this.nameColor = r105;
        this.moreColor = r106;
        this.moreTextColor = r107;
        this.moreTextToken = r110;
        this.moreTextSize = r111;
        this.moreMaxCount = r112;
        this.margin = r113;
    }
}
