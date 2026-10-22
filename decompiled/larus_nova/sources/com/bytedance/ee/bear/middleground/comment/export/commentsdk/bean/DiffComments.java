package com.bytedance.ee.bear.middleground.comment.export.commentsdk.bean;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
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

    public void setAddedComments(ArrayList<CommentBean> r100) {
        this.addedComments = r100;
    }

    public void setDeletedComments(ArrayList<CommentBean> r100) {
        this.deletedComments = r100;
    }

    public void setResolveStatusChangedComments(ArrayList<CommentBean> r100) {
        this.resolveStatusChangedComments = r100;
    }

    public void setUpdatedComments(ArrayList<CommentBean> r100) {
        this.updatedComments = r100;
    }
}
