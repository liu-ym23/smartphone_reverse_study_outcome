package com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/orchestrator/RecordingRejectReason;", "", "<init>", "(Ljava/lang/String;I)V", "SAME_INSTANCE_ALREADY_RUNNING", "SAME_SCENE_ALREADY_RUNNING", "BLOCKED_BY_ACTIVE_SCENE", "BLOCKED_BY_SAME_PRIORITY", "BLOCKED_BY_HIGHER_PRIORITY", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RecordingRejectReason extends Enum<RecordingRejectReason> {
    public static final RecordingRejectReason BLOCKED_BY_ACTIVE_SCENE = null;
    public static final RecordingRejectReason BLOCKED_BY_HIGHER_PRIORITY = null;
    public static final RecordingRejectReason BLOCKED_BY_SAME_PRIORITY = null;
    public static final RecordingRejectReason SAME_INSTANCE_ALREADY_RUNNING = null;
    public static final RecordingRejectReason SAME_SCENE_ALREADY_RUNNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RecordingRejectReason[] f433569a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433570b = null;

    public static EnumEntries<RecordingRejectReason> getEntries() {
        return f433570b;
    }

    static {
        RecordingRejectReason r100 = new RecordingRejectReason("SAME_INSTANCE_ALREADY_RUNNING", 0);
        SAME_INSTANCE_ALREADY_RUNNING = r100;
        RecordingRejectReason r101 = new RecordingRejectReason("SAME_SCENE_ALREADY_RUNNING", 1);
        SAME_SCENE_ALREADY_RUNNING = r101;
        RecordingRejectReason r102 = new RecordingRejectReason("BLOCKED_BY_ACTIVE_SCENE", 2);
        BLOCKED_BY_ACTIVE_SCENE = r102;
        RecordingRejectReason r103 = new RecordingRejectReason("BLOCKED_BY_SAME_PRIORITY", 3);
        BLOCKED_BY_SAME_PRIORITY = r103;
        RecordingRejectReason r104 = new RecordingRejectReason("BLOCKED_BY_HIGHER_PRIORITY", 4);
        BLOCKED_BY_HIGHER_PRIORITY = r104;
        RecordingRejectReason[] r105 = {r100, r101, r102, r103, r104};
        f433569a = r105;
        f433570b = EnumEntriesKt.enumEntries(r105);
    }

    public static RecordingRejectReason[] values() {
        return (RecordingRejectReason[]) f433569a.clone();
    }

    public static RecordingRejectReason valueOf(String r100) {
        return (RecordingRejectReason) a.a(RecordingRejectReason.class, r100);
    }

    public RecordingRejectReason(String r100, int r101) {
        super(r100, r101);
    }
}
