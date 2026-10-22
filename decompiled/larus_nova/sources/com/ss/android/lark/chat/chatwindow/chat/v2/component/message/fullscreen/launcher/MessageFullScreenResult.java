package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher;

import android.os.Bundle;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/MessageFullScreenResult;", "Ljava/io/Serializable;", "requestCode", "", "replyData", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/ReplyData;", "<init>", "(ILcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/ReplyData;)V", "getRequestCode", "()I", "getReplyData", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/ReplyData;", "toBundle", "Landroid/os/Bundle;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageFullScreenResult implements Serializable {
    private final ReplyData replyData;
    private final int requestCode;

    public static /* synthetic */ MessageFullScreenResult copy$default(MessageFullScreenResult r100, int r101, ReplyData r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.requestCode;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.replyData;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.requestCode;
    }

    public final ReplyData component2() {
        return this.replyData;
    }

    public final MessageFullScreenResult copy(int r100, ReplyData r101) {
        Intrinsics.checkNotNullParameter(r101, "replyData");
        return new MessageFullScreenResult(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MessageFullScreenResult) == true) goto L8;
        return false;
    L8:
        MessageFullScreenResult r101 = (MessageFullScreenResult) r100;
        if (this.requestCode == r101.requestCode) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.replyData, r101.replyData) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.requestCode * 31) + this.replyData.hashCode();
    }

    public String toString() {
        return "MessageFullScreenResult(requestCode=" + this.requestCode + ", replyData=" + this.replyData + ')';
    }

    public final Bundle toBundle() {
        Bundle r100 = new Bundle();
        r100.putAll(this.replyData.toBundle());
        return r100;
    }

    public final ReplyData getReplyData() {
        return this.replyData;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    public MessageFullScreenResult(int r100, ReplyData r101) {
        Intrinsics.checkNotNullParameter(r101, "replyData");
        this.requestCode = r100;
        this.replyData = r101;
    }
}
