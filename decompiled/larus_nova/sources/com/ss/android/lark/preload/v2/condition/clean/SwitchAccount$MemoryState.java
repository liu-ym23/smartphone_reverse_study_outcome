package com.ss.android.lark.preload.v2.condition.clean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/preload/v2/condition/clean/SwitchAccount$MemoryState;", "", "<init>", "(Ljava/lang/String;I)V", "CRITICAL", "UNKNOWN", "preload-manager_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SwitchAccount$MemoryState extends Enum<SwitchAccount$MemoryState> {
    public static final SwitchAccount$MemoryState CRITICAL = null;
    public static final SwitchAccount$MemoryState UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SwitchAccount$MemoryState[] f438817a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f438818b = null;

    public static EnumEntries<SwitchAccount$MemoryState> getEntries() {
        return f438818b;
    }

    static {
        SwitchAccount$MemoryState r100 = new SwitchAccount$MemoryState("CRITICAL", 0);
        CRITICAL = r100;
        SwitchAccount$MemoryState r101 = new SwitchAccount$MemoryState("UNKNOWN", 1);
        UNKNOWN = r101;
        SwitchAccount$MemoryState[] r102 = {r100, r101};
        f438817a = r102;
        f438818b = EnumEntriesKt.enumEntries(r102);
    }

    public static SwitchAccount$MemoryState[] values() {
        return (SwitchAccount$MemoryState[]) f438817a.clone();
    }

    public static SwitchAccount$MemoryState valueOf(String r100) {
        return (SwitchAccount$MemoryState) a.a(SwitchAccount$MemoryState.class, r100);
    }

    public SwitchAccount$MemoryState(String r100, int r101) {
        super(r100, r101);
    }
}
