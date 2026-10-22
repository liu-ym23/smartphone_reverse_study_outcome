package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/ainote/MmRecordingAINoteHint;", "", "<init>", "(Ljava/lang/String;I)V", "SubtitleMissing", "MarkThrottle", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmRecordingAINoteHint extends Enum<MmRecordingAINoteHint> {
    public static final MmRecordingAINoteHint MarkThrottle = null;
    public static final MmRecordingAINoteHint SubtitleMissing = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmRecordingAINoteHint[] f434796a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f434797b = null;

    public static EnumEntries<MmRecordingAINoteHint> getEntries() {
        return f434797b;
    }

    static {
        MmRecordingAINoteHint r100 = new MmRecordingAINoteHint("SubtitleMissing", 0);
        SubtitleMissing = r100;
        MmRecordingAINoteHint r101 = new MmRecordingAINoteHint("MarkThrottle", 1);
        MarkThrottle = r101;
        MmRecordingAINoteHint[] r102 = {r100, r101};
        f434796a = r102;
        f434797b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmRecordingAINoteHint[] values() {
        return (MmRecordingAINoteHint[]) f434796a.clone();
    }

    public static MmRecordingAINoteHint valueOf(String r100) {
        return (MmRecordingAINoteHint) r27.a.a(MmRecordingAINoteHint.class, r100);
    }

    public MmRecordingAINoteHint(String r100, int r101) {
        super(r100, r101);
    }
}
