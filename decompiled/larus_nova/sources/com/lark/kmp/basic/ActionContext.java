package com.lark.kmp.basic;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/lark/kmp/basic/ActionContext;", "", "<init>", "(Ljava/lang/String;I)V", "LoginContext", "LogoutContext", "SwitchContext", "InternalContext", "user-state-manager_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionContext extends Enum<ActionContext> {
    public static final ActionContext InternalContext = null;
    public static final ActionContext LoginContext = null;
    public static final ActionContext LogoutContext = null;
    public static final ActionContext SwitchContext = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActionContext[] f278567a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f278568b = null;

    public static EnumEntries<ActionContext> getEntries() {
        return f278568b;
    }

    static {
        ActionContext r100 = new ActionContext("LoginContext", 0);
        LoginContext = r100;
        ActionContext r101 = new ActionContext("LogoutContext", 1);
        LogoutContext = r101;
        ActionContext r102 = new ActionContext("SwitchContext", 2);
        SwitchContext = r102;
        ActionContext r103 = new ActionContext("InternalContext", 3);
        InternalContext = r103;
        ActionContext[] r104 = {r100, r101, r102, r103};
        f278567a = r104;
        f278568b = EnumEntriesKt.enumEntries(r104);
    }

    public static ActionContext[] values() {
        return (ActionContext[]) f278567a.clone();
    }

    public static ActionContext valueOf(String r100) {
        return (ActionContext) a.a(ActionContext.class, r100);
    }

    public ActionContext(String r100, int r101) {
        super(r100, r101);
    }
}
