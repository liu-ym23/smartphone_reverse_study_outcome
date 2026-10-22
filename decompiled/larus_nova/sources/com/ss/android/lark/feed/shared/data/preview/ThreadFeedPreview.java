package com.ss.android.lark.feed.shared.data.preview;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.feed.app.entity.UIFeedCard;

/* JADX INFO: loaded from: classes35.dex */
public class ThreadFeedPreview extends FeedPreview {
    private String chatId;
    private Chat.Type chatType;
    private boolean isMsgThread;
    private String p2pChatterId;

    public ThreadFeedPreview() {
        this.isMsgThread = false;
    }

    @Override // com.ss.android.lark.feed.shared.data.preview.FeedPreview, com.ss.android.lark.feed.app.entity.UIFeedCard
    public ThreadFeedPreview clone() throws CloneNotSupportedException {
        ThreadFeedPreview r100 = (ThreadFeedPreview) super.clone();
        r100.chatId = this.chatId;
        r100.isMsgThread = this.isMsgThread;
        r100.p2pChatterId = this.p2pChatterId;
        r100.chatType = this.chatType;
        return r100;
    }

    public String getChatId() {
        return this.chatId;
    }

    public Chat.Type getChatType() {
        return this.chatType;
    }

    public String getP2pChatterId() {
        return this.p2pChatterId;
    }

    public boolean isMsgThread() {
        return this.isMsgThread;
    }

    @Override // com.ss.android.lark.feed.shared.data.preview.FeedPreview, com.ss.android.lark.feed.app.entity.UIFeedCard
    public /* bridge */ /* synthetic */ UIFeedCard clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.ss.android.lark.feed.shared.data.preview.FeedPreview, com.ss.android.lark.feed.app.entity.UIFeedCard
    public /* bridge */ /* synthetic */ FeedPreview clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.ss.android.lark.feed.shared.data.preview.FeedPreview, com.ss.android.lark.feed.app.entity.UIFeedCard
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo8637clone() throws CloneNotSupportedException {
        return clone();
    }

    public ThreadFeedPreview(ThreadFeedPreview r100) {
        super(r100);
        this.isMsgThread = false;
        setChatId(r100.getChatId());
        setP2pChatterId(r100.getP2pChatterId());
        setChatType(r100.getChatType());
        setMsgThread(r100.isMsgThread());
    }

    public void setChatId(String r100) {
        this.chatId = r100;
    }

    public void setChatType(Chat.Type r100) {
        this.chatType = r100;
    }

    public void setMsgThread(boolean r100) {
        this.isMsgThread = r100;
    }

    public void setP2pChatterId(String r100) {
        this.p2pChatterId = r100;
    }
}
