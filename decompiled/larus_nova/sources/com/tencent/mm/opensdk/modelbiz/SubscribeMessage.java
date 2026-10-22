package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

/* JADX INFO: loaded from: classes40.dex */
public final class SubscribeMessage {

    public static class Req extends BaseReq {
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "MicroMsg.SDK.SubscribeMessage.Req";
        public String reserved;
        public int scene;
        public String templateID;

        public Req() {
        }

        public Req(Bundle r100) {
            fromBundle(r100);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            String r100 = this.templateID;
            if (r100 != null) goto L5;
        L19:
            String r101 = "checkArgs fail, templateID is null";
        L10:
            Log.e(TAG, r101);
            return false;
        L5:
            if (r100.length() == 0) goto L19;
            if (this.templateID.length() <= 1024) goto L12;
            r101 = "checkArgs fail, templateID is too long";
            goto L10
        L12:
            String r102 = this.reserved;
            if (r102 != null) goto L15;
            return true;
        L15:
            if (r102.length() <= 1024) goto L20;
            r101 = "checkArgs fail, reserved is too long";
            goto L10
        L20:
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle r100) {
            super.fromBundle(r100);
            this.scene = r100.getInt("_wxapi_subscribemessage_req_scene");
            this.templateID = r100.getString("_wxapi_subscribemessage_req_templateid");
            this.reserved = r100.getString("_wxapi_subscribemessage_req_reserved");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 18;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putInt("_wxapi_subscribemessage_req_scene", this.scene);
            r100.putString("_wxapi_subscribemessage_req_templateid", this.templateID);
            r100.putString("_wxapi_subscribemessage_req_reserved", this.reserved);
        }
    }

    public static class Resp extends BaseResp {
        private static final String TAG = "MicroMsg.SDK.SubscribeMessage.Resp";
        public String action;
        public String reserved;
        public int scene;
        public String templateID;

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
            this.templateID = r100.getString("_wxapi_subscribemessage_resp_templateid");
            this.scene = r100.getInt("_wxapi_subscribemessage_resp_scene");
            this.action = r100.getString("_wxapi_subscribemessage_resp_action");
            this.reserved = r100.getString("_wxapi_subscribemessage_resp_reserved");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 18;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString("_wxapi_subscribemessage_resp_templateid", this.templateID);
            r100.putInt("_wxapi_subscribemessage_resp_scene", this.scene);
            r100.putString("_wxapi_subscribemessage_resp_action", this.action);
            r100.putString("_wxapi_subscribemessage_resp_reserved", this.reserved);
        }
    }

    private SubscribeMessage() {
    }
}
