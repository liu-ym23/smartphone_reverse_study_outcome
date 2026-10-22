package com.larus.setting.api.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/setting/api/data/NotifySettingsSectionId;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "APP_CLOSED", "APP_OPEN", "NOTIFY_TYPE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NotifySettingsSectionId extends Enum<NotifySettingsSectionId> {
    public static final NotifySettingsSectionId APP_CLOSED = null;
    public static final NotifySettingsSectionId APP_OPEN = null;
    public static final NotifySettingsSectionId NOTIFY_TYPE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NotifySettingsSectionId[] f367895a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f367896b = null;
    private final String value;

    public static EnumEntries<NotifySettingsSectionId> getEntries() {
        return f367896b;
    }

    static {
        NotifySettingsSectionId r100 = new NotifySettingsSectionId("APP_CLOSED", 0, "app_closed");
        APP_CLOSED = r100;
        NotifySettingsSectionId r101 = new NotifySettingsSectionId("APP_OPEN", 1, "app_open");
        APP_OPEN = r101;
        NotifySettingsSectionId r102 = new NotifySettingsSectionId("NOTIFY_TYPE", 2, "notify_type");
        NOTIFY_TYPE = r102;
        NotifySettingsSectionId[] r103 = {r100, r101, r102};
        f367895a = r103;
        f367896b = EnumEntriesKt.enumEntries(r103);
    }

    public static NotifySettingsSectionId[] values() {
        return (NotifySettingsSectionId[]) f367895a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static NotifySettingsSectionId valueOf(String r100) {
        return (NotifySettingsSectionId) a.a(NotifySettingsSectionId.class, r100);
    }

    public NotifySettingsSectionId(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
