package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusPrefetchVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/o;", "", "code", "I", "getCode", "()I", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "NOT_MATCH", "PREFETCH_HOST_UNPARSEABLE", "NOT_END_WITH_CORRECT_SUFFIX", "MATCH", "EMPTY_HOST", "PREFETCH_LOAD_OFFLINE_CONFIG", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusPrefetchVerifyReason extends Enum<ArgusPrefetchVerifyReason> implements o {
    public static final ArgusPrefetchVerifyReason EMPTY_HOST = null;
    public static final ArgusPrefetchVerifyReason MATCH = null;
    public static final ArgusPrefetchVerifyReason NOT_END_WITH_CORRECT_SUFFIX = null;
    public static final ArgusPrefetchVerifyReason NOT_MATCH = null;
    public static final ArgusPrefetchVerifyReason PREFETCH_HOST_UNPARSEABLE = null;
    public static final ArgusPrefetchVerifyReason PREFETCH_LOAD_OFFLINE_CONFIG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusPrefetchVerifyReason[] f245966a = null;
    private final int code;
    private final String strValue;

    public static ArgusPrefetchVerifyReason valueOf(String r100) {
        return (ArgusPrefetchVerifyReason) r27.a.a(ArgusPrefetchVerifyReason.class, r100);
    }

    public static ArgusPrefetchVerifyReason[] values() {
        return (ArgusPrefetchVerifyReason[]) f245966a.clone();
    }

    static {
        ArgusPrefetchVerifyReason r100 = new ArgusPrefetchVerifyReason("NOT_MATCH", 0, -1, "not match white list");
        NOT_MATCH = r100;
        ArgusPrefetchVerifyReason r101 = new ArgusPrefetchVerifyReason("PREFETCH_HOST_UNPARSEABLE", 1, -2, "prefetch host unparseable");
        PREFETCH_HOST_UNPARSEABLE = r101;
        ArgusPrefetchVerifyReason r102 = new ArgusPrefetchVerifyReason("NOT_END_WITH_CORRECT_SUFFIX", 2, -3, "not end with correct suffix");
        NOT_END_WITH_CORRECT_SUFFIX = r102;
        ArgusPrefetchVerifyReason r103 = new ArgusPrefetchVerifyReason("MATCH", 3, 1, "match white list");
        MATCH = r103;
        ArgusPrefetchVerifyReason r104 = new ArgusPrefetchVerifyReason("EMPTY_HOST", 4, 2, "empty host");
        EMPTY_HOST = r104;
        ArgusPrefetchVerifyReason r105 = new ArgusPrefetchVerifyReason("PREFETCH_LOAD_OFFLINE_CONFIG", 5, 3, "prefetch load offline config");
        PREFETCH_LOAD_OFFLINE_CONFIG = r105;
        f245966a = new ArgusPrefetchVerifyReason[]{r100, r101, r102, r103, r104, r105};
    }

    @Override // com.bytedance.ies.argus.bean.o
    public int getCode() {
        return this.code;
    }

    @Override // com.bytedance.ies.argus.bean.o
    public String getStrValue() {
        return this.strValue;
    }

    public ArgusPrefetchVerifyReason(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.strValue = r103;
    }
}
