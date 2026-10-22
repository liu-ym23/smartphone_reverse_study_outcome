package com.larus.platform.model.chat;

import com.google.gson.annotations.SerializedName;
import com.larus.platform.service.e2;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b \n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u001a\u001a\u00020\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003JY\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006)"}, d2 = {"Lcom/larus/platform/model/chat/ChatAwemeFeedConfig;", "", "supportFullScreen", "", "entryMode", "", "cardLocationRatio", "", "padSupportInfiniteFlow", "fullScreenHideActionBar", "supportFullScreenNavi", "shouldFullyDisplay", "revertAlignTopView", "<init>", "(ZIFZZZZZ)V", "getSupportFullScreen", "()Z", "getEntryMode", "()I", "getCardLocationRatio", "()F", "getPadSupportInfiniteFlow", "getFullScreenHideActionBar", "getSupportFullScreenNavi", "getShouldFullyDisplay", "getRevertAlignTopView", "canEntryAwemeFeed", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatAwemeFeedConfig {

    @SerializedName("card_location_ratio")
    private final float cardLocationRatio;

    @SerializedName("entry_mode")
    private final int entryMode;

    @SerializedName("full_screen_hide_action_bar")
    private final boolean fullScreenHideActionBar;

    @SerializedName("pad_support_infinite_flow")
    private final boolean padSupportInfiniteFlow;

    @SerializedName("revert_align_top_view")
    private final boolean revertAlignTopView;

    @SerializedName("should_fully_display")
    private final boolean shouldFullyDisplay;

    @SerializedName("support_full_screen")
    private final boolean supportFullScreen;

    @SerializedName("support_full_screen_navi")
    private final boolean supportFullScreenNavi;

    public ChatAwemeFeedConfig() {
        this(false, 0, 0.0f, false, false, false, false, false, 255, null);
    }

    public static /* synthetic */ ChatAwemeFeedConfig copy$default(ChatAwemeFeedConfig r100, boolean r110, int r111, float r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        boolean r101 = r100.supportFullScreen;
    L7:
        if ((r118 & 2) == 0) goto L9;
        int r102 = r100.entryMode;
    L11:
        if ((r118 & 4) == 0) goto L13;
        float r103 = r100.cardLocationRatio;
    L15:
        if ((r118 & 8) == 0) goto L17;
        boolean r104 = r100.padSupportInfiniteFlow;
    L19:
        if ((r118 & 16) == 0) goto L21;
        boolean r105 = r100.fullScreenHideActionBar;
    L23:
        if ((r118 & 32) == 0) goto L25;
        boolean r106 = r100.supportFullScreenNavi;
    L27:
        if ((r118 & 64) == 0) goto L29;
        boolean r107 = r100.shouldFullyDisplay;
    L31:
        if ((r118 & 128) == 0) goto L33;
        boolean r108 = r100.revertAlignTopView;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
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
        r101 = r110;
        goto L7
    }

    public final boolean component1() {
        return this.supportFullScreen;
    }

    public final int component2() {
        return this.entryMode;
    }

    public final float component3() {
        return this.cardLocationRatio;
    }

    public final boolean component4() {
        return this.padSupportInfiniteFlow;
    }

    public final boolean component5() {
        return this.fullScreenHideActionBar;
    }

    public final boolean component6() {
        return this.supportFullScreenNavi;
    }

    public final boolean component7() {
        return this.shouldFullyDisplay;
    }

    public final boolean component8() {
        return this.revertAlignTopView;
    }

    public final ChatAwemeFeedConfig copy(boolean r110, int r111, float r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r117) {
        return new ChatAwemeFeedConfig(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatAwemeFeedConfig) == true) goto L8;
        return false;
    L8:
        ChatAwemeFeedConfig r101 = (ChatAwemeFeedConfig) r100;
        if (this.supportFullScreen == r101.supportFullScreen) goto L12;
        return false;
    L12:
        if (this.entryMode == r101.entryMode) goto L15;
        return false;
    L15:
        if (Float.compare(this.cardLocationRatio, r101.cardLocationRatio) == 0) goto L18;
        return false;
    L18:
        if (this.padSupportInfiniteFlow == r101.padSupportInfiniteFlow) goto L21;
        return false;
    L21:
        if (this.fullScreenHideActionBar == r101.fullScreenHideActionBar) goto L24;
        return false;
    L24:
        if (this.supportFullScreenNavi == r101.supportFullScreenNavi) goto L27;
        return false;
    L27:
        if (this.shouldFullyDisplay == r101.shouldFullyDisplay) goto L30;
        return false;
    L30:
        if (this.revertAlignTopView == r101.revertAlignTopView) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.supportFullScreen == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((r101 * 31) + this.entryMode) * 31) + Float.floatToIntBits(this.cardLocationRatio)) * 31;
        if (this.padSupportInfiniteFlow == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.fullScreenHideActionBar == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.supportFullScreenNavi == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.shouldFullyDisplay == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.revertAlignTopView == true) goto L27;
        r100 = 1237;
    L27:
        return r110 + r100;
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "ChatAwemeFeedConfig(supportFullScreen=" + this.supportFullScreen + ", entryMode=" + this.entryMode + ", cardLocationRatio=" + this.cardLocationRatio + ", padSupportInfiniteFlow=" + this.padSupportInfiniteFlow + ", fullScreenHideActionBar=" + this.fullScreenHideActionBar + ", supportFullScreenNavi=" + this.supportFullScreenNavi + ", shouldFullyDisplay=" + this.shouldFullyDisplay + ", revertAlignTopView=" + this.revertAlignTopView + ')';
    }

    public final boolean canEntryAwemeFeed() {
        if (this.entryMode == ChatAwemeFeedEntryMode.DIRECT_SLIDE.getValue()) goto L7;
        if (this.entryMode == ChatAwemeFeedEntryMode.VIEW_MORE.getValue()) goto L7;
    L11:
        return false;
    L7:
        if (e2.f365734a.isPad() == true) goto L9;
    L12:
        return true;
    L9:
        if (this.padSupportInfiniteFlow == false) goto L11;
        goto L11
    }

    public final float getCardLocationRatio() {
        return this.cardLocationRatio;
    }

    public final int getEntryMode() {
        return this.entryMode;
    }

    public final boolean getFullScreenHideActionBar() {
        return this.fullScreenHideActionBar;
    }

    public final boolean getPadSupportInfiniteFlow() {
        return this.padSupportInfiniteFlow;
    }

    public final boolean getRevertAlignTopView() {
        return this.revertAlignTopView;
    }

    public final boolean getShouldFullyDisplay() {
        return this.shouldFullyDisplay;
    }

    public final boolean getSupportFullScreen() {
        return this.supportFullScreen;
    }

    public final boolean getSupportFullScreenNavi() {
        return this.supportFullScreenNavi;
    }

    public ChatAwemeFeedConfig(boolean r100, int r101, float r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107) {
        this.supportFullScreen = r100;
        this.entryMode = r101;
        this.cardLocationRatio = r102;
        this.padSupportInfiniteFlow = r103;
        this.fullScreenHideActionBar = r104;
        this.supportFullScreenNavi = r105;
        this.shouldFullyDisplay = r106;
        this.revertAlignTopView = r107;
    }

    public /* synthetic */ ChatAwemeFeedConfig(boolean r110, int r111, float r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r117, int r118, DefaultConstructorMarker r119) {
        boolean r100 = false;
        if ((r118 & 1) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r118 & 2) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r118 & 4) == 0) goto L13;
        float r103 = 1.2f;
    L15:
        if ((r118 & 8) == 0) goto L17;
        boolean r104 = false;
    L19:
        if ((r118 & 16) == 0) goto L21;
        boolean r105 = false;
    L23:
        if ((r118 & 32) == 0) goto L25;
        boolean r106 = false;
    L27:
        if ((r118 & 64) == 0) goto L29;
        boolean r107 = true;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
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
        r101 = r110;
        goto L7
    }
}
