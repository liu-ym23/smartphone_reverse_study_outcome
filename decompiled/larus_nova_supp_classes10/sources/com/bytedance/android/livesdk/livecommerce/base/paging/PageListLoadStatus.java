package com.bytedance.android.livesdk.livecommerce.base.paging;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/base/paging/PageListLoadStatus;", "", "Initialize", "InitializeSuccess", "InitializeError", "InitializeEmpty", "LoadMoreIn", "LoadMoreSuccess", "LoadMoreError", "LoadMoreEnd", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PageListLoadStatus extends Enum<PageListLoadStatus> {
    public static final PageListLoadStatus Initialize = null;
    public static final PageListLoadStatus InitializeEmpty = null;
    public static final PageListLoadStatus InitializeError = null;
    public static final PageListLoadStatus InitializeSuccess = null;
    public static final PageListLoadStatus LoadMoreEnd = null;
    public static final PageListLoadStatus LoadMoreError = null;
    public static final PageListLoadStatus LoadMoreIn = null;
    public static final PageListLoadStatus LoadMoreSuccess = null;
    public static final /* synthetic */ PageListLoadStatus[] a = null;

    static {
        PageListLoadStatus r1 = new PageListLoadStatus("Initialize", 0);
        Initialize = r1;
        PageListLoadStatus r2 = new PageListLoadStatus("InitializeSuccess", 1);
        InitializeSuccess = r2;
        PageListLoadStatus r3 = new PageListLoadStatus("InitializeError", 2);
        InitializeError = r3;
        PageListLoadStatus r4 = new PageListLoadStatus("InitializeEmpty", 3);
        InitializeEmpty = r4;
        PageListLoadStatus r5 = new PageListLoadStatus("LoadMoreIn", 4);
        LoadMoreIn = r5;
        PageListLoadStatus r6 = new PageListLoadStatus("LoadMoreSuccess", 5);
        LoadMoreSuccess = r6;
        PageListLoadStatus r7 = new PageListLoadStatus("LoadMoreError", 6);
        LoadMoreError = r7;
        PageListLoadStatus r8 = new PageListLoadStatus("LoadMoreEnd", 7);
        LoadMoreEnd = r8;
        a = new PageListLoadStatus[]{r1, r2, r3, r4, r5, r6, r7, r8};
    }

    public static PageListLoadStatus valueOf(String r1) {
        return (PageListLoadStatus) a.a(PageListLoadStatus.class, r1);
    }

    public static PageListLoadStatus[] values() {
        return (PageListLoadStatus[]) a.clone();
    }

    public PageListLoadStatus(String r1, int r2) {
        super(r1, r2);
    }
}
