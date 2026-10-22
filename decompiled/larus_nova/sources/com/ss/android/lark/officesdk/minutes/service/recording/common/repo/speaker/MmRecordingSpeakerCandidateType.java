package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/speaker/MmRecordingSpeakerCandidateType;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "ADD_NEW", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmRecordingSpeakerCandidateType extends Enum<MmRecordingSpeakerCandidateType> {
    public static final MmRecordingSpeakerCandidateType ADD_NEW = null;
    public static final MmRecordingSpeakerCandidateType NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmRecordingSpeakerCandidateType[] f435054a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435055b = null;

    public static EnumEntries<MmRecordingSpeakerCandidateType> getEntries() {
        return f435055b;
    }

    static {
        MmRecordingSpeakerCandidateType r100 = new MmRecordingSpeakerCandidateType(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        MmRecordingSpeakerCandidateType r101 = new MmRecordingSpeakerCandidateType("ADD_NEW", 1);
        ADD_NEW = r101;
        MmRecordingSpeakerCandidateType[] r102 = {r100, r101};
        f435054a = r102;
        f435055b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmRecordingSpeakerCandidateType[] values() {
        return (MmRecordingSpeakerCandidateType[]) f435054a.clone();
    }

    public static MmRecordingSpeakerCandidateType valueOf(String r100) {
        return (MmRecordingSpeakerCandidateType) r27.a.a(MmRecordingSpeakerCandidateType.class, r100);
    }

    public MmRecordingSpeakerCandidateType(String r100, int r101) {
        super(r100, r101);
    }
}
