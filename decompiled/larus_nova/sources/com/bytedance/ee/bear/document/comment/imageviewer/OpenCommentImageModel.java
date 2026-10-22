package com.bytedance.ee.bear.document.comment.imageviewer;

import com.bytedance.ee.bear.document.comment.bean.Card;
import com.bytedance.ee.bear.document.comment.bean.Per;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentAreaMark;
import com.bytedance.ee.util.io.NonProguard;
import du5.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes16.dex */
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

        /* JADX INFO: renamed from: src, reason: collision with root package name */
        private String f219316src;
        private String token;

        public int hashCode() {
            return Objects.hash(new Object[]{this.token, this.f219316src, this.originalSrc, this.areaMark});
        }

        public String toString() {
            return "CommentImage{token='" + b.g(this.token) + "', src='" + b.g(this.f219316src) + "', originalSrc='" + b.g(this.originalSrc) + "', areaMark=" + this.areaMark + '}';
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
            return this.f219316src;
        }

        public String getToken() {
            return this.token;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L21:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L21;
            CommentImageBean r101 = (CommentImageBean) r100;
            if (Objects.equals(this.token, r101.token) == true) goto L13;
        L19:
            return false;
        L13:
            if (Objects.equals(this.f219316src, r101.f219316src) == false) goto L19;
            if (Objects.equals(this.originalSrc, r101.originalSrc) == false) goto L19;
            if (Objects.equals(this.areaMark, r101.areaMark) == false) goto L19;
            return true;
        }

        public void setAreaMark(ArrayList<CommentAreaMark> r100) {
            this.areaMark = r100;
        }

        public void setOriginalSrc(String r100) {
            this.originalSrc = r100;
        }

        public void setSrc(String r100) {
            this.f219316src = r100;
        }

        public void setToken(String r100) {
            this.token = r100;
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

    public static boolean isActive(OpenCommentImageModel r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getImageList() == null) goto L15;
        int r101 = r100.getImageList().size();
        int r102 = r100.active;
        if (r102 < 0) goto L13;
        if (r102 >= r101) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L15:
        return false;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L25:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L25;
        OpenCommentImageModel r101 = (OpenCommentImageModel) r100;
        if (this.active == r101.active) goto L13;
    L23:
        return false;
    L13:
        if (Objects.equals(this.imageList, r101.imageList) == false) goto L23;
        if (Objects.equals(this.commentId, r101.commentId) == false) goto L23;
        if (Objects.equals(this.replyId, r101.replyId) == false) goto L23;
        if (Objects.equals(this.comment, r101.comment) == false) goto L23;
        if (Objects.equals(this.permission, r101.permission) == false) goto L23;
        return true;
    }

    public void setActive(int r100) {
        this.active = r100;
    }

    public void setComment(Card r100) {
        this.comment = r100;
    }

    public void setCommentId(String r100) {
        this.commentId = r100;
    }

    public void setImageList(List<CommentImageBean> r100) {
        this.imageList = r100;
    }

    public void setPermission(Per r100) {
        this.permission = r100;
    }

    public void setReplyId(String r100) {
        this.replyId = r100;
    }
}
