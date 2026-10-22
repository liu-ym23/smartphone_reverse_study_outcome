package com.bytedance.jedi.model.cache;

import com.bytedance.jedi.model.traceable.ITracePoint;
import com.bytedance.jedi.model.traceable.ITraceable;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"model_release"}, k = 2, mv = {1, 7, 1})
public final class PointcutKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<ITracePoint<?>, Map<?, ITraceable<?>>> f251050a = null;

    static {
        f251050a = Collections.synchronizedMap(new WeakHashMap());
    }
}
