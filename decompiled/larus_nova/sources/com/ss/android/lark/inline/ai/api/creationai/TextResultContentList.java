package com.ss.android.lark.inline.ai.api.creationai;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/creationai/TextResultContentList;", "Lcom/ss/android/lark/inline/ai/api/creationai/BaseTextContentList;", "Lcom/ss/android/lark/inline/ai/api/creationai/ParamResultDetail;", "displayContent", "", "<init>", "(Ljava/lang/String;)V", "getDisplayContent", "()Ljava/lang/String;", "setDisplayContent", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextResultContentList extends BaseTextContentList<ParamResultDetail> {
    private String displayContent;

    /* JADX WARN: Multi-variable type inference failed */
    public TextResultContentList() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final String getDisplayContent() {
        return this.displayContent;
    }

    public TextResultContentList(String r100) {
        this.displayContent = r100;
    }

    public final void setDisplayContent(String r100) {
        this.displayContent = r100;
    }

    public /* synthetic */ TextResultContentList(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = "";
    L5:
        this(r100);
    }
}
