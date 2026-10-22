package com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/orchestrator/RecordingPriorityStartMode;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "BACKGROUND", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RecordingPriorityStartMode extends Enum<RecordingPriorityStartMode> {
    public static final RecordingPriorityStartMode BACKGROUND = null;
    public static final RecordingPriorityStartMode NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RecordingPriorityStartMode[] f433567a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433568b = null;

    public static EnumEntries<RecordingPriorityStartMode> getEntries() {
        return f433568b;
    }

    static {
        RecordingPriorityStartMode r100 = new RecordingPriorityStartMode(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        RecordingPriorityStartMode r101 = new RecordingPriorityStartMode("BACKGROUND", 1);
        BACKGROUND = r101;
        RecordingPriorityStartMode[] r102 = {r100, r101};
        f433567a = r102;
        f433568b = EnumEntriesKt.enumEntries(r102);
    }

    public static RecordingPriorityStartMode[] values() {
        return (RecordingPriorityStartMode[]) f433567a.clone();
    }

    public static RecordingPriorityStartMode valueOf(String r100) {
        return (RecordingPriorityStartMode) a.a(RecordingPriorityStartMode.class, r100);
    }

    public RecordingPriorityStartMode(String r100, int r101) {
        super(r100, r101);
    }
}
