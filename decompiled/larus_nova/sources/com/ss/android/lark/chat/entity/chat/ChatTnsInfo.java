package com.ss.android.lark.chat.entity.chat;

import com.bytedance.lark.pb.basic.v1.TnsOpKind;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatTnsInfo;", "Ljava/io/Serializable;", "tnsOpKind", "Lcom/ss/android/lark/chat/entity/chat/ChatTnsOpKind;", "systemBannedInfo", "Lcom/ss/android/lark/chat/entity/chat/ChatTnsSystemBannedInfo;", "<init>", "(Lcom/ss/android/lark/chat/entity/chat/ChatTnsOpKind;Lcom/ss/android/lark/chat/entity/chat/ChatTnsSystemBannedInfo;)V", "getTnsOpKind", "()Lcom/ss/android/lark/chat/entity/chat/ChatTnsOpKind;", "getSystemBannedInfo", "()Lcom/ss/android/lark/chat/entity/chat/ChatTnsSystemBannedInfo;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatTnsInfo implements Serializable {
    public static final a Companion = null;
    private final ChatTnsSystemBannedInfo systemBannedInfo;
    private final ChatTnsOpKind tnsOpKind;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.chat.entity.chat.ChatTnsInfo$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C4856a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f415162a = null;

            static {
                int[] r100 = new int[TnsOpKind.values().length];
                r100[TnsOpKind.TNS_OP_NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[TnsOpKind.TNS_OP_BANNED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[TnsOpKind.TNS_OP_DISSOLVED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f415162a = r100;
            }
        }

        public a() {
        }

        public static ChatTnsOpKind a(TnsOpKind r100) {
            if (r100 != null) goto L4;
            int r101 = -1;
        L6:
            if (r101 == 1) goto L15;
            if (r101 == 2) goto L18;
            if (r101 == 3) goto L17;
            return ChatTnsOpKind.TNS_OP_NONE;
        L17:
            return ChatTnsOpKind.TNS_OP_DISSOLVED;
        L18:
            return ChatTnsOpKind.TNS_OP_BANNED;
        L15:
            return ChatTnsOpKind.TNS_OP_NONE;
        L4:
            r101 = C4856a.f415162a[r100.ordinal()];
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ ChatTnsInfo copy$default(ChatTnsInfo r100, ChatTnsOpKind r101, ChatTnsSystemBannedInfo r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.tnsOpKind;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.systemBannedInfo;
    L9:
        return r100.copy(r101, r102);
    }

    public final ChatTnsOpKind component1() {
        return this.tnsOpKind;
    }

    public final ChatTnsSystemBannedInfo component2() {
        return this.systemBannedInfo;
    }

    public final ChatTnsInfo copy(ChatTnsOpKind r100, ChatTnsSystemBannedInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "tnsOpKind");
        return new ChatTnsInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatTnsInfo) == true) goto L8;
        return false;
    L8:
        ChatTnsInfo r101 = (ChatTnsInfo) r100;
        if (this.tnsOpKind == r101.tnsOpKind) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.systemBannedInfo, r101.systemBannedInfo) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.tnsOpKind.hashCode() * 31;
        ChatTnsSystemBannedInfo r101 = this.systemBannedInfo;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "ChatTnsInfo(tnsOpKind=" + this.tnsOpKind + ", systemBannedInfo=" + this.systemBannedInfo + ')';
    }

    public final ChatTnsSystemBannedInfo getSystemBannedInfo() {
        return this.systemBannedInfo;
    }

    public final ChatTnsOpKind getTnsOpKind() {
        return this.tnsOpKind;
    }

    public ChatTnsInfo(ChatTnsOpKind r100, ChatTnsSystemBannedInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "tnsOpKind");
        this.tnsOpKind = r100;
        this.systemBannedInfo = r101;
    }
}
