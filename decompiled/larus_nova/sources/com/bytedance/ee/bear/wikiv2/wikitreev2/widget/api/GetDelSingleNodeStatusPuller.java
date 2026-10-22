package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public final class GetDelSingleNodeStatusPuller extends b<Params, Result> {

    public static class Params implements NonProguard {
        public String task_id;

        public String toString() {
            return "Params{task_id='" + this.task_id + "'}";
        }

        public Params(String r100) {
            this.task_id = r100;
        }
    }

    public static class Result implements NonProguard {
        public static final int DELETE_FAIL = 3;
        public static final int DELETE_OK = 2;
        public static final int DELETING = 1;
        public int status;
        public String task_id;

        public Result() {
        }

        public String toString() {
            return "Result{task_id='" + this.task_id + "', status=" + this.status + '}';
        }
    }

    public GetDelSingleNodeStatusPuller(NetService r100) {
        super(r100, "/space/api/wiki/v2/tree/del_single_node_status/", 2, 1);
    }
}
