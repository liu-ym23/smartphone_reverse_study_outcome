package hlc;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ProviderEffect;

/* JADX INFO: loaded from: classes36.dex */
public interface b extends IEffectPlatformBaseListener<ProviderEffect> {
    void onProgress(ProviderEffect r100, int r101, long r102);
}
