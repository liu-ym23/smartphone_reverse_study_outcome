package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

/* JADX INFO: loaded from: classes40.dex */
public class ChooseCardFromWXCardPackage {
    private static final String TAG = "MicroMsg.ChooseCardFromWXCardPackage";

    public static class Req extends BaseReq {
        public String appId;
        public String canMultiSelect;
        public String cardId;
        public String cardSign;
        public String cardType;
        public String locationId;
        public String nonceStr;
        public String signType;
        public String timeStamp;

        public Req() {
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            String r100 = this.appId;
            if (r100 != null) goto L5;
        L19:
            return false;
        L5:
            if (r100.length() <= 0) goto L19;
            String r101 = this.signType;
            if (r101 == null) goto L19;
            if (r101.length() <= 0) goto L19;
            String r102 = this.cardSign;
            if (r102 == null) goto L19;
            if (r102.length() <= 0) goto L19;
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 16;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString("_wxapi_choose_card_from_wx_card_app_id", this.appId);
            r100.putString("_wxapi_choose_card_from_wx_card_location_id", this.locationId);
            r100.putString("_wxapi_choose_card_from_wx_card_sign_type", this.signType);
            r100.putString("_wxapi_choose_card_from_wx_card_card_sign", this.cardSign);
            r100.putString("_wxapi_choose_card_from_wx_card_time_stamp", this.timeStamp);
            r100.putString("_wxapi_choose_card_from_wx_card_nonce_str", this.nonceStr);
            r100.putString("_wxapi_choose_card_from_wx_card_card_id", this.cardId);
            r100.putString("_wxapi_choose_card_from_wx_card_card_type", this.cardType);
            r100.putString("_wxapi_choose_card_from_wx_card_can_multi_select", this.canMultiSelect);
        }
    }

    public static class Resp extends BaseResp {
        public String cardItemList;

        public Resp() {
        }

        public Resp(Bundle r100) {
            fromBundle(r100);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            String r100 = this.cardItemList;
            if (r100 != null) goto L5;
            return false;
        L5:
            if (r100.length() == 0) goto L11;
            return true;
        L11:
            return false;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle r100) {
            super.fromBundle(r100);
            String r101 = r100.getString("_wxapi_choose_card_from_wx_card_list");
            if (r101 != null) goto L5;
        L7:
            Log.i(ChooseCardFromWXCardPackage.TAG, "cardItemList is empty!");
            return;
        L5:
            if (r101.length() <= 0) goto L7;
            this.cardItemList = r101;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 16;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString("_wxapi_choose_card_from_wx_card_list", this.cardItemList);
        }
    }

    public ChooseCardFromWXCardPackage() {
    }
}
