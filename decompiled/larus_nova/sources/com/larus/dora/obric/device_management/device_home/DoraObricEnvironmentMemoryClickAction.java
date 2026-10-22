package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricEnvironmentMemoryClickAction;", "", "<init>", "(Ljava/lang/String;I)V", "NO_OP", "SHOW_UNAVAILABLE", "REQUEST_AUTHORIZATION", "ENABLE_SWITCH", "ENABLE_SWITCH_WITH_OVERRIDE", "DISABLE_SWITCH", "ACTIVATE_OVERRIDE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricEnvironmentMemoryClickAction extends Enum<DoraObricEnvironmentMemoryClickAction> {
    public static final DoraObricEnvironmentMemoryClickAction ACTIVATE_OVERRIDE = null;
    public static final DoraObricEnvironmentMemoryClickAction DISABLE_SWITCH = null;
    public static final DoraObricEnvironmentMemoryClickAction ENABLE_SWITCH = null;
    public static final DoraObricEnvironmentMemoryClickAction ENABLE_SWITCH_WITH_OVERRIDE = null;
    public static final DoraObricEnvironmentMemoryClickAction NO_OP = null;
    public static final DoraObricEnvironmentMemoryClickAction REQUEST_AUTHORIZATION = null;
    public static final DoraObricEnvironmentMemoryClickAction SHOW_UNAVAILABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraObricEnvironmentMemoryClickAction[] f339139a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f339140b = null;

    public static EnumEntries<DoraObricEnvironmentMemoryClickAction> getEntries() {
        return f339140b;
    }

    static {
        DoraObricEnvironmentMemoryClickAction r100 = new DoraObricEnvironmentMemoryClickAction("NO_OP", 0);
        NO_OP = r100;
        DoraObricEnvironmentMemoryClickAction r101 = new DoraObricEnvironmentMemoryClickAction("SHOW_UNAVAILABLE", 1);
        SHOW_UNAVAILABLE = r101;
        DoraObricEnvironmentMemoryClickAction r102 = new DoraObricEnvironmentMemoryClickAction("REQUEST_AUTHORIZATION", 2);
        REQUEST_AUTHORIZATION = r102;
        DoraObricEnvironmentMemoryClickAction r103 = new DoraObricEnvironmentMemoryClickAction("ENABLE_SWITCH", 3);
        ENABLE_SWITCH = r103;
        DoraObricEnvironmentMemoryClickAction r104 = new DoraObricEnvironmentMemoryClickAction("ENABLE_SWITCH_WITH_OVERRIDE", 4);
        ENABLE_SWITCH_WITH_OVERRIDE = r104;
        DoraObricEnvironmentMemoryClickAction r105 = new DoraObricEnvironmentMemoryClickAction("DISABLE_SWITCH", 5);
        DISABLE_SWITCH = r105;
        DoraObricEnvironmentMemoryClickAction r110 = new DoraObricEnvironmentMemoryClickAction("ACTIVATE_OVERRIDE", 6);
        ACTIVATE_OVERRIDE = r110;
        DoraObricEnvironmentMemoryClickAction[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f339139a = r111;
        f339140b = EnumEntriesKt.enumEntries(r111);
    }

    public static DoraObricEnvironmentMemoryClickAction[] values() {
        return (DoraObricEnvironmentMemoryClickAction[]) f339139a.clone();
    }

    public static DoraObricEnvironmentMemoryClickAction valueOf(String r100) {
        return (DoraObricEnvironmentMemoryClickAction) r27.a.a(DoraObricEnvironmentMemoryClickAction.class, r100);
    }

    public DoraObricEnvironmentMemoryClickAction(String r100, int r101) {
        super(r100, r101);
    }
}
