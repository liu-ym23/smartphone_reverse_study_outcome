package com.ss.android.lark.keyboard.plugin.tool.face;

import java.io.Serializable;

/* JADX INFO: loaded from: classes36.dex */
public class Sticker implements Serializable {
    public final String filePath;
    public final String key;

    public Sticker() {
        this.key = "";
        this.filePath = "";
    }

    public Sticker(String r100, String r101) {
        this.key = r100;
        this.filePath = r101;
    }
}
