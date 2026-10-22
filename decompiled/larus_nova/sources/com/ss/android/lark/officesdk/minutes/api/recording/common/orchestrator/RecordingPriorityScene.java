package com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/orchestrator/RecordingPriorityScene;", "", "<init>", "(Ljava/lang/String;I)V", "D3200_RECORDING", "D3200_FILE_SYNC", "D1204_CHARGING_CASE_RECORDING", "D1204_CHARGING_CASE_FILE_SYNC", "D1204_UPLOAD_WALLPAPER", "SOFTWARE_RECORDING", "STANDALONE_AI_INTERPRETATION", "MEDIA_RECORD", "CALL_RECORD", "VIDEO_CONFERENCE", FlowDoraWifiScene.OTA, "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RecordingPriorityScene extends Enum<RecordingPriorityScene> {
    public static final RecordingPriorityScene CALL_RECORD = null;
    public static final RecordingPriorityScene D1204_CHARGING_CASE_FILE_SYNC = null;
    public static final RecordingPriorityScene D1204_CHARGING_CASE_RECORDING = null;
    public static final RecordingPriorityScene D1204_UPLOAD_WALLPAPER = null;
    public static final RecordingPriorityScene D3200_FILE_SYNC = null;
    public static final RecordingPriorityScene D3200_RECORDING = null;
    public static final RecordingPriorityScene MEDIA_RECORD = null;
    public static final RecordingPriorityScene OTA = null;
    public static final RecordingPriorityScene SOFTWARE_RECORDING = null;
    public static final RecordingPriorityScene STANDALONE_AI_INTERPRETATION = null;
    public static final RecordingPriorityScene VIDEO_CONFERENCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RecordingPriorityScene[] f433565a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433566b = null;

    public static EnumEntries<RecordingPriorityScene> getEntries() {
        return f433566b;
    }

    static {
        RecordingPriorityScene r100 = new RecordingPriorityScene("D3200_RECORDING", 0);
        D3200_RECORDING = r100;
        RecordingPriorityScene r101 = new RecordingPriorityScene("D3200_FILE_SYNC", 1);
        D3200_FILE_SYNC = r101;
        RecordingPriorityScene r102 = new RecordingPriorityScene("D1204_CHARGING_CASE_RECORDING", 2);
        D1204_CHARGING_CASE_RECORDING = r102;
        RecordingPriorityScene r103 = new RecordingPriorityScene("D1204_CHARGING_CASE_FILE_SYNC", 3);
        D1204_CHARGING_CASE_FILE_SYNC = r103;
        RecordingPriorityScene r104 = new RecordingPriorityScene("D1204_UPLOAD_WALLPAPER", 4);
        D1204_UPLOAD_WALLPAPER = r104;
        RecordingPriorityScene r105 = new RecordingPriorityScene("SOFTWARE_RECORDING", 5);
        SOFTWARE_RECORDING = r105;
        RecordingPriorityScene r110 = new RecordingPriorityScene("STANDALONE_AI_INTERPRETATION", 6);
        STANDALONE_AI_INTERPRETATION = r110;
        RecordingPriorityScene r111 = new RecordingPriorityScene("MEDIA_RECORD", 7);
        MEDIA_RECORD = r111;
        RecordingPriorityScene r112 = new RecordingPriorityScene("CALL_RECORD", 8);
        CALL_RECORD = r112;
        RecordingPriorityScene r113 = new RecordingPriorityScene("VIDEO_CONFERENCE", 9);
        VIDEO_CONFERENCE = r113;
        RecordingPriorityScene r114 = new RecordingPriorityScene(FlowDoraWifiScene.OTA, 10);
        OTA = r114;
        RecordingPriorityScene[] r115 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        f433565a = r115;
        f433566b = EnumEntriesKt.enumEntries(r115);
    }

    public static RecordingPriorityScene[] values() {
        return (RecordingPriorityScene[]) f433565a.clone();
    }

    public static RecordingPriorityScene valueOf(String r100) {
        return (RecordingPriorityScene) a.a(RecordingPriorityScene.class, r100);
    }

    public RecordingPriorityScene(String r100, int r101) {
        super(r100, r101);
    }
}
