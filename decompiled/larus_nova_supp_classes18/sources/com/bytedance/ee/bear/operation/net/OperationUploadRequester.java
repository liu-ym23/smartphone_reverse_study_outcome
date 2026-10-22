package com.bytedance.ee.bear.operation.net;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.util.io.NonProguard;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OperationUploadRequester {
    public final NetService a;

    public static class Params implements Serializable {
        public int obj_type;
        public List<RecordDetail> records;
        public String token;

        public Params() {
        }
    }

    public static class RecordDetail implements Serializable {
        public String event_uuid;
        public String operate_name;
        public int operate_scene;
        public Long operate_time;

        public RecordDetail() {
        }
    }

    public static class Result implements Serializable {
        public Result() {
        }
    }

    public static class UploadOperationResult implements NonProguard {
        public List<dl5.a> requestOperations;
        public Result result;

        public UploadOperationResult(Result r1, List<dl5.a> r2) {
            this.requestOperations = r2;
            this.result = r1;
        }
    }

    public static class a implements NetService.c<com.bytedance.ee.bear.contract.Result<Result>> {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.operation.net.OperationUploadRequester$a$a, reason: collision with other inner class name */
        public class C0136a extends TypeReference<com.bytedance.ee.bear.contract.Result<Result>> {
            public C0136a() {
            }
        }

        public a() {
        }

        public final com.bytedance.ee.bear.contract.Result<Result> parse(String r3) throws NetService.ParseException {
            return (com.bytedance.ee.bear.contract.Result) JSON.parseObject(r3, new C0136a(), new Feature[0]);
        }
    }

    public OperationUploadRequester(NetService r1) {
        this.a = r1;
    }
}
