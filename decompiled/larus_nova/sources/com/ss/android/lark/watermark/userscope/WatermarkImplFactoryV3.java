package com.ss.android.lark.watermark.userscope;

import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@UserScope
public final class WatermarkImplFactoryV3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UiThreadExecutionWatermarkImplV3 f445345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WatermarkAdapterV3 f445346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f445347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f445348d;

    @Inject
    public WatermarkImplFactoryV3(UiThreadExecutionWatermarkImplV3 r100, WatermarkAdapterV3 r101) {
        Intrinsics.checkNotNullParameter(r100, "uiThreadExecutionWatermarkImplV3");
        Intrinsics.checkNotNullParameter(r101, "watermarkAdapterV3");
        this.f445345a = r100;
        this.f445346b = r101;
        this.f445347c = LazyKt.lazy(new WatermarkImplFactoryV3$watermarkInstance$2(this));
        this.f445348d = LazyKt.lazy(new WatermarkImplFactoryV3$watermarkAdapterInstance$2(this));
    }
}
