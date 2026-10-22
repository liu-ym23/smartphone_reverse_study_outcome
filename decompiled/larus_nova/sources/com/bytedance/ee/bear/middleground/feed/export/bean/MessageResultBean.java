package com.bytedance.ee.bear.middleground.feed.export.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
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

            public void setCount(long r100) {
                this.count = r100;
            }

            public void setVer(long r100) {
                this.ver = r100;
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

            public void setObjMeta(Map<String, ObjMetaBean> r100) {
                this.objMeta = r100;
            }

            public void setUsers(Map<String, UserEntity> r100) {
                this.users = r100;
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

        public void setBadge(Badge r100) {
            this.badge = r100;
        }

        public void setCode(int r100) {
            this.code = r100;
        }

        public void setCountUnreadMessage(int r100) {
            this.countUnreadMessage = r100;
        }

        public void setDataType(int r100) {
            this.dataType = r100;
        }

        public void setEntities(Entities r100) {
            this.entities = r100;
        }

        public void setHasMore(boolean r100) {
            this.hasMore = r100;
        }

        public void setIsRemind(boolean r100) {
            this.isRemind = r100;
        }

        public void setMessage(List<MessageBean> r100) {
            this.message = r100;
        }

        public void setNoticeList(ArrayList<Notice<?>> r100) {
            this.noticeList = r100;
        }

        public void setPageToken(String r100) {
            this.pageToken = r100;
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

    public void setCode(int r100) {
        this.code = r100;
    }

    public void setData(Data r100) {
        this.data = r100;
    }

    public void setMsg(String r100) {
        this.msg = r100;
    }

    public void setNoSetValue(boolean r100) {
        this.noSetValue = r100;
    }
}
