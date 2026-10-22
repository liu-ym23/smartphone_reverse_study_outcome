package com.bytedance.ee.bear.document.editionmanager.data;

import du5.b;
import java.io.Serializable;

/* JADX INFO: loaded from: classes16.dex */
public class VersionMetasBean implements Serializable {
    private Long create_time;
    private String creator_id;
    private int delete_flag;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f219613id;
    private String name;
    private String obj_id;
    private int obj_type;
    private String owner_id;
    private String parent_id;
    private String parent_token;
    private int parent_type;
    private String token;
    private Long update_time;
    private String version;

    public VersionMetasBean() {
    }

    public String toString() {
        return b.g("VersionMetaBean{create_time=" + this.create_time + ", creator_id=" + this.creator_id + ", delete_flag=" + this.delete_flag + ", id=" + this.f219613id + ", name='" + this.name + "', obj_id=" + this.obj_id + ", obj_type=" + this.obj_type + ", owner_id=" + this.owner_id + ", parent_id=" + this.parent_id + ", parent_token='" + this.parent_token + "', parent_type=" + this.parent_type + ", token='" + this.token + "', update_time=" + this.update_time + ", version='" + this.version + "'}");
    }

    public Long getCreate_time() {
        return this.create_time;
    }

    public String getCreator_id() {
        return this.creator_id;
    }

    public int getDelete_flag() {
        return this.delete_flag;
    }

    public String getId() {
        return this.f219613id;
    }

    public String getName() {
        return this.name;
    }

    public String getObj_id() {
        return this.obj_id;
    }

    public int getObj_type() {
        return this.obj_type;
    }

    public String getOwner_id() {
        return this.owner_id;
    }

    public String getParent_id() {
        return this.parent_id;
    }

    public String getParent_token() {
        return this.parent_token;
    }

    public int getParent_type() {
        return this.parent_type;
    }

    public String getToken() {
        return this.token;
    }

    public Long getUpdate_time() {
        return this.update_time;
    }

    public String getVersion() {
        return this.version;
    }

    public void setCreate_time(Long r100) {
        this.create_time = r100;
    }

    public void setCreator_id(String r100) {
        this.creator_id = r100;
    }

    public void setDelete_flag(int r100) {
        this.delete_flag = r100;
    }

    public void setId(String r100) {
        this.f219613id = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setObj_id(String r100) {
        this.obj_id = r100;
    }

    public void setObj_type(int r100) {
        this.obj_type = r100;
    }

    public void setOwner_id(String r100) {
        this.owner_id = r100;
    }

    public void setParent_id(String r100) {
        this.parent_id = r100;
    }

    public void setParent_token(String r100) {
        this.parent_token = r100;
    }

    public void setParent_type(int r100) {
        this.parent_type = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setUpdate_time(Long r100) {
        this.update_time = r100;
    }

    public void setVersion(String r100) {
        this.version = r100;
    }
}
