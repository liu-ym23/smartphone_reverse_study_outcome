package com.larus.dora.impl.device.ota;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/larus/dora/impl/device/ota/EventTypeOTAErrorCode;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "SUCCESS", "PARAMETERS", "VERSION_FORMAT", "VERSION_EXISTED", "STORAGE_FULL", "USER_CANCEL", "PACKAGE_URL", "DOWNLOAD_FAILED", "VERIFICATION_FAILED", "PACKAGE_CONTENT", "INSTALL_FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EventTypeOTAErrorCode extends Enum<EventTypeOTAErrorCode> {
    public static final EventTypeOTAErrorCode DOWNLOAD_FAILED = null;
    public static final EventTypeOTAErrorCode INSTALL_FAILED = null;
    public static final EventTypeOTAErrorCode PACKAGE_CONTENT = null;
    public static final EventTypeOTAErrorCode PACKAGE_URL = null;
    public static final EventTypeOTAErrorCode PARAMETERS = null;
    public static final EventTypeOTAErrorCode STORAGE_FULL = null;
    public static final EventTypeOTAErrorCode SUCCESS = null;
    public static final EventTypeOTAErrorCode USER_CANCEL = null;
    public static final EventTypeOTAErrorCode VERIFICATION_FAILED = null;
    public static final EventTypeOTAErrorCode VERSION_EXISTED = null;
    public static final EventTypeOTAErrorCode VERSION_FORMAT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EventTypeOTAErrorCode[] f334182a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f334183b = null;
    private final int code;

    public static EnumEntries<EventTypeOTAErrorCode> getEntries() {
        return f334183b;
    }

    static {
        EventTypeOTAErrorCode r100 = new EventTypeOTAErrorCode("SUCCESS", 0, 0);
        SUCCESS = r100;
        EventTypeOTAErrorCode r101 = new EventTypeOTAErrorCode("PARAMETERS", 1, 1);
        PARAMETERS = r101;
        EventTypeOTAErrorCode r102 = new EventTypeOTAErrorCode("VERSION_FORMAT", 2, 2);
        VERSION_FORMAT = r102;
        EventTypeOTAErrorCode r103 = new EventTypeOTAErrorCode("VERSION_EXISTED", 3, 3);
        VERSION_EXISTED = r103;
        EventTypeOTAErrorCode r104 = new EventTypeOTAErrorCode("STORAGE_FULL", 4, 4);
        STORAGE_FULL = r104;
        EventTypeOTAErrorCode r105 = new EventTypeOTAErrorCode("USER_CANCEL", 5, 5);
        USER_CANCEL = r105;
        EventTypeOTAErrorCode r110 = new EventTypeOTAErrorCode("PACKAGE_URL", 6, 6);
        PACKAGE_URL = r110;
        EventTypeOTAErrorCode r111 = new EventTypeOTAErrorCode("DOWNLOAD_FAILED", 7, 7);
        DOWNLOAD_FAILED = r111;
        EventTypeOTAErrorCode r112 = new EventTypeOTAErrorCode("VERIFICATION_FAILED", 8, 8);
        VERIFICATION_FAILED = r112;
        EventTypeOTAErrorCode r113 = new EventTypeOTAErrorCode("PACKAGE_CONTENT", 9, 9);
        PACKAGE_CONTENT = r113;
        EventTypeOTAErrorCode r114 = new EventTypeOTAErrorCode("INSTALL_FAILED", 10, 10);
        INSTALL_FAILED = r114;
        EventTypeOTAErrorCode[] r115 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        f334182a = r115;
        f334183b = EnumEntriesKt.enumEntries(r115);
    }

    public static EventTypeOTAErrorCode[] values() {
        return (EventTypeOTAErrorCode[]) f334182a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public static EventTypeOTAErrorCode valueOf(String r100) {
        return (EventTypeOTAErrorCode) r27.a.a(EventTypeOTAErrorCode.class, r100);
    }

    public EventTypeOTAErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
