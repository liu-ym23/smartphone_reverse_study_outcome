package com.ss.android.lark.officesdk.minutes.api.recording.common.data;

import com.byted.cast.common.bean.State;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", State.RECORDING, "PAUSED", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmRecordingState extends Enum<MmRecordingState> {
    public static final MmRecordingState IDLE = null;
    public static final MmRecordingState PAUSED = null;
    public static final MmRecordingState RECORDING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmRecordingState[] f433527a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433528b = null;

    public static EnumEntries<MmRecordingState> getEntries() {
        return f433528b;
    }

    static {
        MmRecordingState r100 = new MmRecordingState("IDLE", 0);
        IDLE = r100;
        MmRecordingState r101 = new MmRecordingState(State.RECORDING, 1);
        RECORDING = r101;
        MmRecordingState r102 = new MmRecordingState("PAUSED", 2);
        PAUSED = r102;
        MmRecordingState[] r103 = {r100, r101, r102};
        f433527a = r103;
        f433528b = EnumEntriesKt.enumEntries(r103);
    }

    public static MmRecordingState[] values() {
        return (MmRecordingState[]) f433527a.clone();
    }

    public static MmRecordingState valueOf(String r100) {
        return (MmRecordingState) a.a(MmRecordingState.class, r100);
    }

    public MmRecordingState(String r100, int r101) {
        super(r100, r101);
    }
}
