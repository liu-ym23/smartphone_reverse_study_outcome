package com.bytedance.ee.bear.document.offline.sync;

import java.io.Serializable;

/* JADX INFO: loaded from: classes16.dex */
public class PreloadConfigModel implements Serializable {
    public static final int DEFAULT_PIN = 6;
    public static final int DEFAULT_RECENT = 10;
    public static final int DEFAULT_STAR = 10;
    public static final String DOCX_GET_CLIENT_VARS = "/space/api/docx/pages/client_vars?id=";
    public static final String GET_CLIENT_VARS = "/space/api/rce/messages?member_id=";
    public static final String GET_DOCUMENT_VERSION = "/space/api/rce/mget_version";
    public static final String VERSION_CHECK_TYPE_BITABLE = "BITABLE_BASE";
    public static final String VERSION_CHECK_TYPE_DOC = "DOC";
    public static final String VERSION_CHECK_TYPE_DOCX = "DOCX";
    public static final String VERSION_CHECK_TYPE_MINDNOTE = "MINDNOTE";
    public static final String VERSION_CHECK_TYPE_SHEET = "SPREADSHEET";
    private int favorite;
    private int pin;
    private int recent;

    public PreloadConfigModel() {
    }

    public int getFavorite() {
        return this.favorite;
    }

    public int getPin() {
        return this.pin;
    }

    public int getRecent() {
        return this.recent;
    }

    public void setFavorite(int r100) {
        this.favorite = r100;
    }

    public void setPin(int r100) {
        this.pin = r100;
    }

    public void setRecent(int r100) {
        this.recent = r100;
    }
}
