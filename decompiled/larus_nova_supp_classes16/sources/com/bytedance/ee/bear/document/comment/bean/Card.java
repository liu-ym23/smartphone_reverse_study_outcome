package com.bytedance.ee.bear.document.comment.bean;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.Reaction;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        StringBuilder r0 = new StringBuilder();
        StringBuilder r1 = new StringBuilder("{id: ");
        r1.append(this.commentId);
        r1.append(", type: ");
        r1.append(this.commentType);
        r1.append(", size: ");
        List<CommentBean.CommentDetail> r2 = this.commentList;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        r1.append(r4);
        r0.append(r1.toString());
    L8:
        if (r3 >= this.commentList.size()) goto L13;
        if (((CommentBean.CommentDetail) ListProtector.get(this.commentList, r3)).getSmartReplyData() == null) goto L12;
        r0.append(", ");
        r0.append(r3);
        r0.append(" hasSmartReply");
    L12:
        r3 = r3 + 1;
        goto L8
    L13:
        r0.append("}");
        return r0.toString();
    L5:
        r4 = r2.size();
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

    public void setBizParams(Map<Object, Object> r1) {
        this.bizParams = r1;
    }

    public void setBlockedActionList(ArrayList<String> r1) {
        this.blockedActionList = r1;
    }

    public void setCanPerformAction(boolean r1) {
        this.canPerformAction = r1;
    }

    public void setCommentAnchorId(String r1) {
        this.commentAnchorId = r1;
    }

    public void setCommentId(String r1) {
        this.commentId = r1;
    }

    public void setCommentList(List<CommentBean.CommentDetail> r1) {
        this.commentList = r1;
    }

    public void setCommentType(int r1) {
        this.commentType = r1;
    }

    public void setCommentUUID(String r1) {
        this.commentUUID = r1;
    }

    public void setExtra(CommentBean.Extra r1) {
        this.extra = r1;
    }

    public void setFinish(int r1) {
        this.finish = r1;
    }

    public void setNewInput(boolean r1) {
        this.isNewInput = r1;
    }

    public void setParticipantList(ArrayList<String> r1) {
        this.participantList = r1;
    }

    public void setPosition(String r1) {
        this.position = r1;
    }

    public void setQuote(String r1) {
        this.quote = r1;
    }

    public void setReactionList(List<Reaction> r1) {
        this.reactionList = r1;
    }

    public void setUnSubmitComment(boolean r1) {
        this.unSubmitComment = r1;
    }

    public void setUserId(String r1) {
        this.userId = r1;
    }

    public void setWhole(boolean r1) {
        this.isWhole = r1;
    }
}
