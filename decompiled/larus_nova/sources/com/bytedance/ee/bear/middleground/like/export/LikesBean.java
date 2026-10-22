package com.bytedance.ee.bear.middleground.like.export;

import java.io.Serializable;

/* JADX INFO: loaded from: classes18.dex */
public class LikesBean implements Serializable {
    private int create_time;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f232804id;
    private int like_type;
    private int refer_type;
    private int update_time;
    private String user_id;

    public LikesBean() {
    }

    public String toString() {
        return "LikesBean{create_time=" + this.create_time + ", id='" + this.f232804id + "', like_type=" + this.like_type + ", refer_type=" + this.refer_type + ", update_time=" + this.update_time + ", user_id='" + this.user_id + "'}";
    }

    public int getCreate_time() {
        return this.create_time;
    }

    public String getId() {
        return this.f232804id;
    }

    public int getLike_type() {
        return this.like_type;
    }

    public int getRefer_type() {
        return this.refer_type;
    }

    public int getUpdate_time() {
        return this.update_time;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setCreate_time(int r100) {
        this.create_time = r100;
    }

    public void setId(String r100) {
        this.f232804id = r100;
    }

    public void setLike_type(int r100) {
        this.like_type = r100;
    }

    public void setRefer_type(int r100) {
        this.refer_type = r100;
    }

    public void setUpdate_time(int r100) {
        this.update_time = r100;
    }

    public void setUser_id(String r100) {
        this.user_id = r100;
    }
}
