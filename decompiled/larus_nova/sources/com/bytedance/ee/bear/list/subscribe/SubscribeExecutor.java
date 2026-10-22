package com.bytedance.ee.bear.list.subscribe;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class SubscribeExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService f229761a;

    public static class SendParams implements NonProguard {
        public String obj_token;
        public int obj_type;
        public int sub_type;

        public String getObj_token() {
            return this.obj_token;
        }

        public int getObj_type() {
            return this.obj_type;
        }

        public int getSub_type() {
            return this.sub_type;
        }

        public void setObj_token(String r100) {
            this.obj_token = r100;
        }

        public void setObj_type(int r100) {
            this.obj_type = r100;
        }

        public void setSub_type(int r100) {
            this.sub_type = r100;
        }

        public SendParams(String r100, int r101, int r102) {
            this.obj_token = r100;
            this.obj_type = r101;
            this.sub_type = r102;
        }
    }

    public interface a {
        void onFail(int r100, Throwable r101);

        void onSuccess();
    }

    public class b implements NetService.c<Result> {
        public b() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r100) {
            Result r101 = new Result();
            r101.code = -1;
            r101.code = new JSONObject(r100).optInt("code");     // Catch: JSONException -> L5
        L7:
            return r101;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }
    }

    public SubscribeExecutor(NetService r100) {
        this.f229761a = r100;
    }

    public static NetService.f a(String r100, String r101, int r102, int r103) {
        NetService.f r104 = new NetService.f(r100);
        r104.f216906c = 1;
        r104.f216913j = JSON.toJSONString(new SendParams(r101, r102, r103));
        return r104;
    }
}
