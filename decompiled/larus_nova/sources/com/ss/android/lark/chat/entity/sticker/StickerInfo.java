package com.ss.android.lark.chat.entity.sticker;

import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class StickerInfo implements Serializable {
    private String mDescription;
    private boolean mHasPaid;
    private String mTitle;

    public StickerInfo() {
        this.mTitle = "";
        this.mDescription = "";
        this.mHasPaid = true;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public boolean isHasPaid() {
        return this.mHasPaid;
    }

    public void setDescription(String r100) {
        this.mDescription = r100;
    }

    public void setHasPaid(boolean r100) {
        this.mHasPaid = r100;
    }

    public void setTitle(String r100) {
        this.mTitle = r100;
    }
}
