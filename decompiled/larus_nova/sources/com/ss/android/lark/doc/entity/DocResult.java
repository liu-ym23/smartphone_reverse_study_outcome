package com.ss.android.lark.doc.entity;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import y28.a;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
public class DocResult implements Serializable, b<DocResult> {

    /* JADX INFO: renamed from: doc, reason: collision with root package name */
    private Doc f420494doc;
    private DocCard docCard;
    private List<String> messageIds;

    public String getDocCardId() {
        DocCard r100 = this.docCard;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.getDocId();
    }

    public List<String> getMessageIds() {
        List<String> r100 = this.messageIds;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new ArrayList();
    }

    public int hashCode() {
        Doc r100 = this.f420494doc;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        DocCard r104 = this.docCard;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public DocResult() {
    }

    public Doc getDoc() {
        return this.f420494doc;
    }

    public DocCard getDocCard() {
        return this.docCard;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L25:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L25;
        DocResult r101 = (DocResult) r100;
        Doc r102 = this.f420494doc;
        if (r102 == null) goto L16;
        if (r102.equals(r101.f420494doc) == false) goto L17;
    L18:
        DocCard r103 = this.docCard;
        DocCard r104 = r101.docCard;
        if (r103 != null) goto L26;
        if (r104 == null) goto L27;
        return false;
    L27:
        return true;
    L26:
        return r103.equals(r104);
    L17:
        return false;
    L16:
        if (r101.f420494doc == null) goto L18;
        goto L17
    }

    public boolean isContentSame(DocResult r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (a.c(this.f420494doc, r100.getDoc()) == true) goto L9;
        return false;
    L9:
        if (a.c(this.docCard, r100.getDocCard()) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public boolean isItemSame(DocResult r100) {
        if (this.docCard != null) goto L8;
        if (r100 != null) goto L6;
    L7:
        return true;
    L6:
        if (r100.getDocCard() == null) goto L7;
    L8:
        String r101 = this.docCard.getMessageId();
        String r102 = "";
        if (r100 == null) goto L16;
        if (r100.getDocCard() == null) goto L16;
        r102 = r100.getDocCard().getMessageId();
    L16:
        if (TextUtils.equals(r101, r102) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public void setDoc(Doc r100) {
        this.f420494doc = r100;
    }

    public void setDocCard(DocCard r100) {
        this.docCard = r100;
    }

    public void setMessageIds(List<String> r100) {
        this.messageIds = r100;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((DocResult) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((DocResult) r100);
    }

    public DocResult(Doc r100, DocCard r101) {
        this.f420494doc = r100;
        this.docCard = r101;
    }

    public DocResult(Doc r100, DocCard r101, List<String> r102) {
        this.f420494doc = r100;
        this.docCard = r101;
        this.messageIds = r102;
    }
}
