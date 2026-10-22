package com.larus.bmhome.miniartifact.listpage.request;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/miniartifact/listpage/request/PageStatus;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "SUCCESS", "EMPTY", "FAIL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PageStatus extends Enum<PageStatus> {
    public static final PageStatus EMPTY = null;
    public static final PageStatus FAIL = null;
    public static final PageStatus LOADING = null;
    public static final PageStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PageStatus[] f312603a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f312604b = null;

    public static EnumEntries<PageStatus> getEntries() {
        return f312604b;
    }

    static {
        PageStatus r100 = new PageStatus("LOADING", 0);
        LOADING = r100;
        PageStatus r101 = new PageStatus("SUCCESS", 1);
        SUCCESS = r101;
        PageStatus r102 = new PageStatus("EMPTY", 2);
        EMPTY = r102;
        PageStatus r103 = new PageStatus("FAIL", 3);
        FAIL = r103;
        PageStatus[] r104 = {r100, r101, r102, r103};
        f312603a = r104;
        f312604b = EnumEntriesKt.enumEntries(r104);
    }

    public static PageStatus[] values() {
        return (PageStatus[]) f312603a.clone();
    }

    public static PageStatus valueOf(String r100) {
        return (PageStatus) r27.a.a(PageStatus.class, r100);
    }

    public PageStatus(String r100, int r101) {
        super(r100, r101);
    }
}
