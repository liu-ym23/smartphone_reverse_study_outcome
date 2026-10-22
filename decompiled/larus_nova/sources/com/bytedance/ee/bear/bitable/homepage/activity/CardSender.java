package com.bytedance.ee.bear.bitable.homepage.activity;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/activity/CardSender;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "avatarKey", "", "getAvatarKey", "()Ljava/lang/String;", "setAvatarKey", "(Ljava/lang/String;)V", "name", "getName", "setName", "senderType", "getSenderType", "setSenderType", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardSender implements NonProguard {
    public static final String CARD_SEND_TYPE_APP = "app";
    public static final a Companion = null;
    private String avatarKey;
    private String name;
    private String senderType;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CardSender() {
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSenderType() {
        return this.senderType;
    }

    public final void setAvatarKey(String r100) {
        this.avatarKey = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setSenderType(String r100) {
        this.senderType = r100;
    }
}
