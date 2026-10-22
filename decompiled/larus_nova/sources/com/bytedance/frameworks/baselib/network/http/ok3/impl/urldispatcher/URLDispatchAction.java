package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class URLDispatchAction extends BaseDispatchAction {
    private static final String TAG = null;
    private boolean mNeedRequestResultFeedBack;

    public abstract BaseDispatchAction.DispatchResultEnum dispatch(URLRequest r100, String r101, List<String> r102);

    public abstract int getDispatchStrategyType();

    public int getTcTypedDropCode() {
        return -555;
    }

    public abstract boolean loadActionParam(JSONObject r100, List<Boolean> r101, String r102, long r103);

    public abstract void onRequestCompleted(String r100, boolean r101, int r102);

    static {
        TAG = "URLDispatchAction";
    }

    public URLDispatchAction() {
        this.mNeedRequestResultFeedBack = false;
    }

    public boolean needRequestResultFeedBack() {
        return this.mNeedRequestResultFeedBack;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.BaseDispatchAction
    public boolean initWithActionParam(JSONObject r100, String r110, long r111) {
        ArrayList r101 = new ArrayList();
        ListProtector.add(r101, 0, Boolean.FALSE);
        boolean r102 = loadActionParam(r100, r101, r110, r111);
        this.mNeedRequestResultFeedBack = ((Boolean) ListProtector.get(r101, 0)).booleanValue();
        return r102;
    }

    public void notifyRequestCompleted(String r100, boolean r101, int r102) {
        if (this.mNeedRequestResultFeedBack == true) goto L5;
        return;
    L5:
        onRequestCompleted(r100, r101, r102);
    }

    public BaseDispatchAction.DispatchResultEnum takeAction(URLRequest r100, String r101, List<String> r102, List<DispatchActionInfo> r103) {
        if (isActionEffective(r100) == true) goto L5;
    L15:
        ListProtector.set(r102, 0, r101);
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L15;
        BaseDispatchAction.DispatchResultEnum r104 = dispatch(r100, r101, r102);
        DispatchActionInfo r105 = new DispatchActionInfo();
        if (r104 == BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE) goto L13;
        r105.mActionHit = true;
        r105.mRuleid = getRuleId();
        r105.mPriority = getPriority();
        r105.mStrategyType = getDispatchStrategyType();
        r105.mServiceName = getServiceName();
        if (r104 != BaseDispatchAction.DispatchResultEnum.DISPATCH_HIT) goto L12;
        r105.mDispatchedUrl = (String) ListProtector.get(r102, 0);
        r105.mNeedFeedBack = needRequestResultFeedBack();
    L12:
        r100.setDispatchPriority(this.mSetReqPriority);
    L13:
        r103.add(r105);
        return r104;
    }
}
