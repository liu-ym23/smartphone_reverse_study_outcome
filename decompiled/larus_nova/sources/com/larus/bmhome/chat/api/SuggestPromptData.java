package com.larus.bmhome.chat.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$GEO;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/api/SuggestPromptData;", "Ljava/io/Serializable;", "<init>", "()V", EnvConst$GEO.SG, "", "getSg", "()Ljava/lang/String;", "setSg", "(Ljava/lang/String;)V", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SuggestPromptData implements Serializable {

    /* JADX INFO: renamed from: sg, reason: collision with root package name */
    @SerializedName("content")
    private String f297180sg;

    public SuggestPromptData() {
    }

    public final String getSg() {
        return this.f297180sg;
    }

    public final void setSg(String r100) {
        this.f297180sg = r100;
    }
}
