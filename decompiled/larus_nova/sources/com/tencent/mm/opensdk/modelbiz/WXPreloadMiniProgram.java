package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

/* JADX INFO: loaded from: classes40.dex */
public class WXPreloadMiniProgram {

    public static final class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.WXPreloadMiniProgram.Req";
        public String extData;
        public int miniprogramType;
        public String path;
        public String userName;

        public Req() {
            this.path = "";
            this.miniprogramType = 0;
            this.extData = "";
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            if (b.b(this.userName) == false) goto L7;
            String r100 = "userName is null";
        L5:
            Log.e(TAG, r100);
            return false;
        L7:
            int r101 = this.miniprogramType;
            if (r101 >= 0) goto L10;
        L14:
            r100 = "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW";
            goto L5
        L10:
            if (r101 > 2) goto L14;
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 28;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString("_launch_wxminiprogram_username", this.userName);
            r100.putString("_launch_wxminiprogram_path", this.path);
            r100.putString("_launch_wxminiprogram_extData", this.extData);
            r100.putInt("_launch_wxminiprogram_type", this.miniprogramType);
        }
    }

    public static final class Resp extends BaseResp {
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
            this.extMsg = r100.getString("_launch_wxminiprogram_ext_msg");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 28;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString("_launch_wxminiprogram_ext_msg", this.extMsg);
        }
    }

    public WXPreloadMiniProgram() {
    }
}
