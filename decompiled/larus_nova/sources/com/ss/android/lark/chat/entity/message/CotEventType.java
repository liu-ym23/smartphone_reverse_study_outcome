package com.ss.android.lark.chat.entity.message;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b#\b\u0086\u0081\u0002\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001%B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$¨\u0006&"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/CotEventType;", "", "rawName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawName", "()Ljava/lang/String;", "UNKNOWN", "RUN_STARTED", "RUN_FINISHED", "RUN_ERROR", "STEP_STARTED", "STEP_FINISHED", "TEXT_MESSAGE_START", "TEXT_MESSAGE_CONTENT", "TEXT_MESSAGE_END", "TEXT_MESSAGE_CHUNK", "TOOL_CALL_START", "TOOL_CALL_ARGS", "TOOL_CALL_END", "TOOL_CALL_RESULT", "TOOL_CALL_CHUNK", "STATE_SNAPSHOT", "STATE_DELTA", "MESSAGES_SNAPSHOT", "ACTIVITY_SNAPSHOT", "ACTIVITY_DELTA", "REASONING_START", "REASONING_MESSAGE_START", "REASONING_MESSAGE_CONTENT", "REASONING_MESSAGE_END", "REASONING_MESSAGE_CHUNK", "REASONING_END", "REASONING_ENCRYPTED_VALUE", "RAW", "CUSTOM", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CotEventType extends Enum<CotEventType> {
    public static final CotEventType ACTIVITY_DELTA = null;
    public static final CotEventType ACTIVITY_SNAPSHOT = null;
    public static final CotEventType CUSTOM = null;
    public static final a Companion = null;
    public static final CotEventType MESSAGES_SNAPSHOT = null;
    public static final CotEventType RAW = null;
    public static final CotEventType REASONING_ENCRYPTED_VALUE = null;
    public static final CotEventType REASONING_END = null;
    public static final CotEventType REASONING_MESSAGE_CHUNK = null;
    public static final CotEventType REASONING_MESSAGE_CONTENT = null;
    public static final CotEventType REASONING_MESSAGE_END = null;
    public static final CotEventType REASONING_MESSAGE_START = null;
    public static final CotEventType REASONING_START = null;
    public static final CotEventType RUN_ERROR = null;
    public static final CotEventType RUN_FINISHED = null;
    public static final CotEventType RUN_STARTED = null;
    public static final CotEventType STATE_DELTA = null;
    public static final CotEventType STATE_SNAPSHOT = null;
    public static final CotEventType STEP_FINISHED = null;
    public static final CotEventType STEP_STARTED = null;
    public static final CotEventType TEXT_MESSAGE_CHUNK = null;
    public static final CotEventType TEXT_MESSAGE_CONTENT = null;
    public static final CotEventType TEXT_MESSAGE_END = null;
    public static final CotEventType TEXT_MESSAGE_START = null;
    public static final CotEventType TOOL_CALL_ARGS = null;
    public static final CotEventType TOOL_CALL_CHUNK = null;
    public static final CotEventType TOOL_CALL_END = null;
    public static final CotEventType TOOL_CALL_RESULT = null;
    public static final CotEventType TOOL_CALL_START = null;
    public static final CotEventType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CotEventType[] f415212a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415213b = null;
    private final String rawName;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<CotEventType> getEntries() {
        return f415213b;
    }

    static {
        CotEventType r100 = new CotEventType("UNKNOWN", 0, "UNKNOWN");
        UNKNOWN = r100;
        CotEventType r101 = new CotEventType("RUN_STARTED", 1, "RUN_STARTED");
        RUN_STARTED = r101;
        CotEventType r102 = new CotEventType("RUN_FINISHED", 2, "RUN_FINISHED");
        RUN_FINISHED = r102;
        CotEventType r103 = new CotEventType("RUN_ERROR", 3, "RUN_ERROR");
        RUN_ERROR = r103;
        CotEventType r104 = new CotEventType("STEP_STARTED", 4, "STEP_STARTED");
        STEP_STARTED = r104;
        CotEventType r105 = new CotEventType("STEP_FINISHED", 5, "STEP_FINISHED");
        STEP_FINISHED = r105;
        CotEventType r110 = new CotEventType("TEXT_MESSAGE_START", 6, "TEXT_MESSAGE_START");
        TEXT_MESSAGE_START = r110;
        CotEventType r111 = new CotEventType("TEXT_MESSAGE_CONTENT", 7, "TEXT_MESSAGE_CONTENT");
        TEXT_MESSAGE_CONTENT = r111;
        CotEventType r112 = new CotEventType("TEXT_MESSAGE_END", 8, "TEXT_MESSAGE_END");
        TEXT_MESSAGE_END = r112;
        CotEventType r113 = new CotEventType("TEXT_MESSAGE_CHUNK", 9, "TEXT_MESSAGE_CHUNK");
        TEXT_MESSAGE_CHUNK = r113;
        CotEventType r114 = new CotEventType("TOOL_CALL_START", 10, "TOOL_CALL_START");
        TOOL_CALL_START = r114;
        CotEventType r115 = new CotEventType("TOOL_CALL_ARGS", 11, "TOOL_CALL_ARGS");
        TOOL_CALL_ARGS = r115;
        CotEventType r106 = new CotEventType("TOOL_CALL_END", 12, "TOOL_CALL_END");
        TOOL_CALL_END = r106;
        CotEventType r107 = new CotEventType("TOOL_CALL_RESULT", 13, "TOOL_CALL_RESULT");
        TOOL_CALL_RESULT = r107;
        CotEventType r108 = new CotEventType("TOOL_CALL_CHUNK", 14, "TOOL_CALL_CHUNK");
        TOOL_CALL_CHUNK = r108;
        CotEventType r109 = new CotEventType("STATE_SNAPSHOT", 15, "STATE_SNAPSHOT");
        STATE_SNAPSHOT = r109;
        CotEventType r116 = new CotEventType("STATE_DELTA", 16, "STATE_DELTA");
        STATE_DELTA = r116;
        CotEventType r117 = new CotEventType("MESSAGES_SNAPSHOT", 17, "MESSAGES_SNAPSHOT");
        MESSAGES_SNAPSHOT = r117;
        CotEventType r118 = new CotEventType("ACTIVITY_SNAPSHOT", 18, "ACTIVITY_SNAPSHOT");
        ACTIVITY_SNAPSHOT = r118;
        CotEventType r119 = new CotEventType("ACTIVITY_DELTA", 19, "ACTIVITY_DELTA");
        ACTIVITY_DELTA = r119;
        CotEventType r120 = new CotEventType("REASONING_START", 20, "REASONING_START");
        REASONING_START = r120;
        CotEventType r121 = new CotEventType("REASONING_MESSAGE_START", 21, "REASONING_MESSAGE_START");
        REASONING_MESSAGE_START = r121;
        CotEventType r122 = new CotEventType("REASONING_MESSAGE_CONTENT", 22, "REASONING_MESSAGE_CONTENT");
        REASONING_MESSAGE_CONTENT = r122;
        CotEventType r123 = new CotEventType("REASONING_MESSAGE_END", 23, "REASONING_MESSAGE_END");
        REASONING_MESSAGE_END = r123;
        CotEventType r124 = new CotEventType("REASONING_MESSAGE_CHUNK", 24, "REASONING_MESSAGE_CHUNK");
        REASONING_MESSAGE_CHUNK = r124;
        CotEventType r125 = new CotEventType("REASONING_END", 25, "REASONING_END");
        REASONING_END = r125;
        CotEventType r126 = new CotEventType("REASONING_ENCRYPTED_VALUE", 26, "REASONING_ENCRYPTED_VALUE");
        REASONING_ENCRYPTED_VALUE = r126;
        CotEventType r127 = new CotEventType("RAW", 27, "RAW");
        RAW = r127;
        CotEventType r128 = new CotEventType("CUSTOM", 28, "CUSTOM");
        CUSTOM = r128;
        CotEventType[] r129 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128};
        f415212a = r129;
        f415213b = EnumEntriesKt.enumEntries(r129);
        Companion = new a();
    }

    public static CotEventType[] values() {
        return (CotEventType[]) f415212a.clone();
    }

    public final String getRawName() {
        return this.rawName;
    }

    @JvmStatic
    public static final CotEventType fromValue(int r100) {
        Companion.getClass();
        if (r100 == 1) goto L49;
        if (r100 == 2) goto L77;
        if (r100 == 3) goto L76;
        if (r100 == 4) goto L75;
        if (r100 == 5) goto L74;
        if (r100 == 50) goto L73;
        if (r100 == 51) goto L72;
        switch(r100) {
            case 10: goto L54;
            case 11: goto L53;
            case 12: goto L52;
            case 13: goto L51;
            default: goto L17;
        };
    L17:
        switch(r100) {
            case 20: goto L59;
            case 21: goto L58;
            case 22: goto L57;
            case 23: goto L56;
            case 24: goto L55;
            default: goto L18;
        };
    L18:
        switch(r100) {
            case 30: goto L64;
            case 31: goto L63;
            case 32: goto L62;
            case 33: goto L61;
            case 34: goto L60;
            default: goto L19;
        };
    L19:
        switch(r100) {
            case 40: goto L71;
            case 41: goto L70;
            case 42: goto L69;
            case 43: goto L68;
            case 44: goto L67;
            case 45: goto L66;
            case 46: goto L65;
            default: goto L50;
        };
    L50:
        return UNKNOWN;
    L65:
        return REASONING_ENCRYPTED_VALUE;
    L66:
        return REASONING_END;
    L67:
        return REASONING_MESSAGE_CHUNK;
    L68:
        return REASONING_MESSAGE_END;
    L69:
        return REASONING_MESSAGE_CONTENT;
    L70:
        return REASONING_MESSAGE_START;
    L71:
        return REASONING_START;
    L60:
        return ACTIVITY_DELTA;
    L61:
        return ACTIVITY_SNAPSHOT;
    L62:
        return MESSAGES_SNAPSHOT;
    L63:
        return STATE_DELTA;
    L64:
        return STATE_SNAPSHOT;
    L55:
        return TOOL_CALL_CHUNK;
    L56:
        return TOOL_CALL_RESULT;
    L57:
        return TOOL_CALL_END;
    L58:
        return TOOL_CALL_ARGS;
    L59:
        return TOOL_CALL_START;
    L51:
        return TEXT_MESSAGE_CHUNK;
    L52:
        return TEXT_MESSAGE_END;
    L53:
        return TEXT_MESSAGE_CONTENT;
    L54:
        return TEXT_MESSAGE_START;
    L72:
        return CUSTOM;
    L73:
        return RAW;
    L74:
        return STEP_FINISHED;
    L75:
        return STEP_STARTED;
    L76:
        return RUN_ERROR;
    L77:
        return RUN_FINISHED;
    L49:
        return RUN_STARTED;
    }

    public static CotEventType valueOf(String r100) {
        return (CotEventType) r27.a.a(CotEventType.class, r100);
    }

    public CotEventType(String r100, int r101, String r102) {
        super(r100, r101);
        this.rawName = r102;
    }
}
