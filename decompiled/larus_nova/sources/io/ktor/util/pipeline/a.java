package io.ktor.util.pipeline;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public class a<TSubject, TContext> {
    private volatile /* synthetic */ Object _interceptors;

    public final Object a(Object r100, Unit r101, Continuation r102) {
        CoroutineContext r103 = r102.getContext();
        if (((List) this._interceptors) != null) goto L5;
        this._interceptors = CollectionsKt.emptyList();
        CollectionsKt.emptyList();
    L5:
        List r104 = (List) this._interceptors;
        Intrinsics.checkNotNull(r104);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "interceptors");
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_SUBJECT);
        Intrinsics.checkNotNullParameter(r103, "coroutineContext");
        if (c.f491976a == true) goto L8;
        b r105 = new g(r101, r100, r104);
    L10:
        return r105.a(r101, r102);
    L8:
        r105 = new DebugPipelineContext(r100, r104, r101, r103);
        goto L10
    }
}
