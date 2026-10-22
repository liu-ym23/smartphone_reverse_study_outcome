package com.ss.android.lark.doc.entity;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public class DocMessage implements Serializable {
    private String content;
    private long createTime;
    private String docFeedId;
    private String fromId;
    private String fromName;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f420491id;
    private Type type;
    private long updateTime;

    public static final enum Type extends Enum<Type> {
        public static final Type COMMENT = null;
        public static final Type MENTION = null;
        public static final Type REACTION = null;
        public static final Type REOPEN = null;
        public static final Type REPLY = null;
        public static final Type SHARE = null;
        public static final Type SOLVE = null;
        public static final Type UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f420492a = null;
        private int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("MENTION", 1, 1);
            MENTION = r101;
            Type r102 = new Type("COMMENT", 2, 2);
            COMMENT = r102;
            Type r103 = new Type("REPLY", 3, 3);
            REPLY = r103;
            Type r104 = new Type("SOLVE", 4, 4);
            SOLVE = r104;
            Type r105 = new Type("SHARE", 5, 5);
            SHARE = r105;
            Type r110 = new Type("REOPEN", 6, 6);
            REOPEN = r110;
            Type r111 = new Type(CardAdapter.REACTION, 7, 7);
            REACTION = r111;
            f420492a = new Type[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static Type[] values() {
            return (Type[]) f420492a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Type forNumber(int r100) {
            switch(r100) {
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L4;
            };
        L4:
            return UNKNOWN;
        L6:
            return REACTION;
        L8:
            return REOPEN;
        L10:
            return SHARE;
        L12:
            return SOLVE;
        L14:
            return REPLY;
        L16:
            return COMMENT;
        L18:
            return MENTION;
        L20:
            return UNKNOWN;
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

    public DocMessage() {
    }

    public String getContent() {
        return this.content;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getDocFeedId() {
        return this.docFeedId;
    }

    public String getFromId() {
        return this.fromId;
    }

    public String getFromName() {
        return this.fromName;
    }

    public String getId() {
        return this.f420491id;
    }

    public Type getType() {
        return this.type;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this != r100) goto L9;
        return true;
    L9:
        if ((r100 instanceof DocMessage) == true) goto L11;
        return false;
    L11:
        DocMessage r101 = (DocMessage) r100;
        String r102 = this.f420491id;
        if (r102 == null) goto L14;
        boolean r103 = r102.equals(r101.getId());
    L18:
        if (r103 == true) goto L20;
        return false;
    L20:
        Type r104 = this.type;
        if (r104 == null) goto L23;
        boolean r105 = r104.equals(r101.getType());
    L27:
        if (r105 == true) goto L29;
        return false;
    L29:
        String r106 = this.docFeedId;
        String r107 = r101.getDocFeedId();
        if (r106 != null) goto L34;
        if (r107 != null) goto L35;
        return true;
    L35:
        return false;
    L34:
        return r106.equals(r107);
    L23:
        if (r101.getType() != null) goto L25;
        r105 = true;
        goto L27
    L25:
        r105 = false;
        goto L27
    L14:
        if (r101.getId() != null) goto L16;
        r103 = true;
        goto L18
    L16:
        r103 = false;
        goto L18
    }

    public boolean exactlyCompare(DocMessage r100) {
        return equals(r100);
    }

    public void setContent(String r100) {
        this.content = r100;
    }

    public void setCreateTime(long r100) {
        this.createTime = r100;
    }

    public void setDocFeedId(String r100) {
        this.docFeedId = r100;
    }

    public void setFromId(String r100) {
        this.fromId = r100;
    }

    public void setFromName(String r100) {
        this.fromName = r100;
    }

    public void setId(String r100) {
        this.f420491id = r100;
    }

    public void setType(Type r100) {
        this.type = r100;
    }

    public void setUpdateTime(long r100) {
        this.updateTime = r100;
    }
}
