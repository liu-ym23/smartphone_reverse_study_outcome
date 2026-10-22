package com.ss.android.lark.chat.entity.thread;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public class TopicGroup implements Serializable {
    private Chat chat;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f415370id;
    private Type type;
    private UserSetting userSetting;

    public static final enum TopicGroupRole extends Enum<TopicGroupRole> {
        public static final TopicGroupRole MEMBER = null;
        public static final TopicGroupRole PARTICIPANT = null;
        public static final TopicGroupRole UNAUTHORIZED_USER = null;
        public static final TopicGroupRole UNKNOWN_ROLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TopicGroupRole[] f415371a = null;
        private int value;

        static {
            TopicGroupRole r100 = new TopicGroupRole("UNKNOWN_ROLE", 0, 0);
            UNKNOWN_ROLE = r100;
            TopicGroupRole r101 = new TopicGroupRole("UNAUTHORIZED_USER", 1, 1);
            UNAUTHORIZED_USER = r101;
            TopicGroupRole r102 = new TopicGroupRole("MEMBER", 2, 2);
            MEMBER = r102;
            TopicGroupRole r103 = new TopicGroupRole("PARTICIPANT", 3, 3);
            PARTICIPANT = r103;
            f415371a = new TopicGroupRole[]{r100, r101, r102, r103};
        }

        public static TopicGroupRole[] values() {
            return (TopicGroupRole[]) f415371a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static TopicGroupRole fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return UNKNOWN_ROLE;
        L11:
            return PARTICIPANT;
        L13:
            return MEMBER;
        L15:
            return UNAUTHORIZED_USER;
        }

        public static TopicGroupRole valueOf(String r100) {
            return (TopicGroupRole) a.a(TopicGroupRole.class, r100);
        }

        public static TopicGroupRole valueOf(int r100) {
            return fromValue(r100);
        }

        public TopicGroupRole(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Type extends Enum<Type> {
        public static final Type DEFAULT = null;
        public static final Type NORMAL = null;
        public static final Type UNKNOWN_TYPE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f415372a = null;
        private int value;

        static {
            Type r100 = new Type("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r100;
            Type r101 = new Type(EffectConstants.NORMAL, 1, 1);
            NORMAL = r101;
            Type r102 = new Type("DEFAULT", 2, 2);
            DEFAULT = r102;
            f415372a = new Type[]{r100, r101, r102};
        }

        public static Type[] values() {
            return (Type[]) f415372a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Type fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return UNKNOWN_TYPE;
        L9:
            return DEFAULT;
        L11:
            return NORMAL;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        public static Type valueOf(int r100) {
            return fromValue(r100);
        }

        public Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static class UserSetting implements Serializable {
        private boolean isFavorite;
        private TopicGroupRole topicGroupRole;
        private long updateTime;

        public UserSetting() {
        }

        public TopicGroupRole getTopicGroupRole() {
            return this.topicGroupRole;
        }

        public long getUpdateTime() {
            return this.updateTime;
        }

        public boolean isFavorite() {
            return this.isFavorite;
        }

        public static /* synthetic */ boolean access$000(UserSetting r100) {
            return r100.isFavorite;
        }

        public static /* synthetic */ long access$100(UserSetting r100) {
            return r100.updateTime;
        }

        public void setFavorite(boolean r100) {
            this.isFavorite = r100;
        }

        public void setTopicGroupRole(TopicGroupRole r100) {
            this.topicGroupRole = r100;
        }

        public void setUpdateTime(long r100) {
            this.updateTime = r100;
        }
    }

    public TopicGroup() {
    }

    public String toString() {
        if (this.userSetting == null) goto L7;
        return "TopicGroup{id='" + this.f415370id + "', type=" + this.type + ", role =" + this.userSetting.getTopicGroupRole() + ", isFavorite =" + UserSetting.access$000(this.userSetting) + ", updateTime=" + UserSetting.access$100(this.userSetting) + '}';
    L7:
        return "TopicGroup{id='" + this.f415370id + "', type=" + this.type + ", usersetting =null}";
    }

    public Chat getChat() {
        return this.chat;
    }

    public String getId() {
        return this.f415370id;
    }

    public Type getType() {
        return this.type;
    }

    public UserSetting getUserSetting() {
        return this.userSetting;
    }

    public void setChat(Chat r100) {
        this.chat = r100;
    }

    public void setId(String r100) {
        this.f415370id = r100;
    }

    public void setType(Type r100) {
        this.type = r100;
    }

    public void setUserSetting(UserSetting r100) {
        this.userSetting = r100;
    }
}
