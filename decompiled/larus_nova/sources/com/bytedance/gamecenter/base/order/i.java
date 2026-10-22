package com.bytedance.gamecenter.base.order;

import com.ss.android.downloadlib.addownload.model.OrderItem;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public interface i {

    public interface a {
        String getCurUserId();
    }

    void a();

    JSONArray b(JSONObject r100);

    boolean c(OrderItem r100);

    void d();

    void e(com.bytedance.gamecenter.base.order.a r100);

    Boolean f(JSONObject r100);
}
