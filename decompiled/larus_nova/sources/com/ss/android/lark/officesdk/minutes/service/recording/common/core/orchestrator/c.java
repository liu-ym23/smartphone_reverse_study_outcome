package com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator;

import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityScene;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<RecordingPriorityScene> f434219b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<RecordingPriorityScene, RecordingPriorityScene, String> f434220a;

    public static final class a {
    }

    static {
        f434219b = CollectionsKt.listOf(new RecordingPriorityScene[]{RecordingPriorityScene.OTA, RecordingPriorityScene.D3200_FILE_SYNC, RecordingPriorityScene.D1204_CHARGING_CASE_FILE_SYNC, RecordingPriorityScene.D1204_UPLOAD_WALLPAPER, RecordingPriorityScene.D3200_RECORDING, RecordingPriorityScene.D1204_CHARGING_CASE_RECORDING, RecordingPriorityScene.SOFTWARE_RECORDING, RecordingPriorityScene.STANDALONE_AI_INTERPRETATION, RecordingPriorityScene.MEDIA_RECORD, RecordingPriorityScene.CALL_RECORD, RecordingPriorityScene.VIDEO_CONFERENCE});
    }

    public c(int r100) {
        RecordingPriorityRejectMessageResolver$1 r101 = RecordingPriorityRejectMessageResolver$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r101, "scenePairMessageProvider");
        this.f434220a = r101;
    }
}
