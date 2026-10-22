package com.bytedance.caijing.sdk.biz.pay;

import com.bytedance.caijing.sdk.biz.pay.api.CJPayApiService;
import com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import vc4.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/caijing/sdk/biz/pay/CJPayApiServiceImpl;", "Lcom/bytedance/caijing/sdk/biz/pay/api/CJPayApiService;", "Lcom/bytedance/caijing/sdk/biz/pay/api/ITTCJPayUtilsCompat;", "getTTCJPayUtilsCompat", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "cjpay-se-impl_release"}, k = 1, mv = {1, 6, 0})
public final class CJPayApiServiceImpl implements CJPayApiService {
    public static final a Companion = null;
    private static final String TAG = "CJPayApiServiceImpl000";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.CJPayApiService
    public ITTCJPayUtilsCompat getTTCJPayUtilsCompat() {
        return new b();
    }

    public CJPayApiServiceImpl() {
    }
}
