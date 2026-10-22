package com.bytedance.ug.sdk.luckyhost.api.api.countTimer;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ug/sdk/luckyhost/api/api/countTimer/LuckyCounterPendantHideFrom;", "", "QUIT_SCENE", "PENDANT_EXCLUSION", "RULE_CHANGE", "luckyhost-api_release"}, k = 1, mv = {1, 4, 0})
public final enum LuckyCounterPendantHideFrom extends Enum<LuckyCounterPendantHideFrom> {
    public static final LuckyCounterPendantHideFrom PENDANT_EXCLUSION = null;
    public static final LuckyCounterPendantHideFrom QUIT_SCENE = null;
    public static final LuckyCounterPendantHideFrom RULE_CHANGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LuckyCounterPendantHideFrom[] f272298a = null;

    static {
        LuckyCounterPendantHideFrom r100 = new LuckyCounterPendantHideFrom("QUIT_SCENE", 0);
        QUIT_SCENE = r100;
        LuckyCounterPendantHideFrom r101 = new LuckyCounterPendantHideFrom("PENDANT_EXCLUSION", 1);
        PENDANT_EXCLUSION = r101;
        LuckyCounterPendantHideFrom r102 = new LuckyCounterPendantHideFrom("RULE_CHANGE", 2);
        RULE_CHANGE = r102;
        f272298a = new LuckyCounterPendantHideFrom[]{r100, r101, r102};
    }

    public static LuckyCounterPendantHideFrom valueOf(String r100) {
        return (LuckyCounterPendantHideFrom) a.a(LuckyCounterPendantHideFrom.class, r100);
    }

    public static LuckyCounterPendantHideFrom[] values() {
        return (LuckyCounterPendantHideFrom[]) f272298a.clone();
    }

    public LuckyCounterPendantHideFrom(String r100, int r101) {
        super(r100, r101);
    }
}
