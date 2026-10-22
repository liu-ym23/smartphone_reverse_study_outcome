package my4;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.doc.cover.selectcover.official.OfficialCoverData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b<T extends Result> implements NetService.c {
    public static final b<T> a = null;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r2) {
        return (OfficialCoverData) JSON.parseObject(r2, OfficialCoverData.class);
    }
}
