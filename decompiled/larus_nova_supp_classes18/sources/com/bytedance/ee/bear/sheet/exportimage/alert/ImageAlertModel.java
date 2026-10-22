package com.bytedance.ee.bear.sheet.exportimage.alert;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

        public void setImageHeight(int r1) {
            this.imageHeight = r1;
        }

        public void setImageWidth(int r1) {
            this.imageWidth = r1;
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

    public static Boolean isValid(ImageAlertModel r1) {
        if (r1 != null) goto L4;
    L10:
        boolean r2 = false;
    L12:
        return Boolean.valueOf(r2);
    L4:
        if (r1.imageInfo == null) goto L10;
        if (TextUtils.isEmpty(r1.title) == true) goto L10;
        if (TextUtils.isEmpty(r1.messages) == true) goto L10;
        r2 = true;
        goto L12
    }

    public void setImageInfo(ImageInfo r1) {
        this.imageInfo = r1;
    }

    public void setMessages(String r1) {
        this.messages = r1;
    }

    public void setSource(String r1) {
        this.source = r1;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }
}
