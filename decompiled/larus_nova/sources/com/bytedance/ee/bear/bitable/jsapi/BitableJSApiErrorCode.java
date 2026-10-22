package com.bytedance.ee.bear.bitable.jsapi;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/bitable/jsapi/BitableJSApiErrorCode;", "", "code", "", "errMsg", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getErrMsg", "()Ljava/lang/String;", "LOCATION_PERMISSION_DENIED", "ADMIN_DISABLE_GPS", "ADMIN_DISABLE_AMAP_SDK", "TOKEN_INVALID", "UPLOAD_ERROR_WITH_BASE_TOKEN", "UPLOAD_ERROR_WITH_SHARE_TOKEN", "UPLOAD_ERROR_WITH_BASE_TOKEN_NO_ATTACHMENT", "UPLOAD_ERROR_WITH_SHARE_TOKEN_NO_ATTACHMENT", "FILE_OVER_LIMIT", "UNKNOWN", "UNAUTHORIZED_DOMAIN", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BitableJSApiErrorCode extends Enum<BitableJSApiErrorCode> {
    public static final BitableJSApiErrorCode ADMIN_DISABLE_AMAP_SDK = null;
    public static final BitableJSApiErrorCode ADMIN_DISABLE_GPS = null;
    public static final BitableJSApiErrorCode FILE_OVER_LIMIT = null;
    public static final BitableJSApiErrorCode LOCATION_PERMISSION_DENIED = null;
    public static final BitableJSApiErrorCode TOKEN_INVALID = null;
    public static final BitableJSApiErrorCode UNAUTHORIZED_DOMAIN = null;
    public static final BitableJSApiErrorCode UNKNOWN = null;
    public static final BitableJSApiErrorCode UPLOAD_ERROR_WITH_BASE_TOKEN = null;
    public static final BitableJSApiErrorCode UPLOAD_ERROR_WITH_BASE_TOKEN_NO_ATTACHMENT = null;
    public static final BitableJSApiErrorCode UPLOAD_ERROR_WITH_SHARE_TOKEN = null;
    public static final BitableJSApiErrorCode UPLOAD_ERROR_WITH_SHARE_TOKEN_NO_ATTACHMENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BitableJSApiErrorCode[] f214325a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f214326b = null;
    private final int code;
    private final String errMsg;

    public static EnumEntries<BitableJSApiErrorCode> getEntries() {
        return f214326b;
    }

    static {
        BitableJSApiErrorCode r100 = new BitableJSApiErrorCode("LOCATION_PERMISSION_DENIED", 0, -1, "no location permission");
        LOCATION_PERMISSION_DENIED = r100;
        BitableJSApiErrorCode r101 = new BitableJSApiErrorCode("ADMIN_DISABLE_GPS", 1, -4, "admin disabled gps");
        ADMIN_DISABLE_GPS = r101;
        BitableJSApiErrorCode r102 = new BitableJSApiErrorCode("ADMIN_DISABLE_AMAP_SDK", 2, -5, "admin disabled amap sdk");
        ADMIN_DISABLE_AMAP_SDK = r102;
        BitableJSApiErrorCode r103 = new BitableJSApiErrorCode("TOKEN_INVALID", 3, -6, "token invalid");
        TOKEN_INVALID = r103;
        BitableJSApiErrorCode r104 = new BitableJSApiErrorCode("UPLOAD_ERROR_WITH_BASE_TOKEN", 4, -100, "upload failed");
        UPLOAD_ERROR_WITH_BASE_TOKEN = r104;
        BitableJSApiErrorCode r105 = new BitableJSApiErrorCode("UPLOAD_ERROR_WITH_SHARE_TOKEN", 5, -101, "upload failed");
        UPLOAD_ERROR_WITH_SHARE_TOKEN = r105;
        BitableJSApiErrorCode r110 = new BitableJSApiErrorCode("UPLOAD_ERROR_WITH_BASE_TOKEN_NO_ATTACHMENT", 6, -102, "upload failed without attachment");
        UPLOAD_ERROR_WITH_BASE_TOKEN_NO_ATTACHMENT = r110;
        BitableJSApiErrorCode r111 = new BitableJSApiErrorCode("UPLOAD_ERROR_WITH_SHARE_TOKEN_NO_ATTACHMENT", 7, -103, "upload failed without attachment");
        UPLOAD_ERROR_WITH_SHARE_TOKEN_NO_ATTACHMENT = r111;
        BitableJSApiErrorCode r112 = new BitableJSApiErrorCode("FILE_OVER_LIMIT", 8, -201, "file too large");
        FILE_OVER_LIMIT = r112;
        BitableJSApiErrorCode r106 = new BitableJSApiErrorCode("UNKNOWN", 9, -9999, "unknown");
        UNKNOWN = r106;
        BitableJSApiErrorCode r113 = new BitableJSApiErrorCode("UNAUTHORIZED_DOMAIN", 10, -999997, "no domain permission");
        UNAUTHORIZED_DOMAIN = r113;
        BitableJSApiErrorCode[] r107 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r106, r113};
        f214325a = r107;
        f214326b = EnumEntriesKt.enumEntries(r107);
    }

    public static BitableJSApiErrorCode[] values() {
        return (BitableJSApiErrorCode[]) f214325a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public static BitableJSApiErrorCode valueOf(String r100) {
        return (BitableJSApiErrorCode) r27.a.a(BitableJSApiErrorCode.class, r100);
    }

    public BitableJSApiErrorCode(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.errMsg = r103;
    }
}
