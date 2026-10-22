package com.ss.android.lark.chat.entity.message;

import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/MyAIThreadInfo;", "Ljava/io/Serializable;", "", "preview", "Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity;", "lastMessagePosition", "", "<init>", "(Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity;I)V", "getPreview", "()Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity;", "getLastMessagePosition", "()I", "clone", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyAIThreadInfo implements Serializable, Cloneable {
    private final int lastMessagePosition;
    private final UrlInlinePreviewEntity preview;

    public static /* synthetic */ MyAIThreadInfo copy$default(MyAIThreadInfo r100, UrlInlinePreviewEntity r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.preview;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.lastMessagePosition;
    L9:
        return r100.copy(r101, r102);
    }

    public final UrlInlinePreviewEntity component1() {
        return this.preview;
    }

    public final int component2() {
        return this.lastMessagePosition;
    }

    public final MyAIThreadInfo copy(UrlInlinePreviewEntity r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "preview");
        return new MyAIThreadInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MyAIThreadInfo) == true) goto L8;
        return false;
    L8:
        MyAIThreadInfo r101 = (MyAIThreadInfo) r100;
        if (Intrinsics.areEqual(this.preview, r101.preview) == true) goto L12;
        return false;
    L12:
        if (this.lastMessagePosition == r101.lastMessagePosition) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.preview.hashCode() * 31) + this.lastMessagePosition;
    }

    public String toString() {
        return "MyAIThreadInfo(preview=" + this.preview + ", lastMessagePosition=" + this.lastMessagePosition + ')';
    }

    public Object clone() {
        return super.clone();
    }

    public final int getLastMessagePosition() {
        return this.lastMessagePosition;
    }

    public final UrlInlinePreviewEntity getPreview() {
        return this.preview;
    }

    public MyAIThreadInfo(UrlInlinePreviewEntity r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "preview");
        this.preview = r100;
        this.lastMessagePosition = r101;
    }
}
