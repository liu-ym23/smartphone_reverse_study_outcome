package com.ss.android.lark.chat.entity.response;

import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public class PushMyThreadReplyPromptResponse implements Serializable {
    public String groupId;
    public List<MessageInfo> lastAtMessages;
    public int newAtReplyCount;
    public int newReplyCount;

    public PushMyThreadReplyPromptResponse(String r100, int r101, int r102, List<MessageInfo> r103) {
        this.groupId = r100;
        this.newReplyCount = r101;
        this.newAtReplyCount = r102;
        this.lastAtMessages = r103;
    }
}
