package com.bytedance.ug.sdk.luckydog.api.stage;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ug/sdk/luckydog/api/stage/LuckyActivityStage;", "", "NOT_STARTED", "UNDERWAY", "FINISHED", "UNKNOWN", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final enum LuckyActivityStage extends Enum<LuckyActivityStage> {
    public static final LuckyActivityStage FINISHED = null;
    public static final LuckyActivityStage NOT_STARTED = null;
    public static final LuckyActivityStage UNDERWAY = null;
    public static final LuckyActivityStage UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LuckyActivityStage[] f271666a = null;

    static {
        LuckyActivityStage r100 = new LuckyActivityStage("NOT_STARTED", 0);
        NOT_STARTED = r100;
        LuckyActivityStage r101 = new LuckyActivityStage("UNDERWAY", 1);
        UNDERWAY = r101;
        LuckyActivityStage r102 = new LuckyActivityStage("FINISHED", 2);
        FINISHED = r102;
        LuckyActivityStage r103 = new LuckyActivityStage("UNKNOWN", 3);
        UNKNOWN = r103;
        f271666a = new LuckyActivityStage[]{r100, r101, r102, r103};
    }

    public static LuckyActivityStage valueOf(String r100) {
        return (LuckyActivityStage) a.a(LuckyActivityStage.class, r100);
    }

    public static LuckyActivityStage[] values() {
        return (LuckyActivityStage[]) f271666a.clone();
    }

    public LuckyActivityStage(String r100, int r101) {
        super(r100, r101);
    }
}
