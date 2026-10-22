package com.ss.android.lark.sticker.core.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes38.dex */
public class UISticker implements Serializable {
    private String filePath;
    private int selected;
    private com.ss.android.lark.chat.entity.sticker.Sticker sticker;

    public boolean isSelected() {
        if (this.selected <= (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public UISticker() {
        this.selected = -1;
        this.filePath = "";
    }

    public String getFilePath() {
        return this.filePath;
    }

    public int getSelected() {
        return this.selected;
    }

    public com.ss.android.lark.chat.entity.sticker.Sticker getSticker() {
        return this.sticker;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L22:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L22;
        UISticker r101 = (UISticker) r100;
        com.ss.android.lark.chat.entity.sticker.Sticker r102 = this.sticker;
        if (r102 == null) goto L18;
        if (r102.equals(r101.sticker) == false) goto L15;
        return true;
    L15:
        if (this.sticker.getImageKey().equals(r101.sticker.getImageKey()) == true) goto L24;
    L20:
        return false;
    L24:
        return true;
    L18:
        if (r101.sticker != null) goto L20;
        return true;
    }

    public boolean isExactlySame(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L20:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L20;
        UISticker r101 = (UISticker) r100;
        if (this.selected == r101.selected) goto L13;
        return false;
    L13:
        com.ss.android.lark.chat.entity.sticker.Sticker r102 = this.sticker;
        com.ss.android.lark.chat.entity.sticker.Sticker r103 = r101.sticker;
        if (r102 != null) goto L21;
        if (r103 == null) goto L22;
        return false;
    L22:
        return true;
    L21:
        return r102.equals(r103);
    }

    public void setFilePath(String r100) {
        this.filePath = r100;
    }

    public void setSelected(int r100) {
        this.selected = r100;
    }

    public void setSticker(com.ss.android.lark.chat.entity.sticker.Sticker r100) {
        this.sticker = r100;
    }
}
