package com.bytedance.ee.bear.document.imageviewer.bean;

import com.bytedance.ee.bear.document.comment.bean.Card;
import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class CardCommentData implements BaseJSModel {
    private boolean commentable;
    private List<Card> comments;

    public String toString() {
        return "CardCommentData{commentable=" + this.commentable + ", comments=" + this.comments + '}';
    }

    public CardCommentData() {
        this.comments = new ArrayList();
    }

    public List<Card> getComments() {
        return this.comments;
    }

    public boolean isCommentable() {
        return this.commentable;
    }

    public void setCommentable(boolean r1) {
        this.commentable = r1;
    }

    public void setComments(List<Card> r1) {
        this.comments = r1;
    }
}
