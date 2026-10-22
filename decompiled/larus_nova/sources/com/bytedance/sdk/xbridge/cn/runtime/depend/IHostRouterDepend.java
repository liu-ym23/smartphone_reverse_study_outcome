package com.bytedance.sdk.xbridge.cn.runtime.depend;

import android.content.Context;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J8\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J(\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0011\u001a\u00020\u000eH&J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0014"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostRouterDepend;", "", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "xBridgeContext", "", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/a;", "provideRouteOpenHandlerList", "provideRouteOpenExceptionHandler", "", "schema", "", "extraParams", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "openSchema", "containerID", GXTemplateKey.GAIAX_LAYER_PROGRESS_ANIMATED, "closeView", "assembleHandlerChain", "anniex_release"}, k = 1, mv = {1, 4, 3})
public interface IHostRouterDepend {

    public static final class a {
        public static /* synthetic */ void a(IHostRouterDepend r100, IBDXBridgeContext r101) {
            r100.closeView(r101, null, false);
        }
    }

    boolean closeView(IBDXBridgeContext r100, String r101, boolean r102);

    boolean openSchema(IBDXBridgeContext r100, String r101, Map<String, ? extends Object> r102, Context r103);

    com.bytedance.sdk.xbridge.cn.runtime.depend.a provideRouteOpenExceptionHandler(IBDXBridgeContext r100);

    List<com.bytedance.sdk.xbridge.cn.runtime.depend.a> provideRouteOpenHandlerList(IBDXBridgeContext r100);
}
