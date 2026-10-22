package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

/* JADX INFO: loaded from: classes40.dex */
public class WXChannelOpenEvent {

    public static class Req extends BaseReq {
        private static final String Key_EventId = "_wxapi_finder_open_event_eventId";
        private static final String Key_ExtInfo = "_wxapi_finder_open_event_extInfo";
        private static final String Key_Username = "_wxapi_finder_open_event_username";
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "MicroMsg.SDK.WXChannelOpenEvent.Req";
        public String eventId;
        public String extInfo;
        public String username;

        public Req() {
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            if (b.b(this.username) == false) goto L8;
            String r100 = "username is null";
        L5:
            Log.e(TAG, r100);
            return false;
        L8:
            if (this.username.length() <= 1024) goto L11;
            r100 = "username exceeds the limit";
            goto L5
        L11:
            if (b.b(this.eventId) == false) goto L14;
            r100 = "eventId is null";
            goto L5
        L14:
            if (this.eventId.length() <= 1024) goto L16;
            r100 = "eventId exceeds the limit";
            goto L5
        L16:
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle r100) {
            super.fromBundle(r100);
            this.username = r100.getString(Key_Username);
            this.eventId = r100.getString(Key_EventId);
            this.extInfo = r100.getString(Key_ExtInfo);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 41;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString(Key_Username, this.username);
            r100.putString(Key_EventId, this.eventId);
            r100.putString(Key_ExtInfo, this.extInfo);
        }
    }

    public static class Resp extends BaseResp {
        private static final String Key_ExtMsg = "_wxapi_finder_open_event_extMsg";
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
            this.extMsg = r100.getString(Key_ExtMsg);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 41;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString(Key_ExtMsg, this.extMsg);
        }
    }

    public WXChannelOpenEvent() {
    }
}
