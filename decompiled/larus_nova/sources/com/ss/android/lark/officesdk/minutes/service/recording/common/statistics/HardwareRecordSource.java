package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/statistics/HardwareRecordSource;", "", "trackValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTrackValue", "()Ljava/lang/String;", "CALL", "APP", "MEDIA", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HardwareRecordSource extends Enum<HardwareRecordSource> {
    public static final HardwareRecordSource APP = null;
    public static final HardwareRecordSource CALL = null;
    public static final HardwareRecordSource MEDIA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HardwareRecordSource[] f435393a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435394b = null;
    private final String trackValue;

    public static EnumEntries<HardwareRecordSource> getEntries() {
        return f435394b;
    }

    static {
        HardwareRecordSource r100 = new HardwareRecordSource("CALL", 0, NotificationCompat.CATEGORY_CALL);
        CALL = r100;
        HardwareRecordSource r101 = new HardwareRecordSource("APP", 1, "app");
        APP = r101;
        HardwareRecordSource r102 = new HardwareRecordSource("MEDIA", 2, "media");
        MEDIA = r102;
        HardwareRecordSource[] r103 = {r100, r101, r102};
        f435393a = r103;
        f435394b = EnumEntriesKt.enumEntries(r103);
    }

    public static HardwareRecordSource[] values() {
        return (HardwareRecordSource[]) f435393a.clone();
    }

    public final String getTrackValue() {
        return this.trackValue;
    }

    public static HardwareRecordSource valueOf(String r100) {
        return (HardwareRecordSource) r27.a.a(HardwareRecordSource.class, r100);
    }

    public HardwareRecordSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.trackValue = r102;
    }
}
