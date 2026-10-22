package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import com.byted.cast.common.bean.State;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MMRecordingState;", "", "<init>", "(Ljava/lang/String;I)V", ErrorCode.INIT, State.RECORDING, "PAUSED", "DISABLED", "IDLE", "isNotIdle", "", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MMRecordingState extends Enum<MMRecordingState> {
    public static final MMRecordingState DISABLED = null;
    public static final MMRecordingState IDLE = null;
    public static final MMRecordingState INIT = null;
    public static final MMRecordingState PAUSED = null;
    public static final MMRecordingState RECORDING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MMRecordingState[] f436143a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f436144b = null;

    public static EnumEntries<MMRecordingState> getEntries() {
        return f436144b;
    }

    static {
        MMRecordingState r100 = new MMRecordingState(ErrorCode.INIT, 0);
        INIT = r100;
        MMRecordingState r101 = new MMRecordingState(State.RECORDING, 1);
        RECORDING = r101;
        MMRecordingState r102 = new MMRecordingState("PAUSED", 2);
        PAUSED = r102;
        MMRecordingState r103 = new MMRecordingState("DISABLED", 3);
        DISABLED = r103;
        MMRecordingState r104 = new MMRecordingState("IDLE", 4);
        IDLE = r104;
        MMRecordingState[] r105 = {r100, r101, r102, r103, r104};
        f436143a = r105;
        f436144b = EnumEntriesKt.enumEntries(r105);
    }

    public static MMRecordingState[] values() {
        return (MMRecordingState[]) f436143a.clone();
    }

    public final boolean isNotIdle() {
        if (this == IDLE) goto L5;
        return true;
    L5:
        return false;
    }

    public static MMRecordingState valueOf(String r100) {
        return (MMRecordingState) r27.a.a(MMRecordingState.class, r100);
    }

    public MMRecordingState(String r100, int r101) {
        super(r100, r101);
    }
}
