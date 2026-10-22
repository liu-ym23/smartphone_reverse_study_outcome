package com.bytedance.caijing.sdk.infra.base.api.container.ttpay_container;

import android.content.Context;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/container/ttpay_container/ITTPayAnnieContainer;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "getBid", "", "init", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ITTPayAnnieContainer extends ICJService {
    String getBid();

    void init(Context r100);
}
