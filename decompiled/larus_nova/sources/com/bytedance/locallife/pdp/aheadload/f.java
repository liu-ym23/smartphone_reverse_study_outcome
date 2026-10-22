package com.bytedance.locallife.pdp.aheadload;

import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.locallife.cube.api.config.CubeContext;
import com.bytedance.locallife.cube.api.i.ICubeListener;
import com.bytedance.locallife.pdp.container.j0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f extends ICubeListener.Base {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f260920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j0 f260921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f260922c;

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener.Base, com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onLoadSuccess(CubeContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onLoadSuccess(r100);
        this.f260922c.set(true);
        j0 r101 = this.f260921b;
        d1 r102 = r100.f257178q;
        if (r102 == null) goto L5;
        String r103 = r102.a();
    L6:
        r101.a(r103);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener.Base, com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onPageUpdate(CubeContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onPageUpdate(r100);
        if (this.f260920a == true) goto L5;
        return;
    L5:
        if (this.f260922c.compareAndSet(false, true) == false) goto L13;
        j0 r101 = this.f260921b;
        d1 r102 = r100.f257178q;
        if (r102 == null) goto L9;
        String r103 = r102.a();
    L10:
        r101.a(r103);
        return;
    L9:
        r103 = null;
        goto L10
    }

    public f(boolean r100, j0 r101) {
        Intrinsics.checkNotNullParameter(r101, "renderStateManager");
        this.f260920a = r100;
        this.f260921b = r101;
        this.f260922c = new AtomicBoolean(false);
    }
}
