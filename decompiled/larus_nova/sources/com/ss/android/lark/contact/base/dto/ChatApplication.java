package com.ss.android.lark.contact.base.dto;

import com.bytedance.lark.pb.basic.v1.CertificationInfo;
import com.ss.android.lark.contact.base.entity.ExternalContactSummary;
import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class ChatApplication implements Serializable {
    private long applyTime;
    private CertificationInfo certificationInfo;
    private String chatId;
    private ExternalContactSummary externalContactSummary;
    private String extraMessage;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f418861id;
    private boolean isRead;
    private long processedTime;
    private Status status;
    private Type type;

    public static final enum Status extends Enum<Status> {
        public static final Status AGREED = null;
        public static final Status DELETED = null;
        public static final Status EXPIRED = null;
        public static final Status PEDING = null;
        public static final Status REFUSED = null;
        public static final Status UNKNOWN_STATUS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f418862a = null;
        private int value;

        static {
            Status r100 = new Status("UNKNOWN_STATUS", 0, 0);
            UNKNOWN_STATUS = r100;
            Status r101 = new Status("PEDING", 1, 1);
            PEDING = r101;
            Status r102 = new Status("AGREED", 2, 2);
            AGREED = r102;
            Status r103 = new Status("REFUSED", 3, 3);
            REFUSED = r103;
            Status r104 = new Status("DELETED", 4, 4);
            DELETED = r104;
            Status r105 = new Status("EXPIRED", 5, 5);
            EXPIRED = r105;
            f418862a = new Status[]{r100, r101, r102, r103, r104, r105};
        }

        public static Status[] values() {
            return (Status[]) f418862a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Status forNumber(int r100) {
            if (r100 == 0) goto L26;
            if (r100 == 1) goto L24;
            if (r100 == 2) goto L22;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L18;
            if (r100 == 5) goto L16;
            return null;
        L16:
            return EXPIRED;
        L18:
            return DELETED;
        L20:
            return REFUSED;
        L22:
            return AGREED;
        L24:
            return PEDING;
        L26:
            return UNKNOWN_STATUS;
        }

        public static Status valueOf(String r100) {
            return (Status) r27.a.a(Status.class, r100);
        }

        public static Status valueOf(int r100) {
            return forNumber(r100);
        }

        public Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Type extends Enum<Type> {
        public static final Type FRIEND = null;
        public static final Type JOIN_CHAT = null;
        public static final Type UNKNOWN_TYPE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f418863a = null;
        private int value;

        static {
            Type r100 = new Type("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r100;
            Type r101 = new Type("FRIEND", 1, 1);
            FRIEND = r101;
            Type r102 = new Type("JOIN_CHAT", 2, 2);
            JOIN_CHAT = r102;
            f418863a = new Type[]{r100, r101, r102};
        }

        public static Type[] values() {
            return (Type[]) f418863a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Type forNumber(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return JOIN_CHAT;
        L12:
            return FRIEND;
        L14:
            return UNKNOWN_TYPE;
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public static Type valueOf(int r100) {
            return forNumber(r100);
        }

        public Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public ChatApplication() {
    }

    public long getApplyTime() {
        return this.applyTime;
    }

    public CertificationInfo getCertificationInfo() {
        return this.certificationInfo;
    }

    public String getChatId() {
        return this.chatId;
    }

    public ExternalContactSummary getExternalContactSummary() {
        return this.externalContactSummary;
    }

    public String getExtraMessage() {
        return this.extraMessage;
    }

    public String getId() {
        return this.f418861id;
    }

    public long getProcessedTime() {
        return this.processedTime;
    }

    public Status getStatus() {
        return this.status;
    }

    public Type getType() {
        return this.type;
    }

    public boolean isRead() {
        return this.isRead;
    }

    public void setApplyTime(long r100) {
        this.applyTime = r100;
    }

    public void setCertificationInfo(CertificationInfo r100) {
        this.certificationInfo = r100;
    }

    public void setChatId(String r100) {
        this.chatId = r100;
    }

    public void setExternalContactSummary(ExternalContactSummary r100) {
        this.externalContactSummary = r100;
    }

    public void setExtraMessage(String r100) {
        this.extraMessage = r100;
    }

    public void setId(String r100) {
        this.f418861id = r100;
    }

    public void setProcessedTime(long r100) {
        this.processedTime = r100;
    }

    public void setRead(boolean r100) {
        this.isRead = r100;
    }

    public void setStatus(Status r100) {
        this.status = r100;
    }

    public void setType(Type r100) {
        this.type = r100;
    }
}
