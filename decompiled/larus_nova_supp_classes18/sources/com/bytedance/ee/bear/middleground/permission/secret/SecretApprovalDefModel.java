package com.bytedance.ee.bear.middleground.permission.secret;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SecretApprovalDefModel extends Result implements NonProguard {
    private String approval_code;
    private ApprovalDetail approval_detail;

    @SerializedName("cc_users")
    private ArrayList<Reviewer> ccUsers;
    private boolean isSuccess;
    private boolean is_open;
    private ArrayList<Reviewer> reviewers;

    public static class ApprovalDetail implements NonProguard {
        private ArrayList<String> from_label_ids;
        private boolean is_for_all;
        private ArrayList<String> to_label_ids;

        public ApprovalDetail() {
        }

        public ArrayList<String> getFrom_label_ids() {
            if (this.from_label_ids != null) goto L6;
            this.from_label_ids = new ArrayList();
        L6:
            return this.from_label_ids;
        }

        public ArrayList<String> getTo_label_ids() {
            if (this.to_label_ids != null) goto L6;
            this.to_label_ids = new ArrayList();
        L6:
            return this.to_label_ids;
        }

        public boolean isIs_for_all() {
            return this.is_for_all;
        }

        public void setFrom_label_ids(ArrayList<String> r1) {
            this.from_label_ids = r1;
        }

        public void setIs_for_all(boolean r1) {
            this.is_for_all = r1;
        }

        public void setTo_label_ids(ArrayList<String> r1) {
            this.to_label_ids = r1;
        }
    }

    public static class Reviewer implements NonProguard {
        private String user_avatar_tos_url;
        private String user_id;
        private String user_name;

        public Reviewer() {
        }

        public String getUser_name() {
            if (this.user_name != null) goto L6;
            this.user_name = "";
        L6:
            return this.user_name;
        }

        public String getUser_avatar_url() {
            return this.user_avatar_tos_url;
        }

        public String getUser_id() {
            return this.user_id;
        }

        public void setUser_avatar_url(String r1) {
            this.user_avatar_tos_url = r1;
        }

        public void setUser_id(String r1) {
            this.user_id = r1;
        }

        public void setUser_name(String r1) {
            this.user_name = r1;
        }
    }

    public ArrayList<Reviewer> getReviewers() {
        if (this.reviewers != null) goto L6;
        this.reviewers = new ArrayList();
    L6:
        return this.reviewers;
    }

    public SecretApprovalDefModel() {
        this.is_open = false;
        this.isSuccess = false;
    }

    public String getApproval_code() {
        return this.approval_code;
    }

    public ApprovalDetail getApproval_detail() {
        return this.approval_detail;
    }

    public ArrayList<Reviewer> getCcUsers() {
        return this.ccUsers;
    }

    public boolean isIs_open() {
        return this.is_open;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setApproval_code(String r1) {
        this.approval_code = r1;
    }

    public void setApproval_detail(ApprovalDetail r1) {
        this.approval_detail = r1;
    }

    public void setCcUsers(ArrayList<Reviewer> r1) {
        this.ccUsers = r1;
    }

    public void setIs_open(boolean r1) {
        this.is_open = r1;
    }

    public void setReviewers(ArrayList<Reviewer> r1) {
        this.reviewers = r1;
    }

    public void setSuccess(boolean r1) {
        this.isSuccess = r1;
    }
}
