package com.larus.receive.contract;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/receive/contract/ReceiveTextDelivery;", "", "<init>", "(Ljava/lang/String;I)V", "AUTO_SEND", "FILL_INPUT", "receive_contract_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReceiveTextDelivery extends Enum<ReceiveTextDelivery> {
    public static final ReceiveTextDelivery AUTO_SEND = null;
    public static final ReceiveTextDelivery FILL_INPUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReceiveTextDelivery[] f367366a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f367367b = null;

    public static EnumEntries<ReceiveTextDelivery> getEntries() {
        return f367367b;
    }

    static {
        ReceiveTextDelivery r100 = new ReceiveTextDelivery("AUTO_SEND", 0);
        AUTO_SEND = r100;
        ReceiveTextDelivery r101 = new ReceiveTextDelivery("FILL_INPUT", 1);
        FILL_INPUT = r101;
        ReceiveTextDelivery[] r102 = {r100, r101};
        f367366a = r102;
        f367367b = EnumEntriesKt.enumEntries(r102);
    }

    public static ReceiveTextDelivery[] values() {
        return (ReceiveTextDelivery[]) f367366a.clone();
    }

    public static ReceiveTextDelivery valueOf(String r100) {
        return (ReceiveTextDelivery) r27.a.a(ReceiveTextDelivery.class, r100);
    }

    public ReceiveTextDelivery(String r100, int r101) {
        super(r100, r101);
    }
}
