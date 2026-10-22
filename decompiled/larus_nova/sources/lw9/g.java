package lw9;

import com.obric.assistant.spi.share.ShareKeyConfigDelegate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements jn7.g {
    public g() {
    }

    @Override // jn7.g
    public final JSONObject getKeys() {
        JSONObject r100 = new JSONObject();
        ShareKeyConfigDelegate r101 = ShareKeyConfigDelegate.f392913b;
        r100.put("wechat", r101.a("wechat"));
        r100.put("qq", r101.a("qq"));
        r100.put("douyin", r101.a("douyin"));
        return r100;
    }
}
