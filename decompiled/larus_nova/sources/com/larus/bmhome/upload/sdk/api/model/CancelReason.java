package com.larus.bmhome.upload.sdk.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/upload/sdk/api/model/CancelReason;", "", "reason", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getReason", "()Ljava/lang/String;", "User", "LeaveChat", "Replaced", "Shutdown", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CancelReason extends Enum<CancelReason> {
    public static final CancelReason LeaveChat = null;
    public static final CancelReason Replaced = null;
    public static final CancelReason Shutdown = null;
    public static final CancelReason User = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CancelReason[] f314810a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f314811b = null;
    private final String reason;

    public static EnumEntries<CancelReason> getEntries() {
        return f314811b;
    }

    static {
        CancelReason r100 = new CancelReason("User", 0, "user_cancel");
        User = r100;
        CancelReason r101 = new CancelReason("LeaveChat", 1, "leave_chat");
        LeaveChat = r101;
        CancelReason r102 = new CancelReason("Replaced", 2, "replaced");
        Replaced = r102;
        CancelReason r103 = new CancelReason("Shutdown", 3, "shutdown");
        Shutdown = r103;
        CancelReason[] r104 = {r100, r101, r102, r103};
        f314810a = r104;
        f314811b = EnumEntriesKt.enumEntries(r104);
    }

    public static CancelReason[] values() {
        return (CancelReason[]) f314810a.clone();
    }

    public final String getReason() {
        return this.reason;
    }

    public static CancelReason valueOf(String r100) {
        return (CancelReason) a.a(CancelReason.class, r100);
    }

    public CancelReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.reason = r102;
    }
}
