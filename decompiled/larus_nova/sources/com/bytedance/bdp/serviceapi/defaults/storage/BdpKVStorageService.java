package com.bytedance.bdp.serviceapi.defaults.storage;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdp.bdpbase.service.IBdpService;

/* JADX INFO: loaded from: classes3.dex */
public interface BdpKVStorageService extends IBdpService {
    SharedPreferences h(Context r100, String r101);
}
