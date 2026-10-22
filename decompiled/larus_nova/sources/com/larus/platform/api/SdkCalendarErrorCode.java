package com.larus.platform.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/platform/api/SdkCalendarErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "ArgumentError", "NoPermission", "AlreadyExists", "NoAccount", "Unknown", "Success", "NotFound", "NotGetId", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SdkCalendarErrorCode extends Enum<SdkCalendarErrorCode> {
    public static final SdkCalendarErrorCode AlreadyExists = null;
    public static final SdkCalendarErrorCode ArgumentError = null;
    public static final SdkCalendarErrorCode NoAccount = null;
    public static final SdkCalendarErrorCode NoPermission = null;
    public static final SdkCalendarErrorCode NotFound = null;
    public static final SdkCalendarErrorCode NotGetId = null;
    public static final SdkCalendarErrorCode Success = null;
    public static final SdkCalendarErrorCode Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SdkCalendarErrorCode[] f364847a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364848b = null;

    public static EnumEntries<SdkCalendarErrorCode> getEntries() {
        return f364848b;
    }

    static {
        SdkCalendarErrorCode r100 = new SdkCalendarErrorCode("ArgumentError", 0);
        ArgumentError = r100;
        SdkCalendarErrorCode r101 = new SdkCalendarErrorCode("NoPermission", 1);
        NoPermission = r101;
        SdkCalendarErrorCode r102 = new SdkCalendarErrorCode("AlreadyExists", 2);
        AlreadyExists = r102;
        SdkCalendarErrorCode r103 = new SdkCalendarErrorCode("NoAccount", 3);
        NoAccount = r103;
        SdkCalendarErrorCode r104 = new SdkCalendarErrorCode("Unknown", 4);
        Unknown = r104;
        SdkCalendarErrorCode r105 = new SdkCalendarErrorCode("Success", 5);
        Success = r105;
        SdkCalendarErrorCode r110 = new SdkCalendarErrorCode("NotFound", 6);
        NotFound = r110;
        SdkCalendarErrorCode r111 = new SdkCalendarErrorCode("NotGetId", 7);
        NotGetId = r111;
        SdkCalendarErrorCode[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f364847a = r112;
        f364848b = EnumEntriesKt.enumEntries(r112);
    }

    public static SdkCalendarErrorCode[] values() {
        return (SdkCalendarErrorCode[]) f364847a.clone();
    }

    public static SdkCalendarErrorCode valueOf(String r100) {
        return (SdkCalendarErrorCode) r27.a.a(SdkCalendarErrorCode.class, r100);
    }

    public SdkCalendarErrorCode(String r100, int r101) {
        super(r100, r101);
    }
}
