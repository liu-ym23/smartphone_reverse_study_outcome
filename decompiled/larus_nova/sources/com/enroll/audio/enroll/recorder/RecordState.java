package com.enroll.audio.enroll.recorder;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/enroll/audio/enroll/recorder/RecordState;", "", "<init>", "(Ljava/lang/String;I)V", "STOP", GXAnimation.STATE_START, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RecordState extends Enum<RecordState> {
    public static final RecordState START = null;
    public static final RecordState STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RecordState[] f273740a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f273741b = null;

    public static EnumEntries<RecordState> getEntries() {
        return f273741b;
    }

    static {
        RecordState r100 = new RecordState("STOP", 0);
        STOP = r100;
        RecordState r101 = new RecordState(GXAnimation.STATE_START, 1);
        START = r101;
        RecordState[] r102 = {r100, r101};
        f273740a = r102;
        f273741b = EnumEntriesKt.enumEntries(r102);
    }

    public static RecordState[] values() {
        return (RecordState[]) f273740a.clone();
    }

    public static RecordState valueOf(String r100) {
        return (RecordState) r27.a.a(RecordState.class, r100);
    }

    public RecordState(String r100, int r101) {
        super(r100, r101);
    }
}
