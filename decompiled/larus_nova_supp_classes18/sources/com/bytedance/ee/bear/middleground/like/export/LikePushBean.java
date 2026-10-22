package com.bytedance.ee.bear.middleground.like.export;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class LikePushBean implements NonProguard {
    private List<AheadUsersBean> ahead_users;
    private String avatar_url;
    private int code;
    private int count;
    private int create_time;
    private String en_name;
    private String id;
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
        private String id;
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
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public String getTenant_id() {
            return this.tenant_id;
        }

        public void setAvatar_url(String r1) {
            this.avatar_url = r1;
        }

        public void setCreate_time(int r1) {
            this.create_time = r1;
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

        public void setTenant_id(String r1) {
            this.tenant_id = r1;
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
        return this.id;
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

    public void setAhead_users(List<AheadUsersBean> r1) {
        this.ahead_users = r1;
    }

    public void setAvatar_url(String r1) {
        this.avatar_url = r1;
    }

    public void setCode(int r1) {
        this.code = r1;
    }

    public void setCount(int r1) {
        this.count = r1;
    }

    public void setCreate_time(int r1) {
        this.create_time = r1;
    }

    public void setEn_name(String r1) {
        this.en_name = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setIs_liked(boolean r1) {
        this.is_liked = r1;
    }

    public void setLike_type(int r1) {
        this.like_type = r1;
    }

    public void setMsg(String r1) {
        this.msg = r1;
    }

    public void setTenant_id(String r1) {
        this.tenant_id = r1;
    }

    public void setType(String r1) {
        this.type = r1;
    }

    public void setUser_id(String r1) {
        this.user_id = r1;
    }

    public void setUser_name(String r1) {
        this.user_name = r1;
    }
}
