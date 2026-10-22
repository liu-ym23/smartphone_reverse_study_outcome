package com.ss.android.lark.doc.entity;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
public class DocCard implements Serializable, b<DocCard> {
    private String docId;
    private Extra extra;
    private String groupId;
    private String messageId;
    private List<DocPermission> permissions;
    private DocPermission receiverPermission;
    private Boolean senderIsExternal;
    private String shareInfo;
    private long shareStatus;
    private boolean shouldRender;
    private DocPermission userPermission;

    public DocCard() {
    }

    public DocPermission getCurrentDocPerm() {
        if (this.permissions.size() == 1) goto L5;
        Iterator<DocPermission> r100 = this.permissions.iterator();
    L8:
        if (r100.hasNext() == false) goto L12;
        DocPermission r101 = r100.next();
        if (r101.isSet() == false) goto L8;
        return r101;
    L12:
        DocPermission r102 = new DocPermission();
        r102.setIsSet(true);
        r102.setRead(true);
        return r102;
    L5:
        return (DocPermission) ListProtector.get(this.permissions, 0);
    }

    public List<DocPermission> getPermissions() {
        List<DocPermission> r100 = this.permissions;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new ArrayList();
    }

    public boolean getSenderIsExternal() {
        Boolean r100 = this.senderIsExternal;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    public int hashCode() {
        String r100 = this.docId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        List<DocPermission> r103 = this.permissions;
        if (r103 == null) goto L12;
        Iterator<DocPermission> r104 = r103.iterator();
        int r105 = 0;
    L10:
        if (r104.hasNext() == false) goto L13;
        r105 = r105 + r104.next().hashCode();
    L13:
        int r106 = ((r102 * 31) + r105) * 31;
        String r107 = this.shareInfo;
        if (r107 == null) goto L16;
        int r108 = r107.hashCode();
    L17:
        int r109 = (r106 + r108) * 31;
        DocPermission r110 = this.userPermission;
        if (r110 == null) goto L21;
        r101 = r110.hashCode();
    L21:
        return ((r109 + r101) * 31) + ((int) this.shareStatus);
    L16:
        r108 = 0;
        goto L17
    L12:
        r105 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public boolean isEmpty() {
        if (TextUtils.isEmpty(this.messageId) == false) goto L5;
    L8:
        return true;
    L5:
        if (TextUtils.isEmpty(this.docId) == true) goto L8;
        return false;
    }

    public String toString() {
        return "shouldRender" + this.shouldRender + "sharedStatus" + this.shareStatus + "permissions().size()" + getPermissions().size();
    }

    public String getDocId() {
        return this.docId;
    }

    public Extra getExtra() {
        return this.extra;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public DocPermission getReceiverPermission() {
        return this.receiverPermission;
    }

    public String getShareInfo() {
        return this.shareInfo;
    }

    public long getShareStatus() {
        return this.shareStatus;
    }

    public DocPermission getUserPermission() {
        return this.userPermission;
    }

    public boolean isShouldRender() {
        return this.shouldRender;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (getClass() == r100.getClass()) goto L10;
        return false;
    L10:
        return isContentSame((DocCard) r100);
    }

    public boolean isContentSame(DocCard r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (TextUtils.equals(this.docId, r100.getDocId()) == true) goto L9;
        return false;
    L9:
        if (TextUtils.equals(this.shareInfo, r100.getShareInfo()) == true) goto L12;
        return false;
    L12:
        if (Objects.equals(this.userPermission, r100.userPermission) == true) goto L15;
        return false;
    L15:
        if (this.shareStatus == r100.getShareStatus()) goto L17;
        return false;
    L17:
        List<DocPermission> r101 = r100.getPermissions();
        if (r101 == null) goto L20;
    L22:
        if (r101 != null) goto L24;
        return false;
    L24:
        if (this.permissions == null) goto L46;
        Iterator<DocPermission> r102 = r101.iterator();
    L27:
        if (r102.hasNext() == false) goto L21;
        DocPermission r103 = r102.next();
        Iterator<DocPermission> r104 = this.permissions.iterator();
    L30:
        if (r104.hasNext() == false) goto L34;
        if (r103.equals(r104.next()) == false) goto L30;
        boolean r105 = true;
    L35:
        if (r105 == true) goto L27;
        return false;
    L34:
        r105 = false;
    L21:
        return true;
    L46:
        return false;
    L20:
        if (this.permissions != null) goto L22;
        goto L21
    }

    public boolean isItemSame(DocCard r100) {
        String r101 = this.messageId;
        if (r100 != null) goto L5;
        String r102 = "";
    L7:
        return TextUtils.equals(r101, r102);
    L5:
        r102 = r100.getMessageId();
        goto L7
    }

    public void setDocId(String r100) {
        this.docId = r100;
    }

    public void setExtra(Extra r100) {
        this.extra = r100;
    }

    public void setGroupId(String r100) {
        this.groupId = r100;
    }

    public void setMessageId(String r100) {
        this.messageId = r100;
    }

    public void setPermissions(List<DocPermission> r100) {
        this.permissions = r100;
    }

    public void setReceiverPermission(DocPermission r100) {
        this.receiverPermission = r100;
    }

    public void setSenderIsExternal(Boolean r100) {
        this.senderIsExternal = r100;
    }

    public void setShareInfo(String r100) {
        this.shareInfo = r100;
    }

    public void setShareStatus(long r100) {
        this.shareStatus = r100;
    }

    public void setShouldRender(boolean r100) {
        this.shouldRender = r100;
    }

    public void setUserPermission(DocPermission r100) {
        this.userPermission = r100;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((DocCard) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((DocCard) r100);
    }
}
