package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class RevisionExtra implements NonProguard {
    private String commentFrontId;
    private String firstReplyId;
    private long reviewTime;
    private String reviewUserId;
    private int revisionStatus;
    private RevisionTypes revisionTag;
    private String revisionTitle;
    private String revisionTitleTranslate;
    private int statusVersion;

    public static final enum RevisionTypes extends Enum<RevisionTypes> implements NonProguard {
        private static final /* synthetic */ RevisionTypes[] $VALUES = null;
        public static final RevisionTypes ADD = null;
        public static final RevisionTypes DEL = null;
        public static final RevisionTypes FORMAT = null;
        public static final RevisionTypes REPLACE = null;

        static {
            RevisionTypes r100 = new RevisionTypes("ADD", 0);
            ADD = r100;
            RevisionTypes r101 = new RevisionTypes("DEL", 1);
            DEL = r101;
            RevisionTypes r102 = new RevisionTypes("REPLACE", 2);
            REPLACE = r102;
            RevisionTypes r103 = new RevisionTypes("FORMAT", 3);
            FORMAT = r103;
            $VALUES = new RevisionTypes[]{r100, r101, r102, r103};
        }

        public static RevisionTypes[] values() {
            return (RevisionTypes[]) $VALUES.clone();
        }

        public static RevisionTypes valueOf(String r100) {
            return (RevisionTypes) r27.a.a(RevisionTypes.class, r100);
        }

        private RevisionTypes(String r100, int r101) {
            super(r100, r101);
        }
    }

    public RevisionExtra() {
        this.commentFrontId = "";
        this.revisionTag = RevisionTypes.ADD;
        this.revisionStatus = 0;
        this.reviewUserId = "";
        this.firstReplyId = "";
        this.revisionTitle = "";
        this.revisionTitleTranslate = "";
    }

    public String getCommentFrontId() {
        return this.commentFrontId;
    }

    public String getFirstReplyId() {
        return this.firstReplyId;
    }

    public long getReviewTime() {
        return this.reviewTime;
    }

    public String getReviewUserId() {
        return this.reviewUserId;
    }

    public int getRevisionStatus() {
        return this.revisionStatus;
    }

    public RevisionTypes getRevisionTag() {
        return this.revisionTag;
    }

    public String getRevisionTitle() {
        return this.revisionTitle;
    }

    public String getRevisionTitleTranslate() {
        return this.revisionTitleTranslate;
    }

    public int getStatusVersion() {
        return this.statusVersion;
    }

    public void setCommentFrontId(String r100) {
        this.commentFrontId = r100;
    }

    public void setFirstReplyId(String r100) {
        this.firstReplyId = r100;
    }

    public void setReviewTime(long r100) {
        this.reviewTime = r100;
    }

    public void setReviewUserId(String r100) {
        this.reviewUserId = r100;
    }

    public void setRevisionStatus(int r100) {
        this.revisionStatus = r100;
    }

    public void setRevisionTag(RevisionTypes r100) {
        this.revisionTag = r100;
    }

    public void setRevisionTitle(String r100) {
        this.revisionTitle = r100;
    }

    public void setRevisionTitleTranslate(String r100) {
        this.revisionTitleTranslate = r100;
    }

    public void setStatusVersion(int r100) {
        this.statusVersion = r100;
    }
}
