package com.larus.dora.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/api/DoraResourceState;", "", "<init>", "(Ljava/lang/String;I)V", "DISABLED", "PENDING", "READY", "FAILED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraResourceState extends Enum<DoraResourceState> {
    public static final DoraResourceState DISABLED = null;
    public static final DoraResourceState FAILED = null;
    public static final DoraResourceState PENDING = null;
    public static final DoraResourceState READY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraResourceState[] f331712a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f331713b = null;

    public static EnumEntries<DoraResourceState> getEntries() {
        return f331713b;
    }

    static {
        DoraResourceState r100 = new DoraResourceState("DISABLED", 0);
        DISABLED = r100;
        DoraResourceState r101 = new DoraResourceState("PENDING", 1);
        PENDING = r101;
        DoraResourceState r102 = new DoraResourceState("READY", 2);
        READY = r102;
        DoraResourceState r103 = new DoraResourceState("FAILED", 3);
        FAILED = r103;
        DoraResourceState[] r104 = {r100, r101, r102, r103};
        f331712a = r104;
        f331713b = EnumEntriesKt.enumEntries(r104);
    }

    public static DoraResourceState[] values() {
        return (DoraResourceState[]) f331712a.clone();
    }

    public static DoraResourceState valueOf(String r100) {
        return (DoraResourceState) a.a(DoraResourceState.class, r100);
    }

    public DoraResourceState(String r100, int r101) {
        super(r100, r101);
    }
}
