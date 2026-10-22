package com.larus.im.internal.jni.bean;

import com.larus.im.internal.delegate.d1;
import com.tencent.connect.common.Constants;
import de9.s4;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0087\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniBreakReason;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "OmniBreakReason_OTHER", "OmniBreakReason_CLICK_ASR", "OmniBreakReason_SEND_NEW_MSG", "OmniBreakReason_CLEAR_CONTEXT", "OmniBreakReason_CLEAR_HISTORY_BY_USER", "OmniBreakReason_CLEAR_HISTORY_BY_SERVER_PUSH", "OmniBreakReason_EDIT_MSG", "OmniBreakReason_CLICK_BREAK_BUTTON", "OmniBreakReason_VOICE_CALL_END", "OmniBreakReason_CHAT_CONTAINER_EXIT", "OmniBreakReason_TTS_PLAY_PREEMPT", "OmniBreakReason_AGENT_TASK_ABORT", "OmniBreakReason_REGENERATE_OR_SWITCH_MODE", "OmniBreakReason_SERVER_RECORD_NEW_QUERY", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum OmniBreakReason extends Enum<OmniBreakReason> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OmniBreakReason[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final Companion Companion = null;

    @SerialName("11")
    public static final OmniBreakReason OmniBreakReason_AGENT_TASK_ABORT = null;

    @SerialName(Constants.VIA_SHARE_TYPE_MINI_PROGRAM)
    public static final OmniBreakReason OmniBreakReason_CHAT_CONTAINER_EXIT = null;

    @SerialName("3")
    public static final OmniBreakReason OmniBreakReason_CLEAR_CONTEXT = null;

    @SerialName("5")
    public static final OmniBreakReason OmniBreakReason_CLEAR_HISTORY_BY_SERVER_PUSH = null;

    @SerialName("4")
    public static final OmniBreakReason OmniBreakReason_CLEAR_HISTORY_BY_USER = null;

    @SerialName("1")
    public static final OmniBreakReason OmniBreakReason_CLICK_ASR = null;

    @SerialName("7")
    public static final OmniBreakReason OmniBreakReason_CLICK_BREAK_BUTTON = null;

    @SerialName("6")
    public static final OmniBreakReason OmniBreakReason_EDIT_MSG = null;

    @SerialName("0")
    public static final OmniBreakReason OmniBreakReason_OTHER = null;

    @SerialName("12")
    public static final OmniBreakReason OmniBreakReason_REGENERATE_OR_SWITCH_MODE = null;

    @SerialName("2")
    public static final OmniBreakReason OmniBreakReason_SEND_NEW_MSG = null;

    @SerialName("13")
    public static final OmniBreakReason OmniBreakReason_SERVER_RECORD_NEW_QUERY = null;

    @SerialName(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ)
    public static final OmniBreakReason OmniBreakReason_TTS_PLAY_PREEMPT = null;

    @SerialName("8")
    public static final OmniBreakReason OmniBreakReason_VOICE_CALL_END = null;
    public final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniBreakReason$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/OmniBreakReason;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) OmniBreakReason.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<OmniBreakReason> serializer() {
            return get$cachedSerializer();
        }

        @JvmStatic
        public final OmniBreakReason findByValue(int r100) {
            switch(r100) {
                case 0: goto L18;
                case 1: goto L32;
                case 2: goto L31;
                case 3: goto L30;
                case 4: goto L29;
                case 5: goto L28;
                case 6: goto L27;
                case 7: goto L26;
                case 8: goto L25;
                case 9: goto L24;
                case 10: goto L23;
                case 11: goto L22;
                case 12: goto L21;
                case 13: goto L20;
                default: goto L3;
            };
        L3:
            d1.f348206b.b("enum", "OmniBreakReason unknown value: " + r100);
            return OmniBreakReason.OmniBreakReason_OTHER;
        L20:
            return OmniBreakReason.OmniBreakReason_SERVER_RECORD_NEW_QUERY;
        L21:
            return OmniBreakReason.OmniBreakReason_REGENERATE_OR_SWITCH_MODE;
        L22:
            return OmniBreakReason.OmniBreakReason_AGENT_TASK_ABORT;
        L23:
            return OmniBreakReason.OmniBreakReason_TTS_PLAY_PREEMPT;
        L24:
            return OmniBreakReason.OmniBreakReason_CHAT_CONTAINER_EXIT;
        L25:
            return OmniBreakReason.OmniBreakReason_VOICE_CALL_END;
        L26:
            return OmniBreakReason.OmniBreakReason_CLICK_BREAK_BUTTON;
        L27:
            return OmniBreakReason.OmniBreakReason_EDIT_MSG;
        L28:
            return OmniBreakReason.OmniBreakReason_CLEAR_HISTORY_BY_SERVER_PUSH;
        L29:
            return OmniBreakReason.OmniBreakReason_CLEAR_HISTORY_BY_USER;
        L30:
            return OmniBreakReason.OmniBreakReason_CLEAR_CONTEXT;
        L31:
            return OmniBreakReason.OmniBreakReason_SEND_NEW_MSG;
        L32:
            return OmniBreakReason.OmniBreakReason_CLICK_ASR;
        L18:
            return OmniBreakReason.OmniBreakReason_OTHER;
        }
    }

    private static final /* synthetic */ OmniBreakReason[] $values() {
        return new OmniBreakReason[]{OmniBreakReason_OTHER, OmniBreakReason_CLICK_ASR, OmniBreakReason_SEND_NEW_MSG, OmniBreakReason_CLEAR_CONTEXT, OmniBreakReason_CLEAR_HISTORY_BY_USER, OmniBreakReason_CLEAR_HISTORY_BY_SERVER_PUSH, OmniBreakReason_EDIT_MSG, OmniBreakReason_CLICK_BREAK_BUTTON, OmniBreakReason_VOICE_CALL_END, OmniBreakReason_CHAT_CONTAINER_EXIT, OmniBreakReason_TTS_PLAY_PREEMPT, OmniBreakReason_AGENT_TASK_ABORT, OmniBreakReason_REGENERATE_OR_SWITCH_MODE, OmniBreakReason_SERVER_RECORD_NEW_QUERY};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    @JvmStatic
    public static final OmniBreakReason findByValue(int r100) {
        return Companion.findByValue(r100);
    }

    public static EnumEntries<OmniBreakReason> getEntries() {
        return $ENTRIES;
    }

    static {
        OmniBreakReason_OTHER = new OmniBreakReason("OmniBreakReason_OTHER", 0, 0);
        OmniBreakReason_CLICK_ASR = new OmniBreakReason("OmniBreakReason_CLICK_ASR", 1, 1);
        OmniBreakReason_SEND_NEW_MSG = new OmniBreakReason("OmniBreakReason_SEND_NEW_MSG", 2, 2);
        OmniBreakReason_CLEAR_CONTEXT = new OmniBreakReason("OmniBreakReason_CLEAR_CONTEXT", 3, 3);
        OmniBreakReason_CLEAR_HISTORY_BY_USER = new OmniBreakReason("OmniBreakReason_CLEAR_HISTORY_BY_USER", 4, 4);
        OmniBreakReason_CLEAR_HISTORY_BY_SERVER_PUSH = new OmniBreakReason("OmniBreakReason_CLEAR_HISTORY_BY_SERVER_PUSH", 5, 5);
        OmniBreakReason_EDIT_MSG = new OmniBreakReason("OmniBreakReason_EDIT_MSG", 6, 6);
        OmniBreakReason_CLICK_BREAK_BUTTON = new OmniBreakReason("OmniBreakReason_CLICK_BREAK_BUTTON", 7, 7);
        OmniBreakReason_VOICE_CALL_END = new OmniBreakReason("OmniBreakReason_VOICE_CALL_END", 8, 8);
        OmniBreakReason_CHAT_CONTAINER_EXIT = new OmniBreakReason("OmniBreakReason_CHAT_CONTAINER_EXIT", 9, 9);
        OmniBreakReason_TTS_PLAY_PREEMPT = new OmniBreakReason("OmniBreakReason_TTS_PLAY_PREEMPT", 10, 10);
        OmniBreakReason_AGENT_TASK_ABORT = new OmniBreakReason("OmniBreakReason_AGENT_TASK_ABORT", 11, 11);
        OmniBreakReason_REGENERATE_OR_SWITCH_MODE = new OmniBreakReason("OmniBreakReason_REGENERATE_OR_SWITCH_MODE", 12, 12);
        OmniBreakReason_SERVER_RECORD_NEW_QUERY = new OmniBreakReason("OmniBreakReason_SERVER_RECORD_NEW_QUERY", 13, 13);
        OmniBreakReason[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new s4());
    }

    public static OmniBreakReason[] values() {
        return (OmniBreakReason[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.OmniBreakReason", values(), new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", Constants.VIA_SHARE_TYPE_MINI_PROGRAM, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, "11", "12", "13"}, new Annotation[][]{null, null, null, null, null, null, null, null, null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static OmniBreakReason valueOf(String r100) {
        return (OmniBreakReason) a.a(OmniBreakReason.class, r100);
    }

    private OmniBreakReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
