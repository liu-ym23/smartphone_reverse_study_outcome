package com.bytedance.ee.bear.middleground.like.executor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.like.export.LikeUserList;

/* JADX INFO: loaded from: classes18.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService f232798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NetService.f f232799b;

    public static class a implements NetService.c<Result<LikeUserList>> {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.like.executor.i$a$a, reason: collision with other inner class name */
        public class C3334a extends TypeReference<Result<LikeUserList>> {
            public C3334a() {
            }
        }

        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<LikeUserList> parse(String r100) {
            return (Result) JSON.parseObject(r100, new C3334a(), new Feature[0]);
        L5:
            e = move-exception;
            tt5.a.f("LikeListPuller", e, false);
            return null;
        }
    }

    public i(NetService r100) {
        this.f232798a = r100;
    }
}
