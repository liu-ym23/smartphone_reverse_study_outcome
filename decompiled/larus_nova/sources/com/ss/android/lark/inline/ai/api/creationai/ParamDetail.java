package com.ss.android.lark.inline.ai.api.creationai;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/creationai/ParamDetail;", "Ljava/io/Serializable;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "name", "getName", "setName", "placeHolder", "getPlaceHolder", "setPlaceHolder", "content", "getContent", "setContent", "userInput", "getUserInput", "setUserInput", "toString", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ParamDetail implements Serializable {
    private String content;
    private String key;
    private String name;
    private String placeHolder;
    private String userInput;

    public String toString() {
        StringBuilder r100 = new StringBuilder("ParamDetail(key=");
        r100.append(this.key);
        r100.append(", name=");
        r100.append(this.name);
        r100.append(", placeHolder=");
        r100.append(this.placeHolder);
        r100.append(", content=");
        r100.append(this.content);
        r100.append(", userInput = ");
        String r101 = this.userInput;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.length());
    L6:
        r100.append(r102);
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public ParamDetail() {
        this.key = "";
        this.name = "";
        this.placeHolder = "";
        this.content = "";
        this.userInput = "";
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

    public final String getPlaceHolder() {
        return this.placeHolder;
    }

    public final String getUserInput() {
        return this.userInput;
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

    public final void setPlaceHolder(String r100) {
        this.placeHolder = r100;
    }

    public final void setUserInput(String r100) {
        this.userInput = r100;
    }
}
