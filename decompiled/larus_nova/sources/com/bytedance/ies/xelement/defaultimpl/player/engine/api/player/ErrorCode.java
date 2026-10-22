package com.bytedance.ies.xelement.defaultimpl.player.engine.api.player;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/xelement/defaultimpl/player/engine/api/player/ErrorCode;", "", "", "code", "I", "getCode", "()I", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "NETWORK_ERROR", "INVALIDATE_PLAYER_MODEL", "UNKNOWN", "x-element-audio_release"}, k = 1, mv = {1, 6, 0})
public final enum ErrorCode extends Enum<ErrorCode> {
    public static final ErrorCode INVALIDATE_PLAYER_MODEL = null;
    public static final ErrorCode NETWORK_ERROR = null;
    public static final ErrorCode UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ErrorCode[] f249865a = null;
    private final int code;
    private final String msg;

    public static ErrorCode valueOf(String r100) {
        return (ErrorCode) a.a(ErrorCode.class, r100);
    }

    public static ErrorCode[] values() {
        return (ErrorCode[]) f249865a.clone();
    }

    static {
        ErrorCode r100 = new ErrorCode("NETWORK_ERROR", 0, 0, "NETWORK_ERROR");
        NETWORK_ERROR = r100;
        ErrorCode r101 = new ErrorCode("INVALIDATE_PLAYER_MODEL", 1, 1, "INVALIDATE_DATA_SOURCE");
        INVALIDATE_PLAYER_MODEL = r101;
        ErrorCode r102 = new ErrorCode("UNKNOWN", 2, -1, "UNKNOWN");
        UNKNOWN = r102;
        f249865a = new ErrorCode[]{r100, r101, r102};
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public ErrorCode(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.msg = r103;
    }
}
