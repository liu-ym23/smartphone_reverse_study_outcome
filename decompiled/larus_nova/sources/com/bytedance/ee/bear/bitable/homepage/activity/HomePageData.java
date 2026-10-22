package com.bytedance.ee.bear.bitable.homepage.activity;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/activity/HomePageData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "messageType", "", "getMessageType", "()I", "setMessageType", "(I)V", "cardInfo", "Lcom/bytedance/ee/bear/bitable/homepage/activity/CardInfo;", "getCardInfo", "()Lcom/bytedance/ee/bear/bitable/homepage/activity/CardInfo;", "setCardInfo", "(Lcom/bytedance/ee/bear/bitable/homepage/activity/CardInfo;)V", "noticeInfo", "Lcom/bytedance/ee/bear/bitable/homepage/activity/NoticeInfo;", "getNoticeInfo", "()Lcom/bytedance/ee/bear/bitable/homepage/activity/NoticeInfo;", "setNoticeInfo", "(Lcom/bytedance/ee/bear/bitable/homepage/activity/NoticeInfo;)V", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HomePageData implements NonProguard {
    public static final a Companion = null;
    public static final int MESSAGE_TYPE_CARD = 1;
    public static final int MESSAGE_TYPE_NATIVE_BOT = 0;
    public static final int MESSAGE_TYPE_NOTICE = 2;
    private CardInfo cardInfo;
    private int messageType;
    private NoticeInfo noticeInfo;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public HomePageData() {
        this.messageType = 1;
    }

    public final CardInfo getCardInfo() {
        return this.cardInfo;
    }

    public final int getMessageType() {
        return this.messageType;
    }

    public final NoticeInfo getNoticeInfo() {
        return this.noticeInfo;
    }

    public final void setCardInfo(CardInfo r100) {
        this.cardInfo = r100;
    }

    public final void setMessageType(int r100) {
        this.messageType = r100;
    }

    public final void setNoticeInfo(NoticeInfo r100) {
        this.noticeInfo = r100;
    }
}
