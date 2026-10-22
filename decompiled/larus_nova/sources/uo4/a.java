package uo4;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.bitable.baseadd.model.CascadeResponse;
import com.bytedance.ee.bear.bitable.common.model.field.OptionItem;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements NetService.c<CascadeResponse> {

    /* JADX INFO: renamed from: uo4.a$a, reason: collision with other inner class name */
    public static final class C7907a {
    }

    static {
    }

    public a() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) {
    L16:
        e = move-exception;
        tt5.a.e("BaseAddCascadeParser", "parse err ", e, false);
        throw new NetService.ParseException();
    L3:
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        JSONObject r101 = new JSONObject(r100).optJSONObject("data");     // Catch: Exception -> L16
        if (r101 != null) goto L8;
        r101 = new JSONObject();     // Catch: Exception -> L16
    L8:
        String r102 = r101.optString("cascadeContent");     // Catch: Exception -> L16
        ArrayList r103 = new ArrayList();     // Catch: Exception -> L16
        List r104 = JSON.parseArray(r102, OptionItem.class);     // Catch: Exception -> L16
        if (r104 == null) goto L14;
        Iterator r105 = r104.iterator();     // Catch: Exception -> L16
    L12:
        if (r105.hasNext() == false) goto L14;
        r103.add((OptionItem) r105.next());     // Catch: Exception -> L16
    L14:
        return new CascadeResponse(r103);
    }
}
