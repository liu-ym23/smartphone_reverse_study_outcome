package com.bytedance.lark.sdk.refactor.state;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/lark/sdk/refactor/state/UpdateUserLoginStateType;", "", "<init>", "(Ljava/lang/String;I)V", "FOREGROUND_ONLINE", "BACKGROUND_ONLINE", "FOREGROUND_OFFLINE", "BACKGROUND_OFFLINE", "SWITCH_FOREGROUND_ONLINE", "SWITCH_BACKGROUND_ONLINE", "rust-jvm_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UpdateUserLoginStateType extends Enum<UpdateUserLoginStateType> {
    public static final UpdateUserLoginStateType BACKGROUND_OFFLINE = null;
    public static final UpdateUserLoginStateType BACKGROUND_ONLINE = null;
    public static final UpdateUserLoginStateType FOREGROUND_OFFLINE = null;
    public static final UpdateUserLoginStateType FOREGROUND_ONLINE = null;
    public static final UpdateUserLoginStateType SWITCH_BACKGROUND_ONLINE = null;
    public static final UpdateUserLoginStateType SWITCH_FOREGROUND_ONLINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UpdateUserLoginStateType[] f254308a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f254309b = null;

    public static EnumEntries<UpdateUserLoginStateType> getEntries() {
        return f254309b;
    }

    static {
        UpdateUserLoginStateType r100 = new UpdateUserLoginStateType("FOREGROUND_ONLINE", 0);
        FOREGROUND_ONLINE = r100;
        UpdateUserLoginStateType r101 = new UpdateUserLoginStateType("BACKGROUND_ONLINE", 1);
        BACKGROUND_ONLINE = r101;
        UpdateUserLoginStateType r102 = new UpdateUserLoginStateType("FOREGROUND_OFFLINE", 2);
        FOREGROUND_OFFLINE = r102;
        UpdateUserLoginStateType r103 = new UpdateUserLoginStateType("BACKGROUND_OFFLINE", 3);
        BACKGROUND_OFFLINE = r103;
        UpdateUserLoginStateType r104 = new UpdateUserLoginStateType("SWITCH_FOREGROUND_ONLINE", 4);
        SWITCH_FOREGROUND_ONLINE = r104;
        UpdateUserLoginStateType r105 = new UpdateUserLoginStateType("SWITCH_BACKGROUND_ONLINE", 5);
        SWITCH_BACKGROUND_ONLINE = r105;
        UpdateUserLoginStateType[] r110 = {r100, r101, r102, r103, r104, r105};
        f254308a = r110;
        f254309b = EnumEntriesKt.enumEntries(r110);
    }

    public static UpdateUserLoginStateType[] values() {
        return (UpdateUserLoginStateType[]) f254308a.clone();
    }

    public static UpdateUserLoginStateType valueOf(String r100) {
        return (UpdateUserLoginStateType) r27.a.a(UpdateUserLoginStateType.class, r100);
    }

    public UpdateUserLoginStateType(String r100, int r101) {
        super(r100, r101);
    }
}
