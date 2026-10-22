package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum COTEventType extends Enum<COTEventType> implements WireEnum {
    private static final /* synthetic */ COTEventType[] $VALUES = null;
    public static final ProtoAdapter<COTEventType> ADAPTER = null;
    public static final COTEventType COT_EVENT_ACTIVITY_DELTA = null;
    public static final COTEventType COT_EVENT_ACTIVITY_SNAPSHOT = null;
    public static final COTEventType COT_EVENT_CUSTOM = null;
    public static final COTEventType COT_EVENT_MESSAGES_SNAPSHOT = null;
    public static final COTEventType COT_EVENT_RAW = null;
    public static final COTEventType COT_EVENT_REASONING_ENCRYPTED_VALUE = null;
    public static final COTEventType COT_EVENT_REASONING_END = null;
    public static final COTEventType COT_EVENT_REASONING_MESSAGE_CHUNK = null;
    public static final COTEventType COT_EVENT_REASONING_MESSAGE_CONTENT = null;
    public static final COTEventType COT_EVENT_REASONING_MESSAGE_END = null;
    public static final COTEventType COT_EVENT_REASONING_MESSAGE_START = null;
    public static final COTEventType COT_EVENT_REASONING_START = null;
    public static final COTEventType COT_EVENT_RUN_ERROR = null;
    public static final COTEventType COT_EVENT_RUN_FINISHED = null;
    public static final COTEventType COT_EVENT_RUN_STARTED = null;
    public static final COTEventType COT_EVENT_STATE_DELTA = null;
    public static final COTEventType COT_EVENT_STATE_SNAPSHOT = null;
    public static final COTEventType COT_EVENT_STEP_FINISHED = null;
    public static final COTEventType COT_EVENT_STEP_STARTED = null;
    public static final COTEventType COT_EVENT_TEXT_MESSAGE_CHUNK = null;
    public static final COTEventType COT_EVENT_TEXT_MESSAGE_CONTENT = null;
    public static final COTEventType COT_EVENT_TEXT_MESSAGE_END = null;
    public static final COTEventType COT_EVENT_TEXT_MESSAGE_START = null;
    public static final COTEventType COT_EVENT_TOOL_CALL_ARGS = null;
    public static final COTEventType COT_EVENT_TOOL_CALL_CHUNK = null;
    public static final COTEventType COT_EVENT_TOOL_CALL_END = null;
    public static final COTEventType COT_EVENT_TOOL_CALL_RESULT = null;
    public static final COTEventType COT_EVENT_TOOL_CALL_START = null;
    public static final COTEventType COT_EVENT_UNKNOWN = null;
    private final int value;

    static {
        COTEventType r100 = new COTEventType("COT_EVENT_UNKNOWN", 0, 0);
        COT_EVENT_UNKNOWN = r100;
        COTEventType r101 = new COTEventType("COT_EVENT_RUN_STARTED", 1, 1);
        COT_EVENT_RUN_STARTED = r101;
        COTEventType r102 = new COTEventType("COT_EVENT_RUN_FINISHED", 2, 2);
        COT_EVENT_RUN_FINISHED = r102;
        COTEventType r103 = new COTEventType("COT_EVENT_RUN_ERROR", 3, 3);
        COT_EVENT_RUN_ERROR = r103;
        COTEventType r104 = new COTEventType("COT_EVENT_STEP_STARTED", 4, 4);
        COT_EVENT_STEP_STARTED = r104;
        COTEventType r105 = new COTEventType("COT_EVENT_STEP_FINISHED", 5, 5);
        COT_EVENT_STEP_FINISHED = r105;
        COTEventType r110 = new COTEventType("COT_EVENT_TEXT_MESSAGE_START", 6, 10);
        COT_EVENT_TEXT_MESSAGE_START = r110;
        COTEventType r111 = new COTEventType("COT_EVENT_TEXT_MESSAGE_CONTENT", 7, 11);
        COT_EVENT_TEXT_MESSAGE_CONTENT = r111;
        COTEventType r112 = new COTEventType("COT_EVENT_TEXT_MESSAGE_END", 8, 12);
        COT_EVENT_TEXT_MESSAGE_END = r112;
        COTEventType r113 = new COTEventType("COT_EVENT_TEXT_MESSAGE_CHUNK", 9, 13);
        COT_EVENT_TEXT_MESSAGE_CHUNK = r113;
        COTEventType r106 = new COTEventType("COT_EVENT_TOOL_CALL_START", 10, 20);
        COT_EVENT_TOOL_CALL_START = r106;
        COTEventType r107 = new COTEventType("COT_EVENT_TOOL_CALL_ARGS", 11, 21);
        COT_EVENT_TOOL_CALL_ARGS = r107;
        COTEventType r114 = new COTEventType("COT_EVENT_TOOL_CALL_END", 12, 22);
        COT_EVENT_TOOL_CALL_END = r114;
        COTEventType r115 = new COTEventType("COT_EVENT_TOOL_CALL_RESULT", 13, 23);
        COT_EVENT_TOOL_CALL_RESULT = r115;
        COTEventType r108 = new COTEventType("COT_EVENT_TOOL_CALL_CHUNK", 14, 24);
        COT_EVENT_TOOL_CALL_CHUNK = r108;
        COTEventType r116 = new COTEventType("COT_EVENT_STATE_SNAPSHOT", 15, 30);
        COT_EVENT_STATE_SNAPSHOT = r116;
        COTEventType r109 = new COTEventType("COT_EVENT_STATE_DELTA", 16, 31);
        COT_EVENT_STATE_DELTA = r109;
        COTEventType r117 = new COTEventType("COT_EVENT_MESSAGES_SNAPSHOT", 17, 32);
        COT_EVENT_MESSAGES_SNAPSHOT = r117;
        COTEventType r118 = new COTEventType("COT_EVENT_ACTIVITY_SNAPSHOT", 18, 33);
        COT_EVENT_ACTIVITY_SNAPSHOT = r118;
        COTEventType r119 = new COTEventType("COT_EVENT_ACTIVITY_DELTA", 19, 34);
        COT_EVENT_ACTIVITY_DELTA = r119;
        COTEventType r120 = new COTEventType("COT_EVENT_REASONING_START", 20, 40);
        COT_EVENT_REASONING_START = r120;
        COTEventType r121 = new COTEventType("COT_EVENT_REASONING_MESSAGE_START", 21, 41);
        COT_EVENT_REASONING_MESSAGE_START = r121;
        COTEventType r122 = new COTEventType("COT_EVENT_REASONING_MESSAGE_CONTENT", 22, 42);
        COT_EVENT_REASONING_MESSAGE_CONTENT = r122;
        COTEventType r123 = new COTEventType("COT_EVENT_REASONING_MESSAGE_END", 23, 43);
        COT_EVENT_REASONING_MESSAGE_END = r123;
        COTEventType r124 = new COTEventType("COT_EVENT_REASONING_MESSAGE_CHUNK", 24, 44);
        COT_EVENT_REASONING_MESSAGE_CHUNK = r124;
        COTEventType r125 = new COTEventType("COT_EVENT_REASONING_END", 25, 45);
        COT_EVENT_REASONING_END = r125;
        COTEventType r126 = new COTEventType("COT_EVENT_REASONING_ENCRYPTED_VALUE", 26, 46);
        COT_EVENT_REASONING_ENCRYPTED_VALUE = r126;
        COTEventType r127 = new COTEventType("COT_EVENT_RAW", 27, 50);
        COT_EVENT_RAW = r127;
        COTEventType r128 = new COTEventType("COT_EVENT_CUSTOM", 28, 51);
        COT_EVENT_CUSTOM = r128;
        $VALUES = new COTEventType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r107, r114, r115, r108, r116, r109, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128};
        ADAPTER = ProtoAdapter.newEnumAdapter(COTEventType.class);
    }

    public static COTEventType[] values() {
        return (COTEventType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static COTEventType fromValue(int r100) {
        if (r100 == 0) goto L80;
        if (r100 == 1) goto L78;
        if (r100 == 2) goto L76;
        if (r100 == 3) goto L74;
        if (r100 == 4) goto L72;
        if (r100 == 5) goto L70;
        if (r100 == 50) goto L68;
        if (r100 == 51) goto L66;
        switch(r100) {
            case 10: goto L64;
            case 11: goto L62;
            case 12: goto L60;
            case 13: goto L58;
            default: goto L18;
        };
    L18:
        switch(r100) {
            case 20: goto L56;
            case 21: goto L54;
            case 22: goto L52;
            case 23: goto L50;
            case 24: goto L48;
            default: goto L19;
        };
    L19:
        switch(r100) {
            case 30: goto L46;
            case 31: goto L44;
            case 32: goto L42;
            case 33: goto L40;
            case 34: goto L38;
            default: goto L20;
        };
    L20:
        switch(r100) {
            case 40: goto L36;
            case 41: goto L34;
            case 42: goto L32;
            case 43: goto L30;
            case 44: goto L28;
            case 45: goto L26;
            case 46: goto L24;
            default: goto L21;
        };
    L21:
        return null;
    L24:
        return COT_EVENT_REASONING_ENCRYPTED_VALUE;
    L26:
        return COT_EVENT_REASONING_END;
    L28:
        return COT_EVENT_REASONING_MESSAGE_CHUNK;
    L30:
        return COT_EVENT_REASONING_MESSAGE_END;
    L32:
        return COT_EVENT_REASONING_MESSAGE_CONTENT;
    L34:
        return COT_EVENT_REASONING_MESSAGE_START;
    L36:
        return COT_EVENT_REASONING_START;
    L38:
        return COT_EVENT_ACTIVITY_DELTA;
    L40:
        return COT_EVENT_ACTIVITY_SNAPSHOT;
    L42:
        return COT_EVENT_MESSAGES_SNAPSHOT;
    L44:
        return COT_EVENT_STATE_DELTA;
    L46:
        return COT_EVENT_STATE_SNAPSHOT;
    L48:
        return COT_EVENT_TOOL_CALL_CHUNK;
    L50:
        return COT_EVENT_TOOL_CALL_RESULT;
    L52:
        return COT_EVENT_TOOL_CALL_END;
    L54:
        return COT_EVENT_TOOL_CALL_ARGS;
    L56:
        return COT_EVENT_TOOL_CALL_START;
    L58:
        return COT_EVENT_TEXT_MESSAGE_CHUNK;
    L60:
        return COT_EVENT_TEXT_MESSAGE_END;
    L62:
        return COT_EVENT_TEXT_MESSAGE_CONTENT;
    L64:
        return COT_EVENT_TEXT_MESSAGE_START;
    L66:
        return COT_EVENT_CUSTOM;
    L68:
        return COT_EVENT_RAW;
    L70:
        return COT_EVENT_STEP_FINISHED;
    L72:
        return COT_EVENT_STEP_STARTED;
    L74:
        return COT_EVENT_RUN_ERROR;
    L76:
        return COT_EVENT_RUN_FINISHED;
    L78:
        return COT_EVENT_RUN_STARTED;
    L80:
        return COT_EVENT_UNKNOWN;
    }

    public static COTEventType valueOf(String r100) {
        return (COTEventType) a.a(COTEventType.class, r100);
    }

    private COTEventType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
