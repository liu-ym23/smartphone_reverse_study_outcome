package com.bytedance.locallife.pdp.container.view.lynx;

import com.bytedance.locallife.cube.api.config.CubeContext;
import com.bytedance.locallife.cube.api.i.ICubeListener;
import com.bytedance.locallife.cube.api.i.IPoiLynxKitDelegate;
import com.bytedance.locallife.cube.api.model.CubeLynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f extends ICubeListener.Base {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f261320a;

    public f(d r100) {
        this.f261320a = r100;
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener.Base, com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onFirstScreen(CubeContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onFirstScreen(r100);
        IPoiLynxKitDelegate r101 = this.f261320a.f261316e;
        if (r101 == null) goto L6;
        r101.syncFlush();
        return;
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener.Base, com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onLoadSuccess(CubeContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onLoadSuccess(r100);
        LynxLoader.c r101 = this.f261320a.f261314c;
        if (r101 == null) goto L5;
        r101.a();
    L5:
        this.f261320a.f261314c = null;
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener.Base, com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onRuntimeReady(CubeContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onRuntimeReady(r100);
        this.f261320a.getClass();
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener.Base, com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onReceivedError(CubeContext r100, CubeLynxError r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onReceivedError(r100, r101);
        boolean r102 = true;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L21;
        if (r101 != null) goto L11;
    L13:
        boolean r104 = false;
    L14:
        if (r104 == true) goto L21;
        if (r101 != null) goto L17;
    L19:
        r102 = false;
    L20:
        if (r102 == true) goto L21;
        return;
    L17:
        if (r101.getErrorCode() != 102) goto L19;
    L11:
        if (r101.getErrorCode() != 103) goto L13;
        r104 = true;
    L21:
        d.a(this.f261320a, r101);
        return;
    L5:
        if (r101.getErrorCode() != 100) goto L7;
        r103 = true;
        goto L8
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener.Base, com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onTimingSetup(CubeContext r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onTimingSetup(r100, r101);
        this.f261320a.getClass();
        d.a(this.f261320a, null);
    }
}
