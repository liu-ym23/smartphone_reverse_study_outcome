package com.larus.im.internal.tracking;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/im/internal/tracking/ReceiveMessageFrom;", "", "<init>", "(Ljava/lang/String;I)V", "FRONTIER", "FIRST_PACKAGE_TIME_OUT", "CLIENT_PULL", AccountType.OTHERS, "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReceiveMessageFrom extends Enum<ReceiveMessageFrom> {
    public static final ReceiveMessageFrom CLIENT_PULL = null;
    public static final ReceiveMessageFrom FIRST_PACKAGE_TIME_OUT = null;
    public static final ReceiveMessageFrom FRONTIER = null;
    public static final ReceiveMessageFrom OTHERS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReceiveMessageFrom[] f350223a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350224b = null;

    public static EnumEntries<ReceiveMessageFrom> getEntries() {
        return f350224b;
    }

    static {
        ReceiveMessageFrom r100 = new ReceiveMessageFrom("FRONTIER", 0);
        FRONTIER = r100;
        ReceiveMessageFrom r101 = new ReceiveMessageFrom("FIRST_PACKAGE_TIME_OUT", 1);
        FIRST_PACKAGE_TIME_OUT = r101;
        ReceiveMessageFrom r102 = new ReceiveMessageFrom("CLIENT_PULL", 2);
        CLIENT_PULL = r102;
        ReceiveMessageFrom r103 = new ReceiveMessageFrom(AccountType.OTHERS, 3);
        OTHERS = r103;
        ReceiveMessageFrom[] r104 = {r100, r101, r102, r103};
        f350223a = r104;
        f350224b = EnumEntriesKt.enumEntries(r104);
    }

    public static ReceiveMessageFrom[] values() {
        return (ReceiveMessageFrom[]) f350223a.clone();
    }

    public static ReceiveMessageFrom valueOf(String r100) {
        return (ReceiveMessageFrom) r27.a.a(ReceiveMessageFrom.class, r100);
    }

    public ReceiveMessageFrom(String r100, int r101) {
        super(r100, r101);
    }
}
