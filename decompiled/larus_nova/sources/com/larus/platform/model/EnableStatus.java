package com.larus.platform.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/platform/model/EnableStatus;", "", "status", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStatus", "()Ljava/lang/String;", "DISABLE", "ENABLE", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EnableStatus extends Enum<EnableStatus> {
    public static final EnableStatus DISABLE = null;
    public static final EnableStatus ENABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EnableStatus[] f365454a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365455b = null;
    private final String status;

    public static EnumEntries<EnableStatus> getEntries() {
        return f365455b;
    }

    static {
        EnableStatus r100 = new EnableStatus("DISABLE", 0, "0");
        DISABLE = r100;
        EnableStatus r101 = new EnableStatus("ENABLE", 1, "1");
        ENABLE = r101;
        EnableStatus[] r102 = {r100, r101};
        f365454a = r102;
        f365455b = EnumEntriesKt.enumEntries(r102);
    }

    public static EnableStatus[] values() {
        return (EnableStatus[]) f365454a.clone();
    }

    public final String getStatus() {
        return this.status;
    }

    public static EnableStatus valueOf(String r100) {
        return (EnableStatus) a.a(EnableStatus.class, r100);
    }

    public EnableStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.status = r102;
    }
}
