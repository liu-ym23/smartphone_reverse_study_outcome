package com.larus.canvas.service.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B¹\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\t\u00102\u001a\u00020\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003J»\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020FHÖ\u0001J\t\u0010G\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001eR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001e¨\u0006H"}, d2 = {"Lcom/larus/canvas/service/bean/OptionItem;", "", "id", "", "displayText", "", "messageText", "icon", "Lcom/larus/canvas/service/bean/Icon;", "darkModeIcon", "extra", "Lcom/larus/canvas/service/bean/OptionExtra;", "redirectSchema", "maskUri", "Lcom/larus/canvas/service/bean/MaskUri;", "paramFilterConf", "Lcom/larus/canvas/service/bean/ParamFilterConf;", "msgPromptConf", "Lcom/larus/canvas/service/bean/MsgPromptConf;", "iconOri", "Lcom/larus/canvas/service/bean/ImageInfo;", "previewIcon", "language", "sourceMessageText", "targetMessageText", "<init>", "(JLjava/lang/String;Ljava/lang/String;Lcom/larus/canvas/service/bean/Icon;Lcom/larus/canvas/service/bean/Icon;Lcom/larus/canvas/service/bean/OptionExtra;Ljava/lang/String;Lcom/larus/canvas/service/bean/MaskUri;Lcom/larus/canvas/service/bean/ParamFilterConf;Lcom/larus/canvas/service/bean/MsgPromptConf;Lcom/larus/canvas/service/bean/ImageInfo;Lcom/larus/canvas/service/bean/ImageInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getDisplayText", "()Ljava/lang/String;", "getMessageText", "getIcon", "()Lcom/larus/canvas/service/bean/Icon;", "getDarkModeIcon", "getExtra", "()Lcom/larus/canvas/service/bean/OptionExtra;", "getRedirectSchema", "getMaskUri", "()Lcom/larus/canvas/service/bean/MaskUri;", "getParamFilterConf", "()Lcom/larus/canvas/service/bean/ParamFilterConf;", "getMsgPromptConf", "()Lcom/larus/canvas/service/bean/MsgPromptConf;", "getIconOri", "()Lcom/larus/canvas/service/bean/ImageInfo;", "getPreviewIcon", "getLanguage", "getSourceMessageText", "getTargetMessageText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OptionItem {

    @SerializedName("dark_mode_icon")
    private final Icon darkModeIcon;

    @SerializedName("display_text")
    private final String displayText;

    @SerializedName("extra")
    private final OptionExtra extra;

    @SerializedName("icon")
    private final Icon icon;

    @SerializedName("icon_ori")
    private final ImageInfo iconOri;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final long f323829id;

    @SerializedName("language")
    private final String language;

    @SerializedName("mask_uri")
    private final MaskUri maskUri;

    @SerializedName(TTDelegateActivity.MESSAGE_TEXT)
    private final String messageText;

    @SerializedName("msg_prompt_conf")
    private final MsgPromptConf msgPromptConf;

    @SerializedName("param_filter_conf")
    private final ParamFilterConf paramFilterConf;

    @SerializedName("preview_icon")
    private final ImageInfo previewIcon;

    @SerializedName("redirect_schema")
    private final String redirectSchema;

    @SerializedName("source_message_text")
    private final String sourceMessageText;

    @SerializedName("target_message_text")
    private final String targetMessageText;

    public OptionItem() {
        this(0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    public static /* synthetic */ OptionItem copy$default(OptionItem r110, long r111, String r112, String r210, Icon r211, Icon r212, OptionExtra r213, String r214, MaskUri r215, ParamFilterConf r216, MsgPromptConf r217, ImageInfo r218, ImageInfo r219, String r310, String r311, String r312, int r313, Object r314) {
        if ((r313 & 1) == 0) goto L5;
        long r100 = r110.f323829id;
    L7:
        if ((r313 & 2) == 0) goto L9;
        String r101 = r110.displayText;
    L11:
        if ((r313 & 4) == 0) goto L13;
        String r102 = r110.messageText;
    L15:
        if ((r313 & 8) == 0) goto L17;
        Icon r103 = r110.icon;
    L19:
        if ((r313 & 16) == 0) goto L21;
        Icon r104 = r110.darkModeIcon;
    L23:
        if ((r313 & 32) == 0) goto L25;
        OptionExtra r105 = r110.extra;
    L27:
        if ((r313 & 64) == 0) goto L29;
        String r106 = r110.redirectSchema;
    L31:
        if ((r313 & 128) == 0) goto L33;
        MaskUri r113 = r110.maskUri;
    L35:
        if ((r313 & 256) == 0) goto L37;
        ParamFilterConf r114 = r110.paramFilterConf;
    L39:
        if ((r313 & 512) == 0) goto L41;
        MsgPromptConf r115 = r110.msgPromptConf;
    L43:
        if ((r313 & 1024) == 0) goto L45;
        ImageInfo r116 = r110.iconOri;
    L47:
        if ((r313 & 2048) == 0) goto L49;
        ImageInfo r117 = r110.previewIcon;
    L51:
        if ((r313 & 4096) == 0) goto L53;
        String r118 = r110.language;
    L54:
        String r315 = r118;
        if ((r313 & 8192) == 0) goto L57;
        String r119 = r110.sourceMessageText;
    L59:
        if ((r313 & 16384) == 0) goto L61;
        String r107 = r110.targetMessageText;
    L63:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r113, r114, r115, r116, r117, r315, r119, r107);
    L61:
        r107 = r312;
        goto L63
    L57:
        r119 = r311;
        goto L59
    L53:
        r118 = r310;
        goto L54
    L49:
        r117 = r219;
        goto L51
    L45:
        r116 = r218;
        goto L47
    L41:
        r115 = r217;
        goto L43
    L37:
        r114 = r216;
        goto L39
    L33:
        r113 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final long component1() {
        return this.f323829id;
    }

    public final MsgPromptConf component10() {
        return this.msgPromptConf;
    }

    public final ImageInfo component11() {
        return this.iconOri;
    }

    public final ImageInfo component12() {
        return this.previewIcon;
    }

    public final String component13() {
        return this.language;
    }

    public final String component14() {
        return this.sourceMessageText;
    }

    public final String component15() {
        return this.targetMessageText;
    }

    public final String component2() {
        return this.displayText;
    }

    public final String component3() {
        return this.messageText;
    }

    public final Icon component4() {
        return this.icon;
    }

    public final Icon component5() {
        return this.darkModeIcon;
    }

    public final OptionExtra component6() {
        return this.extra;
    }

    public final String component7() {
        return this.redirectSchema;
    }

    public final MaskUri component8() {
        return this.maskUri;
    }

    public final ParamFilterConf component9() {
        return this.paramFilterConf;
    }

    public final OptionItem copy(long r110, String r210, String r211, Icon r212, Icon r213, OptionExtra r214, String r215, MaskUri r216, ParamFilterConf r217, MsgPromptConf r218, ImageInfo r310, ImageInfo r311, String r312, String r313, String r314) {
        return new OptionItem(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OptionItem) == true) goto L8;
        return false;
    L8:
        OptionItem r101 = (OptionItem) r100;
        if (this.f323829id == r101.f323829id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.displayText, r101.displayText) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.messageText, r101.messageText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.darkModeIcon, r101.darkModeIcon) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.redirectSchema, r101.redirectSchema) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.maskUri, r101.maskUri) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.paramFilterConf, r101.paramFilterConf) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.msgPromptConf, r101.msgPromptConf) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.iconOri, r101.iconOri) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.previewIcon, r101.previewIcon) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.language, r101.language) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.sourceMessageText, r101.sourceMessageText) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.targetMessageText, r101.targetMessageText) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        long r100 = this.f323829id;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.displayText;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.messageText;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        Icon r109 = this.icon;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        Icon r112 = this.darkModeIcon;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        OptionExtra r115 = this.extra;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        int r117 = (r114 + r116) * 31;
        String r118 = this.redirectSchema;
        if (r118 != null) goto L25;
        int r119 = 0;
    L26:
        int r120 = (r117 + r119) * 31;
        MaskUri r121 = this.maskUri;
        if (r121 != null) goto L29;
        int r122 = 0;
    L30:
        int r123 = (r120 + r122) * 31;
        ParamFilterConf r124 = this.paramFilterConf;
        if (r124 != null) goto L33;
        int r125 = 0;
    L34:
        int r126 = (r123 + r125) * 31;
        MsgPromptConf r127 = this.msgPromptConf;
        if (r127 != null) goto L37;
        int r128 = 0;
    L38:
        int r129 = (r126 + r128) * 31;
        ImageInfo r130 = this.iconOri;
        if (r130 != null) goto L41;
        int r131 = 0;
    L42:
        int r132 = (r129 + r131) * 31;
        ImageInfo r133 = this.previewIcon;
        if (r133 != null) goto L45;
        int r134 = 0;
    L46:
        int r135 = (r132 + r134) * 31;
        String r136 = this.language;
        if (r136 != null) goto L49;
        int r137 = 0;
    L50:
        int r138 = (r135 + r137) * 31;
        String r139 = this.sourceMessageText;
        if (r139 != null) goto L53;
        int r140 = 0;
    L54:
        int r141 = (r138 + r140) * 31;
        String r142 = this.targetMessageText;
        if (r142 == null) goto L59;
        r103 = r142.hashCode();
    L59:
        return r141 + r103;
    L53:
        r140 = r139.hashCode();
        goto L54
    L49:
        r137 = r136.hashCode();
        goto L50
    L45:
        r134 = r133.hashCode();
        goto L46
    L41:
        r131 = r130.hashCode();
        goto L42
    L37:
        r128 = r127.hashCode();
        goto L38
    L33:
        r125 = r124.hashCode();
        goto L34
    L29:
        r122 = r121.hashCode();
        goto L30
    L25:
        r119 = r118.hashCode();
        goto L26
    L21:
        r116 = r115.hashCode();
        goto L22
    L17:
        r113 = r112.hashCode();
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
        return "OptionItem(id=" + this.f323829id + ", displayText=" + this.displayText + ", messageText=" + this.messageText + ", icon=" + this.icon + ", darkModeIcon=" + this.darkModeIcon + ", extra=" + this.extra + ", redirectSchema=" + this.redirectSchema + ", maskUri=" + this.maskUri + ", paramFilterConf=" + this.paramFilterConf + ", msgPromptConf=" + this.msgPromptConf + ", iconOri=" + this.iconOri + ", previewIcon=" + this.previewIcon + ", language=" + this.language + ", sourceMessageText=" + this.sourceMessageText + ", targetMessageText=" + this.targetMessageText + ')';
    }

    public final Icon getDarkModeIcon() {
        return this.darkModeIcon;
    }

    public final String getDisplayText() {
        return this.displayText;
    }

    public final OptionExtra getExtra() {
        return this.extra;
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final ImageInfo getIconOri() {
        return this.iconOri;
    }

    public final long getId() {
        return this.f323829id;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final MaskUri getMaskUri() {
        return this.maskUri;
    }

    public final String getMessageText() {
        return this.messageText;
    }

    public final MsgPromptConf getMsgPromptConf() {
        return this.msgPromptConf;
    }

    public final ParamFilterConf getParamFilterConf() {
        return this.paramFilterConf;
    }

    public final ImageInfo getPreviewIcon() {
        return this.previewIcon;
    }

    public final String getRedirectSchema() {
        return this.redirectSchema;
    }

    public final String getSourceMessageText() {
        return this.sourceMessageText;
    }

    public final String getTargetMessageText() {
        return this.targetMessageText;
    }

    public OptionItem(long r100, String r101, String r102, Icon r103, Icon r104, OptionExtra r110, String r111, MaskUri r112, ParamFilterConf r113, MsgPromptConf r114, ImageInfo r115, ImageInfo r116, String r117, String r118, String r119) {
        this.f323829id = r100;
        this.displayText = r101;
        this.messageText = r102;
        this.icon = r103;
        this.darkModeIcon = r104;
        this.extra = r110;
        this.redirectSchema = r111;
        this.maskUri = r112;
        this.paramFilterConf = r113;
        this.msgPromptConf = r114;
        this.iconOri = r115;
        this.previewIcon = r116;
        this.language = r117;
        this.sourceMessageText = r118;
        this.targetMessageText = r119;
    }

    public /* synthetic */ OptionItem(long r110, String r111, String r210, Icon r211, Icon r212, OptionExtra r213, String r214, MaskUri r215, ParamFilterConf r216, MsgPromptConf r217, ImageInfo r218, ImageInfo r219, String r310, String r311, String r312, int r313, DefaultConstructorMarker r314) {
        if ((r313 & 1) == 0) goto L5;
        long r100 = 0;
    L7:
        if ((r313 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r313 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r313 & 8) == 0) goto L17;
        Icon r103 = null;
    L19:
        if ((r313 & 16) == 0) goto L21;
        Icon r104 = null;
    L23:
        if ((r313 & 32) == 0) goto L25;
        OptionExtra r105 = null;
    L27:
        if ((r313 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r313 & 128) == 0) goto L33;
        MaskUri r112 = null;
    L35:
        if ((r313 & 256) == 0) goto L37;
        ParamFilterConf r113 = null;
    L39:
        if ((r313 & 512) == 0) goto L41;
        MsgPromptConf r114 = null;
    L43:
        if ((r313 & 1024) == 0) goto L45;
        ImageInfo r115 = null;
    L47:
        if ((r313 & 2048) == 0) goto L49;
        ImageInfo r116 = null;
    L51:
        if ((r313 & 4096) == 0) goto L53;
        String r117 = null;
    L55:
        if ((r313 & 8192) == 0) goto L57;
        String r107 = null;
    L59:
        if ((r313 & 16384) == 0) goto L61;
        String r108 = null;
    L62:
        this(r100, r101, r102, r103, r104, r105, r106, r112, r113, r114, r115, r116, r117, r107, r108);
        return;
    L61:
        r108 = r312;
        goto L62
    L57:
        r107 = r311;
        goto L59
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r112 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
