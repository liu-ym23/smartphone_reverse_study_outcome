package com.larus.caijing_pay.impl.config;

import android.content.SharedPreferences;
import com.bytedance.caijing.sdk.infra.base.api.env.CJHostService;
import com.bytedance.caijing.sdk.infra.base.api.kvstore.CJKVStoreService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ve4.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/caijing_pay/impl/config/CJKVStoreServiceImpl;", "Lcom/bytedance/caijing/sdk/infra/base/api/kvstore/CJKVStoreService;", "<init>", "()V", "getSharedPreference", "Landroid/content/SharedPreferences;", "name", "", "mode", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJKVStoreServiceImpl implements CJKVStoreService {
    public CJKVStoreServiceImpl() {
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.kvstore.CJKVStoreService
    public SharedPreferences getSharedPreference(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        a.f554342a.getClass();
        return ((CJHostService) a.d(CJHostService.class)).getHostApplication().getSharedPreferences(r100, r101);
    }
}
