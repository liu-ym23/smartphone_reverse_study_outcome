package com.larus.setting.api.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/setting/api/data/NotifySettingsItemId;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "HUMAN_CHAT", "SCHEDULED_JOB", "ORDER_MESSAGE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NotifySettingsItemId extends Enum<NotifySettingsItemId> {
    public static final NotifySettingsItemId HUMAN_CHAT = null;
    public static final NotifySettingsItemId ORDER_MESSAGE = null;
    public static final NotifySettingsItemId SCHEDULED_JOB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NotifySettingsItemId[] f367893a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f367894b = null;
    private final String value;

    public static EnumEntries<NotifySettingsItemId> getEntries() {
        return f367894b;
    }

    static {
        NotifySettingsItemId r100 = new NotifySettingsItemId("HUMAN_CHAT", 0, "human_chat");
        HUMAN_CHAT = r100;
        NotifySettingsItemId r101 = new NotifySettingsItemId("SCHEDULED_JOB", 1, "scheduled_job");
        SCHEDULED_JOB = r101;
        NotifySettingsItemId r102 = new NotifySettingsItemId("ORDER_MESSAGE", 2, "order_message");
        ORDER_MESSAGE = r102;
        NotifySettingsItemId[] r103 = {r100, r101, r102};
        f367893a = r103;
        f367894b = EnumEntriesKt.enumEntries(r103);
    }

    public static NotifySettingsItemId[] values() {
        return (NotifySettingsItemId[]) f367893a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static NotifySettingsItemId valueOf(String r100) {
        return (NotifySettingsItemId) a.a(NotifySettingsItemId.class, r100);
    }

    public NotifySettingsItemId(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
