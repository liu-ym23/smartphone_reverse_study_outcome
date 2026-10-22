package com.ss.android.lark.contact.base.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class UserRelationResponse implements Serializable {
    private String mApplyReason;
    private boolean mBeCtrlAddContact;
    private String mContactApplicationId;
    private boolean mHasApply;
    private boolean mHasBeApply;
    private boolean mHasBeBlock;
    private boolean mHasBlock;
    private boolean mInCollaboration;
    private boolean mIsFriend;

    public static /* synthetic */ class a {
    }

    public static class b {
    }

    public UserRelationResponse() {
        this.mBeCtrlAddContact = false;
        this.mIsFriend = true;
    }

    public String getApplyReason() {
        return this.mApplyReason;
    }

    public String getContactApplicationId() {
        return this.mContactApplicationId;
    }

    public boolean isBeCtrlAddContact() {
        return this.mBeCtrlAddContact;
    }

    public boolean isFriend() {
        return this.mIsFriend;
    }

    public boolean isHasApply() {
        return this.mHasApply;
    }

    public boolean isHasBeApply() {
        return this.mHasBeApply;
    }

    public boolean isHasBeBlocked() {
        return this.mHasBeBlock;
    }

    public boolean isHasBlock() {
        return this.mHasBlock;
    }

    public boolean isInCollaboration() {
        return this.mInCollaboration;
    }

    public void setApplyReason(String r100) {
        this.mApplyReason = r100;
    }

    public void setHasApply(boolean r100) {
        this.mHasApply = r100;
    }

    public UserRelationResponse(b r100, a r101) {
        this.mBeCtrlAddContact = false;
        throw null;
    }
}
