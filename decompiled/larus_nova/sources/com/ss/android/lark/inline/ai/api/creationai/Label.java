package com.ss.android.lark.inline.ai.api.creationai;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/creationai/Label;", "Ljava/io/Serializable;", "<init>", "()V", "show", "", "getShow", "()Z", "setShow", "(Z)V", "data", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/inline/ai/api/creationai/MenuItem;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "toString", "", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Label implements Serializable {
    private ArrayList<MenuItem> data;
    private boolean show;

    public Label() {
    }

    public String toString() {
        return "Label(show=" + this.show + ", data=" + this.data + ')';
    }

    public final ArrayList<MenuItem> getData() {
        return this.data;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final void setData(ArrayList<MenuItem> r100) {
        this.data = r100;
    }

    public final void setShow(boolean r100) {
        this.show = r100;
    }
}
