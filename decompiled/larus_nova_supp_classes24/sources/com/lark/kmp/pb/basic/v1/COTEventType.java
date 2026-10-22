package com.lark.kmp.pb.basic.v1;

import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.o0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b#\b\u0086\u0081\u0002\u0018\u0000 &2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001&B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%¨\u0006'"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/COTEventType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "COT_EVENT_UNKNOWN", "COT_EVENT_RUN_STARTED", "COT_EVENT_RUN_FINISHED", "COT_EVENT_RUN_ERROR", "COT_EVENT_STEP_STARTED", "COT_EVENT_STEP_FINISHED", "COT_EVENT_TEXT_MESSAGE_START", "COT_EVENT_TEXT_MESSAGE_CONTENT", "COT_EVENT_TEXT_MESSAGE_END", "COT_EVENT_TEXT_MESSAGE_CHUNK", "COT_EVENT_TOOL_CALL_START", "COT_EVENT_TOOL_CALL_ARGS", "COT_EVENT_TOOL_CALL_END", "COT_EVENT_TOOL_CALL_RESULT", "COT_EVENT_TOOL_CALL_CHUNK", "COT_EVENT_STATE_SNAPSHOT", "COT_EVENT_STATE_DELTA", "COT_EVENT_MESSAGES_SNAPSHOT", "COT_EVENT_ACTIVITY_SNAPSHOT", "COT_EVENT_ACTIVITY_DELTA", "COT_EVENT_REASONING_START", "COT_EVENT_REASONING_MESSAGE_START", "COT_EVENT_REASONING_MESSAGE_CONTENT", "COT_EVENT_REASONING_MESSAGE_END", "COT_EVENT_REASONING_MESSAGE_CHUNK", "COT_EVENT_REASONING_END", "COT_EVENT_REASONING_ENCRYPTED_VALUE", "COT_EVENT_RAW", "COT_EVENT_CUSTOM", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum COTEventType extends Enum<COTEventType> implements o0 {
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
    public static final b Companion = null;
    public static final /* synthetic */ COTEventType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }

        @JvmStatic
        public static COTEventType a(int r1) {
            if (r1 == 0) goto L51;
            if (r1 == 1) goto L80;
            if (r1 == 2) goto L79;
            if (r1 == 3) goto L78;
            if (r1 == 4) goto L77;
            if (r1 == 5) goto L76;
            if (r1 == 50) goto L75;
            if (r1 == 51) goto L74;
            switch(r1) {
                case 10: goto L56;
                case 11: goto L55;
                case 12: goto L54;
                case 13: goto L53;
                default: goto L18;
            };
        L18:
            switch(r1) {
                case 20: goto L61;
                case 21: goto L60;
                case 22: goto L59;
                case 23: goto L58;
                case 24: goto L57;
                default: goto L19;
            };
        L19:
            switch(r1) {
                case 30: goto L66;
                case 31: goto L65;
                case 32: goto L64;
                case 33: goto L63;
                case 34: goto L62;
                default: goto L20;
            };
        L20:
            switch(r1) {
                case 40: goto L73;
                case 41: goto L72;
                case 42: goto L71;
                case 43: goto L70;
                case 44: goto L69;
                case 45: goto L68;
                case 46: goto L67;
                default: goto L21;
            };
        L21:
            return null;
        L67:
            return COTEventType.COT_EVENT_REASONING_ENCRYPTED_VALUE;
        L68:
            return COTEventType.COT_EVENT_REASONING_END;
        L69:
            return COTEventType.COT_EVENT_REASONING_MESSAGE_CHUNK;
        L70:
            return COTEventType.COT_EVENT_REASONING_MESSAGE_END;
        L71:
            return COTEventType.COT_EVENT_REASONING_MESSAGE_CONTENT;
        L72:
            return COTEventType.COT_EVENT_REASONING_MESSAGE_START;
        L73:
            return COTEventType.COT_EVENT_REASONING_START;
        L62:
            return COTEventType.COT_EVENT_ACTIVITY_DELTA;
        L63:
            return COTEventType.COT_EVENT_ACTIVITY_SNAPSHOT;
        L64:
            return COTEventType.COT_EVENT_MESSAGES_SNAPSHOT;
        L65:
            return COTEventType.COT_EVENT_STATE_DELTA;
        L66:
            return COTEventType.COT_EVENT_STATE_SNAPSHOT;
        L57:
            return COTEventType.COT_EVENT_TOOL_CALL_CHUNK;
        L58:
            return COTEventType.COT_EVENT_TOOL_CALL_RESULT;
        L59:
            return COTEventType.COT_EVENT_TOOL_CALL_END;
        L60:
            return COTEventType.COT_EVENT_TOOL_CALL_ARGS;
        L61:
            return COTEventType.COT_EVENT_TOOL_CALL_START;
        L53:
            return COTEventType.COT_EVENT_TEXT_MESSAGE_CHUNK;
        L54:
            return COTEventType.COT_EVENT_TEXT_MESSAGE_END;
        L55:
            return COTEventType.COT_EVENT_TEXT_MESSAGE_CONTENT;
        L56:
            return COTEventType.COT_EVENT_TEXT_MESSAGE_START;
        L74:
            return COTEventType.COT_EVENT_CUSTOM;
        L75:
            return COTEventType.COT_EVENT_RAW;
        L76:
            return COTEventType.COT_EVENT_STEP_FINISHED;
        L77:
            return COTEventType.COT_EVENT_STEP_STARTED;
        L78:
            return COTEventType.COT_EVENT_RUN_ERROR;
        L79:
            return COTEventType.COT_EVENT_RUN_FINISHED;
        L80:
            return COTEventType.COT_EVENT_RUN_STARTED;
        L51:
            return COTEventType.COT_EVENT_UNKNOWN;
        }
    }

    @JvmStatic
    public static final COTEventType fromValue(int r1) {
        Companion.getClass();
        return b.a(r1);
    }

    public static EnumEntries<COTEventType> getEntries() {
        return b;
    }

    static {
        final COTEventType r0 = new COTEventType("COT_EVENT_UNKNOWN", 0, 0);
        COT_EVENT_UNKNOWN = r0;
        COTEventType r1 = new COTEventType("COT_EVENT_RUN_STARTED", 1, 1);
        COT_EVENT_RUN_STARTED = r1;
        COTEventType r3 = new COTEventType("COT_EVENT_RUN_FINISHED", 2, 2);
        COT_EVENT_RUN_FINISHED = r3;
        COTEventType r5 = new COTEventType("COT_EVENT_RUN_ERROR", 3, 3);
        COT_EVENT_RUN_ERROR = r5;
        COTEventType r7 = new COTEventType("COT_EVENT_STEP_STARTED", 4, 4);
        COT_EVENT_STEP_STARTED = r7;
        COTEventType r9 = new COTEventType("COT_EVENT_STEP_FINISHED", 5, 5);
        COT_EVENT_STEP_FINISHED = r9;
        COTEventType r11 = new COTEventType("COT_EVENT_TEXT_MESSAGE_START", 6, 10);
        COT_EVENT_TEXT_MESSAGE_START = r11;
        COTEventType r13 = new COTEventType("COT_EVENT_TEXT_MESSAGE_CONTENT", 7, 11);
        COT_EVENT_TEXT_MESSAGE_CONTENT = r13;
        COTEventType r14 = new COTEventType("COT_EVENT_TEXT_MESSAGE_END", 8, 12);
        COT_EVENT_TEXT_MESSAGE_END = r14;
        COTEventType r12 = new COTEventType("COT_EVENT_TEXT_MESSAGE_CHUNK", 9, 13);
        COT_EVENT_TEXT_MESSAGE_CHUNK = r12;
        COTEventType r8 = new COTEventType("COT_EVENT_TOOL_CALL_START", 10, 20);
        COT_EVENT_TOOL_CALL_START = r8;
        COTEventType r4 = new COTEventType("COT_EVENT_TOOL_CALL_ARGS", 11, 21);
        COT_EVENT_TOOL_CALL_ARGS = r4;
        COTEventType r15 = new COTEventType("COT_EVENT_TOOL_CALL_END", 12, 22);
        COT_EVENT_TOOL_CALL_END = r15;
        COTEventType r10 = new COTEventType("COT_EVENT_TOOL_CALL_RESULT", 13, 23);
        COT_EVENT_TOOL_CALL_RESULT = r10;
        COTEventType r6 = new COTEventType("COT_EVENT_TOOL_CALL_CHUNK", 14, 24);
        COT_EVENT_TOOL_CALL_CHUNK = r6;
        COTEventType r16 = new COTEventType("COT_EVENT_STATE_SNAPSHOT", 15, 30);
        COT_EVENT_STATE_SNAPSHOT = r16;
        COTEventType r2 = new COTEventType("COT_EVENT_STATE_DELTA", 16, 31);
        COT_EVENT_STATE_DELTA = r2;
        COTEventType r17 = new COTEventType("COT_EVENT_MESSAGES_SNAPSHOT", 17, 32);
        COT_EVENT_MESSAGES_SNAPSHOT = r17;
        COTEventType r19 = new COTEventType("COT_EVENT_ACTIVITY_SNAPSHOT", 18, 33);
        COT_EVENT_ACTIVITY_SNAPSHOT = r19;
        COTEventType r20 = new COTEventType("COT_EVENT_ACTIVITY_DELTA", 19, 34);
        COT_EVENT_ACTIVITY_DELTA = r20;
        COTEventType r21 = new COTEventType("COT_EVENT_REASONING_START", 20, 40);
        COT_EVENT_REASONING_START = r21;
        COTEventType r22 = new COTEventType("COT_EVENT_REASONING_MESSAGE_START", 21, 41);
        COT_EVENT_REASONING_MESSAGE_START = r22;
        COTEventType r23 = new COTEventType("COT_EVENT_REASONING_MESSAGE_CONTENT", 22, 42);
        COT_EVENT_REASONING_MESSAGE_CONTENT = r23;
        COTEventType r24 = new COTEventType("COT_EVENT_REASONING_MESSAGE_END", 23, 43);
        COT_EVENT_REASONING_MESSAGE_END = r24;
        COTEventType r25 = new COTEventType("COT_EVENT_REASONING_MESSAGE_CHUNK", 24, 44);
        COT_EVENT_REASONING_MESSAGE_CHUNK = r25;
        COTEventType r26 = new COTEventType("COT_EVENT_REASONING_END", 25, 45);
        COT_EVENT_REASONING_END = r26;
        COTEventType r27 = new COTEventType("COT_EVENT_REASONING_ENCRYPTED_VALUE", 26, 46);
        COT_EVENT_REASONING_ENCRYPTED_VALUE = r27;
        COTEventType r29 = new COTEventType("COT_EVENT_RAW", 27, 50);
        COT_EVENT_RAW = r29;
        COTEventType r30 = new COTEventType("COT_EVENT_CUSTOM", 28, 51);
        COT_EVENT_CUSTOM = r30;
        COTEventType[] r31 = {r0, r1, r3, r5, r7, r9, r11, r13, r14, r12, r8, r4, r15, r10, r6, r16, r2, r17, r19, r20, r21, r22, r23, r24, r25, r26, r27, r29, r30};
        a = r31;
        b = EnumEntriesKt.enumEntries(r31);
        Companion = new b();
        final KClass r32 = Reflection.getOrCreateKotlinClass(COTEventType.class);
        final Syntax r33 = Syntax.PROTO_2;
        ADAPTER = new a(r32, r33, r0);
    }

    public static COTEventType[] values() {
        return (COTEventType[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    public static COTEventType valueOf(String r1) {
        return (COTEventType) r27.a.a(COTEventType.class, r1);
    }

    public COTEventType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
