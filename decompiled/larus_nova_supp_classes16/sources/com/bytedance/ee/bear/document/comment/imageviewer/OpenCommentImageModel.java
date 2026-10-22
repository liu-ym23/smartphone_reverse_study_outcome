package com.bytedance.ee.bear.document.comment.imageviewer;

import com.bytedance.ee.bear.document.comment.bean.Card;
import com.bytedance.ee.bear.document.comment.bean.Per;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentAreaMark;
import com.bytedance.ee.util.io.NonProguard;
import du5.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OpenCommentImageModel implements NonProguard {
    private int active;
    private Card comment;
    private String commentId;
    private List<CommentImageBean> imageList;
    private Per permission;
    private String replyId;

    public static class CommentImageBean implements NonProguard {
        private ArrayList<CommentAreaMark> areaMark;
        private String originalSrc;
        private String src;
        private String token;

        public int hashCode() {
            return Objects.hash(new Object[]{this.token, this.src, this.originalSrc, this.areaMark});
        }

        public String toString() {
            return "CommentImage{token='" + b.g(this.token) + "', src='" + b.g(this.src) + "', originalSrc='" + b.g(this.originalSrc) + "', areaMark=" + this.areaMark + '}';
        }

        public CommentImageBean() {
            this.areaMark = new ArrayList();
        }

        public ArrayList<CommentAreaMark> getAreaMark() {
            return this.areaMark;
        }

        public String getOriginalSrc() {
            return this.originalSrc;
        }

        public String getSrc() {
            return this.src;
        }

        public String getToken() {
            return this.token;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L21:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L21;
            CommentImageBean r6 = (CommentImageBean) r5;
            if (Objects.equals(this.token, r6.token) == true) goto L13;
        L19:
            return false;
        L13:
            if (Objects.equals(this.src, r6.src) == false) goto L19;
            if (Objects.equals(this.originalSrc, r6.originalSrc) == false) goto L19;
            if (Objects.equals(this.areaMark, r6.areaMark) == false) goto L19;
            return true;
        }

        public void setAreaMark(ArrayList<CommentAreaMark> r1) {
            this.areaMark = r1;
        }

        public void setOriginalSrc(String r1) {
            this.originalSrc = r1;
        }

        public void setSrc(String r1) {
            this.src = r1;
        }

        public void setToken(String r1) {
            this.token = r1;
        }
    }

    public OpenCommentImageModel() {
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.imageList, Integer.valueOf(this.active), this.commentId, this.replyId, this.comment, this.permission});
    }

    public String toString() {
        return "OpenCommentImageModel{imageList=" + this.imageList + ", active=" + this.active + ", commentId=" + this.commentId + ", replyId=" + this.replyId + ", permission=" + this.permission + '}';
    }

    public int getActive() {
        return this.active;
    }

    public Card getComment() {
        return this.comment;
    }

    public String getCommentId() {
        return this.commentId;
    }

    public List<CommentImageBean> getImageList() {
        return this.imageList;
    }

    public Per getPermission() {
        return this.permission;
    }

    public String getReplyId() {
        return this.replyId;
    }

    public static boolean isActive(OpenCommentImageModel r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.getImageList() == null) goto L15;
        int r1 = r2.getImageList().size();
        int r3 = r2.active;
        if (r3 < 0) goto L13;
        if (r3 >= r1) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L15:
        return false;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L25:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L25;
        OpenCommentImageModel r6 = (OpenCommentImageModel) r5;
        if (this.active == r6.active) goto L13;
    L23:
        return false;
    L13:
        if (Objects.equals(this.imageList, r6.imageList) == false) goto L23;
        if (Objects.equals(this.commentId, r6.commentId) == false) goto L23;
        if (Objects.equals(this.replyId, r6.replyId) == false) goto L23;
        if (Objects.equals(this.comment, r6.comment) == false) goto L23;
        if (Objects.equals(this.permission, r6.permission) == false) goto L23;
        return true;
    }

    public void setActive(int r1) {
        this.active = r1;
    }

    public void setComment(Card r1) {
        this.comment = r1;
    }

    public void setCommentId(String r1) {
        this.commentId = r1;
    }

    public void setImageList(List<CommentImageBean> r1) {
        this.imageList = r1;
    }

    public void setPermission(Per r1) {
        this.permission = r1;
    }

    public void setReplyId(String r1) {
        this.replyId = r1;
    }
}
