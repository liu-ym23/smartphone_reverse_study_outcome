package com.bytedance.ee.bear.middleground.like.export;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class LikeUserList implements NonProguard {
    private boolean has_more;
    private List<String> ids;
    private Map<String, LikesBean> likes;
    private Map<String, UsersBean> users;

    public LikeUserList() {
    }

    public String toString() {
        return "LikeUserList{has_more=" + this.has_more + ", likes=" + this.likes + ", users=" + this.users + ", ids=" + this.ids + '}';
    }

    public List<String> getIds() {
        return this.ids;
    }

    public Map<String, LikesBean> getLikes() {
        return this.likes;
    }

    public Map<String, UsersBean> getUsers() {
        return this.users;
    }

    public boolean isHas_more() {
        return this.has_more;
    }

    public void setHas_more(boolean r1) {
        this.has_more = r1;
    }

    public void setIds(List<String> r1) {
        this.ids = r1;
    }

    public void setLikes(Map<String, LikesBean> r1) {
        this.likes = r1;
    }

    public void setUsers(Map<String, UsersBean> r1) {
        this.users = r1;
    }
}
