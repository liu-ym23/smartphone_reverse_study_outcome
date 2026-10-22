package com.larksuite.component.card.protocol.data.at;

import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.w;
import java.io.Serializable;
import java.util.Objects;
import ty7.a;

/* JADX INFO: loaded from: classes24.dex */
public class AtProperty implements Serializable {
    private String content;
    private boolean isAnonymous;
    private boolean isOutChatUser;
    private String originUserName;
    private String userId;

    public AtProperty() {
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.userId, this.content, Boolean.valueOf(this.isOutChatUser), Boolean.valueOf(this.isAnonymous)});
    }

    public String getAtContent() {
        String r100 = this.content;
        if (r100 != null) goto L6;
        return "@";
    L6:
        if (r100.startsWith("@") == false) goto L8;
        return r100;
    L8:
        return "@".concat(r100);
    }

    public String getContent() {
        String r100 = this.content;
        if (r100 == null) goto L9;
        if (r100.startsWith("@") == true) goto L9;
        return "@" + this.content;
    L9:
        return this.content;
    }

    public JsonObject toJson() {
        JsonObject r100 = new JsonObject();
        r100.addProperty("content", this.content);
        return r100;
    }

    public String getOriginUserName() {
        return this.originUserName;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    public boolean isOutChatUser() {
        return this.isOutChatUser;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (getClass() == r100.getClass()) goto L11;
        return false;
    L11:
        AtProperty r101 = (AtProperty) r100;
        if (this.isAnonymous == r101.isAnonymous) goto L24;
        return false;
    L24:
    L21:
        e = move-exception;
        e.printStackTrace();
        return false;
    L15:
        if (TextUtils.equals(this.userId, r101.userId) == false) goto L19;
        if (TextUtils.equals(getContent(), r101.getAtContent()) == false) goto L19;
        return true;
    L19:
        return false;
    }

    public void setAnonymous(boolean r100) {
        this.isAnonymous = r100;
    }

    public void setContent(String r100) {
        this.content = r100;
        String r101 = getAtContent();
        String r102 = a.a().getLoginUserId();
        if (TextUtils.isEmpty(r102) == false) goto L5;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == false) goto L15;
        this.content = w.b(r101) + "...";
        return;
    L15:
        return;
    L5:
        if (TextUtils.isEmpty(this.userId) == true) goto L11;
        if (TextUtils.equals(this.userId, r102) == false) goto L11;
        if (w.a(r101, r101.length()) <= 18) goto L11;
        r103 = true;
        goto L12
    }

    public void setOriginUserName(String r100) {
        this.originUserName = r100;
    }

    public void setOutChatUser(boolean r100) {
        this.isOutChatUser = r100;
    }

    public void setUserId(String r100) {
        this.userId = r100;
    }
}
