package com.ss.android.lark.inline.ai.api.creationai;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/creationai/Title;", "Ljava/io/Serializable;", "<init>", "()V", "show", "", "getShow", "()Z", "setShow", "(Z)V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "toString", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Title implements Serializable {
    private boolean show;
    private String text;

    public String toString() {
        return "Title(show=" + this.show + ", text='" + this.text + "')";
    }

    public Title() {
        this.text = "";
    }

    public final boolean getShow() {
        return this.show;
    }

    public final String getText() {
        return this.text;
    }

    public final void setShow(boolean r100) {
        this.show = r100;
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.text = r100;
    }
}
