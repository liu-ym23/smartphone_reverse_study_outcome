package com.ss.android.lark.passportc.internal;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/passportc/internal/StateTransferType;", "", "<init>", "(Ljava/lang/String;I)V", "Online", "Swap", "Offline", "Clean", "UpdateToDate", "Illegal", "passport-container-manager_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum StateTransferType extends Enum<StateTransferType> {
    public static final StateTransferType Clean = null;
    public static final StateTransferType Illegal = null;
    public static final StateTransferType Offline = null;
    public static final StateTransferType Online = null;
    public static final StateTransferType Swap = null;
    public static final StateTransferType UpdateToDate = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StateTransferType[] f438398a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f438399b = null;

    public static EnumEntries<StateTransferType> getEntries() {
        return f438399b;
    }

    static {
        StateTransferType r100 = new StateTransferType("Online", 0);
        Online = r100;
        StateTransferType r101 = new StateTransferType("Swap", 1);
        Swap = r101;
        StateTransferType r102 = new StateTransferType("Offline", 2);
        Offline = r102;
        StateTransferType r103 = new StateTransferType("Clean", 3);
        Clean = r103;
        StateTransferType r104 = new StateTransferType("UpdateToDate", 4);
        UpdateToDate = r104;
        StateTransferType r105 = new StateTransferType("Illegal", 5);
        Illegal = r105;
        StateTransferType[] r110 = {r100, r101, r102, r103, r104, r105};
        f438398a = r110;
        f438399b = EnumEntriesKt.enumEntries(r110);
    }

    public static StateTransferType[] values() {
        return (StateTransferType[]) f438398a.clone();
    }

    public static StateTransferType valueOf(String r100) {
        return (StateTransferType) r27.a.a(StateTransferType.class, r100);
    }

    public StateTransferType(String r100, int r101) {
        super(r100, r101);
    }
}
