package com.ss.android.lark.chat.entity;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public class Channel implements Serializable {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f415090id;
    private Type type;

    public static final enum Type extends Enum<Type> {
        public static final Type APP = null;
        public static final Type APP_FEED = null;
        public static final Type CHAT = null;
        public static final Type DOC = null;
        public static final Type EMAIL = null;
        public static final Type OPEN_APP_CHAT = null;
        public static final Type SUBSCRIPTION = null;
        public static final Type UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f415091a = null;
        private int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("CHAT", 1, 1);
            CHAT = r101;
            Type r102 = new Type(CommonConstant.RETKEY.EMAIL, 2, 2);
            EMAIL = r102;
            Type r103 = new Type(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 3, 3);
            DOC = r103;
            Type r104 = new Type("APP", 4, 4);
            APP = r104;
            Type r105 = new Type("OPEN_APP_CHAT", 5, 5);
            OPEN_APP_CHAT = r105;
            Type r110 = new Type("SUBSCRIPTION", 6, 10);
            SUBSCRIPTION = r110;
            Type r111 = new Type("APP_FEED", 7, 13);
            APP_FEED = r111;
            f415091a = new Type[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static Type[] values() {
            return (Type[]) f415091a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Type forNumber(int r100) {
            if (r100 == 0) goto L34;
            if (r100 == 1) goto L32;
            if (r100 == 2) goto L30;
            if (r100 == 3) goto L28;
            if (r100 == 4) goto L26;
            if (r100 == 5) goto L24;
            if (r100 == 10) goto L22;
            if (r100 == 13) goto L20;
            return UNKNOWN;
        L20:
            return APP_FEED;
        L22:
            return SUBSCRIPTION;
        L24:
            return OPEN_APP_CHAT;
        L26:
            return APP;
        L28:
            return DOC;
        L30:
            return EMAIL;
        L32:
            return CHAT;
        L34:
            return UNKNOWN;
        }

        public static Type fromFeedType(int r100) {
            if (r100 == 1) goto L31;
            if (r100 == 2) goto L29;
            if (r100 == 3) goto L27;
            if (r100 == 6) goto L25;
            if (r100 == 8) goto L23;
            if (r100 == 10) goto L21;
            if (r100 == 13) goto L19;
            return UNKNOWN;
        L19:
            return APP_FEED;
        L21:
            return SUBSCRIPTION;
        L23:
            return OPEN_APP_CHAT;
        L25:
            return APP;
        L27:
            return DOC;
        L29:
            return EMAIL;
        L31:
            return CHAT;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        public static Type valueOf(int r100) {
            return forNumber(r100);
        }

        public Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public String toString() {
        return "Channel{id='" + this.f415090id + "', type=" + this.type + '}';
    }

    public String getId() {
        return this.f415090id;
    }

    public Type getType() {
        return this.type;
    }

    public void setId(String r100) {
        this.f415090id = r100;
    }

    public void setType(Type r100) {
        this.type = r100;
    }

    public Channel(int r100, String r101) {
        this.type = Type.valueOf(r100);
        this.f415090id = r101;
    }

    public Channel(Type r100, String r101) {
        this.type = r100;
        this.f415090id = r101;
    }
}
