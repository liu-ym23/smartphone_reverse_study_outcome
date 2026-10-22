package com.ss.android.lark.framework.assembly.diskmanage;

import android.content.Context;
import com.bytedance.lark.rustclient.api.h;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.platform.component.storage.clean.CleanRequest;
import com.suite.lark.platform.component.storage.clean.j;
import com.suite.lark.platform.component.storage.clean.m;
import com.suite.lark.platform.component.storage.clean.n;
import com.suite.lark.platform.component.storage.clean.request.LogoutAllRequest;
import com.suite.lark.platform.component.storage.clean.request.RemoteClearRequest;
import java.util.ArrayList;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class RustCleanModule implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f425626a;

    public static final class a implements m<RustResource> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f425627a;

        @Override // com.suite.lark.platform.component.storage.clean.m
        public final Class<RustResource> a() {
            return RustResource.class;
        }

        public a(h r100) {
            Intrinsics.checkNotNullParameter(r100, "rustClient");
            this.f425627a = r100;
        }
    }

    @Inject
    public RustCleanModule(h r100) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        this.f425626a = r100;
    }

    public static final void c(RustCleanModule r100, CleanRequest.a r101) {
        r100.getClass();
        new ArrayList(CollectionsKt.collectionSizeOrDefault(null, 10));
        throw null;
    }

    @Override // com.suite.lark.platform.component.storage.clean.j
    public final void a(Context r100, com.suite.lark.platform.component.storage.clean.h r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "registry");
        r101.a(new a(this.f425626a));
    }

    @Override // com.suite.lark.platform.component.storage.clean.j
    public final void b(Context r100, n r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "registry");
        Function1<CleanRequest.a<?, ?, ?>, Unit> r102 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(new RustCleanModule$registerResource$1(this), 1);
        HashMap<Class<CleanRequest.a<?, ?, ?>>, ArrayList<Function1<CleanRequest.a<?, ?, ?>, Unit>>> r103 = r101.f460617a;
        ArrayList<Function1<CleanRequest.a<?, ?, ?>, Unit>> r104 = r103.get(LogoutAllRequest.a.class);
        if (r104 != null) goto L5;
        r104 = new ArrayList();
        r103.put(LogoutAllRequest.a.class, r104);
    L5:
        r104.add(r102);
        Function1<CleanRequest.a<?, ?, ?>, Unit> r105 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(new RustCleanModule$registerResource$2(this), 1);
        HashMap<Class<CleanRequest.a<?, ?, ?>>, ArrayList<Function1<CleanRequest.a<?, ?, ?>, Unit>>> r106 = r101.f460617a;
        ArrayList<Function1<CleanRequest.a<?, ?, ?>, Unit>> r107 = r106.get(RemoteClearRequest.a.class);
        if (r107 != null) goto L8;
        r107 = new ArrayList();
        r106.put(RemoteClearRequest.a.class, r107);
    L8:
        r107.add(r105);
    }
}
