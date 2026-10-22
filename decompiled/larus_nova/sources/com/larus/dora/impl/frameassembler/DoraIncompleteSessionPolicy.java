package com.larus.dora.impl.frameassembler;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/frameassembler/DoraIncompleteSessionPolicy;", "", "<init>", "(Ljava/lang/String;I)V", "DISCARD", "NOTIFY_PARTIAL", "NOTIFY_WITHOUT_PAYLOAD", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraIncompleteSessionPolicy extends Enum<DoraIncompleteSessionPolicy> {
    public static final DoraIncompleteSessionPolicy DISCARD = null;
    public static final DoraIncompleteSessionPolicy NOTIFY_PARTIAL = null;
    public static final DoraIncompleteSessionPolicy NOTIFY_WITHOUT_PAYLOAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraIncompleteSessionPolicy[] f335782a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f335783b = null;

    public static EnumEntries<DoraIncompleteSessionPolicy> getEntries() {
        return f335783b;
    }

    static {
        DoraIncompleteSessionPolicy r100 = new DoraIncompleteSessionPolicy("DISCARD", 0);
        DISCARD = r100;
        DoraIncompleteSessionPolicy r101 = new DoraIncompleteSessionPolicy("NOTIFY_PARTIAL", 1);
        NOTIFY_PARTIAL = r101;
        DoraIncompleteSessionPolicy r102 = new DoraIncompleteSessionPolicy("NOTIFY_WITHOUT_PAYLOAD", 2);
        NOTIFY_WITHOUT_PAYLOAD = r102;
        DoraIncompleteSessionPolicy[] r103 = {r100, r101, r102};
        f335782a = r103;
        f335783b = EnumEntriesKt.enumEntries(r103);
    }

    public static DoraIncompleteSessionPolicy[] values() {
        return (DoraIncompleteSessionPolicy[]) f335782a.clone();
    }

    public static DoraIncompleteSessionPolicy valueOf(String r100) {
        return (DoraIncompleteSessionPolicy) r27.a.a(DoraIncompleteSessionPolicy.class, r100);
    }

    public DoraIncompleteSessionPolicy(String r100, int r101) {
        super(r100, r101);
    }
}
