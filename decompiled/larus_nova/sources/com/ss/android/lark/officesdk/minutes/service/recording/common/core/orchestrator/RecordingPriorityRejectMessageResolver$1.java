package com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator;

import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityScene;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class RecordingPriorityRejectMessageResolver$1 extends FunctionReferenceImpl implements Function2<RecordingPriorityScene, RecordingPriorityScene, String> {
    public static final RecordingPriorityRejectMessageResolver$1 INSTANCE = null;

    static {
        INSTANCE = new RecordingPriorityRejectMessageResolver$1();
    }

    public RecordingPriorityRejectMessageResolver$1() {
        super(2, d.class, "defaultScenePairMessage", "defaultScenePairMessage(Lcom/ss/android/lark/officesdk/minutes/api/recording/common/orchestrator/RecordingPriorityScene;Lcom/ss/android/lark/officesdk/minutes/api/recording/common/orchestrator/RecordingPriorityScene;)Ljava/lang/String;", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(RecordingPriorityScene r100, RecordingPriorityScene r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        Integer r102 = d.f434221a.get(TuplesKt.to(r100, r101));
        if (r102 == null) goto L5;
        int r103 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.e.f434040a;
        return UIHelper.getString(r102.intValue());
    L5:
        return null;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ String invoke(RecordingPriorityScene r100, RecordingPriorityScene r101) {
        return invoke2(r100, r101);
    }
}
