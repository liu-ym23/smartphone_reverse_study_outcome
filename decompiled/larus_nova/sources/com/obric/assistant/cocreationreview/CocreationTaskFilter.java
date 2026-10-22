package com.obric.assistant.cocreationreview;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/cocreationreview/CocreationTaskFilter;", "", "label", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getLabel", "()Ljava/lang/String;", AccountType.ALL, "PENDING", "RUN", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CocreationTaskFilter extends Enum<CocreationTaskFilter> {
    public static final CocreationTaskFilter ALL = null;
    public static final CocreationTaskFilter PENDING = null;
    public static final CocreationTaskFilter RUN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CocreationTaskFilter[] f387124a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f387125b = null;
    private final String label;

    public static EnumEntries<CocreationTaskFilter> getEntries() {
        return f387125b;
    }

    static {
        CocreationTaskFilter r100 = new CocreationTaskFilter(AccountType.ALL, 0, "任务总量");
        ALL = r100;
        CocreationTaskFilter r101 = new CocreationTaskFilter("PENDING", 1, "未运行");
        PENDING = r101;
        CocreationTaskFilter r102 = new CocreationTaskFilter("RUN", 2, "已运行");
        RUN = r102;
        CocreationTaskFilter[] r103 = {r100, r101, r102};
        f387124a = r103;
        f387125b = EnumEntriesKt.enumEntries(r103);
    }

    public static CocreationTaskFilter[] values() {
        return (CocreationTaskFilter[]) f387124a.clone();
    }

    public final String getLabel() {
        return this.label;
    }

    public static CocreationTaskFilter valueOf(String r100) {
        return (CocreationTaskFilter) r27.a.a(CocreationTaskFilter.class, r100);
    }

    public CocreationTaskFilter(String r100, int r101, String r102) {
        super(r100, r101);
        this.label = r102;
    }
}
