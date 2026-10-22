package com.ss.android.lark.chat.entity.chat;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatTnsSystemBannedInfo;", "Ljava/io/Serializable;", "isBanned", "", "expireAt", "", "appealUrl", "", "blockedFeatures", "", "Lcom/ss/android/lark/chat/entity/chat/ChatTnsBlockedFeature;", "isPermanent", "<init>", "(ZLjava/lang/Long;Ljava/lang/String;Ljava/util/List;Z)V", "()Z", "getExpireAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAppealUrl", "()Ljava/lang/String;", "getBlockedFeatures", "()Ljava/util/List;", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatTnsSystemBannedInfo implements Serializable {
    private final String appealUrl;
    private final List<ChatTnsBlockedFeature> blockedFeatures;
    private final Long expireAt;
    private final boolean isBanned;
    private final boolean isPermanent;

    public final String getAppealUrl() {
        return this.appealUrl;
    }

    public final List<ChatTnsBlockedFeature> getBlockedFeatures() {
        return this.blockedFeatures;
    }

    public final Long getExpireAt() {
        return this.expireAt;
    }

    public final boolean isBanned() {
        return this.isBanned;
    }

    public final boolean isPermanent() {
        return this.isPermanent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatTnsSystemBannedInfo(boolean r100, Long r101, String r102, List<? extends ChatTnsBlockedFeature> r103, boolean r104) {
        this.isBanned = r100;
        this.expireAt = r101;
        this.appealUrl = r102;
        this.blockedFeatures = r103;
        this.isPermanent = r104;
    }
}
