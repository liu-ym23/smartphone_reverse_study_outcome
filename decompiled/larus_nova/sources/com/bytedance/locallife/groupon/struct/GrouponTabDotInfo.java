package com.bytedance.locallife.groupon.struct;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b,\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\rHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jk\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u00107\u001a\u00020\r2\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\u0003HÖ\u0001J\t\u0010:\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR \u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006;"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/GrouponTabDotInfo;", "", "dotType", "", "dotText", "", "dotScene", "freKey", "freDuration", "", "logExtra", "dotAttribute", "needClearWhenUserChange", "", "nearbyGeneralBubble", "Lcom/bytedance/locallife/groupon/struct/GrouponGeneralBubbleStruct;", "(ILjava/lang/String;ILjava/lang/String;JLjava/lang/String;IZLcom/bytedance/locallife/groupon/struct/GrouponGeneralBubbleStruct;)V", "getDotAttribute", "()I", "setDotAttribute", "(I)V", "getDotScene", "setDotScene", "getDotText", "()Ljava/lang/String;", "setDotText", "(Ljava/lang/String;)V", "getDotType", "setDotType", "getFreDuration", "()J", "setFreDuration", "(J)V", "getFreKey", "setFreKey", "getLogExtra", "setLogExtra", "getNearbyGeneralBubble", "()Lcom/bytedance/locallife/groupon/struct/GrouponGeneralBubbleStruct;", "setNearbyGeneralBubble", "(Lcom/bytedance/locallife/groupon/struct/GrouponGeneralBubbleStruct;)V", "getNeedClearWhenUserChange", "()Z", "setNeedClearWhenUserChange", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class GrouponTabDotInfo {

    @SerializedName("dot_attribute")
    private int dotAttribute;

    @SerializedName("dot_scene")
    private int dotScene;

    @SerializedName("dot_text")
    private String dotText;

    @SerializedName("dot_type")
    private int dotType;

    @SerializedName("frequence_duration")
    private long freDuration;

    @SerializedName("frequence_key")
    private String freKey;

    @SerializedName("log_extra")
    private String logExtra;

    @SerializedName("nearby_general_bubble")
    private GrouponGeneralBubbleStruct nearbyGeneralBubble;

    @SerializedName("need_clear_when_user_change")
    private boolean needClearWhenUserChange;

    public GrouponTabDotInfo() {
        this(0, null, 0, null, 0, null, 0, false, null, 511, null);
    }

    public static /* synthetic */ GrouponTabDotInfo copy$default(GrouponTabDotInfo r110, int r111, String r112, int r113, String r114, long r115, String r116, int r117, boolean r210, GrouponGeneralBubbleStruct r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        int r100 = r110.dotType;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.dotText;
    L11:
        if ((r212 & 4) == 0) goto L13;
        int r102 = r110.dotScene;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.freKey;
    L19:
        if ((r212 & 16) == 0) goto L21;
        long r104 = r110.freDuration;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.logExtra;
    L27:
        if ((r212 & 64) == 0) goto L29;
        int r106 = r110.dotAttribute;
    L31:
        if ((r212 & 128) == 0) goto L33;
        boolean r118 = r110.needClearWhenUserChange;
    L35:
        if ((r212 & 256) == 0) goto L37;
        GrouponGeneralBubbleStruct r107 = r110.nearbyGeneralBubble;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r118, r107);
    L37:
        r107 = r211;
        goto L39
    L33:
        r118 = r210;
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

    public final int component1() {
        return this.dotType;
    }

    public final String component2() {
        return this.dotText;
    }

    public final int component3() {
        return this.dotScene;
    }

    public final String component4() {
        return this.freKey;
    }

    public final long component5() {
        return this.freDuration;
    }

    public final String component6() {
        return this.logExtra;
    }

    public final int component7() {
        return this.dotAttribute;
    }

    public final boolean component8() {
        return this.needClearWhenUserChange;
    }

    public final GrouponGeneralBubbleStruct component9() {
        return this.nearbyGeneralBubble;
    }

    public final GrouponTabDotInfo copy(int r110, String r111, int r112, String r113, long r114, String r115, int r210, boolean r211, GrouponGeneralBubbleStruct r212) {
        return new GrouponTabDotInfo(r110, r111, r112, r113, r114, r115, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GrouponTabDotInfo) == true) goto L8;
        return false;
    L8:
        GrouponTabDotInfo r101 = (GrouponTabDotInfo) r100;
        if (this.dotType == r101.dotType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.dotText, r101.dotText) == true) goto L15;
        return false;
    L15:
        if (this.dotScene == r101.dotScene) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.freKey, r101.freKey) == true) goto L21;
        return false;
    L21:
        if (this.freDuration == r101.freDuration) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.logExtra, r101.logExtra) == true) goto L27;
        return false;
    L27:
        if (this.dotAttribute == r101.dotAttribute) goto L30;
        return false;
    L30:
        if (this.needClearWhenUserChange == r101.needClearWhenUserChange) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.nearbyGeneralBubble, r101.nearbyGeneralBubble) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r100 = this.dotType * 31;
        String r101 = this.dotText;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.dotScene) * 31;
        String r105 = this.freKey;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        long r107 = this.freDuration;
        int r108 = (((r104 + r106) * 31) + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.logExtra;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (((r108 + r110) * 31) + this.dotAttribute) * 31;
        if (this.needClearWhenUserChange == false) goto L17;
        int r112 = 1231;
    L18:
        int r113 = (r111 + r112) * 31;
        GrouponGeneralBubbleStruct r114 = this.nearbyGeneralBubble;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = 1237;
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "GrouponTabDotInfo(dotType=" + this.dotType + ", dotText=" + this.dotText + ", dotScene=" + this.dotScene + ", freKey=" + this.freKey + ", freDuration=" + this.freDuration + ", logExtra=" + this.logExtra + ", dotAttribute=" + this.dotAttribute + ", needClearWhenUserChange=" + this.needClearWhenUserChange + ", nearbyGeneralBubble=" + this.nearbyGeneralBubble + ')';
    }

    public final int getDotAttribute() {
        return this.dotAttribute;
    }

    public final int getDotScene() {
        return this.dotScene;
    }

    public final String getDotText() {
        return this.dotText;
    }

    public final int getDotType() {
        return this.dotType;
    }

    public final long getFreDuration() {
        return this.freDuration;
    }

    public final String getFreKey() {
        return this.freKey;
    }

    public final String getLogExtra() {
        return this.logExtra;
    }

    public final GrouponGeneralBubbleStruct getNearbyGeneralBubble() {
        return this.nearbyGeneralBubble;
    }

    public final boolean getNeedClearWhenUserChange() {
        return this.needClearWhenUserChange;
    }

    public final void setDotAttribute(int r100) {
        this.dotAttribute = r100;
    }

    public final void setDotScene(int r100) {
        this.dotScene = r100;
    }

    public final void setDotText(String r100) {
        this.dotText = r100;
    }

    public final void setDotType(int r100) {
        this.dotType = r100;
    }

    public final void setFreDuration(long r100) {
        this.freDuration = r100;
    }

    public final void setFreKey(String r100) {
        this.freKey = r100;
    }

    public final void setLogExtra(String r100) {
        this.logExtra = r100;
    }

    public final void setNearbyGeneralBubble(GrouponGeneralBubbleStruct r100) {
        this.nearbyGeneralBubble = r100;
    }

    public final void setNeedClearWhenUserChange(boolean r100) {
        this.needClearWhenUserChange = r100;
    }

    public GrouponTabDotInfo(int r100, String r101, int r102, String r103, long r104, String r105, int r106, boolean r107, GrouponGeneralBubbleStruct r110) {
        this.dotType = r100;
        this.dotText = r101;
        this.dotScene = r102;
        this.freKey = r103;
        this.freDuration = r104;
        this.logExtra = r105;
        this.dotAttribute = r106;
        this.needClearWhenUserChange = r107;
        this.nearbyGeneralBubble = r110;
    }

    public /* synthetic */ GrouponTabDotInfo(int r110, String r111, int r112, String r113, long r114, String r115, int r210, boolean r211, GrouponGeneralBubbleStruct r212, int r213, DefaultConstructorMarker r214) {
        boolean r100 = false;
        if ((r213 & 1) == 0) goto L5;
        int r101 = 0;
    L6:
        GrouponGeneralBubbleStruct r102 = null;
        if ((r213 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r213 & 4) == 0) goto L13;
        int r104 = 0;
    L15:
        if ((r213 & 8) == 0) goto L17;
        String r105 = "";
    L19:
        if ((r213 & 16) == 0) goto L21;
        long r106 = Long.MAX_VALUE;
    L23:
        if ((r213 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r213 & 64) == 0) goto L29;
        int r116 = 0;
    L31:
        if ((r213 & 128) != 0) goto L35;
        r100 = r211;
    L35:
        if ((r213 & 256) != 0) goto L38;
        r102 = r212;
    L38:
        this(r101, r103, r104, r105, r106, r107, r116, r100, r102);
        return;
    L29:
        r116 = r210;
        goto L31
    L25:
        r107 = r115;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
