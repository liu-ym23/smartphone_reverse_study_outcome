package com.bytedance.ee.bear.contract.setting;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0015\u0010\n\u001a\u0004\u0018\u00010\b*\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010\u000bR\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/contract/setting/DoubaoInputDocumentAccessConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "personalEnabled", "Lcom/google/gson/JsonElement;", "enterpriseEnabled", "isEnabled", "", "isEnterprise", "strictBoolean", "(Lcom/google/gson/JsonElement;)Ljava/lang/Boolean;", "features-feature-gating-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoInputDocumentAccessConfig implements NonProguard {

    @SerializedName("enterprise_enabled")
    private JsonElement enterpriseEnabled;

    @SerializedName("personal_enabled")
    private JsonElement personalEnabled;

    public DoubaoInputDocumentAccessConfig() {
    }

    private final Boolean strictBoolean(JsonElement r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.isJsonPrimitive() == true) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == true) goto L13;
        r100 = null;
    L13:
        if (r100 != null) goto L15;
        return null;
    L15:
        return Boolean.valueOf(r100.getAsBoolean());
    L7:
        if (r100.getAsJsonPrimitive().isBoolean() == false) goto L9;
        r101 = true;
        goto L10
    }

    public final boolean isEnabled(boolean r100) {
        if (r100 == false) goto L4;
        JsonElement r101 = this.enterpriseEnabled;
    L5:
        Boolean r102 = strictBoolean(r101);
        if (r102 != null) goto L10;
        return true;
    L10:
        return r102.booleanValue();
    L4:
        r101 = this.personalEnabled;
        goto L5
    }
}
