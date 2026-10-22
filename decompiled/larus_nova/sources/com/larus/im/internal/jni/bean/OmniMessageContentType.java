package com.larus.im.internal.jni.bean;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.larus.im.internal.delegate.d1;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import com.tencent.connect.common.Constants;
import de9.q8;
import java.lang.annotation.Annotation;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import nuc.i0;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b$\b\u0087\u0081\u0002\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001&B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%¨\u0006'"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniMessageContentType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "UNSPECIFIED", "TIME_STAMP", "DISCLAIMER_BIO", "IMMERSIVE_BIO", "FAKE_REPLY", "CLEAR_CONTEXT", "TXT", "SUGGEST", "MUSIC", "WEBVIEW", "VIDEO", "IMAGE", "FILE", "SEARCH_LIST", "AWEME_VIDEO_LIST", "AUDIO_TXT", "CARD", "BOT_MAKER", "FORM_MSG", "EXPERT", "CONTENT_TYPE_MULTI_CONTENT", "CONTENT_TYPE_USER_EVALUATE", "CONTENT_TYPE_LYRICS_TO_SONG", "CONTENT_TYPE_LYRICS_TO_SONG_LYRIC", "CONTENT_TYPE_LYRICS_TO_SONGS_BY_LIST", "WIDGET", FlowDoraWifiScene.OTHER, "SYS_MSG", "TIPS", "CONTENT_TYPE_VIDEO_GENERATE", "CONTENT_TYPE_CREATION", "BLOCK_CONTENT", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum OmniMessageContentType extends Enum<OmniMessageContentType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OmniMessageContentType[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;

    @SerialName("11")
    public static final OmniMessageContentType AUDIO_TXT = null;

    @SerialName(Constants.VIA_SHARE_TYPE_MINI_PROGRAM)
    public static final OmniMessageContentType AWEME_VIDEO_LIST = null;

    @SerialName("9999")
    public static final OmniMessageContentType BLOCK_CONTENT = null;

    @SerialName("51")
    public static final OmniMessageContentType BOT_MAKER = null;

    @SerialName("50")
    public static final OmniMessageContentType CARD = null;

    @SerialName("-1")
    public static final OmniMessageContentType CLEAR_CONTEXT = null;

    @SerialName("2022")
    public static final OmniMessageContentType CONTENT_TYPE_CREATION = null;

    @SerialName(BDLocationException.ERROR_NETWORK_REQUEST)
    public static final OmniMessageContentType CONTENT_TYPE_LYRICS_TO_SONG = null;

    @SerialName(BDLocationException.ERROR_WIFI_UPLOAD)
    public static final OmniMessageContentType CONTENT_TYPE_LYRICS_TO_SONGS_BY_LIST = null;

    @SerialName("71")
    public static final OmniMessageContentType CONTENT_TYPE_LYRICS_TO_SONG_LYRIC = null;

    @SerialName(BDLocationException.ERROR_JSON_CONVERT)
    public static final OmniMessageContentType CONTENT_TYPE_MULTI_CONTENT = null;

    @SerialName("67")
    public static final OmniMessageContentType CONTENT_TYPE_USER_EVALUATE = null;

    @SerialName("2021")
    public static final OmniMessageContentType CONTENT_TYPE_VIDEO_GENERATE = null;
    public static final Companion Companion = null;

    @SerialName(OnekeyLoginConstants.ErrorCode.ERROR_CU_REQUEST_TIMEOUT)
    public static final OmniMessageContentType DISCLAIMER_BIO = null;

    @SerialName(BDLocationException.ERROR_NO_LOCATE)
    public static final OmniMessageContentType EXPERT = null;

    @SerialName("-2")
    public static final OmniMessageContentType FAKE_REPLY = null;

    @SerialName("7")
    public static final OmniMessageContentType FILE = null;

    @SerialName("53")
    public static final OmniMessageContentType FORM_MSG = null;

    @SerialName("6")
    public static final OmniMessageContentType IMAGE = null;

    @SerialName("-3")
    public static final OmniMessageContentType IMMERSIVE_BIO = null;

    @SerialName("3")
    public static final OmniMessageContentType MUSIC = null;

    @SerialName("800")
    public static final OmniMessageContentType OTHER = null;

    @SerialName("8")
    public static final OmniMessageContentType SEARCH_LIST = null;

    @SerialName("2")
    public static final OmniMessageContentType SUGGEST = null;

    @SerialName(AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF)
    public static final OmniMessageContentType SYS_MSG = null;

    @SerialName(OnekeyLoginConstants.ErrorCode.ERROR_CARRIER_DISABLED)
    public static final OmniMessageContentType TIME_STAMP = null;

    @SerialName("1003")
    public static final OmniMessageContentType TIPS = null;

    @SerialName("1")
    public static final OmniMessageContentType TXT = null;

    @SerialName("0")
    public static final OmniMessageContentType UNSPECIFIED = null;

    @SerialName("5")
    public static final OmniMessageContentType VIDEO = null;

    @SerialName("4")
    public static final OmniMessageContentType WEBVIEW = null;

    @SerialName("100")
    public static final OmniMessageContentType WIDGET = null;
    public final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniMessageContentType$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/OmniMessageContentType;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) OmniMessageContentType.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<OmniMessageContentType> serializer() {
            return get$cachedSerializer();
        }

        @JvmStatic
        public final OmniMessageContentType findByValue(int r100) {
            if (r100 == 11) goto L65;
            if (r100 == 53) goto L97;
            if (r100 == 60) goto L96;
            if (r100 == 100) goto L95;
            if (r100 == 800) goto L94;
            if (r100 == 1001) goto L93;
            if (r100 == 1003) goto L92;
            if (r100 == 9999) goto L91;
            if (r100 == 50) goto L90;
            if (r100 == 51) goto L89;
            if (r100 == 66) goto L88;
            if (r100 == 67) goto L87;
            if (r100 == 2021) goto L86;
            if (r100 == 2022) goto L85;
            switch(r100) {
                case -5: goto L84;
                case -4: goto L83;
                case -3: goto L82;
                case -2: goto L81;
                case -1: goto L80;
                case 0: goto L79;
                case 1: goto L78;
                case 2: goto L77;
                case 3: goto L76;
                case 4: goto L75;
                case 5: goto L74;
                case 6: goto L73;
                case 7: goto L72;
                case 8: goto L71;
                case 9: goto L70;
                default: goto L31;
            };
        L31:
            switch(r100) {
                case 70: goto L69;
                case 71: goto L68;
                case 72: goto L67;
                default: goto L32;
            };
        L32:
            d1.f348206b.b("enum", "OmniMessageContentType unknown value: " + r100);
            return OmniMessageContentType.UNSPECIFIED;
        L67:
            return OmniMessageContentType.CONTENT_TYPE_LYRICS_TO_SONGS_BY_LIST;
        L68:
            return OmniMessageContentType.CONTENT_TYPE_LYRICS_TO_SONG_LYRIC;
        L69:
            return OmniMessageContentType.CONTENT_TYPE_LYRICS_TO_SONG;
        L70:
            return OmniMessageContentType.AWEME_VIDEO_LIST;
        L71:
            return OmniMessageContentType.SEARCH_LIST;
        L72:
            return OmniMessageContentType.FILE;
        L73:
            return OmniMessageContentType.IMAGE;
        L74:
            return OmniMessageContentType.VIDEO;
        L75:
            return OmniMessageContentType.WEBVIEW;
        L76:
            return OmniMessageContentType.MUSIC;
        L77:
            return OmniMessageContentType.SUGGEST;
        L78:
            return OmniMessageContentType.TXT;
        L79:
            return OmniMessageContentType.UNSPECIFIED;
        L80:
            return OmniMessageContentType.CLEAR_CONTEXT;
        L81:
            return OmniMessageContentType.FAKE_REPLY;
        L82:
            return OmniMessageContentType.IMMERSIVE_BIO;
        L83:
            return OmniMessageContentType.DISCLAIMER_BIO;
        L84:
            return OmniMessageContentType.TIME_STAMP;
        L85:
            return OmniMessageContentType.CONTENT_TYPE_CREATION;
        L86:
            return OmniMessageContentType.CONTENT_TYPE_VIDEO_GENERATE;
        L87:
            return OmniMessageContentType.CONTENT_TYPE_USER_EVALUATE;
        L88:
            return OmniMessageContentType.CONTENT_TYPE_MULTI_CONTENT;
        L89:
            return OmniMessageContentType.BOT_MAKER;
        L90:
            return OmniMessageContentType.CARD;
        L91:
            return OmniMessageContentType.BLOCK_CONTENT;
        L92:
            return OmniMessageContentType.TIPS;
        L93:
            return OmniMessageContentType.SYS_MSG;
        L94:
            return OmniMessageContentType.OTHER;
        L95:
            return OmniMessageContentType.WIDGET;
        L96:
            return OmniMessageContentType.EXPERT;
        L97:
            return OmniMessageContentType.FORM_MSG;
        L65:
            return OmniMessageContentType.AUDIO_TXT;
        }
    }

    private static final /* synthetic */ OmniMessageContentType[] $values() {
        return new OmniMessageContentType[]{UNSPECIFIED, TIME_STAMP, DISCLAIMER_BIO, IMMERSIVE_BIO, FAKE_REPLY, CLEAR_CONTEXT, TXT, SUGGEST, MUSIC, WEBVIEW, VIDEO, IMAGE, FILE, SEARCH_LIST, AWEME_VIDEO_LIST, AUDIO_TXT, CARD, BOT_MAKER, FORM_MSG, EXPERT, CONTENT_TYPE_MULTI_CONTENT, CONTENT_TYPE_USER_EVALUATE, CONTENT_TYPE_LYRICS_TO_SONG, CONTENT_TYPE_LYRICS_TO_SONG_LYRIC, CONTENT_TYPE_LYRICS_TO_SONGS_BY_LIST, WIDGET, OTHER, SYS_MSG, TIPS, CONTENT_TYPE_VIDEO_GENERATE, CONTENT_TYPE_CREATION, BLOCK_CONTENT};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    @JvmStatic
    public static final OmniMessageContentType findByValue(int r100) {
        return Companion.findByValue(r100);
    }

    public static EnumEntries<OmniMessageContentType> getEntries() {
        return $ENTRIES;
    }

    static {
        UNSPECIFIED = new OmniMessageContentType("UNSPECIFIED", 0, 0);
        TIME_STAMP = new OmniMessageContentType("TIME_STAMP", 1, -5);
        DISCLAIMER_BIO = new OmniMessageContentType("DISCLAIMER_BIO", 2, -4);
        IMMERSIVE_BIO = new OmniMessageContentType("IMMERSIVE_BIO", 3, -3);
        FAKE_REPLY = new OmniMessageContentType("FAKE_REPLY", 4, -2);
        CLEAR_CONTEXT = new OmniMessageContentType("CLEAR_CONTEXT", 5, -1);
        TXT = new OmniMessageContentType("TXT", 6, 1);
        SUGGEST = new OmniMessageContentType("SUGGEST", 7, 2);
        MUSIC = new OmniMessageContentType("MUSIC", 8, 3);
        WEBVIEW = new OmniMessageContentType("WEBVIEW", 9, 4);
        VIDEO = new OmniMessageContentType("VIDEO", 10, 5);
        IMAGE = new OmniMessageContentType("IMAGE", 11, 6);
        FILE = new OmniMessageContentType("FILE", 12, 7);
        SEARCH_LIST = new OmniMessageContentType("SEARCH_LIST", 13, 8);
        AWEME_VIDEO_LIST = new OmniMessageContentType("AWEME_VIDEO_LIST", 14, 9);
        AUDIO_TXT = new OmniMessageContentType("AUDIO_TXT", 15, 11);
        CARD = new OmniMessageContentType("CARD", 16, 50);
        BOT_MAKER = new OmniMessageContentType("BOT_MAKER", 17, 51);
        FORM_MSG = new OmniMessageContentType("FORM_MSG", 18, 53);
        EXPERT = new OmniMessageContentType("EXPERT", 19, 60);
        CONTENT_TYPE_MULTI_CONTENT = new OmniMessageContentType("CONTENT_TYPE_MULTI_CONTENT", 20, 66);
        CONTENT_TYPE_USER_EVALUATE = new OmniMessageContentType("CONTENT_TYPE_USER_EVALUATE", 21, 67);
        CONTENT_TYPE_LYRICS_TO_SONG = new OmniMessageContentType("CONTENT_TYPE_LYRICS_TO_SONG", 22, 70);
        CONTENT_TYPE_LYRICS_TO_SONG_LYRIC = new OmniMessageContentType("CONTENT_TYPE_LYRICS_TO_SONG_LYRIC", 23, 71);
        CONTENT_TYPE_LYRICS_TO_SONGS_BY_LIST = new OmniMessageContentType("CONTENT_TYPE_LYRICS_TO_SONGS_BY_LIST", 24, 72);
        WIDGET = new OmniMessageContentType("WIDGET", 25, 100);
        OTHER = new OmniMessageContentType(FlowDoraWifiScene.OTHER, 26, 800);
        SYS_MSG = new OmniMessageContentType("SYS_MSG", 27, 1001);
        TIPS = new OmniMessageContentType("TIPS", 28, 1003);
        CONTENT_TYPE_VIDEO_GENERATE = new OmniMessageContentType("CONTENT_TYPE_VIDEO_GENERATE", 29, 2021);
        CONTENT_TYPE_CREATION = new OmniMessageContentType("CONTENT_TYPE_CREATION", 30, 2022);
        BLOCK_CONTENT = new OmniMessageContentType("BLOCK_CONTENT", 31, 9999);
        OmniMessageContentType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new q8());
    }

    public static OmniMessageContentType[] values() {
        return (OmniMessageContentType[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.OmniMessageContentType", values(), new String[]{"0", OnekeyLoginConstants.ErrorCode.ERROR_CARRIER_DISABLED, OnekeyLoginConstants.ErrorCode.ERROR_CU_REQUEST_TIMEOUT, "-3", "-2", "-1", "1", "2", "3", "4", "5", "6", "7", "8", Constants.VIA_SHARE_TYPE_MINI_PROGRAM, "11", "50", "51", "53", BDLocationException.ERROR_NO_LOCATE, BDLocationException.ERROR_JSON_CONVERT, "67", BDLocationException.ERROR_NETWORK_REQUEST, "71", BDLocationException.ERROR_WIFI_UPLOAD, "100", "800", AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF, "1003", "2021", "2022", "9999"}, new Annotation[][]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static OmniMessageContentType valueOf(String r100) {
        return (OmniMessageContentType) a.a(OmniMessageContentType.class, r100);
    }

    private OmniMessageContentType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
