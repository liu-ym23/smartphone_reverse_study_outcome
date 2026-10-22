package com.bytedance.ee.bear.bitable.baseadd;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/bitable/baseadd/FastAddErrorCode;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "FAST_ADD_ERR_CODE_TABLE_NOT_EXIST", "FAST_ADD_ERR_CODE_TABLE_NOT_EXIST_1", "FAST_ADD_ERR_CODE_TABLE_NOT_EXIST_2", "FAST_ADD_ERR_CODE_NO_ADD_ACCESS", "FAST_ADD_ERR_CODE_NO_ADD_ACCESS_1", "FAST_ADD_ERR_CODE_NO_READ_ACCESS", "FAST_ADD_ERR_CODE_SUBMIT_TIMEOUT_OR_OTHER", "FAST_ADD_ERR_CODE_OVER_ROW_QUOTA_LIMIT", "FAST_ADD_ERR_CODE_OVER_ROW_SYSTEM_LIMIT", "FAST_ADD_ERR_CODE_META_REQUEST_FAILED", "FAST_ADD_ERR_CODE_META_REQUEST_EXCEPTION", "FAST_ADD_ERR_CODE_META_RESPONSE_DATA_IS_NULL", "FAST_ADD_ERR_CODE_FG_CLOSE", "FAST_ADD_ERR_CODE_NO_SHARE_TOKEN_AFTER_SUBMIT", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FastAddErrorCode extends Enum<FastAddErrorCode> {
    public static final FastAddErrorCode FAST_ADD_ERR_CODE_FG_CLOSE = null;
    public static final FastAddErrorCode FAST_ADD_ERR_CODE_META_REQUEST_EXCEPTION = null;
    public static final FastAddErrorCode FAST_ADD_ERR_CODE_META_REQUEST_FAILED = null;
    public static final FastAddErrorCode FAST_ADD_ERR_CODE_META_RESPONSE_DATA_IS_NULL = null;
    public static final FastAddErrorCode FAST_ADD_ERR_CODE_NO_ADD_ACCESS = null;
    public static final FastAddErrorCode FAST_ADD_ERR_CODE_NO_ADD_ACCESS_1 = null;
    public static final FastAddErrorCode FAST_ADD_ERR_CODE_NO_READ_ACCESS = null;
    public static final FastAddErrorCode FAST_ADD_ERR_CODE_NO_SHARE_TOKEN_AFTER_SUBMIT = null;
    public static final FastAddErrorCode FAST_ADD_ERR_CODE_OVER_ROW_QUOTA_LIMIT = null;
    public static final FastAddErrorCode FAST_ADD_ERR_CODE_OVER_ROW_SYSTEM_LIMIT = null;
    public static final FastAddErrorCode FAST_ADD_ERR_CODE_SUBMIT_TIMEOUT_OR_OTHER = null;
    public static final FastAddErrorCode FAST_ADD_ERR_CODE_TABLE_NOT_EXIST = null;
    public static final FastAddErrorCode FAST_ADD_ERR_CODE_TABLE_NOT_EXIST_1 = null;
    public static final FastAddErrorCode FAST_ADD_ERR_CODE_TABLE_NOT_EXIST_2 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FastAddErrorCode[] f206974a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f206975b = null;
    private final int code;

    public static EnumEntries<FastAddErrorCode> getEntries() {
        return f206975b;
    }

    static {
        FastAddErrorCode r100 = new FastAddErrorCode("FAST_ADD_ERR_CODE_TABLE_NOT_EXIST", 0, 800004000);
        FAST_ADD_ERR_CODE_TABLE_NOT_EXIST = r100;
        FastAddErrorCode r101 = new FastAddErrorCode("FAST_ADD_ERR_CODE_TABLE_NOT_EXIST_1", 1, 3);
        FAST_ADD_ERR_CODE_TABLE_NOT_EXIST_1 = r101;
        FastAddErrorCode r102 = new FastAddErrorCode("FAST_ADD_ERR_CODE_TABLE_NOT_EXIST_2", 2, 1002);
        FAST_ADD_ERR_CODE_TABLE_NOT_EXIST_2 = r102;
        FastAddErrorCode r103 = new FastAddErrorCode("FAST_ADD_ERR_CODE_NO_ADD_ACCESS", 3, 800004011);
        FAST_ADD_ERR_CODE_NO_ADD_ACCESS = r103;
        FastAddErrorCode r104 = new FastAddErrorCode("FAST_ADD_ERR_CODE_NO_ADD_ACCESS_1", 4, 4);
        FAST_ADD_ERR_CODE_NO_ADD_ACCESS_1 = r104;
        FastAddErrorCode r105 = new FastAddErrorCode("FAST_ADD_ERR_CODE_NO_READ_ACCESS", 5, 120120);
        FAST_ADD_ERR_CODE_NO_READ_ACCESS = r105;
        FastAddErrorCode r110 = new FastAddErrorCode("FAST_ADD_ERR_CODE_SUBMIT_TIMEOUT_OR_OTHER", 6, 110110);
        FAST_ADD_ERR_CODE_SUBMIT_TIMEOUT_OR_OTHER = r110;
        FastAddErrorCode r111 = new FastAddErrorCode("FAST_ADD_ERR_CODE_OVER_ROW_QUOTA_LIMIT", 7, 800004333);
        FAST_ADD_ERR_CODE_OVER_ROW_QUOTA_LIMIT = r111;
        FastAddErrorCode r112 = new FastAddErrorCode("FAST_ADD_ERR_CODE_OVER_ROW_SYSTEM_LIMIT", 8, 800004024);
        FAST_ADD_ERR_CODE_OVER_ROW_SYSTEM_LIMIT = r112;
        FastAddErrorCode r113 = new FastAddErrorCode("FAST_ADD_ERR_CODE_META_REQUEST_FAILED", 9, 801);
        FAST_ADD_ERR_CODE_META_REQUEST_FAILED = r113;
        FastAddErrorCode r114 = new FastAddErrorCode("FAST_ADD_ERR_CODE_META_REQUEST_EXCEPTION", 10, 802);
        FAST_ADD_ERR_CODE_META_REQUEST_EXCEPTION = r114;
        FastAddErrorCode r106 = new FastAddErrorCode("FAST_ADD_ERR_CODE_META_RESPONSE_DATA_IS_NULL", 11, 803);
        FAST_ADD_ERR_CODE_META_RESPONSE_DATA_IS_NULL = r106;
        FastAddErrorCode r107 = new FastAddErrorCode("FAST_ADD_ERR_CODE_FG_CLOSE", 12, 804);
        FAST_ADD_ERR_CODE_FG_CLOSE = r107;
        FastAddErrorCode r108 = new FastAddErrorCode("FAST_ADD_ERR_CODE_NO_SHARE_TOKEN_AFTER_SUBMIT", 13, 805);
        FAST_ADD_ERR_CODE_NO_SHARE_TOKEN_AFTER_SUBMIT = r108;
        FastAddErrorCode[] r109 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108};
        f206974a = r109;
        f206975b = EnumEntriesKt.enumEntries(r109);
    }

    public static FastAddErrorCode[] values() {
        return (FastAddErrorCode[]) f206974a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public static FastAddErrorCode valueOf(String r100) {
        return (FastAddErrorCode) a.a(FastAddErrorCode.class, r100);
    }

    public FastAddErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
