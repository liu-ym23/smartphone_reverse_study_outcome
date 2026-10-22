package com.ss.android.lark.contact.entity;

import com.ss.android.lark.chat.entity.chat.Chat;
import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public class ChatInfo implements Serializable {
    private static final long serialVersionUID = 6384386750016337646L;
    private Chat chat;
    private boolean isMember;
    private UserPermission userPermission;

    public static final enum UserPermission extends Enum<UserPermission> {
        public static final UserPermission INVISIBLE = null;
        public static final UserPermission UNKNOWN = null;
        public static final UserPermission VISIBLE_AND_CREATE = null;
        public static final UserPermission VISIBLE_NOT_CREATE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ UserPermission[] f419436a = null;
        private int value;

        static {
            UserPermission r100 = new UserPermission("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            UserPermission r101 = new UserPermission("VISIBLE_AND_CREATE", 1, 1);
            VISIBLE_AND_CREATE = r101;
            UserPermission r102 = new UserPermission("VISIBLE_NOT_CREATE", 2, 2);
            VISIBLE_NOT_CREATE = r102;
            UserPermission r103 = new UserPermission("INVISIBLE", 3, 3);
            INVISIBLE = r103;
            f419436a = new UserPermission[]{r100, r101, r102, r103};
        }

        public static UserPermission[] values() {
            return (UserPermission[]) f419436a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static UserPermission forNumber(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return UNKNOWN;
        L12:
            return INVISIBLE;
        L14:
            return VISIBLE_NOT_CREATE;
        L16:
            return VISIBLE_AND_CREATE;
        L18:
            return UNKNOWN;
        }

        public static UserPermission valueOf(String r100) {
            return (UserPermission) a.a(UserPermission.class, r100);
        }

        public static UserPermission valueOf(int r100) {
            return forNumber(r100);
        }

        public UserPermission(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public ChatInfo() {
    }

    public Chat getChat() {
        return this.chat;
    }

    public UserPermission getUserPermission() {
        return this.userPermission;
    }

    public boolean isMember() {
        return this.isMember;
    }

    public void setChat(Chat r100) {
        this.chat = r100;
    }

    public void setMember(boolean r100) {
        this.isMember = r100;
    }

    public void setUserPermission(UserPermission r100) {
        this.userPermission = r100;
    }
}
