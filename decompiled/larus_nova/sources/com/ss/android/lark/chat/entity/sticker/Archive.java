package com.ss.android.lark.chat.entity.sticker;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public class Archive implements Serializable {
    private String mCheckSum;
    private String mKey;
    private String mMime;
    private Map<String, String> mParams;
    private long mSize;
    private List<String> mUrls;

    public Archive() {
    }

    public String getCheckSum() {
        return this.mCheckSum;
    }

    public String getKey() {
        return this.mKey;
    }

    public String getMime() {
        return this.mMime;
    }

    public Map<String, String> getParams() {
        return this.mParams;
    }

    public long getSize() {
        return this.mSize;
    }

    public List<String> getUrls() {
        return this.mUrls;
    }

    public void setCheckSum(String r100) {
        this.mCheckSum = r100;
    }

    public void setKey(String r100) {
        this.mKey = r100;
    }

    public void setMime(String r100) {
        this.mMime = r100;
    }

    public void setParams(Map<String, String> r100) {
        this.mParams = r100;
    }

    public void setSize(long r100) {
        this.mSize = r100;
    }

    public void setUrls(List<String> r100) {
        this.mUrls = r100;
    }
}
