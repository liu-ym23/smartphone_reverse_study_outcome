package com.ss.android.lark.watermark.userscope;

import android.app.Dialog;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback;
import com.ss.android.lark.watermark.dto.WatermarkInfo;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes38.dex */
public final class WatermarkModuleProxy extends c0c.b implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f445379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.passportc.internal.v f445380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<c> f445381d;

    @Override // com.ss.android.lark.watermark.userscope.c
    public final void C4(BaseFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f445379b.C4(r100);
    }

    @Override // com.ss.android.lark.watermark.userscope.c
    public final void N0(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f445379b.N0(r100);
    }

    @Override // com.ss.android.lark.watermark.userscope.c
    public final void attachGlobalWatermark(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        this.f445379b.attachGlobalWatermark(r100);
    }

    @Override // com.ss.android.lark.watermark.userscope.c
    public final String cd(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "path");
        return this.f445379b.cd(r100, r101);
    }

    @Override // com.ss.android.lark.watermark.userscope.c
    public final void qa(BaseFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f445379b.qa(r100);
    }

    @Override // com.ss.android.lark.watermark.userscope.c
    public final int s() {
        return this.f445379b.s();
    }

    @Override // com.ss.android.lark.watermark.userscope.c
    public final void v7() {
        this.f445379b.v7();
    }

    @Override // com.ss.android.lark.watermark.userscope.c
    public final void w0(String r100, String r101, ByteString r102, IGetWaterMarkResourceCallback r103) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r103, "callback");
        this.f445379b.w0(r100, r101, r102, r103);
    }

    @Override // com.ss.android.lark.watermark.userscope.c
    public final WatermarkInfo z0(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f445379b.z0(r100);
    }

    @Override // com.ss.android.lark.watermark.userscope.c
    public final void h6(final com.ss.android.lark.watermark.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f445381d.a(new com.ss.android.lark.passportc.convention.b.C5239b(com.ss.android.lark.watermark.a.class, r100), new com.ss.android.lark.passportc.convention.b.c(new WatermarkModuleProxy$registerWatermarkInfoChangedListener$1(r100), new WatermarkModuleProxy$registerWatermarkInfoChangedListener$2(r100)));
    }

    @Override // com.ss.android.lark.watermark.userscope.c
    public final void hf(com.ss.android.lark.watermark.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f445381d.d(new com.ss.android.lark.passportc.convention.b.C5239b(com.ss.android.lark.watermark.a.class, r100));
    }

    public WatermarkModuleProxy(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.internal.v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<c> r103 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r102), c.class), c.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f445379b = r103.b();
        this.f445380c = r101;
        this.f445381d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        com.ss.android.lark.passportc.internal.v r102 = this.f445380c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        c r104 = (c) e0c.k.b(r102.c(r103), c.class);
        this.f445381d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
