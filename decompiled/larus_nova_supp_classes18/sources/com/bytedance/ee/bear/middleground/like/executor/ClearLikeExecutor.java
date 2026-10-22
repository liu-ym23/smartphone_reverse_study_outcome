package com.bytedance.ee.bear.middleground.like.executor;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.like.export.ClearLikeResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class ClearLikeExecutor {
    public hg5.d a;
    public NetService.f b;
    public final NetService c;

    public static class ClearLikeResult extends Result {
        String id;

        public String toString() {
            return "ClearLikeResult{msg='" + ((Result) this).msg + "', code='" + ((Result) this).code + "', id='" + this.id + "'}";
        }

        public ClearLikeResult() {
        }

        public String getId() {
            return this.id;
        }

        public void setId(String r1) {
            this.id = r1;
        }
    }

    public static class a implements NetService.c<ClearLikeResult> {
        public a() {
        }

        public final Result parse(String r5) throws NetService.ParseException {
            tt5.a.b("ClearLikeExecutor", "ClearLikeExecutor parse: json=" + r5);
            ClearLikeResult r0 = new ClearLikeResult();
            ClearLikeResponse r6 = (ClearLikeResponse) JSON.parseObject(r5, ClearLikeResponse.class);     // Catch: Exception -> L8
            r0.setCode(r6.getCode());     // Catch: Exception -> L8
            r0.setMsg(r6.getMsg());     // Catch: Exception -> L8
            if (r6.getData() == null) goto L6;
            r0.setId(r6.getData().getId());     // Catch: Exception -> L8
        L11:
        L10:
            return r0;
        L6:
            tt5.a.d("ClearLikeExecutor", "ClearLikeExecutor parse: ClearLikeResult get data is null");     // Catch: Exception -> L8
            r0.setId("");     // Catch: Exception -> L8
        L8:
            e = move-exception;
            tt5.a.e("ClearLikeExecutor", "ClearLikeExecutor json exception", e, false);
            goto L10
        }
    }

    public ClearLikeExecutor(NetService r1) {
        this.c = r1;
    }
}
