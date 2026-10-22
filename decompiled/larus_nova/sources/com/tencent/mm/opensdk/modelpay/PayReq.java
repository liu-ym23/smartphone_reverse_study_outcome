package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.mm.opensdk.channel.a.a;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;

/* JADX INFO: loaded from: classes40.dex */
public class PayReq extends BaseReq {
    private static final int EXTDATA_MAX_LENGTH = 1024;
    private static final String TAG = "MicroMsg.PaySdk.PayReq";
    public String appId;
    public String extData;
    public String nonceStr;
    public Options options;
    public String packageValue;
    public String partnerId;
    public String prepayId;
    public String sign;
    public String signType;
    public String timeStamp;

    public static class Options {
        public static final int INVALID_FLAGS = -1;
        public String callbackClassName;
        public int callbackFlags;

        public Options() {
            this.callbackFlags = -1;
        }

        public void fromBundle(Bundle r100) {
            this.callbackClassName = a.a(r100, "_wxapi_payoptions_callback_classname");
            this.callbackFlags = a.a(r100, "_wxapi_payoptions_callback_flags", -1);
        }

        public void toBundle(Bundle r100) {
            r100.putString("_wxapi_payoptions_callback_classname", this.callbackClassName);
            r100.putInt("_wxapi_payoptions_callback_flags", this.callbackFlags);
        }
    }

    public PayReq() {
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseReq
    public boolean checkArgs() {
        String r100 = this.appId;
        if (r100 != null) goto L5;
    L52:
        String r101 = "checkArgs fail, invalid appId";
    L42:
        Log.e(TAG, r101);
        return false;
    L5:
        if (r100.length() == 0) goto L52;
        String r102 = this.partnerId;
        if (r102 != null) goto L10;
    L51:
        r101 = "checkArgs fail, invalid partnerId";
        goto L42
    L10:
        if (r102.length() == 0) goto L51;
        String r103 = this.prepayId;
        if (r103 != null) goto L15;
    L50:
        r101 = "checkArgs fail, invalid prepayId";
        goto L42
    L15:
        if (r103.length() == 0) goto L50;
        String r104 = this.nonceStr;
        if (r104 != null) goto L20;
    L49:
        r101 = "checkArgs fail, invalid nonceStr";
        goto L42
    L20:
        if (r104.length() == 0) goto L49;
        String r105 = this.timeStamp;
        if (r105 != null) goto L25;
    L48:
        r101 = "checkArgs fail, invalid timeStamp";
        goto L42
    L25:
        if (r105.length() == 0) goto L48;
        String r106 = this.packageValue;
        if (r106 != null) goto L30;
    L47:
        r101 = "checkArgs fail, invalid packageValue";
        goto L42
    L30:
        if (r106.length() == 0) goto L47;
        String r107 = this.sign;
        if (r107 != null) goto L35;
    L46:
        r101 = "checkArgs fail, invalid sign";
        goto L42
    L35:
        if (r107.length() == 0) goto L46;
        String r108 = this.extData;
        if (r108 != null) goto L40;
        return true;
    L40:
        if (r108.length() <= 1024) goto L53;
        r101 = "checkArgs fail, extData length too long";
        goto L42
    L53:
        return true;
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseReq
    public void fromBundle(Bundle r100) {
        super.fromBundle(r100);
        this.appId = a.a(r100, "_wxapi_payreq_appid");
        this.partnerId = a.a(r100, "_wxapi_payreq_partnerid");
        this.prepayId = a.a(r100, "_wxapi_payreq_prepayid");
        this.nonceStr = a.a(r100, "_wxapi_payreq_noncestr");
        this.timeStamp = a.a(r100, "_wxapi_payreq_timestamp");
        this.packageValue = a.a(r100, "_wxapi_payreq_packagevalue");
        this.sign = a.a(r100, "_wxapi_payreq_sign");
        this.extData = a.a(r100, "_wxapi_payreq_extdata");
        this.signType = a.a(r100, "_wxapi_payreq_sign_type");
        Options r101 = new Options();
        this.options = r101;
        r101.fromBundle(r100);
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseReq
    public int getType() {
        return 5;
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseReq
    public void toBundle(Bundle r100) {
        super.toBundle(r100);
        r100.putString("_wxapi_payreq_appid", this.appId);
        r100.putString("_wxapi_payreq_partnerid", this.partnerId);
        r100.putString("_wxapi_payreq_prepayid", this.prepayId);
        r100.putString("_wxapi_payreq_noncestr", this.nonceStr);
        r100.putString("_wxapi_payreq_timestamp", this.timeStamp);
        r100.putString("_wxapi_payreq_packagevalue", this.packageValue);
        r100.putString("_wxapi_payreq_sign", this.sign);
        r100.putString("_wxapi_payreq_extdata", this.extData);
        r100.putString("_wxapi_payreq_sign_type", this.signType);
        Options r101 = this.options;
        if (r101 == null) goto L6;
        r101.toBundle(r100);
        return;
    }
}
