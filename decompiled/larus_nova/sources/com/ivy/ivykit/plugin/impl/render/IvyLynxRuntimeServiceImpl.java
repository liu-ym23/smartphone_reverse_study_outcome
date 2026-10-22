package com.ivy.ivykit.plugin.impl.render;

import android.content.Context;
import com.bytedance.ies.bullet.core.device.PropsUtilsKt;
import com.ivy.ivykit.api.plugin.IIvyLynxRuntimeService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ivy/ivykit/plugin/impl/render/IvyLynxRuntimeServiceImpl;", "Lcom/ivy/ivykit/api/plugin/IIvyLynxRuntimeService;", "<init>", "()V", "ivy_plugin_impl_bullet_release"}, k = 1, mv = {1, 7, 1})
public final class IvyLynxRuntimeServiceImpl implements IIvyLynxRuntimeService {
    @Override // com.ivy.ivykit.api.plugin.IIvyLynxRuntimeService
    public final String getLanguage() {
        return i16.a.e();
    }

    public IvyLynxRuntimeServiceImpl() {
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyLynxRuntimeService
    public final Map<String, Object> a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return PropsUtilsKt.getPageCommonProps(r100, null);
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyLynxRuntimeService
    public final Pair<Integer, Integer> b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return i16.a.g(r100);
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyLynxRuntimeService
    public final float c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return i16.a.b(r100);
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyLynxRuntimeService
    public final int getStatusBarHeight(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return i16.a.j(r100);
    }
}
