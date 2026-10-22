package com.bytedance.gkfs.io;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/gkfs/io/GkFSError;", "", "", "code", "I", "getCode", "()I", "NO_ERROR", "TINY_FILE", "CDC_ERROR", "CDC_NO_CHUNK", "TRANSFER_RESULT_NOT_WORTH", "HEADER_WRITE_ERROR", "CHUNK_WRITE_ERROR", "TAIL_WRITE_ERROR", "SOURCE_FILE_NOT_EXISTS", "MAJOR_FILE_ERROR", "MAJOR_FILE_RENAME_FAILED", "STORE_GENERIC_ERROR", "HEADER_READ_ERROR", "CHUNK_CONTENT_READ_ERROR", "TAIL_READ_ERROR", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final enum GkFSError extends Enum<GkFSError> {
    public static final GkFSError CDC_ERROR = null;
    public static final GkFSError CDC_NO_CHUNK = null;
    public static final GkFSError CHUNK_CONTENT_READ_ERROR = null;
    public static final GkFSError CHUNK_WRITE_ERROR = null;
    public static final GkFSError HEADER_READ_ERROR = null;
    public static final GkFSError HEADER_WRITE_ERROR = null;
    public static final GkFSError MAJOR_FILE_ERROR = null;
    public static final GkFSError MAJOR_FILE_RENAME_FAILED = null;
    public static final GkFSError NO_ERROR = null;
    public static final GkFSError SOURCE_FILE_NOT_EXISTS = null;
    public static final GkFSError STORE_GENERIC_ERROR = null;
    public static final GkFSError TAIL_READ_ERROR = null;
    public static final GkFSError TAIL_WRITE_ERROR = null;
    public static final GkFSError TINY_FILE = null;
    public static final GkFSError TRANSFER_RESULT_NOT_WORTH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GkFSError[] f245181a = null;
    private final int code;

    public static GkFSError valueOf(String r100) {
        return (GkFSError) r27.a.a(GkFSError.class, r100);
    }

    public static GkFSError[] values() {
        return (GkFSError[]) f245181a.clone();
    }

    static {
        GkFSError r100 = new GkFSError("NO_ERROR", 0, -1);
        NO_ERROR = r100;
        GkFSError r101 = new GkFSError("TINY_FILE", 1, 0);
        TINY_FILE = r101;
        GkFSError r102 = new GkFSError("CDC_ERROR", 2, 1);
        CDC_ERROR = r102;
        GkFSError r103 = new GkFSError("CDC_NO_CHUNK", 3, 2);
        CDC_NO_CHUNK = r103;
        GkFSError r104 = new GkFSError("TRANSFER_RESULT_NOT_WORTH", 4, 3);
        TRANSFER_RESULT_NOT_WORTH = r104;
        GkFSError r105 = new GkFSError("HEADER_WRITE_ERROR", 5, 100);
        HEADER_WRITE_ERROR = r105;
        GkFSError r106 = new GkFSError("CHUNK_WRITE_ERROR", 6, 101);
        CHUNK_WRITE_ERROR = r106;
        GkFSError r107 = new GkFSError("TAIL_WRITE_ERROR", 7, 102);
        TAIL_WRITE_ERROR = r107;
        GkFSError r108 = new GkFSError("SOURCE_FILE_NOT_EXISTS", 8, 103);
        SOURCE_FILE_NOT_EXISTS = r108;
        GkFSError r109 = new GkFSError("MAJOR_FILE_ERROR", 9, 104);
        MAJOR_FILE_ERROR = r109;
        GkFSError r110 = new GkFSError("MAJOR_FILE_RENAME_FAILED", 10, 105);
        MAJOR_FILE_RENAME_FAILED = r110;
        GkFSError r111 = new GkFSError("STORE_GENERIC_ERROR", 11, 106);
        STORE_GENERIC_ERROR = r111;
        GkFSError r112 = new GkFSError("HEADER_READ_ERROR", 12, 1001);
        HEADER_READ_ERROR = r112;
        GkFSError r113 = new GkFSError("CHUNK_CONTENT_READ_ERROR", 13, 1002);
        CHUNK_CONTENT_READ_ERROR = r113;
        GkFSError r114 = new GkFSError("TAIL_READ_ERROR", 14, 1003);
        TAIL_READ_ERROR = r114;
        f245181a = new GkFSError[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114};
    }

    public final int getCode() {
        return this.code;
    }

    public GkFSError(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
