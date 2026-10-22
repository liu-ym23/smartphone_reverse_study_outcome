package com.ss.android.lark.auditsdk.v2.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/auditsdk/v2/utils/DownloadAuthorizationEventType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE_DOWNLOAD", "VIDEO_DOWNLOAD", "FILE_DOWNLOAD", "FILE_OPEN_IN_3RD_APP", "audit-wrapper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DownloadAuthorizationEventType extends Enum<DownloadAuthorizationEventType> {
    public static final DownloadAuthorizationEventType FILE_DOWNLOAD = null;
    public static final DownloadAuthorizationEventType FILE_OPEN_IN_3RD_APP = null;
    public static final DownloadAuthorizationEventType IMAGE_DOWNLOAD = null;
    public static final DownloadAuthorizationEventType VIDEO_DOWNLOAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DownloadAuthorizationEventType[] f409689a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f409690b = null;

    public static EnumEntries<DownloadAuthorizationEventType> getEntries() {
        return f409690b;
    }

    static {
        DownloadAuthorizationEventType r100 = new DownloadAuthorizationEventType("IMAGE_DOWNLOAD", 0);
        IMAGE_DOWNLOAD = r100;
        DownloadAuthorizationEventType r101 = new DownloadAuthorizationEventType("VIDEO_DOWNLOAD", 1);
        VIDEO_DOWNLOAD = r101;
        DownloadAuthorizationEventType r102 = new DownloadAuthorizationEventType("FILE_DOWNLOAD", 2);
        FILE_DOWNLOAD = r102;
        DownloadAuthorizationEventType r103 = new DownloadAuthorizationEventType("FILE_OPEN_IN_3RD_APP", 3);
        FILE_OPEN_IN_3RD_APP = r103;
        DownloadAuthorizationEventType[] r104 = {r100, r101, r102, r103};
        f409689a = r104;
        f409690b = EnumEntriesKt.enumEntries(r104);
    }

    public static DownloadAuthorizationEventType[] values() {
        return (DownloadAuthorizationEventType[]) f409689a.clone();
    }

    public static DownloadAuthorizationEventType valueOf(String r100) {
        return (DownloadAuthorizationEventType) r27.a.a(DownloadAuthorizationEventType.class, r100);
    }

    public DownloadAuthorizationEventType(String r100, int r101) {
        super(r100, r101);
    }
}
