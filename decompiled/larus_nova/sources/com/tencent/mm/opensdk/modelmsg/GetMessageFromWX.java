package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

/* JADX INFO: loaded from: classes40.dex */
public final class GetMessageFromWX {

    public static class Req extends BaseReq {
        public String country;
        public String lang;
        public String username;

        public Req() {
        }

        public Req(Bundle r100) {
            fromBundle(r100);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle r100) {
            super.fromBundle(r100);
            this.lang = r100.getString("_wxapi_getmessage_req_lang");
            this.country = r100.getString("_wxapi_getmessage_req_country");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 3;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString("_wxapi_getmessage_req_lang", this.lang);
            r100.putString("_wxapi_getmessage_req_country", this.country);
        }
    }

    public static class Resp extends BaseResp {
        private static final String TAG = "MicroMsg.SDK.GetMessageFromWX.Resp";
        public WXMediaMessage message;

        public Resp() {
        }

        public Resp(Bundle r100) {
            fromBundle(r100);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            WXMediaMessage r100 = this.message;
            if (r100 != null) goto L7;
            Log.e(TAG, "checkArgs fail, message is null");
            return false;
        L7:
            return r100.checkArgs();
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle r100) {
            super.fromBundle(r100);
            this.message = WXMediaMessage.Builder.fromBundle(r100);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 3;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putAll(WXMediaMessage.Builder.toBundle(this.message));
        }
    }

    private GetMessageFromWX() {
    }
}
