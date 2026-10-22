package com.larus.dora.impl.device.ota;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/dora/impl/device/ota/EventTypeOTAStatus;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "FAIL", "START_DOWNLOAD", "DOWNLOAD_COMPLETED", "VERIFIED", "ENVIRONMENT_READY", "START_INSTALL", "INSTALL_COMPLETED", "DELETE_PACKAGE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EventTypeOTAStatus extends Enum<EventTypeOTAStatus> {
    public static final EventTypeOTAStatus DELETE_PACKAGE = null;
    public static final EventTypeOTAStatus DOWNLOAD_COMPLETED = null;
    public static final EventTypeOTAStatus ENVIRONMENT_READY = null;
    public static final EventTypeOTAStatus FAIL = null;
    public static final EventTypeOTAStatus INSTALL_COMPLETED = null;
    public static final EventTypeOTAStatus START_DOWNLOAD = null;
    public static final EventTypeOTAStatus START_INSTALL = null;
    public static final EventTypeOTAStatus VERIFIED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EventTypeOTAStatus[] f334184a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f334185b = null;
    private final int code;

    public static EnumEntries<EventTypeOTAStatus> getEntries() {
        return f334185b;
    }

    static {
        EventTypeOTAStatus r100 = new EventTypeOTAStatus("FAIL", 0, 0);
        FAIL = r100;
        EventTypeOTAStatus r101 = new EventTypeOTAStatus("START_DOWNLOAD", 1, 1);
        START_DOWNLOAD = r101;
        EventTypeOTAStatus r102 = new EventTypeOTAStatus("DOWNLOAD_COMPLETED", 2, 2);
        DOWNLOAD_COMPLETED = r102;
        EventTypeOTAStatus r103 = new EventTypeOTAStatus("VERIFIED", 3, 3);
        VERIFIED = r103;
        EventTypeOTAStatus r104 = new EventTypeOTAStatus("ENVIRONMENT_READY", 4, 4);
        ENVIRONMENT_READY = r104;
        EventTypeOTAStatus r105 = new EventTypeOTAStatus("START_INSTALL", 5, 5);
        START_INSTALL = r105;
        EventTypeOTAStatus r110 = new EventTypeOTAStatus("INSTALL_COMPLETED", 6, 6);
        INSTALL_COMPLETED = r110;
        EventTypeOTAStatus r111 = new EventTypeOTAStatus("DELETE_PACKAGE", 7, 7);
        DELETE_PACKAGE = r111;
        EventTypeOTAStatus[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f334184a = r112;
        f334185b = EnumEntriesKt.enumEntries(r112);
    }

    public static EventTypeOTAStatus[] values() {
        return (EventTypeOTAStatus[]) f334184a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public static EventTypeOTAStatus valueOf(String r100) {
        return (EventTypeOTAStatus) r27.a.a(EventTypeOTAStatus.class, r100);
    }

    public EventTypeOTAStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
