package com.larus.bmhome.chat.standarduikit.localfileblock.remote;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/localfileblock/remote/PcRemoteFileError;", "", "<init>", "(Ljava/lang/String;I)V", "INVALID_REQUEST", "INVALID_RESPONSE", "MISMATCHED_COMMAND", "UNEXPECTED_COMMAND", "FILE_NOT_FOUND", "INVALID_URL", "SERVER_ERROR", "NETWORK_ERROR", "REQUEST_TIMEOUT", "DOWNLOAD_FAILED", "ACCOUNT_CHANGED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PcRemoteFileError extends Enum<PcRemoteFileError> {
    public static final PcRemoteFileError ACCOUNT_CHANGED = null;
    public static final PcRemoteFileError DOWNLOAD_FAILED = null;
    public static final PcRemoteFileError FILE_NOT_FOUND = null;
    public static final PcRemoteFileError INVALID_REQUEST = null;
    public static final PcRemoteFileError INVALID_RESPONSE = null;
    public static final PcRemoteFileError INVALID_URL = null;
    public static final PcRemoteFileError MISMATCHED_COMMAND = null;
    public static final PcRemoteFileError NETWORK_ERROR = null;
    public static final PcRemoteFileError REQUEST_TIMEOUT = null;
    public static final PcRemoteFileError SERVER_ERROR = null;
    public static final PcRemoteFileError UNEXPECTED_COMMAND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PcRemoteFileError[] f309435a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f309436b = null;

    public static EnumEntries<PcRemoteFileError> getEntries() {
        return f309436b;
    }

    static {
        PcRemoteFileError r100 = new PcRemoteFileError("INVALID_REQUEST", 0);
        INVALID_REQUEST = r100;
        PcRemoteFileError r101 = new PcRemoteFileError("INVALID_RESPONSE", 1);
        INVALID_RESPONSE = r101;
        PcRemoteFileError r102 = new PcRemoteFileError("MISMATCHED_COMMAND", 2);
        MISMATCHED_COMMAND = r102;
        PcRemoteFileError r103 = new PcRemoteFileError("UNEXPECTED_COMMAND", 3);
        UNEXPECTED_COMMAND = r103;
        PcRemoteFileError r104 = new PcRemoteFileError("FILE_NOT_FOUND", 4);
        FILE_NOT_FOUND = r104;
        PcRemoteFileError r105 = new PcRemoteFileError("INVALID_URL", 5);
        INVALID_URL = r105;
        PcRemoteFileError r110 = new PcRemoteFileError("SERVER_ERROR", 6);
        SERVER_ERROR = r110;
        PcRemoteFileError r111 = new PcRemoteFileError("NETWORK_ERROR", 7);
        NETWORK_ERROR = r111;
        PcRemoteFileError r112 = new PcRemoteFileError("REQUEST_TIMEOUT", 8);
        REQUEST_TIMEOUT = r112;
        PcRemoteFileError r113 = new PcRemoteFileError("DOWNLOAD_FAILED", 9);
        DOWNLOAD_FAILED = r113;
        PcRemoteFileError r114 = new PcRemoteFileError("ACCOUNT_CHANGED", 10);
        ACCOUNT_CHANGED = r114;
        PcRemoteFileError[] r115 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        f309435a = r115;
        f309436b = EnumEntriesKt.enumEntries(r115);
    }

    public static PcRemoteFileError[] values() {
        return (PcRemoteFileError[]) f309435a.clone();
    }

    public static PcRemoteFileError valueOf(String r100) {
        return (PcRemoteFileError) r27.a.a(PcRemoteFileError.class, r100);
    }

    public PcRemoteFileError(String r100, int r101) {
        super(r100, r101);
    }
}
