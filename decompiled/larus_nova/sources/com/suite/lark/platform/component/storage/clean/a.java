package com.suite.lark.platform.component.storage.clean;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.platform.component.storage.clean.request.ResetAllRequest;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider<Set<l>> f460602a;

    @Override // com.suite.lark.platform.component.storage.clean.j
    public final void b(Context r100, n r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "registry");
    }

    @Inject
    public a(Provider<Set<l>> r100) {
        Intrinsics.checkNotNullParameter(r100, "eraserProvider");
        this.f460602a = r100;
    }

    @Override // com.suite.lark.platform.component.storage.clean.j
    public final void a(Context r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "registry");
        Iterator<T> r102 = this.f460602a.get().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.a(((l) r102.next()).a());
        goto L4
    L6:
        r101.a(new uoc.c());
        r101.a(new uoc.a());
        r101.a(new ResetAllRequest.b());
        r101.a(new uoc.e());
        r101.a(new uoc.d());
        r101.a(new uoc.b());
    }
}
