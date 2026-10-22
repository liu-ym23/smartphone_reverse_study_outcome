package com.bytedance.ee.bear.secret;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SecretApprovalInstanceModel extends Result implements NonProguard {
    private ArrayList<Instance> instances;
    private boolean isSuccess;
    private Instance my_instance;

    public class Instance implements NonProguard {
        private String apply_sec_label_id;
        private long create_time;
        private String instance_code;
        private long obj_id;
        private long obj_type;
        private String sec_label_id;
        final /* synthetic */ SecretApprovalInstanceModel this$0;
        private String user_avatar_url;
        private long user_id;
        private String user_name;

        public String getApply_sec_label_id() {
            return this.apply_sec_label_id;
        }

        public long getCreate_time() {
            return this.create_time;
        }

        public String getInstance_code() {
            return this.instance_code;
        }

        public long getObj_id() {
            return this.obj_id;
        }

        public long getObj_type() {
            return this.obj_type;
        }

        public String getSec_label_id() {
            return this.sec_label_id;
        }

        public String getUser_avatar_url() {
            return this.user_avatar_url;
        }

        public long getUser_id() {
            return this.user_id;
        }

        public String getUser_name() {
            return this.user_name;
        }

        public Instance(SecretApprovalInstanceModel r1) {
            this.this$0 = r1;
        }

        public void setApply_sec_label_id(String r1) {
            this.apply_sec_label_id = r1;
        }

        public void setCreate_time(long r1) {
            this.create_time = r1;
        }

        public void setInstance_code(String r1) {
            this.instance_code = r1;
        }

        public void setObj_id(long r1) {
            this.obj_id = r1;
        }

        public void setObj_type(long r1) {
            this.obj_type = r1;
        }

        public void setSec_label_id(String r1) {
            this.sec_label_id = r1;
        }

        public void setUser_avatar_url(String r1) {
            this.user_avatar_url = r1;
        }

        public void setUser_id(long r1) {
            this.user_id = r1;
        }

        public void setUser_name(String r1) {
            this.user_name = r1;
        }
    }

    public SecretApprovalInstanceModel() {
        this.isSuccess = false;
    }

    public ArrayList<Instance> getInstances() {
        return this.instances;
    }

    public Instance getMy_instance() {
        return this.my_instance;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setInstances(ArrayList<Instance> r1) {
        this.instances = r1;
    }

    public void setMy_instance(Instance r1) {
        this.my_instance = r1;
    }

    public void setSuccess(boolean r1) {
        this.isSuccess = r1;
    }
}
