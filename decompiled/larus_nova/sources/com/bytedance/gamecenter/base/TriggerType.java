package com.bytedance.gamecenter.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/gamecenter/base/TriggerType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "GAME", "RES", "ON_FOREGROUND", "gamecenterbase_release"}, k = 1, mv = {1, 4, 3})
public final enum TriggerType extends Enum<TriggerType> {
    public static final TriggerType GAME = null;
    public static final TriggerType ON_FOREGROUND = null;
    public static final TriggerType RES = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TriggerType[] f244942a = null;
    private final String type;

    static {
        TriggerType r100 = new TriggerType("GAME", 0, "game");
        GAME = r100;
        TriggerType r101 = new TriggerType("RES", 1, "res");
        RES = r101;
        TriggerType r102 = new TriggerType("ON_FOREGROUND", 2, "onForeground");
        ON_FOREGROUND = r102;
        f244942a = new TriggerType[]{r100, r101, r102};
    }

    public static TriggerType valueOf(String r100) {
        return (TriggerType) r27.a.a(TriggerType.class, r100);
    }

    public static TriggerType[] values() {
        return (TriggerType[]) f244942a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public TriggerType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
