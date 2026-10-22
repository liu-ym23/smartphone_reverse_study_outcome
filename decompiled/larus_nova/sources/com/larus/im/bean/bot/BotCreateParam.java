package com.larus.im.bean.bot;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bD\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u0002Bí\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010I\u001a\u00020\u0004HÆ\u0003J\t\u0010J\u001a\u00020\u0004HÆ\u0003J\t\u0010K\u001a\u00020\u0004HÆ\u0003J\t\u0010L\u001a\u00020\bHÆ\u0003J\t\u0010M\u001a\u00020\u0004HÆ\u0003J\t\u0010N\u001a\u00020\u000bHÆ\u0003J\t\u0010O\u001a\u00020\u0004HÆ\u0003J\t\u0010P\u001a\u00020\u000bHÆ\u0003J\t\u0010Q\u001a\u00020\u000bHÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010S\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00106J\u000b\u0010T\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0010\u0010U\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00106J\u000b\u0010V\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u001dHÆ\u0003Jø\u0001\u0010^\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÆ\u0001¢\u0006\u0002\u0010_J\u0013\u0010`\u001a\u00020\u000b2\b\u0010a\u001a\u0004\u0018\u00010bHÖ\u0003J\t\u0010c\u001a\u00020\bHÖ\u0001J\t\u0010d\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010!\"\u0004\b+\u0010#R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010!\"\u0004\b1\u0010#R\u001a\u0010\r\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010-\"\u0004\b2\u0010/R\u001a\u0010\u000e\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010-\"\u0004\b4\u0010/R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\b:\u00106\"\u0004\b;\u00108R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u00109\u001a\u0004\b>\u00106R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010!R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010!R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010!R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010!R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010!R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010!R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\bG\u0010H¨\u0006e"}, d2 = {"Lcom/larus/im/bean/bot/BotCreateParam;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "name", "", "description", "iconUri", "privateStatus", "", "voiceType", "muted", "", "botLanguage", "isUgcVoice", "hasUsedAutoFill", "enableWebSearch", "enableGenPic", "firstMet", "Lcom/larus/im/bean/bot/FirstMet;", "useBotEnrichEdit", "createChannel", "bgImgUri", "bgImageInfo", "Lcom/larus/im/bean/bot/BgImageInfo;", "userBotGenderStarlingKey", "userBotTypeStarlingKey", "originalUserImgUri", "bioEdit", "creationIdInfo", "Lcom/larus/im/bean/bot/CreationIdInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;ZZLjava/lang/Boolean;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/FirstMet;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BgImageInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/CreationIdInfo;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getDescription", "setDescription", "getIconUri", "setIconUri", "getPrivateStatus", "()I", "getVoiceType", "setVoiceType", "getMuted", "()Z", "setMuted", "(Z)V", "getBotLanguage", "setBotLanguage", "setUgcVoice", "getHasUsedAutoFill", "setHasUsedAutoFill", "getEnableWebSearch", "()Ljava/lang/Boolean;", "setEnableWebSearch", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getEnableGenPic", "setEnableGenPic", "getFirstMet", "()Lcom/larus/im/bean/bot/FirstMet;", "getUseBotEnrichEdit", "getCreateChannel", "getBgImgUri", "getBgImageInfo", "()Lcom/larus/im/bean/bot/BgImageInfo;", "getUserBotGenderStarlingKey", "getUserBotTypeStarlingKey", "getOriginalUserImgUri", "getBioEdit", "getCreationIdInfo", "()Lcom/larus/im/bean/bot/CreationIdInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;ZZLjava/lang/Boolean;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/FirstMet;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BgImageInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/CreationIdInfo;)Lcom/larus/im/bean/bot/BotCreateParam;", "equals", "other", "", "hashCode", "toString", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotCreateParam implements Serializable {
    private final BgImageInfo bgImageInfo;
    private final String bgImgUri;
    private final String bioEdit;
    private String botLanguage;
    private final String createChannel;
    private final CreationIdInfo creationIdInfo;
    private String description;
    private Boolean enableGenPic;
    private Boolean enableWebSearch;
    private final FirstMet firstMet;
    private boolean hasUsedAutoFill;
    private String iconUri;
    private boolean isUgcVoice;
    private boolean muted;
    private String name;
    private final String originalUserImgUri;
    private final int privateStatus;
    private final Boolean useBotEnrichEdit;
    private final String userBotGenderStarlingKey;
    private final String userBotTypeStarlingKey;
    private String voiceType;

    public static /* synthetic */ BotCreateParam copy$default(BotCreateParam r110, String r111, String r112, String r210, int r211, String r212, boolean r213, String r214, boolean r215, boolean r216, Boolean r217, Boolean r218, FirstMet r219, Boolean r310, String r311, String r312, BgImageInfo r313, String r314, String r315, String r316, String r317, CreationIdInfo r318, int r319, Object r410) {
        if ((r319 & 1) == 0) goto L5;
        String r100 = r110.name;
    L7:
        if ((r319 & 2) == 0) goto L9;
        String r101 = r110.description;
    L11:
        if ((r319 & 4) == 0) goto L13;
        String r102 = r110.iconUri;
    L15:
        if ((r319 & 8) == 0) goto L17;
        int r103 = r110.privateStatus;
    L19:
        if ((r319 & 16) == 0) goto L21;
        String r104 = r110.voiceType;
    L23:
        if ((r319 & 32) == 0) goto L25;
        boolean r105 = r110.muted;
    L27:
        if ((r319 & 64) == 0) goto L29;
        String r106 = r110.botLanguage;
    L31:
        if ((r319 & 128) == 0) goto L33;
        boolean r107 = r110.isUgcVoice;
    L35:
        if ((r319 & 256) == 0) goto L37;
        boolean r113 = r110.hasUsedAutoFill;
    L39:
        if ((r319 & 512) == 0) goto L41;
        Boolean r114 = r110.enableWebSearch;
    L43:
        if ((r319 & 1024) == 0) goto L45;
        Boolean r115 = r110.enableGenPic;
    L47:
        if ((r319 & 2048) == 0) goto L49;
        FirstMet r116 = r110.firstMet;
    L51:
        if ((r319 & 4096) == 0) goto L53;
        Boolean r117 = r110.useBotEnrichEdit;
    L55:
        if ((r319 & 8192) == 0) goto L57;
        String r118 = r110.createChannel;
    L58:
        String r320 = r118;
        if ((r319 & 16384) == 0) goto L61;
        String r119 = r110.bgImgUri;
    L62:
        String r321 = r119;
        if ((r319 & 32768) == 0) goto L65;
        BgImageInfo r120 = r110.bgImageInfo;
    L66:
        BgImageInfo r322 = r120;
        if ((r319 & 65536) == 0) goto L69;
        String r121 = r110.userBotGenderStarlingKey;
    L70:
        String r323 = r121;
        if ((r319 & 131072) == 0) goto L73;
        String r122 = r110.userBotTypeStarlingKey;
    L74:
        String r324 = r122;
        if ((r319 & 262144) == 0) goto L77;
        String r123 = r110.originalUserImgUri;
    L78:
        String r325 = r123;
        if ((r319 & 524288) == 0) goto L81;
        String r124 = r110.bioEdit;
    L83:
        if ((r319 & 1048576) == 0) goto L85;
        CreationIdInfo r108 = r110.creationIdInfo;
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
        return this.name;
    }

    public final Boolean component10() {
        return this.enableWebSearch;
    }

    public final Boolean component11() {
        return this.enableGenPic;
    }

    public final FirstMet component12() {
        return this.firstMet;
    }

    public final Boolean component13() {
        return this.useBotEnrichEdit;
    }

    public final String component14() {
        return this.createChannel;
    }

    public final String component15() {
        return this.bgImgUri;
    }

    public final BgImageInfo component16() {
        return this.bgImageInfo;
    }

    public final String component17() {
        return this.userBotGenderStarlingKey;
    }

    public final String component18() {
        return this.userBotTypeStarlingKey;
    }

    public final String component19() {
        return this.originalUserImgUri;
    }

    public final String component2() {
        return this.description;
    }

    public final String component20() {
        return this.bioEdit;
    }

    public final CreationIdInfo component21() {
        return this.creationIdInfo;
    }

    public final String component3() {
        return this.iconUri;
    }

    public final int component4() {
        return this.privateStatus;
    }

    public final String component5() {
        return this.voiceType;
    }

    public final boolean component6() {
        return this.muted;
    }

    public final String component7() {
        return this.botLanguage;
    }

    public final boolean component8() {
        return this.isUgcVoice;
    }

    public final boolean component9() {
        return this.hasUsedAutoFill;
    }

    public final BotCreateParam copy(String r210, String r211, String r212, int r213, String r214, boolean r310, String r311, boolean r312, boolean r313, Boolean r314, Boolean r315, FirstMet r316, Boolean r317, String r318, String r319, BgImageInfo r410, String r411, String r412, String r413, String r414, CreationIdInfo r415) {
        Intrinsics.checkNotNullParameter(r210, "name");
        Intrinsics.checkNotNullParameter(r211, "description");
        Intrinsics.checkNotNullParameter(r212, "iconUri");
        Intrinsics.checkNotNullParameter(r214, "voiceType");
        Intrinsics.checkNotNullParameter(r311, "botLanguage");
        return new BotCreateParam(r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BotCreateParam) == true) goto L8;
        return false;
    L8:
        BotCreateParam r101 = (BotCreateParam) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.iconUri, r101.iconUri) == true) goto L18;
        return false;
    L18:
        if (this.privateStatus == r101.privateStatus) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.voiceType, r101.voiceType) == true) goto L24;
        return false;
    L24:
        if (this.muted == r101.muted) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.botLanguage, r101.botLanguage) == true) goto L30;
        return false;
    L30:
        if (this.isUgcVoice == r101.isUgcVoice) goto L33;
        return false;
    L33:
        if (this.hasUsedAutoFill == r101.hasUsedAutoFill) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.enableWebSearch, r101.enableWebSearch) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.enableGenPic, r101.enableGenPic) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.firstMet, r101.firstMet) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.useBotEnrichEdit, r101.useBotEnrichEdit) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.createChannel, r101.createChannel) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.bgImgUri, r101.bgImgUri) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.bgImageInfo, r101.bgImageInfo) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.userBotGenderStarlingKey, r101.userBotGenderStarlingKey) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.userBotTypeStarlingKey, r101.userBotTypeStarlingKey) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.originalUserImgUri, r101.originalUserImgUri) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.bioEdit, r101.bioEdit) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.creationIdInfo, r101.creationIdInfo) == true) goto L71;
        return false;
    L71:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((this.name.hashCode() * 31) + this.description.hashCode()) * 31) + this.iconUri.hashCode()) * 31) + this.privateStatus) * 31) + this.voiceType.hashCode()) * 31;
        int r101 = 1231;
        if (this.muted == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((r100 + r102) * 31) + this.botLanguage.hashCode()) * 31;
        if (this.isUgcVoice == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.hasUsedAutoFill == true) goto L14;
        r101 = 1237;
    L14:
        int r106 = (r105 + r101) * 31;
        Boolean r107 = this.enableWebSearch;
        int r108 = 0;
        if (r107 != null) goto L17;
        int r109 = 0;
    L18:
        int r110 = (r106 + r109) * 31;
        Boolean r111 = this.enableGenPic;
        if (r111 != null) goto L21;
        int r112 = 0;
    L22:
        int r113 = (r110 + r112) * 31;
        FirstMet r114 = this.firstMet;
        if (r114 != null) goto L25;
        int r115 = 0;
    L26:
        int r116 = (r113 + r115) * 31;
        Boolean r117 = this.useBotEnrichEdit;
        if (r117 != null) goto L29;
        int r118 = 0;
    L30:
        int r119 = (r116 + r118) * 31;
        String r120 = this.createChannel;
        if (r120 != null) goto L33;
        int r121 = 0;
    L34:
        int r122 = (r119 + r121) * 31;
        String r123 = this.bgImgUri;
        if (r123 != null) goto L37;
        int r124 = 0;
    L38:
        int r125 = (r122 + r124) * 31;
        BgImageInfo r126 = this.bgImageInfo;
        if (r126 != null) goto L41;
        int r127 = 0;
    L42:
        int r128 = (r125 + r127) * 31;
        String r129 = this.userBotGenderStarlingKey;
        if (r129 != null) goto L45;
        int r130 = 0;
    L46:
        int r131 = (r128 + r130) * 31;
        String r132 = this.userBotTypeStarlingKey;
        if (r132 != null) goto L49;
        int r133 = 0;
    L50:
        int r134 = (r131 + r133) * 31;
        String r135 = this.originalUserImgUri;
        if (r135 != null) goto L53;
        int r136 = 0;
    L54:
        int r137 = (r134 + r136) * 31;
        String r138 = this.bioEdit;
        if (r138 != null) goto L57;
        int r139 = 0;
    L58:
        int r140 = (r137 + r139) * 31;
        CreationIdInfo r141 = this.creationIdInfo;
        if (r141 == null) goto L63;
        r108 = r141.hashCode();
    L63:
        return r140 + r108;
    L57:
        r139 = r138.hashCode();
        goto L58
    L53:
        r136 = r135.hashCode();
        goto L54
    L49:
        r133 = r132.hashCode();
        goto L50
    L45:
        r130 = r129.hashCode();
        goto L46
    L41:
        r127 = r126.hashCode();
        goto L42
    L37:
        r124 = r123.hashCode();
        goto L38
    L33:
        r121 = r120.hashCode();
        goto L34
    L29:
        r118 = r117.hashCode();
        goto L30
    L25:
        r115 = r114.hashCode();
        goto L26
    L21:
        r112 = r111.hashCode();
        goto L22
    L17:
        r109 = r107.hashCode();
        goto L18
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "BotCreateParam(name=" + this.name + ", description=" + this.description + ", iconUri=" + this.iconUri + ", privateStatus=" + this.privateStatus + ", voiceType=" + this.voiceType + ", muted=" + this.muted + ", botLanguage=" + this.botLanguage + ", isUgcVoice=" + this.isUgcVoice + ", hasUsedAutoFill=" + this.hasUsedAutoFill + ", enableWebSearch=" + this.enableWebSearch + ", enableGenPic=" + this.enableGenPic + ", firstMet=" + this.firstMet + ", useBotEnrichEdit=" + this.useBotEnrichEdit + ", createChannel=" + this.createChannel + ", bgImgUri=" + this.bgImgUri + ", bgImageInfo=" + this.bgImageInfo + ", userBotGenderStarlingKey=" + this.userBotGenderStarlingKey + ", userBotTypeStarlingKey=" + this.userBotTypeStarlingKey + ", originalUserImgUri=" + this.originalUserImgUri + ", bioEdit=" + this.bioEdit + ", creationIdInfo=" + this.creationIdInfo + ')';
    }

    public final BgImageInfo getBgImageInfo() {
        return this.bgImageInfo;
    }

    public final String getBgImgUri() {
        return this.bgImgUri;
    }

    public final String getBioEdit() {
        return this.bioEdit;
    }

    public final String getBotLanguage() {
        return this.botLanguage;
    }

    public final String getCreateChannel() {
        return this.createChannel;
    }

    public final CreationIdInfo getCreationIdInfo() {
        return this.creationIdInfo;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Boolean getEnableGenPic() {
        return this.enableGenPic;
    }

    public final Boolean getEnableWebSearch() {
        return this.enableWebSearch;
    }

    public final FirstMet getFirstMet() {
        return this.firstMet;
    }

    public final boolean getHasUsedAutoFill() {
        return this.hasUsedAutoFill;
    }

    public final String getIconUri() {
        return this.iconUri;
    }

    public final boolean getMuted() {
        return this.muted;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOriginalUserImgUri() {
        return this.originalUserImgUri;
    }

    public final int getPrivateStatus() {
        return this.privateStatus;
    }

    public final Boolean getUseBotEnrichEdit() {
        return this.useBotEnrichEdit;
    }

    public final String getUserBotGenderStarlingKey() {
        return this.userBotGenderStarlingKey;
    }

    public final String getUserBotTypeStarlingKey() {
        return this.userBotTypeStarlingKey;
    }

    public final String getVoiceType() {
        return this.voiceType;
    }

    public final boolean isUgcVoice() {
        return this.isUgcVoice;
    }

    public final void setBotLanguage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.botLanguage = r100;
    }

    public final void setDescription(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.description = r100;
    }

    public final void setEnableGenPic(Boolean r100) {
        this.enableGenPic = r100;
    }

    public final void setEnableWebSearch(Boolean r100) {
        this.enableWebSearch = r100;
    }

    public final void setHasUsedAutoFill(boolean r100) {
        this.hasUsedAutoFill = r100;
    }

    public final void setIconUri(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.iconUri = r100;
    }

    public final void setMuted(boolean r100) {
        this.muted = r100;
    }

    public final void setName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.name = r100;
    }

    public final void setUgcVoice(boolean r100) {
        this.isUgcVoice = r100;
    }

    public final void setVoiceType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.voiceType = r100;
    }

    public BotCreateParam(String r100, String r101, String r110, int r111, String r112, boolean r113, String r114, boolean r115, boolean r116, Boolean r117, Boolean r118, FirstMet r119, Boolean r210, String r211, String r212, BgImageInfo r213, String r214, String r215, String r216, String r217, CreationIdInfo r218) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "description");
        Intrinsics.checkNotNullParameter(r110, "iconUri");
        Intrinsics.checkNotNullParameter(r112, "voiceType");
        Intrinsics.checkNotNullParameter(r114, "botLanguage");
        this.name = r100;
        this.description = r101;
        this.iconUri = r110;
        this.privateStatus = r111;
        this.voiceType = r112;
        this.muted = r113;
        this.botLanguage = r114;
        this.isUgcVoice = r115;
        this.hasUsedAutoFill = r116;
        this.enableWebSearch = r117;
        this.enableGenPic = r118;
        this.firstMet = r119;
        this.useBotEnrichEdit = r210;
        this.createChannel = r211;
        this.bgImgUri = r212;
        this.bgImageInfo = r213;
        this.userBotGenderStarlingKey = r214;
        this.userBotTypeStarlingKey = r215;
        this.originalUserImgUri = r216;
        this.bioEdit = r217;
        this.creationIdInfo = r218;
    }

    public /* synthetic */ BotCreateParam(String r210, String r211, String r212, int r213, String r310, boolean r311, String r312, boolean r313, boolean r314, Boolean r315, Boolean r316, FirstMet r317, Boolean r318, String r319, String r410, BgImageInfo r411, String r412, String r413, String r414, String r415, CreationIdInfo r416, int r417, DefaultConstructorMarker r418) {
        if ((r417 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r417 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r417 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r417 & 32) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r417 & 64) == 0) goto L21;
        String r110 = "";
    L23:
        if ((r417 & 128) == 0) goto L25;
        boolean r111 = false;
    L27:
        if ((r417 & 256) == 0) goto L29;
        boolean r112 = false;
    L31:
        if ((r417 & 512) == 0) goto L33;
        Boolean r113 = null;
    L35:
        if ((r417 & 1024) == 0) goto L37;
        Boolean r114 = null;
    L39:
        if ((r417 & 2048) == 0) goto L41;
        FirstMet r115 = null;
    L43:
        if ((r417 & 4096) == 0) goto L45;
        Boolean r116 = null;
    L47:
        if ((r417 & 8192) == 0) goto L49;
        String r117 = null;
    L51:
        if ((r417 & 16384) == 0) goto L53;
        String r118 = null;
    L55:
        if ((32768 & r417) == 0) goto L57;
        BgImageInfo r119 = null;
    L59:
        if ((65536 & r417) == 0) goto L61;
        String r214 = null;
    L63:
        if ((131072 & r417) == 0) goto L65;
        String r215 = null;
    L67:
        if ((262144 & r417) == 0) goto L69;
        String r216 = null;
    L71:
        if ((524288 & r417) == 0) goto L73;
        String r217 = null;
    L75:
        if ((r417 & 1048576) == 0) goto L77;
        CreationIdInfo r218 = null;
    L78:
        this(r100, r101, r102, r213, r310, r103, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r214, r215, r216, r217, r218);
        return;
    L77:
        r218 = r416;
        goto L78
    L73:
        r217 = r415;
        goto L75
    L69:
        r216 = r414;
        goto L71
    L65:
        r215 = r413;
        goto L67
    L61:
        r214 = r412;
        goto L63
    L57:
        r119 = r411;
        goto L59
    L53:
        r118 = r410;
        goto L55
    L49:
        r117 = r319;
        goto L51
    L45:
        r116 = r318;
        goto L47
    L41:
        r115 = r317;
        goto L43
    L37:
        r114 = r316;
        goto L39
    L33:
        r113 = r315;
        goto L35
    L29:
        r112 = r314;
        goto L31
    L25:
        r111 = r313;
        goto L27
    L21:
        r110 = r312;
        goto L23
    L17:
        r103 = r311;
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
