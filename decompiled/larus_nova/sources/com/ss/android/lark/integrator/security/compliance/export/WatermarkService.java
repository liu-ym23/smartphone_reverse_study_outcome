package com.ss.android.lark.integrator.security.compliance.export;

import android.app.Dialog;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback;
import com.ss.android.lark.watermark.userscope.ToolsV3Kt;
import com.ss.android.lark.watermark.userscope.WatermarkImplFactoryV3;
import com.ss.android.lark.watermark.v2.o;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes36.dex */
@OfficeSDKUserScope
public final class WatermarkService implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WatermarkImplFactoryV3 f428082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.watermark.userscope.c f428083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f428084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f428085d;

    @Override // com.ss.android.lark.integrator.security.compliance.export.d
    public final void K(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        boolean r101 = true;
        if (((Boolean) this.f428085d.getValue()).booleanValue() == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        p4c.d r103 = ToolsV3Kt.a();
        if (r103 == null) goto L11;
        r101 = r103.enableDoubaoDialogWatermarkGlobalOnly();
    L11:
        if (r101 == true) goto L13;
        ((o) this.f428084c.getValue()).a(r100, Boolean.valueOf(r102));
        return;
    L13:
        if (((Boolean) this.f428085d.getValue()).booleanValue() == false) goto L17;
        ((o) this.f428084c.getValue()).a(r100, Boolean.TRUE);
        return;
    L17:
        return;
    L5:
        if (((o) this.f428084c.getValue()).s() != 0) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.ss.android.lark.integrator.security.compliance.export.d
    public final void L8(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        ((o) this.f428084c.getValue()).b(r100);
    }

    @Inject
    public WatermarkService(WatermarkImplFactoryV3 r100, com.ss.android.lark.watermark.userscope.c r101) {
        Intrinsics.checkNotNullParameter(r100, "watermarkImplFactoryV3");
        Intrinsics.checkNotNullParameter(r101, "watermarkModule");
        this.f428082a = r100;
        this.f428083b = r101;
        this.f428084c = LazyKt.lazy(new WatermarkService$watermarkImpl$2(this));
        this.f428085d = LazyKt.lazy(WatermarkService$enableDoubaoWatermark$2.INSTANCE);
    }

    @Override // com.ss.android.lark.integrator.security.compliance.export.d
    public final void w0(String r100, String r101, ByteString r102, IGetWaterMarkResourceCallback r103) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r103, "callback");
        this.f428083b.w0(r100, r101, r102, r103);
    }
}
