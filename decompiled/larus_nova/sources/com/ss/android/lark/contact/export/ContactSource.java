package com.ss.android.lark.contact.export;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes35.dex */
public class ContactSource implements Serializable {
    public static final String SUB_TYPE_IN_MEETING = "sub_type_in_meeting";
    private static final long serialVersionUID = 6988230933246958495L;
    private String mFromTag;
    private String sender;
    private String senderId;
    private String sourceId;
    private String sourceName;
    private int sourceType;
    private String subSourceType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SourceType {
        public static final int CALENDAR = 3;
        public static final int CHAT = 2;
        public static final int COMMUNITY = 11;
        public static final int CONTACTCARDS = 14;
        public static final int CONTACT_EXTERNAL = 17;
        public static final int CONTACT_NEW = 18;
        public static final int DOCS = 4;
        public static final int EMAIL = 6;
        public static final int LINK = 1;
        public static final int MEEGO = 10001;
        public static final int MINUTES = 20;
        public static final int NAME_CARD = 7;
        public static final int PUSH = 10002;
        public static final int SEARCH_CONTACT = 10;
        public static final int SEARCH_DOUBAO_ID = 21;
        public static final int SEARCH_EMAIL = 9;
        public static final int SEARCH_PHONE = 8;
        public static final int SPECIAL_FOCUS = 19;
        public static final int UNKNOWN_SOURCE = 0;
        public static final int VC = 5;
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f419442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f419443b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f419444c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f419445d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f419446e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f419447f;

        public a() {
        }
    }

    public ContactSource() {
    }

    public String getFromTag() {
        return this.mFromTag;
    }

    public String getSender() {
        return this.sender;
    }

    public String getSenderId() {
        return this.senderId;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public String getSubSourceType() {
        return this.subSourceType;
    }

    public ContactSource(a r100) {
        this.sender = r100.f419442a;
        this.sourceType = r100.f419443b;
        this.sourceName = r100.f419444c;
        this.senderId = r100.f419445d;
        this.sourceId = r100.f419446e;
        this.subSourceType = r100.f419447f;
        this.mFromTag = null;
    }

    public void setFromTag(String r100) {
        this.mFromTag = r100;
    }

    public void setSender(String r100) {
        this.sender = r100;
    }

    public void setSenderId(String r100) {
        this.senderId = r100;
    }

    public void setSourceId(String r100) {
        this.sourceId = r100;
    }

    public void setSourceName(String r100) {
        this.sourceName = r100;
    }

    public void setSourceType(int r100) {
        this.sourceType = r100;
    }

    public void setSubSourceType(String r100) {
        this.subSourceType = r100;
    }
}
