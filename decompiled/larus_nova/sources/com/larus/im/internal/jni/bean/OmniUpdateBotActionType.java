package com.larus.im.internal.jni.bean;

import com.larus.im.internal.delegate.d1;
import com.tencent.connect.common.Constants;
import de9.rb;
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

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\b\u0087\u0081\u0002\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001aB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniUpdateBotActionType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "OmniUpdateBotActionType_NAME", "OmniUpdateBotActionType_DESC", "OmniUpdateBotActionType_ICON", "OmniUpdateBotActionType_MODEL_TYPE", "OmniUpdateBotActionType_LANGUAGE", "OmniUpdateBotActionType_VOICE_TYPE", "OmniUpdateBotActionType_MUTED", "OmniUpdateBotActionType_DELETE", "OmniUpdateBotActionType_VISIBILITY", "OmniUpdateBotActionType_MESSAGE_PUSH", "OmniUpdateBotActionType_WEB_SEARCH", "OmniUpdateBotActionType_PIC_GEN", "OmniUpdateBotActionType_FIRST_MET", "OmniUpdateBotActionType_BG_IMG_URI", "OmniUpdateBotActionType_BG_IMG_INFO", "OmniUpdateBotActionType_MEMORY", "OmniUpdateBotActionType_DYNAMIC_IMG_URI", "OmniUpdateBotActionType_DYNAMIC_IMG_URL", "OmniUpdateBotActionType_BOT_ICON_MAPPED_APP_ICON", "OmniUpdateBotActionType_USER_EDIT_BIO", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum OmniUpdateBotActionType extends Enum<OmniUpdateBotActionType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OmniUpdateBotActionType[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final Companion Companion = null;

    @SerialName(Constants.VIA_REPORT_TYPE_MAKE_FRIEND)
    public static final OmniUpdateBotActionType OmniUpdateBotActionType_BG_IMG_INFO = null;

    @SerialName("13")
    public static final OmniUpdateBotActionType OmniUpdateBotActionType_BG_IMG_URI = null;

    @SerialName("18")
    public static final OmniUpdateBotActionType OmniUpdateBotActionType_BOT_ICON_MAPPED_APP_ICON = null;

    @SerialName("7")
    public static final OmniUpdateBotActionType OmniUpdateBotActionType_DELETE = null;

    @SerialName("1")
    public static final OmniUpdateBotActionType OmniUpdateBotActionType_DESC = null;

    @SerialName(Constants.VIA_REPORT_TYPE_START_WAP)
    public static final OmniUpdateBotActionType OmniUpdateBotActionType_DYNAMIC_IMG_URI = null;

    @SerialName(Constants.VIA_REPORT_TYPE_START_GROUP)
    public static final OmniUpdateBotActionType OmniUpdateBotActionType_DYNAMIC_IMG_URL = null;

    @SerialName("12")
    public static final OmniUpdateBotActionType OmniUpdateBotActionType_FIRST_MET = null;

    @SerialName("2")
    public static final OmniUpdateBotActionType OmniUpdateBotActionType_ICON = null;

    @SerialName("4")
    public static final OmniUpdateBotActionType OmniUpdateBotActionType_LANGUAGE = null;

    @SerialName(Constants.VIA_REPORT_TYPE_WPA_STATE)
    public static final OmniUpdateBotActionType OmniUpdateBotActionType_MEMORY = null;

    @SerialName(Constants.VIA_SHARE_TYPE_MINI_PROGRAM)
    public static final OmniUpdateBotActionType OmniUpdateBotActionType_MESSAGE_PUSH = null;

    @SerialName("3")
    public static final OmniUpdateBotActionType OmniUpdateBotActionType_MODEL_TYPE = null;

    @SerialName("6")
    public static final OmniUpdateBotActionType OmniUpdateBotActionType_MUTED = null;

    @SerialName("0")
    public static final OmniUpdateBotActionType OmniUpdateBotActionType_NAME = null;

    @SerialName("11")
    public static final OmniUpdateBotActionType OmniUpdateBotActionType_PIC_GEN = null;

    @SerialName(Constants.VIA_ACT_TYPE_NINETEEN)
    public static final OmniUpdateBotActionType OmniUpdateBotActionType_USER_EDIT_BIO = null;

    @SerialName("8")
    public static final OmniUpdateBotActionType OmniUpdateBotActionType_VISIBILITY = null;

    @SerialName("5")
    public static final OmniUpdateBotActionType OmniUpdateBotActionType_VOICE_TYPE = null;

    @SerialName(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ)
    public static final OmniUpdateBotActionType OmniUpdateBotActionType_WEB_SEARCH = null;
    public final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniUpdateBotActionType$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/OmniUpdateBotActionType;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) OmniUpdateBotActionType.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<OmniUpdateBotActionType> serializer() {
            return get$cachedSerializer();
        }

        @JvmStatic
        public final OmniUpdateBotActionType findByValue(int r100) {
            switch(r100) {
                case 0: goto L24;
                case 1: goto L44;
                case 2: goto L43;
                case 3: goto L42;
                case 4: goto L41;
                case 5: goto L40;
                case 6: goto L39;
                case 7: goto L38;
                case 8: goto L37;
                case 9: goto L36;
                case 10: goto L35;
                case 11: goto L34;
                case 12: goto L33;
                case 13: goto L32;
                case 14: goto L31;
                case 15: goto L30;
                case 16: goto L29;
                case 17: goto L28;
                case 18: goto L27;
                case 19: goto L26;
                default: goto L3;
            };
        L3:
            d1.f348206b.b("enum", "OmniUpdateBotActionType unknown value: " + r100);
            return OmniUpdateBotActionType.OmniUpdateBotActionType_NAME;
        L26:
            return OmniUpdateBotActionType.OmniUpdateBotActionType_USER_EDIT_BIO;
        L27:
            return OmniUpdateBotActionType.OmniUpdateBotActionType_BOT_ICON_MAPPED_APP_ICON;
        L28:
            return OmniUpdateBotActionType.OmniUpdateBotActionType_DYNAMIC_IMG_URL;
        L29:
            return OmniUpdateBotActionType.OmniUpdateBotActionType_DYNAMIC_IMG_URI;
        L30:
            return OmniUpdateBotActionType.OmniUpdateBotActionType_MEMORY;
        L31:
            return OmniUpdateBotActionType.OmniUpdateBotActionType_BG_IMG_INFO;
        L32:
            return OmniUpdateBotActionType.OmniUpdateBotActionType_BG_IMG_URI;
        L33:
            return OmniUpdateBotActionType.OmniUpdateBotActionType_FIRST_MET;
        L34:
            return OmniUpdateBotActionType.OmniUpdateBotActionType_PIC_GEN;
        L35:
            return OmniUpdateBotActionType.OmniUpdateBotActionType_WEB_SEARCH;
        L36:
            return OmniUpdateBotActionType.OmniUpdateBotActionType_MESSAGE_PUSH;
        L37:
            return OmniUpdateBotActionType.OmniUpdateBotActionType_VISIBILITY;
        L38:
            return OmniUpdateBotActionType.OmniUpdateBotActionType_DELETE;
        L39:
            return OmniUpdateBotActionType.OmniUpdateBotActionType_MUTED;
        L40:
            return OmniUpdateBotActionType.OmniUpdateBotActionType_VOICE_TYPE;
        L41:
            return OmniUpdateBotActionType.OmniUpdateBotActionType_LANGUAGE;
        L42:
            return OmniUpdateBotActionType.OmniUpdateBotActionType_MODEL_TYPE;
        L43:
            return OmniUpdateBotActionType.OmniUpdateBotActionType_ICON;
        L44:
            return OmniUpdateBotActionType.OmniUpdateBotActionType_DESC;
        L24:
            return OmniUpdateBotActionType.OmniUpdateBotActionType_NAME;
        }
    }

    private static final /* synthetic */ OmniUpdateBotActionType[] $values() {
        return new OmniUpdateBotActionType[]{OmniUpdateBotActionType_NAME, OmniUpdateBotActionType_DESC, OmniUpdateBotActionType_ICON, OmniUpdateBotActionType_MODEL_TYPE, OmniUpdateBotActionType_LANGUAGE, OmniUpdateBotActionType_VOICE_TYPE, OmniUpdateBotActionType_MUTED, OmniUpdateBotActionType_DELETE, OmniUpdateBotActionType_VISIBILITY, OmniUpdateBotActionType_MESSAGE_PUSH, OmniUpdateBotActionType_WEB_SEARCH, OmniUpdateBotActionType_PIC_GEN, OmniUpdateBotActionType_FIRST_MET, OmniUpdateBotActionType_BG_IMG_URI, OmniUpdateBotActionType_BG_IMG_INFO, OmniUpdateBotActionType_MEMORY, OmniUpdateBotActionType_DYNAMIC_IMG_URI, OmniUpdateBotActionType_DYNAMIC_IMG_URL, OmniUpdateBotActionType_BOT_ICON_MAPPED_APP_ICON, OmniUpdateBotActionType_USER_EDIT_BIO};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    @JvmStatic
    public static final OmniUpdateBotActionType findByValue(int r100) {
        return Companion.findByValue(r100);
    }

    public static EnumEntries<OmniUpdateBotActionType> getEntries() {
        return $ENTRIES;
    }

    static {
        OmniUpdateBotActionType_NAME = new OmniUpdateBotActionType("OmniUpdateBotActionType_NAME", 0, 0);
        OmniUpdateBotActionType_DESC = new OmniUpdateBotActionType("OmniUpdateBotActionType_DESC", 1, 1);
        OmniUpdateBotActionType_ICON = new OmniUpdateBotActionType("OmniUpdateBotActionType_ICON", 2, 2);
        OmniUpdateBotActionType_MODEL_TYPE = new OmniUpdateBotActionType("OmniUpdateBotActionType_MODEL_TYPE", 3, 3);
        OmniUpdateBotActionType_LANGUAGE = new OmniUpdateBotActionType("OmniUpdateBotActionType_LANGUAGE", 4, 4);
        OmniUpdateBotActionType_VOICE_TYPE = new OmniUpdateBotActionType("OmniUpdateBotActionType_VOICE_TYPE", 5, 5);
        OmniUpdateBotActionType_MUTED = new OmniUpdateBotActionType("OmniUpdateBotActionType_MUTED", 6, 6);
        OmniUpdateBotActionType_DELETE = new OmniUpdateBotActionType("OmniUpdateBotActionType_DELETE", 7, 7);
        OmniUpdateBotActionType_VISIBILITY = new OmniUpdateBotActionType("OmniUpdateBotActionType_VISIBILITY", 8, 8);
        OmniUpdateBotActionType_MESSAGE_PUSH = new OmniUpdateBotActionType("OmniUpdateBotActionType_MESSAGE_PUSH", 9, 9);
        OmniUpdateBotActionType_WEB_SEARCH = new OmniUpdateBotActionType("OmniUpdateBotActionType_WEB_SEARCH", 10, 10);
        OmniUpdateBotActionType_PIC_GEN = new OmniUpdateBotActionType("OmniUpdateBotActionType_PIC_GEN", 11, 11);
        OmniUpdateBotActionType_FIRST_MET = new OmniUpdateBotActionType("OmniUpdateBotActionType_FIRST_MET", 12, 12);
        OmniUpdateBotActionType_BG_IMG_URI = new OmniUpdateBotActionType("OmniUpdateBotActionType_BG_IMG_URI", 13, 13);
        OmniUpdateBotActionType_BG_IMG_INFO = new OmniUpdateBotActionType("OmniUpdateBotActionType_BG_IMG_INFO", 14, 14);
        OmniUpdateBotActionType_MEMORY = new OmniUpdateBotActionType("OmniUpdateBotActionType_MEMORY", 15, 15);
        OmniUpdateBotActionType_DYNAMIC_IMG_URI = new OmniUpdateBotActionType("OmniUpdateBotActionType_DYNAMIC_IMG_URI", 16, 16);
        OmniUpdateBotActionType_DYNAMIC_IMG_URL = new OmniUpdateBotActionType("OmniUpdateBotActionType_DYNAMIC_IMG_URL", 17, 17);
        OmniUpdateBotActionType_BOT_ICON_MAPPED_APP_ICON = new OmniUpdateBotActionType("OmniUpdateBotActionType_BOT_ICON_MAPPED_APP_ICON", 18, 18);
        OmniUpdateBotActionType_USER_EDIT_BIO = new OmniUpdateBotActionType("OmniUpdateBotActionType_USER_EDIT_BIO", 19, 19);
        OmniUpdateBotActionType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new rb());
    }

    public static OmniUpdateBotActionType[] values() {
        return (OmniUpdateBotActionType[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.OmniUpdateBotActionType", values(), new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", Constants.VIA_SHARE_TYPE_MINI_PROGRAM, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, "11", "12", "13", Constants.VIA_REPORT_TYPE_MAKE_FRIEND, Constants.VIA_REPORT_TYPE_WPA_STATE, Constants.VIA_REPORT_TYPE_START_WAP, Constants.VIA_REPORT_TYPE_START_GROUP, "18", Constants.VIA_ACT_TYPE_NINETEEN}, new Annotation[][]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static OmniUpdateBotActionType valueOf(String r100) {
        return (OmniUpdateBotActionType) a.a(OmniUpdateBotActionType.class, r100);
    }

    private OmniUpdateBotActionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
