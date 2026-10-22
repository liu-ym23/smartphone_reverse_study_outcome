package com.bytedance.bdp.live.livecontainer.miniapp;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/bdp/live/livecontainer/miniapp/PageStatus;", "", "", "des", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", "ADD", "START_EXPLAIN", "CANCEL_EXPLAIN", "HIDE", "livecontainer_douyinRelease"}, k = 1, mv = {1, 4, 0})
public final enum PageStatus extends Enum<PageStatus> {
    public static final PageStatus ADD = null;
    public static final PageStatus CANCEL_EXPLAIN = null;
    public static final PageStatus HIDE = null;
    public static final PageStatus START_EXPLAIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PageStatus[] f201519a = null;
    private final String des;

    static {
        PageStatus r100 = new PageStatus("ADD", 0, "ADD");
        ADD = r100;
        PageStatus r101 = new PageStatus("START_EXPLAIN", 1, "START_EXPLAIN");
        START_EXPLAIN = r101;
        PageStatus r102 = new PageStatus("CANCEL_EXPLAIN", 2, "CANCEL_EXPLAIN");
        CANCEL_EXPLAIN = r102;
        PageStatus r103 = new PageStatus("HIDE", 3, "HIDE");
        HIDE = r103;
        f201519a = new PageStatus[]{r100, r101, r102, r103};
    }

    public static PageStatus valueOf(String r100) {
        return (PageStatus) a.a(PageStatus.class, r100);
    }

    public static PageStatus[] values() {
        return (PageStatus[]) f201519a.clone();
    }

    public final String getDes() {
        return this.des;
    }

    public PageStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.des = r102;
    }
}
