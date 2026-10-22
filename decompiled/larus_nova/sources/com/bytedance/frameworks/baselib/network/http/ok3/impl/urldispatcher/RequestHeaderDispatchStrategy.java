package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.retrofit2.client.Header;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class RequestHeaderDispatchStrategy extends DispatchStrategy {
    private static final String TAG = null;
    private Map<String, String> mAddHeaderMap;

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public boolean needRequestResultFeedback() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public void notifyRequestResult(String r100, boolean r101, int r102) {
    }

    static {
        TAG = "RequestHeaderDispatchStrategy";
    }

    public RequestHeaderDispatchStrategy(JSONObject r100) {
        super(DispatchStrategy.DispatchStrategyType.REQUEST_HEADER_DISPATCH_STRATEGY);
        this.mAddHeaderMap = new HashMap();
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
        this.mAddHeaderMap.put(r102, r103);
        goto L7
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public void dispatchRequestHeaders(URLRequest r100) {
        if (r100.getHeaders() == null) goto L8;
        Iterator<Map.Entry<String, String>> r101 = this.mAddHeaderMap.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        Map.Entry<String, String> r102 = r101.next();
        r100.getHeaders().add(new Header(r102.getKey(), r102.getValue()));
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public String getTargetUrl(Uri r100) {
        return r100.toString();
    }
}
