package com.larus.im.internal.audio.ability;

import com.byted.cast.mediacommon.MediaCaptureError;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/larus/im/internal/audio/ability/DoraCustomSignalType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CHAT_REQUEST", "WAKE_UP_ON_SESSION", "SET_LOUDNESS_STRATEGY", "SET_TRANSLATE_SCENE_SWITCH", "VUI_RESET", "SPEECH_STARTED", "SPEECH_ENDED", "SESSION_WAKE_UP", "SESSION_CONF_RESPONSE", "Companion", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraCustomSignalType extends Enum<DoraCustomSignalType> {
    public static final DoraCustomSignalType CHAT_REQUEST = null;
    public static final a Companion = null;
    public static final DoraCustomSignalType SESSION_CONF_RESPONSE = null;
    public static final DoraCustomSignalType SESSION_WAKE_UP = null;
    public static final DoraCustomSignalType SET_LOUDNESS_STRATEGY = null;
    public static final DoraCustomSignalType SET_TRANSLATE_SCENE_SWITCH = null;
    public static final DoraCustomSignalType SPEECH_ENDED = null;
    public static final DoraCustomSignalType SPEECH_STARTED = null;
    public static final DoraCustomSignalType VUI_RESET = null;
    public static final DoraCustomSignalType WAKE_UP_ON_SESSION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraCustomSignalType[] f347170a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f347171b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static DoraCustomSignalType a(Integer r100) {
            Object r101 = null;
            if (r100 == null) goto L29;
            r100.intValue();
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L17
            DoraCustomSignalType[] r103 = DoraCustomSignalType.values();     // Catch: Throwable -> L17
            int r104 = r103.length;     // Catch: Throwable -> L17
            int r105 = 0;
        L6:
            if (r105 >= r104) goto L14;
            DoraCustomSignalType r106 = r103[r105];     // Catch: Throwable -> L17
            if (r106.getValue() != r100.intValue()) goto L10;
            boolean r107 = true;
        L11:
            if (r107 == true) goto L15;
            r105 = r105 + 1;     // Catch: Throwable -> L17
        L15:
            Object r108 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L17
        L20:
            if (Result.m9455isFailureimpl(r108) == true) goto L24;
            r101 = r108;
        L24:
            return (DoraCustomSignalType) r101;
        L10:
            r107 = false;
            goto L11
        L14:
            r106 = null;
        L17:
            th = move-exception;
            Result.Companion r109 = Result.Companion;
            r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L20
        L29:
            return null;
        }
    }

    public static EnumEntries<DoraCustomSignalType> getEntries() {
        return f347171b;
    }

    static {
        DoraCustomSignalType r100 = new DoraCustomSignalType("CHAT_REQUEST", 0, 30005);
        CHAT_REQUEST = r100;
        DoraCustomSignalType r101 = new DoraCustomSignalType("WAKE_UP_ON_SESSION", 1, MediaCaptureError.ERROR_CAST_CONNECTION_NOT_BUILT);
        WAKE_UP_ON_SESSION = r101;
        DoraCustomSignalType r102 = new DoraCustomSignalType("SET_LOUDNESS_STRATEGY", 2, 30008);
        SET_LOUDNESS_STRATEGY = r102;
        DoraCustomSignalType r103 = new DoraCustomSignalType("SET_TRANSLATE_SCENE_SWITCH", 3, 30009);
        SET_TRANSLATE_SCENE_SWITCH = r103;
        DoraCustomSignalType r104 = new DoraCustomSignalType("VUI_RESET", 4, TTVideoEngineInterface.ALGO_CONFIG_STRING_PRELOAD_TIMELINESS);
        VUI_RESET = r104;
        DoraCustomSignalType r105 = new DoraCustomSignalType("SPEECH_STARTED", 5, TTVideoEngineInterface.ALGO_CONFIG_STRING_PLAY_LOAD);
        SPEECH_STARTED = r105;
        DoraCustomSignalType r110 = new DoraCustomSignalType("SPEECH_ENDED", 6, TTVideoEngineInterface.ALGO_CONFIG_STRING_PLAY_RANGE);
        SPEECH_ENDED = r110;
        DoraCustomSignalType r111 = new DoraCustomSignalType("SESSION_WAKE_UP", 7, TTVideoEngineInterface.ALGO_CONFIG_STRING_GEAR_STRATEGY);
        SESSION_WAKE_UP = r111;
        DoraCustomSignalType r112 = new DoraCustomSignalType("SESSION_CONF_RESPONSE", 8, TTVideoEngineInterface.ALGO_CONFIG_STRING_BANDWIDTH);
        SESSION_CONF_RESPONSE = r112;
        DoraCustomSignalType[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f347170a = r113;
        f347171b = EnumEntriesKt.enumEntries(r113);
        Companion = new a();
    }

    public static DoraCustomSignalType[] values() {
        return (DoraCustomSignalType[]) f347170a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DoraCustomSignalType valueOf(String r100) {
        return (DoraCustomSignalType) r27.a.a(DoraCustomSignalType.class, r100);
    }

    public DoraCustomSignalType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
