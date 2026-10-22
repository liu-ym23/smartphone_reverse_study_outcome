package com.bytedance.ee.bear.drive.biz.preview.vc.comment;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DriveCommentState implements NonProguard {
    private String focusedCommentId;
    private boolean isCommentExpanded;

    public DriveCommentState() {
    }

    public String toString() {
        return "DriveCommentState{isCommentExpanded=" + this.isCommentExpanded + ", focusedCommentId='" + this.focusedCommentId + "'}";
    }

    public String getFocusedCommentId() {
        return this.focusedCommentId;
    }

    public boolean isIsCommentExpanded() {
        return this.isCommentExpanded;
    }

    public void setFocusedCommentId(String r1) {
        this.focusedCommentId = r1;
    }

    public void setIsCommentExpanded(boolean r1) {
        this.isCommentExpanded = r1;
    }
}
