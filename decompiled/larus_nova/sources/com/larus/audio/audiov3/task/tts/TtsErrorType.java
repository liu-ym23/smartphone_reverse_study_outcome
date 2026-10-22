package com.larus.audio.audiov3.task.tts;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/larus/audio/audiov3/task/tts/TtsErrorType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "TTS_TASK_FAILED", "TTS_SESSION_FAILED", "WEB_SOCKET_CHANGE_FAIL", "WEB_SOCKET_CONNECTION_FAIL", "LANGUAGE_NOT_SUPPORTED", "Companion", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TtsErrorType extends Enum<TtsErrorType> {
    public static final a Companion = null;
    public static final TtsErrorType LANGUAGE_NOT_SUPPORTED = null;
    public static final int STATUS_CODE_LANGUAGE_NOT_SUPPORTED = 40000022;
    public static final TtsErrorType TTS_SESSION_FAILED = null;
    public static final TtsErrorType TTS_TASK_FAILED = null;
    public static final TtsErrorType WEB_SOCKET_CHANGE_FAIL = null;
    public static final TtsErrorType WEB_SOCKET_CONNECTION_FAIL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TtsErrorType[] f288673a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288674b = null;
    private final String type;

    public static final class a {
        public a() {
        }

        public static TtsErrorType a(Integer r100) {
            if (r100 != null) goto L5;
        L7:
            return null;
        L5:
            if (r100.intValue() != 40000022) goto L7;
            return TtsErrorType.LANGUAGE_NOT_SUPPORTED;
        }
    }

    public static EnumEntries<TtsErrorType> getEntries() {
        return f288674b;
    }

    static {
        TtsErrorType r100 = new TtsErrorType("TTS_TASK_FAILED", 0, "tts_task_failed");
        TTS_TASK_FAILED = r100;
        TtsErrorType r101 = new TtsErrorType("TTS_SESSION_FAILED", 1, "tts_session_failed");
        TTS_SESSION_FAILED = r101;
        TtsErrorType r102 = new TtsErrorType("WEB_SOCKET_CHANGE_FAIL", 2, "web_socket_change_fail");
        WEB_SOCKET_CHANGE_FAIL = r102;
        TtsErrorType r103 = new TtsErrorType("WEB_SOCKET_CONNECTION_FAIL", 3, "web_socket_connection_fail");
        WEB_SOCKET_CONNECTION_FAIL = r103;
        TtsErrorType r104 = new TtsErrorType("LANGUAGE_NOT_SUPPORTED", 4, "language_not_supported");
        LANGUAGE_NOT_SUPPORTED = r104;
        TtsErrorType[] r105 = {r100, r101, r102, r103, r104};
        f288673a = r105;
        f288674b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static TtsErrorType[] values() {
        return (TtsErrorType[]) f288673a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static TtsErrorType valueOf(String r100) {
        return (TtsErrorType) r27.a.a(TtsErrorType.class, r100);
    }

    public TtsErrorType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
