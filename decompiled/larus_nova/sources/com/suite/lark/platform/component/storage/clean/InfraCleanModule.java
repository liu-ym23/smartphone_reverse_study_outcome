package com.suite.lark.platform.component.storage.clean;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.platform.component.storage.clean.request.RemoteClearRequest;
import java.util.ArrayList;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class InfraCleanModule implements j {

    public static final class a {
    }

    static {
    }

    @Inject
    public InfraCleanModule() {
    }

    @Override // com.suite.lark.platform.component.storage.clean.j
    public final void a(Context r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "registry");
    }

    @Override // com.suite.lark.platform.component.storage.clean.j
    public final void b(final Context r100, n r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "registry");
        Function1<CleanRequest.a<?, ?, ?>, Unit> r102 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(new InfraCleanModule$registerResource$1(r100, this), 1);
        HashMap<Class<CleanRequest.a<?, ?, ?>>, ArrayList<Function1<CleanRequest.a<?, ?, ?>, Unit>>> r103 = r101.f460617a;
        ArrayList<Function1<CleanRequest.a<?, ?, ?>, Unit>> r104 = r103.get(RemoteClearRequest.a.class);
        if (r104 != null) goto L5;
        r104 = new ArrayList();
        r103.put(RemoteClearRequest.a.class, r104);
    L5:
        r104.add(r102);
    }
}
