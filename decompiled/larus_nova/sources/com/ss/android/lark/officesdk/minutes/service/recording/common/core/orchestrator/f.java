package com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator;

import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityScene;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<Pair<RecordingPriorityScene, RecordingPriorityScene>, SceneRelation> f434223a;

    public f() {
        this.f434223a = new LinkedHashMap();
    }

    public final void a(RecordingPriorityScene r100, Function1<? super a, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "block");
        r101.invoke(new a(r100, this.f434223a));
    }
}
