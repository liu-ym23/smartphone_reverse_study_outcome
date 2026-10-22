package com.larus.reach.api;

import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/reach/api/ReachRejectReason;", "", "discardReason", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDiscardReason", "()Ljava/lang/String;", "REVOKED", "EXPIRED", "BUSINESS_NOT_ALLOWED", "NOT_TARGET_PAGE", "PRIORITY_QUEUE", "NOTIFICATION_DISABLED", "INVALID_PROTOCOL", "CLIENT_EXCEPTION", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReachRejectReason extends Enum<ReachRejectReason> {
    public static final ReachRejectReason BUSINESS_NOT_ALLOWED = null;
    public static final ReachRejectReason CLIENT_EXCEPTION = null;
    public static final ReachRejectReason EXPIRED = null;
    public static final ReachRejectReason INVALID_PROTOCOL = null;
    public static final ReachRejectReason NOTIFICATION_DISABLED = null;
    public static final ReachRejectReason NOT_TARGET_PAGE = null;
    public static final ReachRejectReason PRIORITY_QUEUE = null;
    public static final ReachRejectReason REVOKED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReachRejectReason[] f367133a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f367134b = null;
    private final String discardReason;

    public static EnumEntries<ReachRejectReason> getEntries() {
        return f367134b;
    }

    static {
        ReachRejectReason r100 = new ReachRejectReason("REVOKED", 0, "revoked");
        REVOKED = r100;
        ReachRejectReason r101 = new ReachRejectReason("EXPIRED", 1, AiBotPollingAuthResult.STATUS_EXPIRED);
        EXPIRED = r101;
        ReachRejectReason r102 = new ReachRejectReason("BUSINESS_NOT_ALLOWED", 2, "business_filtered");
        BUSINESS_NOT_ALLOWED = r102;
        ReachRejectReason r103 = new ReachRejectReason("NOT_TARGET_PAGE", 3, "not_target_page");
        NOT_TARGET_PAGE = r103;
        ReachRejectReason r104 = new ReachRejectReason("PRIORITY_QUEUE", 4, "priority_queue");
        PRIORITY_QUEUE = r104;
        ReachRejectReason r105 = new ReachRejectReason("NOTIFICATION_DISABLED", 5, "notification_disabled");
        NOTIFICATION_DISABLED = r105;
        ReachRejectReason r110 = new ReachRejectReason("INVALID_PROTOCOL", 6, "unknown_payload");
        INVALID_PROTOCOL = r110;
        ReachRejectReason r111 = new ReachRejectReason("CLIENT_EXCEPTION", 7, "client_exception");
        CLIENT_EXCEPTION = r111;
        ReachRejectReason[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f367133a = r112;
        f367134b = EnumEntriesKt.enumEntries(r112);
    }

    public static ReachRejectReason[] values() {
        return (ReachRejectReason[]) f367133a.clone();
    }

    public final String getDiscardReason() {
        return this.discardReason;
    }

    public static ReachRejectReason valueOf(String r100) {
        return (ReachRejectReason) a.a(ReachRejectReason.class, r100);
    }

    public ReachRejectReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.discardReason = r102;
    }
}
