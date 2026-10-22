package xh5;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface m {
    Flowable<SimpleRequestResult> a(String r1, int r2);

    Flowable<SimpleRequestResult> b(JSONObject r1);
}
