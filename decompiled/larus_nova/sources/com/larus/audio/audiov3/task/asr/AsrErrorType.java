package com.larus.audio.audiov3.task.asr;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/audio/audiov3/task/asr/AsrErrorType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "ASR_TASK_FAILED", "ASR_SESSION_FAILED", "WEB_SOCKET_CHANGE_FAIL", "WEB_SOCKET_CONNECTION_FAIL", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AsrErrorType extends Enum<AsrErrorType> {
    public static final AsrErrorType ASR_SESSION_FAILED = null;
    public static final AsrErrorType ASR_TASK_FAILED = null;
    public static final AsrErrorType WEB_SOCKET_CHANGE_FAIL = null;
    public static final AsrErrorType WEB_SOCKET_CONNECTION_FAIL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AsrErrorType[] f288528a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288529b = null;
    private final String type;

    public static EnumEntries<AsrErrorType> getEntries() {
        return f288529b;
    }

    static {
        AsrErrorType r100 = new AsrErrorType("ASR_TASK_FAILED", 0, "asr_task_failed");
        ASR_TASK_FAILED = r100;
        AsrErrorType r101 = new AsrErrorType("ASR_SESSION_FAILED", 1, "asr_session_failed");
        ASR_SESSION_FAILED = r101;
        AsrErrorType r102 = new AsrErrorType("WEB_SOCKET_CHANGE_FAIL", 2, "web_socket_change_fail");
        WEB_SOCKET_CHANGE_FAIL = r102;
        AsrErrorType r103 = new AsrErrorType("WEB_SOCKET_CONNECTION_FAIL", 3, "web_socket_connection_fail");
        WEB_SOCKET_CONNECTION_FAIL = r103;
        AsrErrorType[] r104 = {r100, r101, r102, r103};
        f288528a = r104;
        f288529b = EnumEntriesKt.enumEntries(r104);
    }

    public static AsrErrorType[] values() {
        return (AsrErrorType[]) f288528a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static AsrErrorType valueOf(String r100) {
        return (AsrErrorType) a.a(AsrErrorType.class, r100);
    }

    public AsrErrorType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
