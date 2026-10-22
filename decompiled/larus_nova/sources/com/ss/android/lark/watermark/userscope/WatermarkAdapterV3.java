package com.ss.android.lark.watermark.userscope;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.watermark.core.IAttachResultCallback;
import com.ss.android.lark.watermark.core.IAttachToBitmapCallback;
import com.ss.android.lark.watermark.core.WatermarkPointContext;
import com.ss.android.lark.watermark.core.WatermarkType;
import com.ss.android.lark.watermark.dto.WatermarkData;
import com.ss.android.lark.watermark.dto.WatermarkInfo;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@UserScope
public final class WatermarkAdapterV3 implements com.ss.android.lark.watermark.v2.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UiThreadExecutionWatermarkImplV3 f445343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f445344b;

    @Override // com.ss.android.lark.watermark.v2.p
    public final void init(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public void update(WatermarkInfo r100) {
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public final WatermarkInfo get() {
        UiThreadExecutionWatermarkImplV3 r100 = this.f445343a;
        Application r101 = LarkContext.getApplication();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        WatermarkImplV3 r102 = r100.f445332a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return r102.f().a();
    }

    @Inject
    public WatermarkAdapterV3(UiThreadExecutionWatermarkImplV3 r100) {
        Intrinsics.checkNotNullParameter(r100, "watermarkInstance");
        this.f445343a = r100;
        this.f445344b = LazyKt.lazy(WatermarkAdapterV3$fallbackUseGlobalFG$2.INSTANCE);
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public final void detachWatermark(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        UiThreadExecutionWatermarkImplV3 r101 = this.f445343a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "activity");
        j.a(r101.d(), new f(r101, r100));
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public final WatermarkData getWatermarkData(WatermarkType r100) {
        Intrinsics.checkNotNullParameter(r100, "watermarkType");
        UiThreadExecutionWatermarkImplV3 r101 = this.f445343a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "watermarkType");
        WatermarkImplV3 r102 = r101.f445332a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "watermarkType");
        if (r100 != WatermarkType.EXPORT) goto L6;
        return r102.f().e();
    L6:
        if (r100 != WatermarkType.PREVIEW) goto L9;
        return r102.f().i();
    L9:
        return r102.f().c();
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public final void detachWatermark(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "frameLayout");
        UiThreadExecutionWatermarkImplV3 r101 = this.f445343a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "frameLayout");
        j.a(r101.d(), new g(r101, r100));
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public final void addWatermarkToBitmap(Bitmap r100, IAttachToBitmapCallback r101) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        UiThreadExecutionWatermarkImplV3 r102 = this.f445343a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        j.a(r102.d(), new e(r102, r100, r101));
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public final void attachWatermark(FrameLayout r100, IAttachResultCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "frameLayout");
        UiThreadExecutionWatermarkImplV3 r102 = this.f445343a;
        if (((Boolean) this.f445344b.getValue()).booleanValue() == false) goto L5;
        Boolean r103 = null;
    L6:
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "frameLayout");
        j.a(r102.d(), new d(r102, r100, r103, r101));
        return;
    L5:
        r103 = Boolean.FALSE;
        goto L6
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public final void attachWatermark(Activity r100, IAttachResultCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        UiThreadExecutionWatermarkImplV3 r102 = this.f445343a;
        if (((Boolean) this.f445344b.getValue()).booleanValue() == false) goto L5;
        Boolean r103 = null;
    L6:
        r102.c(r100, r103, r101);
        return;
    L5:
        r103 = Boolean.FALSE;
        goto L6
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public final void attachWatermark(FrameLayout r100, boolean r101, IAttachResultCallback r102) {
        if (r100 == null) goto L5;
        UiThreadExecutionWatermarkImplV3 r103 = this.f445343a;
        Boolean r104 = Boolean.valueOf(r101);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "frameLayout");
        j.a(r103.d(), new d(r103, r100, r104, r102));
        return;
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public final void attachWatermark(Activity r100, boolean r101, IAttachResultCallback r102) {
        if (r100 == null) goto L5;
        this.f445343a.c(r100, Boolean.valueOf(r101), r102);
        return;
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public final void tryAddFileWatermarkToBitmap(final Bitmap r110, final IAttachToBitmapCallback r111, final WatermarkType r112, final WatermarkPointContext r113) {
        Intrinsics.checkNotNullParameter(r110, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "watermarkType");
        Intrinsics.checkNotNullParameter(r113, "watermarkPointContext");
        UiThreadExecutionWatermarkImplV3 r100 = this.f445343a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "watermarkType");
        Intrinsics.checkNotNullParameter(r113, "watermarkPointContext");
        final WatermarkImplV3 r101 = r100.f445332a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r110, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "watermarkType");
        Intrinsics.checkNotNullParameter(r113, "watermarkPointContext");
        new Handler(Looper.getMainLooper()).post(new WatermarkImplV3$tryAddFileWatermarkToBitmap$1(r101, r112, r113, r110, r111));
    }
}
