package com.ss.android.lark.doc.entity;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class DocPermission implements Serializable {

    @JSONField(name = "set")
    private boolean isSet;
    private int permCode;
    private String permName;

    public DocPermission() {
    }

    public boolean canEdit() {
        if ((this.permCode & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean canRead() {
        if ((this.permCode & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean canShare() {
        if ((this.permCode & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getPermTypeNum() {
        int r100 = this.permCode;
        if ((r100 & 4) == 0) goto L7;
        return DocPermPair.PermType.EDIT.getNumber();
    L7:
        if ((r100 & 1) == 0) goto L11;
        return DocPermPair.PermType.READ.getNumber();
    L11:
        return DocPermPair.PermType.UNKNOWN.getNumber();
    }

    public int hashCode() {
        int r100 = this.permCode * 31;
        String r101 = this.permName;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return ((r100 + r102) * 31) + (this.isSet ? 1 : 0);
    L5:
        r102 = 0;
        goto L7
    }

    public int getPermCode() {
        return this.permCode;
    }

    public boolean isSet() {
        return this.isSet;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L18:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L18;
        DocPermission r101 = (DocPermission) r100;
        if (this.permCode == r101.permCode) goto L14;
        return false;
    L14:
        if (this.isSet == r101.isSet) goto L17;
        return false;
    L17:
        return TextUtils.equals(this.permName, r101.permName);
    }

    public void setEdit(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = this.permCode | 4;
    L5:
        this.permCode = r101;
        this.permCode = r101;
        return;
    L4:
        r101 = this.permCode & (-5);
        goto L5
    }

    public void setIsSet(boolean r100) {
        this.isSet = r100;
    }

    public void setPermCode(int r100) {
        this.permCode = r100;
    }

    public void setPermName(String r100) {
        this.permName = r100;
    }

    public void setRead(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = this.permCode | 1;
    L5:
        this.permCode = r101;
        this.permCode = r101;
        return;
    L4:
        r101 = this.permCode & (-2);
        goto L5
    }

    public void setShare(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = this.permCode | 8;
    L5:
        this.permCode = r101;
        this.permCode = r101;
        return;
    L4:
        r101 = this.permCode & (-9);
        goto L5
    }
}
