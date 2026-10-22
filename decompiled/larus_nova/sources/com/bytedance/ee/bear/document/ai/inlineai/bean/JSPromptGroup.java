package com.bytedance.ee.bear.document.ai.inlineai.bean;

import com.alipay.sdk.m.x.d;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSPromptGroup;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "prompts", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSPrompt;", "Lkotlin/collections/ArrayList;", "getPrompts", "()Ljava/util/ArrayList;", "setPrompts", "(Ljava/util/ArrayList;)V", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JSPromptGroup implements NonProguard {
    private ArrayList<JSPrompt> prompts;
    private String title;

    public JSPromptGroup() {
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("PromptGroup(title=");
        r100.append(this.title);
        r100.append(", prompts size=");
        ArrayList<JSPrompt> r101 = this.prompts;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.size());
    L6:
        r100.append(r102);
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public final ArrayList<JSPrompt> getPrompts() {
        return this.prompts;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setPrompts(ArrayList<JSPrompt> r100) {
        this.prompts = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
