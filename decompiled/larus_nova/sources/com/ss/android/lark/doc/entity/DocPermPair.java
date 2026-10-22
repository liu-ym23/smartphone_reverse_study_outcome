package com.ss.android.lark.doc.entity;

import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public class DocPermPair implements Serializable {
    private String docToken;
    private String messageId;
    private PermType perm;

    public static final enum PermType extends Enum<PermType> {
        public static final PermType EDIT = null;
        public static final PermType FORBIDDEN = null;
        public static final PermType READ = null;
        public static final PermType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PermType[] f420493a = null;
        private int value;

        static {
            PermType r100 = new PermType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            PermType r101 = new PermType("READ", 1, 1);
            READ = r101;
            PermType r102 = new PermType("EDIT", 2, 4);
            EDIT = r102;
            PermType r103 = new PermType("FORBIDDEN", 3, 501);
            FORBIDDEN = r103;
            f420493a = new PermType[]{r100, r101, r102, r103};
        }

        public static PermType[] values() {
            return (PermType[]) f420493a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static PermType forNumber(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 4) goto L14;
            if (r100 == 501) goto L12;
            return UNKNOWN;
        L12:
            return FORBIDDEN;
        L14:
            return EDIT;
        L16:
            return READ;
        L18:
            return UNKNOWN;
        }

        public static PermType valueOf(String r100) {
            return (PermType) a.a(PermType.class, r100);
        }

        public static PermType valueOf(int r100) {
            return forNumber(r100);
        }

        public PermType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public String getDocToken() {
        return this.docToken;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public PermType getPerm() {
        return this.perm;
    }

    public void setDocToken(String r100) {
        this.docToken = r100;
    }

    public void setMessageId(String r100) {
        this.messageId = r100;
    }

    public void setPerm(PermType r100) {
        this.perm = r100;
    }

    public DocPermPair(String r100, String r101, PermType r102) {
        this.messageId = r100;
        this.docToken = r101;
        this.perm = r102;
    }
}
