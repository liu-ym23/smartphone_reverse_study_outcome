package com.bytedance.caijing.sdk.infra.base.api.lottie;

import android.content.Context;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/lottie/CJLottieService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "createLottieView", "Lcom/bytedance/caijing/sdk/infra/base/api/lottie/ILottieAnimationView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isLottieJson", "", "jsonObject", "Lorg/json/JSONObject;", "preloadFromUrl", "", "url", "", "preloadFromUrlSync", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJLottieService extends ICJService {
    ILottieAnimationView createLottieView(Context r100);

    boolean isLottieJson(JSONObject r100);

    void preloadFromUrl(Context r100, String r101);

    boolean preloadFromUrlSync(Context r100, String r101);
}
