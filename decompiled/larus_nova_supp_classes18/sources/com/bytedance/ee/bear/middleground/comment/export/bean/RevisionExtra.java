package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
            RevisionTypes r0 = new RevisionTypes("ADD", 0);
            ADD = r0;
            RevisionTypes r1 = new RevisionTypes("DEL", 1);
            DEL = r1;
            RevisionTypes r3 = new RevisionTypes("REPLACE", 2);
            REPLACE = r3;
            RevisionTypes r5 = new RevisionTypes("FORMAT", 3);
            FORMAT = r5;
            $VALUES = new RevisionTypes[]{r0, r1, r3, r5};
        }

        public static RevisionTypes[] values() {
            return (RevisionTypes[]) $VALUES.clone();
        }

        public static RevisionTypes valueOf(String r1) {
            return (RevisionTypes) r27.a.a(RevisionTypes.class, r1);
        }

        private RevisionTypes(String r1, int r2) {
            super(r1, r2);
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

    public void setCommentFrontId(String r1) {
        this.commentFrontId = r1;
    }

    public void setFirstReplyId(String r1) {
        this.firstReplyId = r1;
    }

    public void setReviewTime(long r1) {
        this.reviewTime = r1;
    }

    public void setReviewUserId(String r1) {
        this.reviewUserId = r1;
    }

    public void setRevisionStatus(int r1) {
        this.revisionStatus = r1;
    }

    public void setRevisionTag(RevisionTypes r1) {
        this.revisionTag = r1;
    }

    public void setRevisionTitle(String r1) {
        this.revisionTitle = r1;
    }

    public void setRevisionTitleTranslate(String r1) {
        this.revisionTitleTranslate = r1;
    }

    public void setStatusVersion(int r1) {
        this.statusVersion = r1;
    }
}
