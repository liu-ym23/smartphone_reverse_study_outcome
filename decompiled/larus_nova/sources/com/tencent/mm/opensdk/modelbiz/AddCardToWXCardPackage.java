package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes40.dex */
public class AddCardToWXCardPackage {
    private static final String TAG = "MicroMsg.AddCardToWXCardPackage";

    public static class Req extends BaseReq {
        public List<WXCardItem> cardArrary;

        public Req() {
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            List<WXCardItem> r100 = this.cardArrary;
            if (r100 != null) goto L5;
        L25:
            return false;
        L5:
            if (r100.size() == 0) goto L25;
            if (this.cardArrary.size() > 40) goto L25;
            Iterator<WXCardItem> r101 = this.cardArrary.iterator();
        L11:
            if (r101.hasNext() == false) goto L23;
            WXCardItem r102 = r101.next();
            if (r102 == null) goto L22;
            String r103 = r102.cardId;
            if (r103 == null) goto L22;
            if (r103.length() > 1024) goto L22;
            String r104 = r102.cardExtMsg;
            if (r104 == null) goto L11;
            if (r104.length() <= 1024) goto L11;
        L22:
            return false;
        L23:
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 9;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            JSONStringer r101 = new JSONStringer();
            r101.object();     // Catch: Exception -> L12
            r101.key("card_list");     // Catch: Exception -> L12
            r101.array();     // Catch: Exception -> L12
            Iterator<WXCardItem> r102 = this.cardArrary.iterator();     // Catch: Exception -> L12
        L5:
            if (r102.hasNext() == false) goto L10;
            WXCardItem r103 = r102.next();     // Catch: Exception -> L12
            r101.object();     // Catch: Exception -> L12
            r101.key("card_id");     // Catch: Exception -> L12
            r101.value(r103.cardId);     // Catch: Exception -> L12
            r101.key("card_ext");     // Catch: Exception -> L12
            String r104 = r103.cardExtMsg;     // Catch: Exception -> L12
            if (r104 != null) goto L9;
            r104 = "";
        L9:
            r101.value(r104);     // Catch: Exception -> L12
            r101.endObject();     // Catch: Exception -> L12
            goto L5
        L10:
            r101.endArray();     // Catch: Exception -> L12
            r101.endObject();     // Catch: Exception -> L12
        L14:
            r100.putString("_wxapi_add_card_to_wx_card_list", r101.toString());
            return;
        L12:
            e = move-exception;
            Log.e(AddCardToWXCardPackage.TAG, "Req.toBundle exception:" + e.getMessage());
            goto L14
        }
    }

    public static class Resp extends BaseResp {
        public List<WXCardItem> cardArrary;

        public Resp() {
        }

        public Resp(Bundle r100) {
            fromBundle(r100);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            List<WXCardItem> r100 = this.cardArrary;
            if (r100 != null) goto L5;
            return false;
        L5:
            if (r100.size() == 0) goto L11;
            return true;
        L11:
            return false;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle r100) {
            super.fromBundle(r100);
            if (this.cardArrary != null) goto L5;
            this.cardArrary = new LinkedList();
        L5:
            String r101 = r100.getString("_wxapi_add_card_to_wx_card_list");
            if (r101 != null) goto L8;
            return;
        L8:
            if (r101.length() <= 0) goto L21;
            JSONArray r102 = JSONObjectProtectorUtils.getJSONArray((JSONObject) new JSONTokener(r101).nextValue(), "card_list");     // Catch: Exception -> L14
            int r103 = 0;
        L11:
            if (r103 >= r102.length()) goto L22;
            JSONObject r104 = JSONArrayProtectorUtils.getJSONObject(r102, r103);     // Catch: Exception -> L14
            WXCardItem r105 = new WXCardItem();     // Catch: Exception -> L14
            r105.cardId = r104.optString("card_id");     // Catch: Exception -> L14
            r105.cardExtMsg = r104.optString("card_ext");     // Catch: Exception -> L14
            r105.cardState = r104.optInt("is_succ");     // Catch: Exception -> L14
            this.cardArrary.add(r105);     // Catch: Exception -> L14
            r103 = r103 + 1;
            goto L11
        L22:
            return;
        L14:
            e = move-exception;
            Log.e(AddCardToWXCardPackage.TAG, "fromBundle exception: " + e.getMessage());
            return;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 9;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            JSONStringer r101 = new JSONStringer();
            r101.object();     // Catch: Exception -> L12
            r101.key("card_list");     // Catch: Exception -> L12
            r101.array();     // Catch: Exception -> L12
            Iterator<WXCardItem> r102 = this.cardArrary.iterator();     // Catch: Exception -> L12
        L5:
            if (r102.hasNext() == false) goto L10;
            WXCardItem r103 = r102.next();     // Catch: Exception -> L12
            r101.object();     // Catch: Exception -> L12
            r101.key("card_id");     // Catch: Exception -> L12
            r101.value(r103.cardId);     // Catch: Exception -> L12
            r101.key("card_ext");     // Catch: Exception -> L12
            String r104 = r103.cardExtMsg;     // Catch: Exception -> L12
            if (r104 != null) goto L9;
            r104 = "";
        L9:
            r101.value(r104);     // Catch: Exception -> L12
            r101.key("is_succ");     // Catch: Exception -> L12
            r101.value(r103.cardState);     // Catch: Exception -> L12
            r101.endObject();     // Catch: Exception -> L12
            goto L5
        L10:
            r101.endArray();     // Catch: Exception -> L12
            r101.endObject();     // Catch: Exception -> L12
        L14:
            r100.putString("_wxapi_add_card_to_wx_card_list", r101.toString());
            return;
        L12:
            e = move-exception;
            Log.e(AddCardToWXCardPackage.TAG, "Resp.toBundle exception:" + e.getMessage());
            goto L14
        }
    }

    public static final class WXCardItem {
        public String cardExtMsg;
        public String cardId;
        public int cardState;

        public WXCardItem() {
        }
    }

    public AddCardToWXCardPackage() {
    }
}
