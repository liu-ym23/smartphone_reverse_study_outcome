package com.ss.android.lark.dto.draft;

import com.bytedance.lark.pb.basic.v1.DraftAttachmentSnapshot;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.widget.richtext.RichText;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* JADX INFO: loaded from: classes35.dex */
public class Draft implements Serializable {
    public transient DraftAttachmentSnapshot attachmentSnapshot;
    public String chatId;
    public RichText contentRichText;
    public long createTime;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public String f420576id;
    public Boolean isNeedDelete;
    public Boolean isReloadUrl;
    public Message message;
    public String messageId;
    public PartialReplyInfo partialReplyInfo;
    public RichText postRichText;
    public QueryStatusInfo queryStatusInfo;
    public String reEditMessageId;
    public ScheduleDraftInfo scheduleDraftInfo;
    public ChatChatter sender;
    public String threadId;
    public String title;
    public String topicGroupId;
    public int type;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DRAFT_TYPE {
        public static final int DRAFT_TYPE_CHAT_POST = 1;
        public static final int DRAFT_TYPE_CHAT_TEXT = 0;
        public static final int DRAFT_TYPE_INDIVIDUAL_TOPIC = 4;
        public static final int DRAFT_TYPE_REEDIT = 6;
        public static final int DRAFT_TYPE_REPLY_IN_THREAD_POST = 5;
        public static final int DRAFT_TYPE_REPLY_POST = 3;
        public static final int DRAFT_TYPE_REPLY_TEXT = 2;
        public static final int DRAFT_TYPE_SCHEDULE_SEND = 7;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("Draft{getChatId='");
        r100.append(this.chatId);
        r100.append("', messageId='");
        r100.append(this.messageId);
        r100.append("', type=");
        r100.append(this.type);
        r100.append(", contentRichText=");
        RichText r101 = this.contentRichText;
        String r102 = "";
        if (r101 != null) goto L5;
    L8:
        String r103 = "";
    L9:
        r100.append(r103);
        r100.append(", title='");
        r100.append(this.title);
        r100.append("', createTime=");
        r100.append(this.createTime);
        r100.append(", postRichText=");
        RichText r104 = this.postRichText;
        if (r104 != null) goto L12;
    L15:
        r100.append(r102);
        r100.append(", scheduleDraftInfo=");
        r100.append(this.scheduleDraftInfo);
        r100.append(", queryStatusInfo=");
        r100.append(this.queryStatusInfo);
        r100.append('}');
        return r100.toString();
    L12:
        if (r104.getInnerText() == null) goto L15;
        r102 = this.postRichText.getInnerText();
        goto L15
    L5:
        if (r101.getInnerText() == null) goto L8;
        r103 = this.contentRichText.getInnerText();
        goto L9
    }

    public Draft() {
        this.reEditMessageId = "";
        Boolean r100 = Boolean.FALSE;
        this.isNeedDelete = r100;
        this.isReloadUrl = r100;
    }

    public boolean exactlyCompare(Draft r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this != r100) goto L8;
        return true;
    L8:
        String r101 = this.chatId;
        if (r101 != null) goto L14;
        if (r100.chatId == null) goto L16;
        return false;
    L16:
        RichText r102 = this.contentRichText;
        if (r102 == null) goto L22;
        if (r102.equals(r100.contentRichText) == false) goto L23;
    L24:
        String r103 = this.title;
        if (r103 == null) goto L30;
        if (r103.equals(r100.title) == true) goto L33;
    L31:
        return false;
    L33:
        if (Objects.equals(this.scheduleDraftInfo, r100.scheduleDraftInfo) == true) goto L35;
        return false;
    L35:
        RichText r104 = this.postRichText;
        RichText r105 = r100.postRichText;
        if (r104 != null) goto L41;
        if (r105 != null) goto L42;
        return true;
    L42:
        return false;
    L41:
        return r104.equals(r105);
    L30:
        if (r100.title == null) goto L33;
    L23:
        return false;
    L22:
        if (r100.contentRichText == null) goto L24;
    L14:
        if (r101.equals(r100.chatId) == true) goto L16;
        return false;
    }
}
