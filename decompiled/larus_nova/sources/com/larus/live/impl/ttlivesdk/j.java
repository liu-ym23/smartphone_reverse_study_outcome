package com.larus.live.impl.ttlivesdk;

import android.content.Context;
import com.bytedance.android.livehostapi.business.IHostMiniApp;
import com.bytedance.android.livehostapi.business.MiniAppPreloadListener;
import com.bytedance.android.livehostapi.business.depend.miniapp.AnchorLiveData;
import com.bytedance.android.livehostapi.business.depend.miniapp.MiniAppParams;
import java.util.Map;

/* JADX INFO: loaded from: classes30.dex */
public final class j implements IHostMiniApp {
    public j() {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostMiniApp
    public final boolean openMiniApp(Context r100, String r101, boolean r102, MiniAppParams r103, AnchorLiveData r104) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostMiniApp
    public final void preloadMiniApp(String r100, Map<String, String> r101, MiniAppPreloadListener r102) {
    }
}
