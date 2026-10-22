package com.bytedance.android.shopping.store.home;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/store/home/ActionType;", "", "", "type", "I", "getType", "()I", "ClearAndPlay", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ActionType extends Enum<ActionType> {
    public static final ActionType ClearAndPlay = null;
    public static final /* synthetic */ ActionType[] a = null;
    private final int type;

    static {
        ActionType r1 = new ActionType();
        ClearAndPlay = r1;
        a = new ActionType[]{r1};
    }

    public static ActionType valueOf(String r1) {
        return (ActionType) r27.a.a(ActionType.class, r1);
    }

    public static ActionType[] values() {
        return (ActionType[]) a.clone();
    }

    public ActionType() {
        super("ClearAndPlay", 0);
        this.type = 1;
    }

    public final int getType() {
        return this.type;
    }
}
