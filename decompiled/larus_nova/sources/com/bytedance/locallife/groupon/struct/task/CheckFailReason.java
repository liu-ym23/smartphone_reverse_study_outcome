package com.bytedance.locallife.groupon.struct.task;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/task/CheckFailReason;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "UI_AVOID", "RUN_CHECK_FAIL", "DATA_INVALID", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum CheckFailReason extends Enum<CheckFailReason> {
    public static final CheckFailReason DATA_INVALID = null;
    public static final CheckFailReason RUN_CHECK_FAIL = null;
    public static final CheckFailReason UI_AVOID = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CheckFailReason[] f258851a = null;
    private final String key;

    public static CheckFailReason valueOf(String r100) {
        return (CheckFailReason) a.a(CheckFailReason.class, r100);
    }

    public static CheckFailReason[] values() {
        return (CheckFailReason[]) f258851a.clone();
    }

    static {
        CheckFailReason r100 = new CheckFailReason("UI_AVOID", 0, "requestComponentShow fail");
        UI_AVOID = r100;
        CheckFailReason r101 = new CheckFailReason("RUN_CHECK_FAIL", 1, "evaluateRunCheckExpression fail");
        RUN_CHECK_FAIL = r101;
        CheckFailReason r102 = new CheckFailReason("DATA_INVALID", 2, "data invalid");
        DATA_INVALID = r102;
        f258851a = new CheckFailReason[]{r100, r101, r102};
    }

    public final String getKey() {
        return this.key;
    }

    public CheckFailReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.key = r102;
    }
}
