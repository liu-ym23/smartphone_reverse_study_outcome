package com.lark.kmp.basic;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/lark/kmp/basic/ActionType;", "", "<init>", "(Ljava/lang/String;I)V", "Offline", "Online", "BringOnline", "BringForeground", "Clean", "user-state-manager_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionType extends Enum<ActionType> {
    public static final ActionType BringForeground = null;
    public static final ActionType BringOnline = null;
    public static final ActionType Clean = null;
    public static final ActionType Offline = null;
    public static final ActionType Online = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActionType[] f278569a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f278570b = null;

    public static EnumEntries<ActionType> getEntries() {
        return f278570b;
    }

    static {
        ActionType r100 = new ActionType("Offline", 0);
        Offline = r100;
        ActionType r101 = new ActionType("Online", 1);
        Online = r101;
        ActionType r102 = new ActionType("BringOnline", 2);
        BringOnline = r102;
        ActionType r103 = new ActionType("BringForeground", 3);
        BringForeground = r103;
        ActionType r104 = new ActionType("Clean", 4);
        Clean = r104;
        ActionType[] r105 = {r100, r101, r102, r103, r104};
        f278569a = r105;
        f278570b = EnumEntriesKt.enumEntries(r105);
    }

    public static ActionType[] values() {
        return (ActionType[]) f278569a.clone();
    }

    public static ActionType valueOf(String r100) {
        return (ActionType) a.a(ActionType.class, r100);
    }

    public ActionType(String r100, int r101) {
        super(r100, r101);
    }
}
