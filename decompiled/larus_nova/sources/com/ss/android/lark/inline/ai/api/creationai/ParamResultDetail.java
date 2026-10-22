package com.ss.android.lark.inline.ai.api.creationai;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u00002\u00020\u0001B;\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/creationai/ParamResultDetail;", "Ljava/io/Serializable;", "key", "", "name", "placeHolder", "content", "originContent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getName", "setName", "getPlaceHolder", "setPlaceHolder", "getContent", "setContent", "getOriginContent", "setOriginContent", "toString", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ParamResultDetail implements Serializable {
    private String content;
    private String key;
    private String name;
    private String originContent;
    private String placeHolder;

    public String toString() {
        return "ParamResultDetail(key=" + this.key + ", name=" + this.name + ", content=" + this.content + ", originContent=" + this.originContent + ')';
    }

    public final String getContent() {
        return this.content;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOriginContent() {
        return this.originContent;
    }

    public final String getPlaceHolder() {
        return this.placeHolder;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setKey(String r100) {
        this.key = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setOriginContent(String r100) {
        this.originContent = r100;
    }

    public final void setPlaceHolder(String r100) {
        this.placeHolder = r100;
    }

    public ParamResultDetail(String r100, String r101, String r102, String r103, String r104) {
        this.key = r100;
        this.name = r101;
        this.placeHolder = r102;
        this.content = r103;
        this.originContent = r104;
    }
}
