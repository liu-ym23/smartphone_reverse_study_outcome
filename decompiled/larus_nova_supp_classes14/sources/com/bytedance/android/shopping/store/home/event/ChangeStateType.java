package com.bytedance.android.shopping.store.home.event;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/home/event/ChangeStateType;", "", "AUTO", "HAND", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ChangeStateType extends Enum<ChangeStateType> {
    public static final ChangeStateType AUTO = null;
    public static final ChangeStateType HAND = null;
    public static final /* synthetic */ ChangeStateType[] a = null;

    static {
        ChangeStateType r1 = new ChangeStateType("AUTO", 0);
        AUTO = r1;
        ChangeStateType r2 = new ChangeStateType("HAND", 1);
        HAND = r2;
        a = new ChangeStateType[]{r1, r2};
    }

    public static ChangeStateType valueOf(String r1) {
        return (ChangeStateType) a.a(ChangeStateType.class, r1);
    }

    public static ChangeStateType[] values() {
        return (ChangeStateType[]) a.clone();
    }

    public ChangeStateType(String r1, int r2) {
        super(r1, r2);
    }
}
