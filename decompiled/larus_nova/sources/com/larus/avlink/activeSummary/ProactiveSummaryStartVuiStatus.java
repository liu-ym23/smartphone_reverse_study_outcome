package com.larus.avlink.activeSummary;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/avlink/activeSummary/ProactiveSummaryStartVuiStatus;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "SUCCESS", "FAIL", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ProactiveSummaryStartVuiStatus extends Enum<ProactiveSummaryStartVuiStatus> {
    public static final ProactiveSummaryStartVuiStatus FAIL = null;
    public static final ProactiveSummaryStartVuiStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProactiveSummaryStartVuiStatus[] f291435a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291436b = null;
    private final int code;

    public static EnumEntries<ProactiveSummaryStartVuiStatus> getEntries() {
        return f291436b;
    }

    static {
        ProactiveSummaryStartVuiStatus r100 = new ProactiveSummaryStartVuiStatus("SUCCESS", 0, 1);
        SUCCESS = r100;
        ProactiveSummaryStartVuiStatus r101 = new ProactiveSummaryStartVuiStatus("FAIL", 1, 0);
        FAIL = r101;
        ProactiveSummaryStartVuiStatus[] r102 = {r100, r101};
        f291435a = r102;
        f291436b = EnumEntriesKt.enumEntries(r102);
    }

    public static ProactiveSummaryStartVuiStatus[] values() {
        return (ProactiveSummaryStartVuiStatus[]) f291435a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public static ProactiveSummaryStartVuiStatus valueOf(String r100) {
        return (ProactiveSummaryStartVuiStatus) r27.a.a(ProactiveSummaryStartVuiStatus.class, r100);
    }

    public ProactiveSummaryStartVuiStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
