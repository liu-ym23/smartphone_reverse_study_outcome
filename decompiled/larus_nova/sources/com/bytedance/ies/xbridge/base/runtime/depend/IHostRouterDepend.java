package com.bytedance.ies.xbridge.base.runtime.depend;

import android.content.Context;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.qqmusic.third.api.contract.Keys;
import g66.c;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import r56.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J@\u0010\u0011\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J0\u0010\u0015\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0014\u001a\u00020\u0010H&J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostRouterDepend;", "", "Lg66/c;", "contextProviderFactory", "", "Lr56/a;", "provideRouteOpenHandlerList", "provideRouteOpenExceptionHandler", "", "schema", "", "extraParams", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", Keys.API_PARAM_KEY_PLATFORM_TYPE, "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "openSchema", "type", "containerID", GXTemplateKey.GAIAX_LAYER_PROGRESS_ANIMATED, "closeView", "assembleHandlerChain", "anniex_release"}, k = 1, mv = {1, 4, 3})
public interface IHostRouterDepend {
    boolean closeView(c r100, XBridgePlatformType r101, String r102, boolean r103);

    boolean openSchema(c r100, String r101, Map<String, ? extends Object> r102, XBridgePlatformType r103, Context r104);

    a provideRouteOpenExceptionHandler(c r100);

    List<a> provideRouteOpenHandlerList(c r100);
}
