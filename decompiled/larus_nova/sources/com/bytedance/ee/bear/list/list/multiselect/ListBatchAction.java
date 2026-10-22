package com.bytedance.ee.bear.list.list.multiselect;

import r27.a;

/* JADX INFO: loaded from: classes18.dex */
public final enum ListBatchAction extends Enum<ListBatchAction> {
    public static final ListBatchAction DELETE = null;
    public static final ListBatchAction REMOVE_RECENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ListBatchAction[] f228606a = null;

    static {
        ListBatchAction r100 = new ListBatchAction("DELETE", 0);
        DELETE = r100;
        ListBatchAction r101 = new ListBatchAction("REMOVE_RECENT", 1);
        REMOVE_RECENT = r101;
        f228606a = new ListBatchAction[]{r100, r101};
    }

    public static ListBatchAction[] values() {
        return (ListBatchAction[]) f228606a.clone();
    }

    public static ListBatchAction valueOf(String r100) {
        return (ListBatchAction) a.a(ListBatchAction.class, r100);
    }

    public ListBatchAction(String r100, int r101) {
        super(r100, r101);
    }
}
