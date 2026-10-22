package com.ss.android.lark.officesdk.minutes.api.recording.common.data.notification;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/notification/MmRecordingNotificationType;", "", "<init>", "(Ljava/lang/String;I)V", "MAX_DURATION", "PHONE_CALL", "WEAK_NETWORK", "SUBTITLE_FAILED", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmRecordingNotificationType extends Enum<MmRecordingNotificationType> {
    public static final MmRecordingNotificationType MAX_DURATION = null;
    public static final MmRecordingNotificationType PHONE_CALL = null;
    public static final MmRecordingNotificationType SUBTITLE_FAILED = null;
    public static final MmRecordingNotificationType WEAK_NETWORK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmRecordingNotificationType[] f433535a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433536b = null;

    public static EnumEntries<MmRecordingNotificationType> getEntries() {
        return f433536b;
    }

    static {
        MmRecordingNotificationType r100 = new MmRecordingNotificationType("MAX_DURATION", 0);
        MAX_DURATION = r100;
        MmRecordingNotificationType r101 = new MmRecordingNotificationType("PHONE_CALL", 1);
        PHONE_CALL = r101;
        MmRecordingNotificationType r102 = new MmRecordingNotificationType("WEAK_NETWORK", 2);
        WEAK_NETWORK = r102;
        MmRecordingNotificationType r103 = new MmRecordingNotificationType("SUBTITLE_FAILED", 3);
        SUBTITLE_FAILED = r103;
        MmRecordingNotificationType[] r104 = {r100, r101, r102, r103};
        f433535a = r104;
        f433536b = EnumEntriesKt.enumEntries(r104);
    }

    public static MmRecordingNotificationType[] values() {
        return (MmRecordingNotificationType[]) f433535a.clone();
    }

    public static MmRecordingNotificationType valueOf(String r100) {
        return (MmRecordingNotificationType) a.a(MmRecordingNotificationType.class, r100);
    }

    public MmRecordingNotificationType(String r100, int r101) {
        super(r100, r101);
    }
}
