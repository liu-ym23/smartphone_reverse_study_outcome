package com.bytedance.ug.sdk.luckydog.api.stage;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ug/sdk/luckydog/api/stage/LuckyActivityBlockStage;", "", "", "value", "I", "getValue", "()I", "PLAYED", "NOT_PLAY", "UNKNOWN", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final enum LuckyActivityBlockStage extends Enum<LuckyActivityBlockStage> {
    public static final LuckyActivityBlockStage NOT_PLAY = null;
    public static final LuckyActivityBlockStage PLAYED = null;
    public static final LuckyActivityBlockStage UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LuckyActivityBlockStage[] f271665a = null;
    private final int value;

    static {
        LuckyActivityBlockStage r100 = new LuckyActivityBlockStage("PLAYED", 0, 1);
        PLAYED = r100;
        LuckyActivityBlockStage r101 = new LuckyActivityBlockStage("NOT_PLAY", 1, 0);
        NOT_PLAY = r101;
        LuckyActivityBlockStage r102 = new LuckyActivityBlockStage("UNKNOWN", 2, -1);
        UNKNOWN = r102;
        f271665a = new LuckyActivityBlockStage[]{r100, r101, r102};
    }

    public static LuckyActivityBlockStage valueOf(String r100) {
        return (LuckyActivityBlockStage) a.a(LuckyActivityBlockStage.class, r100);
    }

    public static LuckyActivityBlockStage[] values() {
        return (LuckyActivityBlockStage[]) f271665a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LuckyActivityBlockStage(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
