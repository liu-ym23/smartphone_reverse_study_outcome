package com.larus.bmhome.chat.bean;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b>\b\u0087\b\u0018\u00002\u00020\u0001B\u0085\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010.J\t\u0010I\u001a\u00020\u0012HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015HÆ\u0003J\t\u0010L\u001a\u00020\u0012HÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010N\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u0010:J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u0010:J\u008c\u0002\u0010R\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00122\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0002\u0010SJ\u0013\u0010T\u001a\u00020\u00122\b\u0010U\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010V\u001a\u00020\u0016HÖ\u0001J\t\u0010W\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010!R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010!R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u00100R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010!R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0016\u0010\u0017\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u00100R\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\b\u0018\u00104R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00107R\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010;\u001a\u0004\b9\u0010:R\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010;\u001a\u0004\b<\u0010:¨\u0006X"}, d2 = {"Lcom/larus/bmhome/chat/bean/TextCandidateConf;", "", "displayText", "", "bgColorLight", "bgColorDark", "fontColorLight", "fontColorDark", "borderColorLight", "borderColorDark", "frontIcon", "Lcom/larus/bmhome/chat/bean/NexPulseMedia;", "endIcon", "sendMessageText", "schema", "suggestedItemType", "", "isHighlightPush", "", "wcbItem", "tagList", "", "", "isRichText", "isContinueAsk", "displayRichTextConf", "Lcom/google/gson/JsonObject;", "sendRichTextConf", "icon", "position", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/bean/NexPulseMedia;Lcom/larus/bmhome/chat/bean/NexPulseMedia;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;ZLjava/lang/String;Ljava/util/List;ZLjava/lang/Boolean;Lcom/google/gson/JsonObject;Lcom/google/gson/JsonObject;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getDisplayText", "()Ljava/lang/String;", "getBgColorLight", "getBgColorDark", "getFontColorLight", "getFontColorDark", "getBorderColorLight", "getBorderColorDark", "getFrontIcon", "()Lcom/larus/bmhome/chat/bean/NexPulseMedia;", "getEndIcon", "getSendMessageText", "getSchema", "getSuggestedItemType", "()Ljava/lang/Long;", "Ljava/lang/Long;", "()Z", "getWcbItem", "getTagList", "()Ljava/util/List;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDisplayRichTextConf", "()Lcom/google/gson/JsonObject;", "getSendRichTextConf", "getIcon", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPosition", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/bean/NexPulseMedia;Lcom/larus/bmhome/chat/bean/NexPulseMedia;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;ZLjava/lang/String;Ljava/util/List;ZLjava/lang/Boolean;Lcom/google/gson/JsonObject;Lcom/google/gson/JsonObject;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/bean/TextCandidateConf;", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextCandidateConf {

    @SerializedName("bg_color_dark")
    private final String bgColorDark;

    @SerializedName("bg_color_light")
    private final String bgColorLight;

    @SerializedName("border_color_dark")
    private final String borderColorDark;

    @SerializedName("border_color_light")
    private final String borderColorLight;

    @SerializedName("rich_display_text_conf")
    private final JsonObject displayRichTextConf;

    @SerializedName("display_text")
    private final String displayText;

    @SerializedName("end_icon")
    private final NexPulseMedia endIcon;

    @SerializedName("font_color_dark")
    private final String fontColorDark;

    @SerializedName("font_color_light")
    private final String fontColorLight;

    @SerializedName("front_icon")
    private final NexPulseMedia frontIcon;

    @SerializedName("Icon")
    private final Integer icon;

    @SerializedName("is_continue_ask")
    private final Boolean isContinueAsk;

    @SerializedName("is_highlight_push")
    private final boolean isHighlightPush;

    @SerializedName("is_rich_text")
    private final boolean isRichText;

    @SerializedName("Position")
    private final Integer position;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("send_message_text")
    private final String sendMessageText;

    @SerializedName("rich_send_message_text_conf")
    private final JsonObject sendRichTextConf;

    @SerializedName("suggestted_item_type")
    private final Long suggestedItemType;

    @SerializedName("tag_enum_mapping")
    private final List<Integer> tagList;

    @SerializedName("wcb_item")
    private final String wcbItem;

    public TextCandidateConf() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, null, null, null, null, null, 2097151, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextCandidateConf copy$default(TextCandidateConf r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, NexPulseMedia r215, NexPulseMedia r216, String r217, String r218, Long r219, boolean r310, String r311, List r312, boolean r313, Boolean r314, JsonObject r315, JsonObject r316, Integer r317, Integer r318, int r319, Object r410) {
        if ((r319 & 1) == 0) goto L5;
        String r100 = r110.displayText;
    L7:
        if ((r319 & 2) == 0) goto L9;
        String r101 = r110.bgColorLight;
    L11:
        if ((r319 & 4) == 0) goto L13;
        String r102 = r110.bgColorDark;
    L15:
        if ((r319 & 8) == 0) goto L17;
        String r103 = r110.fontColorLight;
    L19:
        if ((r319 & 16) == 0) goto L21;
        String r104 = r110.fontColorDark;
    L23:
        if ((r319 & 32) == 0) goto L25;
        String r105 = r110.borderColorLight;
    L27:
        if ((r319 & 64) == 0) goto L29;
        String r106 = r110.borderColorDark;
    L31:
        if ((r319 & 128) == 0) goto L33;
        NexPulseMedia r107 = r110.frontIcon;
    L35:
        if ((r319 & 256) == 0) goto L37;
        NexPulseMedia r113 = r110.endIcon;
    L39:
        if ((r319 & 512) == 0) goto L41;
        String r114 = r110.sendMessageText;
    L43:
        if ((r319 & 1024) == 0) goto L45;
        String r115 = r110.schema;
    L47:
        if ((r319 & 2048) == 0) goto L49;
        Long r116 = r110.suggestedItemType;
    L51:
        if ((r319 & 4096) == 0) goto L53;
        boolean r117 = r110.isHighlightPush;
    L55:
        if ((r319 & 8192) == 0) goto L57;
        String r118 = r110.wcbItem;
    L58:
        String r320 = r118;
        if ((r319 & 16384) == 0) goto L61;
        List r119 = r110.tagList;
    L62:
        List r321 = r119;
        if ((r319 & 32768) == 0) goto L65;
        boolean r120 = r110.isRichText;
    L66:
        boolean r322 = r120;
        if ((r319 & 65536) == 0) goto L69;
        Boolean r121 = r110.isContinueAsk;
    L70:
        Boolean r323 = r121;
        if ((r319 & 131072) == 0) goto L73;
        JsonObject r122 = r110.displayRichTextConf;
    L74:
        JsonObject r324 = r122;
        if ((r319 & 262144) == 0) goto L77;
        JsonObject r123 = r110.sendRichTextConf;
    L78:
        JsonObject r325 = r123;
        if ((r319 & 524288) == 0) goto L81;
        Integer r124 = r110.icon;
    L83:
        if ((r319 & 1048576) == 0) goto L85;
        Integer r108 = r110.position;
    L87:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r124, r108);
    L85:
        r108 = r318;
        goto L87
    L81:
        r124 = r317;
        goto L83
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
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
        r107 = r215;
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

    public final String component1() {
        return this.displayText;
    }

    public final String component10() {
        return this.sendMessageText;
    }

    public final String component11() {
        return this.schema;
    }

    public final Long component12() {
        return this.suggestedItemType;
    }

    public final boolean component13() {
        return this.isHighlightPush;
    }

    public final String component14() {
        return this.wcbItem;
    }

    public final List<Integer> component15() {
        return this.tagList;
    }

    public final boolean component16() {
        return this.isRichText;
    }

    public final Boolean component17() {
        return this.isContinueAsk;
    }

    public final JsonObject component18() {
        return this.displayRichTextConf;
    }

    public final JsonObject component19() {
        return this.sendRichTextConf;
    }

    public final String component2() {
        return this.bgColorLight;
    }

    public final Integer component20() {
        return this.icon;
    }

    public final Integer component21() {
        return this.position;
    }

    public final String component3() {
        return this.bgColorDark;
    }

    public final String component4() {
        return this.fontColorLight;
    }

    public final String component5() {
        return this.fontColorDark;
    }

    public final String component6() {
        return this.borderColorLight;
    }

    public final String component7() {
        return this.borderColorDark;
    }

    public final NexPulseMedia component8() {
        return this.frontIcon;
    }

    public final NexPulseMedia component9() {
        return this.endIcon;
    }

    public final TextCandidateConf copy(String r210, String r211, String r212, String r213, String r214, String r215, String r310, NexPulseMedia r311, NexPulseMedia r312, String r313, String r314, Long r315, boolean r316, String r317, List<Integer> r318, boolean r319, Boolean r410, JsonObject r411, JsonObject r412, Integer r413, Integer r414) {
        return new TextCandidateConf(r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TextCandidateConf) == true) goto L8;
        return false;
    L8:
        TextCandidateConf r101 = (TextCandidateConf) r100;
        if (Intrinsics.areEqual(this.displayText, r101.displayText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bgColorLight, r101.bgColorLight) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bgColorDark, r101.bgColorDark) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fontColorLight, r101.fontColorLight) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fontColorDark, r101.fontColorDark) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.borderColorLight, r101.borderColorLight) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.borderColorDark, r101.borderColorDark) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.frontIcon, r101.frontIcon) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.endIcon, r101.endIcon) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.sendMessageText, r101.sendMessageText) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.suggestedItemType, r101.suggestedItemType) == true) goto L45;
        return false;
    L45:
        if (this.isHighlightPush == r101.isHighlightPush) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.wcbItem, r101.wcbItem) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.tagList, r101.tagList) == true) goto L54;
        return false;
    L54:
        if (this.isRichText == r101.isRichText) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.isContinueAsk, r101.isContinueAsk) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.displayRichTextConf, r101.displayRichTextConf) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.sendRichTextConf, r101.sendRichTextConf) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.position, r101.position) == true) goto L71;
        return false;
    L71:
        return true;
    }

    public int hashCode() {
        String r100 = this.displayText;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.bgColorLight;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.bgColorDark;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.fontColorLight;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.fontColorDark;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.borderColorLight;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.borderColorDark;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        NexPulseMedia r122 = this.frontIcon;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        NexPulseMedia r125 = this.endIcon;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.sendMessageText;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.schema;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Long r134 = this.suggestedItemType;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        int r137 = 1231;
        if (this.isHighlightPush == false) goto L53;
        int r138 = 1231;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.wcbItem;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        List<Integer> r143 = this.tagList;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        if (this.isRichText == true) goto L66;
        r137 = 1237;
    L66:
        int r146 = (r145 + r137) * 31;
        Boolean r147 = this.isContinueAsk;
        if (r147 != null) goto L69;
        int r148 = 0;
    L70:
        int r149 = (r146 + r148) * 31;
        JsonObject r150 = this.displayRichTextConf;
        if (r150 != null) goto L73;
        int r151 = 0;
    L74:
        int r152 = (r149 + r151) * 31;
        JsonObject r153 = this.sendRichTextConf;
        if (r153 != null) goto L77;
        int r154 = 0;
    L78:
        int r155 = (r152 + r154) * 31;
        Integer r156 = this.icon;
        if (r156 != null) goto L81;
        int r157 = 0;
    L82:
        int r158 = (r155 + r157) * 31;
        Integer r159 = this.position;
        if (r159 == null) goto L87;
        r101 = r159.hashCode();
    L87:
        return r158 + r101;
    L81:
        r157 = r156.hashCode();
        goto L82
    L77:
        r154 = r153.hashCode();
        goto L78
    L73:
        r151 = r150.hashCode();
        goto L74
    L69:
        r148 = r147.hashCode();
        goto L70
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = 1237;
        goto L54
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

    public String toString() {
        return "TextCandidateConf(displayText=" + this.displayText + ", bgColorLight=" + this.bgColorLight + ", bgColorDark=" + this.bgColorDark + ", fontColorLight=" + this.fontColorLight + ", fontColorDark=" + this.fontColorDark + ", borderColorLight=" + this.borderColorLight + ", borderColorDark=" + this.borderColorDark + ", frontIcon=" + this.frontIcon + ", endIcon=" + this.endIcon + ", sendMessageText=" + this.sendMessageText + ", schema=" + this.schema + ", suggestedItemType=" + this.suggestedItemType + ", isHighlightPush=" + this.isHighlightPush + ", wcbItem=" + this.wcbItem + ", tagList=" + this.tagList + ", isRichText=" + this.isRichText + ", isContinueAsk=" + this.isContinueAsk + ", displayRichTextConf=" + this.displayRichTextConf + ", sendRichTextConf=" + this.sendRichTextConf + ", icon=" + this.icon + ", position=" + this.position + ')';
    }

    public final String getBgColorDark() {
        return this.bgColorDark;
    }

    public final String getBgColorLight() {
        return this.bgColorLight;
    }

    public final String getBorderColorDark() {
        return this.borderColorDark;
    }

    public final String getBorderColorLight() {
        return this.borderColorLight;
    }

    public final JsonObject getDisplayRichTextConf() {
        return this.displayRichTextConf;
    }

    public final String getDisplayText() {
        return this.displayText;
    }

    public final NexPulseMedia getEndIcon() {
        return this.endIcon;
    }

    public final String getFontColorDark() {
        return this.fontColorDark;
    }

    public final String getFontColorLight() {
        return this.fontColorLight;
    }

    public final NexPulseMedia getFrontIcon() {
        return this.frontIcon;
    }

    public final Integer getIcon() {
        return this.icon;
    }

    public final Integer getPosition() {
        return this.position;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getSendMessageText() {
        return this.sendMessageText;
    }

    public final JsonObject getSendRichTextConf() {
        return this.sendRichTextConf;
    }

    public final Long getSuggestedItemType() {
        return this.suggestedItemType;
    }

    public final List<Integer> getTagList() {
        return this.tagList;
    }

    public final String getWcbItem() {
        return this.wcbItem;
    }

    public final Boolean isContinueAsk() {
        return this.isContinueAsk;
    }

    public final boolean isHighlightPush() {
        return this.isHighlightPush;
    }

    public final boolean isRichText() {
        return this.isRichText;
    }

    public TextCandidateConf(String r100, String r101, String r102, String r103, String r104, String r105, String r106, NexPulseMedia r110, NexPulseMedia r111, String r112, String r113, Long r114, boolean r115, String r116, List<Integer> r117, boolean r118, Boolean r119, JsonObject r210, JsonObject r211, Integer r212, Integer r213) {
        this.displayText = r100;
        this.bgColorLight = r101;
        this.bgColorDark = r102;
        this.fontColorLight = r103;
        this.fontColorDark = r104;
        this.borderColorLight = r105;
        this.borderColorDark = r106;
        this.frontIcon = r110;
        this.endIcon = r111;
        this.sendMessageText = r112;
        this.schema = r113;
        this.suggestedItemType = r114;
        this.isHighlightPush = r115;
        this.wcbItem = r116;
        this.tagList = r117;
        this.isRichText = r118;
        this.isContinueAsk = r119;
        this.displayRichTextConf = r210;
        this.sendRichTextConf = r211;
        this.icon = r212;
        this.position = r213;
    }

    public /* synthetic */ TextCandidateConf(String r210, String r211, String r212, String r213, String r214, String r215, String r216, NexPulseMedia r310, NexPulseMedia r311, String r312, String r313, Long r314, boolean r315, String r316, List r317, boolean r318, Boolean r319, JsonObject r410, JsonObject r411, Integer r412, Integer r413, int r414, DefaultConstructorMarker r415) {
        if ((r414 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r414 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r414 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r414 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r414 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r414 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r414 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r414 & 128) == 0) goto L33;
        NexPulseMedia r107 = null;
    L35:
        if ((r414 & 256) == 0) goto L37;
        NexPulseMedia r110 = null;
    L39:
        if ((r414 & 512) == 0) goto L41;
        String r111 = null;
    L43:
        if ((r414 & 1024) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r414 & 2048) == 0) goto L49;
        Long r113 = null;
    L51:
        if ((r414 & 4096) == 0) goto L53;
        boolean r114 = false;
    L55:
        if ((r414 & 8192) == 0) goto L57;
        String r108 = null;
    L59:
        if ((r414 & 16384) == 0) goto L61;
        List r115 = null;
    L63:
        if ((r414 & 32768) == 0) goto L65;
        boolean r116 = false;
    L67:
        if ((r414 & 65536) == 0) goto L69;
        Boolean r117 = null;
    L71:
        if ((r414 & 131072) == 0) goto L73;
        JsonObject r118 = null;
    L75:
        if ((r414 & 262144) == 0) goto L77;
        JsonObject r119 = null;
    L79:
        if ((r414 & 524288) == 0) goto L81;
        Integer r217 = null;
    L83:
        if ((r414 & 1048576) == 0) goto L85;
        Integer r109 = null;
    L86:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r108, r115, r116, r117, r118, r119, r217, r109);
        return;
    L85:
        r109 = r413;
        goto L86
    L81:
        r217 = r412;
        goto L83
    L77:
        r119 = r411;
        goto L79
    L73:
        r118 = r410;
        goto L75
    L69:
        r117 = r319;
        goto L71
    L65:
        r116 = r318;
        goto L67
    L61:
        r115 = r317;
        goto L63
    L57:
        r108 = r316;
        goto L59
    L53:
        r114 = r315;
        goto L55
    L49:
        r113 = r314;
        goto L51
    L45:
        r112 = r313;
        goto L47
    L41:
        r111 = r312;
        goto L43
    L37:
        r110 = r311;
        goto L39
    L33:
        r107 = r310;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
