package com.ss.android.lark.integrator.ccm.storage.clean;

import android.content.Context;
import ay4.d;
import com.bytedance.ee.bear.diskmanager.dirs.CCMLarkDir;
import com.ss.android.lark.diskmanage.Biz;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.platform.component.storage.clean.CleanRequest;
import com.suite.lark.platform.component.storage.clean.h;
import com.suite.lark.platform.component.storage.clean.j;
import com.suite.lark.platform.component.storage.clean.n;
import com.suite.lark.platform.component.storage.clean.request.LogoutAllRequest;
import com.suite.lark.platform.component.storage.clean.request.RemoteClearRequest;
import com.suite.lark.platform.component.storage.clean.resource.FileCleanResource;
import java.util.ArrayList;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class CCMCleanModule implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Biz f427910a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f427911b;

    public static final class a {
    }

    @Inject
    public CCMCleanModule() {
    }

    static {
        f427910a = Biz.DOCS;
    }

    public static final void c(CCMCleanModule r100, CleanRequest.a r101) {
        r100.getClass();
        String r102 = f427911b;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("CCM_INTERNAL_FILES");
        r102 = null;
    L5:
        FileCleanResource r103 = new FileCleanResource(d.a().z(r102).subPath("docs").subPath("clip").toString(), f427910a);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r103, "res");
        throw null;
    }

    @Override // com.suite.lark.platform.component.storage.clean.j
    public final void a(Context r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "registry");
        r101.a(new com.ss.android.lark.integrator.ccm.storage.clean.a());
    }

    @Override // com.suite.lark.platform.component.storage.clean.j
    public final void b(final Context r100, n r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "registry");
        f427911b = CCMLarkDir.f217596c.getValue().a(r100);
        CCMLarkDir.f217595b.getValue().a(r100);
        CCMLarkDir.f217597d.getValue().a(r100);
        CCMLarkDir.f217598e.getValue().a(r100);
        Function1<CleanRequest.a<?, ?, ?>, Unit> r102 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(new CCMCleanModule$registerResource$1(this, r100), 1);
        HashMap<Class<CleanRequest.a<?, ?, ?>>, ArrayList<Function1<CleanRequest.a<?, ?, ?>, Unit>>> r103 = r101.f460617a;
        ArrayList<Function1<CleanRequest.a<?, ?, ?>, Unit>> r104 = r103.get(LogoutAllRequest.a.class);
        if (r104 != null) goto L5;
        r104 = new ArrayList();
        r103.put(LogoutAllRequest.a.class, r104);
    L5:
        r104.add(r102);
        Function1<CleanRequest.a<?, ?, ?>, Unit> r105 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(new CCMCleanModule$registerResource$2(this, r100), 1);
        HashMap<Class<CleanRequest.a<?, ?, ?>>, ArrayList<Function1<CleanRequest.a<?, ?, ?>, Unit>>> r106 = r101.f460617a;
        ArrayList<Function1<CleanRequest.a<?, ?, ?>, Unit>> r107 = r106.get(RemoteClearRequest.a.class);
        if (r107 != null) goto L8;
        r107 = new ArrayList();
        r106.put(RemoteClearRequest.a.class, r107);
    L8:
        r107.add(r105);
    }
}
