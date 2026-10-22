package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

/* JADX INFO: loaded from: classes40.dex */
public class WXChannelOpenLive {

    public static class Req extends BaseReq {
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "MicroMsg.SDK.WXChannelOpenLive.Req";
        public String feedID;
        public String nonceID;

        public Req() {
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            if (b.b(this.feedID) == false) goto L8;
            String r100 = "feedID is null";
        L5:
            Log.e(TAG, r100);
            return false;
        L8:
            if (b.b(this.nonceID) == false) goto L11;
            r100 = "nonceID is null";
            goto L5
        L11:
            if (this.feedID.length() <= 1024) goto L14;
            r100 = "feedID.length too long!";
            goto L5
        L14:
            if (this.nonceID.length() <= 1024) goto L16;
            r100 = "nonceID.length too long!";
            goto L5
        L16:
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle r100) {
            super.fromBundle(r100);
            this.feedID = r100.getString("_wxapi_finder_feedID");
            this.nonceID = r100.getString("_wxapi_finder_nonceID");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 35;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString("_wxapi_finder_feedID", this.feedID);
            r100.putString("_wxapi_finder_nonceID", this.nonceID);
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
            return 35;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString("_wxapi_finder_extMsg", this.extMsg);
        }
    }

    public WXChannelOpenLive() {
    }
}
