package com.larus.business.floatchat.impl.component;

import com.larus.bmhome.ability.FloatChatWindowEventType;
import com.larus.bmhome.ability.FloatChatWindowState;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003Je\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\nHÆ\u0001J\u0013\u0010(\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u0005HÖ\u0001J\t\u0010,\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001a¨\u0006-"}, d2 = {"Lcom/larus/business/floatchat/impl/component/AIFloatChatWindowStateVMState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "state", "Lcom/larus/bmhome/ability/FloatChatWindowState;", "heightPx", "", "showPercent", "from", "", "needAnim", "", "anchorMessage", "Lcom/larus/im/bean/message/Message;", "autoExpandedFromPreview", "isDynamicHeightSync", "isDragging", "<init>", "(Lcom/larus/bmhome/ability/FloatChatWindowState;IILjava/lang/String;ZLcom/larus/im/bean/message/Message;ZZZ)V", "getState", "()Lcom/larus/bmhome/ability/FloatChatWindowState;", "getHeightPx", "()I", "getShowPercent", "getFrom", "()Ljava/lang/String;", "getNeedAnim", "()Z", "getAnchorMessage", "()Lcom/larus/im/bean/message/Message;", "getAutoExpandedFromPreview", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIFloatChatWindowStateVMState implements w1a.b {
    private final Message anchorMessage;
    private final boolean autoExpandedFromPreview;
    private final String from;
    private final int heightPx;
    private final boolean isDragging;
    private final boolean isDynamicHeightSync;
    private final boolean needAnim;
    private final int showPercent;
    private final FloatChatWindowState state;

    public AIFloatChatWindowStateVMState() {
        this(null, 0, 0, null, false, null, false, false, false, 511, null);
    }

    public static /* synthetic */ AIFloatChatWindowStateVMState copy$default(AIFloatChatWindowStateVMState r110, FloatChatWindowState r111, int r112, int r113, String r114, boolean r115, Message r116, boolean r117, boolean r118, boolean r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        FloatChatWindowState r100 = r110.state;
    L7:
        if ((r210 & 2) == 0) goto L9;
        int r101 = r110.heightPx;
    L11:
        if ((r210 & 4) == 0) goto L13;
        int r102 = r110.showPercent;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.from;
    L19:
        if ((r210 & 16) == 0) goto L21;
        boolean r104 = r110.needAnim;
    L23:
        if ((r210 & 32) == 0) goto L25;
        Message r105 = r110.anchorMessage;
    L27:
        if ((r210 & 64) == 0) goto L29;
        boolean r106 = r110.autoExpandedFromPreview;
    L31:
        if ((r210 & 128) == 0) goto L33;
        boolean r107 = r110.isDynamicHeightSync;
    L35:
        if ((r210 & 256) == 0) goto L37;
        boolean r108 = r110.isDragging;
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

    public final FloatChatWindowState component1() {
        return this.state;
    }

    public final int component2() {
        return this.heightPx;
    }

    public final int component3() {
        return this.showPercent;
    }

    public final String component4() {
        return this.from;
    }

    public final boolean component5() {
        return this.needAnim;
    }

    public final Message component6() {
        return this.anchorMessage;
    }

    public final boolean component7() {
        return this.autoExpandedFromPreview;
    }

    public final boolean component8() {
        return this.isDynamicHeightSync;
    }

    public final boolean component9() {
        return this.isDragging;
    }

    public final AIFloatChatWindowStateVMState copy(FloatChatWindowState r110, int r111, int r112, String r113, boolean r114, Message r115, boolean r116, boolean r117, boolean r210) {
        Intrinsics.checkNotNullParameter(r110, "state");
        Intrinsics.checkNotNullParameter(r113, "from");
        return new AIFloatChatWindowStateVMState(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AIFloatChatWindowStateVMState) == true) goto L8;
        return false;
    L8:
        AIFloatChatWindowStateVMState r101 = (AIFloatChatWindowStateVMState) r100;
        if (this.state == r101.state) goto L12;
        return false;
    L12:
        if (this.heightPx == r101.heightPx) goto L15;
        return false;
    L15:
        if (this.showPercent == r101.showPercent) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.from, r101.from) == true) goto L21;
        return false;
    L21:
        if (this.needAnim == r101.needAnim) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.anchorMessage, r101.anchorMessage) == true) goto L27;
        return false;
    L27:
        if (this.autoExpandedFromPreview == r101.autoExpandedFromPreview) goto L30;
        return false;
    L30:
        if (this.isDynamicHeightSync == r101.isDynamicHeightSync) goto L33;
        return false;
    L33:
        if (this.isDragging == r101.isDragging) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((this.state.hashCode() * 31) + this.heightPx) * 31) + this.showPercent) * 31) + this.from.hashCode()) * 31;
        int r101 = 1231;
        if (this.needAnim == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        Message r104 = this.anchorMessage;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.autoExpandedFromPreview == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.isDynamicHeightSync == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (r108 + r109) * 31;
        if (this.isDragging == true) goto L23;
        r101 = 1237;
    L23:
        return r110 + r101;
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "AIFloatChatWindowStateVMState(state=" + this.state + ", heightPx=" + this.heightPx + ", showPercent=" + this.showPercent + ", from=" + this.from + ", needAnim=" + this.needAnim + ", anchorMessage=" + this.anchorMessage + ", autoExpandedFromPreview=" + this.autoExpandedFromPreview + ", isDynamicHeightSync=" + this.isDynamicHeightSync + ", isDragging=" + this.isDragging + ')';
    }

    public final Message getAnchorMessage() {
        return this.anchorMessage;
    }

    public final boolean getAutoExpandedFromPreview() {
        return this.autoExpandedFromPreview;
    }

    public final String getFrom() {
        return this.from;
    }

    public final int getHeightPx() {
        return this.heightPx;
    }

    public final boolean getNeedAnim() {
        return this.needAnim;
    }

    public final int getShowPercent() {
        return this.showPercent;
    }

    public final FloatChatWindowState getState() {
        return this.state;
    }

    public final boolean isDragging() {
        return this.isDragging;
    }

    public final boolean isDynamicHeightSync() {
        return this.isDynamicHeightSync;
    }

    public AIFloatChatWindowStateVMState(FloatChatWindowState r100, int r101, int r102, String r103, boolean r104, Message r105, boolean r106, boolean r107, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r103, "from");
        this.state = r100;
        this.heightPx = r101;
        this.showPercent = r102;
        this.from = r103;
        this.needAnim = r104;
        this.anchorMessage = r105;
        this.autoExpandedFromPreview = r106;
        this.isDynamicHeightSync = r107;
        this.isDragging = r110;
    }

    public /* synthetic */ AIFloatChatWindowStateVMState(FloatChatWindowState r110, int r111, int r112, String r113, boolean r114, Message r115, boolean r116, boolean r117, boolean r118, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 1) == 0) goto L5;
        FloatChatWindowState r100 = FloatChatWindowState.Collapsed;
    L6:
        boolean r101 = false;
        if ((r210 & 2) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r210 & 4) == 0) goto L13;
        int r103 = 0;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r104 = FloatChatWindowEventType.Init.getFrom();
    L19:
        if ((r210 & 16) == 0) goto L21;
        boolean r105 = false;
    L23:
        if ((r210 & 32) == 0) goto L25;
        Message r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        boolean r107 = false;
    L31:
        if ((r210 & 128) == 0) goto L33;
        boolean r108 = false;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r101 = r118;
    L38:
        this(r100, r102, r103, r104, r105, r106, r107, r108, r101);
        return;
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
        r100 = r110;
        goto L6
    }
}
