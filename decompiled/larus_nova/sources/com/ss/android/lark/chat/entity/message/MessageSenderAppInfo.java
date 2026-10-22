package com.ss.android.lark.chat.entity.message;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/MessageSenderAppInfo;", "Ljava/io/Serializable;", "isAgent", "", "avatarUrl", "", "<init>", "(ZLjava/lang/String;)V", "()Z", "getAvatarUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageSenderAppInfo implements Serializable {
    private final String avatarUrl;
    private final boolean isAgent;

    /* JADX WARN: Multi-variable type inference failed */
    public MessageSenderAppInfo() {
        boolean r100 = false;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ MessageSenderAppInfo copy$default(MessageSenderAppInfo r100, boolean r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.isAgent;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.avatarUrl;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.isAgent;
    }

    public final String component2() {
        return this.avatarUrl;
    }

    public final MessageSenderAppInfo copy(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "avatarUrl");
        return new MessageSenderAppInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MessageSenderAppInfo) == true) goto L8;
        return false;
    L8:
        MessageSenderAppInfo r101 = (MessageSenderAppInfo) r100;
        if (this.isAgent == r101.isAgent) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.avatarUrl, r101.avatarUrl) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.isAgent == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.avatarUrl.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public String toString() {
        return "MessageSenderAppInfo(isAgent=" + this.isAgent + ", avatarUrl=" + this.avatarUrl + ')';
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final boolean isAgent() {
        return this.isAgent;
    }

    public MessageSenderAppInfo(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "avatarUrl");
        this.isAgent = r100;
        this.avatarUrl = r101;
    }

    public /* synthetic */ MessageSenderAppInfo(boolean r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}
