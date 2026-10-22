package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Reaction implements BaseJSModel {
    private String reactionKey;
    private String referKey;
    private String referType;
    private int totalCount;
    private List<ReactionDetailUserInfo> userList;

    public Reaction() {
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.reactionKey, Integer.valueOf(this.totalCount)});
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("Reaction{referType='");
        r0.append(this.referType);
        r0.append("', referKey='");
        r0.append(this.referKey);
        r0.append("', reactionKey='");
        r0.append(this.reactionKey);
        r0.append("', totalCount=");
        r0.append(this.totalCount);
        r0.append(", userList=");
        List<ReactionDetailUserInfo> r1 = this.userList;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        r0.append(r2);
        r0.append('}');
        return r0.toString();
    L5:
        r2 = r1.size();
        goto L6
    }

    public String getReactionKey() {
        return this.reactionKey;
    }

    public String getReferKey() {
        return this.referKey;
    }

    public String getReferType() {
        return this.referType;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public List<ReactionDetailUserInfo> getUserList() {
        return this.userList;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L19;
        Reaction r6 = (Reaction) r5;
        if (this.totalCount == r6.totalCount) goto L13;
    L17:
        return false;
    L13:
        if (Objects.equals(this.reactionKey, r6.reactionKey) == false) goto L17;
        if (Objects.equals(this.userList, r6.userList) == false) goto L17;
        return true;
    }

    public void setReactionKey(String r1) {
        this.reactionKey = r1;
    }

    public void setReferKey(String r1) {
        this.referKey = r1;
    }

    public void setReferType(String r1) {
        this.referType = r1;
    }

    public void setTotalCount(int r1) {
        this.totalCount = r1;
    }

    public void setUserList(List<ReactionDetailUserInfo> r1) {
        this.userList = r1;
    }
}
