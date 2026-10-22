package com.larus.uaigc.bean.createpage.component.sendmessage;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b1\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B¡\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\t\u00101\u001a\u00020\u0006HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\t\u00103\u001a\u00020\u0006HÆ\u0003J\t\u00104\u001a\u00020\u0006HÆ\u0003J£\u0001\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u0006HÆ\u0001J\u0013\u00106\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u000108HÖ\u0003J\t\u00109\u001a\u00020:HÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0011\u0010\u0012\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019¨\u0006<"}, d2 = {"Lcom/larus/uaigc/bean/createpage/component/sendmessage/CreationSendUiEvent;", "Ljava/io/Serializable;", "cvsId", "", "requestId", "closeCreationPager", "", "closeGalleryDialog", "switchToChatTab", "closeAttachmentPanel", "scrollToLatest", "setLastReadRestore", "endModify", "markChatListBottomReached", "notifyCoreInputEvent", "cacheMemorizedOptions", "closeBottomAlbumBeforeSend", "clearInputContentAfterSend", "hasAttachment", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZZZZZZZZZZZZ)V", "getCvsId", "()Ljava/lang/String;", "getRequestId", "getCloseCreationPager", "()Z", "getCloseGalleryDialog", "getSwitchToChatTab", "getCloseAttachmentPanel", "getScrollToLatest", "getSetLastReadRestore", "getEndModify", "getMarkChatListBottomReached", "getNotifyCoreInputEvent", "getCacheMemorizedOptions", "getCloseBottomAlbumBeforeSend", "getClearInputContentAfterSend", "getHasAttachment", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationSendUiEvent implements Serializable {
    private final boolean cacheMemorizedOptions;
    private final boolean clearInputContentAfterSend;
    private final boolean closeAttachmentPanel;
    private final boolean closeBottomAlbumBeforeSend;
    private final boolean closeCreationPager;
    private final boolean closeGalleryDialog;
    private final String cvsId;
    private final boolean endModify;
    private final boolean hasAttachment;
    private final boolean markChatListBottomReached;
    private final boolean notifyCoreInputEvent;
    private final String requestId;
    private final boolean scrollToLatest;
    private final boolean setLastReadRestore;
    private final boolean switchToChatTab;

    public CreationSendUiEvent() {
        this(null, null, false, false, false, false, false, false, false, false, false, false, false, false, false, 32767, null);
    }

    public static /* synthetic */ CreationSendUiEvent copy$default(CreationSendUiEvent r110, String r111, String r112, boolean r113, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, boolean r215, boolean r216, boolean r217, boolean r218, boolean r219, boolean r310, boolean r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        String r100 = r110.cvsId;
    L7:
        if ((r312 & 2) == 0) goto L9;
        String r101 = r110.requestId;
    L11:
        if ((r312 & 4) == 0) goto L13;
        boolean r102 = r110.closeCreationPager;
    L15:
        if ((r312 & 8) == 0) goto L17;
        boolean r103 = r110.closeGalleryDialog;
    L19:
        if ((r312 & 16) == 0) goto L21;
        boolean r104 = r110.switchToChatTab;
    L23:
        if ((r312 & 32) == 0) goto L25;
        boolean r105 = r110.closeAttachmentPanel;
    L27:
        if ((r312 & 64) == 0) goto L29;
        boolean r106 = r110.scrollToLatest;
    L31:
        if ((r312 & 128) == 0) goto L33;
        boolean r107 = r110.setLastReadRestore;
    L35:
        if ((r312 & 256) == 0) goto L37;
        boolean r114 = r110.endModify;
    L39:
        if ((r312 & 512) == 0) goto L41;
        boolean r115 = r110.markChatListBottomReached;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        boolean r116 = r110.notifyCoreInputEvent;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        boolean r117 = r110.cacheMemorizedOptions;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        boolean r118 = r110.closeBottomAlbumBeforeSend;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        boolean r119 = r110.clearInputContentAfterSend;
    L59:
        if ((r312 & 16384) == 0) goto L61;
        boolean r108 = r110.hasAttachment;
    L63:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r114, r115, r116, r117, r118, r119, r108);
    L61:
        r108 = r311;
        goto L63
    L57:
        r119 = r310;
        goto L59
    L53:
        r118 = r219;
        goto L55
    L49:
        r117 = r218;
        goto L51
    L45:
        r116 = r217;
        goto L47
    L41:
        r115 = r216;
        goto L43
    L37:
        r114 = r215;
        goto L39
    L33:
        r107 = r214;
        goto L35
    L29:
        r106 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
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
        return this.cvsId;
    }

    public final boolean component10() {
        return this.markChatListBottomReached;
    }

    public final boolean component11() {
        return this.notifyCoreInputEvent;
    }

    public final boolean component12() {
        return this.cacheMemorizedOptions;
    }

    public final boolean component13() {
        return this.closeBottomAlbumBeforeSend;
    }

    public final boolean component14() {
        return this.clearInputContentAfterSend;
    }

    public final boolean component15() {
        return this.hasAttachment;
    }

    public final String component2() {
        return this.requestId;
    }

    public final boolean component3() {
        return this.closeCreationPager;
    }

    public final boolean component4() {
        return this.closeGalleryDialog;
    }

    public final boolean component5() {
        return this.switchToChatTab;
    }

    public final boolean component6() {
        return this.closeAttachmentPanel;
    }

    public final boolean component7() {
        return this.scrollToLatest;
    }

    public final boolean component8() {
        return this.setLastReadRestore;
    }

    public final boolean component9() {
        return this.endModify;
    }

    public final CreationSendUiEvent copy(String r110, String r111, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, boolean r215, boolean r216, boolean r217, boolean r218, boolean r219, boolean r310, boolean r311, boolean r312) {
        return new CreationSendUiEvent(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CreationSendUiEvent) == true) goto L8;
        return false;
    L8:
        CreationSendUiEvent r101 = (CreationSendUiEvent) r100;
        if (Intrinsics.areEqual(this.cvsId, r101.cvsId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L15;
        return false;
    L15:
        if (this.closeCreationPager == r101.closeCreationPager) goto L18;
        return false;
    L18:
        if (this.closeGalleryDialog == r101.closeGalleryDialog) goto L21;
        return false;
    L21:
        if (this.switchToChatTab == r101.switchToChatTab) goto L24;
        return false;
    L24:
        if (this.closeAttachmentPanel == r101.closeAttachmentPanel) goto L27;
        return false;
    L27:
        if (this.scrollToLatest == r101.scrollToLatest) goto L30;
        return false;
    L30:
        if (this.setLastReadRestore == r101.setLastReadRestore) goto L33;
        return false;
    L33:
        if (this.endModify == r101.endModify) goto L36;
        return false;
    L36:
        if (this.markChatListBottomReached == r101.markChatListBottomReached) goto L39;
        return false;
    L39:
        if (this.notifyCoreInputEvent == r101.notifyCoreInputEvent) goto L42;
        return false;
    L42:
        if (this.cacheMemorizedOptions == r101.cacheMemorizedOptions) goto L45;
        return false;
    L45:
        if (this.closeBottomAlbumBeforeSend == r101.closeBottomAlbumBeforeSend) goto L48;
        return false;
    L48:
        if (this.clearInputContentAfterSend == r101.clearInputContentAfterSend) goto L51;
        return false;
    L51:
        if (this.hasAttachment == r101.hasAttachment) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        String r100 = this.cvsId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.requestId;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        int r106 = 1231;
        if (this.closeCreationPager == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r105 + r107) * 31;
        if (this.closeGalleryDialog == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (r108 + r109) * 31;
        if (this.switchToChatTab == false) goto L21;
        int r111 = 1231;
    L22:
        int r112 = (r110 + r111) * 31;
        if (this.closeAttachmentPanel == false) goto L25;
        int r113 = 1231;
    L26:
        int r114 = (r112 + r113) * 31;
        if (this.scrollToLatest == false) goto L29;
        int r115 = 1231;
    L30:
        int r116 = (r114 + r115) * 31;
        if (this.setLastReadRestore == false) goto L33;
        int r117 = 1231;
    L34:
        int r118 = (r116 + r117) * 31;
        if (this.endModify == false) goto L37;
        int r119 = 1231;
    L38:
        int r120 = (r118 + r119) * 31;
        if (this.markChatListBottomReached == false) goto L41;
        int r121 = 1231;
    L42:
        int r122 = (r120 + r121) * 31;
        if (this.notifyCoreInputEvent == false) goto L45;
        int r123 = 1231;
    L46:
        int r124 = (r122 + r123) * 31;
        if (this.cacheMemorizedOptions == false) goto L49;
        int r125 = 1231;
    L50:
        int r126 = (r124 + r125) * 31;
        if (this.closeBottomAlbumBeforeSend == false) goto L53;
        int r127 = 1231;
    L54:
        int r128 = (r126 + r127) * 31;
        if (this.clearInputContentAfterSend == false) goto L57;
        int r129 = 1231;
    L58:
        int r130 = (r128 + r129) * 31;
        if (this.hasAttachment == true) goto L63;
        r106 = 1237;
    L63:
        return r130 + r106;
    L57:
        r129 = 1237;
        goto L58
    L53:
        r127 = 1237;
        goto L54
    L49:
        r125 = 1237;
        goto L50
    L45:
        r123 = 1237;
        goto L46
    L41:
        r121 = 1237;
        goto L42
    L37:
        r119 = 1237;
        goto L38
    L33:
        r117 = 1237;
        goto L34
    L29:
        r115 = 1237;
        goto L30
    L25:
        r113 = 1237;
        goto L26
    L21:
        r111 = 1237;
        goto L22
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CreationSendUiEvent(cvsId=" + this.cvsId + ", requestId=" + this.requestId + ", closeCreationPager=" + this.closeCreationPager + ", closeGalleryDialog=" + this.closeGalleryDialog + ", switchToChatTab=" + this.switchToChatTab + ", closeAttachmentPanel=" + this.closeAttachmentPanel + ", scrollToLatest=" + this.scrollToLatest + ", setLastReadRestore=" + this.setLastReadRestore + ", endModify=" + this.endModify + ", markChatListBottomReached=" + this.markChatListBottomReached + ", notifyCoreInputEvent=" + this.notifyCoreInputEvent + ", cacheMemorizedOptions=" + this.cacheMemorizedOptions + ", closeBottomAlbumBeforeSend=" + this.closeBottomAlbumBeforeSend + ", clearInputContentAfterSend=" + this.clearInputContentAfterSend + ", hasAttachment=" + this.hasAttachment + ')';
    }

    public final boolean getCacheMemorizedOptions() {
        return this.cacheMemorizedOptions;
    }

    public final boolean getClearInputContentAfterSend() {
        return this.clearInputContentAfterSend;
    }

    public final boolean getCloseAttachmentPanel() {
        return this.closeAttachmentPanel;
    }

    public final boolean getCloseBottomAlbumBeforeSend() {
        return this.closeBottomAlbumBeforeSend;
    }

    public final boolean getCloseCreationPager() {
        return this.closeCreationPager;
    }

    public final boolean getCloseGalleryDialog() {
        return this.closeGalleryDialog;
    }

    public final String getCvsId() {
        return this.cvsId;
    }

    public final boolean getEndModify() {
        return this.endModify;
    }

    public final boolean getHasAttachment() {
        return this.hasAttachment;
    }

    public final boolean getMarkChatListBottomReached() {
        return this.markChatListBottomReached;
    }

    public final boolean getNotifyCoreInputEvent() {
        return this.notifyCoreInputEvent;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final boolean getScrollToLatest() {
        return this.scrollToLatest;
    }

    public final boolean getSetLastReadRestore() {
        return this.setLastReadRestore;
    }

    public final boolean getSwitchToChatTab() {
        return this.switchToChatTab;
    }

    public CreationSendUiEvent(String r100, String r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107, boolean r108, boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115) {
        this.cvsId = r100;
        this.requestId = r101;
        this.closeCreationPager = r102;
        this.closeGalleryDialog = r103;
        this.switchToChatTab = r104;
        this.closeAttachmentPanel = r105;
        this.scrollToLatest = r106;
        this.setLastReadRestore = r107;
        this.endModify = r108;
        this.markChatListBottomReached = r110;
        this.notifyCoreInputEvent = r111;
        this.cacheMemorizedOptions = r112;
        this.closeBottomAlbumBeforeSend = r113;
        this.clearInputContentAfterSend = r114;
        this.hasAttachment = r115;
    }

    public /* synthetic */ CreationSendUiEvent(String r110, String r111, boolean r112, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, boolean r215, boolean r216, boolean r217, boolean r218, boolean r219, boolean r310, boolean r311, int r312, DefaultConstructorMarker r313) {
        String r100 = null;
        if ((r312 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r312 & 2) != 0) goto L10;
        r100 = r111;
    L10:
        boolean r102 = false;
        if ((r312 & 4) == 0) goto L13;
        boolean r103 = false;
    L15:
        if ((r312 & 8) == 0) goto L17;
        boolean r104 = false;
    L19:
        if ((r312 & 16) == 0) goto L21;
        boolean r105 = false;
    L23:
        if ((r312 & 32) == 0) goto L25;
        boolean r106 = false;
    L27:
        if ((r312 & 64) == 0) goto L29;
        boolean r107 = false;
    L31:
        if ((r312 & 128) == 0) goto L33;
        boolean r108 = false;
    L35:
        if ((r312 & 256) == 0) goto L37;
        boolean r113 = false;
    L39:
        if ((r312 & 512) == 0) goto L41;
        boolean r114 = false;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        boolean r115 = false;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        boolean r116 = false;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        boolean r117 = false;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        boolean r118 = false;
    L59:
        if ((r312 & 16384) != 0) goto L62;
        r102 = r311;
    L62:
        this(r101, r100, r103, r104, r105, r106, r107, r108, r113, r114, r115, r116, r117, r118, r102);
        return;
    L57:
        r118 = r310;
        goto L59
    L53:
        r117 = r219;
        goto L55
    L49:
        r116 = r218;
        goto L51
    L45:
        r115 = r217;
        goto L47
    L41:
        r114 = r216;
        goto L43
    L37:
        r113 = r215;
        goto L39
    L33:
        r108 = r214;
        goto L35
    L29:
        r107 = r213;
        goto L31
    L25:
        r106 = r212;
        goto L27
    L21:
        r105 = r211;
        goto L23
    L17:
        r104 = r210;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L5:
        r101 = r110;
        goto L7
    }
}
