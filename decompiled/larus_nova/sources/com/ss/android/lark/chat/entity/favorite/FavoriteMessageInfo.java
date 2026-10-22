package com.ss.android.lark.chat.entity.favorite;

import com.bytedance.lark.pb.basic.v1.FavoritesType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class FavoriteMessageInfo implements Serializable, Comparable<FavoriteMessageInfo> {
    private long createTime;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f415199id;
    private Chat sourceChat;
    private Chatter sourceChatter;
    private Message sourceMessage;
    private FavoritesType type;

    public FavoriteMessageInfo() {
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getId() {
        return this.f415199id;
    }

    public Chat getSourceChat() {
        return this.sourceChat;
    }

    public Chatter getSourceChatter() {
        return this.sourceChatter;
    }

    public Message getSourceMessage() {
        return this.sourceMessage;
    }

    public FavoritesType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(FavoriteMessageInfo r100) {
        if (this.createTime >= r100.createTime) goto L6;
        return -1;
    L6:
        return 1;
    }

    public void setCreateTime(long r100) {
        this.createTime = r100;
    }

    public void setId(String r100) {
        this.f415199id = r100;
    }

    public void setSourceChat(Chat r100) {
        this.sourceChat = r100;
    }

    public void setSourceChatter(Chatter r100) {
        this.sourceChatter = r100;
    }

    public void setSourceMessage(Message r100) {
        this.sourceMessage = r100;
    }

    public void setType(FavoritesType r100) {
        this.type = r100;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(FavoriteMessageInfo r100) {
        return compareTo2(r100);
    }
}
