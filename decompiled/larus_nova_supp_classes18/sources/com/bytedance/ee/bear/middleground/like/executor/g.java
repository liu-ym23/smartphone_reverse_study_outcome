package com.bytedance.ee.bear.middleground.like.executor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.like.export.LikeCountResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g {
    public hg5.a a;
    public NetService.f b;
    public final NetService c;

    public static class a implements NetService.c<Result<LikeCountResult>> {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.like.executor.g$a$a, reason: collision with other inner class name */
        public class C0086a extends TypeReference<Result<LikeCountResult>> {
            public C0086a() {
            }
        }

        public a() {
        }

        public final Result<LikeCountResult> parse(String r4) {
            return (Result) JSON.parseObject(r4, new C0086a(), new Feature[0]);
        L5:
            e = move-exception;
            tt5.a.f("FetchLikeCountExecutor", e, false);
            return null;
        }
    }

    public g(NetService r1) {
        this.c = r1;
    }
}
