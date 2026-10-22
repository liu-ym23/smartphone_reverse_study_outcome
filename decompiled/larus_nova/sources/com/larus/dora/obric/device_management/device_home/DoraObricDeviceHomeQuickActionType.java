package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeQuickActionType;", "", "configKey", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getConfigKey", "()Ljava/lang/String;", "DOUBAO_ASSISTANT", "NOTIFICATION_BROADCAST", "QUICK_NOTE", "SIMULTANEOUS_INTERPRET", "RECORD_MINUTES", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricDeviceHomeQuickActionType extends Enum<DoraObricDeviceHomeQuickActionType> {
    public static final DoraObricDeviceHomeQuickActionType DOUBAO_ASSISTANT = null;
    public static final DoraObricDeviceHomeQuickActionType NOTIFICATION_BROADCAST = null;
    public static final DoraObricDeviceHomeQuickActionType QUICK_NOTE = null;
    public static final DoraObricDeviceHomeQuickActionType RECORD_MINUTES = null;
    public static final DoraObricDeviceHomeQuickActionType SIMULTANEOUS_INTERPRET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraObricDeviceHomeQuickActionType[] f339078a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f339079b = null;
    private final String configKey;

    public static EnumEntries<DoraObricDeviceHomeQuickActionType> getEntries() {
        return f339079b;
    }

    static {
        DoraObricDeviceHomeQuickActionType r100 = new DoraObricDeviceHomeQuickActionType("DOUBAO_ASSISTANT", 0, "doubao_assistant");
        DOUBAO_ASSISTANT = r100;
        DoraObricDeviceHomeQuickActionType r101 = new DoraObricDeviceHomeQuickActionType("NOTIFICATION_BROADCAST", 1, "notification_broadcast");
        NOTIFICATION_BROADCAST = r101;
        DoraObricDeviceHomeQuickActionType r102 = new DoraObricDeviceHomeQuickActionType("QUICK_NOTE", 2, "quick_note");
        QUICK_NOTE = r102;
        DoraObricDeviceHomeQuickActionType r103 = new DoraObricDeviceHomeQuickActionType("SIMULTANEOUS_INTERPRET", 3, "simultaneous_interpret");
        SIMULTANEOUS_INTERPRET = r103;
        DoraObricDeviceHomeQuickActionType r104 = new DoraObricDeviceHomeQuickActionType("RECORD_MINUTES", 4, "record_minutes");
        RECORD_MINUTES = r104;
        DoraObricDeviceHomeQuickActionType[] r105 = {r100, r101, r102, r103, r104};
        f339078a = r105;
        f339079b = EnumEntriesKt.enumEntries(r105);
    }

    public static DoraObricDeviceHomeQuickActionType[] values() {
        return (DoraObricDeviceHomeQuickActionType[]) f339078a.clone();
    }

    public final String getConfigKey() {
        return this.configKey;
    }

    public static DoraObricDeviceHomeQuickActionType valueOf(String r100) {
        return (DoraObricDeviceHomeQuickActionType) r27.a.a(DoraObricDeviceHomeQuickActionType.class, r100);
    }

    public DoraObricDeviceHomeQuickActionType(String r100, int r101, String r102) {
        super(r100, r101);
        this.configKey = r102;
    }
}
