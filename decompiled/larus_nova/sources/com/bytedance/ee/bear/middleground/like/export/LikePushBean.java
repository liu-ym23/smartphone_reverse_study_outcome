package com.bytedance.ee.bear.middleground.like.export;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class LikePushBean implements NonProguard {
    private List<AheadUsersBean> ahead_users;
    private String avatar_url;
    private int code;
    private int count;
    private int create_time;
    private String en_name;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f232802id;
    private boolean is_liked;
    private int like_type;
    private String msg;
    private String tenant_id;
    private String type;
    private String user_id;
    private String user_name;

    public static class AheadUsersBean implements NonProguard {
        private String avatar_url;
        private int create_time;
        private String en_name;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f232803id;
        private String name;
        private String tenant_id;

        public AheadUsersBean() {
        }

        public String getAvatar_url() {
            return this.avatar_url;
        }

        public int getCreate_time() {
            return this.create_time;
        }

        public String getEn_name() {
            return this.en_name;
        }

        public String getId() {
            return this.f232803id;
        }

        public String getName() {
            return this.name;
        }

        public String getTenant_id() {
            return this.tenant_id;
        }

        public void setAvatar_url(String r100) {
            this.avatar_url = r100;
        }

        public void setCreate_time(int r100) {
            this.create_time = r100;
        }

        public void setEn_name(String r100) {
            this.en_name = r100;
        }

        public void setId(String r100) {
            this.f232803id = r100;
        }

        public void setName(String r100) {
            this.name = r100;
        }

        public void setTenant_id(String r100) {
            this.tenant_id = r100;
        }
    }

    public LikePushBean() {
    }

    public List<AheadUsersBean> getAhead_users() {
        return this.ahead_users;
    }

    public String getAvatar_url() {
        return this.avatar_url;
    }

    public int getCode() {
        return this.code;
    }

    public int getCount() {
        return this.count;
    }

    public int getCreate_time() {
        return this.create_time;
    }

    public String getEn_name() {
        return this.en_name;
    }

    public String getId() {
        return this.f232802id;
    }

    public int getLike_type() {
        return this.like_type;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getTenant_id() {
        return this.tenant_id;
    }

    public String getType() {
        return this.type;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public boolean isIs_liked() {
        return this.is_liked;
    }

    public void setAhead_users(List<AheadUsersBean> r100) {
        this.ahead_users = r100;
    }

    public void setAvatar_url(String r100) {
        this.avatar_url = r100;
    }

    public void setCode(int r100) {
        this.code = r100;
    }

    public void setCount(int r100) {
        this.count = r100;
    }

    public void setCreate_time(int r100) {
        this.create_time = r100;
    }

    public void setEn_name(String r100) {
        this.en_name = r100;
    }

    public void setId(String r100) {
        this.f232802id = r100;
    }

    public void setIs_liked(boolean r100) {
        this.is_liked = r100;
    }

    public void setLike_type(int r100) {
        this.like_type = r100;
    }

    public void setMsg(String r100) {
        this.msg = r100;
    }

    public void setTenant_id(String r100) {
        this.tenant_id = r100;
    }

    public void setType(String r100) {
        this.type = r100;
    }

    public void setUser_id(String r100) {
        this.user_id = r100;
    }

    public void setUser_name(String r100) {
        this.user_name = r100;
    }
}
