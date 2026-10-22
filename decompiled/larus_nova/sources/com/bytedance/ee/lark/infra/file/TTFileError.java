package com.bytedance.ee.lark.infra.file;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0016\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/lark/infra/file/TTFileError;", "Ljava/io/Serializable;", "code", "", "msg", "", "<init>", "(ILjava/lang/String;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "toString", "Companion", "eco-infra_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TTFileError implements Serializable {
    public static final TTFileError ALREADY_EXISTS = null;
    public static final TTFileError BIZ_ERROR = null;
    public static final TTFileError CANNOT_OPERATE_PATH_AND_SUBPATH = null;
    public static final TTFileError CANNOT_READ = null;
    public static final TTFileError CANNOT_WRITE = null;
    public static final a Companion = null;
    public static final TTFileError DECRYPT_ERROR = null;
    public static final TTFileError DIR_NOT_EMPTY = null;
    public static final TTFileError ENCRYPT_ERROR = null;
    public static final TTBizError FILE_NAME_TOO_LONG = null;
    public static final TTBizError INVALID_FILE_PATH = null;
    public static final TTFileError INVALID_PARAM = null;
    public static final TTFileError NOT_DIR = null;
    public static final TTFileError NOT_EXISTS = null;
    public static final TTFileError NOT_FILE = null;
    public static final TTFileError OVER_READ_THRESHOLD = null;
    public static final TTFileError OVER_SIZE_LIMIT = null;
    public static final TTFileError OVER_WRITE_THRESHOLD = null;
    public static final TTFileError PARENT_NOT_EXISTS = null;
    public static final TTFileError SYSTEM_ERROR = null;
    private final int code;
    private final String msg;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        SYSTEM_ERROR = new TTFileError(10001, "system error");
        BIZ_ERROR = new TTFileError(10002, "biz error");
        CANNOT_READ = new TTFileError(10003, "read permission denied");
        CANNOT_WRITE = new TTFileError(10004, "write permission denied");
        NOT_EXISTS = new TTFileError(10005, "file not exists");
        ALREADY_EXISTS = new TTFileError(10006, "file already exists");
        PARENT_NOT_EXISTS = new TTFileError(10007, "parent not exists");
        DIR_NOT_EMPTY = new TTFileError(10008, "directory not empty");
        NOT_DIR = new TTFileError(10009, "is not directory");
        NOT_FILE = new TTFileError(10010, "is not file");
        CANNOT_OPERATE_PATH_AND_SUBPATH = new TTFileError(10011, "cannot operate path and subpath at the same time");
        OVER_SIZE_LIMIT = new TTFileError(10012, "total size limit");
        OVER_READ_THRESHOLD = new TTFileError(10013, "over read size threshold");
        INVALID_PARAM = new TTFileError(10014, "invalid param");
        ENCRYPT_ERROR = new TTFileError(10015, "encrypt failed");
        DECRYPT_ERROR = new TTFileError(10016, "decrypt failed");
        OVER_WRITE_THRESHOLD = new TTFileError(10017, "over write size threshold");
        INVALID_FILE_PATH = new TTBizError(10018, "invalid ttfile");
        FILE_NAME_TOO_LONG = new TTBizError(10019, "file name too long");
    }

    public String toString() {
        return "TTFileError(code=" + this.code + ", msg='" + this.msg + "')";
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public TTFileError(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.code = r100;
        this.msg = r101;
    }
}
