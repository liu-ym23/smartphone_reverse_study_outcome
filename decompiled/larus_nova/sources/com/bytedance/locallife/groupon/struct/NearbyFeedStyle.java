package com.bytedance.locallife.groupon.struct;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0000j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/NearbyFeedStyle;", "", "(Ljava/lang/String;I)V", "isDual", "", "isFull", "opposite", "FULL", "DUAL", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum NearbyFeedStyle extends Enum<NearbyFeedStyle> {
    private static final /* synthetic */ NearbyFeedStyle[] $VALUES = null;
    public static final NearbyFeedStyle DUAL = null;
    public static final NearbyFeedStyle FULL = null;

    private static final /* synthetic */ NearbyFeedStyle[] $values() {
        return new NearbyFeedStyle[]{FULL, DUAL};
    }

    public static NearbyFeedStyle valueOf(String r100) {
        return (NearbyFeedStyle) r27.a.a(NearbyFeedStyle.class, r100);
    }

    public static NearbyFeedStyle[] values() {
        return (NearbyFeedStyle[]) $VALUES.clone();
    }

    static {
        FULL = new NearbyFeedStyle("FULL", 0);
        DUAL = new NearbyFeedStyle("DUAL", 1);
        $VALUES = $values();
    }

    public final boolean isDual() {
        if (this != DUAL) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFull() {
        if (this != FULL) goto L5;
        return true;
    L5:
        return false;
    }

    public final NearbyFeedStyle opposite() {
        NearbyFeedStyle r100 = DUAL;
        if (this == r100) goto L5;
        NearbyFeedStyle r101 = FULL;
        if (this != r101) goto L9;
        return r100;
    L9:
        return r101;
    L5:
        return FULL;
    }

    private NearbyFeedStyle(String r100, int r101) {
        super(r100, r101);
    }
}
