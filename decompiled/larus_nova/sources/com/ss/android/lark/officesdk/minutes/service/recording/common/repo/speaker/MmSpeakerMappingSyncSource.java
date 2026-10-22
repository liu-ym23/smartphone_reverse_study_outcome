package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/speaker/MmSpeakerMappingSyncSource;", "", "<init>", "(Ljava/lang/String;I)V", "MEETING_INFO_READY", "SUBTITLE_PUSH", "MANUAL_MARK", "SPEAKER_INFO_CHANGE_PUSH", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmSpeakerMappingSyncSource extends Enum<MmSpeakerMappingSyncSource> {
    public static final MmSpeakerMappingSyncSource MANUAL_MARK = null;
    public static final MmSpeakerMappingSyncSource MEETING_INFO_READY = null;
    public static final MmSpeakerMappingSyncSource SPEAKER_INFO_CHANGE_PUSH = null;
    public static final MmSpeakerMappingSyncSource SUBTITLE_PUSH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmSpeakerMappingSyncSource[] f435065a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435066b = null;

    public static EnumEntries<MmSpeakerMappingSyncSource> getEntries() {
        return f435066b;
    }

    static {
        MmSpeakerMappingSyncSource r100 = new MmSpeakerMappingSyncSource("MEETING_INFO_READY", 0);
        MEETING_INFO_READY = r100;
        MmSpeakerMappingSyncSource r101 = new MmSpeakerMappingSyncSource("SUBTITLE_PUSH", 1);
        SUBTITLE_PUSH = r101;
        MmSpeakerMappingSyncSource r102 = new MmSpeakerMappingSyncSource("MANUAL_MARK", 2);
        MANUAL_MARK = r102;
        MmSpeakerMappingSyncSource r103 = new MmSpeakerMappingSyncSource("SPEAKER_INFO_CHANGE_PUSH", 3);
        SPEAKER_INFO_CHANGE_PUSH = r103;
        MmSpeakerMappingSyncSource[] r104 = {r100, r101, r102, r103};
        f435065a = r104;
        f435066b = EnumEntriesKt.enumEntries(r104);
    }

    public static MmSpeakerMappingSyncSource[] values() {
        return (MmSpeakerMappingSyncSource[]) f435065a.clone();
    }

    public static MmSpeakerMappingSyncSource valueOf(String r100) {
        return (MmSpeakerMappingSyncSource) r27.a.a(MmSpeakerMappingSyncSource.class, r100);
    }

    public MmSpeakerMappingSyncSource(String r100, int r101) {
        super(r100, r101);
    }
}
