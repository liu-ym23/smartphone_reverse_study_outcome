package com.ss.android.lark.chat.export.entity.message.content;

import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class SystemMessageAction implements Serializable {
    private static final long serialVersionUID = -8206074036251753606L;
    private ActType actType;

    public static final enum ActType extends Enum<ActType> {
        public static final ActType INVITE_AT_CHATTERS = null;
        public static final ActType UNKNOWN_ACT_TYPE = null;
        public static final ActType URL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ActType[] f415399a = null;
        int value;

        static {
            ActType r100 = new ActType("UNKNOWN_ACT_TYPE", 0, 0);
            UNKNOWN_ACT_TYPE = r100;
            ActType r101 = new ActType("INVITE_AT_CHATTERS", 1, 1);
            INVITE_AT_CHATTERS = r101;
            ActType r102 = new ActType("URL", 2, 2);
            URL = r102;
            f415399a = new ActType[]{r100, r101, r102};
        }

        public static ActType[] values() {
            return (ActType[]) f415399a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static ActType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return UNKNOWN_ACT_TYPE;
        L10:
            return URL;
        L12:
            return INVITE_AT_CHATTERS;
        L14:
            return UNKNOWN_ACT_TYPE;
        }

        public static ActType valueOf(String r100) {
            return (ActType) r27.a.a(ActType.class, r100);
        }

        public ActType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public ActType getActType() {
        return this.actType;
    }

    public SystemMessageAction(ActType r100) {
        this.actType = r100;
    }

    public void setActType(ActType r100) {
        this.actType = r100;
    }
}
