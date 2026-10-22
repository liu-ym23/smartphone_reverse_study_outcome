package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;

/* JADX INFO: loaded from: classes40.dex */
public class SendTdiAuth {

    public static final class Resp extends SendAuth.Resp {
        private static final String KEY_AUTH_BUFFER = "_wxapi_sendauth_resp_tdi_buffer";
        private static final String TAG = "MicroMsg.SDK.SendTdiAuth.Resp";
        public byte[] tdiAuthBuffer;

        public Resp(Bundle r100) {
            super(r100);
        }

        @Override // com.tencent.mm.opensdk.modelmsg.SendAuth.Resp, com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelmsg.SendAuth.Resp, com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle r100) {
            super.fromBundle(r100);
            this.tdiAuthBuffer = r100.getByteArray(KEY_AUTH_BUFFER);
        }

        @Override // com.tencent.mm.opensdk.modelmsg.SendAuth.Resp, com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 31;
        }

        @Override // com.tencent.mm.opensdk.modelmsg.SendAuth.Resp, com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putByteArray(KEY_AUTH_BUFFER, this.tdiAuthBuffer);
        }
    }

    private SendTdiAuth() {
    }
}
