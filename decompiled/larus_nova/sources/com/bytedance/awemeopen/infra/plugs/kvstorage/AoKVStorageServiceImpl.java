package com.bytedance.awemeopen.infra.plugs.kvstorage;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.awemeopen.servicesapi.storage.AoKVStorageService;
import e64.c;

/* JADX INFO: loaded from: classes46.dex */
public class AoKVStorageServiceImpl implements AoKVStorageService {
    public AoKVStorageServiceImpl() {
    }

    @Override // com.bytedance.awemeopen.servicesapi.storage.AoKVStorageService
    public final SharedPreferences h(Context r100, String r101) {
        return new c(r100, r101);
    }
}
