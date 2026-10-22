package com.bytedance.caijing.sdk.infra.base.api.ohr;

import android.view.MotionEvent;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/ohr/OHRService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "feedMotionEvent", "", "ev", "Landroid/view/MotionEvent;", "getSmartOHRExperimentMinInterval", "", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OHRService extends ICJService {
    void feedMotionEvent(MotionEvent r100);

    long getSmartOHRExperimentMinInterval();
}
