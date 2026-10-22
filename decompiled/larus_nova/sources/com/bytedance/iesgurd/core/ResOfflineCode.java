package com.bytedance.iesgurd.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0012\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/iesgurd/core/ResOfflineCode;", "", "", "type", "I", "getType", "()I", "INVALID_PARAMS", "BLOCK_BY_ON_DEMAND", "BLOCK_BY_CLEAN_BLOCK_LIST", "BLOCK_BY_LOW_STORAGE", "BLOCK_BY_OCCASION_UPDATE", "NO_PREPARE_META", "WAIT_UPDATE", "UPDATING", "VERSION_IS_FORBIDDEN", "NO_VERSION_FILE", "NO_BUNDLE_FILE", "CHECK_FILE_BROKEN", "ACCESS_KEY_DIR_NOT_REGISTER", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final enum ResOfflineCode extends Enum<ResOfflineCode> {
    public static final ResOfflineCode ACCESS_KEY_DIR_NOT_REGISTER = null;
    public static final ResOfflineCode BLOCK_BY_CLEAN_BLOCK_LIST = null;
    public static final ResOfflineCode BLOCK_BY_LOW_STORAGE = null;
    public static final ResOfflineCode BLOCK_BY_OCCASION_UPDATE = null;
    public static final ResOfflineCode BLOCK_BY_ON_DEMAND = null;
    public static final ResOfflineCode CHECK_FILE_BROKEN = null;
    public static final ResOfflineCode INVALID_PARAMS = null;
    public static final ResOfflineCode NO_BUNDLE_FILE = null;
    public static final ResOfflineCode NO_PREPARE_META = null;
    public static final ResOfflineCode NO_VERSION_FILE = null;
    public static final ResOfflineCode UPDATING = null;
    public static final ResOfflineCode VERSION_IS_FORBIDDEN = null;
    public static final ResOfflineCode WAIT_UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResOfflineCode[] f250644a = null;
    private final int type;

    public static ResOfflineCode valueOf(String r100) {
        return (ResOfflineCode) r27.a.a(ResOfflineCode.class, r100);
    }

    public static ResOfflineCode[] values() {
        return (ResOfflineCode[]) f250644a.clone();
    }

    static {
        ResOfflineCode r100 = new ResOfflineCode("INVALID_PARAMS", 0, -1);
        INVALID_PARAMS = r100;
        ResOfflineCode r101 = new ResOfflineCode("BLOCK_BY_ON_DEMAND", 1, 1);
        BLOCK_BY_ON_DEMAND = r101;
        ResOfflineCode r102 = new ResOfflineCode("BLOCK_BY_CLEAN_BLOCK_LIST", 2, 2);
        BLOCK_BY_CLEAN_BLOCK_LIST = r102;
        ResOfflineCode r103 = new ResOfflineCode("BLOCK_BY_LOW_STORAGE", 3, 3);
        BLOCK_BY_LOW_STORAGE = r103;
        ResOfflineCode r104 = new ResOfflineCode("BLOCK_BY_OCCASION_UPDATE", 4, 4);
        BLOCK_BY_OCCASION_UPDATE = r104;
        ResOfflineCode r105 = new ResOfflineCode("NO_PREPARE_META", 5, 10);
        NO_PREPARE_META = r105;
        ResOfflineCode r106 = new ResOfflineCode("WAIT_UPDATE", 6, 11);
        WAIT_UPDATE = r106;
        ResOfflineCode r107 = new ResOfflineCode("UPDATING", 7, 12);
        UPDATING = r107;
        ResOfflineCode r108 = new ResOfflineCode("VERSION_IS_FORBIDDEN", 8, 13);
        VERSION_IS_FORBIDDEN = r108;
        ResOfflineCode r109 = new ResOfflineCode("NO_VERSION_FILE", 9, 14);
        NO_VERSION_FILE = r109;
        ResOfflineCode r110 = new ResOfflineCode("NO_BUNDLE_FILE", 10, 15);
        NO_BUNDLE_FILE = r110;
        ResOfflineCode r111 = new ResOfflineCode("CHECK_FILE_BROKEN", 11, 16);
        CHECK_FILE_BROKEN = r111;
        ResOfflineCode r112 = new ResOfflineCode("ACCESS_KEY_DIR_NOT_REGISTER", 12, 99);
        ACCESS_KEY_DIR_NOT_REGISTER = r112;
        f250644a = new ResOfflineCode[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112};
    }

    public final int getType() {
        return this.type;
    }

    public ResOfflineCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
