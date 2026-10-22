package com.bytedance.ee.bear.middleground.like.export;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class LikesBean implements Serializable {
    private int create_time;
    private String id;
    private int like_type;
    private int refer_type;
    private int update_time;
    private String user_id;

    public LikesBean() {
    }

    public String toString() {
        return "LikesBean{create_time=" + this.create_time + ", id='" + this.id + "', like_type=" + this.like_type + ", refer_type=" + this.refer_type + ", update_time=" + this.update_time + ", user_id='" + this.user_id + "'}";
    }

    public int getCreate_time() {
        return this.create_time;
    }

    public String getId() {
        return this.id;
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

    public void setCreate_time(int r1) {
        this.create_time = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setLike_type(int r1) {
        this.like_type = r1;
    }

    public void setRefer_type(int r1) {
        this.refer_type = r1;
    }

    public void setUpdate_time(int r1) {
        this.update_time = r1;
    }

    public void setUser_id(String r1) {
        this.user_id = r1;
    }
}
