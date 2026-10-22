package com.bytedance.ee.bear.document.at;

import com.bytedance.ee.bear.at.AtObject;
import com.bytedance.ee.bear.atfinder.AtFinderResult;
import com.bytedance.ee.bear.contract.Result;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class AtFinderNetServiceResult extends Result {
    public String keyword;
    public List<AtObject> list;
    public String originJson;

    public AtFinderNetServiceResult() {
    }

    public static AtFinderResult convertTo(AtFinderNetServiceResult r2) {
        AtFinderResult r0 = new AtFinderResult();
        r0.keyword = r2.keyword;
        r0.list = r2.list;
        return r0;
    }
}
