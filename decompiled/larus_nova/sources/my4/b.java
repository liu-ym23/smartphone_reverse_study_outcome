package my4;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.doc.cover.selectcover.official.OfficialCoverData;

/* JADX INFO: loaded from: classes16.dex */
public final class b<T extends Result> implements NetService.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T> f516370a = null;

    static {
        f516370a = new b();
    }

    public b() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) {
        return (OfficialCoverData) JSON.parseObject(r100, OfficialCoverData.class);
    }
}
