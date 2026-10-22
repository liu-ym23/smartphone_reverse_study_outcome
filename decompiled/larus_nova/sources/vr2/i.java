package vr2;

import android.content.res.Resources;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.scope.o;
import com.bytedance.common.jato.views.JatoOptDrawableCache;

/* JADX INFO: loaded from: classes11.dex */
public final class i implements o, c {
    public i() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // vr2.c
    public final boolean V4() {
        return LiveInfraSettingKeys.LIVE_XML_AND_DRAWABLE_CACHE_CONFIG.getValue().a();
    }

    @Override // vr2.c
    public final void A2(Resources r100, int[] r101) {
        JatoOptDrawableCache.preloadDrawableCache(r100, r101);     // Catch: Exception -> L4
        return;
    }
}
