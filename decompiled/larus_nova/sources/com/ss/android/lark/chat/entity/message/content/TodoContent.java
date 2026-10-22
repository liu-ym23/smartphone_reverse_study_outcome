package com.ss.android.lark.chat.entity.message.content;

import com.bytedance.lark.pb.basic.v1.TodoOperationContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/TodoContent;", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "<init>", "()V", "messageType", "Lcom/ss/android/lark/chat/entity/message/content/TodoContent$TodoMessageType;", "getMessageType", "()Lcom/ss/android/lark/chat/entity/message/content/TodoContent$TodoMessageType;", "setMessageType", "(Lcom/ss/android/lark/chat/entity/message/content/TodoContent$TodoMessageType;)V", "cardContentData", "Lcom/bytedance/lark/pb/basic/v1/TodoOperationContent;", "getCardContentData", "()Lcom/bytedance/lark/pb/basic/v1/TodoOperationContent;", "setCardContentData", "(Lcom/bytedance/lark/pb/basic/v1/TodoOperationContent;)V", "TodoMessageType", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TodoContent extends Content {
    private TodoOperationContent cardContentData;
    private TodoMessageType messageType;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/TodoContent$TodoMessageType;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "UNKNOWN", "TODO_MESSAGE_CARD", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TodoMessageType extends Enum<TodoMessageType> {
        public static final a Companion = null;
        public static final TodoMessageType TODO_MESSAGE_CARD = null;
        public static final TodoMessageType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TodoMessageType[] f415344a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f415345b = null;
        private final int number;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<TodoMessageType> getEntries() {
            return f415345b;
        }

        static {
            TodoMessageType r100 = new TodoMessageType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            TodoMessageType r101 = new TodoMessageType("TODO_MESSAGE_CARD", 1, 1);
            TODO_MESSAGE_CARD = r101;
            TodoMessageType[] r102 = {r100, r101};
            f415344a = r102;
            f415345b = EnumEntriesKt.enumEntries(r102);
            Companion = new a();
        }

        public static TodoMessageType[] values() {
            return (TodoMessageType[]) f415344a.clone();
        }

        public final int getNumber() {
            return this.number;
        }

        public static TodoMessageType valueOf(String r100) {
            return (TodoMessageType) r27.a.a(TodoMessageType.class, r100);
        }

        public TodoMessageType(String r100, int r101, int r102) {
            super(r100, r101);
            this.number = r102;
        }
    }

    public TodoContent() {
        this.messageType = TodoMessageType.UNKNOWN;
    }

    public final TodoOperationContent getCardContentData() {
        return this.cardContentData;
    }

    public final TodoMessageType getMessageType() {
        return this.messageType;
    }

    public final void setCardContentData(TodoOperationContent r100) {
        this.cardContentData = r100;
    }

    public final void setMessageType(TodoMessageType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.messageType = r100;
    }
}
