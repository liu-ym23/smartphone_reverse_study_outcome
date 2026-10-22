package com.bytedance.ee.bear.list.list.multiselect;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum ListBatchAction extends Enum<ListBatchAction> {
    public static final ListBatchAction DELETE = null;
    public static final ListBatchAction REMOVE_RECENT = null;
    public static final /* synthetic */ ListBatchAction[] a = null;

    static {
        ListBatchAction r0 = new ListBatchAction("DELETE", 0);
        DELETE = r0;
        ListBatchAction r1 = new ListBatchAction("REMOVE_RECENT", 1);
        REMOVE_RECENT = r1;
        a = new ListBatchAction[]{r0, r1};
    }

    public static ListBatchAction[] values() {
        return (ListBatchAction[]) a.clone();
    }

    public static ListBatchAction valueOf(String r1) {
        return (ListBatchAction) a.a(ListBatchAction.class, r1);
    }

    public ListBatchAction(String r1, int r2) {
        super(r1, r2);
    }
}
