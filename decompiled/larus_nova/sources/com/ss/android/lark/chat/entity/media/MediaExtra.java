package com.ss.android.lark.chat.entity.media;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes35.dex */
public class MediaExtra implements Serializable {
    private long duration;
    private String filePath;
    private String key;
    private String mime;
    private long size;
    private String url;

    public int hashCode() {
        return Objects.hash(new Object[]{this.key, this.url, this.filePath, Long.valueOf(this.size), this.mime, Long.valueOf(this.duration)});
    }

    public MediaExtra() {
        this.key = "";
        this.url = "";
        this.filePath = "";
    }

    public long getDuration() {
        return this.duration;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getKey() {
        return this.key;
    }

    public String getMime() {
        return this.mime;
    }

    public long getSize() {
        return this.size;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L21:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L21;
        MediaExtra r101 = (MediaExtra) r100;
        if (this.duration == r101.duration) goto L13;
    L19:
        return false;
    L13:
        if (Objects.equals(this.key, r101.key) == false) goto L19;
        if (Objects.equals(this.url, r101.url) == false) goto L19;
        if (Objects.equals(this.mime, r101.mime) == false) goto L19;
        return true;
    }

    public void setDuration(long r100) {
        this.duration = r100;
    }

    public void setFilePath(String r100) {
        this.filePath = r100;
    }

    public void setKey(String r100) {
        this.key = r100;
    }

    public void setMime(String r100) {
        this.mime = r100;
    }

    public void setSize(long r100) {
        this.size = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }
}
