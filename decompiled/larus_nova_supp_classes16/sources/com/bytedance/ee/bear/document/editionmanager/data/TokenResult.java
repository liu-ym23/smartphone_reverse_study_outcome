package com.bytedance.ee.bear.document.editionmanager.data;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class TokenResult implements Serializable {
    private int can_set_sec_label;
    private String create_date;
    private int create_source;
    private int create_time;
    private String create_uid;
    private String create_user_name;
    private int delete_flag;
    private int edit_time;
    private String edit_user_name;
    private int get_sec_label_code;
    private boolean is_external;
    private boolean is_pined;
    private boolean is_stared;
    private String obj_id;
    private String obj_type;
    private String owner_id;
    private String owner_user_name;
    private int real_sub_type;
    private int sec_label_type;
    private int server_time;
    private String sub_type;
    private int template_type;
    private String tenant_id;
    private String title;
    private boolean title_secure_key_deleted;
    private int type;
    private String url;
    private int version;

    public TokenResult() {
    }

    public int getCan_set_sec_label() {
        return this.can_set_sec_label;
    }

    public String getCreate_date() {
        return this.create_date;
    }

    public int getCreate_source() {
        return this.create_source;
    }

    public int getCreate_time() {
        return this.create_time;
    }

    public String getCreate_uid() {
        return this.create_uid;
    }

    public String getCreate_user_name() {
        return this.create_user_name;
    }

    public int getDelete_flag() {
        return this.delete_flag;
    }

    public int getEdit_time() {
        return this.edit_time;
    }

    public String getEdit_user_name() {
        return this.edit_user_name;
    }

    public int getGet_sec_label_code() {
        return this.get_sec_label_code;
    }

    public String getObj_id() {
        return this.obj_id;
    }

    public String getObj_type() {
        return this.obj_type;
    }

    public String getOwner_id() {
        return this.owner_id;
    }

    public String getOwner_user_name() {
        return this.owner_user_name;
    }

    public int getReal_sub_type() {
        return this.real_sub_type;
    }

    public int getSec_label_type() {
        return this.sec_label_type;
    }

    public int getServer_time() {
        return this.server_time;
    }

    public String getSub_type() {
        return this.sub_type;
    }

    public int getTemplate_type() {
        return this.template_type;
    }

    public String getTenant_id() {
        return this.tenant_id;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public int getVersion() {
        return this.version;
    }

    public boolean isIs_external() {
        return this.is_external;
    }

    public boolean isIs_pined() {
        return this.is_pined;
    }

    public boolean isIs_stared() {
        return this.is_stared;
    }

    public boolean isTitle_secure_key_deleted() {
        return this.title_secure_key_deleted;
    }

    public void setCan_set_sec_label(int r1) {
        this.can_set_sec_label = r1;
    }

    public void setCreate_date(String r1) {
        this.create_date = r1;
    }

    public void setCreate_source(int r1) {
        this.create_source = r1;
    }

    public void setCreate_time(int r1) {
        this.create_time = r1;
    }

    public void setCreate_uid(String r1) {
        this.create_uid = r1;
    }

    public void setCreate_user_name(String r1) {
        this.create_user_name = r1;
    }

    public void setDelete_flag(int r1) {
        this.delete_flag = r1;
    }

    public void setEdit_time(int r1) {
        this.edit_time = r1;
    }

    public void setEdit_user_name(String r1) {
        this.edit_user_name = r1;
    }

    public void setGet_sec_label_code(int r1) {
        this.get_sec_label_code = r1;
    }

    public void setIs_external(boolean r1) {
        this.is_external = r1;
    }

    public void setIs_pined(boolean r1) {
        this.is_pined = r1;
    }

    public void setIs_stared(boolean r1) {
        this.is_stared = r1;
    }

    public void setObj_id(String r1) {
        this.obj_id = r1;
    }

    public void setObj_type(String r1) {
        this.obj_type = r1;
    }

    public void setOwner_id(String r1) {
        this.owner_id = r1;
    }

    public void setOwner_user_name(String r1) {
        this.owner_user_name = r1;
    }

    public void setReal_sub_type(int r1) {
        this.real_sub_type = r1;
    }

    public void setSec_label_type(int r1) {
        this.sec_label_type = r1;
    }

    public void setServer_time(int r1) {
        this.server_time = r1;
    }

    public void setSub_type(String r1) {
        this.sub_type = r1;
    }

    public void setTemplate_type(int r1) {
        this.template_type = r1;
    }

    public void setTenant_id(String r1) {
        this.tenant_id = r1;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }

    public void setTitle_secure_key_deleted(boolean r1) {
        this.title_secure_key_deleted = r1;
    }

    public void setType(int r1) {
        this.type = r1;
    }

    public void setUrl(String r1) {
        this.url = r1;
    }

    public void setVersion(int r1) {
        this.version = r1;
    }
}
