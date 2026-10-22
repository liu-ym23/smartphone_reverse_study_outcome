package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class StaticDispatchStrategy extends DispatchStrategy {
    private static final String TAG = null;
    private Map<String, String> mHostMap;

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public void dispatchRequestHeaders(URLRequest r100) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public boolean needRequestResultFeedback() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public void notifyRequestResult(String r100, boolean r101, int r102) {
    }

    static {
        TAG = "StaticDispatchStrategy";
    }

    public StaticDispatchStrategy(JSONObject r100) {
        super(DispatchStrategy.DispatchStrategyType.STATIC_DISPATCH_STRATEGY);
        this.mHostMap = new HashMap();
        if (r100 != null) goto L5;
        return;
    L5:
        Iterator<String> r101 = r100.keys();
    L7:
        if (r101.hasNext() == false) goto L13;
        String r102 = r101.next();
        String r103 = r100.optString(r102);
        if (TextUtils.isEmpty(r102) == true) goto L7;
        if (TextUtils.isEmpty(r103) == true) goto L7;
        this.mHostMap.put(r102, r103);
        goto L7
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public String getTargetUrl(Uri r100) {
        String r101 = r100.getHost();
        String r102 = r100.toString();
        String r103 = this.mHostMap.get(r101);
        if (TextUtils.isEmpty(r103) == false) goto L5;
        return r102;
    L5:
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "replace host " + r103 + " for " + r101);
    L8:
        return r102.replaceFirst(r101, r103);
    }
}
