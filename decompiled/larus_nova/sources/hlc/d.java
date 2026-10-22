package hlc;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.Effect;

/* JADX INFO: loaded from: classes5.dex */
public interface d extends IEffectPlatformBaseListener<Effect> {
    void onProgress(Effect r100, int r101, long r102);

    void onStart(Effect r100);
}
