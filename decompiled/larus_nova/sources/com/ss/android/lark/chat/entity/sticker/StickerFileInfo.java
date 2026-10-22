package com.ss.android.lark.chat.entity.sticker;

import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class StickerFileInfo implements Serializable {
    public final String filePath;
    public final int height;
    public final String key;
    public String stickerId;
    public String stickerSetId;
    public final String url;
    public final int width;

    public StickerFileInfo(String r100, String r101, String r102, int r103, int r104, String r105, String r106) {
        this.key = r100;
        this.url = r101;
        this.filePath = r102;
        this.width = r103;
        this.height = r104;
        this.stickerSetId = r105;
        this.stickerId = r106;
    }
}
