package com.larus.bot.impl.bean;

import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.larus.bmhome.bot.bean.BotLanguage;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bM\n\u0002\u0010\u0002\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B³\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0012\u0012\u001c\b\u0002\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b#\u0010$J\u0006\u0010j\u001a\u00020kJ\t\u0010l\u001a\u00020\u0003HÆ\u0003J\t\u0010m\u001a\u00020\u0003HÆ\u0003J\t\u0010n\u001a\u00020\u0003HÆ\u0003J\t\u0010o\u001a\u00020\u0003HÆ\u0003J\t\u0010p\u001a\u00020\u0003HÆ\u0003J\t\u0010q\u001a\u00020\u0003HÆ\u0003J\t\u0010r\u001a\u00020\nHÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010u\u001a\u00020\u0003HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010w\u001a\u00020\u0012HÆ\u0003J\u0010\u0010x\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010HJ\u0010\u0010y\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010HJ\u000b\u0010z\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0010\u0010{\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010HJ\u000b\u0010|\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010}\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010HJ\u001d\u0010~\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001bHÆ\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¼\u0002\u0010\u0085\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00122\u001c\b\u0002\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0003\u0010\u0086\u0001J\u0015\u0010\u0087\u0001\u001a\u00020\u00122\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000b\u0010\u0089\u0001\u001a\u00030\u008a\u0001HÖ\u0001J\n\u0010\u008b\u0001\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010&\"\u0004\b.\u0010(R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010&\"\u0004\b0\u0010(R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010&\"\u0004\b2\u0010(R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010&\"\u0004\b@\u0010(R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010&\"\u0004\bB\u0010(R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010K\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010K\u001a\u0004\bL\u0010H\"\u0004\bM\u0010JR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010K\u001a\u0004\bR\u0010H\"\u0004\bS\u0010JR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010&\"\u0004\bU\u0010(R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010K\u001a\u0004\bV\u0010H\"\u0004\bW\u0010JR.\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010&\"\u0004\ba\u0010(R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010&\"\u0004\bc\u0010(R\u001c\u0010 \u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010&\"\u0004\be\u0010(R\u001c\u0010!\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010&\"\u0004\bg\u0010(R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010&\"\u0004\bi\u0010(¨\u0006\u008c\u0001"}, d2 = {"Lcom/larus/bot/impl/bean/BotEditParam;", "", "botId", "", "name", "description", "bio", "iconUrl", "iconUri", "modelType", "", "voice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "language", "Lcom/larus/bmhome/bot/bean/BotLanguage;", "avatarPrompt", "avatarPromptForEnrich", "hasUsedAutoFill", "", "enableWebSearch", "enableGenPic", "modelItem", "Lcom/larus/im/bean/bot/ModelItem;", "muted", "prologue", "suggestSwitch", "suggests", "Lkotlin/Triple;", "bgImage", "Lcom/larus/im/bean/bot/BgImage;", "userBotTypeStarlingKey", "userBotGenderStarlingKey", "originalUserImgUri", "originalAvatarImgUri", "originalBackgroundImgUri", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/larus/im/bean/bot/SpeakerVoice;Lcom/larus/bmhome/bot/bean/BotLanguage;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/ModelItem;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/Triple;Lcom/larus/im/bean/bot/BgImage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBotId", "()Ljava/lang/String;", "setBotId", "(Ljava/lang/String;)V", "getName", "setName", "getDescription", "setDescription", "getBio", "setBio", "getIconUrl", "setIconUrl", "getIconUri", "setIconUri", "getModelType", "()J", "setModelType", "(J)V", "getVoice", "()Lcom/larus/im/bean/bot/SpeakerVoice;", "setVoice", "(Lcom/larus/im/bean/bot/SpeakerVoice;)V", "getLanguage", "()Lcom/larus/bmhome/bot/bean/BotLanguage;", "setLanguage", "(Lcom/larus/bmhome/bot/bean/BotLanguage;)V", "getAvatarPrompt", "setAvatarPrompt", "getAvatarPromptForEnrich", "setAvatarPromptForEnrich", "getHasUsedAutoFill", "()Z", "setHasUsedAutoFill", "(Z)V", "getEnableWebSearch", "()Ljava/lang/Boolean;", "setEnableWebSearch", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getEnableGenPic", "setEnableGenPic", "getModelItem", "()Lcom/larus/im/bean/bot/ModelItem;", "setModelItem", "(Lcom/larus/im/bean/bot/ModelItem;)V", "getMuted", "setMuted", "getPrologue", "setPrologue", "getSuggestSwitch", "setSuggestSwitch", "getSuggests", "()Lkotlin/Triple;", "setSuggests", "(Lkotlin/Triple;)V", "getBgImage", "()Lcom/larus/im/bean/bot/BgImage;", "setBgImage", "(Lcom/larus/im/bean/bot/BgImage;)V", "getUserBotTypeStarlingKey", "setUserBotTypeStarlingKey", "getUserBotGenderStarlingKey", "setUserBotGenderStarlingKey", "getOriginalUserImgUri", "setOriginalUserImgUri", "getOriginalAvatarImgUri", "setOriginalAvatarImgUri", "getOriginalBackgroundImgUri", "setOriginalBackgroundImgUri", BasicTestActionHandler.TEST_ACTION_RESET, "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/larus/im/bean/bot/SpeakerVoice;Lcom/larus/bmhome/bot/bean/BotLanguage;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/ModelItem;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/Triple;Lcom/larus/im/bean/bot/BgImage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/bot/impl/bean/BotEditParam;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotEditParam {
    private String avatarPrompt;
    private String avatarPromptForEnrich;
    private BgImage bgImage;
    private String bio;
    private String botId;
    private String description;
    private Boolean enableGenPic;
    private Boolean enableWebSearch;
    private boolean hasUsedAutoFill;
    private String iconUri;
    private String iconUrl;
    private BotLanguage language;
    private ModelItem modelItem;
    private long modelType;
    private Boolean muted;
    private String name;
    private String originalAvatarImgUri;
    private String originalBackgroundImgUri;
    private String originalUserImgUri;
    private String prologue;
    private Boolean suggestSwitch;
    private Triple<String, String, String> suggests;
    private String userBotGenderStarlingKey;
    private String userBotTypeStarlingKey;
    private SpeakerVoice voice;

    public BotEditParam() {
        this(null, null, null, null, null, null, 0, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, 33554431, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BotEditParam copy$default(BotEditParam r110, String r111, String r112, String r210, String r211, String r212, String r213, long r214, SpeakerVoice r215, BotLanguage r216, String r217, String r218, boolean r310, Boolean r311, Boolean r312, ModelItem r313, Boolean r314, String r315, Boolean r316, Triple r317, BgImage r318, String r319, String r410, String r411, String r412, String r413, int r414, Object r415) {
        if ((r414 & 1) == 0) goto L5;
        String r100 = r110.botId;
    L7:
        if ((r414 & 2) == 0) goto L9;
        String r101 = r110.name;
    L11:
        if ((r414 & 4) == 0) goto L13;
        String r102 = r110.description;
    L15:
        if ((r414 & 8) == 0) goto L17;
        String r103 = r110.bio;
    L19:
        if ((r414 & 16) == 0) goto L21;
        String r104 = r110.iconUrl;
    L23:
        if ((r414 & 32) == 0) goto L25;
        String r105 = r110.iconUri;
    L27:
        if ((r414 & 64) == 0) goto L29;
        long r106 = r110.modelType;
    L31:
        if ((r414 & 128) == 0) goto L33;
        SpeakerVoice r113 = r110.voice;
    L35:
        if ((r414 & 256) == 0) goto L37;
        BotLanguage r114 = r110.language;
    L39:
        if ((r414 & 512) == 0) goto L41;
        String r115 = r110.avatarPrompt;
    L43:
        if ((r414 & 1024) == 0) goto L45;
        String r116 = r110.avatarPromptForEnrich;
    L47:
        if ((r414 & 2048) == 0) goto L49;
        boolean r117 = r110.hasUsedAutoFill;
    L51:
        if ((r414 & 4096) == 0) goto L53;
        Boolean r118 = r110.enableWebSearch;
    L54:
        Boolean r320 = r118;
        if ((r414 & 8192) == 0) goto L57;
        Boolean r119 = r110.enableGenPic;
    L58:
        Boolean r321 = r119;
        if ((r414 & 16384) == 0) goto L61;
        ModelItem r120 = r110.modelItem;
    L62:
        ModelItem r322 = r120;
        if ((r414 & 32768) == 0) goto L65;
        Boolean r121 = r110.muted;
    L66:
        Boolean r323 = r121;
        if ((r414 & 65536) == 0) goto L69;
        String r122 = r110.prologue;
    L70:
        String r324 = r122;
        if ((r414 & 131072) == 0) goto L73;
        Boolean r123 = r110.suggestSwitch;
    L74:
        Boolean r325 = r123;
        if ((r414 & 262144) == 0) goto L77;
        Triple r124 = r110.suggests;
    L78:
        Triple r326 = r124;
        if ((r414 & 524288) == 0) goto L81;
        BgImage r125 = r110.bgImage;
    L82:
        BgImage r327 = r125;
        if ((r414 & 1048576) == 0) goto L85;
        String r126 = r110.userBotTypeStarlingKey;
    L86:
        String r328 = r126;
        if ((r414 & 2097152) == 0) goto L89;
        String r127 = r110.userBotGenderStarlingKey;
    L90:
        String r416 = r127;
        if ((r414 & 4194304) == 0) goto L93;
        String r128 = r110.originalUserImgUri;
    L94:
        String r417 = r128;
        if ((r414 & 8388608) == 0) goto L97;
        String r129 = r110.originalAvatarImgUri;
    L99:
        if ((r414 & 16777216) == 0) goto L101;
        String r107 = r110.originalBackgroundImgUri;
    L103:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r416, r417, r129, r107);
    L101:
        r107 = r413;
        goto L103
    L97:
        r129 = r412;
        goto L99
    L93:
        r128 = r411;
        goto L94
    L89:
        r127 = r410;
        goto L90
    L85:
        r126 = r319;
        goto L86
    L81:
        r125 = r318;
        goto L82
    L77:
        r124 = r317;
        goto L78
    L73:
        r123 = r316;
        goto L74
    L69:
        r122 = r315;
        goto L70
    L65:
        r121 = r314;
        goto L66
    L61:
        r120 = r313;
        goto L62
    L57:
        r119 = r312;
        goto L58
    L53:
        r118 = r311;
        goto L54
    L49:
        r117 = r310;
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

    public final String component1() {
        return this.botId;
    }

    public final String component10() {
        return this.avatarPrompt;
    }

    public final String component11() {
        return this.avatarPromptForEnrich;
    }

    public final boolean component12() {
        return this.hasUsedAutoFill;
    }

    public final Boolean component13() {
        return this.enableWebSearch;
    }

    public final Boolean component14() {
        return this.enableGenPic;
    }

    public final ModelItem component15() {
        return this.modelItem;
    }

    public final Boolean component16() {
        return this.muted;
    }

    public final String component17() {
        return this.prologue;
    }

    public final Boolean component18() {
        return this.suggestSwitch;
    }

    public final Triple<String, String, String> component19() {
        return this.suggests;
    }

    public final String component2() {
        return this.name;
    }

    public final BgImage component20() {
        return this.bgImage;
    }

    public final String component21() {
        return this.userBotTypeStarlingKey;
    }

    public final String component22() {
        return this.userBotGenderStarlingKey;
    }

    public final String component23() {
        return this.originalUserImgUri;
    }

    public final String component24() {
        return this.originalAvatarImgUri;
    }

    public final String component25() {
        return this.originalBackgroundImgUri;
    }

    public final String component3() {
        return this.description;
    }

    public final String component4() {
        return this.bio;
    }

    public final String component5() {
        return this.iconUrl;
    }

    public final String component6() {
        return this.iconUri;
    }

    public final long component7() {
        return this.modelType;
    }

    public final SpeakerVoice component8() {
        return this.voice;
    }

    public final BotLanguage component9() {
        return this.language;
    }

    public final BotEditParam copy(String r310, String r311, String r312, String r313, String r314, String r315, long r316, SpeakerVoice r317, BotLanguage r318, String r410, String r411, boolean r412, Boolean r413, Boolean r414, ModelItem r415, Boolean r416, String r417, Boolean r418, Triple<String, String, String> r419, BgImage r510, String r511, String r512, String r513, String r514, String r515) {
        Intrinsics.checkNotNullParameter(r310, "botId");
        Intrinsics.checkNotNullParameter(r311, "name");
        Intrinsics.checkNotNullParameter(r312, "description");
        Intrinsics.checkNotNullParameter(r313, "bio");
        Intrinsics.checkNotNullParameter(r314, "iconUrl");
        Intrinsics.checkNotNullParameter(r315, "iconUri");
        Intrinsics.checkNotNullParameter(r410, "avatarPrompt");
        return new BotEditParam(r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BotEditParam) == true) goto L8;
        return false;
    L8:
        BotEditParam r101 = (BotEditParam) r100;
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bio, r101.bio) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.iconUri, r101.iconUri) == true) goto L27;
        return false;
    L27:
        if (this.modelType == r101.modelType) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.voice, r101.voice) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.language, r101.language) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.avatarPrompt, r101.avatarPrompt) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.avatarPromptForEnrich, r101.avatarPromptForEnrich) == true) goto L42;
        return false;
    L42:
        if (this.hasUsedAutoFill == r101.hasUsedAutoFill) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.enableWebSearch, r101.enableWebSearch) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.enableGenPic, r101.enableGenPic) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.modelItem, r101.modelItem) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.muted, r101.muted) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.prologue, r101.prologue) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.suggestSwitch, r101.suggestSwitch) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.suggests, r101.suggests) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.bgImage, r101.bgImage) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.userBotTypeStarlingKey, r101.userBotTypeStarlingKey) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.userBotGenderStarlingKey, r101.userBotGenderStarlingKey) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.originalUserImgUri, r101.originalUserImgUri) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.originalAvatarImgUri, r101.originalAvatarImgUri) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.originalBackgroundImgUri, r101.originalBackgroundImgUri) == true) goto L83;
        return false;
    L83:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((((this.botId.hashCode() * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.bio.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.iconUri.hashCode()) * 31;
        long r101 = this.modelType;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        SpeakerVoice r103 = this.voice;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (r102 + r105) * 31;
        BotLanguage r107 = this.language;
        if (r107 != null) goto L9;
        int r108 = 0;
    L10:
        int r109 = (((r106 + r108) * 31) + this.avatarPrompt.hashCode()) * 31;
        String r110 = this.avatarPromptForEnrich;
        if (r110 != null) goto L13;
        int r111 = 0;
    L14:
        int r112 = (r109 + r111) * 31;
        if (this.hasUsedAutoFill == false) goto L17;
        int r113 = 1231;
    L18:
        int r114 = (r112 + r113) * 31;
        Boolean r115 = this.enableWebSearch;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        int r117 = (r114 + r116) * 31;
        Boolean r118 = this.enableGenPic;
        if (r118 != null) goto L25;
        int r119 = 0;
    L26:
        int r120 = (r117 + r119) * 31;
        ModelItem r121 = this.modelItem;
        if (r121 != null) goto L29;
        int r122 = 0;
    L30:
        int r123 = (r120 + r122) * 31;
        Boolean r124 = this.muted;
        if (r124 != null) goto L33;
        int r125 = 0;
    L34:
        int r126 = (r123 + r125) * 31;
        String r127 = this.prologue;
        if (r127 != null) goto L37;
        int r128 = 0;
    L38:
        int r129 = (r126 + r128) * 31;
        Boolean r130 = this.suggestSwitch;
        if (r130 != null) goto L41;
        int r131 = 0;
    L42:
        int r132 = (r129 + r131) * 31;
        Triple<String, String, String> r133 = this.suggests;
        if (r133 != null) goto L45;
        int r134 = 0;
    L46:
        int r135 = (r132 + r134) * 31;
        BgImage r136 = this.bgImage;
        if (r136 != null) goto L49;
        int r137 = 0;
    L50:
        int r138 = (r135 + r137) * 31;
        String r139 = this.userBotTypeStarlingKey;
        if (r139 != null) goto L53;
        int r140 = 0;
    L54:
        int r141 = (r138 + r140) * 31;
        String r142 = this.userBotGenderStarlingKey;
        if (r142 != null) goto L57;
        int r143 = 0;
    L58:
        int r144 = (r141 + r143) * 31;
        String r145 = this.originalUserImgUri;
        if (r145 != null) goto L61;
        int r146 = 0;
    L62:
        int r147 = (r144 + r146) * 31;
        String r148 = this.originalAvatarImgUri;
        if (r148 != null) goto L65;
        int r149 = 0;
    L66:
        int r150 = (r147 + r149) * 31;
        String r151 = this.originalBackgroundImgUri;
        if (r151 == null) goto L71;
        r104 = r151.hashCode();
    L71:
        return r150 + r104;
    L65:
        r149 = r148.hashCode();
        goto L66
    L61:
        r146 = r145.hashCode();
        goto L62
    L57:
        r143 = r142.hashCode();
        goto L58
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
        r113 = 1237;
        goto L18
    L13:
        r111 = r110.hashCode();
        goto L14
    L9:
        r108 = r107.hashCode();
        goto L10
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public String toString() {
        return "BotEditParam(botId=" + this.botId + ", name=" + this.name + ", description=" + this.description + ", bio=" + this.bio + ", iconUrl=" + this.iconUrl + ", iconUri=" + this.iconUri + ", modelType=" + this.modelType + ", voice=" + this.voice + ", language=" + this.language + ", avatarPrompt=" + this.avatarPrompt + ", avatarPromptForEnrich=" + this.avatarPromptForEnrich + ", hasUsedAutoFill=" + this.hasUsedAutoFill + ", enableWebSearch=" + this.enableWebSearch + ", enableGenPic=" + this.enableGenPic + ", modelItem=" + this.modelItem + ", muted=" + this.muted + ", prologue=" + this.prologue + ", suggestSwitch=" + this.suggestSwitch + ", suggests=" + this.suggests + ", bgImage=" + this.bgImage + ", userBotTypeStarlingKey=" + this.userBotTypeStarlingKey + ", userBotGenderStarlingKey=" + this.userBotGenderStarlingKey + ", originalUserImgUri=" + this.originalUserImgUri + ", originalAvatarImgUri=" + this.originalAvatarImgUri + ", originalBackgroundImgUri=" + this.originalBackgroundImgUri + ')';
    }

    public final void reset() {
        this.botId = "";
        this.name = "";
        this.description = "";
        this.iconUrl = "";
        this.iconUri = "";
        this.modelType = 0;
        this.voice = null;
        this.language = null;
        this.hasUsedAutoFill = false;
        this.enableGenPic = null;
        this.enableWebSearch = null;
        this.modelItem = null;
        this.muted = null;
        this.prologue = null;
        this.suggestSwitch = null;
        this.suggests = null;
        this.bgImage = null;
        this.userBotTypeStarlingKey = null;
        this.userBotGenderStarlingKey = null;
        this.originalUserImgUri = null;
        this.originalAvatarImgUri = null;
        this.originalBackgroundImgUri = null;
    }

    public final String getAvatarPrompt() {
        return this.avatarPrompt;
    }

    public final String getAvatarPromptForEnrich() {
        return this.avatarPromptForEnrich;
    }

    public final BgImage getBgImage() {
        return this.bgImage;
    }

    public final String getBio() {
        return this.bio;
    }

    public final String getBotId() {
        return this.botId;
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

    public final boolean getHasUsedAutoFill() {
        return this.hasUsedAutoFill;
    }

    public final String getIconUri() {
        return this.iconUri;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final BotLanguage getLanguage() {
        return this.language;
    }

    public final ModelItem getModelItem() {
        return this.modelItem;
    }

    public final long getModelType() {
        return this.modelType;
    }

    public final Boolean getMuted() {
        return this.muted;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOriginalAvatarImgUri() {
        return this.originalAvatarImgUri;
    }

    public final String getOriginalBackgroundImgUri() {
        return this.originalBackgroundImgUri;
    }

    public final String getOriginalUserImgUri() {
        return this.originalUserImgUri;
    }

    public final String getPrologue() {
        return this.prologue;
    }

    public final Boolean getSuggestSwitch() {
        return this.suggestSwitch;
    }

    public final Triple<String, String, String> getSuggests() {
        return this.suggests;
    }

    public final String getUserBotGenderStarlingKey() {
        return this.userBotGenderStarlingKey;
    }

    public final String getUserBotTypeStarlingKey() {
        return this.userBotTypeStarlingKey;
    }

    public final SpeakerVoice getVoice() {
        return this.voice;
    }

    public final void setAvatarPrompt(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.avatarPrompt = r100;
    }

    public final void setAvatarPromptForEnrich(String r100) {
        this.avatarPromptForEnrich = r100;
    }

    public final void setBgImage(BgImage r100) {
        this.bgImage = r100;
    }

    public final void setBio(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.bio = r100;
    }

    public final void setBotId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.botId = r100;
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

    public final void setIconUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.iconUrl = r100;
    }

    public final void setLanguage(BotLanguage r100) {
        this.language = r100;
    }

    public final void setModelItem(ModelItem r100) {
        this.modelItem = r100;
    }

    public final void setModelType(long r100) {
        this.modelType = r100;
    }

    public final void setMuted(Boolean r100) {
        this.muted = r100;
    }

    public final void setName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.name = r100;
    }

    public final void setOriginalAvatarImgUri(String r100) {
        this.originalAvatarImgUri = r100;
    }

    public final void setOriginalBackgroundImgUri(String r100) {
        this.originalBackgroundImgUri = r100;
    }

    public final void setOriginalUserImgUri(String r100) {
        this.originalUserImgUri = r100;
    }

    public final void setPrologue(String r100) {
        this.prologue = r100;
    }

    public final void setSuggestSwitch(Boolean r100) {
        this.suggestSwitch = r100;
    }

    public final void setSuggests(Triple<String, String, String> r100) {
        this.suggests = r100;
    }

    public final void setUserBotGenderStarlingKey(String r100) {
        this.userBotGenderStarlingKey = r100;
    }

    public final void setUserBotTypeStarlingKey(String r100) {
        this.userBotTypeStarlingKey = r100;
    }

    public final void setVoice(SpeakerVoice r100) {
        this.voice = r100;
    }

    public BotEditParam(String r110, String r111, String r112, String r113, String r114, String r115, long r116, SpeakerVoice r117, BotLanguage r118, String r210, String r211, boolean r212, Boolean r213, Boolean r214, ModelItem r215, Boolean r216, String r217, Boolean r218, Triple<String, String, String> r219, BgImage r310, String r311, String r312, String r313, String r314, String r315) {
        Intrinsics.checkNotNullParameter(r110, "botId");
        Intrinsics.checkNotNullParameter(r111, "name");
        Intrinsics.checkNotNullParameter(r112, "description");
        Intrinsics.checkNotNullParameter(r113, "bio");
        Intrinsics.checkNotNullParameter(r114, "iconUrl");
        Intrinsics.checkNotNullParameter(r115, "iconUri");
        Intrinsics.checkNotNullParameter(r210, "avatarPrompt");
        this.botId = r110;
        this.name = r111;
        this.description = r112;
        this.bio = r113;
        this.iconUrl = r114;
        this.iconUri = r115;
        this.modelType = r116;
        this.voice = r117;
        this.language = r118;
        this.avatarPrompt = r210;
        this.avatarPromptForEnrich = r211;
        this.hasUsedAutoFill = r212;
        this.enableWebSearch = r213;
        this.enableGenPic = r214;
        this.modelItem = r215;
        this.muted = r216;
        this.prologue = r217;
        this.suggestSwitch = r218;
        this.suggests = r219;
        this.bgImage = r310;
        this.userBotTypeStarlingKey = r311;
        this.userBotGenderStarlingKey = r312;
        this.originalUserImgUri = r313;
        this.originalAvatarImgUri = r314;
        this.originalBackgroundImgUri = r315;
    }

    public /* synthetic */ BotEditParam(String r210, String r211, String r212, String r310, String r311, String r312, long r313, SpeakerVoice r314, BotLanguage r315, String r316, String r317, boolean r318, Boolean r410, Boolean r411, ModelItem r412, Boolean r413, String r414, Boolean r415, Triple r416, BgImage r417, String r418, String r419, String r510, String r511, String r512, int r513, DefaultConstructorMarker r514) {
        String r100 = "";
        if ((r513 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r513 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r513 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r513 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r513 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r513 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r513 & 64) == 0) goto L29;
        long r107 = 0;
    L31:
        if ((r513 & 128) == 0) goto L33;
        SpeakerVoice r110 = null;
    L35:
        if ((r513 & 256) == 0) goto L37;
        BotLanguage r111 = null;
    L39:
        if ((r513 & 512) != 0) goto L43;
        r100 = r316;
    L43:
        if ((r513 & 1024) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r513 & 2048) == 0) goto L49;
        boolean r113 = false;
    L51:
        if ((r513 & 4096) == 0) goto L53;
        Boolean r114 = null;
    L55:
        if ((r513 & 8192) == 0) goto L57;
        Boolean r115 = null;
    L58:
        Boolean r515 = r115;
        if ((r513 & 16384) == 0) goto L61;
        ModelItem r116 = null;
    L63:
        if ((r513 & 32768) == 0) goto L65;
        Boolean r117 = null;
    L67:
        if ((r513 & 65536) == 0) goto L69;
        String r118 = null;
    L71:
        if ((r513 & 131072) == 0) goto L73;
        Boolean r119 = null;
    L75:
        if ((r513 & 262144) == 0) goto L77;
        Triple r120 = null;
    L79:
        if ((r513 & 524288) == 0) goto L81;
        BgImage r213 = null;
    L83:
        if ((r513 & 1048576) == 0) goto L85;
        String r214 = null;
    L87:
        if ((r513 & 2097152) == 0) goto L89;
        String r215 = null;
    L91:
        if ((r513 & 4194304) == 0) goto L93;
        String r216 = null;
    L95:
        if ((r513 & 8388608) == 0) goto L97;
        String r217 = null;
    L99:
        if ((r513 & 16777216) == 0) goto L101;
        String r108 = null;
    L102:
        this(r101, r102, r103, r104, r105, r106, r107, r110, r111, r100, r112, r113, r114, r515, r116, r117, r118, r119, r120, r213, r214, r215, r216, r217, r108);
        return;
    L101:
        r108 = r512;
        goto L102
    L97:
        r217 = r511;
        goto L99
    L93:
        r216 = r510;
        goto L95
    L89:
        r215 = r419;
        goto L91
    L85:
        r214 = r418;
        goto L87
    L81:
        r213 = r417;
        goto L83
    L77:
        r120 = r416;
        goto L79
    L73:
        r119 = r415;
        goto L75
    L69:
        r118 = r414;
        goto L71
    L65:
        r117 = r413;
        goto L67
    L61:
        r116 = r412;
        goto L63
    L57:
        r115 = r411;
        goto L58
    L53:
        r114 = r410;
        goto L55
    L49:
        r113 = r318;
        goto L51
    L45:
        r112 = r317;
        goto L47
    L37:
        r111 = r315;
        goto L39
    L33:
        r110 = r314;
        goto L35
    L29:
        r107 = r313;
        goto L31
    L25:
        r106 = r312;
        goto L27
    L21:
        r105 = r311;
        goto L23
    L17:
        r104 = r310;
        goto L19
    L13:
        r103 = r212;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r101 = r210;
        goto L7
    }
}
