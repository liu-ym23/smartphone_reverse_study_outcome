package com.bytedance.ee.bear.bitable.homepage.activity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010&\u001a\u0004\u0018\u00010\u001bR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/activity/CardInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "chatId", "", "getChatId", "()Ljava/lang/String;", "setChatId", "(Ljava/lang/String;)V", "position", "", "getPosition", "()Ljava/lang/Integer;", "setPosition", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "noticeTime", "", "getNoticeTime", "()J", "setNoticeTime", "(J)V", "content", "getContent", "setContent", "contentBean", "Lcom/bytedance/ee/bear/bitable/homepage/activity/CardContent;", "getContentBean", "()Lcom/bytedance/ee/bear/bitable/homepage/activity/CardContent;", "setContentBean", "(Lcom/bytedance/ee/bear/bitable/homepage/activity/CardContent;)V", "sender", "Lcom/bytedance/ee/bear/bitable/homepage/activity/CardSender;", "getSender", "()Lcom/bytedance/ee/bear/bitable/homepage/activity/CardSender;", "setSender", "(Lcom/bytedance/ee/bear/bitable/homepage/activity/CardSender;)V", "parseContent", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardInfo implements NonProguard {

    @JSONField(name = "chatID")
    private String chatId;
    private String content;
    private CardContent contentBean;
    private long noticeTime;
    private Integer position;
    private CardSender sender;

    public CardInfo() {
    }

    public final CardContent parseContent() {
        String r100 = this.content;
        if (r100 != null) goto L7;
        return null;
    L7:
        if (this.contentBean != null) goto L10;
        this.contentBean = (CardContent) JSON.parseObject(r100, CardContent.class);
    L10:
        return this.contentBean;
    }

    public final String getChatId() {
        return this.chatId;
    }

    public final String getContent() {
        return this.content;
    }

    public final CardContent getContentBean() {
        return this.contentBean;
    }

    public final long getNoticeTime() {
        return this.noticeTime;
    }

    public final Integer getPosition() {
        return this.position;
    }

    public final CardSender getSender() {
        return this.sender;
    }

    public final void setChatId(String r100) {
        this.chatId = r100;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setContentBean(CardContent r100) {
        this.contentBean = r100;
    }

    public final void setNoticeTime(long r100) {
        this.noticeTime = r100;
    }

    public final void setPosition(Integer r100) {
        this.position = r100;
    }

    public final void setSender(CardSender r100) {
        this.sender = r100;
    }
}
