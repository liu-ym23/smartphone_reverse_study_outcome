package com.larus.chat.search.api.model;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010/\u001a\u00020\tHÂ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00102\u001a\u00020\rHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00104\u001a\u00020\tHÆ\u0003J\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0003J\u0089\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\t2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0001J\u0013\u00107\u001a\u00020\r2\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\tHÖ\u0001J\t\u0010:\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0010\u0010\b\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001dR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0016\u0010\u000f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u0004\u0018\u00010&8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006;"}, d2 = {"Lcom/larus/chat/search/api/model/SectionItemData;", "", "createTime", "", "sectionId", "", "conversationId", "sectionName", "_viewType", "", "localIndex", "messageId", "isSectionName", "", "url", "unreadCount", "urlJumpCallback", "Lkotlin/Function0;", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;ZLjava/lang/String;ILkotlin/jvm/functions/Function0;)V", "getCreateTime", "()J", "getSectionId", "()Ljava/lang/String;", "getConversationId", "getSectionName", "getLocalIndex", "getMessageId", "()Z", "getUrl", "getUnreadCount", "()I", "getUrlJumpCallback", "()Lkotlin/jvm/functions/Function0;", "setUrlJumpCallback", "(Lkotlin/jvm/functions/Function0;)V", "viewType", "Lcom/larus/chat/search/api/model/SectionViewType;", "getViewType", "()Lcom/larus/chat/search/api/model/SectionViewType;", "setViewType", "(Lcom/larus/chat/search/api/model/SectionViewType;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SectionItemData {

    @SerializedName(BytedCertConstant.IntentKey.VIEW_TYPE)
    private final int _viewType;

    @SerializedName("conversation_id")
    private final String conversationId;

    @SerializedName("create_time")
    private final long createTime;

    @SerializedName("is_section_name")
    private final boolean isSectionName;

    @SerializedName("local_index")
    private final long localIndex;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private final String messageId;

    @SerializedName("section_id")
    private final String sectionId;

    @SerializedName("section_name")
    private final String sectionName;

    @SerializedName("unread_count")
    private final int unreadCount;

    @SerializedName("url")
    private final String url;
    private transient Function0<Unit> urlJumpCallback;
    private SectionViewType viewType;

    public SectionItemData() {
        this(0, null, null, null, 0, 0, null, false, null, 0, null, 2047, null);
    }

    private final int component5() {
        return this._viewType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SectionItemData copy$default(SectionItemData r110, long r111, String r112, String r113, String r114, int r210, long r211, String r212, boolean r213, String r214, int r215, Function0 r216, int r217, Object r218) {
        if ((r217 & 1) == 0) goto L5;
        long r100 = r110.createTime;
    L7:
        if ((r217 & 2) == 0) goto L9;
        String r101 = r110.sectionId;
    L11:
        if ((r217 & 4) == 0) goto L13;
        String r102 = r110.conversationId;
    L15:
        if ((r217 & 8) == 0) goto L17;
        String r103 = r110.sectionName;
    L19:
        if ((r217 & 16) == 0) goto L21;
        int r104 = r110._viewType;
    L23:
        if ((r217 & 32) == 0) goto L25;
        long r105 = r110.localIndex;
    L27:
        if ((r217 & 64) == 0) goto L29;
        String r115 = r110.messageId;
    L31:
        if ((r217 & 128) == 0) goto L33;
        boolean r116 = r110.isSectionName;
    L35:
        if ((r217 & 256) == 0) goto L37;
        String r117 = r110.url;
    L39:
        if ((r217 & 512) == 0) goto L41;
        int r118 = r110.unreadCount;
    L43:
        if ((r217 & 1024) == 0) goto L45;
        Function0 r106 = r110.urlJumpCallback;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r115, r116, r117, r118, r106);
    L45:
        r106 = r216;
        goto L47
    L41:
        r118 = r215;
        goto L43
    L37:
        r117 = r214;
        goto L39
    L33:
        r116 = r213;
        goto L35
    L29:
        r115 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
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

    public final long component1() {
        return this.createTime;
    }

    public final int component10() {
        return this.unreadCount;
    }

    public final Function0<Unit> component11() {
        return this.urlJumpCallback;
    }

    public final String component2() {
        return this.sectionId;
    }

    public final String component3() {
        return this.conversationId;
    }

    public final String component4() {
        return this.sectionName;
    }

    public final long component6() {
        return this.localIndex;
    }

    public final String component7() {
        return this.messageId;
    }

    public final boolean component8() {
        return this.isSectionName;
    }

    public final String component9() {
        return this.url;
    }

    public final SectionItemData copy(long r110, String r111, String r112, String r210, int r211, long r212, String r213, boolean r214, String r215, int r216, Function0<Unit> r217) {
        return new SectionItemData(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SectionItemData) == true) goto L8;
        return false;
    L8:
        SectionItemData r101 = (SectionItemData) r100;
        if (this.createTime == r101.createTime) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sectionId, r101.sectionId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.sectionName, r101.sectionName) == true) goto L21;
        return false;
    L21:
        if (this._viewType == r101._viewType) goto L24;
        return false;
    L24:
        if (this.localIndex == r101.localIndex) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L30;
        return false;
    L30:
        if (this.isSectionName == r101.isSectionName) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L36;
        return false;
    L36:
        if (this.unreadCount == r101.unreadCount) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.urlJumpCallback, r101.urlJumpCallback) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        long r100 = this.createTime;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.sectionId;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.conversationId;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.sectionName;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (((r108 + r110) * 31) + this._viewType) * 31;
        long r112 = this.localIndex;
        int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        String r114 = this.messageId;
        if (r114 != null) goto L17;
        int r115 = 0;
    L18:
        int r116 = (r113 + r115) * 31;
        if (this.isSectionName == false) goto L21;
        int r117 = 1231;
    L22:
        int r118 = (r116 + r117) * 31;
        String r119 = this.url;
        if (r119 != null) goto L25;
        int r120 = 0;
    L26:
        int r121 = (((r118 + r120) * 31) + this.unreadCount) * 31;
        Function0<Unit> r122 = this.urlJumpCallback;
        if (r122 == null) goto L31;
        r103 = r122.hashCode();
    L31:
        return r121 + r103;
    L25:
        r120 = r119.hashCode();
        goto L26
    L21:
        r117 = 1237;
        goto L22
    L17:
        r115 = r114.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public String toString() {
        return "SectionItemData(createTime=" + this.createTime + ", sectionId=" + this.sectionId + ", conversationId=" + this.conversationId + ", sectionName=" + this.sectionName + ", _viewType=" + this._viewType + ", localIndex=" + this.localIndex + ", messageId=" + this.messageId + ", isSectionName=" + this.isSectionName + ", url=" + this.url + ", unreadCount=" + this.unreadCount + ", urlJumpCallback=" + this.urlJumpCallback + ')';
    }

    public final SectionViewType getViewType() {
        SectionViewType.a r100 = SectionViewType.Companion;
        int r101 = this._viewType;
        r100.getClass();
        return SectionViewType.a.a(r101);
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final long getLocalIndex() {
        return this.localIndex;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getSectionId() {
        return this.sectionId;
    }

    public final String getSectionName() {
        return this.sectionName;
    }

    public final int getUnreadCount() {
        return this.unreadCount;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Function0<Unit> getUrlJumpCallback() {
        return this.urlJumpCallback;
    }

    public final boolean isSectionName() {
        return this.isSectionName;
    }

    public final void setUrlJumpCallback(Function0<Unit> r100) {
        this.urlJumpCallback = r100;
    }

    public final void setViewType(SectionViewType r100) {
        this.viewType = r100;
    }

    public SectionItemData(long r100, String r101, String r102, String r103, int r104, long r105, String r106, boolean r110, String r111, int r112, Function0<Unit> r113) {
        this.createTime = r100;
        this.sectionId = r101;
        this.conversationId = r102;
        this.sectionName = r103;
        this._viewType = r104;
        this.localIndex = r105;
        this.messageId = r106;
        this.isSectionName = r110;
        this.url = r111;
        this.unreadCount = r112;
        this.urlJumpCallback = r113;
        this.viewType = SectionViewType.EMPTY;
    }

    public /* synthetic */ SectionItemData(long r110, String r111, String r112, String r113, int r210, long r211, String r212, boolean r213, String r214, int r215, Function0 r216, int r217, DefaultConstructorMarker r218) {
        long r100 = -1;
        if ((r217 & 1) == 0) goto L5;
        long r101 = -1;
    L6:
        String r102 = "";
        if ((r217 & 2) == 0) goto L9;
        String r103 = "";
    L11:
        if ((r217 & 4) == 0) goto L13;
        String r104 = "";
    L15:
        if ((r217 & 8) == 0) goto L17;
        String r105 = "";
    L19:
        if ((r217 & 16) == 0) goto L21;
        int r106 = -1;
    L23:
        if ((r217 & 32) != 0) goto L27;
        r100 = r211;
    L27:
        if ((r217 & 64) == 0) goto L29;
        String r114 = "";
    L30:
        int r115 = 0;
        if ((r217 & 128) == 0) goto L33;
        boolean r116 = false;
    L35:
        if ((r217 & 256) != 0) goto L39;
        r102 = r214;
    L39:
        if ((r217 & 512) != 0) goto L43;
        r115 = r215;
    L43:
        if ((r217 & 1024) == 0) goto L45;
        Function0 r107 = null;
    L46:
        this(r101, r103, r104, r105, r106, r100, r114, r116, r102, r115, r107);
        return;
    L45:
        r107 = r216;
        goto L46
    L33:
        r116 = r213;
        goto L35
    L29:
        r114 = r212;
        goto L30
    L21:
        r106 = r210;
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
