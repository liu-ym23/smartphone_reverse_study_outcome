package com.bytedance.ee.bear.document.ai.myai;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/myai/MyAIChatModeParams;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "base", "Lcom/bytedance/ee/bear/document/ai/myai/ChatModeBase;", "getBase", "()Lcom/bytedance/ee/bear/document/ai/myai/ChatModeBase;", "setBase", "(Lcom/bytedance/ee/bear/document/ai/myai/ChatModeBase;)V", "data", "Lcom/bytedance/ee/bear/document/ai/myai/ChatModeData;", "getData", "()Lcom/bytedance/ee/bear/document/ai/myai/ChatModeData;", "setData", "(Lcom/bytedance/ee/bear/document/ai/myai/ChatModeData;)V", "toString", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyAIChatModeParams implements NonProguard {
    private ChatModeBase base;
    private ChatModeData data;

    public MyAIChatModeParams() {
    }

    public String toString() {
        return "MyAIChatModeParams(base=" + this.base + ", data=" + this.data + ')';
    }

    public final ChatModeBase getBase() {
        return this.base;
    }

    public final ChatModeData getData() {
        return this.data;
    }

    public final void setBase(ChatModeBase r1) {
        this.base = r1;
    }

    public final void setData(ChatModeData r1) {
        this.data = r1;
    }
}
