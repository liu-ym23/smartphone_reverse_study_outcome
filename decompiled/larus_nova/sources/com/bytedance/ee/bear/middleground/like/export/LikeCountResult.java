package com.bytedance.ee.bear.middleground.like.export;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class LikeCountResult implements NonProguard {
    private int count;
    private String likeId;
    private int message_box_version;

    public LikeCountResult() {
    }

    public int getCount() {
        return this.count;
    }

    public String getLikeId() {
        return this.likeId;
    }

    public int getMessageBoxVersion() {
        return this.message_box_version;
    }

    public void setCount(int r100) {
        this.count = r100;
    }

    public void setLikeId(String r100) {
        this.likeId = r100;
    }

    public void setMessageBoxVersion(int r100) {
        this.message_box_version = r100;
    }
}
