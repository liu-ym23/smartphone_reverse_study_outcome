package com.larus.im.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Deprecated(message = "old data flow")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0007!\"#$%&'B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0003J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006("}, d2 = {"Lcom/larus/im/bean/IMMetaInfo;", "Landroid/os/Parcelable;", "type", "", "info", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getInfo", "()Ljava/lang/String;", "setInfo", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/larus/im/bean/IMMetaInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "MetaReference", "MetaReferenceComparator", "ReplaceReference", "InsertReference", "MentionInfoReference", "InsertTextReference", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IMMetaInfo implements Parcelable {
    public static final Parcelable.Creator<IMMetaInfo> CREATOR = null;

    @SerializedName("info")
    private String info;

    @SerializedName("type")
    private Integer type;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b0\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010*\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\u0011J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJz\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u00020\u00072\b\u00107\u001a\u0004\u0018\u000108HÖ\u0003J\t\u00109\u001a\u00020\u0003HÖ\u0001J\t\u0010:\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0016\"\u0004\b\u001f\u0010\u0018R \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\u0018R \u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0016\"\u0004\b%\u0010\u0018R \u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018R\"\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b(\u0010\u001a\"\u0004\b)\u0010\u001c¨\u0006;"}, d2 = {"Lcom/larus/im/bean/IMMetaInfo$InsertTextReference;", "Lcom/larus/im/bean/IMMetaInfo$MetaReference;", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "", "insertText", "", "canReplace", "", "value", "cardType", "style", "alt", "extra", "forceSeparate", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getPos", "()Ljava/lang/Integer;", "setPos", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getInsertText", "()Ljava/lang/String;", "setInsertText", "(Ljava/lang/String;)V", "getCanReplace", "()Ljava/lang/Boolean;", "setCanReplace", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getValue", "setValue", "getCardType", "setCardType", "getStyle", "setStyle", "getAlt", "setAlt", "getExtra", "setExtra", "getForceSeparate", "setForceSeparate", "getComparatorStartPos", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/im/bean/IMMetaInfo$InsertTextReference;", "equals", "other", "", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InsertTextReference implements d {

        @SerializedName("alt")
        private String alt;

        @SerializedName("can_replace")
        private Boolean canReplace;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE)
        private String cardType;

        @SerializedName("extra")
        private String extra;

        @SerializedName("force_separate")
        private Boolean forceSeparate;

        @SerializedName("insert_text")
        private String insertText;

        @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION)
        private Integer pos;

        @SerializedName("style")
        private String style;

        @SerializedName("value")
        private String value;

        public InsertTextReference() {
            this(null, null, null, null, null, null, null, null, null, 511, null);
        }

        public static /* synthetic */ InsertTextReference copy$default(InsertTextReference r110, Integer r111, String r112, Boolean r113, String r114, String r115, String r116, String r117, String r118, Boolean r119, int r210, Object r211) {
            if ((r210 & 1) == 0) goto L5;
            Integer r100 = r110.pos;
        L7:
            if ((r210 & 2) == 0) goto L9;
            String r101 = r110.insertText;
        L11:
            if ((r210 & 4) == 0) goto L13;
            Boolean r102 = r110.canReplace;
        L15:
            if ((r210 & 8) == 0) goto L17;
            String r103 = r110.value;
        L19:
            if ((r210 & 16) == 0) goto L21;
            String r104 = r110.cardType;
        L23:
            if ((r210 & 32) == 0) goto L25;
            String r105 = r110.style;
        L27:
            if ((r210 & 64) == 0) goto L29;
            String r106 = r110.alt;
        L31:
            if ((r210 & 128) == 0) goto L33;
            String r107 = r110.extra;
        L35:
            if ((r210 & 256) == 0) goto L37;
            Boolean r108 = r110.forceSeparate;
        L39:
            return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
        L37:
            r108 = r119;
            goto L39
        L33:
            r107 = r118;
            goto L35
        L29:
            r106 = r117;
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

        public final Integer component1() {
            return this.pos;
        }

        public final String component2() {
            return this.insertText;
        }

        public final Boolean component3() {
            return this.canReplace;
        }

        public final String component4() {
            return this.value;
        }

        public final String component5() {
            return this.cardType;
        }

        public final String component6() {
            return this.style;
        }

        public final String component7() {
            return this.alt;
        }

        public final String component8() {
            return this.extra;
        }

        public final Boolean component9() {
            return this.forceSeparate;
        }

        public final InsertTextReference copy(Integer r110, String r111, Boolean r112, String r113, String r114, String r115, String r116, String r117, Boolean r210) {
            return new InsertTextReference(r110, r111, r112, r113, r114, r115, r116, r117, r210);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof InsertTextReference) == true) goto L8;
            return false;
        L8:
            InsertTextReference r101 = (InsertTextReference) r100;
            if (Intrinsics.areEqual(this.pos, r101.pos) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.insertText, r101.insertText) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.canReplace, r101.canReplace) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.value, r101.value) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.cardType, r101.cardType) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.style, r101.style) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.alt, r101.alt) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.forceSeparate, r101.forceSeparate) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public int hashCode() {
            Integer r100 = this.pos;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.insertText;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Boolean r107 = this.canReplace;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.value;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.cardType;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.style;
            if (r116 != null) goto L25;
            int r117 = 0;
        L26:
            int r118 = (r115 + r117) * 31;
            String r119 = this.alt;
            if (r119 != null) goto L29;
            int r120 = 0;
        L30:
            int r121 = (r118 + r120) * 31;
            String r122 = this.extra;
            if (r122 != null) goto L33;
            int r123 = 0;
        L34:
            int r124 = (r121 + r123) * 31;
            Boolean r125 = this.forceSeparate;
            if (r125 == null) goto L39;
            r101 = r125.hashCode();
        L39:
            return r124 + r101;
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

        public String toString() {
            return "InsertTextReference(pos=" + this.pos + ", insertText=" + this.insertText + ", canReplace=" + this.canReplace + ", value=" + this.value + ", cardType=" + this.cardType + ", style=" + this.style + ", alt=" + this.alt + ", extra=" + this.extra + ", forceSeparate=" + this.forceSeparate + ')';
        }

        public final String getAlt() {
            return this.alt;
        }

        public final Boolean getCanReplace() {
            return this.canReplace;
        }

        public final String getCardType() {
            return this.cardType;
        }

        @Override // com.larus.im.bean.IMMetaInfo.d
        public Integer getComparatorStartPos() {
            return this.pos;
        }

        public final String getExtra() {
            return this.extra;
        }

        public final Boolean getForceSeparate() {
            return this.forceSeparate;
        }

        public final String getInsertText() {
            return this.insertText;
        }

        public final Integer getPos() {
            return this.pos;
        }

        public final String getStyle() {
            return this.style;
        }

        public final String getValue() {
            return this.value;
        }

        public final void setAlt(String r100) {
            this.alt = r100;
        }

        public final void setCanReplace(Boolean r100) {
            this.canReplace = r100;
        }

        public final void setCardType(String r100) {
            this.cardType = r100;
        }

        public final void setExtra(String r100) {
            this.extra = r100;
        }

        public final void setForceSeparate(Boolean r100) {
            this.forceSeparate = r100;
        }

        public final void setInsertText(String r100) {
            this.insertText = r100;
        }

        public final void setPos(Integer r100) {
            this.pos = r100;
        }

        public final void setStyle(String r100) {
            this.style = r100;
        }

        public final void setValue(String r100) {
            this.value = r100;
        }

        public InsertTextReference(Integer r100, String r101, Boolean r102, String r103, String r104, String r105, String r106, String r107, Boolean r108) {
            this.pos = r100;
            this.insertText = r101;
            this.canReplace = r102;
            this.value = r103;
            this.cardType = r104;
            this.style = r105;
            this.alt = r106;
            this.extra = r107;
            this.forceSeparate = r108;
        }

        public /* synthetic */ InsertTextReference(Integer r110, String r111, Boolean r112, String r113, String r114, String r115, String r116, String r117, Boolean r118, int r210, DefaultConstructorMarker r211) {
            if ((r210 & 1) == 0) goto L5;
            Integer r100 = 0;
        L6:
            String r101 = null;
            if ((r210 & 2) == 0) goto L9;
            String r102 = null;
        L11:
            if ((r210 & 4) == 0) goto L13;
            Boolean r103 = Boolean.FALSE;
        L15:
            if ((r210 & 8) == 0) goto L17;
            String r104 = null;
        L19:
            if ((r210 & 16) == 0) goto L21;
            String r105 = null;
        L23:
            if ((r210 & 32) == 0) goto L25;
            String r106 = null;
        L27:
            if ((r210 & 64) == 0) goto L29;
            String r107 = null;
        L31:
            if ((r210 & 128) != 0) goto L35;
            r101 = r117;
        L35:
            if ((r210 & 256) == 0) goto L37;
            Boolean r108 = Boolean.FALSE;
        L38:
            this(r100, r102, r103, r104, r105, r106, r107, r101, r108);
            return;
        L37:
            r108 = r118;
            goto L38
        L29:
            r107 = r116;
            goto L31
        L25:
            r106 = r115;
            goto L27
        L21:
            r105 = r114;
            goto L23
        L17:
            r104 = r113;
            goto L19
        L13:
            r103 = r112;
            goto L15
        L9:
            r102 = r111;
            goto L11
        L5:
            r100 = r110;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\u0017J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J3\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006#"}, d2 = {"Lcom/larus/im/bean/IMMetaInfo$MentionInfoReference;", "Lcom/larus/im/bean/IMMetaInfo$MetaReference;", "startIndex", "", "endIndex", "userId", "", "userType", "<init>", "(IILjava/lang/String;I)V", "getStartIndex", "()I", "setStartIndex", "(I)V", "getEndIndex", "setEndIndex", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "getUserType", "setUserType", "getComparatorStartPos", "()Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MentionInfoReference implements d {

        @SerializedName("end_index")
        private int endIndex;

        @SerializedName("start_index")
        private int startIndex;

        @SerializedName("user_id")
        private String userId;

        @SerializedName("user_type")
        private int userType;

        public MentionInfoReference() {
            this(0, 0, null, 0, 15, null);
        }

        public static /* synthetic */ MentionInfoReference copy$default(MentionInfoReference r100, int r101, int r102, String r103, int r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.startIndex;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.endIndex;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.userId;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.userType;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final int component1() {
            return this.startIndex;
        }

        public final int component2() {
            return this.endIndex;
        }

        public final String component3() {
            return this.userId;
        }

        public final int component4() {
            return this.userType;
        }

        public final MentionInfoReference copy(int r100, int r101, String r102, int r103) {
            return new MentionInfoReference(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof MentionInfoReference) == true) goto L8;
            return false;
        L8:
            MentionInfoReference r101 = (MentionInfoReference) r100;
            if (this.startIndex == r101.startIndex) goto L12;
            return false;
        L12:
            if (this.endIndex == r101.endIndex) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L18;
            return false;
        L18:
            if (this.userType == r101.userType) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r100 = ((this.startIndex * 31) + this.endIndex) * 31;
            String r101 = this.userId;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((r100 + r102) * 31) + this.userType;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public String toString() {
            return "MentionInfoReference(startIndex=" + this.startIndex + ", endIndex=" + this.endIndex + ", userId=" + this.userId + ", userType=" + this.userType + ')';
        }

        @Override // com.larus.im.bean.IMMetaInfo.d
        public Integer getComparatorStartPos() {
            return Integer.valueOf(this.startIndex);
        }

        public final int getEndIndex() {
            return this.endIndex;
        }

        public final int getStartIndex() {
            return this.startIndex;
        }

        public final String getUserId() {
            return this.userId;
        }

        public final int getUserType() {
            return this.userType;
        }

        public final void setEndIndex(int r100) {
            this.endIndex = r100;
        }

        public final void setStartIndex(int r100) {
            this.startIndex = r100;
        }

        public final void setUserId(String r100) {
            this.userId = r100;
        }

        public final void setUserType(int r100) {
            this.userType = r100;
        }

        public MentionInfoReference(int r100, int r101, String r102, int r103) {
            this.startIndex = r100;
            this.endIndex = r101;
            this.userId = r102;
            this.userType = r103;
        }

        public /* synthetic */ MentionInfoReference(int r100, int r101, String r102, int r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = 0;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = null;
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = 0;
        L14:
            this(r100, r101, r102, r103);
        }
    }

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<IMMetaInfo> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final IMMetaInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() != 0) goto L5;
            Integer r101 = null;
        L7:
            return new IMMetaInfo(r101, r100.readString());
        L5:
            r101 = Integer.valueOf(r100.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final IMMetaInfo[] newArray(int r100) {
            return new IMMetaInfo[r100];
        }
    }

    @Deprecated(message = "这个类虽然是特化用于尾部引用的，虽然有 pos 字段但实际没有插入内容中间，pos 只用于了多个引用之间排序依据，如有插入诉求建议使用更通用的InsertText")
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0019\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\u0015J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001e\u001a\u00020\tH\u0016J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003JK\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lcom/larus/im/bean/IMMetaInfo$InsertReference;", "Lcom/larus/im/bean/IMMetaInfo$MetaReference;", "insertText", "", "url", "icon", "title", "posList", "", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getInsertText", "()Ljava/lang/String;", "getUrl", "getIcon", "getTitle", "getPosList", "()Ljava/util/List;", "tempPos", "getTempPos", "()Ljava/lang/Integer;", "setTempPos", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getComparatorStartPos", "equals", "", "other", "", "hashCode", "component1", "component2", "component3", "component4", "component5", "copy", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f346410a;

        @SerializedName("icon")
        private final String icon;

        @SerializedName("insert_text")
        private final String insertText;

        @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION)
        private final List<Integer> posList;

        @SerializedName("website_name")
        private final String title;

        @SerializedName("url")
        private final String url;

        public c() {
            this(null, null, null, null, null);
        }

        public final String toString() {
            return "InsertReference(insertText=" + this.insertText + ", url=" + this.url + ", icon=" + this.icon + ", title=" + this.title + ", posList=" + this.posList + ')';
        }

        public final int hashCode() {
            return (this.insertText + this.url + this.title).hashCode();
        }

        public final String b() {
            return this.icon;
        }

        public final String c() {
            return this.insertText;
        }

        public final List<Integer> d() {
            return this.posList;
        }

        public final String e() {
            return this.title;
        }

        public final String f() {
            return this.url;
        }

        @Override // com.larus.im.bean.IMMetaInfo.d
        public final Integer getComparatorStartPos() {
            return this.f346410a;
        }

        public static c a(c r100) {
            String r101 = r100.insertText;
            String r102 = r100.url;
            String r103 = r100.icon;
            String r104 = r100.title;
            List<Integer> r105 = r100.posList;
            r100.getClass();
            return new c(r101, r102, r103, r104, r105);
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof c) == false) goto L12;
            c r101 = (c) r100;
            if (TextUtils.equals(this.insertText, r101.insertText) == true) goto L7;
            return false;
        L7:
            if (TextUtils.equals(this.url, r101.url) == true) goto L9;
            return false;
        L9:
            if (TextUtils.equals(this.title, r101.title) == false) goto L15;
            return true;
        L15:
            return false;
        L12:
            return false;
        }

        public c(String r100, String r101, String r102, String r103, List<Integer> r104) {
            this.insertText = r100;
            this.url = r101;
            this.icon = r102;
            this.title = r103;
            this.posList = r104;
        }
    }

    public interface d {
        Integer getComparatorStartPos();
    }

    public static final class e implements Comparator<d> {
        public e() {
        }

        @Override // java.util.Comparator
        public final int compare(d r100, d r101) {
            d r102 = r100;
            d r103 = r101;
            if (r102 == null) goto L7;
            Integer r104 = r102.getComparatorStartPos();
            if (r104 == null) goto L7;
            int r105 = r104.intValue();
        L8:
            if (r103 == null) goto L12;
            Integer r106 = r103.getComparatorStartPos();
            if (r106 == null) goto L12;
            int r107 = r106.intValue();
        L13:
            if (r105 > r107) goto L30;
            if (r105 >= r107) goto L18;
            return -1;
        L18:
            if ((r102 instanceof c) == true) goto L20;
            return 0;
        L20:
            if ((r103 instanceof c) == false) goto L33;
            String r108 = ((c) r102).c();
            String r109 = "";
            if (r108 != null) goto L24;
            r108 = "";
        L24:
            String r110 = ((c) r103).c();
            if (r110 == null) goto L29;
            r109 = r110;
        L29:
            return r108.compareTo(r109);
        L33:
            return 0;
        L30:
            return 1;
        L12:
            r107 = 0;
        L7:
            r105 = 0;
            goto L8
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jz\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\u0005HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011¨\u00060"}, d2 = {"Lcom/larus/im/bean/IMMetaInfo$ReplaceReference;", "Lcom/larus/im/bean/IMMetaInfo$MetaReference;", "replaceText", "", "start", "", "end", "sourceFrom", "", "sourceId", "sourceForBaike", "ext", "sourceType", "docId", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getReplaceText", "()Ljava/lang/String;", "getStart", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEnd", "getSourceFrom", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSourceId", "getSourceForBaike", "getExt", "getSourceType", "getDocId", "getComparatorStartPos", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/im/bean/IMMetaInfo$ReplaceReference;", "equals", "", "other", "", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class f implements d {

        @SerializedName("doc_id")
        private final String docId;

        @SerializedName("end")
        private final Integer end;

        @SerializedName("ext")
        private final String ext;

        @SerializedName("replace_text")
        private final String replaceText;

        @SerializedName("source_for_baike")
        private final String sourceForBaike;

        @SerializedName("source_from")
        private final Long sourceFrom;

        @SerializedName("source_id")
        private final String sourceId;

        @SerializedName("source_type")
        private final String sourceType;

        @SerializedName("start")
        private final Integer start;

        public f() {
            this.replaceText = null;
            this.start = 0;
            this.end = 0;
            this.sourceFrom = null;
            this.sourceId = null;
            this.sourceForBaike = null;
            this.ext = null;
            this.sourceType = null;
            this.docId = null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (Intrinsics.areEqual(this.replaceText, r101.replaceText) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.start, r101.start) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.end, r101.end) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.sourceFrom, r101.sourceFrom) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.sourceId, r101.sourceId) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.sourceForBaike, r101.sourceForBaike) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.sourceType, r101.sourceType) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.docId, r101.docId) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            String r100 = this.replaceText;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.start;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Integer r107 = this.end;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            Long r110 = this.sourceFrom;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.sourceId;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.sourceForBaike;
            if (r116 != null) goto L25;
            int r117 = 0;
        L26:
            int r118 = (r115 + r117) * 31;
            String r119 = this.ext;
            if (r119 != null) goto L29;
            int r120 = 0;
        L30:
            int r121 = (r118 + r120) * 31;
            String r122 = this.sourceType;
            if (r122 != null) goto L33;
            int r123 = 0;
        L34:
            int r124 = (r121 + r123) * 31;
            String r125 = this.docId;
            if (r125 == null) goto L39;
            r101 = r125.hashCode();
        L39:
            return r124 + r101;
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
            return "ReplaceReference(replaceText=" + this.replaceText + ", start=" + this.start + ", end=" + this.end + ", sourceFrom=" + this.sourceFrom + ", sourceId=" + this.sourceId + ", sourceForBaike=" + this.sourceForBaike + ", ext=" + this.ext + ", sourceType=" + this.sourceType + ", docId=" + this.docId + ')';
        }

        public final String a() {
            return this.docId;
        }

        public final Integer b() {
            return this.end;
        }

        public final String c() {
            return this.ext;
        }

        public final String d() {
            return this.replaceText;
        }

        public final String e() {
            return this.sourceForBaike;
        }

        public final Long f() {
            return this.sourceFrom;
        }

        public final String g() {
            return this.sourceId;
        }

        @Override // com.larus.im.bean.IMMetaInfo.d
        public final Integer getComparatorStartPos() {
            return this.start;
        }

        public final String h() {
            return this.sourceType;
        }

        public final Integer i() {
            return this.start;
        }
    }

    static {
        CREATOR = new b();
    }

    public IMMetaInfo() {
        this(0, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IMMetaInfo) == true) goto L8;
        return false;
    L8:
        IMMetaInfo r101 = (IMMetaInfo) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.info, r101.info) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.type;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.info;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "IMMetaInfo(type=" + this.type + ", info=" + this.info + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Integer r102 = this.type;
        if (r102 != null) goto L5;
        int r103 = 0;
    L6:
        r100.writeInt(r103);
        r100.writeString(this.info);
        return;
    L5:
        r100.writeInt(1);
        r103 = r102.intValue();
        goto L6
    }

    public final Integer getType() {
        return this.type;
    }

    public IMMetaInfo(Integer r100, String r101) {
        this.type = r100;
        this.info = r101;
    }
}
