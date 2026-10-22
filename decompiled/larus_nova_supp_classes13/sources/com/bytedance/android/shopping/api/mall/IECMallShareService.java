package com.bytedance.android.shopping.api.mall;

import android.content.Context;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/IECMallShareService;", "", "Landroid/content/Context;", "context", "Lorg/json/JSONObject;", "params", "Lcom/bytedance/android/shopping/api/mall/e;", "callback", "", "directJsbShare", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECMallShareService {
    void directJsbShare(Context r1, JSONObject r2, e r3);
}
