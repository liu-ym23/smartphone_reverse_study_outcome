package com.ss.ugc.effectplatform.listener;

import com.bytedance.android.ec.core.event.a;
import com.facebook.keyframes.model.KFFeature;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.ProviderEffect;
import com.ss.ugc.effectplatform.model.net.GifProviderEffectListResponse;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J2\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nH&J\u0016\u0010\u000b\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¨\u0006\r"}, d2 = {"Lcom/ss/ugc/effectplatform/listener/IDownloadProviderEffectListListener;", "Lcom/ss/ugc/effectplatform/listener/IEffectPlatformBaseListener;", "Lcom/ss/ugc/effectplatform/model/net/GifProviderEffectListResponse;", "onDownloadFailed", "", "successfulEffects", "", "Lcom/ss/ugc/effectplatform/model/ProviderEffect;", "failedEffects", a.KEY_EXCEPTION, "Lcom/ss/ugc/effectplatform/model/ExceptionResult;", "onDownloadSuccess", KFFeature.EFFECT_JSON_FIELD, "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public interface IDownloadProviderEffectListListener extends IEffectPlatformBaseListener<GifProviderEffectListResponse> {
    void onDownloadFailed(List<? extends ProviderEffect> r100, List<? extends ProviderEffect> r101, ExceptionResult r102);

    void onDownloadSuccess(List<? extends ProviderEffect> r100);
}
