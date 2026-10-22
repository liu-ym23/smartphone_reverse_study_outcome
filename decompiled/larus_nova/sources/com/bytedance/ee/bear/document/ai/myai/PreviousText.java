package com.bytedance.ee.bear.document.ai.myai;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/myai/PreviousText;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "cursorPosition", "", "getCursorPosition", "()Ljava/lang/String;", "setCursorPosition", "(Ljava/lang/String;)V", "hasValueBeforeCursor", "", "getHasValueBeforeCursor", "()Ljava/lang/Boolean;", "setHasValueBeforeCursor", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "hasValueAfterCursor", "getHasValueAfterCursor", "setHasValueAfterCursor", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreviousText implements NonProguard {
    private String cursorPosition;
    private Boolean hasValueAfterCursor;
    private Boolean hasValueBeforeCursor;

    public PreviousText() {
    }

    public String toString() {
        return "PreviousText(cursorPosition=" + this.cursorPosition + ", hasValueBeforeCursor=" + this.hasValueBeforeCursor + ", hasValueAfterCursor=" + this.hasValueAfterCursor + ')';
    }

    public final String getCursorPosition() {
        return this.cursorPosition;
    }

    public final Boolean getHasValueAfterCursor() {
        return this.hasValueAfterCursor;
    }

    public final Boolean getHasValueBeforeCursor() {
        return this.hasValueBeforeCursor;
    }

    public final void setCursorPosition(String r100) {
        this.cursorPosition = r100;
    }

    public final void setHasValueAfterCursor(Boolean r100) {
        this.hasValueAfterCursor = r100;
    }

    public final void setHasValueBeforeCursor(Boolean r100) {
        this.hasValueBeforeCursor = r100;
    }
}
