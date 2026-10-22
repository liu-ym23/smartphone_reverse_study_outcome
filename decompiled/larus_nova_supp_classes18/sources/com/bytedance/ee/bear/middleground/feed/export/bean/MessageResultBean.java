package com.bytedance.ee.bear.middleground.feed.export.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MessageResultBean implements NonProguard {
    public static final int USE_MESSAGE = 1;
    public static final int USE_NOTICE_LIST = 2;
    private int code;
    private Data data;
    private String msg;
    private boolean noSetValue;

    public static class Data implements NonProguard {
        private Badge badge;
        private int code;
        private int countUnreadMessage;
        private int dataType;
        private Entities entities;
        private boolean hasMore;

        @SerializedName("is_remind")
        @JSONField(name = "is_remind")
        private boolean isRemind;
        private List<MessageBean> message;
        private ArrayList<Notice<?>> noticeList;
        private String pageToken;

        public static class Badge implements NonProguard {
            private long count;
            private long ver;

            public Badge() {
                this.ver = 0;
                this.count = 0;
            }

            public long getCount() {
                return this.count;
            }

            public long getVer() {
                return this.ver;
            }

            public void setCount(long r1) {
                this.count = r1;
            }

            public void setVer(long r1) {
                this.ver = r1;
            }
        }

        public static class Entities implements NonProguard {

            @JSONField(name = "obj_meta")
            private Map<String, ObjMetaBean> objMeta;
            private Map<String, UserEntity> users;

            public Entities() {
            }

            public Map<String, ObjMetaBean> getObjMeta() {
                return this.objMeta;
            }

            public Map<String, UserEntity> getUsers() {
                return this.users;
            }

            public void setObjMeta(Map<String, ObjMetaBean> r1) {
                this.objMeta = r1;
            }

            public void setUsers(Map<String, UserEntity> r1) {
                this.users = r1;
            }
        }

        public Data() {
            this.isRemind = true;
            this.dataType = 1;
            this.hasMore = false;
            this.pageToken = "";
            this.noticeList = null;
            this.code = 0;
        }

        public Badge getBadge() {
            return this.badge;
        }

        public int getCode() {
            return this.code;
        }

        public int getCountUnreadMessage() {
            return this.countUnreadMessage;
        }

        public int getDataType() {
            return this.dataType;
        }

        public Entities getEntities() {
            return this.entities;
        }

        public List<MessageBean> getMessage() {
            return this.message;
        }

        public ArrayList<Notice<?>> getNoticeList() {
            return this.noticeList;
        }

        public String getPageToken() {
            return this.pageToken;
        }

        public boolean isHasMore() {
            return this.hasMore;
        }

        public boolean isRemind() {
            return this.isRemind;
        }

        public void setBadge(Badge r1) {
            this.badge = r1;
        }

        public void setCode(int r1) {
            this.code = r1;
        }

        public void setCountUnreadMessage(int r1) {
            this.countUnreadMessage = r1;
        }

        public void setDataType(int r1) {
            this.dataType = r1;
        }

        public void setEntities(Entities r1) {
            this.entities = r1;
        }

        public void setHasMore(boolean r1) {
            this.hasMore = r1;
        }

        public void setIsRemind(boolean r1) {
            this.isRemind = r1;
        }

        public void setMessage(List<MessageBean> r1) {
            this.message = r1;
        }

        public void setNoticeList(ArrayList<Notice<?>> r1) {
            this.noticeList = r1;
        }

        public void setPageToken(String r1) {
            this.pageToken = r1;
        }
    }

    public MessageResultBean() {
        this.noSetValue = false;
    }

    public int getCode() {
        return this.code;
    }

    public Data getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public boolean isNoSetValue() {
        return this.noSetValue;
    }

    public void setCode(int r1) {
        this.code = r1;
    }

    public void setData(Data r1) {
        this.data = r1;
    }

    public void setMsg(String r1) {
        this.msg = r1;
    }

    public void setNoSetValue(boolean r1) {
        this.noSetValue = r1;
    }
}
