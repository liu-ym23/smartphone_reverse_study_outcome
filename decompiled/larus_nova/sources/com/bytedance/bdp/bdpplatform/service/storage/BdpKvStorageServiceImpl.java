package com.bytedance.bdp.bdpplatform.service.storage;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdp.serviceapi.defaults.storage.BdpKVStorageService;

/* JADX INFO: loaded from: classes3.dex */
public class BdpKvStorageServiceImpl implements BdpKVStorageService {
    public BdpKvStorageServiceImpl() {
    }

    @Override // com.bytedance.bdp.serviceapi.defaults.storage.BdpKVStorageService
    public final SharedPreferences h(Context r100, String r101) {
        return r100.getSharedPreferences(r101, 4);
    }
}
