package com.bytedance.lark.sdk.refactor.state;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/lark/sdk/refactor/state/StateUpdateType;", "", "<init>", "(Ljava/lang/String;I)V", "INIT_SDK", "MAKE_ONLINE", "MAKE_OFFLINE", "rust-jvm_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum StateUpdateType extends Enum<StateUpdateType> {
    public static final StateUpdateType INIT_SDK = null;
    public static final StateUpdateType MAKE_OFFLINE = null;
    public static final StateUpdateType MAKE_ONLINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StateUpdateType[] f254306a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f254307b = null;

    public static EnumEntries<StateUpdateType> getEntries() {
        return f254307b;
    }

    static {
        StateUpdateType r100 = new StateUpdateType("INIT_SDK", 0);
        INIT_SDK = r100;
        StateUpdateType r101 = new StateUpdateType("MAKE_ONLINE", 1);
        MAKE_ONLINE = r101;
        StateUpdateType r102 = new StateUpdateType("MAKE_OFFLINE", 2);
        MAKE_OFFLINE = r102;
        StateUpdateType[] r103 = {r100, r101, r102};
        f254306a = r103;
        f254307b = EnumEntriesKt.enumEntries(r103);
    }

    public static StateUpdateType[] values() {
        return (StateUpdateType[]) f254306a.clone();
    }

    public static StateUpdateType valueOf(String r100) {
        return (StateUpdateType) r27.a.a(StateUpdateType.class, r100);
    }

    public StateUpdateType(String r100, int r101) {
        super(r100, r101);
    }
}
