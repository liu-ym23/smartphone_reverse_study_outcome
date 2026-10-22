package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricEnvironmentMemoryUiMessage;", "", "<init>", "(Ljava/lang/String;I)V", "ENABLED", "TEMPORARY_OVERRIDE", "UNAVAILABLE", "NETWORK_ERROR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricEnvironmentMemoryUiMessage extends Enum<DoraObricEnvironmentMemoryUiMessage> {
    public static final DoraObricEnvironmentMemoryUiMessage ENABLED = null;
    public static final DoraObricEnvironmentMemoryUiMessage NETWORK_ERROR = null;
    public static final DoraObricEnvironmentMemoryUiMessage TEMPORARY_OVERRIDE = null;
    public static final DoraObricEnvironmentMemoryUiMessage UNAVAILABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraObricEnvironmentMemoryUiMessage[] f339151a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f339152b = null;

    public static EnumEntries<DoraObricEnvironmentMemoryUiMessage> getEntries() {
        return f339152b;
    }

    static {
        DoraObricEnvironmentMemoryUiMessage r100 = new DoraObricEnvironmentMemoryUiMessage("ENABLED", 0);
        ENABLED = r100;
        DoraObricEnvironmentMemoryUiMessage r101 = new DoraObricEnvironmentMemoryUiMessage("TEMPORARY_OVERRIDE", 1);
        TEMPORARY_OVERRIDE = r101;
        DoraObricEnvironmentMemoryUiMessage r102 = new DoraObricEnvironmentMemoryUiMessage("UNAVAILABLE", 2);
        UNAVAILABLE = r102;
        DoraObricEnvironmentMemoryUiMessage r103 = new DoraObricEnvironmentMemoryUiMessage("NETWORK_ERROR", 3);
        NETWORK_ERROR = r103;
        DoraObricEnvironmentMemoryUiMessage[] r104 = {r100, r101, r102, r103};
        f339151a = r104;
        f339152b = EnumEntriesKt.enumEntries(r104);
    }

    public static DoraObricEnvironmentMemoryUiMessage[] values() {
        return (DoraObricEnvironmentMemoryUiMessage[]) f339151a.clone();
    }

    public static DoraObricEnvironmentMemoryUiMessage valueOf(String r100) {
        return (DoraObricEnvironmentMemoryUiMessage) r27.a.a(DoraObricEnvironmentMemoryUiMessage.class, r100);
    }

    public DoraObricEnvironmentMemoryUiMessage(String r100, int r101) {
        super(r100, r101);
    }
}
