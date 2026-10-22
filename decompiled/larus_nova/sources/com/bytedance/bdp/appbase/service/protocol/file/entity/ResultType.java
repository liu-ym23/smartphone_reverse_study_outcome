package com.bytedance.bdp.appbase.service.protocol.file.entity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/bdp/appbase/service/protocol/file/entity/ResultType;", "", "SUCCESS", "PARAM_ERROR", "READ_PERMISSION_DENIED", "WRITE_PERMISSION_DENIED", "NO_SUCH_FILE", "PARENT_FILE_NOT_EXIST", "OVER_SIZE", "DIR_NOT_EMPTY", "ALREADY_EXIST", "NOT_FILE", "NOT_DIRECTORY", "FAIL", "bdp-appbase-ext_release"}, k = 1, mv = {1, 4, 0})
public final enum ResultType extends Enum<ResultType> {
    public static final ResultType ALREADY_EXIST = null;
    public static final ResultType DIR_NOT_EMPTY = null;
    public static final ResultType FAIL = null;
    public static final ResultType NOT_DIRECTORY = null;
    public static final ResultType NOT_FILE = null;
    public static final ResultType NO_SUCH_FILE = null;
    public static final ResultType OVER_SIZE = null;
    public static final ResultType PARAM_ERROR = null;
    public static final ResultType PARENT_FILE_NOT_EXIST = null;
    public static final ResultType READ_PERMISSION_DENIED = null;
    public static final ResultType SUCCESS = null;
    public static final ResultType WRITE_PERMISSION_DENIED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResultType[] f200965a = null;

    static {
        ResultType r100 = new ResultType("SUCCESS", 0);
        SUCCESS = r100;
        ResultType r101 = new ResultType("PARAM_ERROR", 1);
        PARAM_ERROR = r101;
        ResultType r102 = new ResultType("READ_PERMISSION_DENIED", 2);
        READ_PERMISSION_DENIED = r102;
        ResultType r103 = new ResultType("WRITE_PERMISSION_DENIED", 3);
        WRITE_PERMISSION_DENIED = r103;
        ResultType r104 = new ResultType("NO_SUCH_FILE", 4);
        NO_SUCH_FILE = r104;
        ResultType r105 = new ResultType("PARENT_FILE_NOT_EXIST", 5);
        PARENT_FILE_NOT_EXIST = r105;
        ResultType r106 = new ResultType("OVER_SIZE", 6);
        OVER_SIZE = r106;
        ResultType r107 = new ResultType("DIR_NOT_EMPTY", 7);
        DIR_NOT_EMPTY = r107;
        ResultType r108 = new ResultType("ALREADY_EXIST", 8);
        ALREADY_EXIST = r108;
        ResultType r109 = new ResultType("NOT_FILE", 9);
        NOT_FILE = r109;
        ResultType r110 = new ResultType("NOT_DIRECTORY", 10);
        NOT_DIRECTORY = r110;
        ResultType r111 = new ResultType("FAIL", 11);
        FAIL = r111;
        f200965a = new ResultType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111};
    }

    public static ResultType valueOf(String r100) {
        return (ResultType) a.a(ResultType.class, r100);
    }

    public static ResultType[] values() {
        return (ResultType[]) f200965a.clone();
    }

    public ResultType(String r100, int r101) {
        super(r100, r101);
    }
}
