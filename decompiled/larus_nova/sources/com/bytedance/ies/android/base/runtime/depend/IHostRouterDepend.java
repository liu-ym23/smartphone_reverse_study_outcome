package com.bytedance.ies.android.base.runtime.depend;

import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "已废弃", replaceWith = @ReplaceWith(expression = "com.bytedance.android.ad.sdk.api.router.IAdRouterDepend", imports = {}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/android/base/runtime/depend/IHostRouterDepend;", "", "isHostScheme", "", "schema", "", "openHostScheme", RuleConditionBean.OPEN_URL_KEY, "runtime-api_release"}, k = 1, mv = {1, 1, 16})
public interface IHostRouterDepend {
    boolean isHostScheme(String r100);

    boolean openHostScheme(String r100);
}
