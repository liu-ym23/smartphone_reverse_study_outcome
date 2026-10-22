package com.bytedance.ee.bear.middleground.like.export;

import java.io.Serializable;

/* JADX INFO: loaded from: classes18.dex */
public class UsersBean implements Serializable {
    private String avatar_url;
    private String en_name;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f232805id;
    private String name;

    public UsersBean() {
    }

    public String toString() {
        return "UsersBean{avatar_url='" + this.avatar_url + "', en_name='" + this.en_name + "', id='" + this.f232805id + "', name='" + this.name + "'}";
    }

    public String getAvatar_url() {
        return this.avatar_url;
    }

    public String getEn_name() {
        return this.en_name;
    }

    public String getId() {
        return this.f232805id;
    }

    public String getName() {
        return this.name;
    }

    public void setAvatar_url(String r100) {
        this.avatar_url = r100;
    }

    public void setEn_name(String r100) {
        this.en_name = r100;
    }

    public void setId(String r100) {
        this.f232805id = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }
}
