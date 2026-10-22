package com.ss.android.lark.intent.export.entity.input;

import com.ss.android.lark.intent.export.entity.output.SendMessage;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/OpenChatWithMessageInput;", "Lcom/ss/android/lark/intent/export/entity/input/IntentInput;", "Ljava/io/Serializable;", "sendMessage", "Lcom/ss/android/lark/intent/export/entity/output/SendMessage;", "sendChatInfo", "Lcom/ss/android/lark/intent/export/entity/input/SendChatInfo;", "<init>", "(Lcom/ss/android/lark/intent/export/entity/output/SendMessage;Lcom/ss/android/lark/intent/export/entity/input/SendChatInfo;)V", "getSendMessage", "()Lcom/ss/android/lark/intent/export/entity/output/SendMessage;", "getSendChatInfo", "()Lcom/ss/android/lark/intent/export/entity/input/SendChatInfo;", "toString", "", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenChatWithMessageInput extends IntentInput implements Serializable {
    private final SendChatInfo sendChatInfo;
    private final SendMessage sendMessage;

    public String toString() {
        return "OpenChatWithMessageInput(sendMessage=" + this.sendMessage + ", sendChatInfo=" + this.sendChatInfo + ')';
    }

    public final SendChatInfo getSendChatInfo() {
        return this.sendChatInfo;
    }

    public final SendMessage getSendMessage() {
        return this.sendMessage;
    }

    public OpenChatWithMessageInput(SendMessage r100, SendChatInfo r101) {
        super(IntentInput.IntentType.OPEN_CHAT_DETAIL);
        this.sendMessage = r100;
        this.sendChatInfo = r101;
    }

    public /* synthetic */ OpenChatWithMessageInput(SendMessage r100, SendChatInfo r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
