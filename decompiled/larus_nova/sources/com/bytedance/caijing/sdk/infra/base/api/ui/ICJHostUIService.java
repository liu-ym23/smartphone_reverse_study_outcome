package com.bytedance.caijing.sdk.infra.base.api.ui;

import android.app.Activity;
import android.content.Context;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/ui/ICJHostUIService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "showToast", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/app/Activity;", "text", "", "Landroid/content/Context;", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJHostUIService extends ICJService {
    void showToast(Activity r100, String r101);

    void showToast(Context r100, String r101);
}
