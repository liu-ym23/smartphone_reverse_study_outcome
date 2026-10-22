package com.bytedance.caijing.sdk.infra.base.api.kvstore;

import android.content.SharedPreferences;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/kvstore/CJKVStoreService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "getSharedPreference", "Landroid/content/SharedPreferences;", "name", "", "mode", "", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJKVStoreService extends ICJService {
    SharedPreferences getSharedPreference(String r100, int r101);
}
