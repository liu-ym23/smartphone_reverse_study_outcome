package com.larus.bmhome.resource.access;

import java.util.List;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f313624a = null;

    static {
        f313624a = new b();
    }

    public b() {
    }

    public final Object a(f r100, h0 r101, List r102, ContinuationImpl r103) {
        return CoroutineScopeKt.coroutineScope(new CompletionDrivenDagResourceNodeOrchestrator$execute$2(r102, r100, r101, null), r103);
    }
}
