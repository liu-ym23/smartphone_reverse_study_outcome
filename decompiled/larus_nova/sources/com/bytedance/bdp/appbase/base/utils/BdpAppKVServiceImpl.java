package com.bytedance.bdp.appbase.base.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.defaults.storage.BdpKVStorageService;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class BdpAppKVServiceImpl implements BdpAppKVService {
    public BdpAppKVServiceImpl() {
    }

    static {
        new ConcurrentHashMap();
    }

    @Override // com.bytedance.bdp.appbase.base.utils.BdpAppKVService
    public final SharedPreferences l2(Context r100, String r101) {
        if (q94.a.f532096b == false) goto L6;
        g94.b.a("BdpAppKVServiceImpl", new Object[]{"Use BDP impl sp."});
    L6:
        return ((BdpKVStorageService) BdpManager.getInst().getService(BdpKVStorageService.class)).h(r100, "com.tt.miniapp.shared_prefs_prefix_".concat(r101));
    }
}
