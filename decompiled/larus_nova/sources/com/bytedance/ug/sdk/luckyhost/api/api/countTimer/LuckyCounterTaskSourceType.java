package com.bytedance.ug.sdk.luckyhost.api.api.countTimer;

import com.larus.bmhome.chat.bean.SuggestActionType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ug/sdk/luckyhost/api/api/countTimer/LuckyCounterTaskSourceType;", "", "RECOVERY", SuggestActionType.SCHEMA, "luckyhost-api_release"}, k = 1, mv = {1, 4, 0})
public final enum LuckyCounterTaskSourceType extends Enum<LuckyCounterTaskSourceType> {
    public static final LuckyCounterTaskSourceType RECOVERY = null;
    public static final LuckyCounterTaskSourceType SCHEMA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LuckyCounterTaskSourceType[] f272299a = null;

    static {
        LuckyCounterTaskSourceType r100 = new LuckyCounterTaskSourceType("RECOVERY", 0);
        RECOVERY = r100;
        LuckyCounterTaskSourceType r101 = new LuckyCounterTaskSourceType(SuggestActionType.SCHEMA, 1);
        SCHEMA = r101;
        f272299a = new LuckyCounterTaskSourceType[]{r100, r101};
    }

    public static LuckyCounterTaskSourceType valueOf(String r100) {
        return (LuckyCounterTaskSourceType) a.a(LuckyCounterTaskSourceType.class, r100);
    }

    public static LuckyCounterTaskSourceType[] values() {
        return (LuckyCounterTaskSourceType[]) f272299a.clone();
    }

    public LuckyCounterTaskSourceType(String r100, int r101) {
        super(r100, r101);
    }
}
