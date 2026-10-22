package com.bytedance.ee.bear.document.at;

import com.bytedance.ee.bear.at.AtObject;
import com.bytedance.ee.bear.atfinder.AtFinderResult;
import com.bytedance.ee.bear.contract.Result;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class AtFinderNetServiceResult extends Result {
    public String keyword;
    public List<AtObject> list;
    public String originJson;

    public AtFinderNetServiceResult() {
    }

    public static AtFinderResult convertTo(AtFinderNetServiceResult r100) {
        AtFinderResult r101 = new AtFinderResult();
        r101.keyword = r100.keyword;
        r101.list = r100.list;
        return r101;
    }
}
