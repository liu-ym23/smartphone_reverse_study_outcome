package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

/* JADX INFO: loaded from: classes40.dex */
public class LaunchFromWX {

    public static class Req extends BaseReq {
        private static final int MESSAGE_ACTION_LENGTH_LIMIT = 2048;
        private static final int MESSAGE_EXT_LENGTH_LIMIT = 2048;
        private static final String TAG = "MicroMsg.SDK.LaunchFromWX.Req";
        public String country;
        public String lang;
        public String messageAction;
        public String messageExt;

        public Req() {
        }

        public Req(Bundle r100) {
            fromBundle(r100);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            String r100 = this.messageAction;
            if (r100 != null) goto L5;
        L9:
            String r101 = this.messageExt;
            if (r101 != null) goto L12;
            return true;
        L12:
            if (r101.length() <= 2048) goto L16;
            String r102 = "checkArgs fail, messageExt is too long";
        L7:
            Log.e(TAG, r102);
            return false;
        L16:
            return true;
        L5:
            if (r100.length() <= 2048) goto L9;
            r102 = "checkArgs fail, messageAction is too long";
            goto L7
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle r100) {
            super.fromBundle(r100);
            this.messageAction = r100.getString("_wxobject_message_action");
            this.messageExt = r100.getString("_wxobject_message_ext");
            this.lang = r100.getString("_wxapi_launch_req_lang");
            this.country = r100.getString("_wxapi_launch_req_country");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 6;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString("_wxobject_message_action", this.messageAction);
            r100.putString("_wxobject_message_ext", this.messageExt);
            r100.putString("_wxapi_launch_req_lang", this.lang);
            r100.putString("_wxapi_launch_req_country", this.country);
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
            return 6;
        }
    }

    private LaunchFromWX() {
    }
}
