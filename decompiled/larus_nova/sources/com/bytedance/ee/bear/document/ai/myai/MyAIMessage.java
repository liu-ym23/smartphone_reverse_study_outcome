package com.bytedance.ee.bear.document.ai.myai;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u000bH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/myai/MyAIMessage;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "key", "Lcom/bytedance/ee/bear/document/ai/myai/ActionButton;", "getKey", "()Lcom/bytedance/ee/bear/document/ai/myai/ActionButton;", "setKey", "(Lcom/bytedance/ee/bear/document/ai/myai/ActionButton;)V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyAIMessage implements NonProguard {
    private String content;
    private ActionButton key;

    public MyAIMessage() {
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("ActionButtonContent(key=");
        r100.append(this.key);
        r100.append(", content=");
        String r101 = this.content;
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

    public final String getContent() {
        return this.content;
    }

    public final ActionButton getKey() {
        return this.key;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setKey(ActionButton r100) {
        this.key = r100;
    }
}
