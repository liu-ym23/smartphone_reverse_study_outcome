package com.ss.android.lark.widget.richtext;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/widget/richtext/RichTextExtraInfo;", "Ljava/io/Serializable;", "<init>", "()V", "lingoLocalExtraData", "Lcom/ss/android/lark/widget/richtext/LingoLocalExtraData;", "getLingoLocalExtraData", "()Lcom/ss/android/lark/widget/richtext/LingoLocalExtraData;", "setLingoLocalExtraData", "(Lcom/ss/android/lark/widget/richtext/LingoLocalExtraData;)V", "curChatId", "", "getCurChatId", "()Ljava/lang/String;", "setCurChatId", "(Ljava/lang/String;)V", "isPartialReplySelectTextEmpty", "", "()Ljava/lang/Boolean;", "setPartialReplySelectTextEmpty", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "equals", "other", "", "hashCode", "", "richtext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RichTextExtraInfo implements Serializable {
    private String curChatId;
    private Boolean isPartialReplySelectTextEmpty;
    private LingoLocalExtraData lingoLocalExtraData;

    public int hashCode() {
        LingoLocalExtraData r100 = this.lingoLocalExtraData;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.curChatId.hashCode()) * 31;
        Boolean r104 = this.isPartialReplySelectTextEmpty;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public RichTextExtraInfo() {
        this.curChatId = "";
        this.isPartialReplySelectTextEmpty = Boolean.FALSE;
    }

    public final String getCurChatId() {
        return this.curChatId;
    }

    public final LingoLocalExtraData getLingoLocalExtraData() {
        return this.lingoLocalExtraData;
    }

    public final Boolean isPartialReplySelectTextEmpty() {
        return this.isPartialReplySelectTextEmpty;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(RichTextExtraInfo.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.widget.richtext.RichTextExtraInfo");
        RichTextExtraInfo r102 = (RichTextExtraInfo) r100;
        if (Intrinsics.areEqual(this.lingoLocalExtraData, r102.lingoLocalExtraData) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.curChatId, r102.curChatId) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.isPartialReplySelectTextEmpty, r102.isPartialReplySelectTextEmpty) == true) goto L21;
        return false;
    L21:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void setCurChatId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.curChatId = r100;
    }

    public final void setLingoLocalExtraData(LingoLocalExtraData r100) {
        this.lingoLocalExtraData = r100;
    }

    public final void setPartialReplySelectTextEmpty(Boolean r100) {
        this.isPartialReplySelectTextEmpty = r100;
    }
}
