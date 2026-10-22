package com.bytedance.locallife.model.poi.resp;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/RateTagBreakMode;", "", "", "mode", "I", "getMode", "()I", "BREAK_MODE_END", "BREAK_MODE_START", "BREAK_MODE_MIDDLE", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum RateTagBreakMode extends Enum<RateTagBreakMode> {
    public static final RateTagBreakMode BREAK_MODE_END = null;
    public static final RateTagBreakMode BREAK_MODE_MIDDLE = null;
    public static final RateTagBreakMode BREAK_MODE_START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RateTagBreakMode[] f260860a = null;
    private final int mode;

    public static RateTagBreakMode valueOf(String r100) {
        return (RateTagBreakMode) r27.a.a(RateTagBreakMode.class, r100);
    }

    public static RateTagBreakMode[] values() {
        return (RateTagBreakMode[]) f260860a.clone();
    }

    static {
        RateTagBreakMode r100 = new RateTagBreakMode("BREAK_MODE_END", 0, 0);
        BREAK_MODE_END = r100;
        RateTagBreakMode r101 = new RateTagBreakMode("BREAK_MODE_START", 1, 1);
        BREAK_MODE_START = r101;
        RateTagBreakMode r102 = new RateTagBreakMode("BREAK_MODE_MIDDLE", 2, 2);
        BREAK_MODE_MIDDLE = r102;
        f260860a = new RateTagBreakMode[]{r100, r101, r102};
    }

    public final int getMode() {
        return this.mode;
    }

    public RateTagBreakMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.mode = r102;
    }
}
