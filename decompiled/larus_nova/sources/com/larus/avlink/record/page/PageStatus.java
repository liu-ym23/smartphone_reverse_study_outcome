package com.larus.avlink.record.page;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/avlink/record/page/PageStatus;", "", "<init>", "(Ljava/lang/String;I)V", "ONBOARDING", "LOADING", "SUCCESS", "ERROR", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PageStatus extends Enum<PageStatus> {
    public static final PageStatus ERROR = null;
    public static final PageStatus LOADING = null;
    public static final PageStatus ONBOARDING = null;
    public static final PageStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PageStatus[] f294146a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f294147b = null;

    public static EnumEntries<PageStatus> getEntries() {
        return f294147b;
    }

    static {
        PageStatus r100 = new PageStatus("ONBOARDING", 0);
        ONBOARDING = r100;
        PageStatus r101 = new PageStatus("LOADING", 1);
        LOADING = r101;
        PageStatus r102 = new PageStatus("SUCCESS", 2);
        SUCCESS = r102;
        PageStatus r103 = new PageStatus("ERROR", 3);
        ERROR = r103;
        PageStatus[] r104 = {r100, r101, r102, r103};
        f294146a = r104;
        f294147b = EnumEntriesKt.enumEntries(r104);
    }

    public static PageStatus[] values() {
        return (PageStatus[]) f294146a.clone();
    }

    public static PageStatus valueOf(String r100) {
        return (PageStatus) r27.a.a(PageStatus.class, r100);
    }

    public PageStatus(String r100, int r101) {
        super(r100, r101);
    }
}
