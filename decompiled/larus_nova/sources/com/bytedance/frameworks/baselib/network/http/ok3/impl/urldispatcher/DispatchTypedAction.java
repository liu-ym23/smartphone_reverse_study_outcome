package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DispatchTypedAction extends URLDispatchAction {
    private static final String TAG = null;
    private DispatchStrategy mDispatchStrategy;

    static {
        TAG = "DispatchTypedAction";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatchAction
    public int getDispatchStrategyType() {
        return this.mDispatchStrategy.getDispatchStrategyType().ordinal();
    }

    public DispatchTypedAction() {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatchAction
    public BaseDispatchAction.DispatchResultEnum dispatch(URLRequest r100, String r101, List<String> r102) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "dispatch action " + this.mDispatchStrategy.getDispatchStrategyType());
    L5:
        BaseDispatchAction.DispatchResultEnum r103 = BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
        Uri r104 = UriProtector.parse(r101);
        if (r104.getHost() != null) goto L8;
    L19:
        return r103;
    L8:
        if (isMatchRules(r104) == false) goto L19;
        DispatchStrategy r105 = this.mDispatchStrategy;
        if (r105 == null) goto L19;
        r103 = BaseDispatchAction.DispatchResultEnum.DISPATCH_HIT;
        if (r105.getDispatchStrategyType() != DispatchStrategy.DispatchStrategyType.REQUEST_HEADER_DISPATCH_STRATEGY) goto L15;
        this.mDispatchStrategy.dispatchRequestHeaders(r100);
        ListProtector.set(r102, 0, r101);
        return r103;
    L15:
        String r106 = this.mDispatchStrategy.getTargetUrl(r104);
        if (r101.equals(r106) == true) goto L18;
        ListProtector.set(r102, 0, r106);
        goto L19
    L18:
        ListProtector.set(r102, 0, r101);
        goto L19
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatchAction
    public void onRequestCompleted(String r100, boolean r101, int r102) {
        this.mDispatchStrategy.notifyRequestResult(r100, r101, r102);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatchAction
    public boolean loadActionParam(JSONObject r110, List<Boolean> r111, String r112, long r113) {
        loadMatchRules(r110);
        String r100 = r110.optString("service_name");
        if (TextUtils.isEmpty(r100) == true) goto L5;
        this.mServiceName = r100;
    L5:
        int r101 = r110.optInt("dispatch_strategy", 0);
        JSONObject r102 = r110.optJSONObject("strategy_info");
        if (r101 >= 0) goto L8;
    L12:
        this.mDispatchStrategy = null;
        return false;
    L8:
        if (r101 > 6) goto L12;
        DispatchStrategy r114 = DispatchStrategy.factory(DispatchStrategy.DispatchStrategyType.values()[r101], r102, r112, r113, getPriority());
        this.mDispatchStrategy = r114;
        ListProtector.set(r111, 0, Boolean.valueOf(r114.needRequestResultFeedback()));
        return true;
    }
}
