package com.ss.android.lark.todo.impl.features.detail.create.richtext;

import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/create/richtext/CommonEntity;", "Ljava/io/Serializable;", RemoteMessageConst.MSGID, "", "chatId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getMsgId", "()Ljava/lang/String;", "setMsgId", "(Ljava/lang/String;)V", "getChatId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonEntity implements Serializable {
    private final String chatId;
    private String msgId;

    public static /* synthetic */ CommonEntity copy$default(CommonEntity r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.msgId;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.chatId;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.msgId;
    }

    public final String component2() {
        return this.chatId;
    }

    public final CommonEntity copy(String r100, String r101) {
        return new CommonEntity(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CommonEntity) == true) goto L8;
        return false;
    L8:
        CommonEntity r101 = (CommonEntity) r100;
        if (Intrinsics.areEqual(this.msgId, r101.msgId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.chatId, r101.chatId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.msgId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.chatId;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CommonEntity(msgId=" + this.msgId + ", chatId=" + this.chatId + ')';
    }

    public final String getChatId() {
        return this.chatId;
    }

    public final String getMsgId() {
        return this.msgId;
    }

    public final void setMsgId(String r100) {
        this.msgId = r100;
    }

    public CommonEntity(String r100, String r101) {
        this.msgId = r100;
        this.chatId = r101;
    }
}
