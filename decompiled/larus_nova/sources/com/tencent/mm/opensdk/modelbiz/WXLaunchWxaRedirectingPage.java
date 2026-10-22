package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;

/* JADX INFO: loaded from: classes40.dex */
public class WXLaunchWxaRedirectingPage {
    public static final String URI_PATH = "launchWxaOpenApiRedirectingPage";

    public interface ConstantsWxaRedirectingPage {
        public static final String KEY_CALLBACK_ACTIVITY = "_launch_wx_wxa_redirecting_page_callback_activity";
        public static final String KEY_CALLBACK_MSG = "_launch_wx_wxa_redirecting_page_callback_msg";
        public static final String KEY_INVOKE_TICKET = "_launch_wx_wxa_redirecting_page_invoke_ticket";
    }

    public static final class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.WXLaunchWxaRedirectingPage.Req";
        public String callbackActivity;
        public String invokeTicket;

        public Req() {
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            return !TextUtils.isEmpty(this.invokeTicket);
        }

        public void fromArray(String[] r100) {
            this.invokeTicket = r100[0];
            this.callbackActivity = r100[1];
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle r100) {
            super.fromBundle(r100);
            this.invokeTicket = r100.getString(ConstantsWxaRedirectingPage.KEY_INVOKE_TICKET);
            this.callbackActivity = r100.getString(ConstantsWxaRedirectingPage.KEY_CALLBACK_ACTIVITY);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 30;
        }

        public String[] toArray() {
            return new String[]{this.invokeTicket, this.callbackActivity};
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString(ConstantsWxaRedirectingPage.KEY_INVOKE_TICKET, this.invokeTicket);
            r100.putString(ConstantsWxaRedirectingPage.KEY_CALLBACK_ACTIVITY, this.callbackActivity);
        }
    }

    public static final class Resp extends BaseResp {
        private static final String TAG = "MicroMsg.SDK.WXLaunchWxaFRedirectingPage.Resp";
        public String callbackActivity;
        public String invokeTicket;

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
            this.invokeTicket = r100.getString(ConstantsWxaRedirectingPage.KEY_INVOKE_TICKET);
            this.callbackActivity = r100.getString(ConstantsWxaRedirectingPage.KEY_CALLBACK_ACTIVITY);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 30;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString(ConstantsWxaRedirectingPage.KEY_INVOKE_TICKET, this.invokeTicket);
            r100.putString(ConstantsWxaRedirectingPage.KEY_CALLBACK_ACTIVITY, this.callbackActivity);
        }
    }

    public WXLaunchWxaRedirectingPage() {
    }
}
