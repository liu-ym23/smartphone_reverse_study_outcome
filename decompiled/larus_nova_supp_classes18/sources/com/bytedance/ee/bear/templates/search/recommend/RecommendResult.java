package com.bytedance.ee.bear.templates.search.recommend;

import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class RecommendResult extends Result<RecommendData> {

    public static class RecommendData implements Serializable {
        public List<String> recommend_keys;

        public RecommendData() {
        }

        public List<String> getRecommend_keys() {
            return this.recommend_keys;
        }

        public void setRecommend_keys(List<String> r1) {
            this.recommend_keys = r1;
        }
    }

    public RecommendResult() {
    }
}
