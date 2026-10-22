package com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator;

import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityScene;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Pair<RecordingPriorityScene, RecordingPriorityScene>, Integer> f434221a = null;

    static {
        RecordingPriorityScene r100 = RecordingPriorityScene.D3200_RECORDING;
        RecordingPriorityScene r101 = RecordingPriorityScene.OTA;
        Pair r102 = TuplesKt.to(r100, r101);
        Integer r103 = Integer.valueOf(R.string.View_MempopeTwo_FirmwareUpgradeBusy_Toast);
        RecordingPriorityScene r104 = RecordingPriorityScene.D3200_FILE_SYNC;
        RecordingPriorityScene r105 = RecordingPriorityScene.D1204_CHARGING_CASE_RECORDING;
        RecordingPriorityScene r106 = RecordingPriorityScene.D1204_CHARGING_CASE_FILE_SYNC;
        RecordingPriorityScene r107 = RecordingPriorityScene.D1204_UPLOAD_WALLPAPER;
        RecordingPriorityScene r108 = RecordingPriorityScene.SOFTWARE_RECORDING;
        RecordingPriorityScene r109 = RecordingPriorityScene.CALL_RECORD;
        Pair r110 = TuplesKt.to(r108, r109);
        Integer r111 = Integer.valueOf(R.string.View_MempopeTwo_RecordingInProgressNoNewRecording_Toast);
        Pair r112 = TuplesKt.to(r101, r100);
        Integer r113 = Integer.valueOf(R.string.View_MemPopeSCW_RecordingTryAgain_Toast);
        Pair r114 = TuplesKt.to(r101, r107);
        Integer r115 = Integer.valueOf(R.string.View_MempopeTwo_FileSyncFirmwareUpgrade_Toast);
        f434221a = MapsKt.mapOf(new Pair[]{TuplesKt.to(r102, r103), TuplesKt.to(TuplesKt.to(r104, r101), r103), TuplesKt.to(TuplesKt.to(r105, r101), r103), TuplesKt.to(TuplesKt.to(r106, r101), r103), TuplesKt.to(TuplesKt.to(r107, r101), Integer.valueOf(R.string.View_MemPopeSCW_FirmwareUpdating_Toast)), TuplesKt.to(r110, r111), TuplesKt.to(TuplesKt.to(RecordingPriorityScene.STANDALONE_AI_INTERPRETATION, r109), r111), TuplesKt.to(TuplesKt.to(r109, r101), r103), TuplesKt.to(TuplesKt.to(r109, r104), Integer.valueOf(R.string.View_MempopeTwo_FileSyncRecordFail_Toast)), TuplesKt.to(r112, r113), TuplesKt.to(TuplesKt.to(r101, r105), r113), TuplesKt.to(TuplesKt.to(r101, r109), Integer.valueOf(R.string.View_MempopeTwo_CallRecordFwUpgrade_Toast)), TuplesKt.to(r114, r115), TuplesKt.to(TuplesKt.to(r101, r104), r115), TuplesKt.to(TuplesKt.to(r101, r106), r115), TuplesKt.to(TuplesKt.to(r101, r101), r103)});
    }
}
