package com.bytedance.ee.bear.middleground.like.export;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class UsersBean implements Serializable {
    private String avatar_url;
    private String en_name;
    private String id;
    private String name;

    public UsersBean() {
    }

    public String toString() {
        return "UsersBean{avatar_url='" + this.avatar_url + "', en_name='" + this.en_name + "', id='" + this.id + "', name='" + this.name + "'}";
    }

    public String getAvatar_url() {
        return this.avatar_url;
    }

    public String getEn_name() {
        return this.en_name;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setAvatar_url(String r1) {
        this.avatar_url = r1;
    }

    public void setEn_name(String r1) {
        this.en_name = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }
}
