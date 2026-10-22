package com.ss.android.lark.chat.entity.chat;

import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class ChatOptionInfo implements Serializable {
    private static final long serialVersionUID = -4912521595824753252L;
    private boolean announceIsUnread;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f415145id;

    public ChatOptionInfo() {
    }

    public String getId() {
        return this.f415145id;
    }

    public boolean isAnnounceIsUnread() {
        return this.announceIsUnread;
    }

    public void setAnnounceIsUnread(boolean r100) {
        this.announceIsUnread = r100;
    }

    public void setId(String r100) {
        this.f415145id = r100;
    }
}
