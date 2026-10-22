package com.bytedance.caijing.sdk.infra.base.impl.lottie;

import android.content.Context;
import com.airbnb.lottie.LottieCompositionFactory;
import com.bytedance.caijing.sdk.infra.base.api.lottie.CJLottieService;
import com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import qf4.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/impl/lottie/CJLottieServiceImpl;", "Lcom/bytedance/caijing/sdk/infra/base/api/lottie/CJLottieService;", "()V", "createLottieView", "Lcom/bytedance/caijing/sdk/infra/base/api/lottie/ILottieAnimationView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isLottieJson", "", "jsonObject", "Lorg/json/JSONObject;", "preloadFromUrl", "", "url", "", "preloadFromUrlSync", "cj-host-service-impl-lottie_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJLottieServiceImpl implements CJLottieService {
    public CJLottieServiceImpl() {
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.CJLottieService
    public ILottieAnimationView createLottieView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new a(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.CJLottieService
    public boolean isLottieJson(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        if (LottieCompositionFactory.fromJsonSync(r100, null).f24812a == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.CJLottieService
    public void preloadFromUrl(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        LottieCompositionFactory.fromUrl(r100, r101);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.CJLottieService
    public boolean preloadFromUrlSync(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        if (LottieCompositionFactory.fromUrlSync(r100, r101).f24812a == null) goto L5;
        return true;
    L5:
        return false;
    }
}
