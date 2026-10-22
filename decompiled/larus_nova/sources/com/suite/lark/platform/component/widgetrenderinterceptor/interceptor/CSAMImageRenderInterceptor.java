package com.suite.lark.platform.component.widgetrenderinterceptor.interceptor;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.platform.component.widgetrenderinterceptor.IMBizImageRenderInterceptor;
import com.suite.lark.platform.component.widgetrenderinterceptor.entity.BizInterceptorType;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class CSAMImageRenderInterceptor implements IMBizImageRenderInterceptor {

    public static final class a {
    }

    static {
    }

    public CSAMImageRenderInterceptor() {
    }

    public final String toString() {
        return "CSAM interceptor";
    }

    @Override // com.suite.lark.platform.component.widgetrenderinterceptor.IMBizImageRenderInterceptor
    public final IMBizImageRenderInterceptor.Scene c() {
        return IMBizImageRenderInterceptor.Scene.BeforeRender;
    }

    @Override // com.suite.lark.platform.component.widgetrenderinterceptor.IMBizImageRenderInterceptor
    public BizInterceptorType getType() {
        return BizInterceptorType.CSAM_DELETE;
    }

    @Override // com.suite.lark.platform.component.widgetrenderinterceptor.IMBizImageRenderInterceptor
    public final Function0<Boolean> a(final Context r100, final IMBizImageRenderInterceptor.a r101, final kpc.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "targetProvider");
        Intrinsics.checkNotNullParameter(r102, "data");
        return new CSAMImageRenderInterceptor$interceptClick$1(this, r102, r101, r100);
    }

    @Override // com.suite.lark.platform.component.widgetrenderinterceptor.IMBizImageRenderInterceptor
    public final Function0<Boolean> b(final Context r100, final IMBizImageRenderInterceptor.a r101, final kpc.a r110, final IMBizImageRenderInterceptor.b r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "targetProvider");
        Intrinsics.checkNotNullParameter(r110, "data");
        return new CSAMImageRenderInterceptor$interceptRender$1(this, r110, r101, r100, r111);
    }
}
