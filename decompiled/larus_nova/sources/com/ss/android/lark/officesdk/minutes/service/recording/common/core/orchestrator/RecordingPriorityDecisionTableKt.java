package com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator;

import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityScene;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class RecordingPriorityDecisionTableKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Pair<RecordingPriorityScene, RecordingPriorityScene>, SceneRelation> f434203a = null;

    static {
        RecordingPriorityDecisionTableKt$recordingPriorityDecisionTable$1 r100 = RecordingPriorityDecisionTableKt$recordingPriorityDecisionTable$1.INSTANCE;
        f r101 = new f();
        r100.invoke(r101);
        f434203a = MapsKt.toMap(r101.f434223a);
    }
}
