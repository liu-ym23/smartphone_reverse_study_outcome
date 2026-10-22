package com.larus.avlink.business.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/avlink/business/api/DoraAvlinkSessionEndReason;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "TIMEOUT_8S", "TIMEOUT_30S", "COMPANION_MODE", "USER_CANCEL", "dora_business_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraAvlinkSessionEndReason extends Enum<DoraAvlinkSessionEndReason> {
    public static final DoraAvlinkSessionEndReason COMPANION_MODE = null;
    public static final DoraAvlinkSessionEndReason TIMEOUT_30S = null;
    public static final DoraAvlinkSessionEndReason TIMEOUT_8S = null;
    public static final DoraAvlinkSessionEndReason UNKNOWN = null;
    public static final DoraAvlinkSessionEndReason USER_CANCEL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraAvlinkSessionEndReason[] f291700a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291701b = null;
    private final int value;

    public static EnumEntries<DoraAvlinkSessionEndReason> getEntries() {
        return f291701b;
    }

    static {
        DoraAvlinkSessionEndReason r100 = new DoraAvlinkSessionEndReason("UNKNOWN", 0, 255);
        UNKNOWN = r100;
        DoraAvlinkSessionEndReason r101 = new DoraAvlinkSessionEndReason("TIMEOUT_8S", 1, 3);
        TIMEOUT_8S = r101;
        DoraAvlinkSessionEndReason r102 = new DoraAvlinkSessionEndReason("TIMEOUT_30S", 2, 15);
        TIMEOUT_30S = r102;
        DoraAvlinkSessionEndReason r103 = new DoraAvlinkSessionEndReason("COMPANION_MODE", 3, 32);
        COMPANION_MODE = r103;
        DoraAvlinkSessionEndReason r104 = new DoraAvlinkSessionEndReason("USER_CANCEL", 4, 1);
        USER_CANCEL = r104;
        DoraAvlinkSessionEndReason[] r105 = {r100, r101, r102, r103, r104};
        f291700a = r105;
        f291701b = EnumEntriesKt.enumEntries(r105);
    }

    public static DoraAvlinkSessionEndReason[] values() {
        return (DoraAvlinkSessionEndReason[]) f291700a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DoraAvlinkSessionEndReason valueOf(String r100) {
        return (DoraAvlinkSessionEndReason) a.a(DoraAvlinkSessionEndReason.class, r100);
    }

    public DoraAvlinkSessionEndReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
