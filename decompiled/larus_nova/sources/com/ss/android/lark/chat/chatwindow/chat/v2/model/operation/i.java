package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class i implements Function1<f5b.b, f5b.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Chatter f414427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f414428b;

    @Override // kotlin.jvm.functions.Function1
    public final f5b.b invoke(f5b.b r100) {
        f5b.b r101 = r100;
        String r102 = null;
        if ((r101 instanceof MessageInfo) == false) goto L5;
        MessageInfo r103 = (MessageInfo) r101;
    L6:
        if (r103 != null) goto L8;
    L17:
        if (r101 == null) goto L19;
        ChatChatter r104 = r101.getMessageSender();
    L20:
        if (r104 == null) goto L33;
        if (r101 == null) goto L26;
        ChatChatter r105 = r101.getMessageSender();
        if (r105 == null) goto L26;
        r102 = r105.getId();
    L26:
        if (Intrinsics.areEqual(r102, this.f414427a.getId()) == false) goto L33;
        ChatChatter r106 = r101.getMessageSender();
        Chatter r107 = this.f414427a;
        if ((r107 instanceof ChatChatter) == true) goto L30;
    L32:
        Intrinsics.checkNotNull(r106);
        r106.setChatter(this.f414427a);
        goto L33
    L30:
        if (Intrinsics.areEqual(((ChatChatter) r107).getChatId(), this.f414428b) == false) goto L32;
        r101.setMessageSender((ChatChatter) this.f414427a);
    L33:
        return r101;
    L19:
        r104 = null;
        goto L20
    L8:
        if ((this.f414427a instanceof ChatChatter) == false) goto L17;
        List<MessageInfo> r108 = r103.getLatestRepliesInThread();
        if (r108 == null) goto L17;
        Iterator<T> r109 = r108.iterator();
    L13:
        if (r109.hasNext() == false) goto L17;
        MessageInfo r110 = (MessageInfo) r109.next();
        if (Intrinsics.areEqual(r110.getMessageSender().getId(), ((ChatChatter) this.f414427a).getId()) == false) goto L13;
        r110.setMessageSender((ChatChatter) this.f414427a);
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    public i(Chatter r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "chatter");
        Intrinsics.checkNotNullParameter(r101, "currentChatId");
        this.f414427a = r100;
        this.f414428b = r101;
    }
}
