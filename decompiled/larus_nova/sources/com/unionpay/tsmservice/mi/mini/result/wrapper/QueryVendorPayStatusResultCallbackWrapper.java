package com.unionpay.tsmservice.mi.mini.result.wrapper;

import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Base64;
import com.unionpay.tsmservice.mi.mini.ITsmCallback;
import com.unionpay.tsmservice.mi.mini.result.QueryVendorPayStatusResult;

/* JADX INFO: loaded from: classes41.dex */
public class QueryVendorPayStatusResultCallbackWrapper extends BaseResultCallbackWrapper {
    public QueryVendorPayStatusResultCallbackWrapper(int r100, ITsmCallback r101) {
        super(r100, r101);
    }

    private void getCallbackResultData(Bundle r100) {
        Parcel r101 = Parcel.obtain();
        String r102 = r100.getString("result");
        if (TextUtils.isEmpty(r102) == true) goto L13;
        byte[] r103 = Base64.decode(r102, 0);
        if (r103 == null) goto L10;
        if (r103.length == 0) goto L10;
        r101.unmarshall(r103, 0, r103.length);
        r101.setDataPosition(0);
    L10:
        if (r101.dataSize() != 0) goto L12;
        r100.putString("errorCode", "010001");
        goto L13
    L12:
        QueryVendorPayStatusResult r104 = (QueryVendorPayStatusResult) r101.readParcelable(QueryVendorPayStatusResult.class.getClassLoader());
        r100.putString("errorCode", "10000");
        r100.putParcelable("result", r104);
    L13:
        r101.recycle();
    }

    @Override // com.unionpay.tsmservice.mi.mini.result.wrapper.BaseResultCallbackWrapper
    public Bundle convertResult(Bundle r100) {
        new QueryVendorPayStatusResult().f462183a = r100;
        getCallbackResultData(r100);
        return r100;
    }
}
