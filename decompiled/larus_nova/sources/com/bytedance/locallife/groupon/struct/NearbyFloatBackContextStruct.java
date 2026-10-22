package com.bytedance.locallife.groupon.struct;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b8\b\u0087\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0010J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00102\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001eJ\t\u00103\u001a\u00020\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00107\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00109\u001a\u00020\tHÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u008e\u0001\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010<J\u0013\u0010=\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020\tHÖ\u0001J\t\u0010@\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\r\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001e\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R\"\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b*\u0010\u001e\"\u0004\b+\u0010 R\"\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b,\u0010\u001e\"\u0004\b-\u0010 R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0016\"\u0004\b/\u0010\u0018¨\u0006A"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/NearbyFloatBackContextStruct;", "", "buttonType", "", "backHotFeed", "", ILiveRoomPlayFragmentConstant.EXTRA_BACK_URL, "text", "singleHiddenCount", "", "doubleHiddenCount", "closeSubType", "offsetFromBottom", "inactiveDisplay", IPerformanceManager.SCENE_RESIDENT, "shrinkCount", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBackHotFeed", "()Z", "setBackHotFeed", "(Z)V", "getBackUrl", "()Ljava/lang/String;", "setBackUrl", "(Ljava/lang/String;)V", "getButtonType", "setButtonType", "getCloseSubType", "setCloseSubType", "getDoubleHiddenCount", "()Ljava/lang/Integer;", "setDoubleHiddenCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getInactiveDisplay", "setInactiveDisplay", "getOffsetFromBottom", "()I", "setOffsetFromBottom", "(I)V", "getResident", "setResident", "getShrinkCount", "setShrinkCount", "getSingleHiddenCount", "setSingleHiddenCount", "getText", "setText", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/locallife/groupon/struct/NearbyFloatBackContextStruct;", "equals", "other", "hashCode", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class NearbyFloatBackContextStruct {

    @SerializedName("back_hot_feed")
    private boolean backHotFeed;

    @SerializedName("back_url")
    private String backUrl;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE)
    private String buttonType;

    @SerializedName("close_sub_page_type")
    private String closeSubType;

    @SerializedName("double_hidden_count")
    private Integer doubleHiddenCount;

    @SerializedName("inactive_display")
    private Integer inactiveDisplay;

    @SerializedName("offset_from_bottom")
    private int offsetFromBottom;

    @SerializedName(IPerformanceManager.SCENE_RESIDENT)
    private Integer resident;

    @SerializedName("shrink_count")
    private Integer shrinkCount;

    @SerializedName("single_hidden_count")
    private Integer singleHiddenCount;

    @SerializedName("text")
    private String text;

    public NearbyFloatBackContextStruct() {
        this(null, false, null, null, null, null, null, 0, null, null, null, 2047, null);
    }

    public static /* synthetic */ NearbyFloatBackContextStruct copy$default(NearbyFloatBackContextStruct r110, String r111, boolean r112, String r113, String r114, Integer r115, Integer r116, String r117, int r210, Integer r211, Integer r212, Integer r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = r110.buttonType;
    L7:
        if ((r214 & 2) == 0) goto L9;
        boolean r101 = r110.backHotFeed;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r102 = r110.backUrl;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r103 = r110.text;
    L19:
        if ((r214 & 16) == 0) goto L21;
        Integer r104 = r110.singleHiddenCount;
    L23:
        if ((r214 & 32) == 0) goto L25;
        Integer r105 = r110.doubleHiddenCount;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r106 = r110.closeSubType;
    L31:
        if ((r214 & 128) == 0) goto L33;
        int r107 = r110.offsetFromBottom;
    L35:
        if ((r214 & 256) == 0) goto L37;
        Integer r118 = r110.inactiveDisplay;
    L39:
        if ((r214 & 512) == 0) goto L41;
        Integer r119 = r110.resident;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        Integer r108 = r110.shrinkCount;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
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

    public final String component1() {
        return this.buttonType;
    }

    public final Integer component10() {
        return this.resident;
    }

    public final Integer component11() {
        return this.shrinkCount;
    }

    public final boolean component2() {
        return this.backHotFeed;
    }

    public final String component3() {
        return this.backUrl;
    }

    public final String component4() {
        return this.text;
    }

    public final Integer component5() {
        return this.singleHiddenCount;
    }

    public final Integer component6() {
        return this.doubleHiddenCount;
    }

    public final String component7() {
        return this.closeSubType;
    }

    public final int component8() {
        return this.offsetFromBottom;
    }

    public final Integer component9() {
        return this.inactiveDisplay;
    }

    public final NearbyFloatBackContextStruct copy(String r110, boolean r111, String r112, String r113, Integer r114, Integer r115, String r210, int r211, Integer r212, Integer r213, Integer r214) {
        return new NearbyFloatBackContextStruct(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NearbyFloatBackContextStruct) == true) goto L8;
        return false;
    L8:
        NearbyFloatBackContextStruct r101 = (NearbyFloatBackContextStruct) r100;
        if (Intrinsics.areEqual(this.buttonType, r101.buttonType) == true) goto L12;
        return false;
    L12:
        if (this.backHotFeed == r101.backHotFeed) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.backUrl, r101.backUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.singleHiddenCount, r101.singleHiddenCount) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.doubleHiddenCount, r101.doubleHiddenCount) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.closeSubType, r101.closeSubType) == true) goto L30;
        return false;
    L30:
        if (this.offsetFromBottom == r101.offsetFromBottom) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.inactiveDisplay, r101.inactiveDisplay) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.resident, r101.resident) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.shrinkCount, r101.shrinkCount) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        String r100 = this.buttonType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        if (this.backHotFeed == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        String r106 = this.backUrl;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        String r109 = this.text;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        Integer r112 = this.singleHiddenCount;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        Integer r115 = this.doubleHiddenCount;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        String r118 = this.closeSubType;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (((r117 + r119) * 31) + this.offsetFromBottom) * 31;
        Integer r121 = this.inactiveDisplay;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        Integer r124 = this.resident;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        Integer r127 = this.shrinkCount;
        if (r127 == null) goto L43;
        r101 = r127.hashCode();
    L43:
        return r126 + r101;
    L37:
        r125 = r124.hashCode();
        goto L38
    L33:
        r122 = r121.hashCode();
        goto L34
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "NearbyFloatBackContextStruct(buttonType=" + this.buttonType + ", backHotFeed=" + this.backHotFeed + ", backUrl=" + this.backUrl + ", text=" + this.text + ", singleHiddenCount=" + this.singleHiddenCount + ", doubleHiddenCount=" + this.doubleHiddenCount + ", closeSubType=" + this.closeSubType + ", offsetFromBottom=" + this.offsetFromBottom + ", inactiveDisplay=" + this.inactiveDisplay + ", resident=" + this.resident + ", shrinkCount=" + this.shrinkCount + ')';
    }

    public final boolean getBackHotFeed() {
        return this.backHotFeed;
    }

    public final String getBackUrl() {
        return this.backUrl;
    }

    public final String getButtonType() {
        return this.buttonType;
    }

    public final String getCloseSubType() {
        return this.closeSubType;
    }

    public final Integer getDoubleHiddenCount() {
        return this.doubleHiddenCount;
    }

    public final Integer getInactiveDisplay() {
        return this.inactiveDisplay;
    }

    public final int getOffsetFromBottom() {
        return this.offsetFromBottom;
    }

    public final Integer getResident() {
        return this.resident;
    }

    public final Integer getShrinkCount() {
        return this.shrinkCount;
    }

    public final Integer getSingleHiddenCount() {
        return this.singleHiddenCount;
    }

    public final String getText() {
        return this.text;
    }

    public final void setBackHotFeed(boolean r100) {
        this.backHotFeed = r100;
    }

    public final void setBackUrl(String r100) {
        this.backUrl = r100;
    }

    public final void setButtonType(String r100) {
        this.buttonType = r100;
    }

    public final void setCloseSubType(String r100) {
        this.closeSubType = r100;
    }

    public final void setDoubleHiddenCount(Integer r100) {
        this.doubleHiddenCount = r100;
    }

    public final void setInactiveDisplay(Integer r100) {
        this.inactiveDisplay = r100;
    }

    public final void setOffsetFromBottom(int r100) {
        this.offsetFromBottom = r100;
    }

    public final void setResident(Integer r100) {
        this.resident = r100;
    }

    public final void setShrinkCount(Integer r100) {
        this.shrinkCount = r100;
    }

    public final void setSingleHiddenCount(Integer r100) {
        this.singleHiddenCount = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public NearbyFloatBackContextStruct(String r100, boolean r101, String r102, String r103, Integer r104, Integer r105, String r106, int r107, Integer r108, Integer r110, Integer r111) {
        this.buttonType = r100;
        this.backHotFeed = r101;
        this.backUrl = r102;
        this.text = r103;
        this.singleHiddenCount = r104;
        this.doubleHiddenCount = r105;
        this.closeSubType = r106;
        this.offsetFromBottom = r107;
        this.inactiveDisplay = r108;
        this.resident = r110;
        this.shrinkCount = r111;
    }

    public /* synthetic */ NearbyFloatBackContextStruct(String r110, boolean r111, String r112, String r113, Integer r114, Integer r115, String r116, int r210, Integer r211, Integer r212, Integer r213, int r214, DefaultConstructorMarker r215) {
        Integer r100 = null;
        if ((r214 & 1) == 0) goto L5;
        String r101 = null;
    L6:
        int r102 = 0;
        if ((r214 & 2) == 0) goto L9;
        boolean r103 = false;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r214 & 16) == 0) goto L21;
        Integer r106 = null;
    L23:
        if ((r214 & 32) == 0) goto L25;
        Integer r107 = null;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r108 = null;
    L31:
        if ((r214 & 128) != 0) goto L35;
        r102 = r210;
    L35:
        if ((r214 & 256) == 0) goto L37;
        Integer r117 = null;
    L39:
        if ((r214 & 512) == 0) goto L41;
        Integer r118 = null;
    L43:
        if ((r214 & 1024) != 0) goto L46;
        r100 = r213;
    L46:
        this(r101, r103, r104, r105, r106, r107, r108, r102, r117, r118, r100);
        return;
    L41:
        r118 = r212;
        goto L43
    L37:
        r117 = r211;
        goto L39
    L29:
        r108 = r116;
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
