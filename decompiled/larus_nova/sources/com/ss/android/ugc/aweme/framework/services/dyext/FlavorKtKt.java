package com.ss.android.ugc.aweme.framework.services.dyext;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"loadPlugin", "Lcom/ss/android/ugc/aweme/framework/services/dyext/LoadPluginFeature;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "pluginNames", "", "", "(Landroid/content/Context;[Ljava/lang/String;)Lcom/ss/android/ugc/aweme/framework/services/dyext/LoadPluginFeature;", "dy-ext-spi-dummy_release"}, k = 2, mv = {1, 1, 15})
public final class FlavorKtKt {
    @Deprecated(level = DeprecationLevel.WARNING, message = "该方法已废弃", replaceWith = @ReplaceWith(expression = "ServiceManagerExt.loadPlugin(pluginNames)", imports = {}))
    public static final LoadPluginFeature loadPlugin(Context r100, String... r101) {
        return new LoadPluginFeature();
    }
}
