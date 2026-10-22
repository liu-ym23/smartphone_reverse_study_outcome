package com.bytedance.locallife.biz.widget;

import android.view.View;
import com.bytedance.locallife.cube.api.config.CubeContext;
import com.bytedance.locallife.cube.api.i.ICubeListener;
import com.bytedance.locallife.cube.api.i.IPoiLynxKitDelegate;
import com.bytedance.locallife.cube.api.model.CubeLynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends ICubeListener.Base {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SimpleLynxView f257026a;

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener.Base, com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onFirstLoadPerfReady(CubeContext r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener.Base, com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onFirstScreen(CubeContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public b(SimpleLynxView r100) {
        this.f257026a = r100;
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener.Base, com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onLoadSuccess(CubeContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        SimpleLynxView r101 = this.f257026a;
        int r102 = SimpleLynxView.f257017h;
        r101.getClass();
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener.Base, com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onPageUpdate(CubeContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        IPoiLynxKitDelegate r101 = this.f257026a.getDelegate();
        if (r101 == null) goto L12;
        View r102 = r101.realView();
        if (r102 == null) goto L12;
        boolean r103 = true;
        if (r102.getVisibility() != 0) goto L9;
        boolean r104 = true;
    L10:
        if (r104 != true) goto L12;
    L13:
        if (r103 == true) goto L20;
        IPoiLynxKitDelegate r105 = this.f257026a.getDelegate();
        if (r105 == null) goto L21;
        View r106 = r105.realView();
        if (r106 == null) goto L22;
        r106.setVisibility(0);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L9:
        r104 = false;
    L12:
        r103 = false;
        goto L13
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener.Base, com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onReceivedError(CubeContext r100, CubeLynxError r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onReceivedError(r100, r101);
        SimpleLynxView r102 = this.f257026a;
        int r103 = SimpleLynxView.f257017h;
        r102.getClass();
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener.Base, com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onLoadUriFailed(String r100, CubeContext r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "cause");
        super.onLoadUriFailed(r100, r101, r102);
    }
}
