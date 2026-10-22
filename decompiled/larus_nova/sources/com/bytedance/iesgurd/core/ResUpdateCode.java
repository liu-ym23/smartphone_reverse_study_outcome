package com.bytedance.iesgurd.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/iesgurd/core/ResUpdateCode;", "", "", "type", "I", "getType", "()I", "NO_PREPARE_META", "UPDATE_FAILED", "NO_VERSION_FILE", "NO_BUNDLE_FILE", "CHECK_FILE_BROKEN", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final enum ResUpdateCode extends Enum<ResUpdateCode> {
    public static final ResUpdateCode CHECK_FILE_BROKEN = null;
    public static final ResUpdateCode NO_BUNDLE_FILE = null;
    public static final ResUpdateCode NO_PREPARE_META = null;
    public static final ResUpdateCode NO_VERSION_FILE = null;
    public static final ResUpdateCode UPDATE_FAILED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResUpdateCode[] f250645a = null;
    private final int type;

    static {
        ResUpdateCode r100 = new ResUpdateCode("NO_PREPARE_META", 0, 1);
        NO_PREPARE_META = r100;
        ResUpdateCode r101 = new ResUpdateCode("UPDATE_FAILED", 1, 2);
        UPDATE_FAILED = r101;
        ResUpdateCode r102 = new ResUpdateCode("NO_VERSION_FILE", 2, 14);
        NO_VERSION_FILE = r102;
        ResUpdateCode r103 = new ResUpdateCode("NO_BUNDLE_FILE", 3, 15);
        NO_BUNDLE_FILE = r103;
        ResUpdateCode r104 = new ResUpdateCode("CHECK_FILE_BROKEN", 4, 16);
        CHECK_FILE_BROKEN = r104;
        f250645a = new ResUpdateCode[]{r100, r101, r102, r103, r104};
    }

    public static ResUpdateCode valueOf(String r100) {
        return (ResUpdateCode) r27.a.a(ResUpdateCode.class, r100);
    }

    public static ResUpdateCode[] values() {
        return (ResUpdateCode[]) f250645a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ResUpdateCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
