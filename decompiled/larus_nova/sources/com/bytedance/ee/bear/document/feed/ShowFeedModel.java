package com.bytedance.ee.bear.document.feed;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;

/* JADX INFO: loaded from: classes16.dex */
public class ShowFeedModel implements BaseJSModel {
    private boolean canComment;
    private boolean canReaction;
    private boolean canReopen;
    private boolean canResolve;
    private boolean canShowMore;
    private boolean canShowVoice;
    private boolean isUserAction;
    private boolean loadingSuccess;

    public String toString() {
        return "ShowFeedModel{isUserAction=" + this.isUserAction + ", canComment=" + this.canComment + ", canReaction=" + this.canReaction + ", canResolve=" + this.canResolve + ", canShowMore=" + this.canShowMore + ", canShowVoice=" + this.canShowVoice + ", canReopen=" + this.canReopen + ", loadingSuccess=" + this.loadingSuccess + '}';
    }

    public ShowFeedModel() {
        this.canComment = true;
        this.loadingSuccess = true;
    }

    public boolean isCanComment() {
        return this.canComment;
    }

    public boolean isCanReaction() {
        return this.canReaction;
    }

    public boolean isCanReopen() {
        return this.canReopen;
    }

    public boolean isCanResolve() {
        return this.canResolve;
    }

    public boolean isCanShowMore() {
        return this.canShowMore;
    }

    public boolean isCanShowVoice() {
        return this.canShowVoice;
    }

    public boolean isIsUserAction() {
        return this.isUserAction;
    }

    public boolean isLoadingSuccess() {
        return this.loadingSuccess;
    }

    public boolean isUserAction() {
        return this.isUserAction;
    }

    public void setCanComment(boolean r100) {
        this.canComment = r100;
    }

    public void setCanReaction(boolean r100) {
        this.canReaction = r100;
    }

    public void setCanReopen(boolean r100) {
        this.canReopen = r100;
    }

    public void setCanResolve(boolean r100) {
        this.canResolve = r100;
    }

    public void setCanShowMore(boolean r100) {
        this.canShowMore = r100;
    }

    public void setCanShowVoice(boolean r100) {
        this.canShowVoice = r100;
    }

    public void setIsUserAction(boolean r100) {
        this.isUserAction = r100;
    }

    public void setLoadingSuccess(boolean r100) {
        this.loadingSuccess = r100;
    }

    public void setUserAction(boolean r100) {
        this.isUserAction = r100;
    }
}
