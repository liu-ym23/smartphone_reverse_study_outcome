package com.ttnetuploader.uploader.api;

/* JADX INFO: loaded from: classes41.dex */
public class ULMultipartPart {
    public final String contentType;
    public final String fileName;
    public final String filePath;
    public final String stringContent;

    public ULMultipartPart(String r100, String r101) {
        this.contentType = r100;
        this.stringContent = r101;
        this.filePath = null;
        this.fileName = null;
    }

    public ULMultipartPart(String r100, String r101, String r102) {
        this.contentType = r100;
        this.filePath = r101;
        this.fileName = r102;
        this.stringContent = null;
    }
}
