package com.larksuite.component.card.protocol.data.options;

import com.google.gson.JsonObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/larksuite/component/card/protocol/data/options/OptionUser;", "Ljava/io/Serializable;", "userId", "", "content", "avatarKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "getContent", "setContent", "getAvatarKey", "setAvatarKey", "toJson", "Lcom/google/gson/JsonObject;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OptionUser implements Serializable {
    private String avatarKey;
    private String content;
    private String userId;

    public final JsonObject toJson() {
        JsonObject r100 = new JsonObject();
        r100.addProperty("content", this.content);
        r100.addProperty("id", this.userId);
        r100.addProperty("avatarKey", this.avatarKey);
        return r100;
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setAvatarKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.avatarKey = r100;
    }

    public final void setContent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.content = r100;
    }

    public final void setUserId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.userId = r100;
    }

    public OptionUser(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, "avatarKey");
        this.userId = r100;
        this.content = r101;
        this.avatarKey = r102;
    }
}
