package com.obric.assistant.upload.internal;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Set<oha.a>> f393564a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f393565b = null;

    static {
        f393564a = Collections.synchronizedMap(new LinkedHashMap());
        f393565b = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new d())));
    }

    public static void a(String r100, oha.a r101) {
        Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
        Intrinsics.checkNotNullParameter(r101, "uploadListener");
        Map<String, Set<oha.a>> r102 = f393564a;
        Set<oha.a> r103 = r102.get(r100);
        if (r103 != null) goto L5;
        r103 = new CopyOnWriteArraySet();
    L5:
        r103.add(r101);
        r102.put(r100, r103);
        if (r102.size() <= 10) goto L9;
        r102.remove(CollectionsKt.first(r102.keySet()));
        return;
    }
}
