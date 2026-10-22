package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

/* JADX INFO: loaded from: classes40.dex */
public final class SubscribeMiniProgramMsg {

    public static class Req extends BaseReq {
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "MicroMsg.SDK.SubscribeMessage.Req";
        public String miniProgramAppId;

        public Req() {
        }

        public Req(Bundle r100) {
            fromBundle(r100);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            String r100 = this.miniProgramAppId;
            if (r100 != null) goto L5;
        L9:
            Log.e(TAG, "checkArgs fail, miniProgramAppId is null");
            return false;
        L5:
            if (r100.length() == 0) goto L9;
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle r100) {
            super.fromBundle(r100);
            this.miniProgramAppId = r100.getString("_wxapi_subscribeminiprogram_req_miniprogramappid");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 23;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString("_wxapi_subscribeminiprogram_req_miniprogramappid", this.miniProgramAppId);
        }
    }

    public static class Resp extends BaseResp {
        private static final String TAG = "MicroMsg.SDK.SubscribeMessage.Resp";
        public String nickname;
        public String unionId;

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
            this.unionId = r100.getString("_wxapi_subscribeminiprogram_resp_unionId");
            this.nickname = r100.getString("_wxapi_subscribeminiprogram_resp_nickname");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 23;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString("_wxapi_subscribeminiprogram_resp_unionId", this.unionId);
            r100.putString("_wxapi_subscribeminiprogram_resp_nickname", this.nickname);
        }
    }

    private SubscribeMiniProgramMsg() {
    }
}
