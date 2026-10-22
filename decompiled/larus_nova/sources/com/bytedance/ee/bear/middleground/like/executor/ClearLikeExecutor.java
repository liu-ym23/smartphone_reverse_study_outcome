package com.bytedance.ee.bear.middleground.like.executor;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.like.export.ClearLikeResponse;

/* JADX INFO: loaded from: classes18.dex */
public final class ClearLikeExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public hg5.d f232777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NetService.f f232778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NetService f232779c;

    public static class ClearLikeResult extends Result {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        String f232780id;

        public String toString() {
            return "ClearLikeResult{msg='" + this.msg + "', code='" + this.code + "', id='" + this.f232780id + "'}";
        }

        public ClearLikeResult() {
        }

        public String getId() {
            return this.f232780id;
        }

        public void setId(String r100) {
            this.f232780id = r100;
        }
    }

    public static class a implements NetService.c<ClearLikeResult> {
        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r100) throws NetService.ParseException {
            tt5.a.b("ClearLikeExecutor", "ClearLikeExecutor parse: json=" + r100);
            ClearLikeResult r101 = new ClearLikeResult();
            ClearLikeResponse r102 = (ClearLikeResponse) JSON.parseObject(r100, ClearLikeResponse.class);     // Catch: Exception -> L8
            r101.setCode(r102.getCode());     // Catch: Exception -> L8
            r101.setMsg(r102.getMsg());     // Catch: Exception -> L8
            if (r102.getData() == null) goto L6;
            r101.setId(r102.getData().getId());     // Catch: Exception -> L8
        L11:
        L10:
            return r101;
        L6:
            tt5.a.d("ClearLikeExecutor", "ClearLikeExecutor parse: ClearLikeResult get data is null");     // Catch: Exception -> L8
            r101.setId("");     // Catch: Exception -> L8
        L8:
            e = move-exception;
            tt5.a.e("ClearLikeExecutor", "ClearLikeExecutor json exception", e, false);
            goto L10
        }
    }

    public ClearLikeExecutor(NetService r100) {
        this.f232779c = r100;
    }
}
