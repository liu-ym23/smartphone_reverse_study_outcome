package com.bytedance.ee.bear.middleground.comment.export.commentsdk.bean;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DiffComments implements NonProguard {
    private ArrayList<CommentBean> addedComments;
    private ArrayList<CommentBean> deletedComments;
    private ArrayList<CommentBean> resolveStatusChangedComments;
    private ArrayList<CommentBean> updatedComments;

    public DiffComments() {
    }

    public ArrayList<CommentBean> getAddedComments() {
        return this.addedComments;
    }

    public ArrayList<CommentBean> getDeletedComments() {
        return this.deletedComments;
    }

    public ArrayList<CommentBean> getResolveStatusChangedComments() {
        return this.resolveStatusChangedComments;
    }

    public ArrayList<CommentBean> getUpdatedComments() {
        return this.updatedComments;
    }

    public void setAddedComments(ArrayList<CommentBean> r1) {
        this.addedComments = r1;
    }

    public void setDeletedComments(ArrayList<CommentBean> r1) {
        this.deletedComments = r1;
    }

    public void setResolveStatusChangedComments(ArrayList<CommentBean> r1) {
        this.resolveStatusChangedComments = r1;
    }

    public void setUpdatedComments(ArrayList<CommentBean> r1) {
        this.updatedComments = r1;
    }
}
