package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import java.util.HashMap;

/* JADX INFO: loaded from: classes40.dex */
public class WXOpenBusinessWebview {

    public static class Req extends BaseReq {
        public int businessType;
        public HashMap<String, String> queryInfo;

        public Req() {
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle r100) {
            super.fromBundle(r100);
            this.queryInfo = (HashMap) r100.getSerializable("_wxapi_open_business_webview_query_info");
            this.businessType = r100.getInt("_wxapi_open_business_webview_query_type", 0);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 25;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putSerializable("_wxapi_open_business_webview_query_info", this.queryInfo);
            r100.putInt("_wxapi_open_business_webview_query_type", this.businessType);
        }
    }

    public static class Resp extends BaseResp {
        public int businessType;
        public String resultInfo;

        public Resp() {
        }

        public Resp(Bundle r100) {
            fromBundle(r100);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle r100) {
            super.fromBundle(r100);
            this.resultInfo = r100.getString("_wxapi_open_business_webview_result");
            this.businessType = r100.getInt("_wxapi_open_business_webview_query_type", 0);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 25;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString("_wxapi_open_business_webview_result", this.resultInfo);
            r100.putInt("_wxapi_open_business_webview_query_type", this.businessType);
        }
    }

    public WXOpenBusinessWebview() {
    }
}
