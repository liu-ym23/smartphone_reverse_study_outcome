package com.bytedance.ee.bear.middleground.permission.batchauthorize.model;

import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public class BatchAuthorizeResult extends Result {
    private BatchAuthorizeData batchData;
    private boolean success;

    public class AhorizeResponse implements Serializable {
        private int auth_data_code;
        private int err_code;
        private String err_msg;
        final /* synthetic */ BatchAuthorizeResult this$0;

        public int getAuth_data_code() {
            return this.auth_data_code;
        }

        public int getErr_code() {
            return this.err_code;
        }

        public String getErr_msg() {
            return this.err_msg;
        }

        public AhorizeResponse(BatchAuthorizeResult r100) {
            this.this$0 = r100;
        }

        public void setAuth_data_code(int r100) {
            this.auth_data_code = r100;
        }

        public void setErr_code(int r100) {
            this.err_code = r100;
        }

        public void setErr_msg(String r100) {
            this.err_msg = r100;
        }
    }

    public class BatchAuthorizeData implements Serializable {
        private ArrayList<BatchAuthorizeNode> auth_res_lists;
        final /* synthetic */ BatchAuthorizeResult this$0;

        public ArrayList<BatchAuthorizeNode> getAuth_res_lists() {
            return this.auth_res_lists;
        }

        public BatchAuthorizeData(BatchAuthorizeResult r100) {
            this.this$0 = r100;
        }

        public void setAuth_res_lists(ArrayList<BatchAuthorizeNode> r100) {
            this.auth_res_lists = r100;
        }
    }

    public class BatchAuthorizeNode implements Serializable {
        private AhorizeResponse authorization_response;
        private int entity_type;
        final /* synthetic */ BatchAuthorizeResult this$0;
        private String token;

        public AhorizeResponse getAuthorization_response() {
            return this.authorization_response;
        }

        public int getEntity_type() {
            return this.entity_type;
        }

        public String getToken() {
            return this.token;
        }

        public BatchAuthorizeNode(BatchAuthorizeResult r100) {
            this.this$0 = r100;
        }

        public void setAuthorization_response(AhorizeResponse r100) {
            this.authorization_response = r100;
        }

        public void setEntity_type(int r100) {
            this.entity_type = r100;
        }

        public void setToken(String r100) {
            this.token = r100;
        }
    }

    public BatchAuthorizeResult() {
    }

    public BatchAuthorizeData getBatchData() {
        return this.batchData;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setBatchData(BatchAuthorizeData r100) {
        this.batchData = r100;
    }

    public void setSuccess(boolean r100) {
        this.success = r100;
    }
}
