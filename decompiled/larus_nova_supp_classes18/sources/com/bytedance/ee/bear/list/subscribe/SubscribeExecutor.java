package com.bytedance.ee.bear.list.subscribe;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class SubscribeExecutor {
    public final NetService a;

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

        public void setObj_token(String r1) {
            this.obj_token = r1;
        }

        public void setObj_type(int r1) {
            this.obj_type = r1;
        }

        public void setSub_type(int r1) {
            this.sub_type = r1;
        }

        public SendParams(String r1, int r2, int r3) {
            this.obj_token = r1;
            this.obj_type = r2;
            this.sub_type = r3;
        }
    }

    public interface a {
        void onFail(int r1, Throwable r2);

        void onSuccess();
    }

    public class b implements NetService.c<Result> {
        public b() {
        }

        public final Result parse(String r3) {
            Result r0 = new Result();
            r0.code = -1;
            r0.code = new JSONObject(r3).optInt("code");     // Catch: JSONException -> L5
        L7:
            return r0;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }
    }

    public SubscribeExecutor(NetService r1) {
        this.a = r1;
    }

    public static NetService.f a(String r1, String r2, int r3, int r4) {
        NetService.f r0 = new NetService.f(r1);
        ((NetService.e) r0).c = 1;
        ((NetService.e) r0).j = JSON.toJSONString(new SendParams(r2, r3, r4));
        return r0;
    }
}
