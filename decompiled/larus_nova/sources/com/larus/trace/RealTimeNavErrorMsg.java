package com.larus.trace;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/trace/RealTimeNavErrorMsg;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PUSH_IC_DOWNLOAD_ERROR", "PUSH_BUILD_ERROR", "TTS_ERROR", "trace_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RealTimeNavErrorMsg extends Enum<RealTimeNavErrorMsg> {
    public static final RealTimeNavErrorMsg PUSH_BUILD_ERROR = null;
    public static final RealTimeNavErrorMsg PUSH_IC_DOWNLOAD_ERROR = null;
    public static final RealTimeNavErrorMsg TTS_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RealTimeNavErrorMsg[] f370145a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f370146b = null;
    private final String value;

    public static EnumEntries<RealTimeNavErrorMsg> getEntries() {
        return f370146b;
    }

    static {
        RealTimeNavErrorMsg r100 = new RealTimeNavErrorMsg("PUSH_IC_DOWNLOAD_ERROR", 0, "push_ic_download_error");
        PUSH_IC_DOWNLOAD_ERROR = r100;
        RealTimeNavErrorMsg r101 = new RealTimeNavErrorMsg("PUSH_BUILD_ERROR", 1, "push_build_error");
        PUSH_BUILD_ERROR = r101;
        RealTimeNavErrorMsg r102 = new RealTimeNavErrorMsg("TTS_ERROR", 2, "tts_error");
        TTS_ERROR = r102;
        RealTimeNavErrorMsg[] r103 = {r100, r101, r102};
        f370145a = r103;
        f370146b = EnumEntriesKt.enumEntries(r103);
    }

    public static RealTimeNavErrorMsg[] values() {
        return (RealTimeNavErrorMsg[]) f370145a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static RealTimeNavErrorMsg valueOf(String r100) {
        return (RealTimeNavErrorMsg) a.a(RealTimeNavErrorMsg.class, r100);
    }

    public RealTimeNavErrorMsg(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
