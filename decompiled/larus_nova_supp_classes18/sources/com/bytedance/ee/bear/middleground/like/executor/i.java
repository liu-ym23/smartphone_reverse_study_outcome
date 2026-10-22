package com.bytedance.ee.bear.middleground.like.executor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.like.export.LikeUserList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i {
    public final NetService a;
    public NetService.f b;

    public static class a implements NetService.c<Result<LikeUserList>> {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.like.executor.i$a$a, reason: collision with other inner class name */
        public class C0087a extends TypeReference<Result<LikeUserList>> {
            public C0087a() {
            }
        }

        public a() {
        }

        public final Result<LikeUserList> parse(String r4) {
            return (Result) JSON.parseObject(r4, new C0087a(), new Feature[0]);
        L5:
            e = move-exception;
            tt5.a.f("LikeListPuller", e, false);
            return null;
        }
    }

    public i(NetService r1) {
        this.a = r1;
    }
}
