package com.bytedance.ee.bear.document.ai.inlineai.bean;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR.\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSPrompts;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "show", "", "getShow", "()Z", "setShow", "(Z)V", "overlap", "getOverlap", "setOverlap", "data", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSPromptGroup;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "toString", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JSPrompts implements NonProguard {
    private ArrayList<JSPromptGroup> data;
    private boolean overlap;
    private boolean show;

    public JSPrompts() {
    }

    public String toString() {
        return "Prompts(show=" + this.show + ", overlap=" + this.overlap + ", data=" + this.data + ')';
    }

    public final ArrayList<JSPromptGroup> getData() {
        return this.data;
    }

    public final boolean getOverlap() {
        return this.overlap;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final void setData(ArrayList<JSPromptGroup> r1) {
        this.data = r1;
    }

    public final void setOverlap(boolean r1) {
        this.overlap = r1;
    }

    public final void setShow(boolean r1) {
        this.show = r1;
    }
}
