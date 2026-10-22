package com.bytedance.ee.bear.document.comment.bean;

import com.alipay.sdk.m.u.i;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.Reaction;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public class Card implements Serializable {
    private Map<Object, Object> bizParams;
    private ArrayList<String> blockedActionList;
    private boolean canPerformAction;
    private String commentAnchorId;
    private String commentId;
    private List<CommentBean.CommentDetail> commentList;
    private int commentType;
    private String commentUUID;
    private CommentBean.Extra extra;
    private int finish;
    private boolean isNewInput;
    private boolean isWhole;
    private ArrayList<String> participantList;
    private String position;
    private String quote;
    private List<Reaction> reactionList;
    private boolean unSubmitComment;
    private String userId;

    public boolean isFinish() {
        if (this.finish == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        StringBuilder r101 = new StringBuilder("{id: ");
        r101.append(this.commentId);
        r101.append(", type: ");
        r101.append(this.commentType);
        r101.append(", size: ");
        List<CommentBean.CommentDetail> r102 = this.commentList;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        r101.append(r104);
        r100.append(r101.toString());
    L8:
        if (r103 >= this.commentList.size()) goto L13;
        if (((CommentBean.CommentDetail) ListProtector.get(this.commentList, r103)).getSmartReplyData() == null) goto L12;
        r100.append(", ");
        r100.append(r103);
        r100.append(" hasSmartReply");
    L12:
        r103 = r103 + 1;
        goto L8
    L13:
        r100.append(i.f25855d);
        return r100.toString();
    L5:
        r104 = r102.size();
        goto L6
    }

    public Card() {
        this.commentType = 0;
        this.canPerformAction = true;
    }

    public Map<Object, Object> getBizParams() {
        return this.bizParams;
    }

    public ArrayList<String> getBlockedActionList() {
        return this.blockedActionList;
    }

    public String getCommentAnchorId() {
        return this.commentAnchorId;
    }

    public String getCommentId() {
        return this.commentId;
    }

    public List<CommentBean.CommentDetail> getCommentList() {
        return this.commentList;
    }

    public int getCommentType() {
        return this.commentType;
    }

    public String getCommentUUID() {
        return this.commentUUID;
    }

    public CommentBean.Extra getExtra() {
        return this.extra;
    }

    public int getFinish() {
        return this.finish;
    }

    public ArrayList<String> getParticipantList() {
        return this.participantList;
    }

    public String getPosition() {
        return this.position;
    }

    public String getQuote() {
        return this.quote;
    }

    public List<Reaction> getReactionList() {
        return this.reactionList;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isCanPerformAction() {
        return this.canPerformAction;
    }

    public boolean isNewInput() {
        return this.isNewInput;
    }

    public boolean isUnSubmitComment() {
        return this.unSubmitComment;
    }

    public boolean isWhole() {
        return this.isWhole;
    }

    public void setBizParams(Map<Object, Object> r100) {
        this.bizParams = r100;
    }

    public void setBlockedActionList(ArrayList<String> r100) {
        this.blockedActionList = r100;
    }

    public void setCanPerformAction(boolean r100) {
        this.canPerformAction = r100;
    }

    public void setCommentAnchorId(String r100) {
        this.commentAnchorId = r100;
    }

    public void setCommentId(String r100) {
        this.commentId = r100;
    }

    public void setCommentList(List<CommentBean.CommentDetail> r100) {
        this.commentList = r100;
    }

    public void setCommentType(int r100) {
        this.commentType = r100;
    }

    public void setCommentUUID(String r100) {
        this.commentUUID = r100;
    }

    public void setExtra(CommentBean.Extra r100) {
        this.extra = r100;
    }

    public void setFinish(int r100) {
        this.finish = r100;
    }

    public void setNewInput(boolean r100) {
        this.isNewInput = r100;
    }

    public void setParticipantList(ArrayList<String> r100) {
        this.participantList = r100;
    }

    public void setPosition(String r100) {
        this.position = r100;
    }

    public void setQuote(String r100) {
        this.quote = r100;
    }

    public void setReactionList(List<Reaction> r100) {
        this.reactionList = r100;
    }

    public void setUnSubmitComment(boolean r100) {
        this.unSubmitComment = r100;
    }

    public void setUserId(String r100) {
        this.userId = r100;
    }

    public void setWhole(boolean r100) {
        this.isWhole = r100;
    }
}
