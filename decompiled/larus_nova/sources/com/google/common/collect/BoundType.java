package com.google.common.collect;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final enum BoundType extends Enum<BoundType> {
    public static final BoundType CLOSED = null;
    public static final BoundType OPEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BoundType[] f274959a = null;
    final boolean inclusive;

    static {
        BoundType r100 = new BoundType("OPEN", 0, false);
        OPEN = r100;
        BoundType r101 = new BoundType(ErrorCode.CLOSED, 1, true);
        CLOSED = r101;
        f274959a = new BoundType[]{r100, r101};
    }

    public static BoundType[] values() {
        return (BoundType[]) f274959a.clone();
    }

    public static BoundType forBoolean(boolean r100) {
        if (r100 == false) goto L5;
        return CLOSED;
    L5:
        return OPEN;
    }

    public static BoundType valueOf(String r100) {
        return (BoundType) r27.a.a(BoundType.class, r100);
    }

    public BoundType(String r100, int r101, boolean r102) {
        super(r100, r101);
        this.inclusive = r102;
    }
}
