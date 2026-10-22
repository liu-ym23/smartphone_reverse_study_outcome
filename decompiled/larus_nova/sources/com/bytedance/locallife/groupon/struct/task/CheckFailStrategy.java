package com.bytedance.locallife.groupon.struct.task;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/task/CheckFailStrategy;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "SKIP", "DISCARD", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum CheckFailStrategy extends Enum<CheckFailStrategy> {
    public static final CheckFailStrategy DISCARD = null;
    public static final CheckFailStrategy SKIP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CheckFailStrategy[] f258852a = null;
    private final String key;

    public static CheckFailStrategy valueOf(String r100) {
        return (CheckFailStrategy) a.a(CheckFailStrategy.class, r100);
    }

    public static CheckFailStrategy[] values() {
        return (CheckFailStrategy[]) f258852a.clone();
    }

    static {
        CheckFailStrategy r100 = new CheckFailStrategy("SKIP", 0, "skip");
        SKIP = r100;
        CheckFailStrategy r101 = new CheckFailStrategy("DISCARD", 1, "discard");
        DISCARD = r101;
        f258852a = new CheckFailStrategy[]{r100, r101};
    }

    public final String getKey() {
        return this.key;
    }

    public CheckFailStrategy(String r100, int r101, String r102) {
        super(r100, r101);
        this.key = r102;
    }
}
