package com.larus.dora.impl.resource;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/impl/resource/DoraResourceSyncTrigger;", "", "<init>", "(Ljava/lang/String;I)V", "COLD_START", "LOGIN", "PAGE_ENTRY", "FOREGROUND_STALE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraResourceSyncTrigger extends Enum<DoraResourceSyncTrigger> {
    public static final DoraResourceSyncTrigger COLD_START = null;
    public static final DoraResourceSyncTrigger FOREGROUND_STALE = null;
    public static final DoraResourceSyncTrigger LOGIN = null;
    public static final DoraResourceSyncTrigger PAGE_ENTRY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraResourceSyncTrigger[] f337830a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f337831b = null;

    public static EnumEntries<DoraResourceSyncTrigger> getEntries() {
        return f337831b;
    }

    static {
        DoraResourceSyncTrigger r100 = new DoraResourceSyncTrigger("COLD_START", 0);
        COLD_START = r100;
        DoraResourceSyncTrigger r101 = new DoraResourceSyncTrigger("LOGIN", 1);
        LOGIN = r101;
        DoraResourceSyncTrigger r102 = new DoraResourceSyncTrigger("PAGE_ENTRY", 2);
        PAGE_ENTRY = r102;
        DoraResourceSyncTrigger r103 = new DoraResourceSyncTrigger("FOREGROUND_STALE", 3);
        FOREGROUND_STALE = r103;
        DoraResourceSyncTrigger[] r104 = {r100, r101, r102, r103};
        f337830a = r104;
        f337831b = EnumEntriesKt.enumEntries(r104);
    }

    public static DoraResourceSyncTrigger[] values() {
        return (DoraResourceSyncTrigger[]) f337830a.clone();
    }

    public static DoraResourceSyncTrigger valueOf(String r100) {
        return (DoraResourceSyncTrigger) r27.a.a(DoraResourceSyncTrigger.class, r100);
    }

    public DoraResourceSyncTrigger(String r100, int r101) {
        super(r100, r101);
    }
}
