package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;

/* JADX INFO: loaded from: classes40.dex */
public class OpenBusiLuckyMoney {

    public static class Req extends BaseReq {
        private static final int MAX_URL_LENGHT = 10240;
        public String appId;
        public String nonceStr;
        public String packageExt;
        public String signType;
        public String signature;
        public String timeStamp;

        public Req() {
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            String r100 = this.appId;
            if (r100 != null) goto L5;
        L29:
            return false;
        L5:
            if (r100.length() <= 0) goto L29;
            String r101 = this.timeStamp;
            if (r101 == null) goto L29;
            if (r101.length() <= 0) goto L29;
            String r102 = this.nonceStr;
            if (r102 == null) goto L29;
            if (r102.length() <= 0) goto L29;
            String r103 = this.signType;
            if (r103 == null) goto L29;
            if (r103.length() <= 0) goto L29;
            String r104 = this.signature;
            if (r104 == null) goto L29;
            if (r104.length() <= 0) goto L29;
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 13;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString("_wxapi_open_busi_lucky_money_appid", this.appId);
            r100.putString("_wxapi_open_busi_lucky_money_timeStamp", this.timeStamp);
            r100.putString("_wxapi_open_busi_lucky_money_nonceStr", this.nonceStr);
            r100.putString("_wxapi_open_busi_lucky_money_signType", this.signType);
            r100.putString("_wxapi_open_busi_lucky_money_signature", this.signature);
            r100.putString("_wxapi_open_busi_lucky_money_package", this.packageExt);
        }
    }

    public OpenBusiLuckyMoney() {
    }
}
