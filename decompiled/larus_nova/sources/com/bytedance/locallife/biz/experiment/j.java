package com.bytedance.locallife.biz.experiment;

import com.bytedance.locallife.dito.common.experiment.PoiLynxOptExperiment;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.poi.utils.TypeExtKt;
import kotlin.KotlinNothingValueException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class j extends PoiLynxOptExperiment<Integer> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j f256668d = null;

    static {
        f256668d = new j();
    }

    @Override // com.bytedance.locallife.dito.common.experiment.PoiLynxOptExperiment
    public final String c() {
        return "poi_lynx_prefetch_image";
    }

    public j() {
        super(Integer.TYPE);
    }

    public static Boolean d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxUrl");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        String r102 = UriProtector.getQueryParameter(UriProtector.parse(r100), "enable_prefetch_image");     // Catch: Throwable -> L9
        if (r102 != null) goto L7;
        return null;
    L7:
        return TypeExtKt.a(r102);
    L9:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        if (Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th))) == null) goto L15;
        return Boolean.FALSE;
    L15:
        throw new KotlinNothingValueException();
    }
}
