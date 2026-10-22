package com.bytedance.ee.bear.sheet.exportimage.alert;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class ImageAlertModel implements NonProguard {
    private ImageInfo imageInfo;
    private String messages;
    private String source;
    private String title;

    public static class ImageInfo implements NonProguard {
        private int imageHeight;
        private int imageWidth;

        public ImageInfo() {
        }

        public String toString() {
            return "ImageInfo{imageWidth=" + this.imageWidth + ", imageHeight=" + this.imageHeight + '}';
        }

        public int getImageHeight() {
            return this.imageHeight;
        }

        public int getImageWidth() {
            return this.imageWidth;
        }

        public void setImageHeight(int r100) {
            this.imageHeight = r100;
        }

        public void setImageWidth(int r100) {
            this.imageWidth = r100;
        }
    }

    public ImageAlertModel() {
    }

    public String toString() {
        return "ImageAlertModel{title='" + this.title + "', messages='" + this.messages + "', imageInfo=" + this.imageInfo + ", source='" + this.source + "'}";
    }

    public ImageInfo getImageInfo() {
        return this.imageInfo;
    }

    public String getMessages() {
        return this.messages;
    }

    public String getSource() {
        return this.source;
    }

    public String getTitle() {
        return this.title;
    }

    public static Boolean isValid(ImageAlertModel r100) {
        if (r100 != null) goto L4;
    L10:
        boolean r101 = false;
    L12:
        return Boolean.valueOf(r101);
    L4:
        if (r100.imageInfo == null) goto L10;
        if (TextUtils.isEmpty(r100.title) == true) goto L10;
        if (TextUtils.isEmpty(r100.messages) == true) goto L10;
        r101 = true;
        goto L12
    }

    public void setImageInfo(ImageInfo r100) {
        this.imageInfo = r100;
    }

    public void setMessages(String r100) {
        this.messages = r100;
    }

    public void setSource(String r100) {
        this.source = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }
}
