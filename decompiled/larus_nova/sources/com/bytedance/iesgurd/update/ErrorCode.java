package com.bytedance.iesgurd.update;

import com.ss.android.download.api.config.HttpMethod;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0013\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/iesgurd/update/ErrorCode;", "", "", "code", "I", "getCode", "()I", "UNEXPECTED", HttpMethod.DOWNLOAD, "DOWNLOAD_CHECK", "DOWNLOAD_OTHER", "UNZIP", "MERGE_PATCH", "MERGE_PATCH_CHECK", "MERGE_PATCH_LOCK", "MERGE_PATCH_NO_LOCAL", "BYTE_PATCH_LOCK", "DECOMPRESS_ZSTD", "DECOMPRESS_ZSTD_CHECK", "RENAME_SINGLE", "RENAME", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final enum ErrorCode extends Enum<ErrorCode> {
    public static final ErrorCode BYTE_PATCH_LOCK = null;
    public static final ErrorCode DECOMPRESS_ZSTD = null;
    public static final ErrorCode DECOMPRESS_ZSTD_CHECK = null;
    public static final ErrorCode DOWNLOAD = null;
    public static final ErrorCode DOWNLOAD_CHECK = null;
    public static final ErrorCode DOWNLOAD_OTHER = null;
    public static final ErrorCode MERGE_PATCH = null;
    public static final ErrorCode MERGE_PATCH_CHECK = null;
    public static final ErrorCode MERGE_PATCH_LOCK = null;
    public static final ErrorCode MERGE_PATCH_NO_LOCAL = null;
    public static final ErrorCode RENAME = null;
    public static final ErrorCode RENAME_SINGLE = null;
    public static final ErrorCode UNEXPECTED = null;
    public static final ErrorCode UNZIP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ErrorCode[] f250867a = null;
    private final int code;

    public static ErrorCode valueOf(String r100) {
        return (ErrorCode) a.a(ErrorCode.class, r100);
    }

    public static ErrorCode[] values() {
        return (ErrorCode[]) f250867a.clone();
    }

    static {
        ErrorCode r100 = new ErrorCode("UNEXPECTED", 0, -999);
        UNEXPECTED = r100;
        ErrorCode r101 = new ErrorCode(HttpMethod.DOWNLOAD, 1, 100);
        DOWNLOAD = r101;
        ErrorCode r102 = new ErrorCode("DOWNLOAD_CHECK", 2, 101);
        DOWNLOAD_CHECK = r102;
        ErrorCode r103 = new ErrorCode("DOWNLOAD_OTHER", 3, 102);
        DOWNLOAD_OTHER = r103;
        ErrorCode r104 = new ErrorCode("UNZIP", 4, 200);
        UNZIP = r104;
        ErrorCode r105 = new ErrorCode("MERGE_PATCH", 5, 300);
        MERGE_PATCH = r105;
        ErrorCode r106 = new ErrorCode("MERGE_PATCH_CHECK", 6, 301);
        MERGE_PATCH_CHECK = r106;
        ErrorCode r107 = new ErrorCode("MERGE_PATCH_LOCK", 7, 302);
        MERGE_PATCH_LOCK = r107;
        ErrorCode r108 = new ErrorCode("MERGE_PATCH_NO_LOCAL", 8, 303);
        MERGE_PATCH_NO_LOCAL = r108;
        ErrorCode r109 = new ErrorCode("BYTE_PATCH_LOCK", 9, 310);
        BYTE_PATCH_LOCK = r109;
        ErrorCode r110 = new ErrorCode("DECOMPRESS_ZSTD", 10, 400);
        DECOMPRESS_ZSTD = r110;
        ErrorCode r111 = new ErrorCode("DECOMPRESS_ZSTD_CHECK", 11, 401);
        DECOMPRESS_ZSTD_CHECK = r111;
        ErrorCode r112 = new ErrorCode("RENAME_SINGLE", 12, 410);
        RENAME_SINGLE = r112;
        ErrorCode r113 = new ErrorCode("RENAME", 13, 500);
        RENAME = r113;
        f250867a = new ErrorCode[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113};
    }

    public final int getCode() {
        return this.code;
    }

    public ErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
