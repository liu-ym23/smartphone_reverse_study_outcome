package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;

/* JADX INFO: loaded from: classes40.dex */
public class ShowMessageFromWX {

    public static class Req extends BaseReq {
        public String country;
        public String lang;
        public WXMediaMessage message;

        public Req() {
        }

        public Req(Bundle r100) {
            fromBundle(r100);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            WXMediaMessage r100 = this.message;
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.checkArgs();
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle r100) {
            super.fromBundle(r100);
            this.lang = r100.getString("_wxapi_showmessage_req_lang");
            this.country = r100.getString("_wxapi_showmessage_req_country");
            this.message = WXMediaMessage.Builder.fromBundle(r100);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 4;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle r100) {
            Bundle r101 = WXMediaMessage.Builder.toBundle(this.message);
            super.toBundle(r101);
            r100.putString("_wxapi_showmessage_req_lang", this.lang);
            r100.putString("_wxapi_showmessage_req_country", this.country);
            r100.putAll(r101);
        }
    }

    public static class Resp extends BaseResp {
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
        public int getType() {
            return 4;
        }
    }

    private ShowMessageFromWX() {
    }
}
