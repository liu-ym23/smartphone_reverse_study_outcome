package com.ss.android.lark.reaction.widget.detailwindow.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes37.dex */
public class ReactionDetailViewModel implements Serializable {
    private String reactionKey;
    private boolean selfInvoke;
    private String tipText;
    private int totalCount;
    private List<DetailUserInfo> userInfoList;

    public int hashCode() {
        return Objects.hash(new Object[]{this.reactionKey, Integer.valueOf(this.totalCount), this.userInfoList, Boolean.valueOf(this.selfInvoke)});
    }

    public ReactionDetailViewModel() {
        this.tipText = "";
    }

    public String getReactionKey() {
        return this.reactionKey;
    }

    public String getTipText() {
        return this.tipText;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public List<DetailUserInfo> getUserInfoList() {
        return this.userInfoList;
    }

    public boolean isSelfInvoke() {
        return this.selfInvoke;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ReactionDetailViewModel) == true) goto L8;
        return false;
    L8:
        ReactionDetailViewModel r101 = (ReactionDetailViewModel) r100;
        if (this.totalCount == r101.totalCount) goto L11;
    L17:
        return false;
    L11:
        if (this.selfInvoke != r101.selfInvoke) goto L17;
        if (Objects.equals(this.reactionKey, r101.reactionKey) == false) goto L17;
        if (Objects.equals(this.userInfoList, r101.userInfoList) == false) goto L17;
        return true;
    }

    public void setReactionKey(String r100) {
        this.reactionKey = r100;
    }

    public void setSelfInvoke(boolean r100) {
        this.selfInvoke = r100;
    }

    public void setTipText(String r100) {
        this.tipText = r100;
    }

    public void setTotalCount(int r100) {
        this.totalCount = r100;
    }

    public void setUserInfoList(List<DetailUserInfo> r100) {
        this.userInfoList = r100;
    }
}
