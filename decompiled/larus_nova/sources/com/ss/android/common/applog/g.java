package com.ss.android.common.applog;

import com.bytedance.bdinstall.RangersHttpException;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final class g implements com.bytedance.bdinstall.g0 {
    public g() {
    }

    @Override // com.bytedance.bdinstall.g0
    public final String get(String r100, Map<String, String> r101) throws RangersHttpException {
        return NetworkClient.getDefault().get(r100, r101, null);
    L4:
        e = move-exception;
        if ((e instanceof CommonHttpException) == false) goto L10;
        CommonHttpException r102 = (CommonHttpException) e;
        throw new RangersHttpException(r102.getResponseCode(), r102.getCause());
    L10:
        throw new RangersHttpException(400, e.getCause());
    }

    @Override // com.bytedance.bdinstall.g0
    public final String post(String r100, byte[] r101, Map<String, String> r102) throws RangersHttpException {
        return NetworkClient.getDefault().post(r100, r101, r102, null);
    L4:
        e = move-exception;
        throw new RangersHttpException(e.getResponseCode(), e.getCause());
    }

    @Override // com.bytedance.bdinstall.g0
    public final byte[] postStream(String r100, byte[] r101, Map<String, String> r102) throws RangersHttpException {
        return NetworkClient.getDefault().postDataStream(r100, r101, r102, null);
    L4:
        e = move-exception;
        throw new RangersHttpException(e.getResponseCode(), e.getCause());
    }
}
