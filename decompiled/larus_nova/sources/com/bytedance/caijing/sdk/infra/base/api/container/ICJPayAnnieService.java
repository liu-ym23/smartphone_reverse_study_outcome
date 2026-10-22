package com.bytedance.caijing.sdk.infra.base.api.container;

import android.content.Context;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/container/ICJPayAnnieService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "getBid", "", "getXElement", "", "", PerfLog.PARAM_KEY_CONTEXT_ID, "init", "", "Landroid/content/Context;", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPayAnnieService extends ICJService {
    String getBid();

    List<Object> getXElement(Object r100);

    void init(Context r100);
}
