package com.larus.agents.impl.webfetch;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/agents/impl/webfetch/WebFetchReportAck;", "", "<init>", "(Ljava/lang/String;I)V", "ACCEPTED", "RETRYABLE", "REJECTED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WebFetchReportAck extends Enum<WebFetchReportAck> {
    public static final WebFetchReportAck ACCEPTED = null;
    public static final WebFetchReportAck REJECTED = null;
    public static final WebFetchReportAck RETRYABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WebFetchReportAck[] f286814a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f286815b = null;

    public static EnumEntries<WebFetchReportAck> getEntries() {
        return f286815b;
    }

    static {
        WebFetchReportAck r100 = new WebFetchReportAck("ACCEPTED", 0);
        ACCEPTED = r100;
        WebFetchReportAck r101 = new WebFetchReportAck("RETRYABLE", 1);
        RETRYABLE = r101;
        WebFetchReportAck r102 = new WebFetchReportAck("REJECTED", 2);
        REJECTED = r102;
        WebFetchReportAck[] r103 = {r100, r101, r102};
        f286814a = r103;
        f286815b = EnumEntriesKt.enumEntries(r103);
    }

    public static WebFetchReportAck[] values() {
        return (WebFetchReportAck[]) f286814a.clone();
    }

    public static WebFetchReportAck valueOf(String r100) {
        return (WebFetchReportAck) r27.a.a(WebFetchReportAck.class, r100);
    }

    public WebFetchReportAck(String r100, int r101) {
        super(r100, r101);
    }
}
