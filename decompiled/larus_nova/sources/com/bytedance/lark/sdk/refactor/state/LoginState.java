package com.bytedance.lark.sdk.refactor.state;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/lark/sdk/refactor/state/LoginState;", "", "<init>", "(Ljava/lang/String;I)V", "FOREGROUND", "BACKGROUND", "OFFLINE", "rust-jvm_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LoginState extends Enum<LoginState> {
    public static final LoginState BACKGROUND = null;
    public static final LoginState FOREGROUND = null;
    public static final LoginState OFFLINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoginState[] f254302a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f254303b = null;

    public static EnumEntries<LoginState> getEntries() {
        return f254303b;
    }

    static {
        LoginState r100 = new LoginState("FOREGROUND", 0);
        FOREGROUND = r100;
        LoginState r101 = new LoginState("BACKGROUND", 1);
        BACKGROUND = r101;
        LoginState r102 = new LoginState("OFFLINE", 2);
        OFFLINE = r102;
        LoginState[] r103 = {r100, r101, r102};
        f254302a = r103;
        f254303b = EnumEntriesKt.enumEntries(r103);
    }

    public static LoginState[] values() {
        return (LoginState[]) f254302a.clone();
    }

    public static LoginState valueOf(String r100) {
        return (LoginState) r27.a.a(LoginState.class, r100);
    }

    public LoginState(String r100, int r101) {
        super(r100, r101);
    }
}
