package z89;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B³\u0001\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0004HÆ\u0003Jµ\u0001\u0010/\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u000206HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017¨\u00067"}, d2 = {"Lcom/larus/enterprise/api/apptheme/AppThemeConfig;", "", "messageBubbleColor", "", "Lcom/larus/enterprise/api/apptheme/ThemeColorMode;", "messageReceiveBubbleColor", "messageSendColor", "navibarTtsButtonColor", "messageCheckboxColor", "messageSendTextColor", "messageSendTextUnderlineColor", "messageSendTextLoadingColor", "messageAnswerActionBackgroundColor", "messageAnswerActionColor", "messageReplyTextColor", "messageReplyLineColor", "messageReplyIconColor", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/larus/enterprise/api/apptheme/ThemeColorMode;Lcom/larus/enterprise/api/apptheme/ThemeColorMode;Lcom/larus/enterprise/api/apptheme/ThemeColorMode;Lcom/larus/enterprise/api/apptheme/ThemeColorMode;Lcom/larus/enterprise/api/apptheme/ThemeColorMode;Lcom/larus/enterprise/api/apptheme/ThemeColorMode;Lcom/larus/enterprise/api/apptheme/ThemeColorMode;Lcom/larus/enterprise/api/apptheme/ThemeColorMode;Lcom/larus/enterprise/api/apptheme/ThemeColorMode;Lcom/larus/enterprise/api/apptheme/ThemeColorMode;Lcom/larus/enterprise/api/apptheme/ThemeColorMode;)V", "getMessageBubbleColor", "()Ljava/util/List;", "getMessageReceiveBubbleColor", "getMessageSendColor", "()Lcom/larus/enterprise/api/apptheme/ThemeColorMode;", "getNavibarTtsButtonColor", "getMessageCheckboxColor", "getMessageSendTextColor", "getMessageSendTextUnderlineColor", "getMessageSendTextLoadingColor", "getMessageAnswerActionBackgroundColor", "getMessageAnswerActionColor", "getMessageReplyTextColor", "getMessageReplyLineColor", "getMessageReplyIconColor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("message_answer_action_background_color")
    private final b messageAnswerActionBackgroundColor;

    @SerializedName("message_answer_action_color")
    private final b messageAnswerActionColor;

    @SerializedName("message_bubble_color")
    private final List<b> messageBubbleColor;

    @SerializedName("mesage_checkbox_color")
    private final b messageCheckboxColor;

    @SerializedName("message_receive_bubble_color")
    private final List<b> messageReceiveBubbleColor;

    @SerializedName("message_reply_icon_color")
    private final b messageReplyIconColor;

    @SerializedName("message_reply_line_color")
    private final b messageReplyLineColor;

    @SerializedName("message_reply_text_color")
    private final b messageReplyTextColor;

    @SerializedName("message_send_color")
    private final b messageSendColor;

    @SerializedName("message_send_text_color")
    private final b messageSendTextColor;

    @SerializedName("message_send_text_loading_color")
    private final b messageSendTextLoadingColor;

    @SerializedName("message_send_text_underline_color")
    private final b messageSendTextUnderlineColor;

    @SerializedName("navibar_tts_button_color")
    private final b navibarTtsButtonColor;

    public a() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.messageBubbleColor, r101.messageBubbleColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.messageReceiveBubbleColor, r101.messageReceiveBubbleColor) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.messageSendColor, r101.messageSendColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.navibarTtsButtonColor, r101.navibarTtsButtonColor) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.messageCheckboxColor, r101.messageCheckboxColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.messageSendTextColor, r101.messageSendTextColor) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.messageSendTextUnderlineColor, r101.messageSendTextUnderlineColor) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.messageSendTextLoadingColor, r101.messageSendTextLoadingColor) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.messageAnswerActionBackgroundColor, r101.messageAnswerActionBackgroundColor) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.messageAnswerActionColor, r101.messageAnswerActionColor) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.messageReplyTextColor, r101.messageReplyTextColor) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.messageReplyLineColor, r101.messageReplyLineColor) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.messageReplyIconColor, r101.messageReplyIconColor) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        List<b> r100 = this.messageBubbleColor;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<b> r104 = this.messageReceiveBubbleColor;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        b r107 = this.messageSendColor;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        b r110 = this.navibarTtsButtonColor;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        b r113 = this.messageCheckboxColor;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        b r116 = this.messageSendTextColor;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        b r119 = this.messageSendTextUnderlineColor;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        b r122 = this.messageSendTextLoadingColor;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        b r125 = this.messageAnswerActionBackgroundColor;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        b r128 = this.messageAnswerActionColor;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        b r131 = this.messageReplyTextColor;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        b r134 = this.messageReplyLineColor;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        b r137 = this.messageReplyIconColor;
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
        return "AppThemeConfig(messageBubbleColor=" + this.messageBubbleColor + ", messageReceiveBubbleColor=" + this.messageReceiveBubbleColor + ", messageSendColor=" + this.messageSendColor + ", navibarTtsButtonColor=" + this.navibarTtsButtonColor + ", messageCheckboxColor=" + this.messageCheckboxColor + ", messageSendTextColor=" + this.messageSendTextColor + ", messageSendTextUnderlineColor=" + this.messageSendTextUnderlineColor + ", messageSendTextLoadingColor=" + this.messageSendTextLoadingColor + ", messageAnswerActionBackgroundColor=" + this.messageAnswerActionBackgroundColor + ", messageAnswerActionColor=" + this.messageAnswerActionColor + ", messageReplyTextColor=" + this.messageReplyTextColor + ", messageReplyLineColor=" + this.messageReplyLineColor + ", messageReplyIconColor=" + this.messageReplyIconColor + ')';
    }

    public final b a() {
        return this.messageAnswerActionBackgroundColor;
    }

    public final b b() {
        return this.messageAnswerActionColor;
    }

    public final List<b> c() {
        return this.messageBubbleColor;
    }

    public final b d() {
        return this.messageCheckboxColor;
    }

    public final List<b> e() {
        return this.messageReceiveBubbleColor;
    }

    public final b f() {
        return this.messageReplyIconColor;
    }

    public final b g() {
        return this.messageReplyLineColor;
    }

    public final b h() {
        return this.messageReplyTextColor;
    }

    public final b i() {
        return this.messageSendColor;
    }

    public final b j() {
        return this.messageSendTextColor;
    }

    public final b k() {
        return this.messageSendTextLoadingColor;
    }

    public final b l() {
        return this.messageSendTextUnderlineColor;
    }

    public final b m() {
        return this.navibarTtsButtonColor;
    }

    public a(List<b> r100, List<b> r101, b r102, b r103, b r104, b r105, b r106, b r107, b r108, b r110, b r111, b r112, b r113) {
        this.messageBubbleColor = r100;
        this.messageReceiveBubbleColor = r101;
        this.messageSendColor = r102;
        this.navibarTtsButtonColor = r103;
        this.messageCheckboxColor = r104;
        this.messageSendTextColor = r105;
        this.messageSendTextUnderlineColor = r106;
        this.messageSendTextLoadingColor = r107;
        this.messageAnswerActionBackgroundColor = r108;
        this.messageAnswerActionColor = r110;
        this.messageReplyTextColor = r111;
        this.messageReplyLineColor = r112;
        this.messageReplyIconColor = r113;
    }
}
