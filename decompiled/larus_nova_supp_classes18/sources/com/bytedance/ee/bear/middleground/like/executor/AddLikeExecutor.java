package com.bytedance.ee.bear.middleground.like.executor;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.like.export.AddLikeResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class AddLikeExecutor {
    public hg5.d a;
    public NetService.f b;
    public final NetService c;

    public static class AddLikeResult extends Result {
        String id;

        public String toString() {
            return "AddLikeResult{msg='" + ((Result) this).msg + "', code='" + ((Result) this).code + "', id='" + this.id + "'}";
        }

        public AddLikeResult() {
        }

        public String getId() {
            return this.id;
        }

        public void setId(String r1) {
            this.id = r1;
        }
    }

    public static class a implements NetService.c<AddLikeResult> {
        public a() {
        }

        public final Result parse(String r5) throws NetService.ParseException {
            tt5.a.b("AddLikeExecutor", "AddLikeExecutor parse: json=" + r5);
            AddLikeResult r0 = new AddLikeResult();
            AddLikeResponse r6 = (AddLikeResponse) JSON.parseObject(r5, AddLikeResponse.class);     // Catch: Exception -> L8
            r0.setCode(r6.getCode());     // Catch: Exception -> L8
            r0.setMsg(r6.getMsg());     // Catch: Exception -> L8
            if (r6.getData() == null) goto L6;
            r0.setId(r6.getData().getId());     // Catch: Exception -> L8
        L11:
        L10:
            return r0;
        L6:
            tt5.a.d("AddLikeExecutor", "AddLikeExecutor AddLikeParser parse: data is null");     // Catch: Exception -> L8
            r0.setId("");     // Catch: Exception -> L8
        L8:
            e = move-exception;
            tt5.a.e("AddLikeExecutor", "AddLikeExecutor json exception", e, false);
            goto L10
        }
    }

    public AddLikeExecutor(NetService r1) {
        this.c = r1;
    }
}
