package com.larus.canvas.service.internal;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import ny8.f;
import ny8.i;

/* JADX INFO: loaded from: classes26.dex */
public final class GetCanvasBlockInfoProcessor extends c<i> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f323831d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f323832e;

    public final void a() {
        FLogger.f375446a.i(this.f323832e, "trigger , canvasId = " + this.f323831d.canvasId + ", canvasSubId = " + this.f323831d.canvasSubId + ", localId = " + this.f323831d.localId);
        BuildersKt.launch$default((CoroutineScope) this.f323834b.getValue(), null, null, new GetCanvasBlockInfoProcessor$process$1(this, null), 3, null);
    }

    public GetCanvasBlockInfoProcessor(f r100, ny8.d<i> r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        super(r101);
        this.f323831d = r100;
        this.f323832e = "GetCanvasBlockInfoProcessor";
    }
}
