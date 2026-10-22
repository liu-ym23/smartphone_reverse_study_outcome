package com.bytedance.ee.bear.middleground.permission.batchauthorize.model;

import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class EmbededDocumentInfo extends Result {
    private EmbededData result;
    private boolean success;

    public class EmbededData implements Serializable {
        private boolean dataSuccess;
        private boolean is_last;
        private String next_cusor;
        private ArrayList<NodeInfo> result;
        final /* synthetic */ EmbededDocumentInfo this$0;
        private int total_has_permission;
        private int total_no_permission;

        public String getNext_cusor() {
            return this.next_cusor;
        }

        public ArrayList<NodeInfo> getResult() {
            return this.result;
        }

        public int getTotal_has_permission() {
            return this.total_has_permission;
        }

        public int getTotal_no_permission() {
            return this.total_no_permission;
        }

        public boolean isDataSuccess() {
            return this.dataSuccess;
        }

        public boolean isIs_last() {
            return this.is_last;
        }

        public EmbededData(EmbededDocumentInfo r2) {
            this.this$0 = r2;
            this.dataSuccess = false;
            this.result = new ArrayList();
            this.is_last = false;
        }

        public void setDataSuccess(boolean r1) {
            this.dataSuccess = r1;
        }

        public void setIs_last(boolean r1) {
            this.is_last = r1;
        }

        public void setNext_cusor(String r1) {
            this.next_cusor = r1;
        }

        public void setResult(ArrayList<NodeInfo> r1) {
            this.result = r1;
        }

        public void setTotal_has_permission(int r1) {
            this.total_has_permission = r1;
        }

        public void setTotal_no_permission(int r1) {
            this.total_no_permission = r1;
        }

        public EmbededData(EmbededDocumentInfo r2, boolean r3) {
            this.this$0 = r2;
            this.dataSuccess = false;
            this.result = new ArrayList();
            this.is_last = false;
            this.dataSuccess = r3;
        }
    }

    public static class NodeInfo implements Serializable {
        private boolean chat_has_permission;
        private boolean isWiki;
        private int object_id;
        private String object_token;
        private int object_type;
        private String owner_id;
        private String owner_name;
        private int perm_type;
        private boolean sender_has_permission;
        private boolean sender_has_share_permission;
        private String title;
        private String token;

        public NodeInfo() {
            this.sender_has_permission = false;
            this.sender_has_share_permission = false;
            this.chat_has_permission = false;
            this.isWiki = false;
        }

        public int getObject_id() {
            return this.object_id;
        }

        public String getObject_token() {
            return this.object_token;
        }

        public int getObject_type() {
            return this.object_type;
        }

        public String getOwner_id() {
            return this.owner_id;
        }

        public String getOwner_name() {
            return this.owner_name;
        }

        public int getPerm_type() {
            return this.perm_type;
        }

        public String getTitle() {
            return this.title;
        }

        public String getToken() {
            return this.token;
        }

        public boolean isChat_has_permission() {
            return this.chat_has_permission;
        }

        public boolean isSenderHasSharePermission() {
            return this.sender_has_share_permission;
        }

        public boolean isSender_has_permission() {
            return this.sender_has_permission;
        }

        public boolean isWiki() {
            return this.isWiki;
        }

        public void setChat_has_permission(boolean r1) {
            this.chat_has_permission = r1;
        }

        public void setObject_id(int r1) {
            this.object_id = r1;
        }

        public void setObject_token(String r1) {
            this.object_token = r1;
        }

        public void setObject_type(int r1) {
            this.object_type = r1;
        }

        public void setOwner_id(String r1) {
            this.owner_id = r1;
        }

        public void setOwner_name(String r1) {
            this.owner_name = r1;
        }

        public void setPerm_type(int r1) {
            this.perm_type = r1;
        }

        public void setSender_has_permission(boolean r1) {
            this.sender_has_permission = r1;
        }

        public void setSender_has_share_permission(boolean r1) {
            this.sender_has_share_permission = r1;
        }

        public void setTitle(String r1) {
            this.title = r1;
        }

        public void setToken(String r1) {
            this.token = r1;
        }

        public void setWiki(boolean r1) {
            this.isWiki = r1;
        }
    }

    public EmbededDocumentInfo() {
        this.success = false;
    }

    public EmbededData getResult() {
        return this.result;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setResult(EmbededData r1) {
        this.result = r1;
    }

    public void setSuccess(boolean r1) {
        this.success = r1;
    }
}
