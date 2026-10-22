package com.ss.android.lark.forwardv2.dto;

import java.io.Serializable;

/* JADX INFO: loaded from: classes36.dex */
public class ThreadTarget implements Serializable {
    private String mAvatar;
    private String mChatId;
    private String mId;
    private boolean mIsReplyInThread;
    private String mName;

    public String getAvatar() {
        return this.mAvatar;
    }

    public String getChatId() {
        return this.mChatId;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public boolean isReplyInThread() {
        return this.mIsReplyInThread;
    }

    public void setAvatar(String r100) {
        this.mAvatar = r100;
    }

    public void setChatId(String r100) {
        this.mChatId = r100;
    }

    public void setId(String r100) {
        this.mId = r100;
    }

    public void setName(String r100) {
        this.mName = r100;
    }

    public void setReplyInThread(boolean r100) {
        this.mIsReplyInThread = r100;
    }

    public ThreadTarget(String r100, String r101, String r102, String r110) {
        this(r100, r101, r102, r110, false);
    }

    public ThreadTarget(String r100, String r101, String r102, String r103, boolean r104) {
        this.mId = r100;
        this.mName = r101;
        this.mAvatar = r102;
        this.mChatId = r103;
        this.mIsReplyInThread = r104;
    }
}
