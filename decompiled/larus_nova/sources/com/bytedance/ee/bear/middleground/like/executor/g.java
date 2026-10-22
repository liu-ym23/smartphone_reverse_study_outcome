package com.bytedance.ee.bear.middleground.like.executor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.like.export.LikeCountResult;

/* JADX INFO: loaded from: classes18.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public hg5.a f232793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NetService.f f232794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NetService f232795c;

    public static class a implements NetService.c<Result<LikeCountResult>> {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.like.executor.g$a$a, reason: collision with other inner class name */
        public class C3333a extends TypeReference<Result<LikeCountResult>> {
            public C3333a() {
            }
        }

        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<LikeCountResult> parse(String r100) {
            return (Result) JSON.parseObject(r100, new C3333a(), new Feature[0]);
        L5:
            e = move-exception;
            tt5.a.f("FetchLikeCountExecutor", e, false);
            return null;
        }
    }

    public g(NetService r100) {
        this.f232795c = r100;
    }
}
