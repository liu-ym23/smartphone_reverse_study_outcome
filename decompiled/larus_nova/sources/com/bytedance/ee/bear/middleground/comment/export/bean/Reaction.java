package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes18.dex */
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
        StringBuilder r100 = new StringBuilder("Reaction{referType='");
        r100.append(this.referType);
        r100.append("', referKey='");
        r100.append(this.referKey);
        r100.append("', reactionKey='");
        r100.append(this.reactionKey);
        r100.append("', totalCount=");
        r100.append(this.totalCount);
        r100.append(", userList=");
        List<ReactionDetailUserInfo> r101 = this.userList;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        r100.append(r102);
        r100.append('}');
        return r100.toString();
    L5:
        r102 = r101.size();
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

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L19;
        Reaction r101 = (Reaction) r100;
        if (this.totalCount == r101.totalCount) goto L13;
    L17:
        return false;
    L13:
        if (Objects.equals(this.reactionKey, r101.reactionKey) == false) goto L17;
        if (Objects.equals(this.userList, r101.userList) == false) goto L17;
        return true;
    }

    public void setReactionKey(String r100) {
        this.reactionKey = r100;
    }

    public void setReferKey(String r100) {
        this.referKey = r100;
    }

    public void setReferType(String r100) {
        this.referType = r100;
    }

    public void setTotalCount(int r100) {
        this.totalCount = r100;
    }

    public void setUserList(List<ReactionDetailUserInfo> r100) {
        this.userList = r100;
    }
}
