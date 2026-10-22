package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.channel.a.a;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

/* JADX INFO: loaded from: classes40.dex */
public final class SendAuth {

    public static class Options {
        public static final int INVALID_FLAGS = -1;
        public String callbackClassName;
        public int callbackFlags;

        public Options() {
            this.callbackFlags = -1;
        }

        public void fromBundle(Bundle r100) {
            this.callbackClassName = a.a(r100, "_wxapi_sendauth_options_callback_classname");
            this.callbackFlags = a.a(r100, "_wxapi_sendauth_options_callback_flags", -1);
        }

        public void toBundle(Bundle r100) {
            r100.putString("_wxapi_sendauth_options_callback_classname", this.callbackClassName);
            r100.putInt("_wxapi_sendauth_options_callback_flags", this.callbackFlags);
        }
    }

    public static class Req extends BaseReq {
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "MicroMsg.SDK.SendAuth.Req";
        public String extData;
        public boolean isOption1;
        public boolean nonAutomatic;
        public Options options;
        public String scope;
        public String state;

        public Req() {
            this.nonAutomatic = false;
        }

        public Req(Bundle r100) {
            this.nonAutomatic = false;
            fromBundle(r100);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            String r100 = this.scope;
            if (r100 != null) goto L5;
        L18:
            String r101 = "checkArgs fail, scope is invalid";
        L14:
            Log.e(TAG, r101);
            return false;
        L5:
            if (r100.length() == 0) goto L18;
            if (this.scope.length() > 1024) goto L18;
            String r102 = this.state;
            if (r102 != null) goto L12;
            return true;
        L12:
            if (r102.length() <= 1024) goto L19;
            r101 = "checkArgs fail, state is invalid";
            goto L14
        L19:
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle r100) {
            super.fromBundle(r100);
            this.scope = r100.getString("_wxapi_sendauth_req_scope");
            this.state = r100.getString("_wxapi_sendauth_req_state");
            this.extData = r100.getString("_wxapi_sendauth_req_ext_data");
            this.isOption1 = r100.getBoolean("_wxapi_sendauth_req_isoption1");
            this.nonAutomatic = r100.getBoolean("_wxapi_sendauth_req_non_automatic");
            Options r101 = new Options();
            this.options = r101;
            r101.fromBundle(r100);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 1;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString("_wxapi_sendauth_req_scope", this.scope);
            r100.putString("_wxapi_sendauth_req_state", this.state);
            r100.putString("_wxapi_sendauth_req_ext_data", this.extData);
            r100.putBoolean("_wxapi_sendauth_req_isoption1", this.isOption1);
            r100.putBoolean("_wxapi_sendauth_req_non_automatic", this.nonAutomatic);
            Options r101 = this.options;
            if (r101 == null) goto L6;
            r101.toBundle(r100);
            return;
        }
    }

    public static class Resp extends BaseResp {
        public static final int ERR_SCOPE_SNSAPI_WXAAPP_INFO_CAN_ONLY_AUTHORIZED_SEPARATELY = -1000;
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "MicroMsg.SDK.SendAuth.Resp";
        public boolean authResult;
        public String code;
        public String country;
        public String lang;
        public String state;
        public String url;

        public Resp() {
            this.authResult = false;
        }

        public Resp(Bundle r100) {
            this.authResult = false;
            fromBundle(r100);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            String r100 = this.state;
            if (r100 != null) goto L5;
            return true;
        L5:
            if (r100.length() <= 1024) goto L10;
            Log.e(TAG, "checkArgs fail, state is invalid");
            return false;
        L10:
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle r100) {
            super.fromBundle(r100);
            this.code = r100.getString("_wxapi_sendauth_resp_token");
            this.state = r100.getString("_wxapi_sendauth_resp_state");
            this.url = r100.getString("_wxapi_sendauth_resp_url");
            this.lang = r100.getString("_wxapi_sendauth_resp_lang");
            this.country = r100.getString("_wxapi_sendauth_resp_country");
            this.authResult = r100.getBoolean("_wxapi_sendauth_resp_auth_result");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 1;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString("_wxapi_sendauth_resp_token", this.code);
            r100.putString("_wxapi_sendauth_resp_state", this.state);
            r100.putString("_wxapi_sendauth_resp_url", this.url);
            r100.putString("_wxapi_sendauth_resp_lang", this.lang);
            r100.putString("_wxapi_sendauth_resp_country", this.country);
            r100.putBoolean("_wxapi_sendauth_resp_auth_result", this.authResult);
        }
    }

    private SendAuth() {
    }
}
