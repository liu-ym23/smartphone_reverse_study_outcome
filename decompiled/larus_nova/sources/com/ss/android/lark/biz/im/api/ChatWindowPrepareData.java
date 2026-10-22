package com.ss.android.lark.biz.im.api;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.thread.TopicGroup;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import java.io.Serializable;

/* JADX INFO: loaded from: classes34.dex */
public class ChatWindowPrepareData implements Serializable {
    private static final long serialVersionUID = 3065827187997616533L;
    public final Chat chat;
    public final ChatThemeInfo chatThemeInfo;
    public final OpenApp openApp;
    public final ChatChatter p2pChatter;
    public final ChatChatter self;
    public final TopicGroup topicGroup;

    public ChatWindowPrepareData(Chat r100, ChatChatter r101, ChatChatter r102, OpenApp r103, TopicGroup r104, ChatThemeInfo r105) {
        this.chat = r100;
        this.p2pChatter = r101;
        this.self = r102;
        this.openApp = r103;
        this.topicGroup = r104;
        this.chatThemeInfo = r105;
    }
}
