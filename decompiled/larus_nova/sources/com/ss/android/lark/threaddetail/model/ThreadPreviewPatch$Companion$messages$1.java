package com.ss.android.lark.threaddetail.model;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.chat.entity.message.Message;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "message", "Lcom/ss/android/lark/chat/entity/message/Message;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/ss/android/lark/chat/entity/message/Message;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ThreadPreviewPatch$Companion$messages$1 extends Lambda implements Function1<Message, Boolean> {
    final /* synthetic */ ArrayList<Message> $result;
    final /* synthetic */ Set<Message> $seen;

    public ThreadPreviewPatch$Companion$messages$1(Set<Message> r100, ArrayList<Message> r101) {
        this.$seen = r100;
        this.$result = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(Message r100) {
        if (r100 == null) goto L7;
        if (this.$seen.add(r100) == false) goto L7;
        this.$result.add(r100);
    L7:
        return Boolean.FALSE;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Message r100) {
        return invoke2(r100);
    }
}
