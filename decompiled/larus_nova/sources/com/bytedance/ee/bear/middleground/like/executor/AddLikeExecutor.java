package com.bytedance.ee.bear.middleground.like.executor;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.like.export.AddLikeResponse;

/* JADX INFO: loaded from: classes18.dex */
public final class AddLikeExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public hg5.d f232773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NetService.f f232774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NetService f232775c;

    public static class AddLikeResult extends Result {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        String f232776id;

        public String toString() {
            return "AddLikeResult{msg='" + this.msg + "', code='" + this.code + "', id='" + this.f232776id + "'}";
        }

        public AddLikeResult() {
        }

        public String getId() {
            return this.f232776id;
        }

        public void setId(String r100) {
            this.f232776id = r100;
        }
    }

    public static class a implements NetService.c<AddLikeResult> {
        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r100) throws NetService.ParseException {
            tt5.a.b("AddLikeExecutor", "AddLikeExecutor parse: json=" + r100);
            AddLikeResult r101 = new AddLikeResult();
            AddLikeResponse r102 = (AddLikeResponse) JSON.parseObject(r100, AddLikeResponse.class);     // Catch: Exception -> L8
            r101.setCode(r102.getCode());     // Catch: Exception -> L8
            r101.setMsg(r102.getMsg());     // Catch: Exception -> L8
            if (r102.getData() == null) goto L6;
            r101.setId(r102.getData().getId());     // Catch: Exception -> L8
        L11:
        L10:
            return r101;
        L6:
            tt5.a.d("AddLikeExecutor", "AddLikeExecutor AddLikeParser parse: data is null");     // Catch: Exception -> L8
            r101.setId("");     // Catch: Exception -> L8
        L8:
            e = move-exception;
            tt5.a.e("AddLikeExecutor", "AddLikeExecutor json exception", e, false);
            goto L10
        }
    }

    public AddLikeExecutor(NetService r100) {
        this.f232775c = r100;
    }
}
