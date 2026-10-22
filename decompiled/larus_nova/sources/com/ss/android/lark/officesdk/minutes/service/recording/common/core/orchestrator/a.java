package com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator;

import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityScene;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecordingPriorityScene f434214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Pair<RecordingPriorityScene, RecordingPriorityScene>, SceneRelation> f434215b;

    public final void b(Function1<? super e, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        a(SceneRelation.COEXIST, r100);
    }

    public final void c(Function1<? super e, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        a(SceneRelation.INTERRUPT, r100);
    }

    public a(RecordingPriorityScene r100, Map<Pair<RecordingPriorityScene, RecordingPriorityScene>, SceneRelation> r101) {
        Intrinsics.checkNotNullParameter(r100, "currentScene");
        Intrinsics.checkNotNullParameter(r101, "relations");
        this.f434214a = r100;
        this.f434215b = r101;
    }

    public final void a(SceneRelation r100, Function1<? super e, Unit> r101) {
        e r102 = new e();
        r101.invoke(r102);
        Iterator r103 = ((ArrayList) r102.f434222a).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        RecordingPriorityScene r104 = (RecordingPriorityScene) r103.next();
        this.f434215b.put(TuplesKt.to(this.f434214a, r104), r100);
        goto L4
    }
}
