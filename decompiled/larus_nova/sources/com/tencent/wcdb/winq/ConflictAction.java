package com.tencent.wcdb.winq;

import com.bytedance.android.shopping.buynow.data.model.CheckStatus;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum ConflictAction extends Enum<ConflictAction> {
    private static final /* synthetic */ ConflictAction[] $VALUES = null;
    public static final ConflictAction Abort = null;
    public static final ConflictAction Fail = null;
    public static final ConflictAction Ignore = null;
    public static final ConflictAction None = null;
    public static final ConflictAction Replace = null;
    public static final ConflictAction Rollback = null;

    private static /* synthetic */ ConflictAction[] $values() {
        return new ConflictAction[]{None, Replace, Rollback, Abort, Fail, Ignore};
    }

    static {
        None = new ConflictAction("None", 0);
        Replace = new ConflictAction("Replace", 1);
        Rollback = new ConflictAction("Rollback", 2);
        Abort = new ConflictAction("Abort", 3);
        Fail = new ConflictAction(CheckStatus.FAIL, 4);
        Ignore = new ConflictAction("Ignore", 5);
        $VALUES = $values();
    }

    public static ConflictAction[] values() {
        return (ConflictAction[]) $VALUES.clone();
    }

    public static ConflictAction valueOf(String r100) {
        return (ConflictAction) a.a(ConflictAction.class, r100);
    }

    private ConflictAction(String r100, int r101) {
        super(r100, r101);
    }
}
