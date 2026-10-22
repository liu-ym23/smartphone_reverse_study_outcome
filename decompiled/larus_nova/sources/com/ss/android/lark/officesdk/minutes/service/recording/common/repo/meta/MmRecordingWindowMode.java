package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/meta/MmRecordingWindowMode;", "", "<init>", "(Ljava/lang/String;I)V", "FULL_SCREEN_ACTIVITY", "FLOAT_WINDOW", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmRecordingWindowMode extends Enum<MmRecordingWindowMode> {
    public static final MmRecordingWindowMode FLOAT_WINDOW = null;
    public static final MmRecordingWindowMode FULL_SCREEN_ACTIVITY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmRecordingWindowMode[] f435034a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435035b = null;

    public static EnumEntries<MmRecordingWindowMode> getEntries() {
        return f435035b;
    }

    static {
        MmRecordingWindowMode r100 = new MmRecordingWindowMode("FULL_SCREEN_ACTIVITY", 0);
        FULL_SCREEN_ACTIVITY = r100;
        MmRecordingWindowMode r101 = new MmRecordingWindowMode("FLOAT_WINDOW", 1);
        FLOAT_WINDOW = r101;
        MmRecordingWindowMode[] r102 = {r100, r101};
        f435034a = r102;
        f435035b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmRecordingWindowMode[] values() {
        return (MmRecordingWindowMode[]) f435034a.clone();
    }

    public static MmRecordingWindowMode valueOf(String r100) {
        return (MmRecordingWindowMode) r27.a.a(MmRecordingWindowMode.class, r100);
    }

    public MmRecordingWindowMode(String r100, int r101) {
        super(r100, r101);
    }
}
