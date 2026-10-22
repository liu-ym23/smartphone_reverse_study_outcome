package com.ss.android.lark.todo.impl.features.detail.create.richtext;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/create/richtext/MultiMessage;", "Ljava/io/Serializable;", "chatId", "", "messageIds", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getChatId", "()Ljava/lang/String;", "getMessageIds", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiMessage implements Serializable {
    private final String chatId;
    private final List<String> messageIds;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MultiMessage copy$default(MultiMessage r100, String r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.chatId;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.messageIds;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.chatId;
    }

    public final List<String> component2() {
        return this.messageIds;
    }

    public final MultiMessage copy(String r100, List<String> r101) {
        return new MultiMessage(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MultiMessage) == true) goto L8;
        return false;
    L8:
        MultiMessage r101 = (MultiMessage) r100;
        if (Intrinsics.areEqual(this.chatId, r101.chatId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.messageIds, r101.messageIds) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.chatId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.messageIds;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "MultiMessage(chatId=" + this.chatId + ", messageIds=" + this.messageIds + ')';
    }

    public final String getChatId() {
        return this.chatId;
    }

    public final List<String> getMessageIds() {
        return this.messageIds;
    }

    public MultiMessage(String r100, List<String> r101) {
        this.chatId = r100;
        this.messageIds = r101;
    }
}
