package com.bytedance.ee.bear.document.comment.bean;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Objects;

/* JADX INFO: loaded from: classes16.dex */
public class Per implements NonProguard {
    public boolean askSmartReply;
    public boolean comment;
    public boolean copy;
    public boolean delete;
    public boolean resolve;
    public boolean reviewRevision;
    public boolean smartReplyPreview;

    public int hashCode() {
        return Objects.hash(new Object[]{Boolean.valueOf(this.resolve), Boolean.valueOf(this.comment), Boolean.valueOf(this.delete), Boolean.valueOf(this.copy), Boolean.valueOf(this.reviewRevision), Boolean.valueOf(this.smartReplyPreview), Boolean.valueOf(this.askSmartReply)});
    }

    public String toString() {
        return "Per{resolve=" + this.resolve + ", comment=" + this.comment + ", delete=" + this.delete + ", copy=" + this.copy + ", applyRevision=" + this.reviewRevision + ", smartReplyPreview=" + this.smartReplyPreview + ", askSmartReply=" + this.askSmartReply + '}';
    }

    public Per() {
        this.delete = true;
        this.copy = true;
        this.reviewRevision = false;
        this.smartReplyPreview = false;
        this.askSmartReply = false;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (getClass() != r100.getClass()) goto L31;
        Per r101 = (Per) r100;
        if (this.resolve == r101.resolve) goto L10;
        return false;
    L10:
        if (this.comment == r101.comment) goto L12;
        return false;
    L12:
        if (this.delete == r101.delete) goto L14;
        return false;
    L14:
        if (this.copy == r101.copy) goto L16;
        return false;
    L16:
        if (this.reviewRevision == r101.reviewRevision) goto L18;
        return false;
    L18:
        if (this.smartReplyPreview == r101.smartReplyPreview) goto L20;
        return false;
    L20:
        if (this.askSmartReply != r101.askSmartReply) goto L30;
        return true;
    L30:
        return false;
    L31:
        return false;
    }
}
