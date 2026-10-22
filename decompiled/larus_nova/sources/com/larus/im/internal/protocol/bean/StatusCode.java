package com.larus.im.internal.protocol.bean;

import af9.i2;
import java.lang.annotation.Annotation;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import nuc.i0;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\b\u0087\u0081\u0002\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001aB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/larus/im/internal/protocol/bean/StatusCode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "OK", "ErasePrompt", "SelfSeePrompt", "UserNotInConv", "ConversationDissolved", "ConversationDelete", "TouristReachLimit", "RateLimit", "BotInvalid", "BotBanned", "BotReviewing", "BotPrivate", "LoginInvalid", "SharkBlock", "CountryRestricted", "UserBanned", "UserBanAppealFailed", "UserBanAppealing", "SecurityTeeGatewayError", "DataNotExist", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum StatusCode extends Enum<StatusCode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ StatusCode[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;

    @SerialName("710022010")
    public static final StatusCode BotBanned = null;

    @SerialName("710022005")
    public static final StatusCode BotInvalid = null;

    @SerialName("710022016")
    public static final StatusCode BotPrivate = null;

    @SerialName("710022011")
    public static final StatusCode BotReviewing = null;
    public static final a Companion = null;

    @SerialName("712013001")
    public static final StatusCode ConversationDelete = null;

    @SerialName("712013003")
    public static final StatusCode ConversationDissolved = null;

    @SerialName("710022003")
    public static final StatusCode CountryRestricted = null;

    @SerialName("712017001")
    public static final StatusCode DataNotExist = null;

    @SerialName("712014001")
    public static final StatusCode ErasePrompt = null;

    @SerialName("710012001")
    public static final StatusCode LoginInvalid = null;

    @SerialName("0")
    public static final StatusCode OK = null;

    @SerialName("710022004")
    public static final StatusCode RateLimit = null;

    @SerialName("710992000")
    public static final StatusCode SecurityTeeGatewayError = null;

    @SerialName("712014003")
    public static final StatusCode SelfSeePrompt = null;

    @SerialName("710022002")
    public static final StatusCode SharkBlock = null;

    @SerialName("710022013")
    public static final StatusCode TouristReachLimit = null;

    @SerialName("710012010")
    public static final StatusCode UserBanAppealFailed = null;

    @SerialName("710012011")
    public static final StatusCode UserBanAppealing = null;

    @SerialName("710012008")
    public static final StatusCode UserBanned = null;

    @SerialName("712013104")
    public static final StatusCode UserNotInConv = null;
    public final int value;

    private static final /* synthetic */ StatusCode[] $values() {
        return new StatusCode[]{OK, ErasePrompt, SelfSeePrompt, UserNotInConv, ConversationDissolved, ConversationDelete, TouristReachLimit, RateLimit, BotInvalid, BotBanned, BotReviewing, BotPrivate, LoginInvalid, SharkBlock, CountryRestricted, UserBanned, UserBanAppealFailed, UserBanAppealing, SecurityTeeGatewayError, DataNotExist};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    public static EnumEntries<StatusCode> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v22, types: [com.larus.im.internal.protocol.bean.StatusCode$a] */
    static {
        OK = new StatusCode("OK", 0, 0);
        ErasePrompt = new StatusCode("ErasePrompt", 1, 712014001);
        SelfSeePrompt = new StatusCode("SelfSeePrompt", 2, 712014003);
        UserNotInConv = new StatusCode("UserNotInConv", 3, 712013104);
        ConversationDissolved = new StatusCode("ConversationDissolved", 4, 712013003);
        ConversationDelete = new StatusCode("ConversationDelete", 5, 712013001);
        TouristReachLimit = new StatusCode("TouristReachLimit", 6, 710022013);
        RateLimit = new StatusCode("RateLimit", 7, 710022004);
        BotInvalid = new StatusCode("BotInvalid", 8, 710022005);
        BotBanned = new StatusCode("BotBanned", 9, 710022010);
        BotReviewing = new StatusCode("BotReviewing", 10, 710022011);
        BotPrivate = new StatusCode("BotPrivate", 11, 710022016);
        LoginInvalid = new StatusCode("LoginInvalid", 12, 710012001);
        SharkBlock = new StatusCode("SharkBlock", 13, 710022002);
        CountryRestricted = new StatusCode("CountryRestricted", 14, 710022003);
        UserBanned = new StatusCode("UserBanned", 15, 710012008);
        UserBanAppealFailed = new StatusCode("UserBanAppealFailed", 16, 710012010);
        UserBanAppealing = new StatusCode("UserBanAppealing", 17, 710012011);
        SecurityTeeGatewayError = new StatusCode("SecurityTeeGatewayError", 18, 710992000);
        DataNotExist = new StatusCode("DataNotExist", 19, 712017001);
        StatusCode[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new i2());
    }

    public static StatusCode[] values() {
        return (StatusCode[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.protocol.bean.StatusCode", values(), new String[]{"0", "712014001", "712014003", "712013104", "712013003", "712013001", "710022013", "710022004", "710022005", "710022010", "710022011", "710022016", "710012001", "710022002", "710022003", "710012008", "710012010", "710012011", "710992000", "712017001"}, new Annotation[][]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static StatusCode valueOf(String r100) {
        return (StatusCode) r27.a.a(StatusCode.class, r100);
    }

    private StatusCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
