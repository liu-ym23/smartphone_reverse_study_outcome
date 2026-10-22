package com.bytedance.android.shopping.store.tabkit.container;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/container/Action;", "", "ON_CREATE", "ON_DESTROY", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Action extends Enum<Action> {
    public static final Action ON_CREATE = null;
    public static final Action ON_DESTROY = null;
    public static final /* synthetic */ Action[] a = null;

    static {
        Action r1 = new Action("ON_CREATE", 0);
        ON_CREATE = r1;
        Action r2 = new Action("ON_DESTROY", 1);
        ON_DESTROY = r2;
        a = new Action[]{r1, r2};
    }

    public static Action valueOf(String r1) {
        return (Action) r27.a.a(Action.class, r1);
    }

    public static Action[] values() {
        return (Action[]) a.clone();
    }

    public Action(String r1, int r2) {
        super(r1, r2);
    }
}
