package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B£\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u00104\u001a\u0004\u0018\u00010\u0003HÂ\u0003¢\u0006\u0002\u0010.J\u0010\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u00106\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.Jª\u0001\u0010A\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010BJ\u0006\u0010C\u001a\u00020\u0003J\u0013\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010GHÖ\u0003J\t\u0010H\u001a\u00020\u0003HÖ\u0001J\t\u0010I\u001a\u00020\u0007HÖ\u0001J\u0016\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u0003R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR \u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR \u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR \u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR \u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001dR \u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR \u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001b\"\u0004\b+\u0010\u001dR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001bR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b-\u0010.R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b/\u0010.R\u0013\u00100\u001a\u0004\u0018\u0001018F¢\u0006\u0006\u001a\u0004\b2\u00103¨\u0006O"}, d2 = {"Lcom/larus/bmhome/auth/OnboardingActionCardItemData;", "Landroid/os/Parcelable;", "_cardType", "", "skillId", "", "skillName", "", "skillLightIcon", "skillDarkIcon", "subTitle", "cardPrompt", "attachmentUrl", "attachmentName", "schema", "actionbarExt", "imgWidth", "imgHeight", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSkillId", "()Ljava/lang/Long;", "setSkillId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getSkillName", "()Ljava/lang/String;", "setSkillName", "(Ljava/lang/String;)V", "getSkillLightIcon", "setSkillLightIcon", "getSkillDarkIcon", "setSkillDarkIcon", "getSubTitle", "setSubTitle", "getCardPrompt", "setCardPrompt", "getAttachmentUrl", "setAttachmentUrl", "getAttachmentName", "setAttachmentName", "getSchema", "setSchema", "getActionbarExt", "getImgWidth", "()Ljava/lang/Integer;", "getImgHeight", "cardType", "Lcom/larus/bmhome/auth/OnboardingActionCardData$CardType;", "getCardType", "()Lcom/larus/bmhome/auth/OnboardingActionCardData$CardType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/bmhome/auth/OnboardingActionCardItemData;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OnboardingActionCardItemData implements Parcelable {
    public static final Parcelable.Creator<OnboardingActionCardItemData> CREATOR = null;

    @SerializedName("skill_type")
    private Integer _cardType;

    @SerializedName("action_bar_instruction_v")
    private final String actionbarExt;

    @SerializedName("attachment_name")
    private String attachmentName;

    @SerializedName("attachment_url")
    private String attachmentUrl;

    @SerializedName(EventConstant.Key.RETAIN_PROMPT)
    private String cardPrompt;

    @SerializedName("image_height")
    private final Integer imgHeight;

    @SerializedName("image_width")
    private final Integer imgWidth;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL)
    private String schema;

    @SerializedName("skill_dark_icon")
    private String skillDarkIcon;

    @SerializedName("skill_card_id")
    private Long skillId;

    @SerializedName("skill_light_icon")
    private String skillLightIcon;

    @SerializedName("skill_name")
    private String skillName;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    private String subTitle;

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a implements Parcelable.Creator<OnboardingActionCardItemData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OnboardingActionCardItemData createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            if (r110.readInt() != 0) goto L5;
            Integer r100 = null;
        L7:
            if (r110.readInt() != 0) goto L9;
            Long r101 = null;
        L10:
            String r102 = r110.readString();
            String r103 = r110.readString();
            String r104 = r110.readString();
            String r105 = r110.readString();
            String r106 = r110.readString();
            String r111 = r110.readString();
            String r112 = r110.readString();
            String r113 = r110.readString();
            String r114 = r110.readString();
            if (r110.readInt() != 0) goto L13;
            Integer r115 = null;
        L15:
            if (r110.readInt() != 0) goto L17;
            Integer r116 = null;
        L19:
            return new OnboardingActionCardItemData(r100, r101, r102, r103, r104, r105, r106, r111, r112, r113, r114, r115, r116);
        L17:
            r116 = Integer.valueOf(r110.readInt());
            goto L19
        L13:
            r115 = Integer.valueOf(r110.readInt());
            goto L15
        L9:
            r101 = Long.valueOf(r110.readLong());
            goto L10
        L5:
            r100 = Integer.valueOf(r110.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final OnboardingActionCardItemData[] newArray(int r100) {
            return new OnboardingActionCardItemData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public OnboardingActionCardItemData() {
        this(null, null, null, null, null, null, null, null, null, null, null, 0, 0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OnboardingActionCardItemData) == true) goto L8;
        return false;
    L8:
        OnboardingActionCardItemData r101 = (OnboardingActionCardItemData) r100;
        if (Intrinsics.areEqual(this._cardType, r101._cardType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.skillId, r101.skillId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.skillName, r101.skillName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.skillLightIcon, r101.skillLightIcon) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.skillDarkIcon, r101.skillDarkIcon) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.subTitle, r101.subTitle) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.cardPrompt, r101.cardPrompt) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.attachmentUrl, r101.attachmentUrl) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.attachmentName, r101.attachmentName) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.actionbarExt, r101.actionbarExt) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.imgWidth, r101.imgWidth) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.imgHeight, r101.imgHeight) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this._cardType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.skillId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.skillName;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.skillLightIcon;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.skillDarkIcon;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.subTitle;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.cardPrompt;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.attachmentUrl;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.attachmentName;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.schema;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.actionbarExt;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.imgWidth;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Integer r137 = this.imgHeight;
        if (r137 == null) goto L55;
        r101 = r137.hashCode();
    L55:
        return r136 + r101;
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
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
        return "OnboardingActionCardItemData(_cardType=" + this._cardType + ", skillId=" + this.skillId + ", skillName=" + this.skillName + ", skillLightIcon=" + this.skillLightIcon + ", skillDarkIcon=" + this.skillDarkIcon + ", subTitle=" + this.subTitle + ", cardPrompt=" + this.cardPrompt + ", attachmentUrl=" + this.attachmentUrl + ", attachmentName=" + this.attachmentName + ", schema=" + this.schema + ", actionbarExt=" + this.actionbarExt + ", imgWidth=" + this.imgWidth + ", imgHeight=" + this.imgHeight + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Integer r102 = this._cardType;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Long r103 = this.skillId;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        r100.writeString(this.skillName);
        r100.writeString(this.skillLightIcon);
        r100.writeString(this.skillDarkIcon);
        r100.writeString(this.subTitle);
        r100.writeString(this.cardPrompt);
        r100.writeString(this.attachmentUrl);
        r100.writeString(this.attachmentName);
        r100.writeString(this.schema);
        r100.writeString(this.actionbarExt);
        Integer r104 = this.imgWidth;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        Integer r105 = this.imgHeight;
        if (r105 != null) goto L17;
        r100.writeInt(0);
        return;
    L17:
        r100.writeInt(1);
        r100.writeInt(r105.intValue());
        return;
    L13:
        r100.writeInt(1);
        r100.writeInt(r104.intValue());
        goto L14
    L9:
        r100.writeInt(1);
        r100.writeLong(r103.longValue());
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.intValue());
        goto L6
    }

    public final OnboardingActionCardData.CardType e() {
        Integer r100 = this._cardType;
        if (r100 == null) goto L13;
        int r101 = r100.intValue();
        OnboardingActionCardData.CardType.Companion.getClass();
        OnboardingActionCardData.CardType[] r102 = OnboardingActionCardData.CardType.values();
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L17;
        OnboardingActionCardData.CardType r105 = r102[r104];
        if (r105.getValue() != r101) goto L9;
        boolean r106 = true;
    L10:
        if (r106 == true) goto L16;
        r104 = r104 + 1;
        goto L5
    L16:
        return r105;
    L9:
        r106 = false;
        goto L10
    L17:
        return null;
    L13:
        return null;
    }

    public final String a() {
        return this.actionbarExt;
    }

    public final String b() {
        return this.attachmentName;
    }

    public final String c() {
        return this.attachmentUrl;
    }

    public final String d() {
        return this.cardPrompt;
    }

    public final Integer g() {
        return this.imgHeight;
    }

    public final Integer h() {
        return this.imgWidth;
    }

    public final String i() {
        return this.schema;
    }

    public final String j() {
        return this.skillDarkIcon;
    }

    public final Long k() {
        return this.skillId;
    }

    public final String o() {
        return this.skillLightIcon;
    }

    public final String q() {
        return this.skillName;
    }

    public final String r() {
        return this.subTitle;
    }

    public OnboardingActionCardItemData(Integer r100, Long r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111, Integer r112, Integer r113) {
        this._cardType = r100;
        this.skillId = r101;
        this.skillName = r102;
        this.skillLightIcon = r103;
        this.skillDarkIcon = r104;
        this.subTitle = r105;
        this.cardPrompt = r106;
        this.attachmentUrl = r107;
        this.attachmentName = r108;
        this.schema = r110;
        this.actionbarExt = r111;
        this.imgWidth = r112;
        this.imgHeight = r113;
    }
}
