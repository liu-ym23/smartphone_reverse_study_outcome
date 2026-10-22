package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

/* JADX INFO: loaded from: classes40.dex */
public class WXChannelStartLive {

    public static class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.WXChannelStartLive.Req";
        public String liveJsonInfo;

        public Req() {
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            if (b.b(this.liveJsonInfo) == false) goto L6;
            Log.e(TAG, "liveInfoData is null");
            return false;
        L6:
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle r100) {
            super.fromBundle(r100);
            this.liveJsonInfo = r100.getString("_wxapi_finder_start_live_info_data");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 39;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString("_wxapi_finder_start_live_info_data", this.liveJsonInfo);
        }
    }

    public static class Resp extends BaseResp {
        public String extMsg;

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
            this.extMsg = r100.getString("_wxapi_finder_extMsg");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 39;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString("_wxapi_finder_extMsg", this.extMsg);
        }
    }

    public WXChannelStartLive() {
    }
}
