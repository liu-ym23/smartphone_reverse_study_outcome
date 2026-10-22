package com.bytedance.android.shopping.feedbackpanel.enums;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/feedbackpanel/enums/WhereType;", "", "GROUP_TOP", "GROUP_MID", "GROUP_BOTTOM", "GROUP_ONLY_ONE", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WhereType extends Enum<WhereType> {
    public static final WhereType GROUP_BOTTOM = null;
    public static final WhereType GROUP_MID = null;
    public static final WhereType GROUP_ONLY_ONE = null;
    public static final WhereType GROUP_TOP = null;
    public static final /* synthetic */ WhereType[] a = null;

    static {
        WhereType r1 = new WhereType("GROUP_TOP", 0);
        GROUP_TOP = r1;
        WhereType r2 = new WhereType("GROUP_MID", 1);
        GROUP_MID = r2;
        WhereType r3 = new WhereType("GROUP_BOTTOM", 2);
        GROUP_BOTTOM = r3;
        WhereType r4 = new WhereType("GROUP_ONLY_ONE", 3);
        GROUP_ONLY_ONE = r4;
        a = new WhereType[]{r1, r2, r3, r4};
    }

    public static WhereType valueOf(String r1) {
        return (WhereType) a.a(WhereType.class, r1);
    }

    public static WhereType[] values() {
        return (WhereType[]) a.clone();
    }

    public WhereType(String r1, int r2) {
        super(r1, r2);
    }
}
