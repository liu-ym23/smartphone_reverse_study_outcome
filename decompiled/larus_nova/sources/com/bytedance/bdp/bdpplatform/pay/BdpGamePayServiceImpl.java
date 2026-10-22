package com.bytedance.bdp.bdpplatform.pay;

import android.app.Activity;
import com.byted.mgl.merge.service.api.pay.BdpGamePayService;
import com.byted.mgl.merge.service.api.pay.GameClientPayListener;
import com.byted.mgl.merge.service.api.pay.model.WxGamePayParamEntity;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/bdp/bdpplatform/pay/BdpGamePayServiceImpl;", "Lcom/byted/mgl/merge/service/api/pay/BdpGamePayService;", "<init>", "()V", "bdp-service_release"}, k = 1, mv = {1, 4, 0})
public final class BdpGamePayServiceImpl implements BdpGamePayService {
    public BdpGamePayServiceImpl() {
    }

    @Override // com.byted.mgl.merge.service.api.pay.BdpGamePayService
    public final boolean isSupportAliPay() {
        return false;
    }

    @Override // com.byted.mgl.merge.service.api.pay.BdpGamePayService
    public final boolean isSupportWXPay() {
        return false;
    }

    @Override // com.byted.mgl.merge.service.api.pay.BdpGamePayService
    public final void doWXPay(Activity r100, WxGamePayParamEntity r101, GameClientPayListener r102) {
        r102.onFailed("host not impl...");
    }

    @Override // com.byted.mgl.merge.service.api.pay.BdpGamePayService
    public final void doAliPay(Activity r100, String r101, GameClientPayListener r102, String r103) {
        r102.onFailed("host not impl...");
    }
}
